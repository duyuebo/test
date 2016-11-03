package com.dyb;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private Integer b;
    public static void main( String[] args )
    {
//        String value = "{\"OrderGuid\":\"WX201607180001\",\"TradeDetailList\":[{'Amount':'','AwardAmount':0,'BankName':'','BankType':1,'MerSerialId':'','OpenId':'','Operator':'','OutSerialid':'','PayFinishTime':1468574072203,'ProductId':1,'ReceveCompany':'','ReduceAmount':0,'TcSerialId':''}]}";
//        System.out.println( value );
//        try {
//            TradeNoticeDomain t = JSON.parseObject(value,TradeNoticeDomain.class);
//            System.out.println(t);
//        }catch (Exception e){ COMPETITOR; IDENTIFIER
//            e.printStackTrace(); WEBSITE; [词典]	EXTERNAL [词典]	 [词典]	POSITION EXPIRING_DATE

        //        }

        String text = "{\"ErrorCode\":4,\"ErrorMessage\":\"RequestParamError\",\"PayUrl\":null,\"TradeDetailList\":[]}";
        CreateTradeResponseDto c = JSON.parseObject(text,CreateTradeResponseDto.class);
        System.out.println(c);

//        List<String> strings = new ArrayList<>();
//        strings=null;
//        try {
//            strings.forEach(s->{
//                System.out.println("here");
//                System.out.println(s);
//            });
//        }catch (Exception e){
//            System.out.println("aaaaaaaaaa");
//            e.printStackTrace();
//        }
        String aaa="你好啊";
        System.out.println(App.isChinese(aaa));
         aaa="你好xxxx";
        System.out.println(App.isChinese(aaa));
        aaa="lishu isda usda";
        System.out.println(App.isChinese(aaa));

        App a= new App();
        App b = new App();
        b.setB(a.getB());
        System.out.println(b);
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public Integer getB(){
        return b;
    }

    public void setB(Integer b){
        this.b = b;
    }
}
