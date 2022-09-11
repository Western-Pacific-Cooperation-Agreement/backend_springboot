package com.wpca.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.sun.xml.txw2.output.ResultFactory;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreUserAct;
import com.wpca.entity.ExpansionCollection;
import com.wpca.entity.SysUser;
import com.wpca.service.CoreUserActService;
import com.wpca.service.ExpansionCollectionService;
import com.wpca.service.SysRoleService;
import com.wpca.service.SysUserService;
import com.wpca.ultis.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.PersonController
 * @Date 2022年09月11日 10:22
 * @Description
 */

@RequestMapping("/person")
@RestController
public class PersonController extends BaseController{

    @Autowired
    SysUserService sysUserService;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    SysRoleService sysRoleService;


    @Autowired
    CoreUserActService coreUserActService;


    @Autowired
    ExpansionCollectionService expansionCollectionService;


/**
 *
 * @methodName getUsername
 * @description 获得用户名
 * @return java.lang.String
 * @CreateTime 17:27 2022/9/11
 * @UpdateTime 17:27 2022/9/11
 */

private String getUsername(){
        String jwt = req.getHeader("Authorization");
        Claims claim = jwtUtils.getClaimByToken(jwt);
        String username = claim.getSubject();
        return username;
    }

    /**
     *
     * @methodName getUserInfo
     * @description 获得当前用户信息
     * @return com.wpca.common.lang.Result
     * @CreateTime 17:27 2022/9/11
     * @UpdateTime 17:27 2022/9/11
     */

    @GetMapping("/get/userInfo")
    public Result getUserInfo(){
        SysUser user = sysUserService.getByUsername(getUsername());
        user.setRoles(sysRoleService.listRolesByUserId(user.getId()));
        return Result.succ(user);
    }

    /**
     *
     * @methodName updateUserInfo
     * @description 修改个人信息
     * @param sysUser
     * @return com.wpca.common.lang.Result
     * @CreateTime 17:27 2022/9/11
     * @UpdateTime 17:27 2022/9/11
     */

    @PostMapping("/post/updateUserInfo")
    public Result updateUserInfo(@RequestBody  SysUser sysUser){
        sysUserService.updateById(sysUser);
        return Result.succ("更新成功");
    }

    /**
     *
     * @methodName updateAvater
     * @description 更新头像
     * @param sysUser
     * @return com.wpca.common.lang.Result
     * @CreateTime 17:56 2022/9/11
     * @UpdateTime 17:56 2022/9/11
     */


    @PostMapping("/post/uploadAvatar")
    public Result uploadAvatar( MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request,
                               @RequestBody SysUser sysUser
                               ) throws IOException {



        //得到文件map对象
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();

        //得到图片file
        MultipartFile file = files.get("avatar");
        //获得项目绝对路径的static/headImage/id/ 的位置
        String path = ResourceUtils.getURL("classpath:").getPath() + "static/headImage/users/"+sysUser.getId()+"/";
        //获得项目的根路径+/headImage/  即/headImage/
        String url = request.getContextPath() + "/headImage/users/"+sysUser.getId()+"/";
        //创建一个文件
        File filePath = new File(path);

        System.out.println("文件的保存路径：" + path);

        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，建立目录:" + filePath);
            filePath.mkdirs(); // mkdir()不会建立目录,找不到相应路径时返回false;而mkdirs()当目录不存在时则会建立相应目录
        }
        //获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();

        //获取文件类型，以最后一个`.`为标识 png
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

        // 新文件名，这里能够根据须要更名
        String fileName = sysUser.getId()+"_"+ new Random().nextInt(100000)+ "."+ type;
        //在指定路径下建立一个文件
        File targetFile = new File(path, fileName); // 未使用outputStream.write()的时候,是一个File对象,保存在内存中,硬盘中看不到,可是可使用这个对象
        try {
        // 使用springmvc的transferTo方法上传文件
            file.transferTo(targetFile);
        //http://192.168.220.1:8080 +
            String HostAndPortUrl=request.getRequestURI();
            //获取该项目的主机和端口号 192.168.220.1:8080 +/headImage/学号/+图片名
            String img=HostAndPortUrl+ url + fileName;

            System.out.println(img);


            sysUser.setAvatar("img");

            sysUserService.updateById(sysUser);


            return  Result.succ(sysUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail(400,"头像上传到本地失败",null);
    }


    /**
     *
     * @methodName getMyApplyAct
     * @description 获得我申请的活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:37 2022/9/11
     * @UpdateTime 21:37 2022/9/11
     */

    @GetMapping("/get/myApplyAct")
    public Result getMyApplyAct(){

        SysUser user = sysUserService.getByUsername(getUsername());
        return Result.succ(coreUserActService.getMap(
                new QueryWrapper<CoreUserAct>().
                        eq("user_id",user.getId())
        ));

    }

    /**
     * @methodName getMyCollectAct
     * @description 获得我收藏的活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:37 2022/9/11
     * @UpdateTime 21:37 2022/9/11
     */
    @GetMapping("/get/myCollectAct")
    public Result getMyCollectAct(){

        SysUser user = sysUserService.getByUsername(getUsername());
        return Result.succ(
                expansionCollectionService.getMap(
                        new QueryWrapper<ExpansionCollection>()
                                .eq("user_id",user.getId())

        ));

    }

    /**
     *
     * @methodName getMyJoinAct
     * @description 获得我报名参加的活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:37 2022/9/11
     * @UpdateTime 21:37 2022/9/11
     */
    @GetMapping("/get/myJoinAct")
    public Result getMyJoinAct(){
        SysUser user = sysUserService.getByUsername(getUsername());
        Map<String, Object> map = coreUserActService.getMap(
                new QueryWrapper<CoreUserAct>().
                        eq("user_id", user.getId()).
                        eq("act_id", user.getId())
        );


        return Result.succ("");
    }




}
