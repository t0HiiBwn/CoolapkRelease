package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class HiAnalyticsClient extends a {
    @Deprecated
    public static String reportEntry(Context context, String str) {
        return reportEntry(context, str, Util.getAppId(context), 0);
    }

    public static String reportEntry(Context context, String str, int i) {
        return reportEntry(context, str, Util.getAppId(context), i);
    }

    public static String reportEntry(Context context, String str, String str2, int i) {
        String id = TransactionIdCreater.getId(str2, str);
        Map<String, String> mapForBi = getMapForBi(context, str);
        mapForBi.put("appid", str2);
        mapForBi.put("transId", id);
        mapForBi.put("direction", "req");
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i)));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_KIT_API_CALLED", mapForBi);
        return id;
    }

    public static void reportExit(Context context, String str, String str2, int i, int i2) {
        reportExit(context, str, str2, Util.getAppId(context), i, i2, 0);
    }

    public static void reportExit(Context context, String str, String str2, int i, int i2, int i3) {
        reportExit(context, str, str2, Util.getAppId(context), i, i2, i3);
    }

    public static void reportExit(Context context, String str, String str2, String str3, int i, int i2, int i3) {
        Map<String, String> mapForBi = getMapForBi(context, str);
        mapForBi.put("appid", str3);
        mapForBi.put("transId", str2);
        mapForBi.put("direction", "rsp");
        mapForBi.put("statusCode", String.valueOf(i));
        mapForBi.put("result", String.valueOf(i2));
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i3)));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_KIT_API_CALLED", mapForBi);
    }
}
