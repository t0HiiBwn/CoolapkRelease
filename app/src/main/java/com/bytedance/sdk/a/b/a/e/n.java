package com.bytedance.sdk.a.b.a.e;

import java.util.Arrays;

/* compiled from: Settings */
public final class n {
    private int a;
    private final int[] b = new int[10];

    void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    n a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean a(int i) {
        return ((1 << i) & this.a) != 0;
    }

    int b(int i) {
        return this.b[i];
    }

    int b() {
        return Integer.bitCount(this.a);
    }

    int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    int c(int i) {
        return (this.a & 16) != 0 ? this.b[4] : i;
    }

    int d(int i) {
        return (this.a & 32) != 0 ? this.b[5] : i;
    }

    int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                a(i, nVar.b(i));
            }
        }
    }
}
