package com.pgl.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public abstract class b {
    public String a = "";
    private Context b;
    private String c;
    private int d;
    private int e;
    private byte[] f;
    private int g = -1;
    private byte[] h = null;
    private int i = 10000;
    private int j = 1;
    private int k = 0;
    private boolean l = false;
    private HandlerThread m;
    private Handler n;
    private boolean o = false;
    private HttpURLConnection p = null;

    public b(Context context, String str) {
        str = (str == null || str.length() <= 0) ? "" : str;
        this.b = context;
        this.c = str;
    }

    private void a(int i2) {
        String str = "GET";
        switch (i2) {
            case 1:
                str = "POST";
                break;
            case 3:
                str = "PUT";
                break;
            case 4:
                str = "DELETE";
                break;
            case 5:
                str = "HEAD";
                break;
            case 6:
                str = "TRACE";
                break;
        }
        this.p.setRequestMethod(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
        if (r2 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        if (r2 != null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        r2 = r4.p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0086, code lost:
        if (r2 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
        r2.disconnect();
        r4.p = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        if (r2 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r0 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        a(r4.g, r4.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        return r0;
     */
    public boolean a() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        boolean z = true;
        try {
            URL url = new URL(this.a);
            if (this.o) {
                HttpsURLConnection.setDefaultSSLSocketFactory(SSLContext.getInstance("TLS").getSocketFactory());
                httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            this.p = httpURLConnection;
            this.p.setConnectTimeout(this.i);
            this.p.setReadTimeout(this.i);
            a(this.d);
            b(this.e);
            byte[] bArr = this.f;
            if (bArr != null && bArr.length > 0) {
                this.p.setDoOutput(true);
                OutputStream outputStream = this.p.getOutputStream();
                outputStream.write(this.f);
                outputStream.flush();
                outputStream.close();
            }
            this.p.connect();
            try {
                this.g = this.p.getResponseCode();
                inputStream = this.p.getInputStream();
                try {
                    this.h = a(inputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        } catch (Throwable th) {
            if (this.p != null) {
                this.p.disconnect();
                this.p = null;
            }
            throw th;
        }
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private void b(int i2) {
        HttpURLConnection httpURLConnection;
        StringBuilder sb;
        String str = i2 != 1 ? i2 != 2 ? "" : "application/octet-stream" : "application/json; charset=utf-8";
        if (str.length() > 0) {
            this.p.addRequestProperty("Content-Type", str);
        }
        HttpURLConnection httpURLConnection2 = this.p;
        httpURLConnection2.addRequestProperty("Cookie", "sessionid=" + this.c);
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                httpURLConnection = this.p;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(",");
                sb.append(language);
                sb.append(";q=0.9");
            } else {
                httpURLConnection = this.p;
                sb = new StringBuilder();
                sb.append(Locale.getDefault().toString());
                sb.append(",");
                sb.append(language);
                sb.append(";q=0.9,en-US;q=0.6,en;q=0.4");
            }
            httpURLConnection.addRequestProperty("Accept-Language", sb.toString());
        } catch (Throwable unused) {
        }
    }

    private void b(int i2, int i3, byte[] bArr) {
        this.d = i2;
        this.e = i3;
        this.f = bArr;
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.k;
        bVar.k = i2 + 1;
        return i2;
    }

    public synchronized void a(int i2, int i3, byte[] bArr) {
        if (!this.l) {
            this.j = 2;
            b(i2, i3, bArr);
            this.l = true;
            this.k = 0;
            HandlerThread handlerThread = new HandlerThread("request");
            this.m = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.m.getLooper(), new Handler.Callback() {
                /* class com.pgl.a.a.b.AnonymousClass1 */

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (b.this.k >= b.this.j) {
                        b.this.l = false;
                        b.this.k = 0;
                        b.this.m.quit();
                        return false;
                    } else if (b.this.a()) {
                        b.this.l = false;
                        b.this.k = 0;
                        b.this.m.quit();
                        return true;
                    } else {
                        b.this.n.sendEmptyMessageDelayed(1, (long) (b.this.i * 1));
                        b.g(b.this);
                        return false;
                    }
                }
            });
            this.n = handler;
            handler.sendEmptyMessage(1);
        }
    }

    public abstract boolean a(int i2, byte[] bArr);
}
