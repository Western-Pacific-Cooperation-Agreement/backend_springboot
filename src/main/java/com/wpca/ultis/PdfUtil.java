package com.wpca.ultis;

import cn.hutool.core.lang.UUID;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.*;
import com.wpca.template.JdPrintTemplate;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.ultis.PdfUtil
 * @Date 2022年09月16日 22:44
 * @Description
 */

public class PdfUtil {
    private static Logger logger = LoggerFactory.getLogger(PdfUtil.class);

    // 利用模板生成pdf
    public static String pdfout(java.util.List<JdPrintTemplate>  tlist) {
        // 模板路径
        String templatePath = System.getProperty("user.dir") + "/downloadPdfPath/pdfTemplate.pdf";
        // 生成的新文件路径
        String fileName = UUID.randomUUID().toString().replace("-","").substring(0,16) +".pdf";
        String newPDFPath = System.getProperty("user.dir") + "/downloadPdfPath/result/"+ fileName;

//        String templatePath = System.getProperty("user.dir") + "/src/main/resources/static/pdfTemplate.pdf";
//        // 生成的新文件路径
//        String fileName = UUID.randomUUID().toString().replace("-","").substring(0,16) +".pdf";
//        String newPDFPath = System.getProperty("user.dir") + "/downloadPdfPath/result/"+ fileName;




        FileOutputStream out;

        //每一条数据代表一个pdf表格
        java.util.List<PdfReader> list = new ArrayList();
        try {

            String prefixFont = "";
            String os = System.getProperties().getProperty("os.name");
            if (os.startsWith("win") || os.startsWith("Win")) {
                prefixFont = "C:\\Windows\\Fonts" + File.separator;
            } else {
                prefixFont = "/usr/share/fonts/chinese" + File.separator;
            }

            BaseFont bf = BaseFont.createFont(prefixFont + "simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            out = new FileOutputStream(newPDFPath);// 输出流

            tlist.forEach(template->{
                try {
                    PdfReader reader = new PdfReader(templatePath);// 读取pdf模板
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();

                    PdfStamper stamper = new PdfStamper(reader, bos);
                    AcroFields form = stamper.getAcroFields();

                    //文字类的内容处理
                    Map<String,String> datemap = template.getColumns();
                    form.addSubstitutionFont(bf);
                    for(String key : datemap.keySet()){
                        String value = datemap.get(key);
                        form.setField(key,value);
                    }
                    //图片类的内容处理
//                    Map<String,String> imgmap = template.getQrCodes();
//                    for(String key : imgmap.keySet()) {
//                        String value = imgmap.get(key);
//
//                        int pageNo = form.getFieldPositions(key).get(0).page;
//                        Rectangle signRect = form.getFieldPositions(key).get(0).position;
//                        float x = signRect.getLeft();
//                        float y = signRect.getBottom();
//
//                        Barcode128 barcode128 = new Barcode128();
//                        //条形码字号
//                        barcode128.setSize(18);
//                        //条形码高度
//                        barcode128.setBarHeight(80);
//                        //条形码与数字间距
//                        barcode128.setBaseline(15);
//                        //条形码值
//                        barcode128.setCode(value);
//                        barcode128.setStartStopText(true);
//                        barcode128.setExtended(true);
//                        barcode128.setX(2.5f);
//                        //绘制条形码在第一页
//                        PdfContentByte cb = stamper.getOverContent(pageNo);
//                        //生成条形码图片
//                        Image image128 = barcode128.createImageWithBarcode(cb, null, null);
//                        //图片大小自适应
//                        image128.scaleToFit(signRect.getWidth(), signRect.getHeight());
//                        //条形码位置
//                        image128.setAbsolutePosition(x, y);
//                        //加入条形码
//                        cb.addImage(image128);
//                    }

                    stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
                    stamper.close();
                    PdfReader pdfReader = new PdfReader(bos.toByteArray());

                    list.add(pdfReader);
                } catch (DocumentException e) {
                    e.printStackTrace();
                    logger.error("PDF生成出错：{}"+e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("PDF生成出错：{}"+e.getMessage());
                }
            });

            //上面已经获得了pdf的每一页，这里只需要合并成为一个pdf，然后返回

            Document document = new Document();

            PdfCopy copy = new PdfCopy(document, out);

            document.open();

            for (int k = 0; k < list.size(); k++) {

                PdfReader pdfReader = list.get(k);

                document.newPage();

                copy.addDocument(pdfReader);

            }

            copy.close();

        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        }
        return fileName;
    }


    public static java.util.List<JdPrintTemplate> produce() {

        JdPrintTemplate pTemplate0 = new JdPrintTemplate();
        pTemplate0.setSubQrCode("JDVC11293914838-1-3-");
        pTemplate0.setPQrCode("JDVC11293914838");
        pTemplate0.setPrintTime("1");
        pTemplate0.setPrintDate("2020-11-07 10:52:23");
        pTemplate0.setSerial("第1/3个");
        pTemplate0.setWeight("1.0Kg");
        pTemplate0.setSourceSortCenterName("合肥");
        pTemplate0.setSourceCrossCode("40-济南W");
        pTemplate0.setTargetSortCenterName("烟台");
        pTemplate0.setTargetCrossCode("47-Y6");
        pTemplate0.setSiteName("烟台容大营业部");
        pTemplate0.setRoad("055");
        pTemplate0.setCollectMoney("代收金额：55元");
        pTemplate0.setTotalMoney("应收总计：55元");
        pTemplate0.setConsignee("张三");
        pTemplate0.setConsigneeTel("134567890");
        pTemplate0.setDestination("广州三元里花园酒店");
        pTemplate0.setSender("李四");
        pTemplate0.setSenderTel("189034567");
        pTemplate0.setSenderAddr("深圳宝安");
        pTemplate0.setDesc("防寒衣服");
        pTemplate0.setDistributeCode("143");
        pTemplate0.setOrderId("RX2021110765497664");
        pTemplate0.setComment("客户对我们很重要");

        JdPrintTemplate pTemplate1 = new JdPrintTemplate();
        pTemplate1.setSubQrCode("JDVC456739188890-1-2-");
        pTemplate1.setPQrCode("JDVC456739188890");
        pTemplate1.setPrintTime("1");
        pTemplate1.setPrintDate("2020-11-07 10:52:23");
        pTemplate1.setSerial("第1/2个");
        pTemplate1.setWeight("2.0Kg");
        pTemplate1.setSourceSortCenterName("山东");
        pTemplate1.setSourceCrossCode("40-济南W");
        pTemplate1.setTargetSortCenterName("烟台");
        pTemplate1.setTargetCrossCode("47-Y6");
        pTemplate1.setSiteName("青岛容大营业部");
        pTemplate1.setRoad("056");
        pTemplate1.setCollectMoney("代收金额：65元");
        pTemplate1.setTotalMoney("应收总计：65元");
        pTemplate1.setConsignee("张三1");
        pTemplate1.setConsigneeTel("1888888999");
        pTemplate1.setDestination("青岛三元里花园酒店");
        pTemplate1.setSender("李四1");
        pTemplate1.setSenderTel("189034567");
        pTemplate1.setSenderAddr("深圳宝安1");
        pTemplate1.setDesc("防寒衣服1");
        pTemplate1.setDistributeCode("147");
        pTemplate1.setOrderId("RX20211102345497");
        pTemplate1.setComment("客户对我们很重要11111");

        //每JdPrintTemplate对象数据代表一个pdf表格
        java.util.List<JdPrintTemplate> list = new ArrayList();
        list.add(pTemplate0);
        list.add(pTemplate1);

        //pdfout(list);

        return list;
    }
}

