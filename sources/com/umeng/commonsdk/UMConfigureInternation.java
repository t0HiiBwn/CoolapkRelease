package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.statistics.common.ULog;

public class UMConfigureInternation {
    private static boolean isInternal;

    public static synchronized void sendInternal(final Context context) {
        synchronized (UMConfigureInternation.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() {
                            /* class com.umeng.commonsdk.UMConfigureInternation.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName) && UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                                        Context context = context;
                                        UMWorkDispatch.sendEvent(context, 32777, b.a(context).a(), null);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }).start();
                        isInternal = true;
                    }
                } catch (Throwable th) {
                    ULog.e("internal", "e is " + th.getMessage());
                }
            }
        }
        return;
    }

    public static void doSelfCheck(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                UMWorkDispatch.sendEvent(context, 32801, b.a(context).a(), null);
            }
        } catch (Throwable unused) {
        }
    }
}
