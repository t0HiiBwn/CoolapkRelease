package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ae;

public class z {
    private static int a = 8;
    private byte[] b = new byte[256];
    private int c = 0;
    private int d = 0;
    private int e = -666;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.b[i2] = (byte) i2;
        }
        this.d = 0;
        this.c = 0;
        while (true) {
            int i3 = this.c;
            if (i3 >= i) {
                break;
            }
            int a2 = ((this.d + a(this.b[i3])) + a(bArr[this.c % length])) % 256;
            this.d = a2;
            a(this.b, this.c, a2);
            this.c++;
        }
        if (i != 256) {
            this.e = ((this.d + a(this.b[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(a(this.b[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append("=");
            sb.append(this.d);
            sb.append("   j_");
            sb.append(i);
            sb.append("=");
            sb.append(this.e);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.b[this.d]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.b[this.e]));
            if (this.b[1] != 0) {
                sb.append("   S[1]!=0");
            }
            c.a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] c2 = ae.c(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(c2.length + 1 + bytes.length)];
        for (int i = 0; i < c2.length; i++) {
            bArr[i] = c2[i];
        }
        bArr[c2.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[c2.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, ae.c(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        z zVar = new z();
        zVar.a(bArr);
        zVar.b();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ zVar.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (!z) {
            bArr3 = new byte[i2];
            i3 = 0;
        } else {
            bArr3 = bArr2;
            i3 = i;
        }
        z zVar = new z();
        zVar.a(bArr);
        zVar.b();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ zVar.a());
        }
        return bArr3;
    }

    private void b() {
        this.d = 0;
        this.c = 0;
    }

    byte a() {
        int i = (this.c + 1) % 256;
        this.c = i;
        int a2 = (this.d + a(this.b[i])) % 256;
        this.d = a2;
        a(this.b, this.c, a2);
        byte[] bArr = this.b;
        return bArr[(a(bArr[this.c]) + a(this.b[this.d])) % 256];
    }
}
