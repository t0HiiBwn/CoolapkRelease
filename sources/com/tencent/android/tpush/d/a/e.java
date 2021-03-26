package com.tencent.android.tpush.d.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: ProGuard */
public class e extends c {
    StringBuffer a;
    private String b;
    private Object c = null;
    private Object d = null;
    private boolean e = false;
    private int f = 0;
    private int g = 1;
    private int h = 2;
    private int i = 210;
    private int j = -1;
    private Class<?> k = null;
    private Class<?> l = null;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "oppo";
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 6;
    }

    private int b() {
        try {
            return d();
        } catch (Throwable unused) {
            TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210");
            try {
                return c();
            } catch (Throwable unused2) {
                TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_colorOS");
                this.k = null;
                this.l = null;
                TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + this.j);
                return this.j;
            }
        }
    }

    private int c() {
        this.k = Class.forName("com.coloros.mcssdk.PushManager");
        this.l = Class.forName("com.coloros.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + this.g);
        return this.g;
    }

    private int d() {
        this.k = Class.forName("com.heytap.mcssdk.PushManager");
        this.l = Class.forName("com.heytap.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + this.h);
        return this.h;
    }

    private int e() {
        this.k = Class.forName("com.heytap.msp.push.HeytapPushManager");
        this.l = Class.forName("com.heytap.msp.push.callback.ICallBackResultService");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + this.i);
        return this.i;
    }

    private Object f(Context context) {
        if (this.f == 0) {
            this.f = b();
        }
        int i2 = this.f;
        if (i2 == this.j) {
            TLogger.ww("OtherPushOppoImpl", "Missing oppo push sdk");
            return null;
        }
        if (this.d == null) {
            try {
                if (i2 == this.i) {
                    this.d = this.k.getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.k.getDeclaredMethod("init", Context.class, Boolean.TYPE).invoke(this.k, context, true);
                } else {
                    this.d = this.k.getDeclaredMethod("getInstance", new Class[0]).invoke(this.k, new Object[0]);
                }
                TLogger.i("OtherPushOppoImpl", "Get oppo pushManager instance:" + this.d);
                return this.d;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                TLogger.ee("OtherPushOppoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -155 , errMsg : " + e2.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                this.d = null;
                return this.d;
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "getImplInstance Error ", th);
                this.d = null;
                return this.d;
            }
        }
        return this.d;
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        this.a = new StringBuffer();
        if (!this.e && Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                NotificationChannel notificationChannel = new NotificationChannel("default_message", "默认通知", 4);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                    this.e = true;
                    TLogger.ii("OtherPushOppoImpl", "create oppo push channle success");
                }
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "create oppo push channle error: ", th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -150 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            }
        }
        if (j.b(d.e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppKey");
        } else if (j.b(d.f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppSecret");
        } else {
            Object f2 = f(context);
            if (f2 != null) {
                try {
                    TLogger.ii("OtherPushOppoImpl", "begin oppo register!" + d.e + " " + d.f);
                    if (this.c == null) {
                        this.c = Proxy.newProxyInstance(this.l.getClassLoader(), new Class[]{this.l}, new a(context));
                    }
                    this.k.getDeclaredMethod("register", Context.class, String.class, String.class, this.l).invoke(f2, context, d.e, d.f, this.c);
                    TLogger.ii("OtherPushOppoImpl", "registerPush oppo push channel success");
                    if (this.f >= this.h && d.g.booleanValue()) {
                        this.k.getDeclaredMethod("requestNotificationPermission", new Class[0]).invoke(f2, new Object[0]);
                    }
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushOppoImpl", "registerPush Throwable e: " + th2.getMessage());
                    StringBuffer stringBuffer2 = this.a;
                    stringBuffer2.append("errCode : -151 , errMsg : " + th2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
                }
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        Object f2 = f(context);
        if (f2 != null) {
            try {
                this.k.getDeclaredMethod("unRegister", new Class[0]).invoke(f2, new Object[0]);
                TLogger.ii("OtherPushOppoImpl", "unregisterPush oppo push channel success");
            } catch (Throwable th) {
                TLogger.ee("OtherPushOppoImpl", "unregisterPush Throwable e: " + th.getMessage());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -152 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (j.b(this.b)) {
            this.b = SharePrefsUtil.getString(context, "oppo_token", "");
        }
        return this.b;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        boolean z;
        if (j.b(d.e) || j.b(d.f)) {
            j.a(context, 6);
        }
        if (j.b(d.e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null appid");
            return false;
        } else if (j.b(d.f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null miAppkey");
            return false;
        } else {
            Object f2 = f(context);
            if (f2 != null) {
                try {
                    if (this.f == this.i) {
                        z = ((Boolean) this.k.getDeclaredMethod("isSupportPush", new Class[0]).invoke(f2, new Object[0])).booleanValue();
                    } else {
                        z = ((Boolean) this.k.getDeclaredMethod("isSupportPush", Context.class).invoke(f2, context)).booleanValue();
                    }
                    if (!z) {
                        TLogger.ee("OtherPushOppoImpl", "OPPO push api isSupportPush() returns false, the device not support for OPPO push!");
                    }
                    return z;
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                } catch (Throwable th) {
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error ", th);
                }
            }
            return false;
        }
    }

    /* compiled from: ProGuard */
    public class a implements InvocationHandler {
        private Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onRegister")) {
                if (objArr != null && objArr.length >= 2) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    String str = (String) objArr[1];
                    if (intValue == 0) {
                        TLogger.ii("OtherPushOppoImpl", "OppoPush Register success, registerId:" + str);
                        if (!j.b(str) && !str.equals(e.this.c(this.b))) {
                            e.this.b = str;
                            SharePrefsUtil.setString(this.b, "oppo_token", e.this.b);
                        }
                        d.a(this.b, "OtherPushOppoImpl", "errCode : " + intValue + " , errMsg : success");
                    } else {
                        TLogger.ww("OtherPushOppoImpl", "OppoPush Register failed, code=" + intValue + ", msg=" + str);
                        Context context = this.b;
                        StringBuffer stringBuffer = e.this.a;
                        stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                        SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                    }
                    try {
                        Intent intent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                        intent.putExtra("TPUSH.ERRORCODE", intValue);
                        intent.putExtra("other_push_token", str);
                        intent.putExtra("TPUSH.FEEDBACK", 1);
                        intent.putExtra("PUSH.CHANNEL", 105);
                        intent.setPackage(this.b.getPackageName());
                        com.tencent.android.tpush.common.d.a(this.b, intent);
                    } catch (Throwable th) {
                        TLogger.w("OtherPushOppoImpl", "OppoPush Register callback broadcast error: " + th.getMessage());
                    }
                }
            } else if (method.getName().equals("onUnRegister") && objArr != null && objArr.length >= 1) {
                int intValue2 = ((Integer) objArr[0]).intValue();
                if (intValue2 == 0) {
                    TLogger.ii("OtherPushOppoImpl", "OppoPush UnRegister success");
                } else {
                    TLogger.ww("OtherPushOppoImpl", "OppoPush UnRegister failed, code=" + intValue2);
                    Context context2 = this.b;
                    StringBuffer stringBuffer2 = e.this.a;
                    stringBuffer2.append("errCode : " + intValue2 + " , errMsg : unknown");
                    SharePrefsUtil.setString(context2, "other_push_error_code", stringBuffer2.toString());
                }
            }
            return method;
        }
    }
}
