package com.tencent.imsdk;

import android.text.TextUtils;

public class TIMSdkConfig {
    private String appidAt3rd = "0";
    private boolean isLogPrintEnabled = true;
    private int logCallbackLevel = 4;
    private int logLevel = 4;
    private TIMLogListener logListener;
    private String logPath = "";
    private int sdkAppId;
    private boolean testEnv = false;

    public TIMSdkConfig(int i) {
        this.sdkAppId = i;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String getAppidAt3rd() {
        return this.appidAt3rd;
    }

    public TIMSdkConfig setAppidAt3rd(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.appidAt3rd = str;
        return this;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public TIMSdkConfig setLogPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.logPath = str;
        return this;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public TIMSdkConfig setLogLevel(int i) {
        this.logLevel = i;
        return this;
    }

    public int getLogCallbackLevel() {
        return this.logCallbackLevel;
    }

    public TIMSdkConfig setLogCallbackLevel(int i) {
        this.logCallbackLevel = i;
        return this;
    }

    public TIMLogListener getLogListener() {
        return this.logListener;
    }

    public TIMSdkConfig setLogListener(TIMLogListener tIMLogListener) {
        this.logListener = tIMLogListener;
        return this;
    }

    public boolean isLogPrintEnabled() {
        return this.isLogPrintEnabled;
    }

    public TIMSdkConfig enableLogPrint(boolean z) {
        this.isLogPrintEnabled = z;
        return this;
    }

    public boolean isTestEnv() {
        return this.testEnv;
    }

    public void setTestEnv(boolean z) {
        this.testEnv = z;
    }

    public String toString() {
        return "sdkAppid=" + this.sdkAppId + ";appid=" + this.appidAt3rd + ";logPath=" + this.logPath + ";logCallbackLevel=" + this.logCallbackLevel + ";logLevel=" + this.logLevel + ";logPrintEnabled=" + this.isLogPrintEnabled;
    }
}
