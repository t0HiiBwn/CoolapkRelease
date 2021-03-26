package com.tencent.android.tpush.d.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ProGuard */
public class c extends com.tencent.android.tpush.d.c {
    String a;
    StringBuffer b;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "meizu";
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 2;
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        boolean z;
        if (j.b(d.c)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null appid");
        } else if (j.b(d.d)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null mzAppkey");
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
                TLogger.ii("OtherPushMZImpl", "begin Mzpush register!" + d.c + " " + d.d);
                try {
                    Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
                    cls.getMethod("register", Context.class, String.class, String.class).invoke(cls, context, d.c, d.d);
                    TLogger.ii("OtherPushMZImpl", "creat meizu push channle success");
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.b;
                    stringBuffer.append("errCode : -160 , errMsg : " + e.getLocalizedMessage());
                    SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error ", th);
                    StringBuffer stringBuffer2 = this.b;
                    stringBuffer2.append("errCode : -161 , errMsg : " + th.getLocalizedMessage());
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
            Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
            Method method = cls.getMethod("unRegister", Context.class, String.class, String.class);
            TLogger.i("OtherPushMZImpl", "begin Mzpush unregister!" + d.c + " " + d.d);
            method.invoke(cls, context, d.c, d.d);
            TLogger.ii("OtherPushMZImpl", "unregisterPush meizu push channle success");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -162 , errMsg : " + e.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
        } catch (Throwable th) {
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error, are you import otherpush package? " + th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -163 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (this.b == null) {
            this.b = new StringBuffer();
        }
        try {
            Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
            Object invoke = cls.getMethod("getPushId", Context.class).invoke(cls, context);
            String f = f(context);
            if (invoke == null || j.b(invoke.toString()) || invoke.toString().equals(f)) {
                return f;
            }
            this.a = invoke.toString();
            SharePrefsUtil.setString(context, "meizu_token", invoke.toString());
            return this.a;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushMZImpl", "meizu getToken Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.b;
            stringBuffer.append("errCode : -164 , errMsg : " + e.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            return "";
        } catch (Throwable th) {
            TLogger.ee("OtherPushMZImpl", "meizu getToken Error", th);
            StringBuffer stringBuffer2 = this.b;
            stringBuffer2.append("errCode : -165 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
            return "";
        }
    }

    private String f(Context context) {
        if (j.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "meizu_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        if (j.b(d.c) || j.b(d.d)) {
            j.a(context, 2);
        }
        if (j.b(d.c) || j.b(d.d)) {
            j.k(context);
        }
        if (!j.b(d.c) && !j.b(d.d)) {
            return true;
        }
        return false;
    }
}
