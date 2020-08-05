package com.g0818.config;

public class PayConfig {
    private static String AppID;
    private static String MchID;
    private static String NotifyUr;
    private static String key;
    private static String storePassword;
    private static String url;

    public static String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        this.AppID = appID;
    }

    public static String getMchID() {
        return MchID;
    }

    public void setMchID(String mchID) {
        this.MchID = mchID;
    }

    public static String getNotifyUrl() {
        return NotifyUr;
    }

    public void setNotifyUr(String notifyUr) {
        this.NotifyUr = notifyUr;
    }

    public static String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public static String getKey() {return key;}

    public static void setKey(String key) {PayConfig.key = key;}

    public static String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}
}
