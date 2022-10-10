package com.wpca.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.SysFile;
import com.wpca.service.SysFileService;
import lombok.SneakyThrows;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.FileController
 * @Date 2022年10月04日 19:18
 * @Description
 */

@RestController
@RequestMapping("/file")
public class FileController extends BaseController{


    @Autowired
    SysFileService sysFileService;

    private String fileUploadPath=System.getProperty("user.dir") + "/downloadPdfPath/";

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
//        String uuid = IdUtil.fastSimpleUUID();
//        String fileUUID=uuid+StrUtil.DOT+type;
        String fileUUID=originalFilename;

        //存储到磁盘
        File uploadParentFile = new File(fileUploadPath);

        //判断文件目录是否存在 不存在则创建目录
        if(!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }

        // 定义一个文件唯一的标识码
        //标识码
        File uploadFile = new File(fileUploadPath+fileUUID);

        String url;
        String md5 = SecureUtil.md5(file.getInputStream());
        // 从数据库查询是否存在相同的记录
        SysFile dbFiles = getFileByMd5(md5);
        if (dbFiles != null) {
            url = dbFiles.getUrl();
        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url= "http://localhost:18888/product/"+fileUUID;
        }


        //存储到数据库
        SysFile saveFiles = new SysFile();
        saveFiles.setName(originalFilename);
        saveFiles.setType(type);
        saveFiles.setSize(size);
        saveFiles.setUrl(url);
        saveFiles.setMd5(md5);
        sysFileService.save(saveFiles);

        return Result.succ(url);
    }

    @SneakyThrows
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) {
        //获取文件
        File uploadFile = new File(fileUploadPath+fileUUID);
        //设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");
        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();

    }

    private SysFile getFileByMd5(String md5){
        //查询文件md5是否存在

        List<SysFile> sysFile = sysFileService.list(new QueryWrapper<SysFile>().eq("md5", md5));


        return sysFile.size()==0?null:sysFile.get(0);

    }



    //    @CachePut(value = "files", key = "'frontAll'")
    @PostMapping("/update")
    public Result update(@RequestBody SysFile files) {
        sysFileService.updateById(files);
        flushRedis(Const.FILES_KEY);
        return Result.succ("");
    }

    @GetMapping("/detail/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.succ(sysFileService.getById(id));
    }

    //清除一条缓存，key为要清空的数据
//    @CacheEvict(value="files",key="'frontAll'")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        SysFile files = sysFileService.getById(id);
        files.setIsDelete(true);
        sysFileService.updateById(files);
        flushRedis(Const.FILES_KEY);
        return Result.succ("");
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // select * from sys_file where id in (id,id,id...)
        QueryWrapper<SysFile> queryWrapper = new QueryWrapper<SysFile>();
        queryWrapper.in("id", ids);
        List<SysFile> files = sysFileService.list(queryWrapper);
        for (SysFile file : files) {
            file.setIsDelete(true);
            sysFileService.updateById(file);
        }
        return Result.succ("");
    }

    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name) {

        QueryWrapper<SysFile> queryWrapper = new QueryWrapper<>();
        // 查询未删除的记录
        queryWrapper.eq("is_delete", false);
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        return Result.succ(sysFileService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    // 设置缓存
    private void setCache(String key, String value) {
        redisUtil.set(key, value);
    }

    // 删除缓存
    private void flushRedis(String key) {
        redisUtil.del(key);
    }


}
