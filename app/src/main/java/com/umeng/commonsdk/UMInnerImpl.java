package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ao;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.d;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.b;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.i;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;

public class UMInnerImpl {
    private static boolean isInternal;

    private static synchronized void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() {
                        /* class com.umeng.commonsdk.UMInnerImpl.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                    try {
                                        d.b(context);
                                    } catch (Throwable th) {
                                        ULog.e("internal", "e is " + th);
                                    }
                                }
                            } catch (Throwable th2) {
                                UMCrashManager.reportCrash(context, th2);
                            }
                        }
                    }).start();
                    isInternal = true;
                } catch (Throwable th) {
                    ULog.e("internal", "e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return;
    }

    public static synchronized void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() {
                            /* class com.umeng.commonsdk.UMInnerImpl.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                        try {
                                            if (FieldManager.allow("inner_lbs")) {
                                                ao.a(context);
                                            }
                                        } catch (Throwable th) {
                                            ULog.e("internal", "e is " + th);
                                        }
                                        try {
                                            if (!c.a(context).a()) {
                                                c.a(context).b();
                                            }
                                        } catch (Throwable th2) {
                                            ULog.e("internal", "e is " + th2);
                                        }
                                        try {
                                            k.b(context);
                                        } catch (Throwable th3) {
                                            ULog.e("internal", "e is " + th3);
                                        }
                                        try {
                                            a.d(context);
                                        } catch (Throwable th4) {
                                            ULog.e("internal", "e is " + th4);
                                        }
                                        try {
                                            if (FieldManager.allow("inner_sr")) {
                                                UMRTLog.i("MobclickRT", "--->>> 采集sensor数据, 已使能");
                                                i.b(context);
                                            } else {
                                                UMRTLog.i("MobclickRT", "--->>> 采集sensor数据, 未使能");
                                            }
                                        } catch (Throwable th5) {
                                            ULog.e("internal", "e is " + th5);
                                        }
                                        try {
                                            if (!b.a(context).a()) {
                                                b.a(context).b();
                                            }
                                        } catch (Throwable unused) {
                                            ULog.e("internal", "get station is null ");
                                        }
                                    }
                                } catch (Throwable th6) {
                                    UMCrashManager.reportCrash(context, th6);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } catch (Throwable th) {
                    ULog.e("internal", "e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return;
    }
}
