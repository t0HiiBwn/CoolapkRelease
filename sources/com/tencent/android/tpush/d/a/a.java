package com.tencent.android.tpush.d.a;

import android.content.Context;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ProGuard */
public class a extends c {
    private String a;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "fcm";
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 4;
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("registerPush", Context.class).invoke(cls, context);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error, are you import otherpush package? " + th);
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            cls.getMethod("unregisterPush", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "unregisterPush FCM Error, are you import otherpush package? " + th);
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        String str = "";
        try {
            Class<?> cls = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
            Object invoke = cls.getMethod("getToken", Context.class).invoke(cls, context);
            String f = f(context);
            if (invoke == null || j.b(invoke.toString())) {
                return f;
            }
            str = invoke.toString();
            if (!invoke.toString().equals(f)) {
                this.a = invoke.toString();
                SharePrefsUtil.setString(context, "fcm_token", invoke.toString());
            }
            d.a(context, "OtherPushFcmImpl", "errCode : 0 , errMsg : success");
            return str;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            TLogger.ee("OtherPushFcmImpl", "getToken Error for InvocationTargetException: " + cause.getMessage());
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "getToken Error", th);
        }
    }

    private String f(Context context) {
        if (j.b(this.a)) {
            this.a = SharePrefsUtil.getString(context, "fcm_token", "");
        }
        return this.a;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        try {
            return com.tencent.android.tpush.d.a.a(context, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
        } catch (Throwable th) {
            TLogger.ee("OtherPushFcmImpl", "isConfig :" + th);
            return false;
        }
    }
}
