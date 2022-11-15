package com.wpca.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.SysBackup;
import com.wpca.entity.SysFile;
import com.wpca.service.SysBackupService;
import javafx.animation.Timeline;
import lombok.SneakyThrows;
import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static cn.hutool.core.swing.RobotUtil.click;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-10-09
 */
@RestController
@RequestMapping("/backup")
//@Configuration
//@EnableScheduling
public class SysBackupController extends BaseController
//        implements SchedulingConfigurer

{

    @Autowired
    SysBackupService sysBackupService;

    private String fileUploadPath=System.getProperty("user.dir") + "/downloadPdfPath/backup/";

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
        SysBackup dbFiles = getFileByMd5(md5);
        if (dbFiles != null) {
            url = dbFiles.getUrl();
        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url= "http://localhost:18888/product/backup/"+fileUUID;
        }


        //存储到数据库
        SysBackup saveFiles = new SysBackup();
        saveFiles.setName(originalFilename);
        saveFiles.setType(type);
        saveFiles.setSize(size);
        saveFiles.setUrl(url);
        saveFiles.setMd5(md5);
        sysBackupService.save(saveFiles);

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

    private SysBackup getFileByMd5(String md5){
        //查询文件md5是否存在

        List<SysBackup> sysFile = sysBackupService.list(new QueryWrapper<SysBackup>().eq("md5", md5));


        return sysFile.size()==0?null:sysFile.get(0);

    }



    //    @CachePut(value = "files", key = "'frontAll'")
    @PostMapping("/update")
    public Result update(@RequestBody SysBackup files) {
        sysBackupService.updateById(files);
        flushRedis(Const.FILES_KEY);
        return Result.succ("");
    }

    @GetMapping("/detail/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.succ(sysBackupService.getById(id));
    }

    //清除一条缓存，key为要清空的数据
//    @CacheEvict(value="files",key="'frontAll'")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        SysBackup files = sysBackupService.getById(id);
        files.setIsDelete(true);
        sysBackupService.updateById(files);
        flushRedis(Const.FILES_KEY);
        return Result.succ("");
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // select * from sys_file where id in (id,id,id...)
        QueryWrapper<SysBackup> queryWrapper = new QueryWrapper<SysBackup>();
        queryWrapper.in("id", ids);
        List<SysBackup> files = sysBackupService.list(queryWrapper);
        for (SysBackup file : files) {
            file.setIsDelete(true);
            sysBackupService.updateById(file);
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

        QueryWrapper<SysBackup> queryWrapper = new QueryWrapper<>();
        // 查询未删除的记录
        queryWrapper.eq("is_delete", false);
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        return Result.succ(sysBackupService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    //获得备份时间
    @GetMapping("/getBackupTime")
    public Result getBackupTime() {
        Long timeLong;
        Long time1 = (Long) redisUtil.get("BackupTime"+getUsername());
        if(time1==null){
            redisUtil.set("TIME"+getUsername(), 1000000,1000000);
            return Result.succ(1000000);
        }
        return Result.succ(""+time1);
    }
    //设置备份时间
    @PostMapping("/setBackupTime/{time}")
    public Result setBackupTime(@PathVariable String time) {
        Long timeLong=Long.parseLong(time);
        System.out.println(time);
        //设置备份时间
        redisUtil.set("BackupTime"+getUsername(),timeLong);
        //设置当先剩余时间位备份时间 进行重置
        redisUtil.set("TIME"+getUsername(), timeLong,timeLong);

        return Result.succ("");
    }

    //查看过期时间（倒计时）
    @GetMapping("/getTime")
    public Result getTime() {

        Long timeLong;

        Long time1 = (Long) redisUtil.getExpire("TIME"+getUsername());

        //如果时间小于0或是没有时间  就设置一个默认的时间  防止前端重复备份
        if(time1<=0||time1==null){
            Result.succ("100000000");
        }

        return Result.succ(time1);
    }


    // 设置缓存
    private void setCache(String key, String value) {
        redisUtil.set(key, value);
    }

    // 删除缓存
    private void flushRedis(String key) {
        redisUtil.del(key);
    }


    /**
     * 数据库文件备份
     */
    @RequestMapping("/doBackup")
    public Result doBackup(){
        System.out.println("现在时间是"+new Date());
        Runtime runtime = Runtime.getRuntime();  //获取Runtime实例
        String database1 = "managestage"; // 需要备份的数据库名
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String sdfDate = sdf.format(currentDate);

        String filepath = fileUploadPath+"time_" + sdfDate + ".sql"; // 备份的路径地址
        //执行命令（此处需要定位到mysqldump.exe路径，--default-character-set=gbk是为了解决中文乱码问题）
        String stmt = " D:\\MySQL-Common\\mysql-8.0.29-winx64\\bin\\mysqldump -h localhost -uroot -p111111 --default-character-set=utf8 "+database1+" > "+filepath;
        System.out.println(stmt);
        try {
            String[] command = { "cmd", "/c", stmt};
            Process process = runtime.exec(command);
            InputStream input = process.getInputStream();
            System.out.println(IOUtils.toString(input, "UTF-8"));
            //若有错误信息则输出
            InputStream errorStream = process.getErrorStream();
            System.out.println(IOUtils.toString(errorStream, "utf-8"));

            //保存备份数据信息到数据库中
            SysBackup sqlFileEntity = new SysBackup();
            sqlFileEntity.setName("time_" + sdfDate + ".sql");
            sqlFileEntity.setType("sql");
            sqlFileEntity.setCreateTime(LocalDateTime.now());
            sqlFileEntity.setUrl("http://localhost:18888/product/backup/"+"time_" + sdfDate + ".sql");

            sysBackupService.save(sqlFileEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Result.succ("");
    }


    /**
     * 还原数据库
     */
    @RequestMapping("/restore")
    public Result restore(@RequestBody String filename) {
        String database = "managestage"; // 需要备份的数据库名
        System.out.println("现在时间是" + new Date());
        Runtime runtime = Runtime.getRuntime();
        try {
            String filePath =  fileUploadPath+filename; // sql文件路径
            String stmt = "mysql -h localhost -uroot -p111111 "+database+"< " + filePath;
            System.out.println(stmt);
            String[] command = {"cmd", "/c", stmt};
            Process process = runtime.exec(command);
            //若有错误信息则输出
            InputStream errorStream = process.getErrorStream();
            System.out.println(IOUtils.toString(errorStream, "gbk"));
            //等待操作
            int processComplete = process.waitFor();
            if (processComplete == 0) {
                System.out.println("还原成功.");
            } else {
                throw new RuntimeException("还原数据库失败.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return Result.succ("");

    }




//    /**
//     * 执行定时任务.
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//
//        taskRegistrar.addTriggerTask(
//                //1.添加任务内容(Runnable)
////                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
//                () -> click(),
//                //2.设置执行周期(Trigger)
//                triggerContext -> {
//                    //2.1 从数据库获取执行周期
////                    BackupConfig backupConfig = backupConfigMapper.selectById(1);
////                   String cron = backupConfig.getCron();
//                    String cron = (String) redisUtil.get("BackupTime"+getUsername());
//                    System.out.println(cron);
//                    //2.2 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                        doBackup();
//                    }
//                    //2.3 返回执行周期(Date)
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }


}
