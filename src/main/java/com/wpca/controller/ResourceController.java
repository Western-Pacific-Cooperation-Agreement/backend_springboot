package com.wpca.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wpca.common.lang.Result;
import com.wpca.entity.*;
import com.wpca.service.*;
import com.wpca.ultis.ExcelUtil;
import com.wpca.ultis.IOUtils;
import com.wpca.ultis.PdfUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.ResourceController
 * @Date 2022年09月16日 22:44
 * @Description
 */


@Api(tags = "资源服务接口")
@RestController
@RequestMapping("/downloadResource")
public class ResourceController extends BaseController {

    @Autowired
    CoreActService coreActService;

    @Autowired
    CoreAssoService coreAssoService;

    private Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Value("${wl.pdfDownloadPath:/downloadPdfPath/result/}")
    private String pdfDownloadPath;

    /**
     * 获取资源
     */
    @GetMapping(
            value = "/{fileName:.+}",
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public byte[] getFileWithMediaType(@PathVariable("fileName") String fileName) throws IOException {

        File file = new File(System.getProperty("user.dir") + this.pdfDownloadPath + fileName);

        InputStream in = new FileInputStream(file);

        return IOUtils.toByteArray(in);
    }


    @GetMapping("/getFileName")
    public Result getFileName() {

        return Result.succ(PdfUtil.pdfout(PdfUtil.produce()));
    }

    @GetMapping("/getProveExcel")
    public Result getProveExcel(String actId) {

        String username = getUsername();

        CoreAct act = coreActService.getOne(new QueryWrapper<CoreAct>().eq("id", Long.parseLong(actId)));
        CoreAsso asso = coreAssoService.getById(act.getAssoId());
        String templateName = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode","活动证明.xlsx")).getUsercode();

        return Result.succ(new ExcelUtil().getProveExcel(username, act, asso,templateName));

    }
    @Autowired
    SysDictService sysDictService;

    @Autowired
    CoreObjectService coreObjectService;

    @Autowired
    CoreAssoTypeService coreAssoTypeService;

    @GetMapping("/getApplicationExcel/{fontName}/{fontSize}/{fontColor}/{IsBold}/{IsItalic}")
    public Result getExcelFile(String actId, @PathVariable String fontName, @PathVariable int fontSize, @PathVariable int fontColor, @PathVariable Boolean IsBold, @PathVariable Boolean IsItalic) {
        CoreAct act = coreActService.getOne(new QueryWrapper<CoreAct>().eq("id", Long.parseLong(actId)));
        String username = getUsername();
        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        SysUser ActReviewer = sysUserService.getOne(new QueryWrapper<SysUser>().eq("id", act.getActReviewerId()));
        SysUser applyuser = sysUserService.getById(act.getUserId());

        System.out.println(act.getAssoId());
        CoreAsso asso = coreAssoService.getById(act.getAssoId());
        SysDict template = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "厦门理工学院活动登记卡.xlsx"));
        // 第一种占位符替换
        Map<String, Object> map = new HashMap<>();

        String assoName = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "assoName")).getUsercode();
        map.put( assoName,asso.getAssoName());

        String applyUserame = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "applyUserame")).getUsercode();
        map.put(applyUserame,username);

        String applyUserPhone = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "applyUserPhone")).getUsercode();

        map.put(applyUserPhone, applyuser.getPhone());


        String place = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "place")).getUsercode();
        map.put(place, act.getActPlace());

        String reviewUsername = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "reviewUsername")).getUsercode();
        map.put(reviewUsername, ActReviewer.getUsername());

        String reviewPhone = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "reviewPhone")).getUsercode();
        map.put(reviewPhone,ActReviewer.getPhone() );

        String actObjectName = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actObjectName")).getUsercode();
        map.put(actObjectName, coreObjectService.getOne(new QueryWrapper<CoreObject>().eq("id",act.getActObjectId())).getObjectName());

        String actNumberName = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actNumberName")).getUsercode();
        map.put(actNumberName, act.getActNumber());

        String assoType = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "assoType")).getUsercode();
        map.put(assoType, coreAssoTypeService.getOne(new QueryWrapper<CoreAssoType>().eq("id",act.getAssoId())).getAssoTypeName());

        String actStartDate = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actStartDate")).getUsercode();
        map.put(actStartDate, act.getActApplyDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

        String actName = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actName")).getUsercode();
        map.put(actName, act.getActName());

        String actAim = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actAim")).getUsercode();
        map.put(actAim, act.getActAim());

        String actProcess = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actProcess")).getUsercode();
        map.put(actProcess, act.getActMessage());

        String actMessage = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actMessage")).getUsercode();
        map.put(actMessage, act.getActMessage());

        String actWarn = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actWarn")).getUsercode();
        map.put(actWarn, act.getActWarn());

        String actFund = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actFund")).getUsercode();
        map.put(actFund, act.getActFund());

        String actApplyDate = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actApplyDate")).getUsercode();
        map.put(actApplyDate, act.getActApplyDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

        String actReviewerDate = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actReviewerDate")).getUsercode();
        map.put(actReviewerDate, act.getActReviewerDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

        String actReply = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "actReply")).getUsercode();
        map.put(actReply, act.getActReply());
        return Result.succ(new ExcelUtil().getApplicationExcel(username, act, asso, fontName, fontSize, fontColor, IsBold, IsItalic,template,map));
    }
}
