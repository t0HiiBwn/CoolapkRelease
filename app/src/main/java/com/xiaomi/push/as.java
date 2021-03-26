package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class as implements ar, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    private volatile int f204a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile long f205a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f206a;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f207a = null;

    /* renamed from: a  reason: collision with other field name */
    private Class f208a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f209a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Method f210a = null;
    private Class b = null;

    /* renamed from: b  reason: collision with other field name */
    private Method f211b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    private class a {

        /* renamed from: a  reason: collision with other field name */
        Boolean f212a;

        /* renamed from: a  reason: collision with other field name */
        String f213a;
        String b;
        String c;
        String d;

        private a() {
            this.f212a = null;
            this.f213a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f213a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f212a = true;
            }
            return this.f212a != null;
        }
    }

    public as(Context context) {
        this.f206a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return t.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a */
    private void mo105a() {
        synchronized (this.f209a) {
            try {
                this.f209a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i);
                cls2 = a4;
                cls = a3;
                break;
            }
            i++;
            cls2 = a4;
            cls = a3;
        }
        this.f208a = a2;
        this.f210a = a(a2, "InitSdk", Context.class, cls);
        this.b = cls;
        this.f211b = a(cls2, "getUDID", new Class[0]);
        this.c = a(cls2, "getOAID", new Class[0]);
        this.d = a(cls2, "getVAID", new Class[0]);
        this.e = a(cls2, "getAAID", new Class[0]);
        this.f = a(cls2, "isSupported", new Class[0]);
        this.g = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.f207a == null) {
            long j = this.f205a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
            int i = this.f204a;
            if (elapsedRealtime > 3000 && i < 3) {
                synchronized (this.f209a) {
                    if (this.f205a == j && this.f204a == i) {
                        b("retry, current count is " + i);
                        this.f204a = this.f204a + 1;
                        b(this.f206a);
                        j = this.f205a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                    }
                }
            }
            if (this.f207a == null && j >= 0 && elapsedRealtime <= 3000 && Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (this.f209a) {
                    if (this.f207a == null) {
                        try {
                            b(str + " wait...");
                            this.f209a.wait(3000);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f210a, this.f208a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f205a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f205a = elapsedRealtime;
    }

    private static void b(String str) {
        b.m41a("mdid:" + str);
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a  reason: collision with other method in class */
    public String mo108a() {
        a("getUDID");
        if (this.f207a == null) {
            return null;
        }
        return this.f207a.f213a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo109a() {
        a("isSupported");
        return this.f207a != null && Boolean.TRUE.equals(this.f207a.f212a);
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo106b() {
        a("getOAID");
        if (this.f207a == null) {
            return null;
        }
        return this.f207a.b;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        a("getVAID");
        if (this.f207a == null) {
            return null;
        }
        return this.f207a.c;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        a("getAAID");
        if (this.f207a == null) {
            return null;
        }
        return this.f207a.d;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f205a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.f213a = (String) a(this.f211b, obj2, new Object[0]);
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.c = (String) a(this.d, obj2, new Object[0]);
                    aVar.d = (String) a(this.e, obj2, new Object[0]);
                    aVar.f212a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        if (this.f207a != null) {
                            z = true;
                        }
                        sb.append(z);
                        b(sb.toString());
                        synchronized (as.class) {
                            if (this.f207a == null) {
                                this.f207a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        mo105a();
        return null;
    }
}
