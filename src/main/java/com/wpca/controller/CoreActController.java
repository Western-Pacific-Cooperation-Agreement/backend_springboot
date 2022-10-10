package com.wpca.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.*;
import com.wpca.mapper.CoreActMapper;
import com.wpca.mapper.SysRoleMapper;
import com.wpca.mapper.SysUserMapper;
import com.wpca.mapper.SysUserRoleMapper;
import com.wpca.service.*;
import com.wpca.ultis.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.CoreActController
 * @Date 2022年09月06日 12:56
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("/act")
public class CoreActController extends BaseController{


    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CoreActService coreActService;

    @Autowired
    CoreUserActService coreUserActService;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    ExpansionCollectionService expansionCollectionService;


    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    CoreObjectService coreObjectService;

    @Autowired
    CoreAssoService coreAssoService;

    @Autowired
    CoreActNatureService coreActNatureService;

    @Autowired
    CoreActMapper coreActMapper;

    /********************************-----------私有方法-----------*****************************/
   public String getUsername(){
        //获得用户的jwt
        String jwt = req.getHeader("Authorization");

        //将jwb进行解密
        Claims claims = jwtUtils.getClaimByToken(jwt);

        //通过claim获得username
        String username = claims.getSubject();

        return  username;
    }


    /********************************-----------GET-----------*****************************/
    /**
     *
     * @methodName getActInfo
     * @description 通过id获取对应活动的详情信息
     * @param actId
     * @return com.wpca.common.lang.Result
     * @CreateTime 12:05 2022/9/10
     * @UpdateTime 12:05 2022/9/10
     */

    @GetMapping("/get/activityInfo/{actId}")
    public Result getActivityInfo(@PathVariable("actId")Long actId){
        CoreAct act = coreActService.getById(actId);
        if(actId==null||act==null){
            return Result.fail("活动可能被删除了，请返回活动列表");
        }
        return Result.succ(act);
    }

    /**
     *
     * @methodName getUserAppliedInfo
     * @description 获得用户的是否报名状态
     * @return com.wpca.common.lang.Result
     * @CreateTime 15:27 2022/9/10
     * @UpdateTime 15:27 2022/9/10
     */
    @GetMapping("/get/userApplied/{id}")
    public  Result getUserApplied(@PathVariable Long id){

        String username = getUsername();

        //获得用户
        SysUser user = sysUserService.getByUsername(username);

        //查询用户对应的id是否有报名参加该项活动
        CoreUserAct applied= coreUserActService.getOne(new QueryWrapper<CoreUserAct>().eq("act_id",id).eq("user_id",user.getId()));

        //如果没有
        if(applied==null) {
            return Result.succ(
                    MapUtil.builder()
                            .put("applied",false)
                            .map()
            );
        }
        else{
            return Result.succ(
                    MapUtil.builder()
                            .put("applied",true)
                            .map()

            );
        }
    }

    /**
     *
     * @methodName getUserCollected
     * @description 获得用户收藏的信息
     * @param id
     * @return com.wpca.common.lang.Result
     * @CreateTime 18:15 2022/9/10
     * @UpdateTime 18:15 2022/9/10
     */

    @GetMapping("/get/userCollected/{id}")
    public  Result getUserCollected(@PathVariable Long id) {

        //通过claim获得username
        String username = getUsername();
        //获得用户
        SysUser user = sysUserService.getByUsername(username);

        ExpansionCollection collected = expansionCollectionService.
                getOne(new QueryWrapper<ExpansionCollection>().eq("act_id",id).eq("user_id",user.getId()));


        if(collected==null) {
            return Result.succ(
                    MapUtil.builder()
                            .put("collected",false)
                            .map()

            );
        }
        else{
            return Result.succ(
                    MapUtil.builder()
                            .put("collected",true)
                            .map()

            );
        }
    }

    /**
     *
     * @methodName getUserInfo
     * @description
     * @return com.wpca.common.lang.Result
     * @CreateTime 18:16 2022/9/10
     * @UpdateTime 18:16 2022/9/10
     */

    @GetMapping("/get/userInfo")
    public Result getUserInfo(){

        String username = getUsername();
        SysUser user = sysUserService.getByUsername(username);
        List<SysRole> roles = sysRoleService.listRolesByUserId(user.getId());
        user.setRoles(roles);

        return Result.succ(user);
    }

    /**
     *
     * @methodName getRoleInfo
     * @description
     * @return com.wpca.common.lang.Result
     * @CreateTime 18:16 2022/9/10
     * @UpdateTime 18:16 2022/9/10
     */

    @GetMapping("/get/roleInfo")
    public Result getRoleInfo(){
        return Result.succ(sysRoleService.list());
    }

