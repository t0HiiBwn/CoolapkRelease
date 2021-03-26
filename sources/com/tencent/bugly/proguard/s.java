package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: BUGLY */
public final class s {
    private static s b;
    public Map<String, String> a = null;
    private Context c;

    private s(Context context) {
        this.c = context;
    }

    public static s a(Context context) {
        if (b == null) {
            b = new s(context);
        }
        return b;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0120: APUT  (r6v7 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r4v21 java.lang.String) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0186, code lost:
        if (com.tencent.bugly.proguard.x.a(r4) != false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0188, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0168, code lost:
        if (com.tencent.bugly.proguard.x.a(r4) != false) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0179 A[Catch:{ all -> 0x016d, all -> 0x0193 }] */
    public final byte[] a(String str, byte[] bArr, v vVar, Map<String, String> map) {
        long j;
        int i;
        Throwable th;
        IOException e;
        long j2;
        Object[] objArr;
        byte[] bArr2 = null;
        int i2 = 0;
        if (str == null) {
            x.e("Failed for no URL.", new Object[0]);
            return null;
        }
        if (bArr == null) {
            j = 0;
        } else {
            j = (long) bArr.length;
        }
        int i3 = 1;
        x.c("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(j), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        while (i4 <= 0 && i5 <= 0) {
            if (z) {
                i = i4;
                z = false;
            } else {
                int i6 = i4 + 1;
                if (i6 > i3) {
                    x.c("try time: " + i6, new Object[i2]);
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(10000)) + 10000);
                }
                i = i6;
            }
            String b2 = b.b(this.c);
            if (b2 == null) {
                x.d("Failed to request for network not avail", new Object[i2]);
                i4 = i;
            } else {
                vVar.a(j);
                HttpURLConnection a2 = a(str2, bArr, b2, map);
                if (a2 != null) {
                    try {
                        int responseCode = a2.getResponseCode();
                        if (responseCode == 200) {
                            this.a = a(a2);
                            byte[] b3 = b(a2);
                            if (b3 == null) {
                                j2 = 0;
                            } else {
                                j2 = (long) b3.length;
                            }
                            vVar.b(j2);
                            try {
                                a2.disconnect();
                            } catch (Throwable th2) {
                                if (!x.a(th2)) {
                                    th2.printStackTrace();
                                }
                            }
                            return b3;
                        }
                        if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                            try {
                                String headerField = a2.getHeaderField("Location");
                                if (headerField == null) {
                                    try {
                                        x.e("Failed to redirect: %d" + responseCode, new Object[0]);
                                        try {
                                            a2.disconnect();
                                            return null;
                                        } catch (Throwable th3) {
                                            if (x.a(th3)) {
                                                return null;
                                            }
                                            th3.printStackTrace();
                                            return null;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        z = true;
                                        try {
                                            if (!x.a(e)) {
                                            }
                                            try {
                                                a2.disconnect();
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                            i4 = i;
                                            bArr2 = null;
                                            i2 = 0;
                                            i3 = 1;
                                        } catch (Throwable th5) {
                                            if (!x.a(th5)) {
                                                th5.printStackTrace();
                                            }
                                        }
                                    }
                                } else {
                                    i5++;
                                    try {
                                        objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(responseCode);
                                    } catch (IOException e3) {
                                        e = e3;
                                        str2 = headerField;
                                        i = 0;
                                        z = true;
                                        if (!x.a(e)) {
                                            e.printStackTrace();
                                        }
                                        a2.disconnect();
                                        i4 = i;
                                        bArr2 = null;
                                        i2 = 0;
                                        i3 = 1;
                                    }
                                    try {
                                        objArr[1] = headerField;
                                        x.c("redirect code: %d ,to:%s", objArr);
                                        str2 = headerField;
                                        i = 0;
                                        z = true;
                                    } catch (IOException e4) {
                                        e = e4;
                                        str2 = headerField;
                                        i = 0;
                                        z = true;
                                        if (!x.a(e)) {
                                        }
                                        a2.disconnect();
                                        i4 = i;
                                        bArr2 = null;
                                        i2 = 0;
                                        i3 = 1;
                                    }
                                }
                            } catch (IOException e5) {
                                e = e5;
                                z = true;
                                if (!x.a(e)) {
                                }
                                a2.disconnect();
                                i4 = i;
                                bArr2 = null;
                                i2 = 0;
                                i3 = 1;
                            }
                        }
                        try {
                            x.d("response code " + responseCode, new Object[0]);
                            long contentLength = (long) a2.getContentLength();
                            if (contentLength < 0) {
                                contentLength = 0;
                            }
                            vVar.b(contentLength);
                            try {
                                a2.disconnect();
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            if (!x.a(e)) {
                            }
                            a2.disconnect();
                            i4 = i;
                            bArr2 = null;
                            i2 = 0;
                            i3 = 1;
                        }
                        i4 = i;
                    } catch (IOException e7) {
                        e = e7;
                        if (!x.a(e)) {
                        }
                        a2.disconnect();
                        i4 = i;
                        bArr2 = null;
                        i2 = 0;
                        i3 = 1;
                    }
                } else {
                    x.c("Failed to execute post.", new Object[0]);
                    vVar.b(0);
                    i4 = i;
                }
                bArr2 = null;
                i2 = 0;
            }
            i3 = 1;
        }
        return bArr2;
        throw th;
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b A[Catch:{ all -> 0x0049, all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[SYNTHETIC, Splitter:B:24:0x0040] */
    private static byte[] b(HttpURLConnection httpURLConnection) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            if (!x.a(th)) {
            }
            if (bufferedInputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            x.e("destUrl is null.", new Object[0]);
            return null;
        }
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            /* class com.tencent.bugly.proguard.s.AnonymousClass1 */

            @Override // javax.net.ssl.X509TrustManager
            public final X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x.c("checkClientTrusted", new Object[0]);
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                x.c("checkServerTrusted", new Object[0]);
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpURLConnection a2 = a(str2, str);
        if (a2 == null) {
            x.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a2.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a2.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            a2.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a2.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a2.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a2;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            x.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (a.b() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(a.b());
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
