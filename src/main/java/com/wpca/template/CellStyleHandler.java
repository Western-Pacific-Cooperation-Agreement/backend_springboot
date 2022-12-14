package com.wpca.template;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.template.CellStyleHandler
 * @Date 2022年09月17日 19:23
 * @Description
 */

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class CellStyleHandler implements CellWriteHandler {
    String fontName="宋体";
    int fontSize=11,fontColor=0;
    Boolean IsBold=Boolean.FALSE,IsItalic=Boolean.FALSE;

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();

        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框

        cellStyle.setVerticalAlignment(VerticalAlignment.TOP);//顶端对齐
        cellStyle.setAlignment(HorizontalAlignment.LEFT);

        cellStyle.setWrapText(true);//设置自动换行

        Font font = workbook.createFont();

        font.setFontName(fontName);
        font.setFontHeightInPoints((short)fontSize);
        font.setColor((short) fontColor);
        font.setBold(IsBold);
        font.setItalic(IsItalic);

        font.getCharSet();
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
    }


    /**
     * 对象转化为Map
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, String> objectToMap01(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), (String) field.get(obj));
        }

        return map;
    }
}
