package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.embedapplog.bz;
import com.bytedance.embedapplog.cf;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public final class ce {
    public static final String a;
    private static final String b;
    private static IOaidObserver d;
    private static String j;
    private final ReentrantLock c = new ReentrantLock();
    private cf e;
    private boolean f;
    private ci g;
    private final Context h;
    private AtomicBoolean i = new AtomicBoolean(false);
    private Map<String, String> k;

    /* renamed from: l  reason: collision with root package name */
    private Long f1261l;

    static {
        String str = ce.class.getSimpleName() + "#";
        b = str;
        a = str;
    }

    ce(Context context) {
        this.h = context;
        cf a2 = cg.a(context);
        this.e = a2;
        if (a2 != null) {
            this.f = a2.a(context);
        } else {
            this.f = false;
        }
        this.g = new ci(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r3 == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        r6.c.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0056, code lost:
        if (r3 != false) goto L_0x0061;
     */
    public Map<String, String> a(long j2) {
        if (!this.f) {
            return null;
        }
        a();
        String str = a;
        bx.a(str, "Oaid#getOaid timeoutMills=" + j2);
        if (this.k == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z = false;
            try {
                z = this.c.tryLock(j2, TimeUnit.MILLISECONDS);
                bx.b(str, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                if (z) {
                    this.c.unlock();
                }
                throw th;
            }
        }
        String str2 = a;
        bx.a(str2, "Oaid#getOaid return apiMap=" + this.k);
        return this.k;
    }

    static void a(IOaidObserver iOaidObserver) {
        d = iOaidObserver;
        String str = j;
        if (str != null) {
            a(new IOaidObserver.Oaid(str));
        }
    }

    private static void a(IOaidObserver.Oaid oaid) {
        IOaidObserver iOaidObserver;
        if (oaid != null && (iOaidObserver = d) != null) {
            iOaidObserver.onOaidLoaded(oaid);
        }
    }

    static void a(JSONObject jSONObject, String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 != null && v != null) {
            map.put(k2, v);
        }
    }

    public void a() {
        if (this.i.compareAndSet(false, true)) {
            a(new Runnable() {
                /* class com.bytedance.embedapplog.ce.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    ce.this.b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        String str = a;
        bx.b(str, "Oaid#initOaid");
        try {
            this.c.lock();
            bx.b(str, "Oaid#initOaid exec");
            ch a2 = this.g.a();
            bx.b(str, "Oaid#initOaid fetch=" + a2);
            if (a2 != null) {
                j = a2.a;
                this.k = a2.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> a3 = a(this.h);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ch chVar = null;
            String str2 = null;
            if (a3.first != null) {
                int i2 = -1;
                int i3 = 1;
                if (a2 != null) {
                    str2 = a2.b;
                    i2 = a2.f.intValue() + 1;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                if (i2 > 0) {
                    i3 = i2;
                }
                ch chVar2 = new ch((String) a3.first, str2, (Boolean) a3.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), this.f1261l);
                this.g.a(chVar2);
                chVar = chVar2;
            }
            if (chVar != null) {
                j = chVar.a;
                this.k = chVar.a();
            }
            bx.b(str, "Oaid#initOaid oaidModel=" + chVar);
        } finally {
            this.c.unlock();
            a(new IOaidObserver.Oaid(j));
        }
    }

    private Pair<String, Boolean> a(Context context) {
        Boolean bool;
        cf.a b2;
        cf cfVar = this.e;
        String str = null;
        if (cfVar == null || (b2 = cfVar.b(context)) == null) {
            bool = null;
        } else {
            str = b2.b;
            bool = Boolean.valueOf(b2.c);
            if (b2 instanceof bz.a) {
                this.f1261l = Long.valueOf(((bz.a) b2).a);
            }
        }
        return new Pair<>(str, bool);
    }

    private static void a(Runnable runnable) {
        by.a(a + "-query", runnable);
    }
}