    /**
     *
     * @methodName getActObject
     * @description 获得活动对象
     * @return com.wpca.common.lang.Result
     * @CreateTime 8:17 2022/9/11
     * @UpdateTime 8:17 2022/9/11
     */

    @GetMapping("/get/actObject")
    public Result getActObject(){

        return Result.succ(coreObjectService.list());

    }


    /**
     *
     * @methodName getActAsso
     * @description 活动活动部门
     * @return com.wpca.common.lang.Result
     * @CreateTime 8:18 2022/9/11
     * @UpdateTime 8:18 2022/9/11
     */

    @GetMapping("/get/actAsso")
    public Result getActAsso(){
        return Result.succ(coreAssoService.list());
    }

        /**
         *
         * @methodName getActUser
         * @description 获得负责人个人信息
         * @param id
         * @return com.wpca.common.lang.Result
         * @CreateTime 9:58 2022/9/11
         * @UpdateTime 9:58 2022/9/11
         */

        @GetMapping("/get/actUser/{id}")
    public  Result getActUser(@PathVariable Long id){
        SysUser user = sysUserService.getById(id);

        return Result.succ(user);
    }

        /**
         * @methodName getActType
         * @description 获得活动类型
         * @return com.wpca.common.lang.Result
         * @CreateTime 9:58 2022/9/11
         * @UpdateTime 9:58 2022/9/11
         */

    @GetMapping("/get/actType")
    public Result getActType(){
        return Result.succ(coreActNatureService.list());
    }

    @GetMapping("/get/DefultList")
    public Result getDefultList(){
        return Result.succ(coreActService.list());
    }

    @GetMapping("/get/SearchList")
    public Result getSearchList(String   name,
                                String   place,
                                String   start,
                                String   end,
                                String   interal,
                                String   object,
                                String   number,
                                String   asso,
                                String  nature){


        long parseLong=0L;
        int objectInt=0,numberInt=0,assoInt=0,natureInt=0;

        if (StrUtil.isNotEmpty(interal)){
            parseLong = Long.parseLong(interal);
        }
        if (StrUtil.isNotEmpty(object)){
            objectInt = Integer.parseInt(object);
        }
        if (StrUtil.isNotEmpty(number)){
            numberInt=Integer.parseInt(number);
        } if (StrUtil.isNotEmpty(asso)){
            assoInt=Integer.parseInt(asso);
        }
        if (StrUtil.isNotEmpty(nature)){
            natureInt=Integer.parseInt(nature);
        }


        List<CoreAct> list = coreActService.list(

                new QueryWrapper<CoreAct>()
                        .like(StrUtil.isNotBlank(name),"act_name",name)
                        .like(StrUtil.isNotBlank(name),"act_place",place)

                        .ge(StrUtil.isNotEmpty(start),"act_start_date",start)
                        .le(StrUtil.isNotEmpty(end),"act_start_date",end)
                        .eq(StrUtil.isNotEmpty(interal),"act_integral",parseLong)
                        .eq(StrUtil.isNotEmpty(object),"act_object_id",objectInt)
                        .eq(StrUtil.isNotEmpty(number),"act_number",numberInt)
                        .eq(StrUtil.isNotEmpty(asso),"asso_id",assoInt)
                        .eq(StrUtil.isNotEmpty(nature),"act_nature_id",natureInt)

        );
        return Result.succ(list);
    }

