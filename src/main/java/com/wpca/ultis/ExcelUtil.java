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
import com.wpca.entity.CoreAct;
import com.wpca.entity.CoreAsso;
import com.wpca.template.CellStyleHandler;
import com.wpca.template.HistoryData;
import com.wpca.test.FillData;
import org.junit.Test;

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

    public static void main(String[] args) {
        String name = "excel.xls";
        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        // 模板文件
        String templateFile = System.getProperty("user.dir") + "/downloadPdfPath/"+name;
        // 结果文件，省去了根据模板文件生成的步骤
        String resultFile = System.getProperty("user.dir") + "/downloadPdfPath/result/"+name;
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
        // 第一种占位符替换
        Map<String, Object> map = new HashMap<>();

        map.put("assoName", "厦门理工周末文化集市运营部");
        map.put("applyUserame", "XieQijiang");
        map.put("applyUserPhone", "13178017923");
        map.put("place", "艺术礼堂前");
        map.put("reviewUsername", "Admin");
        map.put("reviewPhone", "+86 866591");
        map.put("actObjectName", "全体学生");
        map.put("actNumberName", "1000人及以上");
        map.put("assoType", "校级");
        map.put("actStartDate", "全体学生");
        map.put("actName", "周末文化集市");
        map.put("actAim", "为了让厦门理工学院的学生们走出宿舍，走向人文文化活动，厦门理工学院校团委提出了一个“阳光雨露计划”。");
        map.put("actProcess", "所有摊位都面向全校学生招标，因此每个学生都有机会参与到其中，今天你是逛集市的“游客”，明天你可能就是摊位的“主人”。");

        map.put("actMessage", "“周末文化集市”的前身是“周末文化大舞台”。“不论才艺是否出众，只要有热情，只要有意愿，就可以登台展风采”——这是“周末文化大舞台”打出的旗号；让更多普通同学有机会表现和锻炼自己，成为校园文化活动的“主角”，是“周末文化大舞台”的初衷。");
        map.put("actWarn", "新的学期已经开始，希望有更多的同学能参与到集市进来，让“阳光雨露计划”真正惠及每一位学生。");

        map.put("actFund", 2000);

        map.put("actApplyDate", reportDate);

        map.put("actReviewerDate", reportDate);

        map.put("actReply", "同意举办本次活动");

//        excelWriter.fill(map, writeSheet);
        // 第二种占位符替换，这里定义了 hisData

        ArrayList<CoreAct> historyData = new ArrayList<>();
        historyData.add(new CoreAct());
        //excelWriter.fill(historyData,fillConfig, writeSheet);
        //EasyExcel.write(resultFile).withTemplate(templateFile).sheet().doFill(data());
        excelWriter.fill(new FillWrapper(hisData()), fillConfig,writeSheet);
        excelWriter.finish();


    }


    private static List<HistoryData> hisData(){
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

    public static String getProveExcel(String username, CoreAct act, CoreAsso asso) {

         String templateName="活动证明.xlsx";

        String user_dir=System.getProperty("user.dir");

        String templateFilePath="/downloadPdfPath/";
        // 模板文件
        String templateFile = user_dir + templateFilePath+templateName;
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        String fileName = uuid +".xlsx";

        // 结果文件，省去了根据模板文件生成的步骤
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
     * @methodName getExcelName
     * @description

     * @param coreAct
     * @param templateName
     * @return java.lang.String
     * @CreateTime 15:13 2022/9/20
     * @UpdateTime 15:13 2022/9/20
     */
    public static String getExcelName(CoreAct coreAct,String templateName) {

        templateName="厦门理工学院活动登记卡.xlsx";

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
                .registerWriteHandler(new CellStyleHandler())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();
        // 每次都会重新生成新的一行，而不是使用下面的空行
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        // 第一种占位符替换
        Map<String, Object> map = new HashMap<>();
        map.put("assoName", "厦门理工周末文化集市运营部");
        map.put("applyUserame", "XieQijiang");
        map.put("applyUserPhone", "13178017923");
        map.put("place", "艺术礼堂前");
        map.put("reviewUsername", "Admin");
        map.put("reviewPhone", "+86 866591");
        map.put("actObjectName", "全体学生");
        map.put("actNumberName", "1000人及以上");
        map.put("assoType", "校级");
        map.put("actStartDate", "全体学生");
        map.put("actName", "周末文化集市");
        map.put("actAim", "为了让厦门理工学院的学生们走出宿舍，走向人文文化活动，厦门理工学院校团委提出了一个“阳光雨露计划”。");
        map.put("actProcess", "所有摊位都面向全校学生招标，因此每个学生都有机会参与到其中，今天你是逛集市的“游客”，明天你可能就是摊位的“主人”。");

        map.put("actMessage", "“周末文化集市”的前身是“周末文化大舞台”。“不论才艺是否出众，只要有热情，只要有意愿，就可以登台展风采”——这是“周末文化大舞台”打出的旗号；让更多普通同学有机会表现和锻炼自己，成为校园文化活动的“主角”，是“周末文化大舞台”的初衷。");
        map.put("actWarn", "新的学期已经开始，希望有更多的同学能参与到集市进来，让“阳光雨露计划”真正惠及每一位学生。");

        map.put("actFund", 2000);

        map.put("actApplyDate", reportDate);

        map.put("actReviewerDate", reportDate);

        map.put("actReply", "同意举办本次活动");


        excelWriter.fill(map, writeSheet);
        // 第二种占位符替换，这里定义了 hisData
        //excelWriter.fill(new FillWrapper("hisData", hisData()), fillConfig, writeSheet);
        excelWriter.finish();


        return fileName;
    }

}
