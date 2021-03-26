package com.ali.auth.third.core.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.ReflectionUtils;

public class DeviceInfo {
    public static String deviceId;

    private static void a(final Context context) {
        Runnable runnable;
        MemberExecutorService memberExecutorService;
        Class<?> loadClassQuietly = ReflectionUtils.loadClassQuietly("com.ta.utdid2.device.UTDevice");
        String str = null;
        if (loadClassQuietly != null) {
            try {
                Object invoke = loadClassQuietly.getMethod("getUtdid", Context.class).invoke(null, context);
                if (invoke == null) {
                    SDKLogger.e("DeviceInfo", "get utdid null");
                } else {
                    str = (String) invoke;
                }
            } catch (Exception unused) {
                SDKLogger.e("DeviceInfo", "get utdid error");
            }
        }
        if (str == null) {
            memberExecutorService = KernelContext.executorService;
            runnable = new Runnable() {
                /* class com.ali.auth.third.core.device.DeviceInfo.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DeviceInfo.deviceId = context.getSharedPreferences("auth_sdk_device", 0).getString("deviceId", "");
                        SDKLogger.e("DeviceInfo", "DeviceInfo.deviceId = " + DeviceInfo.deviceId);
                    } catch (Throwable unused) {
                    }
                }
            };
        } else {
            deviceId = str;
            SDKLogger.e("DeviceInfo", "utdid = " + str);
            memberExecutorService = KernelContext.executorService;
            runnable = new Runnable() {
                /* class com.ali.auth.third.core.device.DeviceInfo.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SharedPreferences.Editor edit = context.getSharedPreferences("auth_sdk_device", 0).edit();
                        edit.putString("deviceId", DeviceInfo.deviceId);
                        edit.apply();
                    } catch (Throwable unused) {
                    }
                }
            };
        }
        memberExecutorService.postTask(runnable);
    }

    public static void init(Context context) {
        if (TextUtils.isEmpty(deviceId)) {
            a(context);
        }
    }
}
