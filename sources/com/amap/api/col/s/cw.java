package com.amap.api.col.s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.s.bj;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: MySSLSocketFactory */
public final class cw extends SSLSocketFactory {
    private SSLSocketFactory a;
    private Context b;
    private SSLContext c;

    public cw(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.b = context.getApplicationContext();
            } catch (Throwable th) {
                cg.c(th, "myssl", "<init3>");
                return;
            }
        }
        this.c = sSLContext;
        if (sSLContext != null) {
            this.a = sSLContext.getSocketFactory();
        }
        try {
            if (this.c == null && Build.VERSION.SDK_INT >= 9) {
                this.c = SSLContext.getDefault();
            }
        } catch (Throwable th2) {
            cg.c(th2, "myssl", "<init2>");
        }
        try {
            if (this.a == null) {
                this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                return;
            }
            return;
        } catch (Throwable th3) {
            cg.c(th3, "myssl", "<init3>");
            return;
        }
        if (this.a == null) {
            this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            cg.c(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            cg.c(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket());
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs1");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(socket, str, i, z));
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs2");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(str, i));
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs3");
            if (th instanceof UnknownHostException) {
                throw th;
            } else if (!(th instanceof IOException)) {
                return null;
            } else {
                throw th;
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs4");
            if (th instanceof UnknownHostException) {
                throw th;
            } else if (!(th instanceof IOException)) {
                return null;
            } else {
                throw th;
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(inetAddress, i));
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs5");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a2 = a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
            b(a2);
            return a2;
        } catch (Throwable th) {
            cg.c(th, "myssl", "cs6");
            if (!(th instanceof IOException)) {
                return null;
            }
            throw th;
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && bj.f.b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            cg.c(th, "myssl", "stlv2");
        }
        return socket;
    }

    private static void b(Socket socket) {
        int i;
        if (Build.VERSION.SDK_INT >= 17 && bj.f.c && bj.f.e && (socket instanceof SSLSocket)) {
            if (bj.f.f > bj.f.d) {
                i = bj.f.d;
            } else {
                i = bj.f.f;
            }
            if (i <= 17 || Build.VERSION.SDK_INT <= i) {
                try {
                    socket.getClass().getMethod(bs.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    cg.c(th, "myssl", "sust");
                }
            }
        }
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 17 && bj.f.c && this.b != null && this.c != null) {
            int i = bj.f.d;
            if (i <= 17 || Build.VERSION.SDK_INT <= i) {
                SSLSessionCache sSLSessionCache = new SSLSessionCache(this.b);
                if (Build.VERSION.SDK_INT <= 20 || Build.VERSION.SDK_INT >= 28) {
                    a(sSLSessionCache);
                    return;
                }
                try {
                    sSLSessionCache.getClass().getMethod(bs.c("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.c);
                } catch (Throwable th) {
                    cg.c(th, "myssl", "isc1");
                    a(sSLSessionCache);
                }
            }
        }
    }

    private void a(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.c;
        if (sSLContext != null) {
            try {
                SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
                Field declaredField = sSLSessionCache.getClass().getDeclaredField(bs.c("UbVNlc3Npb25DYWNoZQ"));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(sSLSessionCache);
                Method[] methods = clientSessionContext.getClass().getMethods();
                String c2 = bs.c("Yc2V0UGVyc2lzdGVudENhY2hl");
                for (Method method : methods) {
                    if (method.getName().equals(c2)) {
                        method.invoke(clientSessionContext, obj);
                        return;
                    }
                }
            } catch (Throwable th) {
                cg.c(th, "myssl", "isc2");
            }
        }
    }
}
