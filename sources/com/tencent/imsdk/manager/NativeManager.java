package com.tencent.imsdk.manager;

import android.os.Build;
import com.tencent.imsdk.TIMBackgroundParam;
import com.tencent.imsdk.TIMLogListener;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserStatusListener;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.session.IConnectionListener;

public class NativeManager {
    private static final String TAG = "NativeManager";

    protected static native void nativeDoBackground(int i, TIMBackgroundParam tIMBackgroundParam, ICallback iCallback);

    protected static native void nativeDoForeground(int i, ICallback iCallback);

    private static native void nativeEnableConsole(boolean z);

    static native long nativeGetClockTickInHz();

    protected static native String nativeGetIdentifier();

    protected static native void nativeGetOfflinePushConfig(ICallback iCallback);

    public static native long nativeGetServerTime();

    public static native long nativeGetServerTimeDiff();

    static native long nativeGetTimeTick();

    protected static native long nativeGetTinyid();

    protected static native String nativeGetVersion();

    protected static native void nativeInitSdk(long j, String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2, boolean z3);

    public static native int nativeInitStorage(String str, ICallback iCallback);

    protected static native void nativeLogin(String str, String str2, boolean z, ICallback iCallback);

    protected static native void nativeLogout(ICallback iCallback);

    public static native void nativeOnNetworkChanged(boolean z);

    public static native void nativeReduceUnreadNumberWhenRemoveMessage();

    private static native void nativeSetCallbackLogLevel(int i);

    public static native void nativeSetCustomVersion(String str);

    private static native void nativeSetLogLevel(int i);

    private static native void nativeSetLogListener(TIMLogListener tIMLogListener);

    protected static native void nativeSetOfflinePushConfig(int i, String str, String str2, String str3, ICallback iCallback);

    public static native void nativeSetOnlyDNSSource();

    protected static native void nativeSetToken(int i, int i2, String str, ICallback iCallback);

    protected static native void nativeSetUserConfig(TIMUserConfig tIMUserConfig);

    protected static native void nativeUnInitSdk();

    public static void onNetworkStatusChanged(int i, int i2, String str) {
        String str2 = TAG;
        QLog.i(str2, "onNetworkStatusChanged Enter; type:" + i + " code:" + i2 + " errMsg:" + str);
        IConnectionListener connectionListener = BaseManager.getInstance().getConnectionListener();
        if (connectionListener == null) {
            QLog.w(str2, "onNetworkStatusChanged IConnectionListener == null");
        } else if (i == 1) {
            connectionListener.onConnected();
        } else if (i == 2) {
            connectionListener.onConnecting();
        } else if (i == 3) {
            connectionListener.onDisconnected(i2, str);
        } else if (i != 4) {
            QLog.e(str2, "onNetworkStatusChanged, unknown type: " + i);
        } else {
            connectionListener.onConnectFailed(i2, str);
        }
    }

    public static void onForceOffline() {
        String str = TAG;
        QLog.i(str, "onForceOffline Enter");
        TIMUserStatusListener tIMUserStatusListener = BaseManager.getInstance().getTIMUserStatusListener();
        if (tIMUserStatusListener == null) {
            QLog.w(str, "onForceOffline userStatusListener == null");
        } else {
            tIMUserStatusListener.onForceOffline();
        }
    }

    public static void onUserSigExpired() {
        String str = TAG;
        QLog.i(str, "onUserSigExpired Enter");
        TIMUserStatusListener tIMUserStatusListener = BaseManager.getInstance().getTIMUserStatusListener();
        if (tIMUserStatusListener == null) {
            QLog.w(str, "onUserSigExpired userStatusListener == null");
        } else {
            tIMUserStatusListener.onUserSigExpired();
        }
    }

    public static int getNetType() {
        return NetConnectInfoCenter.getInstance().getNetworkType();
    }

    public static String getNetID() {
        return NetConnectInfoCenter.getInstance().getNetID();
    }

    public static int getIPvXType() {
        return NetConnectInfoCenter.getInstance().getIPvXType();
    }

    private static String getDevType() {
        return Build.BRAND + "(" + Build.MODEL + ")";
    }

    private static String getDevSysVersion() {
        return Build.VERSION.RELEASE;
    }

    private static float getAppMemoryUsage() {
        return IMSystemUtil.getAppMemory();
    }

    private static float getSysCpuUsage() {
        return IMSystemUtil.getSysCpuUsage();
    }

    private static float getAppCpuUsage() {
        return IMSystemUtil.getAppCpuUsage();
    }

    public static void initNativeLog(int i, int i2, boolean z, TIMLogListener tIMLogListener) {
        nativeSetLogLevel(i);
        nativeSetCallbackLogLevel(i2);
        nativeEnableConsole(z);
        if (tIMLogListener != null) {
            nativeSetLogListener(tIMLogListener);
        }
    }
}
