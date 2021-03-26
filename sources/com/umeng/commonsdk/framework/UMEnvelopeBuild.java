package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.h;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    public static boolean isOnline(Context context) {
        boolean z = !UMConfigure.needSendZcfgEnv(context);
        if (!UMFrUtils.isOnline(context) || !z) {
            return false;
        }
        return true;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (!getTransmissionSendFlag()) {
            return false;
        }
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L_0x002d;
     */
    private static boolean isRet(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType, boolean z) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            boolean isOnline = UMFrUtils.isOnline(applicationContext);
            int envelopeFileNumber = UMFrUtils.envelopeFileNumber(applicationContext);
            if (isOnline) {
                if (uMBusinessType != UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
                    if (a.a()) {
                        UMWorkDispatch.sendDelayProcessMsg((long) a.b());
                    } else if (!UMFrUtils.hasEnvelopeFile(applicationContext, uMBusinessType)) {
                    }
                    z = false;
                }
                z = true;
            }
            if (isOnline && envelopeFileNumber > 0) {
                a.d();
            }
        }
        return z;
    }

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        h a = h.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_tp", str2);
        contentValues.put("_hd", a.c(jSONObject.toString()));
        contentValues.put("_bd", a.c(jSONObject2.toString()));
        contentValues.put("_ts", String.valueOf(currentTimeMillis));
        contentValues.put("_uuid", randomUUID.toString());
        contentValues.put("_re1", str);
        contentValues.put("_re2", str3);
        bc.a(context).a("stf", contentValues);
        if ("i".equalsIgnoreCase(str2)) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if ("s".equalsIgnoreCase(str2)) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException unused) {
            }
        } else if (!"p".equalsIgnoreCase(str2)) {
            if ("st".equalsIgnoreCase(str2)) {
                UMRTLog.e("MobclickRT", "--->>> [有状态]统计业务 半开报文，返回body。");
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("header", new JSONObject());
                    jSONObject4.put("analytics", jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                } catch (JSONException unused2) {
                    return jSONObject2;
                }
            } else {
                UMRTLog.e("MobclickRT", "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("header", new JSONObject());
                jSONObject5.put("analytics", jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            }
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject.has("st")) {
            str = "t";
        } else {
            str = jSONObject2.has("inner") ? "i" : "a";
        }
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, str, "9.3.3");
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        UMRTLog.e("MobclickRT", "--->>> [有状态]业务发起构建普通有状态信封请求。");
        JSONObject jSONObject3 = null;
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 121);
                    return jSONObject4;
                } catch (JSONException unused) {
                    jSONObject3 = jSONObject4;
                }
            } catch (JSONException unused2) {
                return jSONObject3;
            }
        } else if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("exception", 120);
                    return jSONObject5;
                } catch (JSONException unused3) {
                    jSONObject3 = jSONObject5;
                }
            } catch (JSONException unused4) {
                return jSONObject3;
            }
        } else if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        } else {
            UMRTLog.e("MobclickRT", "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
            if (bc.a(context).c()) {
                UMRTLog.e("MobclickRT", "--->>> [有状态]二级缓存为空，直接打信封");
                return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.e("MobclickRT", "--->>> [有状态]二级缓存不为空，写入二级缓存");
            JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            if (!UMWorkDispatch.eventHasExist(32785)) {
                UMWorkDispatch.sendEvent(context, 32785, com.umeng.commonsdk.internal.b.a(context).a(), null);
            }
            return add2CacheTable;
        }
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (UMUtils.isMainProgress(context)) {
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (JSONException unused) {
                jSONObject3 = jSONObject4;
            }
        } catch (JSONException unused2) {
            return jSONObject3;
        }
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0;
        }
        return b.a(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z;
        synchronized (UMEnvelopeBuild.class) {
            z = transmissionSendFlag;
        }
        return z;
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z;
        }
    }
}
