package com.wpca.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpca.common.dto.ReviewApplyDto;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAct;
import com.wpca.entity.CoreUserAct;
import com.wpca.entity.SysUser;
import com.wpca.service.CoreActService;
import com.wpca.service.CoreUserActService;
import com.wpca.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/userAct")
public class CoreUserActController extends BaseController {


    @Autowired
    CoreUserActService coreUserActService;

    @Autowired
    SysUserService sysUserService;


    @Autowired
    CoreActService coreActService;

    @GetMapping("/get/allAct")
    public Result getAllAct(String name){
        System.out.println(name);
        Page maps = coreActService.page(getPage(), new QueryWrapper<CoreAct>()
                .like(StrUtil.isNotBlank(name),"act_name",name)
        );
        return Result.succ(maps);
    }
    /**
     *
     * @methodName getActSignUpByActId
     * @description 获得报名用户的信息 用于审核用户
     * @param id 活动的id
     * @return com.wpca.common.lang.Result
     * @CreateTime 15:45 2022/9/24
     * @UpdateTime 15:45 2022/9/24
     */
    @GetMapping("/get/actSignUpByActId/{id}")
    public Result getActSignUpByActId(@PathVariable Long id){

        //获得所有的参与者记录
        List<CoreUserAct> users = coreUserActService.list(new QueryWrapper<CoreUserAct>().eq("act_id", id));

        List ids=new ArrayList<Long>();

        users.forEach(user->ids.add(user.getUserId()));

        //活动报名者个人信息
        List<SysUser> userInfo = sysUserService.listByIds(ids);

        userInfo.forEach(u -> {
            u.setRoles(sysRoleService.listRolesByUserId(u.getId()));
        });

        List<ReviewApplyDto> reviewApplyDtos = new ArrayList<ReviewApplyDto>();

        userInfo.forEach(info->{
            ReviewApplyDto reviewApplyDto = new ReviewApplyDto();
            reviewApplyDto.setSysUser((SysUser) info);
            reviewApplyDto.setCoreUserAct(coreUserActService.getOne(
                    new QueryWrapper<CoreUserAct>()
                            .eq("user_id",((SysUser) info).getId())
                            .eq("act_id",id)
            ));
            reviewApplyDtos.add(reviewApplyDto);
        });

        Page page =getPage();

        page.setRecords(reviewApplyDtos);

        return Result.succ(page);

    }


    /**
     *
     * @methodName reviewSignUp
     * @description
     * @param userAct
     * @return com.wpca.common.lang.Result
     * @CreateTime 8:00 2022/9/25
     * @UpdateTime 8:00 2022/9/25
     */
    @PostMapping("/post/reviewSignUp")
    public Result reviewSignUp(@Validated @RequestBody CoreUserAct userAct){

        userAct.setUserActReviewDate(LocalDateTime.now());
        coreUserActService.updateById(userAct);

        return Result.succ("审核成功");

    }


    @GetMapping("/get/editInfo/{id}")
    public Result editReview(@PathVariable  String id){

        CoreUserAct id1 = coreUserActService.getOne(
                new QueryWrapper<CoreUserAct>()
                        .eq("id", Long.parseLong(id))
        );

        return Result.succ(id1);
    }
}


