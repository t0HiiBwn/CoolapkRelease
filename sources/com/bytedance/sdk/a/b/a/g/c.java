package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: JdkWithJettyBootPlatform */
class c extends e {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.a.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.d, this.e}, new a(a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void b(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.b.invoke(null, sSLSocket));
            if (!aVar.a && aVar.b == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.a) {
                return null;
            } else {
                return aVar.b;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to get selected protocol", (Exception) e2);
        }
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* compiled from: JdkWithJettyBootPlatform */
    private static class a implements InvocationHandler {
        boolean a;
        String b;
        private final List<String> c;

        a(List<String> list) {
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.a.b.a.c.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.b = str;
                            return str;
                        }
                    }
                    String str2 = this.c.get(0);
                    this.b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.b = (String) objArr[0];
                    return null;
                }
            }
        }
    }
}
