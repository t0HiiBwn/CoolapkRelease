package com.tencent.tpns.dataacquisition;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.tpns.dataacquisition.a.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceInfos {
    public static final byte NETWORK_TYPE_2G = 2;
    public static final byte NETWORK_TYPE_3G = 3;
    public static final byte NETWORK_TYPE_4G = 4;
    public static final byte NETWORK_TYPE_UNCONNECTED = -1;
    public static final byte NETWORK_TYPE_UNKNOWN = 0;
    public static final byte NETWORK_TYPE_WIFI = 1;

    public static int checkBluetooth(Context context) {
        return a.k(context);
    }

    public static boolean checkHasBluetooth(Context context) {
        return a.l(context);
    }

    public static boolean checkHasLightSensor(Context context) {
        return a.m(context);
    }

    public static boolean checkSimulator(Context context) {
        return a.n(context);
    }

    public static String getBootTime() {
        return a.h();
    }

    public static String getCarrierInfo(Context context) {
        return a.w(context);
    }

    public static int getChangedStatus(Context context) {
        return a.u(context);
    }

    public static JSONObject getCpuInfo(Context context) {
        return a.q(context);
    }

    public static String getCpuString() {
        return a.b();
    }

    public static String getCpuType() {
        return a.c();
    }

    public static String getDeviceModel(Context context) {
        return a.g(context);
    }

    public static String getDeviceName(Context context) {
        return a.v(context);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return a.f(context);
    }

    public static String getExternalStorageInfo(Context context) {
        return a.j(context);
    }

    public static String getLinkedWay(Context context) {
        return a.e(context);
    }

    public static byte getNetworkType(Context context) {
        return a.c(context);
    }

    public static String getRomMemory() {
        return a.d();
    }

    public static JSONArray getSensorsJson(Context context) {
        return a.s(context);
    }

    public static String getSensorsString(Context context) {
        return a.r(context);
    }

    public static String getSimulatorModel(Context context) {
        return a.o(context);
    }

    public static String getSysFileTime() {
        return a.i();
    }

    public static String getSystemMemory(Context context) {
        return a.p(context);
    }

    public static Integer getTelephonyNetworkType(Context context) {
        return a.a(context);
    }

    public static long getTotalInternalMemorySize() {
        return a.e();
    }

    public static long getTotalMemory() {
        return a.f();
    }

    public static int hasRootAccess(Context context) {
        return a.i(context);
    }

    public static boolean haveGravity(Context context) {
        return a.h(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        return a.b(context);
    }

    public static boolean isSDCardMounted() {
        return a.g();
    }

    public static boolean isScreenOn(Context context) {
        return a.t(context);
    }

    public static boolean isWifiNet(Context context) {
        return a.d(context);
    }
}
