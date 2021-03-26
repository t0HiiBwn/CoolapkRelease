package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Request<T> implements Comparable<Request<T>> {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;
    protected m.a<T> a;
    protected Handler b;
    private final o.a c;
    private final int d;
    private String e;
    private String f;
    private final int g;
    private final Object h;
    private Integer i;
    private l j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private d o;
    private a.C0035a p;
    private Object q;
    private long r;
    private long s;
    private boolean t;
    private String u;
    private Map<String, Object> v;
    private a w;

    interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract m<T> a(i iVar);

    protected VAdError a(VAdError vAdError) {
        return vAdError;
    }

    protected void a(long j2, long j3) {
    }

    protected abstract void a(m<T> mVar);

    protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
        return null;
    }

    protected String d() {
        return "UTF-8";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    @Deprecated
    public Request(String str, m.a aVar) {
        this(-1, str, aVar);
    }

    public Request(int i2, String str, m.a aVar) {
        this.c = o.a.a ? new o.a() : null;
        this.f = "VADNetAgent/0";
        this.h = new Object();
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0;
        this.s = 0;
        this.t = true;
        this.b = new Handler(Looper.getMainLooper());
        this.d = i2;
        this.e = str;
        this.a = aVar;
        setRetryPolicy(new e());
        this.g = b(str);
    }

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.v == null) {
                this.v = new HashMap();
            }
            this.v.put(str, obj);
        }
        return this;
    }

    public Map<String, Object> getExtra() {
        return this.v;
    }

    public long getStartTime() {
        return this.r;
    }

    public void setStartTime() {
        this.r = SystemClock.elapsedRealtime();
    }

    public long getNetDuration() {
        return this.s;
    }

    public void setNetDuration(long j2) {
        this.s = j2;
    }

    public boolean isResponseOnMain() {
        return this.t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        this.t = z;
        return this;
    }

    public int getMethod() {
        return this.d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.q = obj;
        return this;
    }

    public Object getTag() {
        return this.q;
    }

    public m.a getBaseListener() {
        m.a<T> aVar;
        synchronized (this.h) {
            aVar = this.a;
        }
        return aVar;
    }

    public int getTrafficStatsTag() {
        return this.g;
    }

    private static int b(String str) {
        Uri parse;
        String host;
        try {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
                return 0;
            }
            return host.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(d dVar) {
        this.o = dVar;
        return this;
    }

    public void addMarker(String str) {
        if (o.a.a) {
            this.c.a(str, Thread.currentThread().getId());
        }
    }

    public String getUserAgent() {
        return this.f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        this.f = str;
        return this;
    }

    void a(final String str) {
        l lVar = this.j;
        if (lVar != null) {
            lVar.c(this);
        }
        if (o.a.a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.b.post(new Runnable() {
                    /* class com.bytedance.sdk.adnet.core.Request.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.c.a(str, id);
                        Request.this.c.a(Request.this.toString());
                    }
                });
                return;
            }
            this.c.a(str, id);
            this.c.a(toString());
        }
    }

    void a(int i2) {
        l lVar = this.j;
        if (lVar != null) {
            lVar.a(this, i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(l lVar) {
        this.j = lVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i2) {
        this.i = Integer.valueOf(i2);
        return this;
    }

    public final l getRequestQueue() {
        return this.j;
    }

    public final int getSequence() {
        Integer num = this.i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.e;
    }

    public void setUrl(String str) {
        this.e = str;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return Integer.toString(method) + '-' + url;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(a.C0035a aVar) {
        this.p = aVar;
        return this;
    }

    public a.C0035a getCacheEntry() {
        return this.p;
    }

    public void cancel() {
        synchronized (this.h) {
            this.l = true;
            this.a = null;
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.h) {
            z = this.l;
        }
        return z;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
        return c();
    }

    @Deprecated
    protected String b() {
        return d();
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> a2 = a();
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        return a(a2, b());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> c2 = c();
        if (c2 == null || c2.size() <= 0) {
            return null;
        }
        return a(c2, d());
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.k = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.k;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.n = z;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.n;
    }

    public b getPriority() {
        return b.NORMAL;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().a();
    }

    public d getRetryPolicy() {
        return this.o;
    }

    public void markDelivered() {
        synchronized (this.h) {
            this.m = true;
        }
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.h) {
            z = this.m;
        }
        return z;
    }

    public void build(l lVar) {
        if (lVar != null) {
            lVar.a(this);
        }
    }

    public void deliverError(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.h) {
            aVar = this.a;
        }
        if (aVar != null) {
            aVar.b(mVar);
        }
    }

    void a(a aVar) {
        synchronized (this.h) {
            this.w = aVar;
        }
    }

    public String getIpAddrStr() {
        return this.u;
    }

    public void setIpAddrStr(String str) {
        this.u = str;
    }

    void b(m<?> mVar) {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this, mVar);
        }
    }

    void e() {
        a aVar;
        synchronized (this.h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public int compareTo(Request<T> request) {
        b priority = getPriority();
        b priority2 = request.getPriority();
        return priority == priority2 ? this.i.intValue() - request.i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Override // java.lang.Object
    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.i);
        return sb.toString();
    }
}
