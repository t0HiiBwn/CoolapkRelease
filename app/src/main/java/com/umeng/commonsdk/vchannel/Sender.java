package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.e("MobclickRT", "--->>> Sender: onEvent: context is null.");
        } else if (TextUtils.isEmpty(str)) {
            UMRTLog.e("MobclickRT", "--->>> Sender: onEvent: eventID is null or an empty string.");
        } else if (map == null) {
            UMRTLog.e("MobclickRT", "--->>> Sender: onEvent: map is null.");
        } else if (!UMFrUtils.isOnline(context)) {
            UMRTLog.e("MobclickRT", "--->>> Sender: onEvent: Network unavailable.");
        } else if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.e("MobclickRT", "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
        } else {
            b bVar = new b(context);
            bVar.a(str);
            bVar.a(System.currentTimeMillis());
            bVar.a(map);
            try {
                UMWorkDispatch.sendEvent(context, 32779, b.a(context).a(), bVar);
            } catch (Throwable unused) {
            }
            lastTriggerTime = System.currentTimeMillis();
        }
    }

    public static void handleEvent(Context context, b bVar) {
        if (context == null) {
            UMRTLog.e("MobclickRT", "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("v_sdk_v", "1.0.0");
                Map<String, String> map = customHeader;
                if (map != null && map.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", bVar.d());
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, a.c, "v", "1.0.0");
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }
}
