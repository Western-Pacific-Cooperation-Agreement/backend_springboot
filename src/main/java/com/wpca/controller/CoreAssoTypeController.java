package com.wpca.controller;


import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAssoType;
import com.wpca.service.CoreAssoService;
import com.wpca.service.CoreAssoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WPCA
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/coreAssoType")
public class CoreAssoTypeController extends BaseController {
    @Autowired
    CoreAssoTypeService coreAssoTypeService;

    @GetMapping("/typeList")
    public Result typeList(){
        return Result.succ(coreAssoTypeService.list());
    }

    @PostMapping("/delById")
    public Result delById(@RequestBody Integer[] ids) {
        for (Integer id : ids) {
            coreAssoTypeService.removeById(id);
        }
        return Result.succ("部门类型删除成功");
    }


    @GetMapping("/updateGetId/{id}")
    public Result getId(@PathVariable Long id){
        return Result.succ(coreAssoTypeService.getById(id));
    }


    @PostMapping("/updateAssoType")
    public Result updateAssoType(@RequestBody CoreAssoType coreAssoType){
        return Result.succ(coreAssoTypeService.updateById(coreAssoType));
    }


    @PostMapping("/addAssoType")
    public Result addAssoType(@RequestBody CoreAssoType coreAssoType){
        coreAssoTypeService.addAssoType(coreAssoType.getAssoTypeName(),coreAssoType.getAssoTypeRemark());
        return Result.succ("添加部门类型成功");
    }


    @PostMapping("/searchAssoType")
    public Result searchAssoType(@RequestBody String assoTypeName){
        return Result.succ(coreAssoTypeService.search(assoTypeName));
    }


}
