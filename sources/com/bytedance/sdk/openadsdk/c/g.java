package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* compiled from: AdEventThread */
public class g<T extends i> extends HandlerThread implements Handler.Callback {
    public static String a = "AdEventThread";
    public static String b = "ttad_bk";
    public final e<T> c;
    public q<T> d;
    public final List<T> e = Collections.synchronizedList(new LinkedList());
    public long f;
    public boolean g;
    public int h;
    public Handler i;
    public final a j;
    public final b k;
    protected boolean l = false;

    /* compiled from: AdEventThread */
    public interface a {
        boolean a();
    }

    public g(e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + b);
        this.k = bVar;
        this.j = aVar;
        this.c = eVar;
        this.d = qVar;
    }

    public g(String str, String str2, e<T> eVar, q<T> qVar, b bVar, a aVar) {
        super("tt_pangle_thread__" + str);
        a = str2;
        this.k = bVar;
        this.j = aVar;
        this.c = eVar;
        this.d = qVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f = System.currentTimeMillis();
        this.i = new Handler(getLooper(), this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.bytedance.sdk.openadsdk.c.g<T extends com.bytedance.sdk.openadsdk.c.i> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a((g<T>) ((i) message.obj));
        } else if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            c();
        } else if (i2 == 4) {
            b();
        } else if (i2 == 5) {
            a();
        }
        return true;
    }

    private void a() {
        this.c.a(this.k.d, this.k.e);
        this.g = this.c.a();
        this.h = this.c.b();
        if (this.g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.h);
            h();
            return;
        }
        b(this.c.a(100, "_id"));
        a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
        a("onHandleInitEvent cacheData count = " + this.e.size());
        e();
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T t : this.e) {
                        hashSet.add(t.b());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.b())) {
                            this.e.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private void b() {
        if (!this.j.a()) {
            a(4, this.k.c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> a2 = this.c.a(100, "_id");
        c(a2);
        if (s.a(a2)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            o();
            j();
            return;
        }
        h a3 = a(a2);
        if (a3 == null) {
            return;
        }
        if (a3.a) {
            a("onHandleServerBusyRetryEvent, success");
            g();
            f();
        } else if (a(a3)) {
            int i2 = this.h + 1;
            this.h = i2;
            this.c.a(i2);
            this.c.a(a2, this.k.d, this.k.e);
            h();
            a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.h);
        } else if (b(a3)) {
            g();
            f();
        } else if (!this.l) {
            i();
            a("onHandleServerBusyRetryEvent, net fail");
        } else {
            int i3 = this.h + 1;
            this.h = i3;
            this.c.a(i3);
            this.c.a(a2, this.k.d, this.k.e);
            l();
        }
    }

    public h a(List<T> list) {
        if (this.d == null) {
            p.f();
        }
        q<T> qVar = this.d;
        if (qVar == null) {
            return null;
        }
        return qVar.a(list);
    }

    private void c() {
        if (!this.g) {
            a("onHandleRoutineRetryEvent");
            e();
        }
    }

    private void d() {
        if (!this.g) {
            a("onHandleRoutineUploadEvent");
            e();
        }
    }

    private void a(T t) {
        c(this.e);
        this.c.a((e<T>) t);
        a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
        if (!this.g) {
            a("onHandleReceivedAdEvent");
            this.e.add(t);
            if (n()) {
                a("onHandleReceivedAdEvent upload");
                e();
            }
        }
    }

    private void c(List<T> list) {
        if (this.l && list != null) {
            if (list.size() <= 100) {
                a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:100");
                return;
            }
            int size = (int) (((float) list.size()) - 75.0f);
            a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
            list.removeAll(arrayList);
            this.c.a(arrayList);
            a("end checkAndDeleteEvent local size:" + list.size());
        }
    }

    private void e() {
        this.i.removeMessages(3);
        this.i.removeMessages(2);
        if (s.a(this.e)) {
            this.f = System.currentTimeMillis();
            j();
        } else if (!this.j.a()) {
            a("doRoutineUpload no net, wait retry");
            i();
        } else {
            h a2 = a(this.e);
            if (a2 == null) {
                return;
            }
            if (a2.a) {
                a("doRoutineUpload success");
                g();
                f();
            } else if (a(a2)) {
                a("doRoutineUpload serverbusy");
                k();
            } else if (b(a2)) {
                g();
                f();
            } else if (this.g) {
            } else {
                if (!this.l) {
                    i();
                    a("doRoutineUpload net fail retry");
                    return;
                }
                l();
            }
        }
    }

    private void f() {
        this.f = System.currentTimeMillis();
        o();
        j();
    }

    private void g() {
        a("clearCacheList, delete event from cache and db");
        this.c.a(this.e);
        this.e.clear();
    }

    private void h() {
        a(4, m());
    }

    private void i() {
        a(3, this.k.c);
    }

    private void j() {
        a(2, this.k.b);
    }

    private void a(int i2, long j2) {
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.what = i2;
        this.i.sendMessageDelayed(obtainMessage, j2);
    }

    private void k() {
        this.g = true;
        this.c.a(true);
        this.e.clear();
        this.i.removeMessages(3);
        this.i.removeMessages(2);
        h();
    }

    private void l() {
        this.g = true;
        this.c.a(true);
        this.e.clear();
        this.i.removeMessages(3);
        this.i.removeMessages(2);
        h();
    }

    private long m() {
        return ((long) ((this.h % 3) + 1)) * this.k.f;
    }

    private static boolean a(h hVar) {
        return hVar.b == 509;
    }

    private static boolean b(h hVar) {
        return hVar.d;
    }

    private boolean n() {
        return !this.g && (this.e.size() >= this.k.a || System.currentTimeMillis() - this.f >= this.k.b);
    }

    private void o() {
        this.g = false;
        this.c.a(false);
        this.h = 0;
        this.c.a(0);
        this.i.removeMessages(4);
    }

    private void a(String str) {
        u.b(a, str);
    }

    /* compiled from: AdEventThread */
    public static class b {
        final int a;
        final long b;
        final long c;
        final int d;
        final long e;
        final long f;

        b(int i, long j, long j2, int i2, long j3, long j4) {
            this.a = i;
            this.b = j;
            this.c = j2;
            this.d = i2;
            this.e = j3;
            this.f = j4;
        }

        public static b a() {
            return new b(1, 120000, 15000, 5, 172800000, 300000);
        }

        public static b b() {
            return new b(3, 120000, 15000, 5, 172800000, 300000);
        }
    }
}
