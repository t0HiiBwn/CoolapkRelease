package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: OkStack */
public class j implements IHttpStack {
    private final v a = new v.a().a(10000, TimeUnit.MILLISECONDS).b(10000, TimeUnit.MILLISECONDS).c(10000, TimeUnit.MILLISECONDS).a();

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    @Override // com.bytedance.sdk.adnet.face.IHttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        Throwable th;
        long timeoutMs = (long) request.getTimeoutMs();
        boolean z = true;
        v a2 = this.a.y().a(timeoutMs, TimeUnit.MILLISECONDS).b(timeoutMs, TimeUnit.MILLISECONDS).c(timeoutMs, TimeUnit.MILLISECONDS).b(true).a(true).a();
        y.a c = c(request);
        if (c != null) {
            a(request);
            if (!TextUtils.isEmpty(request.getUserAgent())) {
                c.b("User-Agent").b("User-Agent", request.getUserAgent());
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                for (String str : headers.keySet()) {
                    c.b(str, headers.get(str));
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    c.a(str2, map.get(str2));
                }
            }
            a(c, request);
            aa a3 = a2.a(c.d()).a();
            k a4 = k.a(a3);
            ab h = a3.h();
            try {
                int i = a4.b;
                if (i == -1) {
                    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                } else if (!a(request.getMethod(), i)) {
                    HttpResponse httpResponse = new HttpResponse(i, a(a3.g()));
                    h.close();
                    return httpResponse;
                } else {
                    try {
                        return new HttpResponse(i, a(a3.g()), (int) h.b(), new a(h));
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                if (!z) {
                    h.close();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("request params maybe null");
        }
    }

    private void a(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(b(request));
        }
    }

    private String b(Request<?> request) {
        if (request == null || request.getUrl() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private y.a c(Request request) throws IOException {
        String str = null;
        if (request == null || request.getUrl() == null) {
            return null;
        }
        y.a aVar = new y.a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        if (com.bytedance.sdk.adnet.a.a != null) {
            str = com.bytedance.sdk.adnet.a.a.a(host);
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar.a(new URL(url.toString().replaceFirst(host, str))).b("Host", host);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            aVar.a(url);
        }
        return aVar;
    }

    private static List<Header> a(r rVar) {
        if (rVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(rVar.a());
        int a2 = rVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = rVar.a(i);
            String b = rVar.b(i);
            if (a3 != null) {
                arrayList.add(new Header(a3, b));
            }
        }
        return arrayList;
    }

    private static void a(y.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.a(z.a(u.a(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.a();
                return;
            case 1:
                aVar.a(d(request));
                return;
            case 2:
                aVar.c(d(request));
                return;
            case 3:
                aVar.c();
                return;
            case 4:
                aVar.b();
                return;
            case 5:
                aVar.a("OPTIONS", (z) null);
                return;
            case 6:
                aVar.a("TRACE", (z) null);
                return;
            case 7:
                aVar.d(d(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static z d(Request request) throws com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() != 1) {
                return null;
            }
            body = "".getBytes();
        }
        return z.a(u.a(request.getBodyContentType()), body);
    }

    /* compiled from: OkStack */
    static class a extends FilterInputStream {
        private final ab a;

        a(ab abVar) {
            super(j.b(abVar));
            this.a = abVar;
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            super.close();
            try {
                this.a.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static InputStream b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        return abVar.c();
    }
}
