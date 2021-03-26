package com.loc;

import java.util.List;

/* compiled from: UploadBufferBuilder */
public final class bw extends bt {
    private static bw b = new bw();

    private bw() {
        super(5120);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static bw b() {
        return b;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, List<? extends ca> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int a = cd.a((er) this.a, bArr);
            int[] iArr = new int[size];
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ca caVar = (ca) list.get(i2);
                iArr[i2] = ci.a(this.a, (byte) caVar.a(), ci.a(this.a, caVar.b()));
            }
            int a2 = cd.a(this.a, iArr);
            if (bArr2 != null) {
                i = cd.b(this.a, bArr2);
            }
            this.a.c(cd.a(this.a, a, i, a2));
            return this.a.c();
        } catch (Throwable th) {
            dg.a(th);
            return null;
        }
    }

    public final byte[] c() {
        super.a();
        try {
            this.a.c(df.a(this.a, de.a(), this.a.a(de.f()), this.a.a(de.c()), (byte) de.m(), this.a.a(de.i()), this.a.a(de.h()), this.a.a(a(de.g())), this.a.a(a(de.j())), dd.a(de.n()), this.a.a(de.l()), this.a.a(de.k()), this.a.a(de.d()), this.a.a(de.e())));
            return this.a.c();
        } catch (Exception e) {
            dg.a(e);
            return null;
        }
    }
}
