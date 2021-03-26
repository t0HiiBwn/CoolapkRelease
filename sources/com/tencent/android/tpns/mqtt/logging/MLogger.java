package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public class MLogger implements Logger {
    private static final String TAG = "MLogger";

    private void log(String str) {
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void dumpTrace() {
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public String formatMessage(String str, Object[] objArr) {
        return "";
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public boolean isLoggable(int i) {
        return false;
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void setResourceName(String str) {
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void severe(String str, String str2, String str3) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void severe(String str, String str2, String str3, Object[] objArr) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void severe(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("server - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void warning(String str, String str2, String str3) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void warning(String str, String str2, String str3, Object[] objArr) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void warning(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("warning - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void info(String str, String str2, String str3) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void info(String str, String str2, String str3, Object[] objArr) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void info(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("info - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void config(String str, String str2, String str3) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void config(String str, String str2, String str3, Object[] objArr) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void config(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("config - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void fine(String str, String str2, String str3) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void fine(String str, String str2, String str3, Object[] objArr) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("fine - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finer(String str, String str2, String str3) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finer(String str, String str2, String str3, Object[] objArr) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finer(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("finer - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finest(String str, String str2, String str3) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finest(String str, String str2, String str3, Object[] objArr) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void finest(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("finest - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void log(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("log - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }

    @Override // com.tencent.android.tpns.mqtt.logging.Logger
    public void trace(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        log("trace - sourceClass:" + str + ", sourceMethod:" + str2 + ", msg:" + str3);
    }
}
