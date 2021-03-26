package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import com.huawei.updatesdk.a.a.c.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class b {
    private HttpURLConnection a = null;

    public static class a {
        private String a;
        private int b;

        public String a() {
            return (String) com.huawei.updatesdk.service.e.a.a(this.a);
        }

        public int b() {
            return ((Integer) com.huawei.updatesdk.service.e.a.a(Integer.valueOf(this.b))).intValue();
        }
    }

    private HttpURLConnection a(String str, Context context) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IllegalAccessException {
        HttpsURLConnection httpsURLConnection;
        URL url = new URL(str);
        Proxy d = com.huawei.updatesdk.a.a.c.b.b.d(context);
        if ("https".equals(url.getProtocol())) {
            httpsURLConnection = (HttpsURLConnection) (d == null ? url.openConnection() : url.openConnection(d));
            HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
            httpsURLConnection2.setSSLSocketFactory(d.a(context));
            httpsURLConnection2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        } else {
            httpsURLConnection = null;
        }
        return "http".equals(url.getProtocol()) ? (HttpURLConnection) url.openConnection() : httpsURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041 A[SYNTHETIC, Splitter:B:27:0x0041] */
    private byte[] a(byte[] bArr) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        IOException e;
        DataOutputStream dataOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                try {
                    dataOutputStream2.write(bArr, 0, bArr.length);
                    dataOutputStream2.flush();
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e2) {
                        com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", e2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    dataOutputStream = dataOutputStream2;
                    try {
                        com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", e);
                        if (dataOutputStream != null) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e4) {
                                com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", e4);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", e);
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e6) {
            e = e6;
            byteArrayOutputStream = null;
            com.huawei.updatesdk.a.a.b.a.a.a.a("HttpsUtil", "gzip error!", e);
            if (dataOutputStream != null) {
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    public a a(String str, String str2, String str3, String str4, Context context) throws IOException, CertificateException, IllegalAccessException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        DataOutputStream dataOutputStream;
        Throwable th;
        Closeable closeable;
        a aVar = new a();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection a2 = a(str, context);
            if (a2 == null) {
                if (a2 != null) {
                    a2.disconnect();
                }
                d.a((Closeable) null);
                d.a((Closeable) null);
                return aVar;
            }
            try {
                this.a = a2;
                a2.setDoInput(true);
                a2.setDoOutput(true);
                a2.setUseCaches(false);
                a2.setConnectTimeout(5000);
                a2.setReadTimeout(10000);
                a2.setRequestMethod("POST");
                a2.setRequestProperty("Content-Type", "application/x-gzip");
                a2.setRequestProperty("Content-Encoding", "gzip");
                a2.setRequestProperty("Connection", "Keep-Alive");
                a2.setRequestProperty("User-Agent", str4);
                dataOutputStream = new DataOutputStream(a2.getOutputStream());
                try {
                    dataOutputStream.write(a(str2.getBytes(str3)));
                    dataOutputStream.flush();
                    int responseCode = a2.getResponseCode();
                    aVar.b = responseCode;
                    BufferedInputStream bufferedInputStream = responseCode == 200 ? new BufferedInputStream(a2.getInputStream()) : new BufferedInputStream(a2.getErrorStream());
                    com.huawei.updatesdk.a.a.c.b bVar = new com.huawei.updatesdk.a.a.c.b();
                    byte[] b = a.a().b();
                    while (true) {
                        int read = bufferedInputStream.read(b);
                        if (read == -1) {
                            break;
                        }
                        bVar.a(b, read);
                    }
                    a.a().a(b);
                    aVar.a = bVar.a();
                    if (a2 != null) {
                        a2.disconnect();
                    }
                    d.a(dataOutputStream);
                    d.a(bufferedInputStream);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = a2;
                    closeable = null;
                    if (httpURLConnection != null) {
                    }
                    d.a(dataOutputStream);
                    d.a(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                httpURLConnection = a2;
                closeable = null;
                if (httpURLConnection != null) {
                }
                d.a(dataOutputStream);
                d.a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            dataOutputStream = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            d.a(dataOutputStream);
            d.a(closeable);
            throw th;
        }
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
