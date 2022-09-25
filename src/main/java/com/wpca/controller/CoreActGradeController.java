package com.wpca.controller;


import com.wpca.common.lang.Result;
import com.wpca.entity.CoreActGrade;
import com.wpca.entity.CoreAsso;
import com.wpca.service.CoreActGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/coreActGrade")
public class CoreActGradeController extends BaseController {
    @Autowired
    CoreActGradeService coreActGradeService;

    @GetMapping("/actTypeList")
    public Result actTypeList(){
//        System.out.println(coreActGradeService.list());
//        return Result.succ(coreActGradeService.list());
        List<CoreActGrade> coreActGradeList= coreActGradeService.findAll();
        return Result.succ(coreActGradeList);
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println("getById : "+coreActGradeService.getById(id));
        return Result.succ(coreActGradeService.getById(id));
    }

    @PostMapping("/getActTypeByName")
    public Result getActTypeByName(@RequestBody String actGradeName){
        List<CoreActGrade> getByName = coreActGradeService.getActTypeByName(actGradeName);
        return Result.succ(getByName);
    }

    @PostMapping("/delById")
    public Result delById(@RequestBody Integer[] ids){
        for(Integer id: ids){
            coreActGradeService.delById(id);
        }
        return Result.succ("删除活动类型成功");
    }

    @PostMapping("/updateActType")
    public Result updateActType(@RequestBody CoreActGrade coreActGrade){
        coreActGradeService.updateActType(coreActGrade);
        return Result.succ("修改成功");
    }

    @PostMapping("veActType")
    public Result saveActType(@RequestBody CoreActGrade coreActGrade){
        coreActGradeService.saveActType(coreActGrade.getActGradeName(),coreActGrade.getActGradeRemark());
        return Result.succ("新增成功");
    }
}
