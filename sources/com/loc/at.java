package com.loc;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.loc.aq;
import com.loc.l;
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
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HttpUrlUtil */
public final class at {
    private static SoftReference<SSLContext> k;
    private static SoftReference<au> m;
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

    /* renamed from: l  reason: collision with root package name */
    private aq.a f1356l;
    private String n;
    private boolean o;
    private String p;

    /* compiled from: HttpUrlUtil */
    public static class a {
        public HttpURLConnection a;
        public int b;

        public a(HttpURLConnection httpURLConnection, int i) {
            this.a = httpURLConnection;
            this.b = i;
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

    /* compiled from: HttpUrlUtil */
    private static class c implements HostnameVerifier {
        private String a;
        private String b;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final String a() {
            return this.b;
        }

        public final void a(String str) {
            this.a = str;
        }

        public final void b(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.a) ? this.a.equals(str) : !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078 A[SYNTHETIC, Splitter:B:22:0x0078] */
    private at(int i2, int i3, Proxy proxy, boolean z) {
        SSLContext sSLContext;
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.o = false;
        this.p = "";
        this.a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = p.a().b(z);
        l.d();
        if (p.b()) {
            this.c = false;
        }
        this.f1356l = null;
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            y.a(th, "ht", "ic");
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
                            y.a(th2, "ht", "ne");
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

    at(av avVar, boolean z) {
        this(avVar, z, (byte) 0);
    }

    private at(av avVar, boolean z, byte b2) {
        this(avVar.c, avVar.d, avVar.e, z);
        if (avVar != null) {
            try {
                String p2 = avVar.p();
                this.p = p2;
                if (!TextUtils.isEmpty(p2)) {
                    return;
                }
                if (avVar instanceof ar) {
                    this.p = a(((ar) avVar).k());
                } else {
                    this.p = b(avVar.b());
                }
            } catch (Throwable th) {
                y.a(th, "ht", "pnfr");
            }
        }
    }

    public static int a(av avVar) {
        try {
            if (l.b()) {
                return 4;
            }
            if (avVar != null && !avVar.i()) {
                return 1;
            }
            return 2 == (!l.a() ? (char) 1 : 2) ? 2 : 1;
        } catch (Throwable th) {
            ab.b(th, "htu", "gt");
        }
    }

    private au a() {
        try {
            SoftReference<au> softReference = m;
            if (softReference == null || softReference.get() == null) {
                m = new SoftReference<>(new au(l.c, this.d));
            }
            au auVar = k != null ? m.get() : null;
            return auVar == null ? new au(l.c, this.d) : auVar;
        } catch (Throwable th) {
            ab.b(th, "ht", "gsf");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01d7 A[SYNTHETIC, Splitter:B:127:0x01d7] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01e2 A[SYNTHETIC, Splitter:B:132:0x01e2] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ed A[SYNTHETIC, Splitter:B:137:0x01ed] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01f8 A[SYNTHETIC, Splitter:B:142:0x01f8] */
    private aw a(a aVar) throws j, IOException {
        InputStream inputStream;
        InputStream inputStream2;
        PushbackInputStream pushbackInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        IOException e2;
        boolean z;
        InputStream inputStream3;
        boolean z2;
        char c2;
        String str = "";
        try {
            as.a();
            long currentTimeMillis = System.currentTimeMillis();
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
                            z2 = a(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey("sc")) {
                            z2 = a(headerFields, false);
                            c2 = 1;
                        } else {
                            l.b(this.p);
                            z2 = false;
                            c2 = 0;
                        }
                        if (z2) {
                            try {
                                try {
                                    if (this.p.equals("loc")) {
                                        l.a(this.p, c2 == 2, httpURLConnection.getURL().getHost(), httpURLConnection.getURL().getHost(), this.n);
                                    } else {
                                        l.b(this.p, c2 == 2);
                                    }
                                    z = z2;
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                            }
                        } else {
                            if (c2 == 1) {
                                as.a(false, this.p);
                                z = z2;
                            }
                            z = z2;
                        }
                    }
                } catch (Throwable unused3) {
                }
                z2 = false;
                z = z2;
            } else {
                z = false;
            }
            if (responseCode == 200) {
                a(aVar, false, currentTimeMillis, System.currentTimeMillis());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    inputStream3 = httpURLConnection.getInputStream();
                } catch (IOException e3) {
                    e2 = e3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    pushbackInputStream = null;
                    inputStream2 = null;
                    inputStream = null;
                    try {
                        j jVar = new j("IO 操作异常 - IOException", str, this.i);
                        jVar.h();
                        throw jVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (pushbackInputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    pushbackInputStream = null;
                    inputStream2 = null;
                    inputStream = null;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (pushbackInputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    pushbackInputStream = new PushbackInputStream(inputStream3, 2);
                    try {
                        byte[] bArr = new byte[2];
                        pushbackInputStream.read(bArr);
                        pushbackInputStream.unread(bArr);
                        inputStream2 = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                    } catch (IOException e4) {
                        e2 = e4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream3;
                        inputStream2 = null;
                        j jVar = new j("IO 操作异常 - IOException", str, this.i);
                        jVar.h();
                        throw jVar;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream3;
                        inputStream2 = null;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (pushbackInputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        ab.c();
                        aw awVar = new aw();
                        awVar.a = byteArrayOutputStream2.toByteArray();
                        awVar.b = headerFields;
                        awVar.c = this.i;
                        awVar.d = str;
                        awVar.e = z;
                        as.a(httpURLConnection.getURL(), awVar);
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Throwable th5) {
                            y.a(th5, "ht", "par");
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable th6) {
                                y.a(th6, "ht", "par");
                            }
                        }
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable th7) {
                            y.a(th7, "ht", "par");
                        }
                        try {
                            inputStream2.close();
                        } catch (Throwable th8) {
                            y.a(th8, "ht", "par");
                        }
                        return awVar;
                    } catch (IOException e5) {
                        e2 = e5;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream3;
                        j jVar = new j("IO 操作异常 - IOException", str, this.i);
                        jVar.h();
                        throw jVar;
                    } catch (Throwable th9) {
                        th = th9;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream3;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (pushbackInputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e2 = e6;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream3;
                    pushbackInputStream = null;
                    inputStream2 = null;
                    j jVar = new j("IO 操作异常 - IOException", str, this.i);
                    if ((e2 instanceof InterruptedIOException) && !TextUtils.isEmpty(e2.getMessage()) && e2.getMessage().equals("thread interrupted")) {
                        jVar.h();
                    }
                    throw jVar;
                } catch (Throwable th10) {
                    th = th10;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream3;
                    pushbackInputStream = null;
                    inputStream2 = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th11) {
                            y.a(th11, "ht", "par");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th12) {
                            y.a(th12, "ht", "par");
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable th13) {
                            y.a(th13, "ht", "par");
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th14) {
                            y.a(th14, "ht", "par");
                        }
                    }
                    throw th;
                }
            } else {
                j jVar2 = new j("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.i, str, this.i);
                jVar2.a(responseCode);
                throw jVar2;
            }
        } catch (IOException e7) {
            e2 = e7;
            byteArrayOutputStream = null;
            pushbackInputStream = null;
            inputStream2 = null;
            inputStream = null;
            j jVar = new j("IO 操作异常 - IOException", str, this.i);
            jVar.h();
            throw jVar;
        } catch (Throwable th15) {
            th = th15;
            byteArrayOutputStream = null;
            pushbackInputStream = null;
            inputStream2 = null;
            inputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (inputStream2 != null) {
            }
            throw th;
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
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(v.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    v.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            y.a(th, "ht", "pnfp");
        }
        return str3;
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
            l.a(str, z3, z2, z, Math.max(0L, j3 - j2));
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
            y.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
    }

    public static boolean a(int i2) {
        return i2 == 2;
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
                            return l.a(this.p, Long.valueOf(str2).longValue());
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
            y.a(th, "ht", "pnfh");
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0008 */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: com.loc.at$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v33 */
    final aw a(String str, String str2, boolean z, String str3, Map<String, String> map, byte[] bArr, int i2) throws j {
        ConnectException e2;
        MalformedURLException e3;
        UnknownHostException e4;
        SocketException e5;
        SocketTimeoutException e6;
        IOException e7;
        j e8;
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        SSLSocketFactory socketFactory;
        HttpURLConnection httpURLConnection2 = null;
        try {
            aw a2 = as.a(str, str2, this.p);
            if (a2 != null) {
                return a2;
            }
            String a3 = as.a(a(str, str2, i2), this.p);
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
            if (map == null) {
                map = new HashMap<>();
            }
            c a4 = this.j.a();
            this.n = str3;
            if (z && !TextUtils.isEmpty(str3)) {
                a4 = this.j.a(str3);
            }
            if (!a3.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.p) && l.a(this.p)) {
                this.o = true;
                map.put("lct", String.valueOf(l.c(this.p)));
            }
            String str4 = "";
            if (aq.a == 1) {
                str4 = aq.b;
            }
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(a3);
                String host = parse.getHost();
                a3 = parse.buildUpon().encodedAuthority(str4).build().toString();
                if (map != null) {
                    map.put("targetHost", host);
                }
                if (this.c) {
                    this.j.b(str4);
                }
            }
            if (this.c) {
                a3 = p.a(a3);
            }
            URL url = new URL(a3);
            aq.a aVar = this.f1356l;
            URLConnection a5 = aVar != null ? aVar.a() : null;
            if (a5 == null) {
                Proxy proxy = this.e;
                a5 = proxy != null ? url.openConnection(proxy) : url.openConnection();
            }
            if (this.c) {
                httpURLConnection = (HttpsURLConnection) a5;
                if (l.f.a) {
                    au a6 = a();
                    if (a6 != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a6);
                        a6.a();
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a4);
                    } else {
                        httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                        socketFactory = this.d.getSocketFactory();
                    }
                } else {
                    httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    socketFactory = this.d.getSocketFactory();
                }
                httpsURLConnection.setSSLSocketFactory(socketFactory);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a4);
            } else {
                httpURLConnection = (HttpURLConnection) a5;
            }
            if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            a(map, httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            a aVar2 = new a(httpURLConnection, i2);
            try {
                HttpURLConnection httpURLConnection3 = aVar2.a;
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                }
                aw a7 = a(aVar2);
                if (httpURLConnection3 != null) {
                    try {
                        httpURLConnection3.disconnect();
                    } catch (Throwable th2) {
                        y.a(th2, "ht", "mPt");
                    }
                }
                return a7;
            } catch (ConnectException e9) {
                e2 = e9;
                e2.printStackTrace();
                throw new j("http连接失败 - ConnectionException");
            } catch (MalformedURLException e10) {
                e3 = e10;
                e3.printStackTrace();
                throw new j("url异常 - MalformedURLException");
            } catch (UnknownHostException e11) {
                e4 = e11;
                e4.printStackTrace();
                throw new j("未知主机 - UnKnowHostException");
            } catch (SocketException e12) {
                e5 = e12;
                e5.printStackTrace();
                throw new j("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e13) {
                e6 = e13;
                e6.printStackTrace();
                throw new j("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused2) {
                throw new j("未知的错误");
            } catch (IOException e14) {
                e7 = e14;
                e7.printStackTrace();
                throw new j("IO 操作异常 - IOException");
            } catch (j e15) {
                e8 = e15;
                boolean g2 = true ^ e8.g();
                y.a(e8, "ht", "mPt");
                throw e8;
            } catch (Throwable th3) {
                th = th3;
                str2 = aVar2;
                y.a(th, "ht", "mPt");
                throw new j("未知的错误");
            }
        } catch (ConnectException e16) {
            e2 = e16;
            e2.printStackTrace();
            throw new j("http连接失败 - ConnectionException");
        } catch (MalformedURLException e17) {
            e3 = e17;
            e3.printStackTrace();
            throw new j("url异常 - MalformedURLException");
        } catch (UnknownHostException e18) {
            e4 = e18;
            e4.printStackTrace();
            throw new j("未知主机 - UnKnowHostException");
        } catch (SocketException e19) {
            e5 = e19;
            e5.printStackTrace();
            throw new j("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e20) {
            e6 = e20;
            e6.printStackTrace();
            throw new j("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused3) {
            throw new j("未知的错误");
        } catch (IOException e21) {
            e7 = e21;
            e7.printStackTrace();
            throw new j("IO 操作异常 - IOException");
        } catch (j e22) {
            e8 = e22;
            boolean g2 = true ^ e8.g();
            y.a(e8, "ht", "mPt");
            throw e8;
        } catch (Throwable th4) {
            if (1 != 0) {
                try {
                    l.a(i2);
                    a(str2, true, 0, 0);
                } catch (Throwable th5) {
                    y.a(th5, "ht", "mPt");
                }
            }
            if (0 != 0) {
                httpURLConnection2.disconnect();
            }
            throw th4;
        }
    }
}
