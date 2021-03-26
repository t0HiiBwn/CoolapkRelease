package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.i.a;
import com.bytedance.sdk.a.b.a.i.b;
import com.bytedance.sdk.a.b.a.i.c;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform */
public class e {
    private static final e a = a();
    private static final Logger b = Logger.getLogger(v.class.getName());

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    public static e b() {
        return a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public c a(X509TrustManager x509TrustManager) {
        return new a(b(x509TrustManager));
    }

    private static e a() {
        e a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        b a3 = b.a();
        if (a3 != null) {
            return a3;
        }
        e a4 = c.a();
        if (a4 != null) {
            return a4;
        }
        return new e();
    }

    static byte[] b(List<w> list) {
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.i(wVar.toString().length());
                cVar.b(wVar.toString());
            }
        }
        return cVar.q();
    }

    public f b(X509TrustManager x509TrustManager) {
        return new b(x509TrustManager.getAcceptedIssuers());
    }
}
