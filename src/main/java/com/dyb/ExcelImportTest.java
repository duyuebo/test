/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author dyb37716
 * @version $Id: ExcelImportTest, v 0.1 2016/10/8 14:47 dyb37716 Exp $
 */
public class ExcelImportTest {

    //使用POI读入excel工作簿文件
    public static void readWorkBook() throws Exception{
        // poi读取excel
        //创建要读入的文件的输入流
        InputStream inp = new FileInputStream("D://34.xlsx");

        //根据上述创建的输入流 创建工作簿对象
        Workbook wb = WorkbookFactory.create(inp);
        //得到第一页 sheet
        //页Sheet是从0开始索引的
        Sheet sheet = wb.getSheetAt(0);
        //利用foreach循环 遍历sheet中的所有行
        for (Row row : sheet) {
            System.out.println("行：" + row.getRowNum());
            //遍历row中的所有方格
            for (Cell cell : row) {
                    //输出方格中的内容，以空格间隔
                    System.out.print("列" + cell.getColumnIndex() + ":" + cell.toString() + "$$$  ");
                }
            //每一个行输出之后换行
            System.out.println();
        }
        //关闭输入流
        inp.close();
    }

    public static void main(String[] args){
        try {
            ExcelImportTest.readWorkBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
