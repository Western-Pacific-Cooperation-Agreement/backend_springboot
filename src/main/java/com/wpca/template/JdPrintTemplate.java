package com.wpca.template;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.template.JdPrintTemplate
 * @Date 2022年09月16日 22:43
 * @Description
 */

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *模板类，字段与上面的变量名一一对应
 */
@Data
public class JdPrintTemplate {

    /**
     * 面单最上面的子条形码
     * */
    private String subQrCode;
    /**
     * 面单下面的父条形码
     * */
    private String pQrCode;

    /**
     * 打印次数
     * */
    private String printTime;
    /**
     * 打印时间
     * */
    private String printDate;

    /**
     * 始发分拣中心
     * */
    private String sourceSortCenterName;

    /**
     *始发道口号
     * */
    private String originalCrossCode;

    private String sourceCrossCode;

    /**
     *始发笼车号
     * */
    private String originalTabletrolleyCode;

    /**
     * 目的分拣中心
     * */
    private String targetSortCenterName;

    private String targetCrossCode;

    /**
     * 目的道口号
     * */
    private String destinationCrossCode;

    /**
     * 目的笼车号
     * */
    private String destinationTabletrolleyCode;

    /**
     * 路区
     * */
    private String road;

    /**
     * 重量
     * */
    private String weight;

    /**
     * 目的站点
     * */
    private String siteName;

    /**
     * 客户名字
     * */
    private String consignee;
    /**
     * 客户电话
     * */
    private String consigneeTel;
    /**
     * 目的地址
     * */
    private String destination;
    /**
     * 发件人名字
     * */
    private String sender;
    /**
     * 发件地址
     * */
    private String senderAddr;

    /**
     * 发件人电话
     * */
    private String senderTel;

    /**
     * 描述
     * */
    private String desc;
    /**
     * 分发码
     * */
    private String distributeCode;
    /**
     * 定单id
     * */
    private String orderId;

    /**
     * 备注
     * */
    private String comment;

    /**
     * 代收金额
     * */
    private String collectMoney;

    /**
     * 应收金额
     * */
    private String totalMoney;

    /**
     * 第几个快递
     * */
    private String serial;

    /**
     * 获取占位字段
     * */
    public Map<String,String> getColumns(){
        Map<String,String> map = new HashMap();
        map.put("printTime",this.printTime);
        map.put("printDate",this.printDate);
        map.put("serial",this.serial);
        map.put("sourceSortCenterName",this.sourceSortCenterName);
        map.put("originalCrossCode",this.originalCrossCode);
        map.put("collectMoney",this.collectMoney);
        map.put("totalMoney",this.totalMoney);
        map.put("originalTabletrolleyCode",this.originalTabletrolleyCode);
        map.put("targetSortCenterName",this.targetSortCenterName);
        map.put("destinationCrossCode",this.destinationCrossCode);
        map.put("destinationTabletrolleyCode",this.destinationTabletrolleyCode);
        map.put("sourceCrossCode", this.sourceCrossCode);
        map.put("targetCrossCode", this.targetCrossCode);
        map.put("road",this.road);
        map.put("weight",this.weight);
        map.put("siteName",this.siteName);
        map.put("consignee",this.consignee);
        map.put("consigneeTel",this.consigneeTel);
        map.put("destination",this.destination);
        map.put("sender",this.sender);
        map.put("senderAddr",this.senderAddr);
        map.put("senderTel",this.senderTel);
        map.put("desc",this.desc);
        map.put("distributeCode",this.distributeCode);
        map.put("orderId",this.orderId);
        map.put("comment",this.comment);

        return map;
    }

    /**
     * 获取条形码字段
     * */
    public Map<String,String> getQrCodes(){
        Map<String,String> map = new HashMap();
        map.put("subQrCode",this.subQrCode);
        map.put("pQrCode",this.pQrCode);
        return map;
    }

}

