package com.wpca.template;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.zip.DeflaterOutputStream;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.template.HistoryData
 * @Date 2022年09月17日 18:55
 * @Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryData {

    private static final long serialVersionUID =1L;

    @ExcelProperty(value = "时间")
    private  String time;
    @ExcelProperty(value = "温度")
    private  Double temp;
    @ExcelProperty(value = "流量")
    private Double press;
    @ExcelProperty(value = "压力")
    private Double insFlow;
    @ExcelProperty(value = "热量")
    private Double isHeadt;



}
