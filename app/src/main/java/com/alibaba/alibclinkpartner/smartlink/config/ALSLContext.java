package com.alibaba.alibclinkpartner.smartlink.config;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.a;

public class ALSLContext {
    private static volatile int environment = 1;
    public String ALSLSDKVersion;
    public String TTID;
    public String appName;
    public String appVersion;
    public String appkey;
    public boolean disableSmartLink;
    public String imei;
    private volatile boolean init;
    public Application mApplication;
    public Context mContext;
    public String packageName;
    public String tempVal;

    private static class SingletonHolder {
        private static ALSLContext instance = new ALSLContext();

        private SingletonHolder() {
        }
    }

    private ALSLContext() {
        this.ALSLSDKVersion = "4.0.0";
        this.disableSmartLink = false;
        this.init = false;
    }

    private String getDefaultTTID(String str) {
        return (str == null || TextUtils.isEmpty(str.trim())) ? "" : String.format("2019_0_%s@baichuan_android_%s_smartlink", str, this.ALSLSDKVersion);
    }

    public static int getEnvironment() {
        return environment;
    }

    public static ALSLContext instance() {
        return SingletonHolder.instance;
    }

    public static void setEnvironment(int i) {
        environment = i;
    }

    public void initContext(Application application, String str) {
        this.appkey = str;
        this.mContext = application;
        this.mApplication = application;
        this.packageName = application.getPackageName();
        this.imei = a.a(application);
        this.TTID = getDefaultTTID(str);
        this.appName = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()).toString();
        try {
            this.appVersion = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Exception e) {
            ALSLLogUtil.d("ALSLContext", "initContext", "获取appversion异常：" + e.getMessage());
            e.printStackTrace();
        }
        ALSLLogUtil.d("ALSLContext", "initContext", "appKey = " + this.appkey + "packageName = " + this.packageName + "imei = " + this.imei + "TTID = " + this.TTID + "appName = " + this.appName + "appVersion = " + this.appVersion);
    }

    public boolean isInit() {
        return this.init;
    }

    public void setDisableSmartLink(boolean z) {
        this.disableSmartLink = z;
    }

    public void setInit(boolean z) {
        this.init = z;
    }
}
