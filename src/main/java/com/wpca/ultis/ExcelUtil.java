package com.wpca.ultis;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wpca.entity.*;
import com.wpca.service.*;
import com.wpca.template.CellStyleHandler;
import com.wpca.template.HistoryData;
import com.wpca.test.FillData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.ultis.ExcelUtil
 * @Date 2022年09月17日 18:54
 * @Description
 */

public class ExcelUtil {




    public  String getHistory(String username,
                              CoreAct act,
                              CoreAsso asso,
                              String fontName,
                              String name) {
//        String name = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode","历史活动.xls")).getUsercode();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//生成唯一的序号（机器识别号）
        String fileName = uuid +".xlsx";
        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        // 模板文件
        String templateFile = System.getProperty("user.dir") + "/downloadPdfPath/"+name;
        // 结果文件，省去了根据模板文件生成的步骤
        String resultFile = System.getProperty("user.dir") + "/downloadPdfPath/result/"+fileName;
        // 根据模板文件生成目标文件
        ExcelWriter excelWriter = EasyExcel
                .write(resultFile)
                .withTemplate(templateFile)
                // 单独设置单元格格式
                .registerWriteHandler(new CellStyleHandler())
                .build();


        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
        // 每次都会重新生成新的一行，而不是使用下面的空行
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();


//        excelWriter.fill(map, writeSheet);
        // 第二种占位符替换，这里定义了 hisData

        ArrayList<CoreAct> historyData = new ArrayList<>();
        historyData.add(new CoreAct());
        //excelWriter.fill(historyData,fillConfig, writeSheet);
        //EasyExcel.write(resultFile).withTemplate(templateFile).sheet().doFill(data());
        excelWriter.fill(new FillWrapper(hisData()), fillConfig,writeSheet);
        excelWriter.finish();

        return fileName;
    }


    private List<HistoryData> hisData(){
        List<HistoryData> resList = new ArrayList<>();

        HistoryData yesData =new HistoryData();
        yesData.setPress(1999.1);
        HistoryData yesData1 =new HistoryData();
        yesData.setPress(1999.12);
        resList.add(yesData);
        resList.add(yesData1);
        return resList;
    }

    /**
     *
     * @methodName getProveExcel
     * @description  打印活动证明
     * @param username
     * @param act
     * @param asso
     * @return java.lang.String
     * @CreateTime 15:12 2022/9/20
     * @UpdateTime 15:12 2022/9/20
     */

    public  String getProveExcel(String username, CoreAct act, CoreAsso asso,String templateName) {


        String user_dir=System.getProperty("user.dir");//获得工作根目录

        String templateFilePath="/downloadPdfPath/";

        // 模板文件路径
        String templateFile = user_dir + templateFilePath+templateName;
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//生成唯一的序号（机器识别号）
        String fileName = uuid +".xlsx";

        // 结果文件路径，省去了根据模板文件生成的步骤
        String resultFile = user_dir + templateFilePath+"result/"+fileName;

        // 根据模板文件生成目标文件
        ExcelWriter excelWriter = EasyExcel
                .write(resultFile)
                .withTemplate(templateFile)
                // 单独设置单元格格式
                .registerWriteHandler(new CellStyleHandler())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
        // 每次都会重新生成新的一行，而不是使用下面的空行
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

        String reportDate = DateUtil.date().toString("yyyy年MM月dd日hh:mm:ss");
        // 第一种占位符替换
        Map<String, Object> map = new HashMap<>();
        map.put("actName", act.getActName());
        map.put("date", act.getActStartDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        map.put("asso", asso.getAssoName());
        map.put("username", username);
        map.put("printDate", reportDate);
        map.put("printCode", uuid);
        excelWriter.fill(map, writeSheet);

        excelWriter.finish();

        return fileName;
    }


    /**
     *
     * @methodName getApplicationExcel
     * @description

     * @param username
     * @param act
     * @param asso
     * @return java.lang.String
     * @CreateTime 15:13 2022/9/20
     * @UpdateTime 15:13 2022/9/20
     */
    public  String getApplicationExcel(String username,
                                             CoreAct act,
                                             CoreAsso asso,
                                             String fontName,
                                             int fontSize,
                                             int fontColor,
                                             Boolean IsBold,
                                             Boolean IsItalic,
                                             SysDict template,
                                       Map map) {

//        SysDict template = sysDictService.getOne(new QueryWrapper<SysDict>().eq("syscode", "厦门理工学院活动登记卡.xlsx"));
//        SysDict template = sysDictService.getById(1L);
        String templateName = template.getUsercode();

        String user_dir=System.getProperty("user.dir");

        String templateFilePath="/downloadPdfPath/";


        // 模板文件
        String templateFile = user_dir + templateFilePath+templateName;

        String fileName = UUID.randomUUID().toString().replace("-","").substring(0,16) +".xlsx";

        // 结果文件，省去了根据模板文件生成的步骤
        String resultFile = user_dir + templateFilePath+"result/"+fileName;


        // 根据模板文件生成目标文件
        ExcelWriter excelWriter = EasyExcel
                .write(resultFile)
                .withTemplate(templateFile)
                // 单独设置单元格格式
                .registerWriteHandler(new CellStyleHandler(fontName,fontSize,fontColor,IsBold,IsItalic))
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
        // 每次都会重新生成新的一行，而不是使用下面的空行
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();





        excelWriter.fill(map, writeSheet);


        excelWriter.finish();


        return fileName;
    }

}
