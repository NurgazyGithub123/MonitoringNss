package com.example.monitoringNss.config;

public class CastToType {

    public static Long strToLong(String str){
        return Long.valueOf(str.substring(1, str.length() -1));
    }

    public static String strRmvQuotes(String str){
        return str.substring(1, str.length() -1);
    }


}
