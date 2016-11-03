/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
/**
 *
 * @author dyb37716
 * @version $Id: PdfTest, v 0.1 2016/11/3 9:00 dyb37716 Exp $
 */
public class PdfTest {

    public static void main(String[] args){
        String dest = ".\\tempOutput\\";
        String fileName = UUID.randomUUID() + ".pdf";
        dest +=fileName;
        System.out.println(dest);
        PdfTest.printText(dest);
    }

    public static void printText(String dest){
        try {
            Document document = new Document(PageSize.A4,80, 79, 60, 45);
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            Font fontChinese = new Font(bfChinese);
            Font titleChinese = new Font(bfChinese, 20, Font.BOLD);
            Font normalChinese = new Font(bfChinese, 14, Font.NORMAL);
            Font subBoldFontChinese = new Font(bfChinese, 8, Font.BOLD);
            Font subFontChinese = new Font(bfChinese, 12, Font.NORMAL);

            Paragraph title = new Paragraph("订单",titleChinese);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setLeading(1f);
            document.add(title);

            Paragraph content = new Paragraph("订单号：1234512363", normalChinese);
            content.setSpacingBefore(25f);//设置上面空白宽度
            document.add(content);

            content = new Paragraph("客户姓名：杜月波    客户电话：18896740989", normalChinese);
            content.setSpacingBefore(5f);//设置上面空白宽度
            document.add(content);

            content = new Paragraph("商品详情：", normalChinese);
            content.setSpacingBefore(5f);//设置上面空白宽度
            document.add(content);

            //设定6列
            float[] widths = new float[]{ 14f,30f,8f,15f,15f,8f };
            PdfPTable table = new PdfPTable(widths);
            table.setSpacingBefore(5f);// 设置表格上面空白宽度
            //table.setTotalWidth(500);// 设置表格的宽度
            table.setWidthPercentage(100);//设置表格宽度为%100

            //PdfPTable tableTest = new PdfPTable(8);
            PdfPCell cell = new PdfPCell(new Paragraph("编码", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("商品名称", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("单位", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("型号", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("规格", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("数量", subBoldFontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            document.add(table);

//            int rowCount=1; //行计数器
//            PdfPCell cell = null;
//            //---表头
//            cell = new PdfPCell(new Paragraph("期次", subBoldFontChinese));//描述
//            cell.setFixedHeight(20);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
//            table.addCell(cell);
//            cell = new PdfPCell(new Paragraph("租金日", subBoldFontChinese));//描述
//            cell.setFixedHeight(20);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
//            table.addCell(cell);
//            cell = new PdfPCell(new Paragraph("各期租金金额", subBoldFontChinese));//描述
//            cell.setFixedHeight(20);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Paragraph("各期租金后\n剩余租金", subBoldFontChinese));//描述
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
//            cell.setFixedHeight(20);
//            table.addCell(cell);
//            document.add(table);
//            Chunk chunk = new Chunk("中文", fontChinese);
//            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
//            chapter.setNumberDepth(0);
//            chapter.add(new Paragraph("This is the paragraph", fontChinese));
//            document.add(chapter);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test() throws IOException{

    }
}
