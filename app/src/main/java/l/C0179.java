package l;

import cc.binmt.signature.Hook;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: l.۬ۧۡ  reason: contains not printable characters */
public class C0179 implements Closeable {

    /* renamed from: ۗۘۚ  reason: not valid java name and contains not printable characters */
    private Map<String, C0168> f1162;

    /* renamed from: ۘ۠ۤ  reason: not valid java name and contains not printable characters */
    private final AbstractC0170 f1163;

    /* renamed from: ۙۚ۠  reason: not valid java name and contains not printable characters */
    private boolean f1164;

    /* JADX WARNING: Illegal instructions before constructor call */
    public C0179(File file) {
        this(C0166.m2072(file, C0166.m2070(r0)));
        short[] r0 = C0161.m2026(1);
        // fill-array-data instruction
        r0[0] = -20;
    }

    public C0179(AbstractC0170 r2) {
        this.f1162 = new LinkedHashMap();
        this.f1164 = false;
        this.f1163 = r2;
        m2191();
    }

    /* renamed from: ۚۚۙ  reason: not valid java name and contains not printable characters */
    private long m2186() {
        return this.f1163.mo2141();
    }

    /* renamed from: ۜ۫ۖ  reason: not valid java name and contains not printable characters */
    private long m2187() {
        return ((long) m2188()) & 4294967295L;
    }

    /* renamed from: ۤ۟ۙ  reason: not valid java name and contains not printable characters */
    private int m2188() {
        int r0 = this.f1163.mo2133();
        int r1 = this.f1163.mo2133();
        int r2 = this.f1163.mo2133();
        int r3 = this.f1163.mo2133();
        if ((r0 | r1 | r2 | r3) >= 0) {
            return r0 | (r1 << 8) | (r2 << 16) | (r3 << 24);
        }
        throw new EOFException();
    }

    /* renamed from: ۤۡۤ  reason: not valid java name and contains not printable characters */
    private void m2189(int i) {
        if (i >= 0) {
            long r0 = this.f1163.mo2138() + ((long) i);
            if (r0 <= this.f1163.mo2141()) {
                this.f1163.mo2142(r0);
                return;
            }
            throw new EOFException();
        }
        StringBuilder sb = new StringBuilder();
        short[] r2 = C0161.m2026(5);
        // fill-array-data instruction
        r2[0] = 18;
        r2[1] = 42;
        r2[2] = 40;
        r2[3] = 49;
        r2[4] = 97;
        sb.append(C0169.m2124(r2));
        sb.append(i);
        throw new IOException(sb.toString());
    }

    /* renamed from: ۤۥۘ  reason: not valid java name and contains not printable characters */
    private void m2190() {
        boolean z;
        long r0 = m2186();
        long j = r0 - 22;
        long max = Math.max(0L, r0 - 65557);
        while (true) {
            if (j < max) {
                z = false;
                break;
            }
            m2193(j);
            if (m2188() == 101010256) {
                z = true;
                break;
            }
            j--;
        }
        if (z) {
            m2193(j + 16);
            m2193(m2187());
            return;
        }
        short[] r1 = C0161.m2026(28);
        // fill-array-data instruction
        r1[0] = -41;
        r1[1] = -101;
        r1[2] = 93;
        r1[3] = -104;
        r1[4] = -1;
        r1[5] = -97;
        r1[6] = 91;
        r1[7] = -48;
        r1[8] = -1;
        r1[9] = -102;
        r1[10] = 30;
        r1[11] = -98;
        r1[12] = -7;
        r1[13] = -99;
        r1[14] = 30;
        r1[15] = -111;
        r1[16] = -74;
        r1[17] = -77;
        r1[18] = 119;
        r1[19] = -96;
        r1[20] = -74;
        r1[21] = -120;
        r1[22] = 76;
        r1[23] = -109;
        r1[24] = -2;
        r1[25] = -128;
        r1[26] = 72;
        r1[27] = -107;
        throw new IOException(C0161.m2029(r1));
    }

    /* renamed from: ۥۨۦ  reason: contains not printable characters */
    private void m2191() {
        ArrayList<C0168> arrayList = new ArrayList();
        m2190();
        while (m2188() == 33639248) {
            C0168 r1 = new C0168();
            r1.m2105((m2194() >> 8) & 15);
            m2194();
            r1.m2092(m2194());
            r1.m2089(m2194());
            r1.m2117(C0172.m2170(m2187()));
            r1.m2102(m2188());
            r1.m2115(m2187());
            r1.m2093(m2187());
            int r2 = m2194();
            int r3 = m2194();
            int r4 = m2194();
            m2194();
            r1.m2090(m2194());
            r1.m2106(m2188());
            r1.m2085(m2187());
            r1.m2097(m2192(r2));
            if (r3 > 0) {
                m2189(r3);
            }
            if (r4 > 0) {
                r1.m2107(m2192(r4));
            }
            arrayList.add(r1);
        }
        Charset charset = C0159.f1058;
        Charset charset2 = C0159.f1058;
        this.f1162.clear();
        for (C0168 r42 : arrayList) {
            long r5 = r42.m2100() + 26;
            m2193(r5);
            int r7 = m2194();
            int r8 = m2194();
            m2189(r7);
            r42.m2086(m2192(r8));
            r42.m2111(r5 + 2 + 2 + ((long) r7) + ((long) r8));
            int i = 0;
            if (r42.m2112()) {
                r42.m2083(charset2, false);
            } else {
                r42.m2083(charset, true);
            }
            if (r42.m2108()) {
                r42.m2092(r42.m2098() & -2);
                int r52 = r42.m2104();
                if (!(r52 == 8 || r52 == 0)) {
                    if (r42.m2091() != r42.m2114()) {
                        i = 8;
                    }
                    r42.m2089(i);
                }
            }
            this.f1162.put(r42.m2116(), r42);
        }
    }

