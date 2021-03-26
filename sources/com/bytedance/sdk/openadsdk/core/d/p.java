package com.bytedance.sdk.openadsdk.core.d;

/* compiled from: SplashAdCache */
public class p {
    private l a;
    private byte[] b;
    private a c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.c = aVar;
        this.a = lVar;
        this.b = bArr;
    }

    public l a() {
        return this.a;
    }

    public void a(l lVar) {
        this.a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public byte[] b() {
        return this.b;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public a c() {
        return this.c;
    }
}
