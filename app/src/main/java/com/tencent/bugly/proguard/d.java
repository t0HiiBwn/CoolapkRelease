package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class d extends c {
    private static HashMap<String, byte[]> f;
    private static HashMap<String, HashMap<String, byte[]>> g;
    private f e;

    public d() {
        f fVar = new f();
        this.e = fVar;
        fVar.a = 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.e.a = 3;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        if (this.e.a != 2) {
            if (this.e.c == null) {
                this.e.c = "";
            }
            if (this.e.d == null) {
                this.e.d = "";
            }
        } else if (this.e.c.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.e.d.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        j jVar = new j(0);
        jVar.a(this.b);
        if (this.e.a == 2) {
            jVar.a((Map) this.a, 0);
        } else {
            jVar.a((Map) this.d, 0);
        }
        this.e.e = l.a(jVar.a());
        j jVar2 = new j(0);
        jVar2.a(this.b);
        this.e.a(jVar2);
        byte[] a = l.a(jVar2.a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                i iVar = new i(bArr, 4);
                iVar.a(this.b);
                this.e.a(iVar);
                if (this.e.a == 3) {
                    i iVar2 = new i(this.e.e);
                    iVar2.a(this.b);
                    if (f == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.d = iVar2.a((Map) f, 0, false);
                    return;
                }
                i iVar3 = new i(this.e.e);
                iVar3.a(this.b);
                if (g == null) {
                    g = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    g.put("", hashMap2);
                }
                this.a = iVar3.a((Map) g, 0, false);
                new HashMap();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public final void b(String str) {
        this.e.c = str;
    }

    public final void c(String str) {
        this.e.d = str;
    }

    public final void a(int i) {
        this.e.b = 1;
    }
}