    @SneakyThrows
    @PostMapping("/get/SearchListBySQL")
    public Result getSearchListBySQL(@RequestBody String json){

        JSONObject JSON = new JSONObject(json);
        String sql = JSON.getString("sql");
        System.out.println(sql);
        List<CoreAct> actBySql;
        try {
         actBySql = coreActMapper.getActBySql(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("检索表达式错误");
        }

        return Result.succ(actBySql);
    }
    @SneakyThrows
    @PostMapping("/get/SearchListBySimpleSQL")
    public Result getSearchListBySimpleSQL(@RequestBody String json){

        JSONObject JSON = new JSONObject(json);
        String sql = JSON.getString("ssql");
        System.out.println(sql);
        sql=simpleSqlToSql(sql);
        List<CoreAct> actBySql;
        try {
            actBySql = coreActMapper.getActBySql(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("检索表达式错误");
        }

        return Result.succ(actBySql);
    }

    /**
     *
     * @methodName simpleSqlToSql
     * @description 转换检索表达式（类检索表达式）到SQL表达式
     * @param ssql
     * @return java.lang.String
     * @CreateTime 8:25 2022/10/8
     * @UpdateTime 8:25 2022/10/8
     */

    public String simpleSqlToSql( String ssql) {
        System.out.println("*********************** => 查询算法 <=   **********************");
        ssql=chage(ssql);
        ssql=ssql.replaceAll("%"," like ");
        System.out.println("进行模糊查询算法");
        StringBuffer sql= new StringBuffer(ssql);
        int ptr=0;//完成的下标
        int idx;
        while((idx=sql.indexOf("like",ptr))!=-1){
            int first=sql.indexOf("\'",idx);
            sql.insert(first+1,'%');
            ptr=first+1;
            for(int i=ptr+1;i<sql.length();i++){
                char[] tmp=new char[2];
                sql.getChars(i,i+1,tmp,0);
                if(tmp[0]=='\''){
                        System.out.println(i+" :  "+sql.toString());
                        sql.insert(i,'%');
                        i++;
                        ptr=i+1;
                        break;
                }
//                sql.insert(i,'%');
//                i++;
            }
        }
        String result= new String(sql);
        result=result.replaceAll("#","%");
        System.out.println("算法替代结果："+result);
        result=result.replaceAll("%%","%");
        System.out.println("算法优化结果："+result);
        System.out.println("*********************** => 查询算法END <=   **********************");

        return result;
    }
    public String chage( String ssql) {
        System.out.println("进行模糊匹配算法");
        ssql=ssql.replaceAll("#"," like ");
        StringBuffer sql= new StringBuffer(ssql);
        int ptr=0;//完成的下标
        int idx;
        while((idx=sql.indexOf("like",ptr))!=-1){
            int first=sql.indexOf("\'",idx);
            sql.insert(first+1,'#');
            ptr=first+1;
            for(int i=ptr+2;i<sql.length();i++){
                char[] tmp=new char[2];
                sql.getChars(i,i+1,tmp,0);
                if(tmp[0]=='\''){
                    System.out.println(i+" :  "+sql.toString());
                    sql.insert(i,'#');
                    i++;
                    ptr=i+1;
                    break;
                }
                sql.insert(i,'#');
                i++;
                ptr++;
            }
        }

        System.out.println(new String(sql));
        return new String(sql);
    }
    /**
     *
     * @methodName info
     * @description 通过id填充表格
     * @param id
     * @return com.wpca.common.lang.Result
     * @CreateTime 17:17 2022/9/23
     * @UpdateTime 17:17 2022/9/23
     */

    @GetMapping("/get/info/{id}")
    public Result info(@PathVariable("id") Long id) {

        CoreAct act = coreActService.getById(id);

        return Result.succ(act);
    }


    private String fileUploadPath=System.getProperty("user.dir") + "/downloadPdfPath/act/";

    /********************************-----------POST-----------*****************************/


    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
       String uuid = IdUtil.fastSimpleUUID();
       String fileUUID=uuid+StrUtil.DOT+type;

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

            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url= "http://localhost:18888/product/act/"+fileUUID;

        return Result.succ(url);
    }

    @PostMapping("/post/saveApply")
    public Result saveApply(@Validated @RequestBody CoreAct act)  {

        act.setActApplyDate(LocalDateTime.now());
        act.setUserId(sysUserService.getByUsername(getUsername()).getId());
        coreActService.save(act);
        return Result.succ(act);
    }

    @PostMapping("/post/updateApply")
    public Result update(@Validated @RequestBody CoreAct act) throws IOException {


        act.setActApplyDate(LocalDateTime.now());
             //更新后需要重新审核
        act.setActReviewerId(null);
       act.setActReply("重新审核中，请等待。");
        act.setActReviewerStaus(Const.ACT_NotReview);

        coreActService.updateById(act);

        return Result.succ(act);
    }

    @PostMapping("/post/deleteApply")
    @Transactional
    public Result info(@RequestBody Long[] ids) {

        coreActService.removeByIds(Arrays.asList(ids));


        return Result.succ("删除成功");
    }
    /**
     *
     * @methodName endAct
     * @description 结束活动
     * @param id
     * @return com.wpca.common.lang.Result
     * @CreateTime 11:30 2022/9/25
     * @UpdateTime 11:30 2022/9/25
     */
    @PostMapping("/post/endAct")
    @Transactional
    public Result endAct(@RequestBody Long id) {

        CoreAct act = coreActService.getOne(new QueryWrapper<CoreAct>().eq("id", id));

        act.setActReviewerStaus(Const.ACT_Save);

        return Result.succ("结束活动");
    }

    /**
     *
     * @methodName updateReviewApply
     * @description
     * @param act
     * @return com.wpca.common.lang.Result
     * @CreateTime 12:55 2022/9/25
     * @UpdateTime 12:55 2022/9/25
     */

    @PostMapping("/post/updateReviewApply")
    public Result updateReviewApply(@Validated @RequestBody CoreAct act) {

        act.setActReviewerDate(LocalDateTime.now());
        act.setActReviewerId(sysUserService.getByUsername(getUsername()).getId());
        //更新后需要重新审核
//        act.setActReply("重新审核中，请等待。");

        coreActService.updateById(act);

        return Result.succ(act);
    }
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
