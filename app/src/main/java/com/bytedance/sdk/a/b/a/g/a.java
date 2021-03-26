package com.bytedance.sdk.a.b.a.g;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: AndroidPlatform */
class a extends e {
    private final Class<?> a;
    private final d<Socket> b;
    private final d<Socket> c;
    private final d<Socket> d;
    private final d<Socket> e;
    private final c f = c.a();

    a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.a = cls;
        this.b = dVar;
        this.c = dVar2;
        this.d = dVar3;
        this.e = dVar4;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (com.bytedance.sdk.a.b.a.c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e4);
                throw iOException2;
            }
            throw e4;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.b.b(sSLSocket, true);
            this.c.b(sSLSocket, str);
        }
        d<Socket> dVar = this.e;
        if (dVar != null && dVar.a((d<Socket>) sSLSocket)) {
            this.e.d(sSLSocket, b(list));
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.d;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket) || (bArr = (byte[]) this.d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.a.b.a.c.e);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public Object a(String str) {
        return this.f.a(str);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(String str, Object obj) {
        if (!this.f.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e2);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private static boolean c() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0029a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d(null, "setHostname", String.class);
        if (c()) {
            d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            dVar = new d(null, "setAlpnProtocols", byte[].class);
            dVar2 = dVar5;
        } else {
            dVar2 = null;
            dVar = null;
        }
        return new a(cls, dVar3, dVar4, dVar2, dVar);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    /* renamed from: com.bytedance.sdk.a.b.a.g.a$a  reason: collision with other inner class name */
    /* compiled from: AndroidPlatform */
    static final class C0029a extends com.bytedance.sdk.a.b.a.i.c {
        private final Object a;
        private final Method b;

        public int hashCode() {
            return 0;
        }

        C0029a(Object obj, Method method) {
            this.a = obj;
            this.b = method;
        }

        @Override // com.bytedance.sdk.a.b.a.i.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0029a;
        }
    }

    /* compiled from: AndroidPlatform */
    static final class c {
        private final Method a;
        private final Method b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }

        Object a(String str) {
            Method method = this.a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }
    }

    /* compiled from: AndroidPlatform */
    static final class b implements f {
        private final X509TrustManager a;
        private final Method b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.a.b.a.i.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.a.b.a.c.a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.a.equals(bVar.a) || !this.b.equals(bVar.b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.a.hashCode() + (this.b.hashCode() * 31);
        }
    }
}
