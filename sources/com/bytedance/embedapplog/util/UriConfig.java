package com.bytedance.embedapplog.util;

public class UriConfig {
    public static final int AMERICA = 2;
    public static final int DEFAULT = 0;
    public static final int SINGAPORE = 1;
    private static final String[] a = {"https://toblog.ctobsnssdk.com", "https://tobapplog.ctobsnssdk.com"};
    private static final String[] b = {"https://toblog.tobsnssdk.com", "https://tobapplog.tobsnssdk.com"};
    private static final String[] c = {"https://toblog.itobsnssdk.com", "https://tobapplog.itobsnssdk.com"};
    private String d;
    private String e;
    private String f;
    private String g;
    private String[] h;
    private String i;

    private void a() {
        this.d = "https://toblog.ctobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.ctobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.ctobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.ctobsnssdk.com/service/2/abtest_config/";
        this.h = a;
        this.i = "https://success.ctobsnssdk.com";
    }

    private void b() {
        this.d = "https://toblog.tobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.tobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.tobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.tobsnssdk.com/service/2/abtest_config/";
        this.h = b;
        this.i = "https://success.tobsnssdk.com";
    }

    private void c() {
        this.d = "https://toblog.itobsnssdk.com/service/2/device_register_only/";
        this.e = "https://toblog.itobsnssdk.com/service/2/app_alert_check/";
        this.f = "https://toblog.itobsnssdk.com/service/2/log_settings/";
        this.g = "https://toblog.itobsnssdk.com/service/2/abtest_config/";
        this.h = c;
        this.i = "https://success.itobsnssdk.com";
    }

    private UriConfig() {
        a();
    }

    public static UriConfig creatUriConfig(int i2) {
        UriConfig uriConfig = new UriConfig();
        if (i2 == 0) {
            uriConfig.a();
        } else if (i2 == 1) {
            uriConfig.b();
        } else if (i2 != 2) {
            uriConfig.a();
        } else {
            uriConfig.c();
        }
        return uriConfig;
    }

    public String getRegisterUri() {
        return this.d;
    }

    public String getActiveUri() {
        return this.e;
    }

    public String getSettingUri() {
        return this.f;
    }

    public String getABConfigUri() {
        return this.g;
    }

    public String[] getSendHeadersUris() {
        return this.h;
    }

    public String getSuccRateUri() {
        return this.i;
    }
}
