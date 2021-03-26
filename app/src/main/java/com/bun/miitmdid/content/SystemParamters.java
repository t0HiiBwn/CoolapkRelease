package com.bun.miitmdid.content;

import com.bun.miitmdid.content.ProviderList;
import com.netease.nis.sdkwrapper.Utils;

public class SystemParamters {
    private static volatile SystemParamters g_insans;
    private String mf;
    private String sdk_version = "10025";
    private String sdk_vname = "1.0.25";

    private SystemParamters() {
    }

    public static ProviderList.DEVICE_PROVIDER checkDeviceSystem() {
        Object[] objArr = new Object[3];
        objArr[1] = 13;
        objArr[2] = 1606976968485L;
        return (ProviderList.DEVICE_PROVIDER) Utils.rL(objArr);
    }

    public static SystemParamters getIns() {
        Object[] objArr = new Object[3];
        objArr[1] = 14;
        objArr[2] = 1606976968486L;
        return (SystemParamters) Utils.rL(objArr);
    }

    public static String getSysProperty(String str, String str2) {
        Object[] objArr = new Object[5];
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = 15;
        objArr[4] = 1606976968487L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isFreeMeOS() {
        Object[] objArr = new Object[3];
        objArr[1] = 16;
        objArr[2] = 1606976968488L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    private static boolean isSsuiOS() {
        Object[] objArr = new Object[3];
        objArr[1] = 17;
        objArr[2] = 1606976968489L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    public String getMf() {
        return (String) Utils.rL(new Object[]{this, 18, 1606976968490L});
    }

    public String getSdkVersion() {
        return (String) Utils.rL(new Object[]{this, 19, 1606976968491L});
    }

    public String getSdkVname() {
        return (String) Utils.rL(new Object[]{this, 20, 1606976968492L});
    }
}
