package com.wpca.template;

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


    private  String time;

    private  Double temp;

    private Double press;

    private Double insFlow;

    private Double isHeadt;



}
