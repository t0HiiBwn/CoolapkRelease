package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.u;

/* compiled from: TTMultiInitHelper */
public class d {
    public static void a(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            a.a(context.getApplicationContext());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    int myPid = Process.myPid();
                    String str = context.getPackageName() + myPid;
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            str = runningAppProcessInfo.processName;
                        }
                    }
                    SSWebView.setDataDirectorySuffix(str);
                } catch (Exception e) {
                    try {
                        SSWebView.setDataDirectorySuffix(packageName);
                    } catch (Exception unused) {
                    }
                    u.b(e.toString());
                }
            }
        }
    }
}
