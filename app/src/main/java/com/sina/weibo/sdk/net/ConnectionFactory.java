package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ConnectionFactory {
    public static HttpURLConnection createConnect(String str, Context context) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str) || (!str.startsWith("http://") && !str.startsWith("https://"))) {
            throw new RuntimeException("非法url请求");
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            URL url = new URL(str);
            Pair<String, Integer> apn = NetStateManager.getAPN();
            Proxy proxy = apn != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue())) : null;
            if (str.startsWith("http://")) {
                if (proxy == null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                }
            } else if (proxy == null) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) url.openConnection(proxy);
            }
            httpURLConnection2 = httpURLConnection;
        } catch (IOException | MalformedURLException unused) {
        }
        httpURLConnection2.setUseCaches(false);
        try {
            httpURLConnection2.setRequestMethod("POST");
        } catch (ProtocolException unused2) {
        }
        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection2.setRequestProperty("Charset", "UTF-8");
        httpURLConnection2.setReadTimeout(20000);
        httpURLConnection2.setConnectTimeout(25000);
        return httpURLConnection2;
    }
}
