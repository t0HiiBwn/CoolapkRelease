package com.amap.api.mapcore2d;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.mapcore2d.er;
import com.amap.api.mapcore2d.et;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
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
public class eu {
    private int a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private a j;
    private er.a k;

    private void a() {
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            dl.a(th, "ht", "ic");
        }
    }

    eu(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, null);
    }

    eu(int i2, int i3, Proxy proxy, boolean z, er.a aVar) {
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = cw.a().b(z);
        if (cw.c()) {
            this.c = false;
        }
        this.k = aVar;
        a();
        if (this.c) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.d = instance;
            } catch (Throwable th) {
                dl.a(th, "ht", "ne");
            }
        }
        this.j = new a();
    }

    void a(long j2) {
        this.h = j2;
    }

    void b(long j2) {
        this.g = j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0115 A[SYNTHETIC, Splitter:B:65:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    void a(String str, boolean z, String str2, Map<String, String> map, Map<String, String> map2, byte[] bArr, et.a aVar) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        int read;
        if (aVar != null) {
            InputStream inputStream = null;
            try {
                String a2 = a(map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a2 != null) {
                    stringBuffer.append("?");
                    stringBuffer.append(a2);
                }
                boolean z2 = true;
                boolean z3 = bArr != null && bArr.length > 0;
                httpURLConnection = a(stringBuffer.toString(), z, str2, map, z3);
                try {
                    httpURLConnection.setRequestProperty("RANGE", "bytes=" + this.h + "-");
                    if (z3) {
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        dataOutputStream.write(bArr);
                        dataOutputStream.close();
                    }
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    boolean z4 = responseCode != 200;
                    if (responseCode == 206) {
                        z2 = false;
                    }
                    if (z4 && z2) {
                        aVar.a(new cp("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode));
                    }
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    byte[] bArr2 = new byte[1024];
                    while (!Thread.interrupted() && !this.f && (read = inputStream2.read(bArr2, 0, 1024)) > 0) {
                        long j2 = this.g;
                        if (j2 != -1 && this.h >= j2) {
                            break;
                        }
                        if (read == 1024) {
                            aVar.a(bArr2, this.h);
                        } else {
                            byte[] bArr3 = new byte[read];
                            System.arraycopy(bArr2, 0, bArr3, 0, read);
                            aVar.a(bArr3, this.h);
                        }
                        this.h += (long) read;
                    }
                    if (this.f) {
                        aVar.b();
                    } else {
                        aVar.c();
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                            dl.a(e2, "ht", "mdr");
                        } catch (Throwable th2) {
                            dl.a(th2, "ht", "mdr");
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                            return;
                        } catch (Throwable th3) {
                            dl.a(th3, "ht", "mdr");
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        aVar.a(th);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                dl.a(e3, "ht", "mdr");
                            } catch (Throwable th5) {
                                dl.a(th5, "ht", "mdr");
                            }
                        }
                        if (httpURLConnection == null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th6) {
                        dl.a(th6, "ht", "mdr");
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                httpURLConnection = null;
                aVar.a(th);
                if (0 != 0) {
                }
                if (httpURLConnection == null) {
                }
            }
        } else {
            return;
        }
        throw th;
    }

    ey a(String str, boolean z, String str2, Map<String, String> map, Map<String, String> map2, boolean z2) throws cp {
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            String a2 = a(map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a2 != null) {
                stringBuffer.append("?");
                stringBuffer.append(a2);
            }
            httpURLConnection = a(stringBuffer.toString(), z, str2, map, false);
            ey a3 = a(httpURLConnection, z2);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th2) {
                    dl.a(th2, "ht", "mgr");
                }
            }
            return a3;
        } catch (ConnectException unused) {
            throw new cp("http连接失败 - ConnectionException");
        } catch (MalformedURLException unused2) {
            throw new cp("url异常 - MalformedURLException");
        } catch (UnknownHostException unused3) {
            throw new cp("未知主机 - UnKnowHostException");
        } catch (SocketException unused4) {
            throw new cp("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException unused5) {
            throw new cp("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused6) {
            throw new cp("未知的错误");
        } catch (IOException unused7) {
            throw new cp("IO 操作异常 - IOException");
        } catch (cp e2) {
            throw e2;
        } catch (ConnectException unused8) {
            throw new cp("http连接失败 - ConnectionException");
        } catch (MalformedURLException unused9) {
            throw new cp("url异常 - MalformedURLException");
        } catch (UnknownHostException unused10) {
            throw new cp("未知主机 - UnKnowHostException");
        } catch (SocketException unused11) {
            throw new cp("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException unused12) {
            throw new cp("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused13) {
            throw new cp("未知的错误");
        } catch (IOException unused14) {
            throw new cp("IO 操作异常 - IOException");
        } catch (cp e3) {
            throw e3;
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    dl.a(th4, "ht", "mgr");
                }
            }
            throw th3;
        }
    }

    ey a(String str, boolean z, String str2, Map<String, String> map, byte[] bArr, boolean z2) throws cp {
        ConnectException e2;
        MalformedURLException e3;
        UnknownHostException e4;
        SocketException e5;
        SocketTimeoutException e6;
        IOException e7;
        cp e8;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(str, z, str2, map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            try {
                ey a2 = a(httpURLConnection, z2);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th2) {
                        dl.a(th2, "ht", "mPt");
                    }
                }
                return a2;
            } catch (ConnectException e9) {
                e2 = e9;
                e2.printStackTrace();
                throw new cp("http连接失败 - ConnectionException");
            } catch (MalformedURLException e10) {
                e3 = e10;
                e3.printStackTrace();
                throw new cp("url异常 - MalformedURLException");
            } catch (UnknownHostException e11) {
                e4 = e11;
                e4.printStackTrace();
                throw new cp("未知主机 - UnKnowHostException");
            } catch (SocketException e12) {
                e5 = e12;
                e5.printStackTrace();
                throw new cp("socket 连接异常 - SocketException");
            } catch (SocketTimeoutException e13) {
                e6 = e13;
                e6.printStackTrace();
                throw new cp("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused) {
                throw new cp("未知的错误");
            } catch (IOException e14) {
                e7 = e14;
                e7.printStackTrace();
                throw new cp("IO 操作异常 - IOException");
            } catch (cp e15) {
                e8 = e15;
                dl.a(e8, "ht", "mPt");
                throw e8;
            } catch (Throwable th3) {
                th = th3;
                dl.a(th, "ht", "mPt");
                throw new cp("未知的错误");
            }
        } catch (ConnectException e16) {
            e2 = e16;
            e2.printStackTrace();
            throw new cp("http连接失败 - ConnectionException");
        } catch (MalformedURLException e17) {
            e3 = e17;
            e3.printStackTrace();
            throw new cp("url异常 - MalformedURLException");
        } catch (UnknownHostException e18) {
            e4 = e18;
            e4.printStackTrace();
            throw new cp("未知主机 - UnKnowHostException");
        } catch (SocketException e19) {
            e5 = e19;
            e5.printStackTrace();
            throw new cp("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e20) {
            e6 = e20;
            e6.printStackTrace();
            throw new cp("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            throw new cp("未知的错误");
        } catch (IOException e21) {
            e7 = e21;
            e7.printStackTrace();
            throw new cp("IO 操作异常 - IOException");
        } catch (cp e22) {
            e8 = e22;
            dl.a(e8, "ht", "mPt");
            throw e8;
        } catch (Throwable th4) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th5) {
                    dl.a(th5, "ht", "mPt");
                }
            }
            throw th4;
        }
    }

    private String a(int i2, String str, Map<String, String> map) {
        String str2 = i2 != 1 ? "" : er.b;
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

    HttpURLConnection a(String str, boolean z, String str2, Map<String, String> map, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection;
        cu.b();
        if (map == null) {
            map = new HashMap<>();
        }
        b a2 = this.j.a();
        if (z && !TextUtils.isEmpty(str2)) {
            a2 = this.j.a(str2);
        }
        String a3 = a(er.a, str, map);
        if (this.c) {
            a3 = cw.a(a3);
        }
        URL url = new URL(a3);
        er.a aVar = this.k;
        URLConnection a4 = aVar != null ? aVar.a(this.e, url) : null;
        if (a4 == null) {
            Proxy proxy = this.e;
            if (proxy != null) {
                a4 = url.openConnection(proxy);
            } else {
                a4 = url.openConnection();
            }
        }
        if (this.c) {
            httpURLConnection = (HttpsURLConnection) a4;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.d.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a2);
        } else {
            httpURLConnection = (HttpURLConnection) a4;
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
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0110 A[SYNTHETIC, Splitter:B:74:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011a A[SYNTHETIC, Splitter:B:79:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0124 A[SYNTHETIC, Splitter:B:84:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012e A[SYNTHETIC, Splitter:B:89:0x012e] */
    private ey a(HttpURLConnection httpURLConnection, boolean z) throws cp, IOException {
        InputStream inputStream;
        Throwable th;
        PushbackInputStream pushbackInputStream;
        PushbackInputStream pushbackInputStream2;
        PushbackInputStream pushbackInputStream3;
        InputStream inputStream2;
        Throwable th2;
        List<String> list;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            httpURLConnection.connect();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (!(headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0)) {
                str = list.get(0);
            }
            if (responseCode == 200) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        pushbackInputStream = new PushbackInputStream(inputStream2, 2);
                        try {
                            byte[] bArr = new byte[2];
                            pushbackInputStream.read(bArr);
                            pushbackInputStream.unread(bArr);
                            FilterInputStream gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117 && !z) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            }
                            Cdo.c();
                            ey eyVar = new ey();
                            eyVar.a = byteArrayOutputStream2.toByteArray();
                            eyVar.b = headerFields;
                            eyVar.c = this.i;
                            eyVar.d = str;
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th3) {
                                dl.a(th3, "ht", "par");
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th4) {
                                    dl.a(th4, "ht", "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th5) {
                                dl.a(th5, "ht", "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th6) {
                                dl.a(th6, "ht", "par");
                            }
                            return eyVar;
                        } catch (IOException unused) {
                            pushbackInputStream3 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                throw new cp("IO 操作异常 - IOException", str);
                            } catch (Throwable th7) {
                                inputStream = inputStream2;
                                th = th7;
                                pushbackInputStream2 = pushbackInputStream3;
                                if (byteArrayOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (pushbackInputStream != null) {
                                }
                                if (pushbackInputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th2 = th8;
                            pushbackInputStream2 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            th = th2;
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (pushbackInputStream != null) {
                            }
                            if (pushbackInputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        pushbackInputStream3 = null;
                        pushbackInputStream = pushbackInputStream3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        throw new cp("IO 操作异常 - IOException", str);
                    } catch (Throwable th9) {
                        th2 = th9;
                        pushbackInputStream2 = null;
                        pushbackInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = inputStream2;
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th10) {
                                dl.a(th10, "ht", "par");
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th11) {
                                dl.a(th11, "ht", "par");
                            }
                        }
                        if (pushbackInputStream != null) {
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th12) {
                                dl.a(th12, "ht", "par");
                            }
                        }
                        if (pushbackInputStream2 != null) {
                            try {
                                pushbackInputStream2.close();
                            } catch (Throwable th13) {
                                dl.a(th13, "ht", "par");
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    inputStream2 = null;
                    pushbackInputStream3 = null;
                    pushbackInputStream = pushbackInputStream3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new cp("IO 操作异常 - IOException", str);
                } catch (Throwable th14) {
                    th = th14;
                    inputStream = null;
                    pushbackInputStream2 = null;
                    pushbackInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (pushbackInputStream != null) {
                    }
                    if (pushbackInputStream2 != null) {
                    }
                    throw th;
                }
            } else {
                cp cpVar = new cp("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.i, str);
                cpVar.a(responseCode);
                throw cpVar;
            }
        } catch (IOException unused4) {
            inputStream2 = null;
            pushbackInputStream3 = null;
            pushbackInputStream = null;
            throw new cp("IO 操作异常 - IOException", str);
        } catch (Throwable th15) {
            th = th15;
            inputStream = null;
            pushbackInputStream2 = null;
            pushbackInputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (pushbackInputStream2 != null) {
            }
            throw th;
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
            dl.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
    }

    /* compiled from: HttpUrlUtil */
    private static class b implements HostnameVerifier {
        private String a;
        private String b;

        private b() {
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public String a() {
            return this.b;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
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
    private static class a {
        private Vector<b> a;
        private volatile b b;

        private a() {
            this.a = new Vector<>();
            this.b = new b();
        }

        public b a() {
            return this.b;
        }

        public b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                b bVar = this.a.get(i);
                if (bVar != null && bVar.a().equals(str)) {
                    return bVar;
                }
            }
            b bVar2 = new b();
            bVar2.b(str);
            this.a.add(bVar2);
            return bVar2;
        }

        public void b(String str) {
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
}
