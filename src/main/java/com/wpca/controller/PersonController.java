package com.wpca.controller;

import cn.hutool.core.lang.func.Func;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.dto.MyActDto;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.*;
import com.wpca.service.*;
import com.wpca.ultis.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    CoreActService coreActService;




    /**
     *
     * @methodName StringToLocalDateTime
     * @description   前端传入的格式为 2022-09-06T16:00:00.000Z

     * @param time
     * @return java.time.LocalDateTime
     * @CreateTime 20:08 2022/9/16
     * @UpdateTime 20:08 2022/9/16
     */

    private String StringToLocalDateTime(String time){
        time = time.substring(0,19);//2022-09-06T16:00:00
        time=time.replace('T',' ');//2022-09-06 16:00:00
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, pattern);
        return time;
    }

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

//    @GetMapping("/get/myApplyAct")
//    public Result getMyApplyAct(){
//        SysUser user = sysUserService.getByUsername(getUsername());
//        List<CoreAct> maps = coreActService.list(new QueryWrapper<CoreAct>()
//                .eq("user_id", user.getId())
//        );
//        return Result.succ(maps);
//    }

    /**
     * @methodName getMyCollectAct
     * @description 获得我收藏的活动
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:37 2022/9/11
     * @UpdateTime 21:37 2022/9/11
     */
    @GetMapping("/get/myCollectAct")
    public Result getMyCollectAct(String name, String start, String end){

        SysUser user = sysUserService.getByUsername(getUsername());

        List<ExpansionCollection> maps = expansionCollectionService.list(new QueryWrapper<ExpansionCollection>().
                eq("user_id", user.getId()));

        List<MyActDto> myActDtos =new ArrayList<MyActDto>();

        for( ExpansionCollection map:maps) {
            MyActDto act=new MyActDto();
            CoreAct coreAct = coreActService.getOne(new QueryWrapper<CoreAct>().
                    eq("id", map.getActId())
                             .like(StrUtil.isNotBlank(name),"act_name",name)
                            .eq("id", map.getActId())
                            .ge(StrUtil.isNotEmpty(start),"act_start_date",start)
                            .le(StrUtil.isNotEmpty(end),"act_start_date",end)

                    );
            if(coreAct ==null){
                continue;
            }
            act.setActId(map.getActId());
            act.setUserActCreateTime(map.getCollectionDate());
            act.setCoreAct(coreAct);
            myActDtos.add(act);
        }


        return Result.succ(myActDtos);

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
    public Result getMyJoinAct(String name, String start, String end){
        SysUser user = sysUserService.getByUsername(getUsername());


        if(StrUtil.isNotBlank(start)){
            start=StringToLocalDateTime(start);
        }
        if(StrUtil.isNotBlank(end)){
            end=StringToLocalDateTime(end);
        }



        List<CoreUserAct> maps = coreUserActService.list(
                new QueryWrapper<CoreUserAct>()
                .eq("user_id", user.getId())

        );

        List<MyActDto> myActDtos =new ArrayList<MyActDto>();
        //然后获取用户 参加的活动的信息，
        for(CoreUserAct map:maps) {
            MyActDto act=new MyActDto();
            CoreAct coreAct = coreActService.getOne(new QueryWrapper<CoreAct>()
                    .like(StrUtil.isNotBlank(name),"act_name",name)
                    .eq("id", map.getActId())
                    .ge(StrUtil.isNotEmpty(start),"act_start_date",start)
                    .le(StrUtil.isNotEmpty(end),"act_start_date",end)
            );
            if(coreAct ==null){
                continue;
            }
            System.out.println(map.getActId());
            act.setActId(map.getActId());
            act.setUserActCreateTime(map.getUserActCreateTime());
            act.setUserId(map.getUserId());
            act.setUserActReview(map.getUserActReview());
            act.setUserActStatu(map.getUserActStatu());
            act.setUserActReviewDate(map.getUserActReviewDate());
            act.setCoreAct(coreAct);

            myActDtos.add(act);
        }

        return Result.succ(myActDtos);

    }





    /********************************-----------POST-----------*****************************/

    /**
     *
     * @methodName addSignUpAct
     * @description 添加活动
     * @param json
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:24 2022/9/15
     * @UpdateTime 21:24 2022/9/15
     */

    @SneakyThrows
    @PostMapping("/post/addSignUpAct")
    public  Result addSignUpAct(@RequestBody String json){
        JSONObject JSON = new JSONObject(json);
        Long id =JSON.getLong("id");
        String username = getUsername();

        SysUser user = sysUserService.getByUsername(username);

        //获得用户活动表实体
        CoreUserAct userAct=new CoreUserAct();
        //设置活动id
        userAct.setActId(id);
        //设置用户id
        userAct.setUserId(user.getId());
        //设置报名时间
        userAct.setUserActCreateTime(LocalDateTime.now());
        //设置报名状态
        userAct.setUserActStatu(Const.USERACT_NotReview);

        coreUserActService.save(userAct);

        return Result.succ("报名成功");
    }

    /**
     *
     * @methodName addCollectedAct
     * @description 添加收藏
     * @param json
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:24 2022/9/15
     * @UpdateTime 21:24 2022/9/15
     */

    @SneakyThrows
    @PostMapping("/post/addCollectedAct")
    public  Result addCollectedAct(@RequestBody String json){

        System.out.println("json:"+json);
        JSONObject JSON = new JSONObject(json);
        Long id = JSON.getLong("id");
        String username = getUsername();

        SysUser user = sysUserService.getByUsername(username);

        //获得用户活动表实体
        ExpansionCollection collection=new ExpansionCollection();
        //设置活动id
        collection.setActId(id);
        //设置用户id
        collection.setUserId(user.getId());

        //设置日期
        collection.setCollectionDate(LocalDateTime.now());

        //保存
        expansionCollectionService.save(collection);

        return Result.succ("收藏成功");
    }

    /**
     *
     * @methodName cancelCollectedAct
     * @description 取消收藏
     * @param json
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:25 2022/9/15
     * @UpdateTime 21:25 2022/9/15
     */

    @SneakyThrows
    @PostMapping("/post/cancelCollectedAct")
    public  Result cancelCollectedAct(@RequestBody String json){
        JSONObject JSON = new JSONObject(json);
        Long id =JSON.getLong("id");


        String username = getUsername();

        SysUser user = sysUserService.getByUsername(username);

        expansionCollectionService.remove(new QueryWrapper<ExpansionCollection>().eq("user_id",user.getId()).eq("act_id",id)) ;

        return Result.succ("取消了收藏");
    }

    /**
     *
     * @methodName cancelSignUpAct
     * @description 取消报名
     * @param json
     * @return com.wpca.common.lang.Result
     * @CreateTime 21:25 2022/9/15
     * @UpdateTime 21:25 2022/9/15
     */

    @SneakyThrows
    @PostMapping("/post/cancelSignUpAct")
    public  Result cancelSignUpAct(@RequestBody String json){
        JSONObject JSON = new JSONObject(json);
        Long id =JSON.getLong("id");
        String username = getUsername();

        SysUser user = sysUserService.getByUsername(username);

        //保存
        coreUserActService.remove(new QueryWrapper<CoreUserAct>().eq("user_id",user.getId()).eq("act_id",id));

        return Result.succ("取消了报名");
    }




}
