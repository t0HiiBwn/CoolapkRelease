package com.umeng.analytics.pro;

/* compiled from: TApplicationException */
public class bh extends bo {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final cm j = new cm("TApplicationException");
    private static final cc k = new cc("message", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final cc f1462l = new cc("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i = 0;

    public bh() {
    }

    public bh(int i2) {
        this.i = i2;
    }

    public bh(int i2, String str) {
        super(str);
        this.i = i2;
    }

    public bh(String str) {
        super(str);
    }

    public int a() {
        return this.i;
    }

    public static bh a(ch chVar) throws bo {
        chVar.j();
        String str = null;
        int i2 = 0;
        while (true) {
            cc l2 = chVar.l();
            if (l2.b == 0) {
                chVar.k();
                return new bh(i2, str);
            }
            short s = l2.c;
            if (s != 1) {
                if (s != 2) {
                    ck.a(chVar, l2.b);
                } else if (l2.b == 8) {
                    i2 = chVar.w();
                } else {
                    ck.a(chVar, l2.b);
                }
            } else if (l2.b == 11) {
                str = chVar.z();
            } else {
                ck.a(chVar, l2.b);
            }
            chVar.m();
        }
    }

    public void b(ch chVar) throws bo {
        chVar.a(j);
        if (getMessage() != null) {
            chVar.a(k);
            chVar.a(getMessage());
            chVar.c();
        }
        chVar.a(f1462l);
        chVar.a(this.i);
        chVar.c();
        chVar.d();
        chVar.b();
    }
}
