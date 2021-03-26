package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HttpManager */
public class ah {
    private static final int a = 3;
    private static final int b = 20000;
    private static HostnameVerifier c;

    private static HostnameVerifier a(HttpsURLConnection httpsURLConnection) {
        if (c == null) {
            c = new HostnameVerifier() {
                /* class com.umeng.analytics.pro.ah.AnonymousClass1 */

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (!TextUtils.isEmpty(str)) {
                        return "ucc.umeng.com".equalsIgnoreCase(str) || "pslog.umeng.com".equalsIgnoreCase(str) || "pre-deeplink.umeng.com".equalsIgnoreCase(str) || "deeplink.umeng.com".equalsIgnoreCase(str);
                    }
                    return false;
                }
            };
        }
        return c;
    }

    public static String a(String str, JSONObject jSONObject) {
        return b(str, jSONObject.toString());
    }

    public static String a(String str, JSONArray jSONArray) {
        return b(str, jSONArray.toString());
    }

    public static String a(String str, String str2) {
        return b(str, str2);
    }

    public static String b(String str, String str2) {
        for (int i = 0; i < 3; i++) {
            try {
                HttpsURLConnection c2 = c(str, str2);
                if (c2 == null || c2.getResponseCode() != 200) {
                    return null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(c2.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStreamReader.read();
                    if (read == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) read);
                }
            } catch (Exception unused) {
                if (i == 2) {
                    return null;
                }
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return null;
    }

    private static HttpsURLConnection c(String str, String str2) {
        Exception e;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(instance.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a(httpsURLConnection2));
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(15000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(15000);
                httpsURLConnection2.setRequestProperty("Content-Type", "application/json");
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e2) {
                e = e2;
                httpsURLConnection = httpsURLConnection2;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return httpsURLConnection;
        }
    }
}
