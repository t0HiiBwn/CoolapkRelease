package com.tencent.beacon.core.c;

import android.content.Context;
import android.net.Proxy;
import com.tencent.beacon.core.d.c;
import com.tencent.beacon.core.protocol.common.SocketRequestPackage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* compiled from: RequestHandlerAbs */
public abstract class f {
    private static f a;

    public abstract boolean a();

    public byte[] a(String str, int i, byte[] bArr, a aVar, e eVar) throws Exception {
        return null;
    }

    public byte[] a(String str, byte[] bArr, a aVar, e eVar) throws Exception {
        return null;
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            boolean h = com.tencent.beacon.core.strategy.a.a().h();
            f fVar2 = a;
            if (fVar2 == null && context != null) {
                a(context, h);
            } else if (!(fVar2 == null || fVar2.a() == h)) {
                a(context, h);
            }
            fVar = a;
        }
        return fVar;
    }

    private static void a(Context context, boolean z) {
        if (z) {
            a = new b(context);
        } else {
            a = new a(context);
        }
    }

    /* compiled from: RequestHandlerAbs */
    private static class a extends f {
        private Context a;

        @Override // com.tencent.beacon.core.c.f
        public final boolean a() {
            return false;
        }

        public a(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r12v1, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x010b, code lost:
            if (r5 < 0) goto L_0x010d;
         */
        @Override // com.tencent.beacon.core.c.f
        public final byte[] a(String str, byte[] bArr, a aVar, e eVar) throws Exception {
            long j;
            String str2;
            long j2;
            long j3;
            byte[] bArr2 = bArr;
            int i = 0;
            if (str == null) {
                com.tencent.beacon.core.d.b.d("[net] destUrl is null.", new Object[0]);
                return null;
            }
            int i2 = 3;
            int i3 = 1;
            int i4 = 2;
            com.tencent.beacon.core.d.b.b("[net] HTTP requestCmd(%d) moduleId(%d) eventCnt(%d)", Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.e));
            if (bArr2 == null) {
                j = 0;
            } else {
                j = (long) bArr2.length;
            }
            com.tencent.beacon.core.d.b.h("[net] request url:%s sz:%d", str, Long.valueOf(j));
            String str3 = str;
            String str4 = "";
            String str5 = str4;
            b bVar = null;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= i2 || i6 >= i4) {
                    break;
                } else if (!z) {
                    if (i7 > i3) {
                        com.tencent.beacon.core.d.b.h("[net] try time:" + i7, new Object[i]);
                        if (i7 == i4 && aVar.c() == i4) {
                            aVar.b(i);
                        }
                        b();
                    }
                    String c = c.c(this.a);
                    String str6 = str3;
                    String str7 = str4;
                    eVar.a(str3, j, c, i7);
                    long time = new Date().getTime();
                    try {
                        bVar = a(str6, bArr2, c, i7);
                        str5 = str5;
                    } catch (Exception e) {
                        String exc = e.toString();
                        if (str7.equals(exc)) {
                            str2 = str5 + i7 + ":same ";
                        } else {
                            str2 = str5 + i7 + ":" + exc + " ";
                        }
                        str7 = exc;
                        str5 = str2;
                    }
                    long time2 = new Date().getTime() - time;
                    if (bVar != null) {
                        HttpResponse httpResponse = bVar.a;
                        HttpEntity entity = httpResponse.getEntity();
                        if (entity != null) {
                            j2 = entity.getContentLength();
                        }
                        j2 = 0;
                        int statusCode = httpResponse.getStatusLine().getStatusCode();
                        com.tencent.beacon.core.d.b.h("[net] response code:%d ", Integer.valueOf(statusCode));
                        if (statusCode != 200) {
                            if (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) {
                                Header firstHeader = httpResponse.getFirstHeader("Location");
                                if (firstHeader == null) {
                                    com.tencent.beacon.core.d.b.d("[net] redirect code:" + statusCode + " Location is null! return", new Object[0]);
                                    try {
                                        if (bVar.b == null) {
                                            return null;
                                        }
                                        bVar.b.abort();
                                        return null;
                                    } catch (Exception unused) {
                                        return null;
                                    }
                                } else {
                                    int i8 = i6 + 1;
                                    String value = firstHeader.getValue();
                                    i4 = 2;
                                    com.tencent.beacon.core.d.b.h("[net] redirect code:%d , to:%s", Integer.valueOf(statusCode), value);
                                    try {
                                        if (bVar.b != null) {
                                            bVar.b.abort();
                                        }
                                    } catch (Exception unused2) {
                                    }
                                    str6 = value;
                                    i6 = i8;
                                    i7 = 0;
                                    z = true;
                                }
                            } else {
                                i4 = 2;
                                i6 = i6;
                            }
                            eVar.a(j2, time2);
                            bArr2 = bArr;
                            bVar = bVar;
                            i5 = i7;
                            str3 = str6;
                            str4 = str7;
                        } else if (httpResponse.containsHeader("encrypt-status")) {
                            com.tencent.beacon.core.d.b.d("[net] svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new Object[0]);
                            return null;
                        } else {
                            byte[] a2 = a(httpResponse, bVar.b);
                            if (a2 == null) {
                                j3 = 0;
                            } else {
                                j3 = (long) a2.length;
                            }
                            eVar.a(j3, time2);
                            return a2;
                        }
                    } else {
                        i4 = 2;
                        eVar.a(0, time2);
                        bArr2 = bArr;
                        bVar = bVar;
                        i5 = i7;
                        str3 = str6;
                        str4 = str7;
                        i6 = i6;
                    }
                    i = 0;
                    i2 = 3;
                    i3 = 1;
                } else {
                    throw new Exception("net redirect");
                }
            }
            throw new Exception(str5);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
        private static b a(String str, byte[] bArr, String str2, int i) throws Exception {
            Throwable th;
            ByteArrayEntity byteArrayEntity;
            HttpPost httpPost = null;
            if (str == null) {
                com.tencent.beacon.core.d.b.d("[net] destUrl is null.", new Object[0]);
                return null;
            }
            if (bArr != null) {
                try {
                    byteArrayEntity = new ByteArrayEntity(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    com.tencent.beacon.core.d.b.a(th);
                    com.tencent.beacon.core.d.b.d("[net] execute error:%s", th.toString());
                    if (httpPost != null) {
                    }
                    throw new Exception(th.toString());
                }
            } else {
                byteArrayEntity = new ByteArrayEntity("".getBytes());
            }
            HttpClient a2 = a(str2, i);
            if (a2 == null) {
                com.tencent.beacon.core.d.b.d("[net] no httpClient!", new Object[0]);
                return null;
            }
            HttpPost httpPost2 = new HttpPost(str);
            try {
                httpPost2.setHeader("wup_version", "3.0");
                httpPost2.setHeader("TYPE_COMPRESS", "2");
                httpPost2.setHeader("encr_type", "rsapost");
                com.tencent.beacon.core.strategy.a a3 = com.tencent.beacon.core.strategy.a.a();
                if (a3 != null) {
                    httpPost2.setHeader("bea_key", a3.n());
                }
                httpPost2.setEntity(byteArrayEntity);
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                HttpResponse execute = a2.execute(httpPost2, basicHttpContext);
                com.tencent.beacon.core.d.b.h("[net] execute request:\n %s", ((HttpRequest) basicHttpContext.getAttribute("http.request")).getRequestLine().toString());
                return new b(execute, httpPost2);
            } catch (Throwable th3) {
                th = th3;
                httpPost = httpPost2;
                com.tencent.beacon.core.d.b.a(th);
                com.tencent.beacon.core.d.b.d("[net] execute error:%s", th.toString());
                if (httpPost != null) {
                    httpPost.abort();
                }
                throw new Exception(th.toString());
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
            if (r9 == null) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
            r9.abort();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00af, code lost:
            if (r9 != null) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b2, code lost:
            return r0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[SYNTHETIC, Splitter:B:36:0x00a7] */
        private byte[] a(HttpResponse httpResponse, HttpPost httpPost) {
            Throwable th;
            BufferedInputStream bufferedInputStream;
            byte[] bArr = null;
            if (httpResponse == null) {
                return null;
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                com.tencent.beacon.core.d.b.c("[net] request failure code:%d , line:%s ", Integer.valueOf(statusCode), httpResponse.getStatusLine());
                return null;
            }
            if (httpResponse.containsHeader("session_id") && httpResponse.containsHeader("max_time")) {
                com.tencent.beacon.core.strategy.a.a().a(this.a, httpResponse.getFirstHeader("session_id").getValue(), httpResponse.getFirstHeader("max_time").getValue());
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                com.tencent.beacon.core.d.b.d("[net] no response data", new Object[0]);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new DataInputStream(entity.getContent()));
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        com.tencent.beacon.core.d.b.a(th2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.tencent.beacon.core.d.b.a(th);
                        com.tencent.beacon.core.d.b.d("[net] read error %s", th.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th4) {
                                com.tencent.beacon.core.d.b.a(th4);
                            }
                        }
                    } catch (Throwable th5) {
                        com.tencent.beacon.core.d.b.a(th5);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                com.tencent.beacon.core.d.b.a(th);
                com.tencent.beacon.core.d.b.d("[net] read error %s", th.toString());
                if (bufferedInputStream != null) {
                }
            }
            if (httpPost != null) {
                httpPost.abort();
            }
            throw th;
        }

        private static HttpClient a(String str, int i) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
                basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
                defaultHttpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
                    /* class com.tencent.beacon.core.c.f.a.AnonymousClass1 */

                    public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
                        if (i >= 3) {
                            return false;
                        }
                        return (iOException instanceof NoHttpResponseException) || (iOException instanceof ClientProtocolException);
                    }
                });
                if (str == null || !str.toLowerCase(Locale.US).contains("wap") || i == 2) {
                    if (str != null) {
                        com.tencent.beacon.core.d.b.a("[net] Don't use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    }
                    defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                } else {
                    com.tencent.beacon.core.d.b.a("[net] use proxy: %s, try time: %s", str, Integer.valueOf(i));
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost != null) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(defaultHost, defaultPort));
                    }
                }
                return defaultHttpClient;
            } catch (Throwable th) {
                com.tencent.beacon.core.d.b.a(th);
                com.tencent.beacon.core.d.b.d("[net] httpclient error!", new Object[0]);
                return null;
            }
        }
    }

    /* compiled from: RequestHandlerAbs */
    private static class b extends f {
        private Context a;

        @Override // com.tencent.beacon.core.c.f
        public final boolean a() {
            return true;
        }

        public b(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b7, code lost:
            r7 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bc, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01bd, code lost:
            r1 = 0;
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c1, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01c2, code lost:
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01eb, code lost:
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x020a, code lost:
            if (r6 == null) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0233, code lost:
            if (r6 != null) goto L_0x020c;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x024d A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01bc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:17:0x00b3] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01c1 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:17:0x00b3] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01e5 A[SYNTHETIC, Splitter:B:67:0x01e5] */
        /* JADX WARNING: Removed duplicated region for block: B:72:? A[ExcHandler: ConnectException (unused java.net.ConnectException), SYNTHETIC, Splitter:B:17:0x00b3] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0238  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x023a  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x024e A[LOOP:0: B:4:0x0037->B:91:0x024e, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x025e A[SYNTHETIC, Splitter:B:96:0x025e] */
        @Override // com.tencent.beacon.core.c.f
        public final byte[] a(String str, int i, byte[] bArr, a aVar, e eVar) throws Exception {
            long j;
            Socket socket;
            int i2;
            byte[] bArr2;
            int i3;
            Exception e;
            OutputStream outputStream;
            byte[] b;
            int length;
            Object[] objArr;
            int i4 = 0;
            if (str == null || i <= 0) {
                com.tencent.beacon.core.d.b.d("[net] Request domain or port illegal!!!", new Object[0]);
                return null;
            }
            int i5 = 3;
            int i6 = 1;
            int i7 = 2;
            com.tencent.beacon.core.d.b.b("[net] TCP requestCmd:%d moduleId:%d eventCnt:%d", Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.e));
            String str2 = "";
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 < i5) {
                    if (i9 > i6) {
                        com.tencent.beacon.core.d.b.h("[net] Request try time:" + i9, new Object[i4]);
                        if (i9 == i7 && aVar.c() == i7) {
                            aVar.b(i4);
                        }
                        b();
                    }
                    if (bArr == null) {
                        j = 0;
                    } else {
                        j = (long) bArr.length;
                    }
                    eVar.a(str + ":" + i, j, c.c(this.a), i9);
                    long time = new Date().getTime();
                    InetAddress byName = InetAddress.getByName(str);
                    Object[] objArr2 = new Object[i7];
                    objArr2[i4] = byName.getHostAddress();
                    objArr2[i6] = Integer.valueOf(i);
                    com.tencent.beacon.core.d.b.b("[net] ip:port [%s:%d]", objArr2);
                    try {
                        socket = new Socket(byName.getHostAddress(), i);
                        try {
                            socket.setSoTimeout(30000);
                            Object[] objArr3 = new Object[i5];
                            objArr3[i4] = socket.getLocalAddress().getHostName();
                            objArr3[i6] = Integer.valueOf(socket.getLocalPort());
                            objArr3[i7] = Integer.valueOf(bArr.length);
                            com.tencent.beacon.core.d.b.b("[net] %s:%d send data[%d] to server. ", objArr3);
                            HashMap hashMap = new HashMap();
                            String d = aVar.d();
                            if (d != null && !"".equals(d)) {
                                hashMap.put("rid", aVar.d());
                            }
                            String p = com.tencent.beacon.core.strategy.a.a().p();
                            if (p != null && !"".equals(p)) {
                                hashMap.put("sid", p);
                            }
                            hashMap.put("wup_version", "3.0");
                            hashMap.put("TYPE_COMPRESS", "2");
                            hashMap.put("encr_type", "rsapost");
                            com.tencent.beacon.core.strategy.a a2 = com.tencent.beacon.core.strategy.a.a();
                            if (a2 != null) {
                                hashMap.put("bea_key", a2.n());
                            }
                            SocketRequestPackage socketRequestPackage = new SocketRequestPackage(hashMap, bArr);
                            com.tencent.beacon.core.wup.b bVar = new com.tencent.beacon.core.wup.b();
                            socketRequestPackage.writeTo(bVar);
                            outputStream = socket.getOutputStream();
                            b = bVar.b();
                            length = b.length;
                            objArr = new Object[i7];
                            objArr[0] = Integer.valueOf(bArr.length);
                        } catch (SocketTimeoutException unused) {
                            i2 = i9;
                            eVar.a();
                            str2 = str2 + i2 + ":timeout ";
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                        } catch (ConnectException unused2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            i2 = i9;
                            sb.append(i2);
                            sb.append(":connectExp ");
                            str2 = sb.toString();
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                str2 = str2 + ":" + e.getMessage();
                                com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                                if (socket != null) {
                                }
                                i2 = i9;
                                bArr2 = null;
                                if (bArr2 != null) {
                                }
                                eVar.a((long) i3, new Date().getTime() - time);
                                if (bArr2 == null) {
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                int i10 = 0;
                                com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[i10]);
                                if (socket != null) {
                                    try {
                                        socket.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                throw th2;
                            }
                        }
                        try {
                            objArr[1] = Integer.valueOf(length);
                            com.tencent.beacon.core.d.b.b("[net] send header + data[%d] = %d", objArr);
                            int i11 = length + 4;
                            ByteBuffer allocate = ByteBuffer.allocate(i11);
                            allocate.order(ByteOrder.BIG_ENDIAN);
                            allocate.putShort((short) i11);
                            allocate.put(b);
                            allocate.put((byte) 13);
                            allocate.put((byte) 10);
                            if (length >= 65532) {
                                com.tencent.beacon.core.d.b.d("[Error] send bytes exceed 64kB will failure!", new Object[0]);
                            }
                            outputStream.write(allocate.array());
                            outputStream.flush();
                            bArr2 = a(socket);
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                            try {
                                socket.close();
                            } catch (IOException unused4) {
                            }
                            i2 = i9;
                        } catch (SocketTimeoutException unused5) {
                            i2 = i9;
                            eVar.a();
                            str2 = str2 + i2 + ":timeout ";
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                        } catch (ConnectException unused6) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            i2 = i9;
                            sb.append(i2);
                            sb.append(":connectExp ");
                            str2 = sb.toString();
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                        } catch (Exception e3) {
                            e = e3;
                            str2 = str2 + ":" + e.getMessage();
                            com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException unused7) {
                                }
                            }
                            i2 = i9;
                            bArr2 = null;
                            if (bArr2 != null) {
                            }
                            eVar.a((long) i3, new Date().getTime() - time);
                            if (bArr2 == null) {
                            }
                        }
                    } catch (SocketTimeoutException unused8) {
                        i2 = i9;
                        socket = null;
                        eVar.a();
                        str2 = str2 + i2 + ":timeout ";
                        com.tencent.beacon.core.d.b.b("[net] close client socket.", new Object[0]);
                    } catch (ConnectException unused9) {
                    } catch (Exception e4) {
                    } catch (Throwable th3) {
                    }
                    if (bArr2 != null) {
                        i3 = 0;
                    } else {
                        i3 = bArr2.length;
                    }
                    eVar.a((long) i3, new Date().getTime() - time);
                    if (bArr2 == null) {
                        return bArr2;
                    }
                    i8 = i2;
                    i4 = 0;
                    i5 = 3;
                    i6 = 1;
                    i7 = 2;
                } else {
                    throw new ConnectException(str2);
                }
            }
        }

        private static byte[] a(Socket socket) throws IOException {
            com.tencent.beacon.core.d.b.b("[net] begin waiting server response.", new Object[0]);
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.tencent.beacon.core.d.b.b("[net] server response length: %d [need >= 4]", Integer.valueOf(byteArray.length));
                    ByteBuffer allocate = ByteBuffer.allocate(byteArray.length - 4);
                    allocate.put(byteArray, 2, byteArray.length - 4);
                    byte[] array = allocate.array();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return array;
                }
            }
        }
    }

    protected static void b() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            com.tencent.beacon.core.d.b.a(e);
        }
    }
}
