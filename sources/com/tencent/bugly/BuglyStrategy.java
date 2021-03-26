package com.tencent.bugly;

import java.util.Map;

/* compiled from: BUGLY */
public class BuglyStrategy {
    protected int a = 31;
    protected boolean b = false;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;
    private boolean i = true;
    private boolean j = true;
    private boolean k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1430l = true;
    private Class<?> m = null;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private boolean q = false;
    private a r;

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.n = z;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.q = z;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.p = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.p;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.n;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.q;
    }

    public boolean isReplaceOldChannel() {
        return this.o;
    }

    public void setReplaceOldChannel(boolean z) {
        this.o = z;
    }

    public synchronized String getAppVersion() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().k;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.c = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.m = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.m;
    }

    public synchronized String getAppChannel() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().m;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.d = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        return com.tencent.bugly.crashreport.common.info.a.b().c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.e = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f = j2;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.g;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.g = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.h;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.h = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.i;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f1430l = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f1430l;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.k;
    }

    public void setEnableCatchAnrTrace(boolean z) {
        this.k = z;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.j;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.j = z;
        return this;
    }

    public synchronized a getCrashHandleCallback() {
        return this.r;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.r = aVar;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.a = i2;
    }

    public synchronized int getCallBackType() {
        return this.a;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.b = z;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    /* compiled from: BUGLY */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }
}
