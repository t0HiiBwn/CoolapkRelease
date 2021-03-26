package com.amap.api.col.s;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.s.bj;
import com.amap.api.col.s.cs;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: HttpUrlUtil */
public final class cv {
    private static SoftReference<SSLContext> k;
    private static SoftReference<cw> m;
    private int a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private b j;
    private cs.a l;
    private String n;
    private boolean o;
    private String p;

    public static boolean a(int i2) {
        return i2 == 2;
    }

    cv(cy cyVar, boolean z) {
        this(cyVar, z, (byte) 0);
    }

    private cv(cy cyVar, boolean z, byte b2) {
        this(cyVar.g, cyVar.h, cyVar.i, z);
        if (cyVar != null) {
            try {
                String c2 = cyVar.c();
                this.p = c2;
                if (!TextUtils.isEmpty(c2)) {
                    return;
                }
                if (cyVar instanceof ct) {
                    this.p = a(((ct) cyVar).l());
                } else {
                    this.p = b(cyVar.f());
                }
            } catch (Throwable th) {
                cd.a(th, "ht", "pnfr");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078 A[SYNTHETIC, Splitter:B:22:0x0078] */
    private cv(int i2, int i3, Proxy proxy, boolean z) {
        SSLContext sSLContext;
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.o = false;
        this.p = "";
        this.a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = bo.a().b(z);
        bj.c();
        if (bo.b()) {
            this.c = false;
        }
        this.l = null;
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            cd.a(th, "ht", "ic");
        }
        if (this.c) {
            try {
                SoftReference<SSLContext> softReference = k;
                if (softReference == null || softReference.get() == null) {
                    k = new SoftReference<>(SSLContext.getInstance("TLS"));
                }
                SoftReference<SSLContext> softReference2 = k;
                if (softReference2 != null) {
                    sSLContext = softReference2.get();
                    if (sSLContext == null) {
                        try {
                            sSLContext = SSLContext.getInstance("TLS");
                        } catch (Throwable th2) {
                            cd.a(th2, "ht", "ne");
                        }
                    }
                    sSLContext.init(null, null, null);
                    this.d = sSLContext;
                }
            } catch (Throwable unused) {
            }
            sSLContext = null;
            if (sSLContext == null) {
            }
            sSLContext.init(null, null, null);
            this.d = sSLContext;
        }
        this.j = new b((byte) 0);
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (a2 != null) {
            stringBuffer.append("?");
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x00fb A[SYNTHETIC, Splitter:B:108:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0112 A[SYNTHETIC, Splitter:B:112:0x0112] */
    final cz a(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, int i2) throws bh {
        HttpURLConnection httpURLConnection;
        boolean z2;
        a aVar;
        Throwable th;
        Throwable th2;
        bh e2;
        Throwable th3;
        a aVar2;
        a aVar3;
        try {
            String a2 = a(str, map2);
            String a3 = a(str2, map2);
            cz a4 = cu.a(a2, a3, this.p);
            if (a4 != null) {
                return a4;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a a5 = a(a2, a3, z, str3, map, false, i2);
            try {
                HttpURLConnection httpURLConnection2 = a5.a;
                try {
                    cz a6 = a(a5, currentTimeMillis);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th4) {
                            cd.a(th4, "ht", "mgr");
                        }
                    }
                    return a6;
                } catch (ConnectException unused) {
                    throw new bh("http连接失败 - ConnectionException");
                } catch (MalformedURLException unused2) {
                    throw new bh("url异常 - MalformedURLException");
                } catch (UnknownHostException unused3) {
                    throw new bh("未知主机 - UnKnowHostException");
                } catch (SocketException unused4) {
                    throw new bh("socket 连接异常 - SocketException");
                } catch (SocketTimeoutException unused5) {
                    throw new bh("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused6) {
                    throw new bh("未知的错误");
                } catch (IOException unused7) {
                    throw new bh("IO 操作异常 - IOException");
                } catch (bh e3) {
                    e2 = e3;
                    aVar = aVar2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        z2 = !e2.f();
                        try {
                            throw e2;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        th = th2;
                        z2 = true;
                        if (z2) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th3 = th7;
                    aVar = aVar3;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th3.printStackTrace();
                        throw new bh("未知的错误");
                    } catch (Throwable th8) {
                        th2 = th8;
                        th = th2;
                        z2 = true;
                        if (z2) {
                            try {
                                bj.a(i2);
                                a(aVar, true, 0, 0);
                            } catch (Throwable unused8) {
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th9) {
                                cd.a(th9, "ht", "mgr");
                            }
                        }
                        throw th;
                    }
                }
            } catch (ConnectException unused9) {
                throw new bh("http连接失败 - ConnectionException");
            } catch (MalformedURLException unused10) {
                throw new bh("url异常 - MalformedURLException");
            } catch (UnknownHostException unused11) {
                throw new bh("未知主机 - UnKnowHostException");
            } catch (SocketException unused12) {
                throw new bh("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException unused13) {
                throw new bh("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused14) {
                throw new bh("未知的错误");
            } catch (IOException unused15) {
                throw new bh("IO 操作异常 - IOException");
            } catch (bh e4) {
                e2 = e4;
                aVar = a5;
                httpURLConnection = null;
                z2 = !e2.f();
                throw e2;
            } catch (Throwable th10) {
                th3 = th10;
                aVar = a5;
                httpURLConnection = null;
                th3.printStackTrace();
                throw new bh("未知的错误");
            }
        } catch (ConnectException unused16) {
            throw new bh("http连接失败 - ConnectionException");
        } catch (MalformedURLException unused17) {
            throw new bh("url异常 - MalformedURLException");
        } catch (UnknownHostException unused18) {
            throw new bh("未知主机 - UnKnowHostException");
        } catch (SocketException unused19) {
            throw new bh("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException unused20) {
            throw new bh("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused21) {
            throw new bh("未知的错误");
        } catch (IOException unused22) {
            throw new bh("IO 操作异常 - IOException");
        } catch (bh e5) {
            e2 = e5;
            aVar = null;
            httpURLConnection = null;
            z2 = !e2.f();
            throw e2;
        } catch (Throwable th11) {
            th3 = th11;
            aVar = null;
            httpURLConnection = null;
            th3.printStackTrace();
            throw new bh("未知的错误");
        }
    }

    public static int a(cy cyVar) {
        try {
            if (bj.b()) {
                return 4;
            }
            if (cyVar != null && !cyVar.k()) {
                return 1;
            }
            if (2 == (!bj.a() ? (char) 1 : 2)) {
                return 2;
            }
            return 1;
        } catch (Throwable th) {
            cg.c(th, "htu", "gt");
        }
    }

    private static String a(String str, String str2, int i2) {
        if (i2 == 2 || i2 == 4) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    private void b(int i2) {
        if (i2 == 2) {
            this.a = Math.max(this.a - 5000, 5000);
            this.b = Math.max(this.b - 5000, 5000);
        } else if (i2 == 3) {
            try {
                this.a = 5000;
                this.b = 5000;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x00ef, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x00fe, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x010d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x011c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x012b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00b8, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00c4, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[ExcHandler: InterruptedIOException (unused java.io.InterruptedIOException), SYNTHETIC, Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x013f A[SYNTHETIC, Splitter:B:137:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0156 A[SYNTHETIC, Splitter:B:141:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00b7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00c3 A[ExcHandler: bh (e com.amap.api.col.s.bh), Splitter:B:1:0x000a] */
    final cz a(String str, String str2, boolean z, String str3, Map<String, String> map, byte[] bArr, int i2) throws bh {
        boolean z2;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Throwable th2;
        ConnectException e2;
        MalformedURLException e3;
        UnknownHostException e4;
        SocketException e5;
        SocketTimeoutException e6;
        IOException e7;
        bh e8;
        Throwable th3;
        DataOutputStream dataOutputStream;
        Throwable th4;
        try {
            cz a2 = cu.a(str, str2, this.p);
            if (a2 != null) {
                return a2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = a(str, str2, z, str3, map, true, i2);
            try {
                HttpURLConnection httpURLConnection2 = aVar.a;
                if (bArr != null) {
                    try {
                        if (bArr.length > 0) {
                            try {
                                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
                                try {
                                    dataOutputStream2.write(bArr);
                                    dataOutputStream2.close();
                                } catch (Throwable th5) {
                                    th4 = th5;
                                    dataOutputStream = dataOutputStream2;
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    throw th4;
                                }
                            } catch (Throwable th6) {
                                th4 = th6;
                                dataOutputStream = null;
                                if (dataOutputStream != null) {
                                }
                                throw th4;
                            }
                        }
                    } catch (ConnectException e9) {
                        e2 = e9;
                        e2.printStackTrace();
                        throw new bh("http连接失败 - ConnectionException");
                    } catch (MalformedURLException e10) {
                        e3 = e10;
                        e3.printStackTrace();
                        throw new bh("url异常 - MalformedURLException");
                    } catch (UnknownHostException e11) {
                        e4 = e11;
                        e4.printStackTrace();
                        throw new bh("未知主机 - UnKnowHostException");
                    } catch (SocketException e12) {
                        e5 = e12;
                        e5.printStackTrace();
                        throw new bh("socket 连接异常 - SocketException");
                    } catch (SocketTimeoutException e13) {
                        e6 = e13;
                        e6.printStackTrace();
                        throw new bh("socket 连接超时 - SocketTimeoutException");
                    } catch (InterruptedIOException unused) {
                        throw new bh("未知的错误");
                    } catch (IOException e14) {
                        e7 = e14;
                        e7.printStackTrace();
                        throw new bh("IO 操作异常 - IOException");
                    } catch (bh e15) {
                        e8 = e15;
                        httpURLConnection = httpURLConnection2;
                        try {
                            z2 = !e8.f();
                            try {
                                cd.a(e8, "ht", "mPt");
                                throw e8;
                            } catch (Throwable th7) {
                                th = th7;
                                if (z2) {
                                    try {
                                        bj.a(i2);
                                        a(aVar, true, 0, 0);
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th8) {
                                        cd.a(th8, "ht", "mPt");
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th9) {
                            th2 = th9;
                            th = th2;
                            z2 = true;
                            if (z2) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th3 = th10;
                        httpURLConnection = httpURLConnection2;
                        try {
                            cd.a(th3, "ht", "mPt");
                            throw new bh("未知的错误");
                        } catch (Throwable th11) {
                            th2 = th11;
                            th = th2;
                            z2 = true;
                            if (z2) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    }
                }
                cz a3 = a(aVar, currentTimeMillis);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th12) {
                        cd.a(th12, "ht", "mPt");
                    }
                }
                return a3;
            } catch (ConnectException e16) {
                e2 = e16;
                e2.printStackTrace();
                throw new bh("http连接失败 - ConnectionException");
            } catch (MalformedURLException e17) {
                e3 = e17;
                e3.printStackTrace();
                throw new bh("url异常 - MalformedURLException");
            } catch (UnknownHostException e18) {
                e4 = e18;
                e4.printStackTrace();
                throw new bh("未知主机 - UnKnowHostException");
            } catch (SocketException e19) {
                e5 = e19;
                e5.printStackTrace();
                throw new bh("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e20) {
                e6 = e20;
                e6.printStackTrace();
                throw new bh("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused3) {
                throw new bh("未知的错误");
            } catch (IOException e21) {
                e7 = e21;
                e7.printStackTrace();
                throw new bh("IO 操作异常 - IOException");
            } catch (bh e22) {
                e8 = e22;
                httpURLConnection = null;
                z2 = !e8.f();
                cd.a(e8, "ht", "mPt");
                throw e8;
            } catch (Throwable th13) {
                th3 = th13;
                httpURLConnection = null;
                cd.a(th3, "ht", "mPt");
                throw new bh("未知的错误");
            }
        } catch (ConnectException e23) {
            e2 = e23;
            e2.printStackTrace();
            throw new bh("http连接失败 - ConnectionException");
        } catch (MalformedURLException e24) {
            e3 = e24;
            e3.printStackTrace();
            throw new bh("url异常 - MalformedURLException");
        } catch (UnknownHostException e25) {
            e4 = e25;
            e4.printStackTrace();
            throw new bh("未知主机 - UnKnowHostException");
        } catch (SocketException e26) {
            e5 = e26;
            e5.printStackTrace();
            throw new bh("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e27) {
            e6 = e27;
            e6.printStackTrace();
            throw new bh("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused4) {
        } catch (IOException e28) {
            e7 = e28;
            e7.printStackTrace();
            throw new bh("IO 操作异常 - IOException");
        } catch (bh e29) {
        } catch (Throwable th14) {
        }
    }

    private String a(int i2, String str, Map<String, String> map) {
        String str2 = i2 != 1 ? "" : cs.b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String uri = parse.buildUpon().encodedAuthority(str2).build().toString();
        if (map != null) {
            map.put("targetHost", host);
        }
        if (this.c) {
            this.j.b(str2);
        }
        return uri;
    }

    /* compiled from: HttpUrlUtil */
    public static class a {
        public HttpURLConnection a;
        public int b;

        public a(HttpURLConnection httpURLConnection, int i) {
            this.a = httpURLConnection;
            this.b = i;
        }
    }

    private cw a() {
        try {
            SoftReference<cw> softReference = m;
            if (softReference == null || softReference.get() == null) {
                m = new SoftReference<>(new cw(bj.c, this.d));
            }
            cw cwVar = k != null ? m.get() : null;
            return cwVar == null ? new cw(bj.c, this.d) : cwVar;
        } catch (Throwable th) {
            cg.c(th, "ht", "gsf");
            return null;
        }
    }

    private a a(String str, String str2, boolean z, String str3, Map<String, String> map, boolean z2, int i2) throws IOException, bh {
        HttpURLConnection httpURLConnection;
        String a2 = cu.a(a(str, str2, i2), this.p);
        b(i2);
        if (map == null) {
            map = new HashMap<>();
        }
        c a3 = this.j.a();
        this.n = str3;
        if (z && !TextUtils.isEmpty(str3)) {
            a3 = this.j.a(str3);
        }
        if (!a2.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.p) && bj.a(this.p)) {
            this.o = true;
            map.put("lct", String.valueOf(bj.c(this.p)));
        }
        String a4 = a(cs.a, a2, map);
        if (this.c) {
            a4 = bo.a(a4);
        }
        URL url = new URL(a4);
        cs.a aVar = this.l;
        URLConnection a5 = aVar != null ? aVar.a() : null;
        if (a5 == null) {
            Proxy proxy = this.e;
            if (proxy != null) {
                a5 = url.openConnection(proxy);
            } else {
                a5 = url.openConnection();
            }
        }
        if (this.c) {
            httpURLConnection = (HttpsURLConnection) a5;
            if (bj.f.a) {
                cw a6 = a();
                if (a6 != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a6);
                    a6.a();
                } else {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.d.getSocketFactory());
                }
            } else {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.d.getSocketFactory());
            }
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a3);
        } else {
            httpURLConnection = (HttpURLConnection) a5;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        a(map, httpURLConnection);
        if (z2) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return new a(httpURLConnection, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002f  */
    private static void a(a aVar, boolean z, long j2, long j3) {
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        String str2;
        boolean z5 = false;
        try {
            str2 = aVar.a.getURL().toString();
            try {
                z4 = aVar.b == 3;
            } catch (Throwable unused) {
                z4 = false;
                str = str2;
                z2 = z4;
                z3 = false;
                if (TextUtils.isEmpty(str)) {
                }
            }
            try {
                if (aVar.b == 2 || aVar.b == 4) {
                    z5 = true;
                }
                z3 = z5;
                str = str2;
                z2 = z4;
            } catch (Throwable unused2) {
                str = str2;
                z2 = z4;
                z3 = false;
                if (TextUtils.isEmpty(str)) {
                }
            }
        } catch (Throwable unused3) {
            str2 = null;
            z4 = false;
            str = str2;
            z2 = z4;
            z3 = false;
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            bj.a(str, z3, z2, z, Math.max(0L, j3 - j2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c7 A[SYNTHETIC, Splitter:B:118:0x01c7] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d2 A[SYNTHETIC, Splitter:B:123:0x01d2] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01dd A[SYNTHETIC, Splitter:B:128:0x01dd] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01e8 A[SYNTHETIC, Splitter:B:133:0x01e8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0157  */
    private cz a(a aVar, long j2) throws bh, IOException {
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        PushbackInputStream pushbackInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        IOException e2;
        boolean z;
        char c2;
        String str = "";
        try {
            cu.a();
            HttpURLConnection httpURLConnection = aVar.a;
            httpURLConnection.connect();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (headerFields != null) {
                List<String> list = headerFields.get("gsid");
                if (list != null && list.size() > 0) {
                    str = list.get(0);
                }
                try {
                    if (!TextUtils.isEmpty(this.p)) {
                        if (!this.o) {
                            z = a(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey("sc")) {
                            z = a(headerFields, false);
                            c2 = 1;
                        } else {
                            bj.b(this.p);
                            z = false;
                            c2 = 0;
                        }
                        if (z) {
                            try {
                                if (this.p.equals("loc")) {
                                    bj.a(this.p, c2 == 2, httpURLConnection.getURL().getHost(), httpURLConnection.getURL().getHost(), this.n);
                                } else {
                                    bj.b(this.p, c2 == 2);
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (c2 == 1) {
                            cu.a(false, this.p);
                        }
                        if (responseCode != 200) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                try {
                                    pushbackInputStream = new PushbackInputStream(inputStream2, 2);
                                    try {
                                        byte[] bArr = new byte[2];
                                        pushbackInputStream.read(bArr);
                                        pushbackInputStream.unread(bArr);
                                        gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                    } catch (IOException e3) {
                                        e2 = e3;
                                        inputStream = inputStream2;
                                        gZIPInputStream = null;
                                        try {
                                            bh bhVar = new bh("IO 操作异常 - IOException", str, this.i);
                                            bhVar.g();
                                            throw bhVar;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (byteArrayOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (pushbackInputStream != null) {
                                            }
                                            if (gZIPInputStream != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = inputStream2;
                                        gZIPInputStream = null;
                                        if (byteArrayOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (pushbackInputStream != null) {
                                        }
                                        if (gZIPInputStream != null) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        byte[] bArr2 = new byte[1024];
                                        while (true) {
                                            int read = gZIPInputStream.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr2, 0, read);
                                        }
                                        cg.b();
                                        cz czVar = new cz();
                                        czVar.a = byteArrayOutputStream.toByteArray();
                                        czVar.b = headerFields;
                                        czVar.c = this.i;
                                        czVar.d = str;
                                        czVar.e = z;
                                        cu.a(httpURLConnection.getURL(), czVar);
                                        a(aVar, false, j2, System.currentTimeMillis());
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable th4) {
                                            cd.a(th4, "ht", "par");
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable th5) {
                                                cd.a(th5, "ht", "par");
                                            }
                                        }
                                        try {
                                            pushbackInputStream.close();
                                        } catch (Throwable th6) {
                                            cd.a(th6, "ht", "par");
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Throwable th7) {
                                            cd.a(th7, "ht", "par");
                                        }
                                        return czVar;
                                    } catch (IOException e4) {
                                        e2 = e4;
                                        inputStream = inputStream2;
                                        bh bhVar = new bh("IO 操作异常 - IOException", str, this.i);
                                        bhVar.g();
                                        throw bhVar;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        inputStream = inputStream2;
                                        if (byteArrayOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (pushbackInputStream != null) {
                                        }
                                        if (gZIPInputStream != null) {
                                        }
                                        throw th;
                                    }
                                } catch (IOException e5) {
                                    e2 = e5;
                                    inputStream = inputStream2;
                                    pushbackInputStream = null;
                                    gZIPInputStream = null;
                                    bh bhVar = new bh("IO 操作异常 - IOException", str, this.i);
                                    if ((e2 instanceof InterruptedIOException) && !TextUtils.isEmpty(e2.getMessage()) && e2.getMessage().equals("thread interrupted")) {
                                        bhVar.g();
                                    }
                                    throw bhVar;
                                } catch (Throwable th9) {
                                    th = th9;
                                    inputStream = inputStream2;
                                    pushbackInputStream = null;
                                    gZIPInputStream = null;
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable th10) {
                                            cd.a(th10, "ht", "par");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th11) {
                                            cd.a(th11, "ht", "par");
                                        }
                                    }
                                    if (pushbackInputStream != null) {
                                        try {
                                            pushbackInputStream.close();
                                        } catch (Throwable th12) {
                                            cd.a(th12, "ht", "par");
                                        }
                                    }
                                    if (gZIPInputStream != null) {
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Throwable th13) {
                                            cd.a(th13, "ht", "par");
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e2 = e6;
                                pushbackInputStream = null;
                                gZIPInputStream = null;
                                inputStream = null;
                                bh bhVar = new bh("IO 操作异常 - IOException", str, this.i);
                                bhVar.g();
                                throw bhVar;
                            } catch (Throwable th14) {
                                th = th14;
                                pushbackInputStream = null;
                                gZIPInputStream = null;
                                inputStream = null;
                                if (byteArrayOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (pushbackInputStream != null) {
                                }
                                if (gZIPInputStream != null) {
                                }
                                throw th;
                            }
                        } else {
                            bh bhVar2 = new bh("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.i, str, this.i);
                            bhVar2.a(responseCode);
                            throw bhVar2;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            z = false;
            if (responseCode != 200) {
            }
        } catch (IOException e7) {
            e2 = e7;
            byteArrayOutputStream = null;
            pushbackInputStream = null;
            gZIPInputStream = null;
            inputStream = null;
            bh bhVar = new bh("IO 操作异常 - IOException", str, this.i);
            bhVar.g();
            throw bhVar;
        } catch (Throwable th15) {
            th = th15;
            byteArrayOutputStream = null;
            pushbackInputStream = null;
            gZIPInputStream = null;
            inputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (gZIPInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ all -> 0x0072 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ all -> 0x0072 }] */
    private boolean a(Map<String, List<String>> map, boolean z) {
        boolean z2;
        List<String> list;
        try {
            List<String> list2 = map.get("sc");
            if (list2 != null && list2.size() > 0) {
                String str = list2.get(0);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains("#")) {
                        String[] split = str.split("#");
                        if (split.length > 1 && "1".equals(split[1])) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                        return false;
                    }
                    if (!z) {
                        return true;
                    }
                    if (map.containsKey("lct") && (list = map.get("lct")) != null && list.size() > 0) {
                        String str2 = list.get(0);
                        if (!TextUtils.isEmpty(str2)) {
                            return bj.a(this.p, Long.valueOf(str2).longValue());
                        }
                    }
                    return false;
                }
            }
            z2 = false;
            if (z2) {
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.i);
        } catch (Throwable th) {
            cd.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
    }

    /* compiled from: HttpUrlUtil */
    private static class c implements HostnameVerifier {
        private String a;
        private String b;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void a(String str) {
            this.a = str;
        }

        public final void b(String str) {
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* compiled from: HttpUrlUtil */
    private static class b {
        private Vector<c> a;
        private volatile c b;

        private b() {
            this.a = new Vector<>();
            this.b = new c((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final c a() {
            return this.b;
        }

        public final c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && cVar.a().equals(str)) {
                    return cVar;
                }
            }
            c cVar2 = new c((byte) 0);
            cVar2.b(str);
            this.a.add(cVar2);
            return cVar2;
        }

        public final void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b.a(str);
            }
        }
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(key));
            sb.append("=");
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    private static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return a(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            cd.a(th, "ht", "pnfh");
            return null;
        }
    }

    private static String a(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i2 = 0;
                    String str4 = str3;
                    while (true) {
                        if (i2 >= length) {
                            str2 = str3;
                            break;
                        }
                        str2 = split[i2];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(cc.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    cc.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cd.a(th, "ht", "pnfp");
        }
        return str3;
    }
}
