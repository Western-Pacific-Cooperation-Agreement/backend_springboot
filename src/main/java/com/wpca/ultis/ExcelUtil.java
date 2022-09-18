package com.wpca.ultis;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.wpca.template.CellStyleHandler;
import com.wpca.template.HistoryData;
import org.junit.Test;

import java.io.File;
import java.util.*;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.ultis.ExcelUtil
 * @Date 2022年09月17日 18:54
 * @Description
 */
public class ExcelUtil {

    public static void main(String[] args) {
        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        // 模板文件
        String templateFile = System.getProperty("user.dir") + "/downloadPdfPath/厦门理工学院活动登记卡.xlsx";
        // 结果文件，省去了根据模板文件生成的步骤
        String resultFile = System.getProperty("user.dir") + "/downloadPdfPath/result/厦门理工学院活动登记卡.xlsx";
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
        map.put("assoName", reportDate);
        map.put("phone", reportDate);
        map.put("place", reportDate);
        map.put("guidePhone", reportDate);
        map.put("object", reportDate);
        map.put("num", reportDate);
        map.put("type", reportDate);
        map.put("time", reportDate);
        map.put("actName", reportDate);
        map.put("actText", reportDate);
        map.put("actWarning", reportDate);


        excelWriter.fill(map, writeSheet);
        // 第二种占位符替换，这里定义了 hisData
        //excelWriter.fill(new FillWrapper("hisData", hisData()), fillConfig, writeSheet);
        excelWriter.finish();
    }


    private static List<HistoryData> hisData(){
        List<HistoryData> resList = new LinkedList<>();

        HistoryData yesData =new HistoryData();
                yesData.setPress(1999.1);
        resList.add(yesData);
        return resList;
    }


}