    /* renamed from: ۦۦ۬  reason: contains not printable characters */
    private byte[] m2192(int i) {
        byte[] bArr = new byte[i];
        this.f1163.mo2134(bArr);
        return bArr;
    }

    /* renamed from: ۧ۠ۥ  reason: not valid java name and contains not printable characters */
    private void m2193(long j) {
        this.f1163.mo2142(j);
    }

    /* renamed from: ۫ۖۢ  reason: not valid java name and contains not printable characters */
    private int m2194() {
        int r0 = this.f1163.mo2133();
        int r1 = this.f1163.mo2133();
        if ((r0 | r1) >= 0) {
            return r0 | (r1 << 8);
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f1164) {
            this.f1163.close();
            this.f1162.clear();
            this.f1164 = true;
        }
    }

    /* renamed from: ۘۙۗ  reason: not valid java name and contains not printable characters */
    public ArrayList<C0168> m2195() {
        return new ArrayList<>(this.f1162.values());
    }

    /* renamed from: ۨ۠ۥ  reason: not valid java name and contains not printable characters */
    public InputStream m2196(C0168 r9) {
        long r2 = r9.m2109();
        int r6 = r9.m2104();
        C0164 r7 = new C0164(this.f1163, r2, r9.m2114());
        if (r6 == 0) {
            return r7;
        }
        if (r6 == 8) {
            return new C0160(r7);
        }
        StringBuilder sb = new StringBuilder();
        short[] r22 = C0161.m2026(31);
        // fill-array-data instruction
        r22[0] = 105;
        r22[1] = 119;
        r22[2] = -86;
        r22[3] = 49;
        r22[4] = 68;
        r22[5] = 76;
        r22[6] = 118;
        r22[7] = -85;
        r22[8] = 48;
        r22[9] = 81;
        r22[10] = 88;
        r22[11] = 57;
        r22[12] = -70;
        r22[13] = 43;
        r22[14] = 89;
        r22[15] = 76;
        r22[16] = 107;
        r22[17] = -68;
        r22[18] = 55;
        r22[19] = 71;
        r22[20] = 85;
        r22[21] = 118;
        r22[22] = -73;
        r22[23] = 100;
        r22[24] = 89;
        r22[25] = 89;
        r22[26] = 109;
        r22[27] = -79;
        r22[28] = 43;
        r22[29] = 80;
        r22[30] = 28;
        sb.append(Hook.m1(r22));
        sb.append(r9.m2104());
        throw new IOException(sb.toString());
    }

    /* renamed from: ۫ۖ۠  reason: not valid java name and contains not printable characters */
    public byte[] m2197(C0168 r5) {
        int read;
        byte[] bArr = new byte[((int) r5.m2091())];
        InputStream r52 = m2196(r5);
        int i = 0;
        while (i < bArr.length && (read = r52.read(bArr, i, bArr.length - i)) != -1) {
            i += read;
        }
        if (i == bArr.length) {
            return bArr;
        }
        short[] r0 = C0161.m2026(46);
        // fill-array-data instruction
        r0[0] = -80;
        r0[1] = 14;
        r0[2] = -119;
        r0[3] = -60;
        r0[4] = 10;
        r0[5] = -119;
        r0[6] = -118;
        r0[7] = 1;
        r0[8] = -104;
        r0[9] = -116;
        r0[10] = 70;
        r0[11] = -125;
        r0[12] = -126;
        r0[13] = 70;
        r0[14] = -120;
        r0[15] = -123;
        r0[16] = 18;
        r0[17] = -115;
        r0[18] = -60;
        r0[19] = 14;
        r0[20] = -115;
        r0[21] = -105;
        r0[22] = 70;
        r0[23] = -114;
        r0[24] = -127;
        r0[25] = 3;
        r0[26] = -126;
        r0[27] = -60;
        r0[28] = 20;
        r0[29] = -119;
        r0[30] = -123;
        r0[31] = 2;
        r0[32] = -52;
        r0[33] = -115;
        r0[34] = 21;
        r0[35] = -52;
        r0[36] = -115;
        r0[37] = 8;
        r0[38] = -113;
        r0[39] = -117;
        r0[40] = 20;
        r0[41] = -98;
        r0[42] = -127;
        r0[43] = 5;
        r0[44] = -104;
        r0[45] = -54;
        throw new IOException(C0172.m2164(r0));
    }

    /* renamed from: ۫ۨ۠  reason: not valid java name and contains not printable characters */
    public InputStream m2198(C0168 r8) {
        return new C0164(this.f1163, r8.m2109(), r8.m2114());
    }
}
