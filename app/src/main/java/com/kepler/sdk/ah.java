package com.kepler.sdk;

import android.content.Context;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ah implements Runnable {
    private String a = "";
    private final String b;

    ah(String str, String str2, Context context) {
        this.b = str;
        this.a = str2;
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    URLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "text/xml;charset=GBK");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.length()));
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(str.getBytes());
        outputStream.flush();
        outputStream.close();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b0 A[SYNTHETIC, Splitter:B:45:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        if (aj.c() != null) {
            String str = this.a + "&_dId=" + aj.c();
            HttpURLConnection httpURLConnection = null;
            try {
                URLConnection a2 = a(str);
                try {
                    a2.connect();
                    bufferedInputStream = new BufferedInputStream(a2.getInputStream());
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    httpURLConnection = a2;
                    try {
                        j.b("suwg", "update data" + th.getMessage());
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (httpURLConnection != null && (httpURLConnection instanceof HttpURLConnection)) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                    while (true) {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    }
                    boolean z = true;
                    if (a2 instanceof HttpURLConnection) {
                        int responseCode = ((HttpURLConnection) a2).getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            z = false;
                        }
                    }
                    if (z) {
                        byteArrayOutputStream.toString("UTF-8");
                        if (str.contains("&events=")) {
                            aj.a("kepler_eday");
                        } else if (str.contains("&start=")) {
                            aj.b();
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    if (a2 != null && (a2 instanceof HttpURLConnection)) {
                        ((HttpURLConnection) a2).disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = a2;
                    j.b("suwg", "update data" + th.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                j.b("suwg", "update data" + th.getMessage());
            }
        }
    }
}
