package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class q {
    private static long f;
    private static a o;
    String a;
    private final z b;
    private final aa c;
    private ay d;
    private ay e;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private aw n;

    q(aa aaVar, z zVar) {
        this.c = aaVar;
        this.b = zVar;
    }

    synchronized aw a() {
        return this.n;
    }

    synchronized Bundle a(long j2, long j3) {
        Bundle bundle;
        bundle = null;
        if (this.b.f() && c() && j2 - this.g > j3) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.l);
            int i2 = this.h + 1;
            this.h = i2;
            bundle.putInt("send_times", i2);
            bundle.putLong("current_duration", (j2 - this.g) / 1000);
            bundle.putString("session_start_time", aq.a(this.i));
            this.g = j2;
        }
        return bundle;
    }

    public boolean b() {
        return this.j;
    }

    boolean c() {
        return b() && this.k == 0;
    }

    private synchronized void a(aq aqVar, ArrayList<aq> arrayList, boolean z) {
        long j2 = aqVar instanceof a ? -1 : aqVar.a;
        this.a = UUID.randomUUID().toString();
        f = this.b.C();
        this.i = j2;
        this.j = z;
        this.k = 0;
        if (bo.b) {
            bo.a("startSession, " + this.a + ", hadUi:" + z + " data:" + aqVar, null);
        }
        if (z) {
            Calendar instance = Calendar.getInstance();
            String str = "" + instance.get(1) + instance.get(2) + instance.get(5);
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.b.c();
                this.l = this.b.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.b.a(str, this.l);
            this.h = 0;
        }
        if (j2 != -1) {
            aw awVar = new aw();
            awVar.c = this.a;
            awVar.b = a(this.b);
            awVar.a = this.i;
            awVar.i = this.c.d();
            awVar.h = this.c.c();
            if (this.b.v()) {
                awVar.e = AppLog.getAbConfigVersion();
                awVar.f = AppLog.getAbSDKVersion();
            }
            arrayList.add(awVar);
            this.n = awVar;
            if (bo.b) {
                bo.a("gen launch, " + awVar.c + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean a(aq aqVar) {
        if (aqVar instanceof ay) {
            return ((ay) aqVar).i();
        }
        return false;
    }

    boolean a(aq aqVar, ArrayList<aq> arrayList) {
        boolean z = aqVar instanceof ay;
        boolean a2 = a(aqVar);
        boolean z2 = true;
        if (this.i == -1) {
            a(aqVar, arrayList, a(aqVar));
        } else if (!this.j && a2) {
            a(aqVar, arrayList, true);
        } else if (this.k != 0 && aqVar.a > this.k + this.b.x()) {
            a(aqVar, arrayList, a2);
        } else if (this.i > aqVar.a + 7200000) {
            a(aqVar, arrayList, a2);
        } else {
            z2 = false;
        }
        if (z) {
            ay ayVar = (ay) aqVar;
            if (ayVar.i()) {
                this.g = aqVar.a;
                this.k = 0;
                arrayList.add(aqVar);
                if (TextUtils.isEmpty(ayVar.i)) {
                    if (this.e != null && (ayVar.a - this.e.a) - this.e.h < 500) {
                        ayVar.i = this.e.j;
                    } else if (this.d != null && (ayVar.a - this.d.a) - this.d.h < 500) {
                        ayVar.i = this.d.j;
                    }
                }
            } else {
                Bundle a3 = a(aqVar.a, 0);
                if (a3 != null) {
                    AppLog.onEventV3("play_session", a3);
                }
                this.g = 0;
                this.k = ayVar.a;
                arrayList.add(aqVar);
                if (ayVar.j()) {
                    this.d = ayVar;
                } else {
                    this.e = ayVar;
                    this.d = null;
                }
            }
        } else if (!(aqVar instanceof a)) {
            arrayList.add(aqVar);
        }
        b(aqVar);
        return z2;
    }

    public void b(aq aqVar) {
        if (aqVar != null) {
            aqVar.d = this.c.f();
            aqVar.c = this.a;
            aqVar.b = a(this.b);
            if (this.b.v()) {
                aqVar.e = AppLog.getAbConfigVersion();
                aqVar.f = AppLog.getAbSDKVersion();
            }
        }
    }

    public static long a(z zVar) {
        long j2 = f + 1;
        f = j2;
        if (j2 % 1000 == 0) {
            zVar.a(j2 + 1000);
        }
        return f;
    }

    static class a extends ba {
        private a() {
        }
    }

    static a d() {
        if (o == null) {
            o = new a();
        }
        o.a = System.currentTimeMillis();
        return o;
    }
}
