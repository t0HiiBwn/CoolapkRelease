package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.taobao.tao.remotebusiness.b;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.XState;

/* compiled from: DefaultLoginImpl */
public final class a implements IRemoteLogin {
    static Context a;
    private static ThreadLocal<C0129a> b = new ThreadLocal<>();
    private static volatile AtomicBoolean o = new AtomicBoolean(false);
    private static volatile a p = null;
    private Class<?> c;
    private Class<?> d;
    private Class<?> e;
    private Method f;
    private Method g;
    private Method h;
    private Method i;
    private Method j;
    private Method k;
    private Method l;
    private LoginContext m = new LoginContext();
    private BroadcastReceiver n = null;

    public static a a(Context context) {
        if (p == null) {
            synchronized (a.class) {
                if (p == null) {
                    if (context == null) {
                        try {
                            context = MtopUtils.getContext();
                            if (context == null) {
                                TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[getDefaultLoginImpl]context can't be null.reflect context is still null.");
                                Mtop instance = Mtop.instance("INNER", (Context) null);
                                if (instance.getMtopConfig().context == null) {
                                    TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init.");
                                    instance.checkMtopSDKInit();
                                }
                                context = instance.getMtopConfig().context;
                                if (context == null) {
                                    TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init finish,context is still null");
                                    return p;
                                }
                                TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[getDefaultLoginImpl]context can't be null.wait INNER mtopInstance init finish.context=" + context);
                            }
                        } catch (Exception e2) {
                            TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[getDefaultLoginImpl]get DefaultLoginImpl instance error", e2);
                        }
                    }
                    a = context;
                    p = new a();
                }
            }
        }
        return p;
    }

    private a() throws ClassNotFoundException, NoSuchMethodException {
        try {
            this.c = Class.forName("com.taobao.login4android.api.Login");
        } catch (ClassNotFoundException unused) {
            this.c = Class.forName("com.taobao.login4android.Login");
        }
        this.f = this.c.getDeclaredMethod("login", Boolean.TYPE, Bundle.class);
        this.g = this.c.getDeclaredMethod("checkSessionValid", new Class[0]);
        this.i = this.c.getDeclaredMethod("getSid", new Class[0]);
        this.j = this.c.getDeclaredMethod("getUserId", new Class[0]);
        this.k = this.c.getDeclaredMethod("getNick", new Class[0]);
        Class<?> cls = Class.forName("com.taobao.login4android.constants.LoginStatus");
        this.e = cls;
        this.h = cls.getDeclaredMethod("isLogining", new Class[0]);
        Class<?> cls2 = Class.forName("com.taobao.login4android.broadcast.LoginBroadcastHelper");
        this.d = cls2;
        this.l = cls2.getMethod("registerLoginReceiver", Context.class, BroadcastReceiver.class);
        b();
        TBSdkLog.e("mtopsdk.DefaultLoginImpl", "register login event receiver");
    }

    private void b() {
        if (this.n != null) {
            return;
        }
        if (a == null) {
            TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[registerReceiver]Context is null, register receiver fail.");
            return;
        }
        synchronized (a.class) {
            if (this.n == null) {
                b bVar = new b(this);
                this.n = bVar;
                a(this.l, a, bVar);
            }
        }
    }

    public final void a(Object obj) {
        if (obj instanceof MtopResponse) {
            b.set(new C0129a((MtopResponse) obj, (String) a(this.k, new Object[0])));
        } else if (obj instanceof MtopRequest) {
            b.set(new C0129a((MtopRequest) obj));
        }
    }

    private <T> T a(Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.c, objArr);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[invokeMethod]invokeMethod error,method:" + method + ",args:" + objArr, e2);
            return null;
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final void login(onLoginListener onloginlistener, boolean z) {
        Bundle bundle;
        Exception e2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
            TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[login]call login,showLoginUI:" + z + " , listener:" + onloginlistener);
        }
        Bundle bundle2 = null;
        C0129a aVar = b.get();
        if (aVar != null) {
            try {
                bundle = new Bundle();
                try {
                    String jSONString = JSON.toJSONString(aVar);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[login]apiRefer=" + jSONString);
                    }
                    bundle.putString("apiReferer", jSONString);
                    IUploadStats iUploadStats = Mtop.instance(a).getMtopConfig().uploadStats;
                    if (iUploadStats == null) {
                        b.remove();
                        return;
                    }
                    MtopSDKThreadPoolExecutorFactory.submit(new c(this, iUploadStats, aVar));
                    b.remove();
                    bundle2 = bundle;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[login]  login extra bundle error.", e2);
                        b.remove();
                        bundle2 = bundle;
                        b();
                        a(this.f, Boolean.valueOf(z), bundle2);
                    } catch (Throwable th) {
                        b.remove();
                        throw th;
                    }
                }
            } catch (Exception e4) {
                bundle = null;
                e2 = e4;
                TBSdkLog.e("mtopsdk.DefaultLoginImpl", "[login]  login extra bundle error.", e2);
                b.remove();
                bundle2 = bundle;
                b();
                a(this.f, Boolean.valueOf(z), bundle2);
            }
        }
        b();
        a(this.f, Boolean.valueOf(z), bundle2);
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final boolean isSessionValid() {
        Boolean bool = (Boolean) a(this.g, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final boolean isLogining() {
        Boolean bool = (Boolean) a(this.h, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final LoginContext getLoginContext() {
        this.m.sid = (String) a(this.i, new Object[0]);
        this.m.userId = (String) a(this.j, new Object[0]);
        this.m.nickname = (String) a(this.k, new Object[0]);
        return this.m;
    }

    /* renamed from: com.taobao.tao.remotebusiness.login.a$a  reason: collision with other inner class name */
    /* compiled from: DefaultLoginImpl */
    static class C0129a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f = MtopUtils.getCurrentProcessName(a.a);
        public boolean g = XState.isAppBackground();

        public C0129a(MtopResponse mtopResponse, String str) {
            this.a = str;
            this.b = mtopResponse.getApi();
            this.c = mtopResponse.getV();
            this.d = mtopResponse.getRetCode();
            this.e = b.a(mtopResponse.getHeaderFields(), "S");
        }

        public C0129a(MtopRequest mtopRequest) {
            this.b = mtopRequest.getApiName();
            this.c = mtopRequest.getVersion();
        }
    }
}
