package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform */
final class b extends e {
    final Method a;
    final Method b;

    b(Method method, Method method2) {
        this.a = method;
        this.b = method2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = a(list);
            this.a.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw c.a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw c.a("unable to get selected protocols", (Exception) e);
        }
    }

    public static b a() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
