package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

/* compiled from: ProGuard */
public class StatHelper {
    public static void reportErrCode(Context context, int i, String str, long j, String str2) {
        TBaseLogger.i("StatHelper", "action - reportErrCode, errCode:" + i + ", msg:" + str + ", req:" + j);
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
            cls.getDeclaredMethod("reportErrCode", Context.class, Integer.TYPE, String.class, Long.TYPE, String.class).invoke(cls, context, Integer.valueOf(i), str, Long.valueOf(j), str2);
        } catch (Throwable th) {
            TBaseLogger.ww("StatHelper", "unexpected for reportErrCode, exception:", th);
        }
    }

    public static void reportCloudControl(Context context, long j, int i, String str, long j2) {
        TBaseLogger.i("StatHelper", "action - reportCloudControl, cloudVersion:" + j + ", msg:" + str + ", req:" + j2);
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
            cls.getDeclaredMethod("reportCloudControl", Context.class, Long.TYPE, Integer.TYPE, String.class, Long.TYPE).invoke(cls, context, Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2));
        } catch (Throwable th) {
            TBaseLogger.ww("StatHelper", "unexpected for reportCloudControl, exception:", th);
        }
    }
}
