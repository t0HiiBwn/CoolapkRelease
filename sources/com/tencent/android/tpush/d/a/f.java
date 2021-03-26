package com.tencent.android.tpush.d.a;

import android.content.Context;
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
public class f extends c {
    StringBuffer a;
    private Object b = null;
    private Class<?> c = null;
    private Class<?> d = null;
    private String e;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "vivo";
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 7;
    }

    private Object f(Context context) {
        try {
            Class<?> cls = Class.forName("com.vivo.push.PushClient");
            this.c = cls;
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(this.c, context.getApplicationContext());
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
            return null;
        } catch (Throwable th) {
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error ", th);
            return null;
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        this.a = new StringBuffer();
        Object f = f(context);
        if (f != null) {
            try {
                if (this.c == null) {
                    this.c = Class.forName("com.vivo.push.PushClient");
                }
                this.c.getDeclaredMethod("initialize", new Class[0]).invoke(f, new Object[0]);
                if (this.b == null) {
                    this.d = Class.forName("com.vivo.push.IPushActionListener");
                    this.b = Proxy.newProxyInstance(this.d.getClassLoader(), new Class[]{this.d}, new a(context));
                }
                if (this.d == null) {
                    this.d = Class.forName("com.vivo.push.IPushActionListener");
                }
                this.c.getDeclaredMethod("turnOnPush", this.d).invoke(f, this.b);
                TLogger.ii("OtherPushVivoImpl", "registerPush vivo push channel success");
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "registerPush Throwable e: " + th.getMessage(), th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -140 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        Object f = f(context);
        if (f != null) {
            try {
                if (this.b == null) {
                    this.d = Class.forName("com.vivo.push.IPushActionListener");
                    this.b = Proxy.newProxyInstance(this.d.getClassLoader(), new Class[]{this.d}, new a(context));
                }
                if (this.d == null) {
                    this.d = Class.forName("com.vivo.push.IPushActionListener");
                }
                if (this.c == null) {
                    this.c = Class.forName("com.vivo.push.PushClient");
                }
                this.c.getDeclaredMethod("turnOffPush", this.d).invoke(f, this.b);
                TLogger.ii("OtherPushVivoImpl", "unregisterPush vivo push channel success");
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "unregisterPush Throwable e: " + th.getMessage(), th);
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -143 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (this.a == null) {
            this.a = new StringBuffer();
        }
        Object f = f(context);
        if (f != null) {
            try {
                Object invoke = Class.forName("com.vivo.push.PushClient").getDeclaredMethod("getRegId", new Class[0]).invoke(f, new Object[0]);
                String g = g(context);
                if (invoke == null || j.b(invoke.toString()) || invoke.toString().equals(g)) {
                    return g;
                }
                String obj = invoke.toString();
                this.e = obj;
                SharePrefsUtil.setString(context, "vivo_token", obj);
                return this.e;
            } catch (InvocationTargetException e2) {
                TLogger.e("OtherPushVivoImpl", "getRegId Error for InvocationTargetException: ", e2.getCause());
                StringBuffer stringBuffer = this.a;
                stringBuffer.append("errCode : -141 , errMsg : " + e2.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "getRegId Error ", th);
                StringBuffer stringBuffer2 = this.a;
                stringBuffer2.append("errCode : -142 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
            }
        }
        return "";
    }

    private String g(Context context) {
        if (j.b(this.e)) {
            this.e = SharePrefsUtil.getString(context, "vivo_token", "");
        }
        return this.e;
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        Object f = f(context);
        if (f != null) {
            try {
                boolean booleanValue = ((Boolean) Class.forName("com.vivo.push.PushClient").getDeclaredMethod("isSupport", new Class[0]).invoke(f, new Object[0])).booleanValue();
                if (!booleanValue) {
                    TLogger.e("OtherPushVivoImpl", "vivo push api isSupport() returns false, the device not support for vivo push!");
                }
                return booleanValue;
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                TLogger.e("OtherPushVivoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                cause.printStackTrace();
            } catch (Throwable th) {
                TLogger.e("OtherPushVivoImpl", "isConfig Error ", th);
            }
        }
        return false;
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
            if (method.getName().equals("onStateChanged") && objArr != null && objArr.length > 0) {
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue == 0) {
                    TLogger.ii("OtherPushVivoImpl", "vivoPush Register or UnRegister success, code = " + intValue);
                    d.a(this.b, "OtherPushVivoImpl", "errCode : " + intValue + " , errMsg : success");
                } else {
                    TLogger.ww("OtherPushVivoImpl", "vivoPush Register or UnRegister fail, code = " + intValue);
                    Context context = this.b;
                    StringBuffer stringBuffer = f.this.a;
                    stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                    SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                }
            }
            return method;
        }
    }
}
