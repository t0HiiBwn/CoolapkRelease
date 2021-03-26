package com.tencent.android.tpush.d.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ProGuard */
public class d extends c {
    String a;
    StringBuffer b;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "xiaomi";
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 1;
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        boolean z;
        if (j.b(com.tencent.android.tpush.d.d.a)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null appid");
        } else if (j.b(com.tencent.android.tpush.d.d.b)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null miAppkey");
        } else {
            this.b = new StringBuffer();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            String packageName = context.getPackageName();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                z = false;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                try {
                    Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
                    Method method = cls.getMethod("registerPush", Context.class, String.class, String.class);
                    TLogger.i("OtherPushMiImpl", "begin Mipush register!" + com.tencent.android.tpush.d.d.a + " " + com.tencent.android.tpush.d.d.b);
                    method.invoke(cls, context, com.tencent.android.tpush.d.d.a, com.tencent.android.tpush.d.d.b);
                    TLogger.ii("OtherPushMiImpl", "registerPush xm push channle success");
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.b;
                    stringBuffer.append("errCode : -130 , errMsg : " + e.getLocalizedMessage());
                    SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error ", th);
                    StringBuffer stringBuffer2 = this.b;
                    stringBuffer2.append("errCode : -131 , errMsg : " + th.getLocalizedMessage());
                    SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
                }
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            cls.getMethod("unregisterPush", Context.class).invoke(cls, context);
            TLogger.ii("OtherPushMiImpl", "unregisterPush xm push channle success");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -132 , errMsg : " + e.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
        } catch (Throwable th) {
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error, are you import otherpush package? " + th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -133 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
            Object invoke = cls.getMethod("getRegId", Context.class).invoke(cls, context);
            String f = f(context);
            if (invoke == null || j.b(invoke.toString()) || invoke.toString().equals(f)) {
                return f;
            }
            this.a = invoke.toString();
            SharePrefsUtil.setString(context, "xiaomi_token", invoke.toString());
            return this.a;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushMiImpl", "xm getToken Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -134 , errMsg : " + e.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            return "";
        } catch (Throwable th) {
            TLogger.ee("OtherPushMiImpl", "xm getToken Error", th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -135 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
            return "";
        }
    }

    private String f(Context context) {
        if (j.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "xiaomi_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        if (j.b(com.tencent.android.tpush.d.d.a) || j.b(com.tencent.android.tpush.d.d.b)) {
            j.a(context, 1);
        }
        if (j.b(com.tencent.android.tpush.d.d.a) || j.b(com.tencent.android.tpush.d.d.b)) {
            j.k(context);
        }
        if (!j.b(com.tencent.android.tpush.d.d.a) && !j.b(com.tencent.android.tpush.d.d.b)) {
            return true;
        }
        return false;
    }
}
