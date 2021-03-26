package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class aj extends k implements Cloneable {
    private static byte[] d;
    private byte a = 0;
    private String b = "";
    private byte[] c = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    public aj() {
    }

    public aj(byte b2, String str, byte[] bArr) {
        this.a = b2;
        this.b = str;
        this.c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.b(1, true);
        if (d == null) {
            byte[] bArr = new byte[1];
            d = bArr;
            bArr[0] = 0;
        }
        this.c = iVar.c(2, false);
    }
}
