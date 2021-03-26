package com.tencent.android.tpush.d.a;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: ProGuard */
public class b extends c {
    Context a;
    BroadcastReceiver b = null;
    String c;
    StringBuffer d;
    private int e = 0;
    private Class<?> f = null;

    @Override // com.tencent.android.tpush.d.c
    public String a() {
        return "huawei";
    }

    @Override // com.tencent.android.tpush.d.c
    public boolean d(Context context) {
        return true;
    }

    @Override // com.tencent.android.tpush.d.c
    public int e(Context context) {
        return 5;
    }

    private int c() {
        try {
            this.f = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
            return 3;
        } catch (Throwable th) {
            this.f = null;
            Context context = this.a;
            StringBuffer stringBuffer = this.d;
            stringBuffer.append("errCode : -121 , errMsg : " + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            return -1;
        }
    }

    public String f(Context context) {
        Object invoke;
        if (this.e == 0) {
            this.e = c();
        }
        String str = "";
        if (this.e != 3) {
            return str;
        }
        try {
            if (!TextUtils.isEmpty(d.h)) {
                return d.h;
            }
            Class<?> cls = Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
            Object invoke2 = cls.getDeclaredMethod("fromContext", Context.class).invoke(cls, context);
            if (invoke2 == null || (invoke = cls.getDeclaredMethod("getString", String.class).invoke(invoke2, "client/app_id")) == null) {
                return str;
            }
            String obj = invoke.toString();
            try {
                d.h = obj;
                return obj;
            } catch (Throwable unused) {
                str = obj;
                TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                return str;
            }
        } catch (Throwable unused2) {
            TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
            return str;
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void a(Context context) {
        this.a = context;
        this.d = new StringBuffer();
        TLogger.i("OtherPushHuaWeiImpl", "other push huawei registerPush");
        g(context);
        if (this.e == 0) {
            this.e = c();
        }
        TLogger.ii("OtherPushHuaWeiImpl", "Get HW SDK version: " + this.e);
        try {
            int i = this.e;
            if (i == 3) {
                Object invoke = this.f.getDeclaredMethod("getInstance", Context.class).invoke(this.f, context);
                Method declaredMethod = this.f.getDeclaredMethod("getToken", String.class, String.class);
                String f2 = f(context);
                TLogger.i("OtherPushHuaWeiImpl", "Get HW appId from agcp: " + f2);
                Object invoke2 = declaredMethod.invoke(invoke, f2, "HCM");
                if (invoke2 == null || TextUtils.isEmpty(invoke2.toString())) {
                    TLogger.i("OtherPushHuaWeiImpl", "Get HW token from HWS.getToken null or empty, get it from receiver");
                    return;
                }
                TLogger.i("OtherPushHuaWeiImpl", "Get HW token: " + invoke2.toString());
                if (!invoke2.toString().equals(c(context))) {
                    String obj = invoke2.toString();
                    this.c = obj;
                    SharePrefsUtil.setString(context, "huawei_token", obj);
                }
                d.a(context, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
            } else if (i == 2) {
                this.f.getDeclaredMethod("init", Application.class).invoke(this.f, context.getApplicationContext());
                Class<?> cls = Class.forName("com.huawei.android.hms.agent.common.handler.ConnectHandler");
                this.f.getDeclaredMethod("connect", Activity.class, cls).invoke(this.f, null, Proxy.newProxyInstance(this.f.getClassLoader(), new Class[]{cls}, new a()));
            } else if (i == -1) {
                StringBuffer stringBuffer = this.d;
                stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                throw new Exception();
            }
        } catch (Throwable th) {
            TLogger.e("OtherPushHuaWeiImpl", "" + th.getCause(), th);
            StringBuffer stringBuffer2 = this.d;
            stringBuffer2.append("errCode : -123 , errMsg :" + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer2.toString());
        }
    }

    /* compiled from: ProGuard */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            TLogger.d("OtherPushHuaWeiImpl", "invoke, method:" + method);
            try {
                if (method.getName().equals("onConnect")) {
                    if (objArr != null && objArr.length > 0) {
                        try {
                            Integer num = (Integer) objArr[0];
                            TLogger.i("OtherPushHuaWeiImpl", "other push huawei onConnect code:" + num);
                            if (num.intValue() == 0) {
                                b.this.b();
                            } else {
                                Context context = b.this.a;
                                StringBuffer stringBuffer = b.this.d;
                                stringBuffer.append("errCode : " + num + " ,  errMsg : unkonwn");
                                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                            }
                        } catch (Throwable th) {
                            Context context2 = b.this.a;
                            StringBuffer stringBuffer2 = b.this.d;
                            stringBuffer2.append("errCode : -124 , errMsg :" + th.getLocalizedMessage());
                            SharePrefsUtil.setString(context2, "other_push_error_code", stringBuffer2.toString());
                        }
                    }
                } else if (method.getName().equals("onResult") && objArr != null && objArr.length > 0) {
                    try {
                        Integer num2 = (Integer) objArr[0];
                        TLogger.i("OtherPushHuaWeiImpl", "other push huawei onResult code:" + num2);
                        num2.intValue();
                    } catch (Throwable th2) {
                        Context context3 = b.this.a;
                        StringBuffer stringBuffer3 = b.this.d;
                        stringBuffer3.append("errCode : -125 , errMsg :" + th2.getLocalizedMessage());
                        SharePrefsUtil.setString(context3, "other_push_error_code", stringBuffer3.toString());
                    }
                }
            } catch (Throwable th3) {
                TLogger.e("OtherPushHuaWeiImpl", "onConnectionFailed", th3);
                Context context4 = b.this.a;
                StringBuffer stringBuffer4 = b.this.d;
                stringBuffer4.append("errCode : -126 , errMsg :" + th3.getLocalizedMessage());
                SharePrefsUtil.setString(context4, "other_push_error_code", stringBuffer4.toString());
            }
            return null;
        }
    }

    public void b() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
            Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.push.handler.GetTokenHandler");
            cls.getDeclaredMethod("getToken", cls2).invoke(cls, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new a()));
        } catch (Throwable th) {
            TLogger.e("OtherPushHuaWeiImpl", "getTokenAsyn error", th);
            Context context = this.a;
            StringBuffer stringBuffer = this.d;
            stringBuffer.append("errCode : -127 , errMsg :" + th.getLocalizedMessage());
            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public void b(Context context) {
        if (!j.b(this.c)) {
            if (this.d == null) {
                this.d = new StringBuffer();
            }
            TLogger.i("OtherPushHuaWeiImpl", "other push huawei unregisterPush");
            if (this.e == 0) {
                this.e = c();
            }
            try {
                int i = this.e;
                if (i == 3) {
                    this.f.getDeclaredMethod("deleteToken", String.class, String.class).invoke(this.f.getDeclaredMethod("getInstance", Context.class).invoke(this.f, this.a), "100167977", "HCM");
                } else if (i == 2) {
                    Class<?> cls = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
                    Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.push.handler.DeleteTokenHandler");
                    cls.getDeclaredMethod("deleteToken", String.class, cls2).invoke(cls, this.c, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, new a()));
                } else if (i == -1) {
                    TLogger.w("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                    Context context2 = this.a;
                    StringBuffer stringBuffer = this.d;
                    stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                    SharePrefsUtil.setString(context2, "other_push_error_code", stringBuffer.toString());
                    throw new Exception();
                }
            } catch (Throwable th) {
                TLogger.e("OtherPushHuaWeiImpl", "unregisterPush error", th);
                Context context3 = this.a;
                StringBuffer stringBuffer2 = this.d;
                stringBuffer2.append("errCode : -128 , errMsg :" + th.getLocalizedMessage());
                SharePrefsUtil.setString(context3, "other_push_error_code", stringBuffer2.toString());
            }
        }
    }

    private void g(Context context) {
        if (this.b == null) {
            this.b = new BroadcastReceiver() {
                /* class com.tencent.android.tpush.d.a.b.AnonymousClass1 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        try {
                            String action = intent.getAction();
                            if (!j.b(action)) {
                                TLogger.i("OtherPushHuaWeiImpl", "Receive broadcast action: " + action);
                                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                                    byte[] byteArrayExtra = intent.getByteArrayExtra("device_token");
                                    if (byteArrayExtra != null) {
                                        String str = new String(byteArrayExtra, "UTF-8");
                                        TLogger.i("OtherPushHuaWeiImpl", "Get token from broadcast: " + str);
                                        if (!j.b(str)) {
                                            if (!str.equals(b.this.c(context))) {
                                                b.this.c = str;
                                                SharePrefsUtil.setString(context, "huawei_token", b.this.c);
                                            }
                                            d.a(b.this.a, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
                                        }
                                    }
                                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                                    TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.android.push.intent.RECEIVE");
                                } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                                    TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.intent.action.PUSH_STATEE");
                                }
                            }
                        } catch (Throwable th) {
                            TLogger.e("OtherPushHuaWeiImpl", "registerHuaweiRecevier ", th);
                            StringBuffer stringBuffer = b.this.d;
                            stringBuffer.append("errCode : -120 , errMsg : " + th.getLocalizedMessage());
                            SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
                        }
                    }
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
                intentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
                intentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
                context.registerReceiver(this.b, intentFilter);
            } catch (Throwable th) {
                TLogger.e("OtherPushHuaWeiImpl", "registerReceiver error", th);
                StringBuffer stringBuffer = this.d;
                stringBuffer.append("errCode : -129 , errMsg : " + th.getLocalizedMessage());
                SharePrefsUtil.setString(context, "other_push_error_code", stringBuffer.toString());
            }
        }
    }

    @Override // com.tencent.android.tpush.d.c
    public String c(Context context) {
        if (j.b(this.c)) {
            this.c = SharePrefsUtil.getString(context, "huawei_token", "");
        }
        return this.c;
    }
}
