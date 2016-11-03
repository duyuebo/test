/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb.pdf;


import org.apache.poi.wp.usermodel.Paragraph;

import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
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
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            //Paragraph cn = new Paragraph("English");
            Paragraph cn = new Paragraph("这是中文");
            PdfFontFactory.register("D:\\MyConfiguration\\dyb37716\\Downloads\\songti.ttf","songti");
            Set<String> fonts = PdfFontFactory.getRegisteredFonts();
            for(String s:fonts){
                System.out.println(s);
            }
            PdfFont font = PdfFontFactory.createRegisteredFont("经典宋体简");
            cn.setFont(font);
            document.add(cn);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test() throws IOException{

    }
}
