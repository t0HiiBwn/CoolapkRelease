package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class k implements Handler.Callback, Comparator<aq> {
    private static k b;
    public Application a;
    private g c;
    private boolean d;
    private z e;
    private final ArrayList<aq> f = new ArrayList<>(32);
    private as g;
    private aa h;
    private Handler i;
    private q j;
    private Handler k;

    public static void a() {
        k kVar = b;
        if (kVar != null) {
            kVar.b(null);
        }
    }

    private k() {
    }

    public static k b() {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
            }
        }
        return b;
    }

    public static String c() {
        return d().a;
    }

    public static q d() {
        k kVar = b;
        if (kVar != null) {
            return kVar.j;
        }
        bo.a(null);
        return null;
    }

    public void a(Application application, z zVar, aa aaVar, f fVar) {
        this.a = application;
        this.g = new as(application, aaVar, zVar);
        this.e = zVar;
        this.h = aaVar;
        this.j = new q(aaVar, zVar);
        this.a.registerActivityLifecycleCallbacks(fVar);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.k = handler;
        boolean z = true;
        handler.sendEmptyMessage(1);
        if (zVar.i() == 0) {
            z = false;
        }
        bn.a(z);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            bo.a = this.e.w();
            if (!this.h.e()) {
                this.k.removeMessages(1);
                this.k.sendEmptyMessageDelayed(1, 1000);
            } else if (this.e.r()) {
                HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper(), this);
                this.i = handler;
                handler.sendEmptyMessage(2);
                if (this.f.size() > 0) {
                    this.k.removeMessages(4);
                    this.k.sendEmptyMessageDelayed(4, 1000);
                }
                bo.d("net|worker start", null);
            }
            t.a();
        } else if (i2 == 2) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(new o(this.a, this.h, this.j));
            arrayList.add(new j(this.a, this.h, this.e));
            arrayList.add(new n(this.a, this.h, this.g));
            arrayList.add(new p(this.a, this.g, this.e, this.h));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                long h2 = iVar.h();
                if (h2 < 864000000) {
                    this.i.sendMessageDelayed(this.k.obtainMessage(6, iVar), h2);
                }
            }
            g();
        } else if (i2 == 4) {
            b(null);
        } else if (i2 == 5) {
            b((String[]) message.obj);
        } else if (i2 == 6) {
            i iVar2 = (i) message.obj;
            if (!iVar2.g()) {
                long h3 = iVar2.h();
                if (h3 < 864000000) {
                    this.i.sendMessageDelayed(this.k.obtainMessage(6, iVar2), h3);
                }
                g();
            }
        } else if (i2 != 7) {
            bo.a(null);
        } else {
            synchronized (this.f) {
                this.f.add(q.d());
            }
            b(null);
        }
        return true;
    }

    private void g() {
        if (!this.e.v()) {
            g gVar = this.c;
            if (gVar != null) {
                gVar.f();
                this.c = null;
            }
        } else if (this.c == null) {
            g gVar2 = new g(this.a, this.h, this.e);
            this.c = gVar2;
            this.i.obtainMessage(6, gVar2).sendToTarget();
        }
    }

    public boolean e() {
        this.d = true;
        h hVar = new h(this.a, this.h);
        Handler handler = this.i;
        if (handler == null) {
            return false;
        }
        handler.obtainMessage(6, hVar).sendToTarget();
        return true;
    }

    private void b(String[] strArr) {
        ArrayList<aq> arrayList;
        synchronized (this.f) {
            arrayList = (ArrayList) this.f.clone();
            this.f.clear();
        }
        int i2 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(aq.a(str));
            }
        }
        boolean a2 = this.e.a(arrayList);
        if (arrayList.size() <= 0) {
            return;
        }
        if (!this.e.r()) {
            Intent intent = new Intent(this.a, Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i3 = 0;
            while (i2 < size) {
                strArr2[i2] = arrayList.get(i2).e().toString();
                i3 += strArr2[i2].length();
                i2++;
            }
            if (i3 >= 307200) {
                bo.a(null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.a.sendBroadcast(intent);
            } catch (Exception e2) {
                bo.a(e2);
            }
        } else if (a2 || arrayList.size() > 100) {
            Collections.sort(arrayList, this);
            ArrayList<aq> arrayList2 = new ArrayList<>(arrayList.size());
            Iterator<aq> it2 = arrayList.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                aq next = it2.next();
                if (this.j.a(next, arrayList2)) {
                    h();
                }
                if (next instanceof ay) {
                    z = q.a(next);
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                if (z) {
                    this.k.removeMessages(7);
                } else {
                    this.k.sendEmptyMessageDelayed(7, this.e.x());
                }
            }
            this.g.a(arrayList2);
            if (!this.d && this.j.b() && this.i != null && AppLog.getAutoActiveState()) {
                e();
            }
        } else {
            synchronized (this.f) {
                this.f.addAll(arrayList);
            }
        }
    }

    private void h() {
        if (bo.b) {
            bo.a("packAndSend once, " + this.j.a + ", hadUI:" + this.j.b(), null);
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.sendMessage(this.k.obtainMessage(6, new l(this.a, this.h, this.g)));
            this.i.sendMessage(this.k.obtainMessage(6, new m(this.a, this.g, this.e, this.h)));
        }
    }

    public static void a(aq aqVar) {
        int size;
        Handler handler;
        k kVar = b;
        if (kVar == null) {
            bo.b("Init comes First!", null);
            t.a(aqVar);
            return;
        }
        if (aqVar.a == 0) {
            bo.a(null);
        }
        if (aqVar instanceof az) {
            ((az) aqVar).i = kVar.e.i();
        }
        synchronized (kVar.f) {
            size = kVar.f.size();
            kVar.f.add(aqVar);
        }
        if (size % 10 == 0 && (handler = kVar.k) != null) {
            handler.removeMessages(4);
            kVar.k.sendEmptyMessageDelayed(4, size == 0 ? 500 : 250);
        }
    }

    public static void a(String[] strArr) {
        k kVar = b;
        if (kVar == null) {
            bo.a(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = kVar.k;
        if (handler != null) {
            handler.removeMessages(4);
            kVar.k.obtainMessage(5, strArr).sendToTarget();
        }
    }

    /* renamed from: a */
    public int compare(aq aqVar, aq aqVar2) {
        int i2 = ((aqVar.a - aqVar2.a) > 0 ? 1 : ((aqVar.a - aqVar2.a) == 0 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public boolean f() {
        z zVar;
        k kVar = b;
        if (kVar == null || (zVar = kVar.e) == null) {
            return false;
        }
        return zVar.b();
    }
}
