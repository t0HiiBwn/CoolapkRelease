package com.kepler.sdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class u {
    private HttpURLConnection a;

    public s a(r rVar) throws IOException, KeyManagementException, NoSuchAlgorithmException, IllegalAccessException {
        int f = rVar.f();
        if (f <= 0) {
            f = 0;
        }
        this.a = a(rVar.a(), f);
        if (!(rVar == null || rVar.d() == null)) {
            this.a.setRequestProperty("Cookie", rVar.d());
        }
        if (rVar.e() != null) {
            for (Map.Entry<String, String> entry : rVar.e().entrySet()) {
                this.a.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if ("post".equals(rVar.b())) {
            a(this.a, rVar.c());
        }
        return a(this.a);
    }

    public void a() throws IOException {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.a.getInputStream().close();
            this.a.getOutputStream().close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[SYNTHETIC, Splitter:B:34:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[Catch:{ Exception -> 0x0098 }, DONT_GENERATE] */
    public static File a(String str, File file, String str2, int i) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        File file2;
        FileOutputStream fileOutputStream2;
        try {
            HttpURLConnection a2 = a(str, 0);
            a2.setConnectTimeout(3000);
            a2.setReadTimeout(5000);
            if (a2.getResponseCode() == 302 && i >= 0) {
                return a(a(a2).a("Location").get(0), file, str2, i);
            }
            if (a2.getResponseCode() != 200) {
                j.b("suwg", "load file back not 200" + a2.getResponseCode());
                return null;
            }
            InputStream inputStream2 = a2.getInputStream();
            try {
                file2 = new File(file, str2);
                y.b(file2);
                fileOutputStream2 = new FileOutputStream(file2);
            } catch (Throwable th2) {
                fileOutputStream = null;
                inputStream = inputStream2;
                th = th2;
                try {
                    j.a(th);
                    if (fileOutputStream != null) {
                        try {
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        inputStream.close();
                    }
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                    inputStream2.close();
                } catch (Exception unused3) {
                }
                return file2;
            } catch (Throwable th3) {
                inputStream = inputStream2;
                th = th3;
                fileOutputStream = fileOutputStream2;
                j.a(th);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            fileOutputStream = null;
            j.a(th);
            return null;
        }
    }

    private static HttpURLConnection a(String str, int i) throws KeyManagementException, NoSuchAlgorithmException, IOException, IllegalAccessException {
        if (!af.a(str)) {
            URL url = new URL(str);
            if (TextUtils.isEmpty(str) || !str.startsWith("https://")) {
                return b(url, i);
            }
            return a(url, i);
        }
        throw new IllegalAccessException("url is request");
    }

    private static HttpsURLConnection a(URL url, int i) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new b()}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new a());
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        if (i > 0) {
            httpsURLConnection.setConnectTimeout(i);
            httpsURLConnection.setReadTimeout(i);
        }
        return httpsURLConnection;
    }

    private static HttpURLConnection b(URL url, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
        }
        return httpURLConnection;
    }

    private static HttpURLConnection a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        if (bArr != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        }
        return httpURLConnection;
    }

    private static s a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (af.a(contentEncoding)) {
            contentEncoding = "utf-8";
        }
        return new s(af.a(a(httpURLConnection.getInputStream()), contentEncoding), httpURLConnection.getHeaderFields(), responseCode);
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        a() {
        }
    }

    static class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        b() {
        }
    }
}
