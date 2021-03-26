package com.ali.auth.third.core.rpc;

import android.text.TextUtils;
import com.ali.auth.third.core.config.Environment;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.InternalSession;
import com.ali.auth.third.core.rpc.a.a;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.IOUtils;
import com.ali.auth.third.core.util.RSAKey;
import com.ali.auth.third.core.util.Rsa;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends a {
    private static final String a = "b";

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        throw new com.ali.auth.third.core.rpc.protocol.RpcException("net work error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ab, code lost:
        r5 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ae, code lost:
        r5 = r5.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007b A[ExcHandler: Exception (r5v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae  */
    private static String a(InputStream inputStream, String str) {
        String str2;
        String str3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            String str4 = null;
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (JSONException e) {
                str4 = str3;
                JSONException e2 = e;
                if (("response  =" + str4 + ":" + e2) != null) {
                }
                throw new RpcException((Integer) 10, str2);
            } catch (Exception e3) {
            }
        }
        str3 = new String(byteArrayOutputStream.toByteArray(), str);
        String a2 = com.ali.auth.third.core.rpc.protocol.b.a();
        String str5 = a;
        SDKLogger.e(str5, "raw response = " + str3);
        String b = a.a().b(str3, a2);
        SDKLogger.e(str5, "decrypt gateway response=" + b);
        JSONObject jSONObject = new JSONObject(b);
        int i = jSONObject.getInt("resultStatus");
        if (i == 1000) {
            return jSONObject.getString("result");
        }
        throw new RpcException(Integer.valueOf(i), "memo");
    }

    public static String a(String str, String str2) {
        String rsaPubkey = RSAKey.getRsaPubkey();
        if (!TextUtils.isEmpty(rsaPubkey)) {
            String encrypt = Rsa.encrypt(str, rsaPubkey);
            String str3 = null;
            try {
                str3 = a.a().a(str2, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return String.format(Locale.getDefault(), "%08X%s%08X%s", Integer.valueOf(encrypt.length()), encrypt, Integer.valueOf(str3.length()), str3);
        }
        throw new IllegalArgumentException("get rsa from server failed!!!");
    }

    public static String a(String str, String str2, String str3) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        OutputStreamWriter outputStreamWriter;
        SDKLogger.d(a, "post target = " + str + " params" + str3);
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            httpURLConnection = (HttpURLConnection) (KernelContext.getEnvironment() == Environment.PRE ? new URL("http://hz.pre.tbusergw.taobao.net/gw.do").openConnection() : KernelContext.getEnvironment() == Environment.TEST ? new URL("http://hz.tbusergw.taobao.net/gw.do").openConnection() : new URL("https://mgw.m.taobao.com/gw.do").openConnection());
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                InternalSession internalSession = CredentialManager.INSTANCE.getInternalSession();
                if (internalSession.user != null && !TextUtils.isEmpty(internalSession.user.userId)) {
                    httpURLConnection.setRequestProperty("userid", internalSession.user.userId);
                }
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw new RuntimeException(th);
                } catch (Throwable th3) {
                    IOUtils.closeQuietly(outputStreamWriter2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    throw th3;
                }
            }
            try {
                outputStreamWriter.write(b(str, str2, str3));
                outputStreamWriter.flush();
                a(httpURLConnection.getResponseCode());
                String a2 = a(httpURLConnection.getInputStream(), a(httpURLConnection.getContentType()));
                IOUtils.closeQuietly(outputStreamWriter);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                return a2;
            } catch (Throwable th4) {
                th = th4;
                outputStreamWriter2 = outputStreamWriter;
                throw new RuntimeException(th);
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            throw new RuntimeException(th);
        }
    }

    public static String b(String str, String str2, String str3) {
        String a2 = com.ali.auth.third.core.rpc.protocol.a.a(16);
        com.ali.auth.third.core.rpc.protocol.b.a(a2);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("id=1&");
            sb.append("apiName=" + str + "&");
            sb.append("apiVersion=" + str2 + "&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestData=");
            sb2.append(URLEncoder.encode(a(a2, str3), "UTF-8"));
            sb.append(sb2.toString());
            sb.append("&symType=AES");
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            SDKLogger.e(a, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
