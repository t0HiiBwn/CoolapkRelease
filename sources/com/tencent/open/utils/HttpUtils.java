package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.open.utils.j;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class HttpUtils {
    private HttpUtils() {
    }

    /* compiled from: ProGuard */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:632)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:277)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:108)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:54)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:97)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:91)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:259)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:252)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:341)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:294)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:263)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00dd, code lost:
        r0.printStackTrace();
        com.tencent.open.b.g.a().a(r4, r5, 0, 0, -4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ec, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ee, code lost:
        r0.printStackTrace();
        com.tencent.open.b.g.a().a(r4, r5, 0, 0, getErrorCodeFromException(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0100, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0101, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0102, code lost:
        r0.printStackTrace();
        com.tencent.open.b.g.a().a(r4, r5, 0, 0, -3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0111, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0112, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0113, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0116, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0117, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012c, code lost:
        r11 = java.lang.Integer.parseInt(r0.getMessage().replace("http status code error:", ""));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x012f, code lost:
        r0.printStackTrace();
        r11 = -9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0142, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0143, code lost:
        r0.printStackTrace();
        r13 = -8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014b, code lost:
        if (r7 < r8) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014d, code lost:
        r5 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0152, code lost:
        com.tencent.open.b.g.a().a(r4, r5, 0, 0, -8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x015e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x015f, code lost:
        r0.printStackTrace();
        r13 = -7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0167, code lost:
        if (r7 < r8) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0169, code lost:
        r5 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x016f, code lost:
        r0 = r3;
        r7 = 0;
        r11 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017a, code lost:
        com.tencent.open.b.g.a().a(r4, r5, 0, 0, -7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0185, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016d, code lost:
        continue;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ed A[ExcHandler: IOException (r0v14 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0101 A[ExcHandler: MalformedURLException (r0v13 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0112 A[ExcHandler: NetworkUnavailableException (r0v12 'e' com.tencent.open.utils.HttpUtils$NetworkUnavailableException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0117 A[ExcHandler: HttpStatusException (r0v6 'e' com.tencent.open.utils.HttpUtils$HttpStatusException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142 A[ExcHandler: SocketTimeoutException (r0v5 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015e A[ExcHandler: ConnectTimeoutException (r0v4 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), Splitter:B:9:0x00c0] */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken qQToken, android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
        // Method dump skipped, instructions count: 390
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new Thread() {
            /* class com.tencent.open.utils.HttpUtils.AnonymousClass1 */

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(qQToken, context, str, bundle, str2);
                    IRequestListener iRequestListener = iRequestListener;
                    if (iRequestListener != null) {
                        iRequestListener.onComplete(request);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (MalformedURLException e2) {
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onMalformedURLException(e2);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e2);
                    }
                } catch (ConnectTimeoutException e3) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onConnectTimeoutException(e3);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e3);
                    }
                } catch (SocketTimeoutException e4) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onSocketTimeoutException(e4);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e4);
                    }
                } catch (NetworkUnavailableException e5) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onNetworkUnavailableException(e5);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e5);
                    }
                } catch (HttpStatusException e6) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onHttpStatusException(e6);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e6);
                    }
                } catch (IOException e7) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onIOException(e7);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e7);
                    }
                } catch (JSONException e8) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onJSONException(e8);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e8);
                    }
                } catch (Exception e9) {
                    IRequestListener iRequestListener9 = iRequestListener;
                    if (iRequestListener9 != null) {
                        iRequestListener9.onUnknowException(e9);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e9);
                    }
                }
            }
        }.start();
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static j.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable())) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            String string = bundle2.getString("appid_for_getting_config");
            bundle2.remove("appid_for_getting_config");
            HttpClient httpClient = getHttpClient(context, string, str);
            HttpGet httpGet = null;
            int i = 0;
            int i2 = -1;
            if (str2.equals("GET")) {
                String encodeUrl = encodeUrl(bundle2);
                i = 0 + encodeUrl.length();
                f.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
                String str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
                f.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(encodeUrl);
                httpGet = new HttpGet(sb.toString());
                httpGet.addHeader("Accept-Encoding", "gzip");
            } else if (str2.equals("POST")) {
                httpGet = new HttpPost(str);
                httpGet.addHeader("Accept-Encoding", "gzip");
                Bundle bundle3 = new Bundle();
                for (String str4 : bundle2.keySet()) {
                    Object obj = bundle2.get(str4);
                    if (obj instanceof byte[]) {
                        bundle3.putByteArray(str4, (byte[]) obj);
                    }
                }
                if (!bundle2.containsKey("method")) {
                    bundle2.putString("method", str2);
                }
                httpGet.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
                httpGet.setHeader("Connection", "Keep-Alive");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(j.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                byteArrayOutputStream.write(j.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
                if (!bundle3.isEmpty()) {
                    int size = bundle3.size();
                    byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    for (String str5 : bundle3.keySet()) {
                        i2++;
                        byteArrayOutputStream.write(j.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                        byteArrayOutputStream.write(j.i("Content-Type: content/unknown\r\n\r\n"));
                        byte[] byteArray = bundle3.getByteArray(str5);
                        if (byteArray != null) {
                            byteArrayOutputStream.write(byteArray);
                        }
                        if (i2 < size - 1) {
                            byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        }
                    }
                }
                byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                i = 0 + byteArray2.length;
                byteArrayOutputStream.close();
                httpGet.setEntity(new ByteArrayEntity(byteArray2));
            }
            HttpResponse execute = httpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return new j.a(a(execute), i);
            }
            throw new HttpStatusException("http status code error:" + statusCode);
        }
        throw new NetworkUnavailableException("network unavailable");
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
            content = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = content.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                content.close();
                return str;
            }
        }
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int i;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        f fVar = null;
        if (Build.VERSION.SDK_INT < 16) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                a aVar = new a(instance);
                aVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", aVar, 443));
            } catch (Exception unused) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        if (context != null) {
            fVar = f.a(context, str);
        }
        int i2 = 0;
        if (fVar != null) {
            i2 = fVar.a("Common_HttpConnectionTimeout");
            i = fVar.a("Common_SocketConnectionTimeout");
        } else {
            i = 0;
        }
        if (i2 == 0) {
            i2 = 15000;
        }
        if (i == 0) {
            i = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        c proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(proxy.a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                sb.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                sb.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            i++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                if (i < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
            }
        }
        return sb.toString();
    }

    public static c getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!(context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0)) {
            String b2 = b(context);
            int a2 = a(context);
            if (!TextUtils.isEmpty(b2) && a2 >= 0) {
                return new c(b2, a2);
            }
        }
        return null;
    }

    /* compiled from: ProGuard */
    public static class c {
        public final String a;
        public final int b;

        private c(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    private static int a(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            int port = Proxy.getPort(context);
            if (port < 0) {
                return Proxy.getDefaultPort();
            }
            return port;
        }
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        String host = Proxy.getHost(context);
        if (TextUtils.isEmpty(host)) {
            return Proxy.getDefaultHost();
        }
        return host;
    }

    /* compiled from: ProGuard */
    public static class a extends SSLSocketFactory {
        private final SSLContext a = SSLContext.getInstance("TLS");

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            b bVar;
            try {
                bVar = new b();
            } catch (Exception unused) {
                bVar = null;
            }
            this.a.init(null, new TrustManager[]{bVar}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }
    }

    /* compiled from: ProGuard */
    public static class b implements X509TrustManager {
        X509TrustManager a;

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
        b() throws Exception {
            KeyStore keyStore;
            TrustManager[] trustManagerArr;
            FileInputStream fileInputStream;
            Throwable th;
            try {
                keyStore = KeyStore.getInstance("JKS");
            } catch (Exception unused) {
                keyStore = null;
            }
            if (keyStore != null) {
                try {
                    fileInputStream = new FileInputStream("trustedCerts");
                    try {
                        keyStore.load(fileInputStream, "passphrase".toCharArray());
                        TrustManagerFactory instance = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                        instance.init(keyStore);
                        trustManagerArr = instance.getTrustManagers();
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileInputStream = null;
                    th = th3;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } else {
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init((KeyStore) null);
                trustManagerArr = instance2.getTrustManagers();
            }
            for (int i = 0; i < trustManagerArr.length; i++) {
                if (trustManagerArr[i] instanceof X509TrustManager) {
                    this.a = (X509TrustManager) trustManagerArr[i];
                    return;
                }
            }
            throw new Exception("Couldn't initialize");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.a.getAcceptedIssuers();
        }
    }
}
