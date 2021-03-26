package com.tencent.imsdk.looper;

import android.util.Log;
import com.tencent.imsdk.log.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpClient {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HTTP_ACTION_REQUEST = 0;
    public static final int HTTP_ACTION_RESPONSE = 1;
    private static final long KEEP_ALIVE = 5;
    private static final int MAX_POOL_SIZE;
    private static final String TAG = "HttpClient";
    private static HostnameVerifier mHostnameVerifier = new HostnameVerifier() {
        /* class com.tencent.imsdk.looper.HttpClient.AnonymousClass2 */

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return str.contains("cloud") || str.contains("tim");
        }
    };
    private static final Executor mThreadPoolExecutor;
    private static TrustManager[] mTrustManagers = {new X509TrustManager() {
        /* class com.tencent.imsdk.looper.HttpClient.AnonymousClass1 */

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                x509CertificateArr[0].checkValidity();
            } catch (CertificateExpiredException e) {
                e.printStackTrace();
            } catch (CertificateNotYetValidException e2) {
                e2.printStackTrace();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                x509CertificateArr[0].checkValidity();
            } catch (CertificateExpiredException e) {
                e.printStackTrace();
            } catch (CertificateNotYetValidException e2) {
                e2.printStackTrace();
            }
        }
    }};

    public interface HttpRequestListener {
        void onCompleted(int i, Map<String, String> map, byte[] bArr);

        void onProgress(int i, int i2, int i3);
    }

    /* access modifiers changed from: private */
    public static native void nativeProgressCallback(int i, int i2, int i3, long j);

    /* access modifiers changed from: private */
    public static native void nativeResponseCallback(int i, String[] strArr, String[] strArr2, byte[] bArr, long j, long j2);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i = availableProcessors + 1;
        CORE_POOL_SIZE = i;
        int i2 = (availableProcessors * 2) + 1;
        MAX_POOL_SIZE = i2;
        mThreadPoolExecutor = new ThreadPoolExecutor(i, i2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    private static void httpRequest(final String str, final String str2, final Map<String, String> map, final byte[] bArr, final String str3, final String str4, final HttpRequestListener httpRequestListener, final String str5, final int i, final int i2, final int i3) {
        mThreadPoolExecutor.execute(new Runnable() {
            /* class com.tencent.imsdk.looper.HttpClient.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: byte[] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:100:0x01aa  */
            /* JADX WARNING: Removed duplicated region for block: B:132:0x0207 A[SYNTHETIC, Splitter:B:132:0x0207] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0211  */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x0218  */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x0240 A[SYNTHETIC, Splitter:B:147:0x0240] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x024a  */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x0251  */
            /* JADX WARNING: Removed duplicated region for block: B:159:0x0259 A[SYNTHETIC, Splitter:B:159:0x0259] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0263  */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x026a  */
            /* JADX WARNING: Removed duplicated region for block: B:171:0x00f9 A[EDGE_INSN: B:171:0x00f9->B:45:0x00f9 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00da A[Catch:{ UnknownHostException -> 0x01d3, Exception -> 0x01ce, all -> 0x01cb }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2 A[Catch:{ UnknownHostException -> 0x01d3, Exception -> 0x01ce, all -> 0x01cb }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x00fd A[Catch:{ UnknownHostException -> 0x01d3, Exception -> 0x01ce, all -> 0x01cb }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x011b A[Catch:{ UnknownHostException -> 0x01c5, Exception -> 0x01bf, all -> 0x01b9 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0131 A[Catch:{ UnknownHostException -> 0x01b6, Exception -> 0x01b2, all -> 0x01af }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0138 A[Catch:{ UnknownHostException -> 0x01b6, Exception -> 0x01b2, all -> 0x01af }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0148 A[Catch:{ UnknownHostException -> 0x01b6, Exception -> 0x01b2, all -> 0x01af }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0196  */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0199 A[SYNTHETIC, Splitter:B:92:0x0199] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x01a3  */
            @Override // java.lang.Runnable
            public void run() {
                Map<String, String> map;
                byte[] bArr;
                HttpURLConnection httpURLConnection;
                Throwable th;
                HttpRequestListener httpRequestListener;
                byte[] bArr2;
                UnknownHostException e;
                HttpRequestListener httpRequestListener2;
                byte[] bArr3;
                Exception exc;
                byte[] bArr4;
                HttpRequestListener httpRequestListener3;
                Map<String, String> map2;
                boolean z;
                int responseCode;
                byte[] bArr5;
                byte[] bArr6;
                byte[] bArr7;
                int size;
                int contentLength;
                byte[] bArr8;
                HttpRequestListener httpRequestListener4;
                OutputStream outputStream;
                InputStream inputStream;
                byte[] bArr9;
                int read;
                int i = -1;
                int i2 = 200;
                BufferedInputStream bufferedInputStream = null;
                try {
                    if (str5.isEmpty() || i == 0) {
                        httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    } else {
                        httpURLConnection = (HttpURLConnection) new URL(str2).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str5, i)));
                    }
                    try {
                        if (str2.startsWith("https")) {
                            SSLContext instance = SSLContext.getInstance("TLS");
                            instance.init(null, HttpClient.mTrustManagers, null);
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                            httpsURLConnection.setHostnameVerifier(HttpClient.mHostnameVerifier);
                        }
                        httpURLConnection.setRequestMethod(str);
                        httpURLConnection.setConnectTimeout(i2);
                        httpURLConnection.setReadTimeout(i3);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        Map map3 = map;
                        if (map3 != null) {
                            for (Map.Entry entry : map3.entrySet()) {
                                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        byte[] bArr10 = bArr;
                        boolean z2 = bArr10 != null && bArr10.length > 0;
                        String str = str3;
                        boolean z3 = (str == null || str.length() == 0) ? false : true;
                        if (!z2) {
                            if (!z3) {
                                z = false;
                                if (!str.equalsIgnoreCase("GET") && z) {
                                    httpURLConnection.setDoOutput(true);
                                    if (!z3) {
                                        inputStream = new FileInputStream(str3);
                                    } else {
                                        inputStream = new ByteArrayInputStream(bArr);
                                    }
                                    int available = inputStream.available();
                                    httpURLConnection.setFixedLengthStreamingMode(available);
                                    bArr9 = new byte[4096];
                                    int i3 = 0;
                                    while (true) {
                                        read = inputStream.read(bArr9);
                                        if (read >= 0) {
                                            break;
                                        }
                                        i3 += read;
                                        httpURLConnection.getOutputStream().write(bArr9, 0, read);
                                        HttpRequestListener httpRequestListener5 = httpRequestListener;
                                        if (httpRequestListener5 != null) {
                                            httpRequestListener5.onProgress(0, i3, available);
                                        }
                                    }
                                    inputStream.close();
                                }
                                responseCode = httpURLConnection.getResponseCode();
                                size = httpURLConnection.getHeaderFields().size();
                                if (size <= 0) {
                                    map = new HashMap<>();
                                    for (int i4 = 0; i4 < size; i4++) {
                                        try {
                                            map.put(httpURLConnection.getHeaderFieldKey(i4), httpURLConnection.getHeaderField(i4));
                                        } catch (UnknownHostException e2) {
                                            e = e2;
                                            bArr5 = null;
                                            bArr2 = bArr5;
                                            QLog.e(HttpClient.TAG, "http request failed." + e.getLocalizedMessage());
                                            if (bufferedInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            httpRequestListener2 = httpRequestListener;
                                            if (httpRequestListener2 != null) {
                                            }
                                        } catch (Exception e3) {
                                            exc = e3;
                                            bArr6 = null;
                                            i2 = responseCode;
                                            bArr4 = bArr6;
                                            try {
                                                QLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                try {
                                                    byte[] bytes = Log.getStackTraceString(exc).getBytes();
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    httpRequestListener3 = httpRequestListener;
                                                    if (httpRequestListener3 != null) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    bArr = bArr4;
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    if (httpURLConnection != null) {
                                                    }
                                                    httpRequestListener = httpRequestListener;
                                                    if (httpRequestListener != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                i = i2;
                                                bArr = bArr4;
                                                if (bufferedInputStream != null) {
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (IOException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                httpRequestListener = httpRequestListener;
                                                if (httpRequestListener != null) {
                                                    httpRequestListener.onCompleted(i, map, bArr);
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bArr7 = null;
                                            i = responseCode;
                                            bArr = bArr7;
                                            if (bufferedInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            httpRequestListener = httpRequestListener;
                                            if (httpRequestListener != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    map = null;
                                }
                                contentLength = httpURLConnection.getContentLength();
                                if (contentLength == -1) {
                                    contentLength = 0;
                                }
                                String str2 = str4;
                                boolean z4 = str2 == null && str2.length() != 0;
                                if (responseCode != 200) {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                                    if (z4) {
                                        try {
                                            outputStream = new FileOutputStream(str4);
                                        } catch (UnknownHostException e5) {
                                            e = e5;
                                            bArr5 = null;
                                            bufferedInputStream = bufferedInputStream2;
                                            bArr2 = bArr5;
                                            QLog.e(HttpClient.TAG, "http request failed." + e.getLocalizedMessage());
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            httpRequestListener2 = httpRequestListener;
                                            if (httpRequestListener2 != null) {
                                                httpRequestListener2.onCompleted(404, map, bArr2);
                                                return;
                                            }
                                            return;
                                        } catch (Exception e7) {
                                            exc = e7;
                                            bArr6 = null;
                                            bufferedInputStream = bufferedInputStream2;
                                            i2 = responseCode;
                                            bArr4 = bArr6;
                                            QLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                            byte[] bytes = Log.getStackTraceString(exc).getBytes();
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e8) {
                                                    e8.printStackTrace();
                                                }
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            httpRequestListener3 = httpRequestListener;
                                            if (httpRequestListener3 != null) {
                                                httpRequestListener3.onCompleted(-1, map, bytes);
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bArr = null;
                                            i = responseCode;
                                            bufferedInputStream = bufferedInputStream2;
                                            if (bufferedInputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            httpRequestListener = httpRequestListener;
                                            if (httpRequestListener != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        outputStream = new ByteArrayOutputStream();
                                    }
                                    byte[] bArr11 = new byte[4096];
                                    int i5 = 0;
                                    while (true) {
                                        int read2 = bufferedInputStream2.read(bArr11);
                                        if (read2 < 0) {
                                            break;
                                        }
                                        i5 += read2;
                                        outputStream.write(bArr11, 0, read2);
                                        HttpRequestListener httpRequestListener6 = httpRequestListener;
                                        if (httpRequestListener6 != null) {
                                            httpRequestListener6.onProgress(1, i5, contentLength);
                                        }
                                    }
                                    byte[] byteArray = z4 ? new byte[0] : ((ByteArrayOutputStream) outputStream).toByteArray();
                                    outputStream.close();
                                    bArr8 = byteArray;
                                    bufferedInputStream = bufferedInputStream2;
                                } else {
                                    bArr8 = null;
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                httpRequestListener4 = httpRequestListener;
                                if (httpRequestListener4 == null) {
                                    httpRequestListener4.onCompleted(responseCode, map, bArr8);
                                    return;
                                }
                                return;
                            }
                        }
                        z = true;
                        httpURLConnection.setDoOutput(true);
                        if (!z3) {
                        }
                        int available = inputStream.available();
                        httpURLConnection.setFixedLengthStreamingMode(available);
                        bArr9 = new byte[4096];
                        int i3 = 0;
                        while (true) {
                            read = inputStream.read(bArr9);
                            if (read >= 0) {
                            }
                        }
                        inputStream.close();
                        responseCode = httpURLConnection.getResponseCode();
                        try {
                            size = httpURLConnection.getHeaderFields().size();
                            if (size <= 0) {
                            }
                            contentLength = httpURLConnection.getContentLength();
                            if (contentLength == -1) {
                            }
                            String str2 = str4;
                            if (str2 == null) {
                            }
                            if (responseCode != 200) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            httpRequestListener4 = httpRequestListener;
                            if (httpRequestListener4 == null) {
                            }
                        } catch (UnknownHostException e10) {
                            e = e10;
                            bArr5 = null;
                            map = null;
                            bArr2 = bArr5;
                            QLog.e(HttpClient.TAG, "http request failed." + e.getLocalizedMessage());
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            httpRequestListener2 = httpRequestListener;
                            if (httpRequestListener2 != null) {
                            }
                        } catch (Exception e11) {
                            exc = e11;
                            bArr6 = null;
                            map = null;
                            i2 = responseCode;
                            bArr4 = bArr6;
                            QLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                            byte[] bytes = Log.getStackTraceString(exc).getBytes();
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            httpRequestListener3 = httpRequestListener;
                            if (httpRequestListener3 != null) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            bArr7 = null;
                            map = null;
                            i = responseCode;
                            bArr = bArr7;
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            httpRequestListener = httpRequestListener;
                            if (httpRequestListener != null) {
                            }
                            throw th;
                        }
                    } catch (UnknownHostException e12) {
                        e = e12;
                        bArr3 = null;
                        map = bArr3;
                        bArr2 = bArr3;
                        QLog.e(HttpClient.TAG, "http request failed." + e.getLocalizedMessage());
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        httpRequestListener2 = httpRequestListener;
                        if (httpRequestListener2 != null) {
                        }
                    } catch (Exception e13) {
                        map = null;
                        exc = e13;
                        bArr4 = null;
                        QLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                        byte[] bytes = Log.getStackTraceString(exc).getBytes();
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        httpRequestListener3 = httpRequestListener;
                        if (httpRequestListener3 != null) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        map2 = null;
                        map = map2;
                        i = 200;
                        bArr = map2;
                        if (bufferedInputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        httpRequestListener = httpRequestListener;
                        if (httpRequestListener != null) {
                        }
                        throw th;
                    }
                } catch (UnknownHostException e14) {
                    e = e14;
                    httpURLConnection = null;
                    bArr3 = null;
                    map = bArr3;
                    bArr2 = bArr3;
                    QLog.e(HttpClient.TAG, "http request failed." + e.getLocalizedMessage());
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    httpRequestListener2 = httpRequestListener;
                    if (httpRequestListener2 != null) {
                    }
                } catch (Exception e15) {
                    bArr4 = null;
                    map = null;
                    exc = e15;
                    httpURLConnection = null;
                    QLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                    byte[] bytes = Log.getStackTraceString(exc).getBytes();
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    httpRequestListener3 = httpRequestListener;
                    if (httpRequestListener3 != null) {
                    }
                } catch (Throwable th8) {
                    th = th8;
                    httpURLConnection = null;
                    map2 = null;
                    map = map2;
                    i = 200;
                    bArr = map2;
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    httpRequestListener = httpRequestListener;
                    if (httpRequestListener != null) {
                    }
                    throw th;
                }
            }
        });
    }

    private static void httpRequest(String str, String str2, String[] strArr, String[] strArr2, byte[] bArr, String str3, String str4, final long j, final long j2, String str5, int i, int i2, int i3) {
        HashMap hashMap;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i4 = 0; i4 < strArr.length; i4++) {
                hashMap.put(strArr[i4], strArr2[i4]);
            }
        }
        httpRequest(str, str2, hashMap, bArr, str3, str4, new HttpRequestListener() {
            /* class com.tencent.imsdk.looper.HttpClient.AnonymousClass4 */

            @Override // com.tencent.imsdk.looper.HttpClient.HttpRequestListener
            public void onProgress(int i, int i2, int i3) {
                long j = j;
                if (j != 0) {
                    try {
                        HttpClient.nativeProgressCallback(i, i2, i3, j);
                    } catch (UnsatisfiedLinkError e) {
                        String str = HttpClient.TAG;
                        QLog.e(str, "UnsatisfiedLinkError " + e.getLocalizedMessage());
                    }
                }
            }

            @Override // com.tencent.imsdk.looper.HttpClient.HttpRequestListener
            public void onCompleted(int i, Map<String, String> map, byte[] bArr) {
                String[] strArr;
                String[] strArr2;
                if (j2 != 0) {
                    if (map != null) {
                        String[] strArr3 = new String[map.size()];
                        String[] strArr4 = new String[map.size()];
                        int i2 = 0;
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            strArr3[i2] = entry.getKey();
                            strArr4[i2] = entry.getValue();
                            i2++;
                        }
                        strArr2 = strArr3;
                        strArr = strArr4;
                    } else {
                        strArr2 = null;
                        strArr = null;
                    }
                    try {
                        HttpClient.nativeResponseCallback(i, strArr2, strArr, bArr, j, j2);
                    } catch (UnsatisfiedLinkError e) {
                        QLog.e(HttpClient.TAG, "UnsatisfiedLinkError " + e.getLocalizedMessage());
                    }
                }
            }
        }, str5, i, i2, i3);
    }
}
