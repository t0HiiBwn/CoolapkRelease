package com.pgl.sys.a.b;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class a {
    private static boolean a;

    public static String a(String str, byte[] bArr) {
        URL url;
        try {
            url = new URL(str);
        } catch (Throwable unused) {
            url = null;
        }
        return a(url, bArr, "application/octet-stream");
    }

    private static String a(URL url, byte[] bArr, String str) {
        URLConnection openConnection;
        try {
            if (!"https".equals(url.getProtocol().toLowerCase()) || !a) {
                openConnection = url.openConnection();
            } else {
                HttpsURLConnection.setDefaultSSLSocketFactory(SSLContext.getInstance("TLS").getSocketFactory());
                openConnection = url.openConnection(Proxy.NO_PROXY);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestProperty("Content-Type", str);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                return String.format("{\"code\":%d}", Integer.valueOf(responseCode));
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStream.close();
                    outputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
            return "";
        }
    }
}
