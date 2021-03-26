package com.tencent.tpns.baseapi.core.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a {
    private static a a;
    private Context b = null;

    private a(Context context) {
        if (context == null) {
            return;
        }
        if (context.getApplicationContext() != null) {
            this.b = context.getApplicationContext();
        } else {
            this.b = context;
        }
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cb  */
    public String a(String str, final String str2, String str3, HttpRequestCallback httpRequestCallback) {
        String str4;
        String str5;
        URL url;
        HttpURLConnection httpURLConnection;
        int responseCode;
        Throwable th;
        String str6 = "";
        ConnectException connectException = null;
        if (str3 == null) {
            return null;
        }
        int i = 0;
        try {
            Logger.d("HttpRequest", "[" + str + "]Send request(" + str3.length() + "bytes), content:" + str3);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                str4 = jSONObject.optString("accessId", str6);
                try {
                    str5 = jSONObject.optString("sdkVersion", str6);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                str4 = str6;
                Logger.e("HttpRequest", "parse request body to json error: " + th.toString());
                str5 = str6;
                Logger.d("HttpRequest", "sendHttpPost | url: " + str + " hostName: " + str2);
                url = new URL(str);
                if (!url.getProtocol().toLowerCase().equals("https")) {
                }
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "json");
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestProperty("AccessId", str4);
                httpURLConnection.setRequestProperty("SdkVersion", str5);
                byte[] bytes = str3.getBytes("UTF-8");
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                Logger.d("HttpRequest", "http recv response status code:" + responseCode + ", responseMsg:" + responseMessage + ",contentLength:" + httpURLConnection.getContentLength());
                if (responseCode != 200) {
                }
                dataOutputStream.close();
                httpURLConnection.disconnect();
                if (connectException != null) {
                }
                return str6;
            }
            Logger.d("HttpRequest", "sendHttpPost | url: " + str + " hostName: " + str2);
            url = new URL(str);
            if (!url.getProtocol().toLowerCase().equals("https")) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("host", str2);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                    /* class com.tencent.tpns.baseapi.core.net.a.AnonymousClass1 */

                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        Logger.d("HttpRequest", "HostnameVerifier : hostName " + str);
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                    }
                });
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("host", str2);
            }
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "json");
            httpURLConnection.setConnectTimeout(15000);
            if (str4 != null && str4.length() > 0) {
                httpURLConnection.setRequestProperty("AccessId", str4);
            }
            if (str5 != null && str5.length() > 0) {
                httpURLConnection.setRequestProperty("SdkVersion", str5);
            }
            byte[] bytes = str3.getBytes("UTF-8");
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            Logger.d("HttpRequest", "http recv response status code:" + responseCode + ", responseMsg:" + responseMessage + ",contentLength:" + httpURLConnection.getContentLength());
            if (responseCode != 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str6 = str6 + readLine;
                }
                Logger.d("HttpRequest", "http get response data:" + str6);
                if (httpRequestCallback != null) {
                    httpRequestCallback.onSuccess(str6);
                }
                bufferedReader.close();
            } else {
                Logger.e("HttpRequest", "Server response error code:" + responseCode + ", error:" + responseMessage);
                if (httpRequestCallback != null) {
                    httpRequestCallback.onFailure(-510, "Http返回:" + responseCode + ", " + responseMessage);
                }
            }
            dataOutputStream.close();
            httpURLConnection.disconnect();
        } catch (UnknownHostException e) {
            connectException = e;
            i = -506;
        } catch (SocketTimeoutException e2) {
            connectException = e2;
            i = -512;
        } catch (ConnectException e3) {
            connectException = e3;
            i = -513;
        } catch (Throwable th4) {
            connectException = th4;
            i = -511;
        }
        if (connectException != null) {
            Logger.e("HttpRequest", "Http Request Error, Tr: " + connectException.toString(), connectException);
            if (httpRequestCallback != null) {
                try {
                    httpRequestCallback.onFailure(i, "HttpRequest Throw Error:" + connectException);
                } catch (Throwable th5) {
                    Logger.e("HttpRequest", "Callback Error, Tr:", th5);
                }
            }
        }
        return str6;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            Logger.e("HttpRequest", "getHostName Exception :", e);
            return "";
        }
    }
}
