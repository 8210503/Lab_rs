package com.gft.lab_rs.network;

public class Constants {

    //请求头
    //public static String httpHost = "http://118.190.145.92:8081/";//正式库
    public static String httpHost = "http://118.190.145.92:8086/";

   // 118.190.145.92:8081
    public static final String VERSION = "Version/getversionupdating";//版本更新

    //public static String httpHost = "http://192.168.3.149:19228/";
    public static String imagePath = "http://192.168.1.233/obd/";

    public static String cash = "http://restapi.amap.com/v3/staticmap?location=116.481485,39.990464&zoom=10&size=1024*1024" +
            "&markers=mid,,A:116.481485,39.990464&key=824b8ceeace054d3e1d0a825f6e37959';";

    public static String getCashImage(String lon, String lat) {
        return "http://restapi.amap.com/v3/staticmap?location=" + lon + "," + lat + "&zoom=15&size=1024*1024&scale=2" +
                "&markers=mid,,A:" + lon + "," + lat + "&key=824b8ceeace054d3e1d0a825f6e37959";
    }

}
