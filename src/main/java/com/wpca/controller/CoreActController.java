package com.wpca.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


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
