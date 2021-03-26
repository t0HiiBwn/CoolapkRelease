package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

public class LoggerFactory {
    private static final String CLASS_NAME = "LoggerFactory";
    public static final String MQTT_CLIENT_MSG_CAT = "com.tencent.android.tpns.mqtt.internal.nls.logcat";
    private static String jsr47LoggerClassName = JSR47Logger.class.getName();
    private static String overrideloggerClassName;

    public static String getLoggingProperty(String str) {
        return null;
    }

    public static Logger getLogger(String str, String str2) {
        return new MLogger();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:5:? A[ExcHandler: ClassNotFoundException | NoClassDefFoundError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:2:0x0007] */
    private static Logger getLogger(String str, ResourceBundle resourceBundle, String str2, String str3) {
        Class<?> cls = Class.forName(str);
        if (cls == null) {
            return null;
        }
        try {
            Logger logger = (Logger) cls.newInstance();
            logger.initialise(resourceBundle, str2, str3);
            return logger;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
    }

    public static void setLogger(String str) {
        overrideloggerClassName = str;
    }
}
