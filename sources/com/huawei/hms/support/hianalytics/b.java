package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.Map;

/* compiled from: HiAnalyticsInnerClient */
public class b extends a {
    public static void a(Context context, String str, String str2, String str3, String str4) {
        Map<String, String> mapForBi = getMapForBi(context, str);
        mapForBi.put("appid", str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = TransactionIdCreater.getId(str2, str);
        }
        mapForBi.put("transId", str3);
        mapForBi.put("direction", "req");
        if (!TextUtils.isEmpty(str4)) {
            mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(str4));
        }
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_API_CALLED", mapForBi);
    }

    public static void a(Context context, ResponseHeader responseHeader, String str) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", "rsp");
        if (!TextUtils.isEmpty(str)) {
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(str));
        }
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_API_CALLED", mapFromRequestHeader);
    }
}
