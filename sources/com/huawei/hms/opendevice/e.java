package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: HttpClient */
public abstract class e {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    public static String a(Context context, String str, String str2, Map<String, String> map) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream2;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream3;
        BufferedOutputStream bufferedOutputStream3 = null;
        String a2 = null;
        bufferedOutputStream3 = null;
        if (str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        int i = -1;
        try {
            httpURLConnection2 = a(context, str, map, a.POST.a());
            if (httpURLConnection2 == null) {
                IOUtil.closeSecure((OutputStream) null);
                IOUtil.closeSecure((InputStream) null);
                IOUtil.closeSecure((InputStream) null);
            } else {
                try {
                    bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        bufferedOutputStream2.write(str2.getBytes("UTF-8"));
                        bufferedOutputStream2.flush();
                        i = httpURLConnection2.getResponseCode();
                        HMSLog.d("PushHttpClient", "http post response code: " + i);
                        if (i >= 400) {
                            inputStream3 = httpURLConnection2.getErrorStream();
                        } else {
                            inputStream3 = httpURLConnection2.getInputStream();
                        }
                    } catch (IOException unused) {
                        inputStream3 = null;
                        bufferedInputStream = inputStream3;
                        HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException unused2) {
                        inputStream3 = null;
                        bufferedInputStream = inputStream3;
                        HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception unused3) {
                        inputStream3 = null;
                        bufferedInputStream = inputStream3;
                        HMSLog.w("PushHttpClient", "http execute encounter unknown exception - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = null;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                        IOUtil.closeSecure(inputStream);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        throw th;
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(inputStream3);
                    } catch (IOException unused4) {
                        bufferedInputStream = null;
                        HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (RuntimeException unused5) {
                        bufferedInputStream = null;
                        HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Exception unused6) {
                        bufferedInputStream = null;
                        HMSLog.w("PushHttpClient", "http execute encounter unknown exception - http code:" + i);
                        inputStream2 = inputStream3;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        return null;
                    } catch (Throwable th3) {
                        bufferedOutputStream = bufferedOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        inputStream = inputStream3;
                        th = th3;
                        bufferedInputStream = null;
                        bufferedOutputStream3 = bufferedOutputStream;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                        IOUtil.closeSecure(inputStream);
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        throw th;
                    }
                } catch (IOException unused7) {
                    bufferedOutputStream2 = null;
                    inputStream3 = bufferedOutputStream2;
                    bufferedInputStream = inputStream3;
                    HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException unused8) {
                    bufferedOutputStream2 = null;
                    inputStream3 = bufferedOutputStream2;
                    bufferedInputStream = inputStream3;
                    HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception unused9) {
                    bufferedOutputStream2 = null;
                    inputStream3 = bufferedOutputStream2;
                    bufferedInputStream = inputStream3;
                    HMSLog.w("PushHttpClient", "http execute encounter unknown exception - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                    bufferedInputStream = null;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
                    IOUtil.closeSecure(inputStream);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    throw th;
                }
                try {
                    a2 = s.a((InputStream) bufferedInputStream);
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream3);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                } catch (IOException unused10) {
                    HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (RuntimeException unused11) {
                    HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                } catch (Exception unused12) {
                    HMSLog.w("PushHttpClient", "http execute encounter unknown exception - http code:" + i);
                    inputStream2 = inputStream3;
                    IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    return null;
                }
            }
            s.a(httpURLConnection2);
            HMSLog.i("PushHttpClient", "close connection");
            return a2;
        } catch (IOException unused13) {
            httpURLConnection2 = null;
            bufferedOutputStream2 = null;
            inputStream3 = bufferedOutputStream2;
            bufferedInputStream = inputStream3;
            HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
            inputStream2 = inputStream3;
            IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure((InputStream) bufferedInputStream);
            s.a(httpURLConnection2);
            HMSLog.i("PushHttpClient", "close connection");
            return null;
        } catch (RuntimeException unused14) {
            httpURLConnection2 = null;
            bufferedOutputStream2 = null;
            inputStream3 = bufferedOutputStream2;
            bufferedInputStream = inputStream3;
            HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
            inputStream2 = inputStream3;
            IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure((InputStream) bufferedInputStream);
            s.a(httpURLConnection2);
            HMSLog.i("PushHttpClient", "close connection");
            return null;
        } catch (Exception unused15) {
            httpURLConnection2 = null;
            bufferedOutputStream2 = null;
            inputStream3 = bufferedOutputStream2;
            bufferedInputStream = inputStream3;
            HMSLog.w("PushHttpClient", "http execute encounter unknown exception - http code:" + i);
            inputStream2 = inputStream3;
            IOUtil.closeSecure((OutputStream) bufferedOutputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure((InputStream) bufferedInputStream);
            s.a(httpURLConnection2);
            HMSLog.i("PushHttpClient", "close connection");
            return null;
        } catch (Throwable th5) {
            bufferedOutputStream = bufferedOutputStream2;
            httpURLConnection = httpURLConnection2;
            inputStream = inputStream3;
            th = th5;
            bufferedOutputStream3 = bufferedOutputStream;
            IOUtil.closeSecure((OutputStream) bufferedOutputStream3);
            IOUtil.closeSecure(inputStream);
            IOUtil.closeSecure((InputStream) bufferedInputStream);
            s.a(httpURLConnection);
            HMSLog.i("PushHttpClient", "close connection");
            throw th;
        }
    }

    private static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SecureSSLSocketFactory secureSSLSocketFactory = null;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(context);
            } catch (NoSuchAlgorithmException unused) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
            } catch (KeyStoreException unused2) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
            } catch (GeneralSecurityException unused3) {
                HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
            } catch (IOException unused4) {
                HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
            } catch (IllegalAccessException unused5) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
            } catch (IllegalArgumentException unused6) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
            }
            if (secureSSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
                httpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                return;
            }
            throw new Exception("No ssl socket factory set.");
        }
    }

    /* compiled from: HttpClient */
    public enum a {
        GET("GET"),
        POST("POST");
        
        private String c;

        private a(String str) {
            this.c = str;
        }

        public String a() {
            return this.c;
        }
    }
}
