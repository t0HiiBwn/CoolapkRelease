package com.loc;

/* compiled from: AmapCell */
public abstract class cw {
    public String a = "";
    public String b = "";
    public int c = 99;
    public int d = Integer.MAX_VALUE;
    public long e = 0;
    public long f = 0;
    public int g = 0;
    public boolean h;
    public boolean i = true;

    public cw(boolean z, boolean z2) {
        this.h = z;
        this.i = z2;
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            dg.a(e2);
            return 0;
        }
    }

    /* renamed from: a */
    public abstract cw clone();

    public final void a(cw cwVar) {
        if (cwVar != null) {
            this.a = cwVar.a;
            this.b = cwVar.b;
            this.c = cwVar.c;
            this.d = cwVar.d;
            this.e = cwVar.e;
            this.f = cwVar.f;
            this.g = cwVar.g;
            this.h = cwVar.h;
            this.i = cwVar.i;
        }
    }

    public final int b() {
        return a(this.a);
    }

    public final int c() {
        return a(this.b);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
