package com.ali.auth.third.core.config;

import com.ali.auth.third.core.model.SNSConfig;
import java.util.Map;

public class ConfigManager {
    public static int APP_KEY_INDEX = 0;
    public static int DAILY_APP_KEY_INDEX = 0;
    public static boolean DEBUG;
    public static String LOGIN_HOST = "https://login.m.taobao.com/minisdk/login.htm";
    public static String LOGIN_URLS = "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)";
    public static String LOGOUT_URLS;
    public static String POSTFIX_OF_SECURITY_JPG = "";
    public static String POSTFIX_OF_SECURITY_JPG_USER_SET;
    public static final Version SDK_VERSION = new Version(2, 0, 0);
    private static final ConfigManager b = new ConfigManager();
    public static String bindUrl = "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s";
    public static String getQrCodeContentUrl = "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m";
    public static String qrCodeLoginUrl = "https://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    public static String qrCodeLoginUrl_daily = "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin";
    public static String qrLoginConfirmUrl = "https://login.m.taobao.com/qrcodeLogin.htm?shortURL=%s&from=bcqrlogin";
    public static int site = 0;
    public static String unbindUrl = "https://accountlink.taobao.com/sdkUnbind.htm";
    Map<String, Object> a;
    private Environment c;
    private int d = 3;
    private boolean e = true;
    private String f;
    private String g;
    private Class<?> h;
    private int i = 0;
    private SNSConfig j;

    private ConfigManager() {
    }

    public static int getAppKeyIndex() {
        return (getInstance().getEnvironment() == null || !getInstance().getEnvironment().equals(Environment.TEST)) ? APP_KEY_INDEX : DAILY_APP_KEY_INDEX;
    }

    public static int getDailyAppKeyIndex() {
        return DAILY_APP_KEY_INDEX;
    }

    public static ConfigManager getInstance() {
        return b;
    }

    public static int getSite() {
        return site;
    }

    public static void setAppKeyIndex(int i2) {
        APP_KEY_INDEX = i2;
    }

    public static void setAppKeyIndex(int i2, int i3) {
        APP_KEY_INDEX = i2;
        DAILY_APP_KEY_INDEX = i3;
    }

    public static void setSite(int i2) {
        site = i2;
    }

    public SNSConfig getAlipay3Config() {
        return this.j;
    }

    public Environment getEnvironment() {
        return this.c;
    }

    public Class<?> getFullyCustomizedLoginFragment() {
        return this.h;
    }

    public int getMaxHistoryAccount() {
        return this.d;
    }

    public String getOfflineDeviceID() {
        return this.f;
    }

    public int getOrientation() {
        return this.i;
    }

    public String getQrCodeLoginUrl() {
        return (getEnvironment() == null || !getEnvironment().equals(Environment.TEST)) ? qrCodeLoginUrl : qrCodeLoginUrl_daily;
    }

    public Map<String, Object> getScanParams() {
        return this.a;
    }

    public String getSsoToken() {
        return this.g;
    }

    public void init(int i2) {
        this.c = Environment.values()[i2];
        LOGIN_HOST = new String[]{"http://login.waptest.tbsandbox.com/minisdk/login.htm", "http://login.waptest.taobao.com/minisdk/login.htm", "http://login.wapa.taobao.com/minisdk/login.htm", "https://login.m.taobao.com/minisdk/login.htm"}[i2];
        LOGIN_URLS = new String[]{"((https|http)://)login.waptest.tbsandbox.com/login.htm(.*)", "((https|http)://)login.waptest.taobao.com/login.htm(.*)", "((https|http)://)login.wapa.taobao.com/login.htm(.*)", "((https|http)://)login.m.taobao.com/login.htm(.*),((https|http)://)login.tmall.com(.*),((https|http)://)login.taobao.com/member/login.jhtml(.*)"}[i2];
        LOGOUT_URLS = new String[]{"((https|http)://)login.waptest.tbsandbox.com/logout.htm(.*)", "((https|http)://)login.waptest.taobao.com/logout.htm(.*)", "((https|http)://)login.wapa.taobao.com/logout.htm(.*)", "((https|http)://)login.m.taobao.com/logout.htm(.*)"}[i2];
        bindUrl = new String[]{"http://login.waptest.tbsandbox.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.waptest.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.wapa.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s", "http://login.m.taobao.com/cooperation/bindLogin.htm?code=%s&IBB=%s&appkey=%s"}[i2];
        unbindUrl = new String[]{"https://accountlink.daily.taobao.net/sdkUnbind.htm", "https://accountlink.daily.taobao.net/sdkUnbind.htm", "https://accountlink.taobao.com/sdkUnbind.htm", "https://accountlink.taobao.com/sdkUnbind.htm"}[i2];
        qrCodeLoginUrl = new String[]{"http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.waptest.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.wapa.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin", "http://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin"}[i2];
        getQrCodeContentUrl = new String[]{"http://qrlogin.daily.taobao.net/qrcodelogin/generateNoLoginQRCode.do?lt=m", "http://qrlogin.daily.taobao.net/qrcodelogin/generateNoLoginQRCode.do?lt=m", "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m", "https://qrlogin.taobao.com/qrcodelogin/generateNoLoginQRCode.do?lt=m"}[i2];
        String str = POSTFIX_OF_SECURITY_JPG_USER_SET;
        if (str == null) {
            POSTFIX_OF_SECURITY_JPG = new String[]{"", "", "", ""}[i2];
        } else {
            POSTFIX_OF_SECURITY_JPG = str;
        }
    }

    public boolean isSaveHistoryWithSalt() {
        return this.e;
    }

    public void setAlipay3Config(SNSConfig sNSConfig) {
        this.j = sNSConfig;
    }

    public void setFullyCustomizedLoginFragment(Class<?> cls) {
        this.h = cls;
    }

    public void setMaxHistoryAccount(int i2) {
        this.d = i2;
    }

    public void setOfflineDeviceID(String str) {
        this.f = str;
    }

    public void setOrientation(int i2) {
        this.i = i2;
    }

    public void setSaveHistoryWithSalt(boolean z) {
        this.e = z;
    }

    public void setScanParams(Map<String, Object> map) {
        this.a = map;
    }

    public void setSsoToken(String str) {
        this.g = str;
    }
}
