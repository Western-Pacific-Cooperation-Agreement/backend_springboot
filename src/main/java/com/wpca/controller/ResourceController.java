package com.wpca.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.wpca.common.lang.Result;
import com.wpca.entity.CoreAct;
import com.wpca.entity.CoreAsso;
import com.wpca.service.CoreActService;
import com.wpca.service.CoreAssoService;
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
import java.util.List;


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
     * */
    @GetMapping(
            value = "/{fileName:.+}",
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public byte[] getFileWithMediaType(@PathVariable("fileName") String fileName) throws IOException {

        File file = new File(System.getProperty("user.dir") +this.pdfDownloadPath + fileName);

        InputStream in = new FileInputStream(file);

        return IOUtils.toByteArray(in);
    }


    @GetMapping("/getFileName")
    public Result getFileName(){

        return Result.succ(PdfUtil.pdfout(PdfUtil.produce()));
    }

    @GetMapping("/getProveExcel")
    public Result getProveExcel(String actId){

        String username = getUsername();

        CoreAct act = coreActService.getOne(new QueryWrapper<CoreAct>().eq("id",Long.parseLong(actId)));
        CoreAsso asso = coreAssoService.getById(act.getAssoId());
        return Result.succ(ExcelUtil.getProveExcel(username,act,asso));

    }

    @GetMapping("/getExcelFile")
    public Result getExcelFile(){
        return Result.succ(ExcelUtil.getExcelName(null,""));
    }
}




