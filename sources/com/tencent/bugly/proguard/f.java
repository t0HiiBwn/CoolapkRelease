package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class f extends k {
    private static byte[] k = null;

    /* renamed from: l  reason: collision with root package name */
    private static Map<String, String> f1442l = null;
    private static /* synthetic */ boolean m = true;
    public short a = 0;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = 0;
    private int g = 0;
    private int h = 0;
    private Map<String, String> i;
    private Map<String, String> j;

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return l.a(1, fVar.a) && l.a(1, fVar.f) && l.a(1, fVar.g) && l.a(1, fVar.b) && l.a(1, fVar.c) && l.a(1, fVar.d) && l.a(1, fVar.e) && l.a(1, fVar.h) && l.a(1, fVar.i) && l.a(1, fVar.j);
    }

    @Override // java.lang.Object
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 1);
        jVar.a(this.f, 2);
        jVar.a(this.g, 3);
        jVar.a(this.b, 4);
        jVar.a(this.c, 5);
        jVar.a(this.d, 6);
        jVar.a(this.e, 7);
        jVar.a(this.h, 8);
        jVar.a((Map) this.i, 9);
        jVar.a((Map) this.j, 10);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        try {
            this.a = iVar.a(this.a, 1, true);
            this.f = iVar.a(this.f, 2, true);
            this.g = iVar.a(this.g, 3, true);
            this.b = iVar.a(this.b, 4, true);
            this.c = iVar.b(5, true);
            this.d = iVar.b(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            this.e = iVar.c(7, true);
            this.h = iVar.a(this.h, 8, true);
            if (f1442l == null) {
                HashMap hashMap = new HashMap();
                f1442l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) iVar.a((i) f1442l, 9, true);
            if (f1442l == null) {
                HashMap hashMap2 = new HashMap();
                f1442l = hashMap2;
                hashMap2.put("", "");
            }
            this.j = (Map) iVar.a((i) f1442l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + e.a(this.e));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.a, "iVersion");
        hVar.a(this.f, "cPacketType");
        hVar.a(this.g, "iMessageType");
        hVar.a(this.b, "iRequestId");
        hVar.a(this.c, "sServantName");
        hVar.a(this.d, "sFuncName");
        hVar.a(this.e, "sBuffer");
        hVar.a(this.h, "iTimeout");
        hVar.a((Map) this.i, "context");
        hVar.a((Map) this.j, "status");
    }
}
