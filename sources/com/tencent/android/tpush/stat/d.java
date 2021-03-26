package com.tencent.android.tpush.stat;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.stat.a.a;
import com.tencent.android.tpush.stat.a.b;
import com.tencent.android.tpush.stat.event.c;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class d {
    private static volatile d a;
    private static b b = a.b();
    private static Context c = null;
    private StringBuilder d = new StringBuilder(4096);
    private long e = 0;

    private d(Context context) {
        try {
            c = context.getApplicationContext();
            this.e = System.currentTimeMillis() / 1000;
        } catch (Throwable th) {
            b.b(th);
        }
    }

    static void a(Context context) {
        c = context.getApplicationContext();
    }

    static Context a() {
        return c;
    }

    public static d b(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private void a(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull("cfg")) {
                b.a(c, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (b.b()) {
                    b bVar = b;
                    bVar.b("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                a.e(c);
                a.a(c, currentTimeMillis);
            }
        } catch (Throwable th) {
            b.d(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0343  */
    void a(List<?> list, c cVar) {
        Throwable th;
        String str;
        String str2;
        URL url;
        HttpURLConnection httpURLConnection;
        int responseCode;
        Throwable th2;
        String str3;
        String str4 = "";
        if (list != null && !list.isEmpty()) {
            if (CloudManager.getInstance(c).isCloudRefuse()) {
                b.d("sendHttpsPost refused by cloud");
                return;
            }
            int size = list.size();
            Throwable th3 = null;
            try {
                StringBuilder sb = this.d;
                sb.delete(0, sb.length());
                this.d.append("[");
                for (int i = 0; i < size; i++) {
                    String obj = list.get(i).toString();
                    try {
                        if (Util.checkAccessId(new JSONObject(obj).optLong("accessId", 0))) {
                            this.d.append(obj);
                            if (i != size - 1) {
                                this.d.append(",");
                            }
                        }
                    } catch (Throwable unused) {
                        b.d("unexpected for:" + th3.getMessage());
                    }
                }
                this.d.append("]");
                String sb2 = this.d.toString();
                int length = sb2.length();
                String statServerAddr = XGApiConfig.getStatServerAddr(c);
                try {
                    JSONObject jSONObject = new JSONObject(list.get(0).toString());
                    String optString = jSONObject.optString("msgId", str4);
                    str2 = jSONObject.optString("accessId", str4);
                    try {
                        str = jSONObject.optString("sdkVersion", str4);
                        try {
                            if (!TextUtils.isEmpty(optString)) {
                                b.h("stat for pushAction");
                            } else {
                                if (jSONObject.has("customEvent")) {
                                    str3 = XGApiConfig.getCustomEvenServerAddr(c);
                                } else {
                                    str3 = XGApiConfig.getErrCodeServerAddr(c);
                                }
                                statServerAddr = str3;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            b.f("parse event to json error: " + th2.toString());
                            if (b.b()) {
                            }
                            url = new URL(statServerAddr);
                            if (!url.getProtocol().toLowerCase().equals("https")) {
                            }
                            httpURLConnection.setReadTimeout(10000);
                            httpURLConnection.setConnectTimeout(15000);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            httpURLConnection.setRequestProperty("AccessId", str2);
                            httpURLConnection.setRequestProperty("SdkVersion", str);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                            byte[] bytes = sb2.getBytes("utf-8");
                            int length2 = bytes.length;
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bytes);
                            gZIPOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (b.b()) {
                            }
                            httpURLConnection.setRequestProperty("ContentAuth", com.tencent.android.tpush.encrypt.a.a(bytes));
                            httpURLConnection.setRequestProperty("ContentGzipAuth", com.tencent.android.tpush.encrypt.a.a(byteArray));
                            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            dataOutputStream.write(byteArray);
                            dataOutputStream.flush();
                            responseCode = httpURLConnection.getResponseCode();
                            String responseMessage = httpURLConnection.getResponseMessage();
                            int contentLength = httpURLConnection.getContentLength();
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            if (b.b()) {
                            }
                            if (responseCode != 200) {
                            }
                            dataOutputStream.close();
                            byteArrayOutputStream.close();
                            th = null;
                            if (th == null) {
                            }
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        str = str4;
                        b.f("parse event to json error: " + th2.toString());
                        if (b.b()) {
                        }
                        url = new URL(statServerAddr);
                        if (!url.getProtocol().toLowerCase().equals("https")) {
                        }
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setConnectTimeout(15000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        httpURLConnection.setRequestProperty("AccessId", str2);
                        httpURLConnection.setRequestProperty("SdkVersion", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                        byte[] bytes = sb2.getBytes("utf-8");
                        int length2 = bytes.length;
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (b.b()) {
                        }
                        httpURLConnection.setRequestProperty("ContentAuth", com.tencent.android.tpush.encrypt.a.a(bytes));
                        httpURLConnection.setRequestProperty("ContentGzipAuth", com.tencent.android.tpush.encrypt.a.a(byteArray));
                        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        dataOutputStream.write(byteArray);
                        dataOutputStream.flush();
                        responseCode = httpURLConnection.getResponseCode();
                        String responseMessage = httpURLConnection.getResponseMessage();
                        int contentLength = httpURLConnection.getContentLength();
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        if (b.b()) {
                        }
                        if (responseCode != 200) {
                        }
                        dataOutputStream.close();
                        byteArrayOutputStream.close();
                        th = null;
                        if (th == null) {
                        }
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    str2 = str4;
                    str = str2;
                    b.f("parse event to json error: " + th2.toString());
                    if (b.b()) {
                    }
                    url = new URL(statServerAddr);
                    if (!url.getProtocol().toLowerCase().equals("https")) {
                    }
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    httpURLConnection.setRequestProperty("AccessId", str2);
                    httpURLConnection.setRequestProperty("SdkVersion", str);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                    byte[] bytes = sb2.getBytes("utf-8");
                    int length2 = bytes.length;
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (b.b()) {
                    }
                    httpURLConnection.setRequestProperty("ContentAuth", com.tencent.android.tpush.encrypt.a.a(bytes));
                    httpURLConnection.setRequestProperty("ContentGzipAuth", com.tencent.android.tpush.encrypt.a.a(byteArray));
                    httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(byteArray);
                    dataOutputStream.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    String responseMessage = httpURLConnection.getResponseMessage();
                    int contentLength = httpURLConnection.getContentLength();
                    String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                    if (b.b()) {
                    }
                    if (responseCode != 200) {
                    }
                    dataOutputStream.close();
                    byteArrayOutputStream.close();
                    th = null;
                    if (th == null) {
                    }
                }
                if (b.b()) {
                    b.b("[" + statServerAddr + "]Send request(" + length + "bytes), content:" + sb2);
                }
                url = new URL(statServerAddr);
                if (!url.getProtocol().toLowerCase().equals("https")) {
                    httpURLConnection = (HttpsURLConnection) url.openConnection();
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (str2 != null && str2.length() > 0) {
                    httpURLConnection.setRequestProperty("AccessId", str2);
                }
                if (str != null && str.length() > 0) {
                    httpURLConnection.setRequestProperty("SdkVersion", str);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = sb2.getBytes("utf-8");
                int length2 = bytes.length;
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (b.b()) {
                    b.h("before Gzip:" + length2 + " bytes, after Gzip:" + byteArray.length + " bytes");
                }
                httpURLConnection.setRequestProperty("ContentAuth", com.tencent.android.tpush.encrypt.a.a(bytes));
                httpURLConnection.setRequestProperty("ContentGzipAuth", com.tencent.android.tpush.encrypt.a.a(byteArray));
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(byteArray);
                dataOutputStream.flush();
                responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                int contentLength = httpURLConnection.getContentLength();
                String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                if (b.b()) {
                    b.b("http recv response status code:" + responseCode + ", responseMsg:" + responseMessage + ",contentLength:" + contentLength + ",contentEncoding:" + headerField);
                }
                if (responseCode != 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    byte[] bArr = new byte[contentLength];
                    dataInputStream.readFully(bArr);
                    inputStream.close();
                    dataInputStream.close();
                    if (TextUtils.isEmpty(headerField)) {
                        str4 = new String(bArr, Charset.forName("UTF-8"));
                    } else if (headerField.equalsIgnoreCase("gzip,rc4")) {
                        str4 = new String(RC4.decrypt(a.a(bArr)), Charset.forName("UTF-8"));
                    } else if (headerField.equalsIgnoreCase("rc4,gzip")) {
                        str4 = new String(a.a(RC4.decrypt(bArr)), Charset.forName("UTF-8"));
                    } else if (headerField.equalsIgnoreCase("gzip")) {
                        str4 = new String(a.a(bArr), Charset.forName("UTF-8"));
                    } else if (headerField.equalsIgnoreCase("rc4")) {
                        str4 = new String(RC4.decrypt(bArr), Charset.forName("UTF-8"));
                    }
                    b.b("http recv response data: " + str4);
                    if (str4.length() > 0) {
                        JSONObject jSONObject2 = new JSONObject(str4);
                        a(jSONObject2);
                        if (cVar != null) {
                            int optInt = jSONObject2.optInt("ret_code", -1);
                            if (optInt == 0) {
                                b.b("http data upload ok");
                                cVar.a();
                                b.b("send Event success:" + sb2);
                            } else {
                                b.e("http response error data ret_code = " + optInt);
                                cVar.b();
                            }
                        }
                    } else {
                        b.e("http response data null");
                        cVar.b();
                    }
                } else {
                    b.e("Server response error code:" + responseCode + ", error:" + responseMessage);
                    if (cVar != null) {
                        cVar.b();
                    }
                }
                dataOutputStream.close();
                byteArrayOutputStream.close();
                th = null;
            } catch (Throwable th7) {
                th = th7;
            }
            if (th == null) {
                b.a(th);
                if (cVar != null) {
                    try {
                        cVar.b();
                    } catch (Throwable th8) {
                        b.b(th8);
                    }
                }
                if (th instanceof OutOfMemoryError) {
                    this.d = null;
                    System.gc();
                    this.d = new StringBuilder(2048);
                } else if (!(th instanceof UnknownHostException)) {
                    boolean z = th instanceof SocketTimeoutException;
                }
            }
        }
    }

    void b(List<?> list, c cVar) {
        try {
            if (!j.b(GuidInfoManager.getToken(c))) {
                a(list, cVar);
            } else if (cVar != null) {
                cVar.a();
            }
        } catch (Throwable unused) {
            b.c("unexpected for sendList");
        }
    }

    public void a(c cVar, c cVar2) {
        b(Arrays.asList(cVar.b()), cVar2);
    }
}
