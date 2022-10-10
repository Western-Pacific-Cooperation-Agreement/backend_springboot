package com.wpca.test;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.test.Test
 * @Date 2022年09月19日 08:45
 * @Description
 */
public class Test {

    /**
     * 最简单的填充
     *
     * @since 2.1.1
     */
    @org.junit.Test
    public void simpleFill() {
        // 加载模板
        String name = "历史活动.xls";
        String reportDate = DateUtil.date().toString("yyyy年MM月dd日");
        // 模板文件
        String templateFile = System.getProperty("user.dir") + "/downloadPdfPath/"+name;
        // 结果文件，省去了根据模板文件生成的步骤
        String resultFile = System.getProperty("user.dir") + "/downloadPdfPath/result/"+name;

        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
        FillData fillData = new FillData();
        fillData.setName("张三");
        fillData.setNumber(5.2);
        EasyExcel.write(resultFile).withTemplate(templateFile).sheet("Sheet1").doFill(fillData);

//
//        // 方案2 根据Map填充
//        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        Map<String, Object> map = new HashMap();
//        map.put("name", "张三");
//        map.put("number", 5.2);
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(map);
    }
}
