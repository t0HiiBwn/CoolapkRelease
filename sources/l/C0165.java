package l;

import cc.binmt.signature.Hook;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: l.۠ۙ۠  reason: contains not printable characters */
public class C0165 implements Closeable {

    /* renamed from: ۘ۠ۥ  reason: not valid java name and contains not printable characters */
    public static final int f1074 = 0;

    /* renamed from: ۛۖۨ  reason: not valid java name and contains not printable characters */
    public static final int f1075 = 8;

    /* renamed from: ۧۘۧ  reason: not valid java name and contains not printable characters */
    public static final int f1076 = -1;

    /* renamed from: ۗۡۢ  reason: not valid java name and contains not printable characters */
    private Charset f1077 = C0159.f1058;

    /* renamed from: ۙۖۛ  reason: not valid java name and contains not printable characters */
    private boolean f1078;

    /* renamed from: ۠ۖۚ  reason: not valid java name and contains not printable characters */
    private final ArrayList<C0171> f1079 = new ArrayList<>();

    /* renamed from: ۢۖ۫  reason: not valid java name and contains not printable characters */
    private final byte[] f1080 = new byte[4096];

    /* renamed from: ۤۚۥ  reason: not valid java name and contains not printable characters */
    private int f1081 = 8;

    /* renamed from: ۥ۫ۢ  reason: contains not printable characters */
    private C0178 f1082;

    /* renamed from: ۦۢۗ  reason: contains not printable characters */
    private final AbstractC0170 f1083;

    /* renamed from: ۧۜۚ  reason: not valid java name and contains not printable characters */
    private C0171 f1084;

    /* renamed from: ۧ۟۠  reason: not valid java name and contains not printable characters */
    private int f1085 = -1;

    /* renamed from: ۧ۟ۡ  reason: not valid java name and contains not printable characters */
    private String f1086;

    /* renamed from: ۧ۟ۤ  reason: not valid java name and contains not printable characters */
    private C0177 f1087;

    public C0165(File file) {
        if (file.exists()) {
            file.delete();
        }
        short[] r0 = C0161.m2026(2);
        // fill-array-data instruction
        r0[0] = 76;
        r0[1] = -121;
        this.f1083 = C0166.m2072(file, C0161.m2029(r0));
        this.f1078 = true;
    }

    /* renamed from: ۖۡ۫  reason: not valid java name and contains not printable characters */
    private void m2035(long j, long j2) {
        String str = this.f1086;
        byte[] bytes = str == null ? new byte[0] : str.getBytes(this.f1077);
        m2047(101010256);
        m2046(0);
        m2046(0);
        m2046(this.f1079.size());
        m2046(this.f1079.size());
        m2047((int) j);
        m2047((int) j2);
        m2046(bytes.length);
        m2042(bytes);
    }

    /* renamed from: ۗۨۘ  reason: not valid java name and contains not printable characters */
    private static boolean m2036(long j, int i) {
        return j % ((long) i) == 0;
    }

    /* renamed from: ۙ۟ۚ  reason: not valid java name and contains not printable characters */
    private long m2037() {
        return this.f1083.mo2138();
    }

    /* renamed from: ۛ۬ۘ  reason: not valid java name and contains not printable characters */
    private void m2038(C0171 r6) {
        OutputStream outputStream;
        if (this.f1084 != null) {
            m2055();
        }
        r6.f1126 = m2037();
        this.f1079.add(r6);
        int i = 2048;
        if (!r6.f1139) {
            this.f1084 = r6;
            int i2 = this.f1081;
            this.f1082 = new C0178(this.f1083);
            C0178 r3 = this.f1082;
            if (!r6.f1135) {
                i = 0;
            }
            int i3 = this.f1081;
            if (i3 == 0) {
                outputStream = r3;
            } else if (i3 == 8) {
                outputStream = new C0173(r3, this.f1085);
            } else {
                StringBuilder sb = new StringBuilder();
                short[] r2 = C0161.m2026(31);
                // fill-array-data instruction
                r2[0] = 105;
                r2[1] = 119;
                r2[2] = -86;
                r2[3] = 49;
                r2[4] = 68;
                r2[5] = 76;
                r2[6] = 118;
                r2[7] = -85;
                r2[8] = 48;
                r2[9] = 81;
                r2[10] = 88;
                r2[11] = 57;
                r2[12] = -70;
                r2[13] = 43;
                r2[14] = 89;
                r2[15] = 76;
                r2[16] = 107;
                r2[17] = -68;
                r2[18] = 55;
                r2[19] = 71;
                r2[20] = 85;
                r2[21] = 118;
                r2[22] = -73;
                r2[23] = 100;
                r2[24] = 89;
                r2[25] = 89;
                r2[26] = 109;
                r2[27] = -79;
                r2[28] = 43;
                r2[29] = 80;
                r2[30] = 28;
                sb.append(Hook.m1(r2));
                sb.append(i2);
                throw new IOException(sb.toString());
            }
            this.f1087 = new C0177(outputStream);
            r6.f1132 = i;
            r6.f1138 = i2;
        } else {
            r6.f1138 = 0;
            if (r6.f1135) {
                r6.f1132 = 2048;
            }
        }
        m2045(r6);
        r6.f1128 = m2037();
    }

    /* renamed from: ۠۬ۘ  reason: not valid java name and contains not printable characters */
    private static boolean m2039(byte[] bArr) {
        for (byte b : bArr) {
            if (b != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ۢ۟ۥ  reason: not valid java name and contains not printable characters */
    private void m2040(C0171 r3) {
        m2047(33639248);
        m2046(r3.f1127);
        m2046(r3.f1136);
        m2046(r3.f1132);
        m2046(r3.f1138);
        m2047(r3.f1130);
        m2047(r3.f1123);
        m2047(r3.f1125);
        m2047(r3.f1137);
        m2046(r3.f1124.length);
        m2046(r3.f1131.length);
        m2046(r3.f1134.length);
        m2046(r3.f1129);
        m2046(r3.f1140);
        m2047(r3.f1133);
        m2047((int) r3.f1126);
        m2042(r3.f1124);
        m2042(r3.f1131);
        m2042(r3.f1134);
    }

    /* renamed from: ۤۗ۬  reason: not valid java name and contains not printable characters */
    private static int m2041(long j, int i) {
        long j2 = (long) i;
        return ((int) (j2 - (j % j2))) % i;
    }

    /* renamed from: ۤۨۘ  reason: not valid java name and contains not printable characters */
    private void m2042(byte[] bArr) {
        if (bArr.length > 0) {
            this.f1083.mo2135(bArr);
        }
    }

    /* renamed from: ۥۨۛ  reason: contains not printable characters */
    private void m2043(long j) {
        this.f1083.mo2142(j);
    }

    /* renamed from: ۧۗۜ  reason: not valid java name and contains not printable characters */
    private void m2044(C0171 r4, long j) {
        String str = new String(r4.f1124, C0159.f1058);
        short[] r1 = C0161.m2026(3);
        // fill-array-data instruction
        r1[0] = 106;
        r1[1] = 71;
        r1[2] = 83;
        int i = str.endsWith(Hook.m1(r1)) ? 4096 : 4;
        if (!m2036(((long) r4.f1131.length) + j, i)) {
            if (m2039(r4.f1131)) {
                r4.f1131 = new byte[m2041(j, i)];
            } else {
                r4.f1131 = Arrays.copyOf(r4.f1131, r4.f1131.length + m2041(j + ((long) r4.f1131.length), i));
            }
        }
    }

    /* renamed from: ۨۨۢ  reason: not valid java name and contains not printable characters */
    private void m2045(C0171 r5) {
        m2047(67324752);
        m2046(r5.f1136);
        m2046(r5.f1132);
        m2046(r5.f1138);
        m2047(r5.f1130);
        m2047(r5.f1123);
        m2047(r5.f1125);
        m2047(r5.f1137);
        m2046(r5.f1124.length);
        if (this.f1078 && r5.f1138 == 0) {
            m2044(r5, m2037() + 2 + ((long) r5.f1124.length));
        }
        m2046(r5.f1131.length);
        m2042(r5.f1124);
        m2042(r5.f1131);
    }

    /* renamed from: ۬۠۬  reason: not valid java name and contains not printable characters */
    private void m2046(int i) {
        this.f1083.mo2136(i & 255);
        this.f1083.mo2136((i >>> 8) & 255);
    }

    /* renamed from: ۬ۧۘ  reason: not valid java name and contains not printable characters */
    private void m2047(int i) {
        this.f1083.mo2136(i & 255);
        this.f1083.mo2136((i >>> 8) & 255);
        this.f1083.mo2136((i >>> 16) & 255);
        this.f1083.mo2136((i >>> 24) & 255);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f1083.mo2137()) {
            if (this.f1084 != null) {
                m2055();
            }
            long r0 = m2037();
            Iterator<C0171> it2 = this.f1079.iterator();
            while (it2.hasNext()) {
                m2040(it2.next());
            }
            m2035(m2037() - r0, r0);
            this.f1083.close();
        }
    }

    /* renamed from: ۖۢۤ  reason: not valid java name and contains not printable characters */
    public void m2048(byte[] bArr) {
        this.f1087.write(bArr);
    }

    /* renamed from: ۗ۬ۡ  reason: not valid java name and contains not printable characters */
    public void m2049(byte[] bArr, int i, int i2) {
        this.f1087.write(bArr, i, i2);
    }

    /* renamed from: ۙۗۥ  reason: not valid java name and contains not printable characters */
    public int m2050() {
        return this.f1081;
    }

    /* renamed from: ۙ۠ۧ  reason: not valid java name and contains not printable characters */
    public String m2051() {
        return this.f1086;
    }

    /* renamed from: ۚۗۢ  reason: not valid java name and contains not printable characters */
    public void m2052(int i) {
        this.f1081 = i;
    }

    /* renamed from: ۜۡۧ  reason: not valid java name and contains not printable characters */
    public int m2053() {
        return this.f1085;
    }

    /* renamed from: ۠ۖۛ  reason: not valid java name and contains not printable characters */
    public void m2054(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                m2049(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: ۠ۡۘ  reason: not valid java name and contains not printable characters */
    public void m2055() {
        if (this.f1084 != null) {
            this.f1087.close();
            this.f1084.f1123 = this.f1087.m2183();
            this.f1084.f1125 = this.f1082.m2185();
            this.f1084.f1137 = this.f1087.m2184();
            long r0 = m2037();
            m2043(this.f1084.f1126 + 4 + 2 + 2 + 2 + 4);
            m2047(this.f1084.f1123);
            m2047(this.f1084.f1125);
            m2047(this.f1084.f1137);
            this.f1083.mo2142(r0);
            this.f1087 = null;
            this.f1082 = null;
            this.f1084 = null;
        }
    }

    /* renamed from: ۡۘۧ  reason: not valid java name and contains not printable characters */
    public void m2056(C0168 r4) {
        if (this.f1084 != null) {
            m2055();
        }
        C0171 r0 = new C0171(r4, this.f1077);
        if (r4.m2108()) {
            r0.f1132 |= 1;
        }
        if (r0.f1135) {
            r0.f1132 |= 2048;
        }
        r0.f1138 = r4.m2104();
        r0.f1123 = r4.m2113();
        r0.f1125 = (int) r4.m2114();
        r0.f1137 = (int) r4.m2091();
        r0.f1126 = m2037();
        this.f1079.add(r0);
        m2045(r0);
    }

    /* renamed from: ۡۥ۫  reason: not valid java name and contains not printable characters */
    public void m2057(int i) {
        this.f1085 = i;
    }

    /* renamed from: ۤۗ۬  reason: not valid java name and contains not printable characters */
    public void m2058(byte[] bArr, int i, int i2) {
        this.f1083.mo2139(bArr, i, i2);
    }

    /* renamed from: ۤۢۙ  reason: not valid java name and contains not printable characters */
    public void m2059(String str) {
        this.f1086 = str;
    }

    /* renamed from: ۥۗۙ  reason: contains not printable characters */
    public void m2060(Charset charset) {
        this.f1077 = charset;
    }

    /* renamed from: ۦۡ۫  reason: contains not printable characters */
    public void m2061(C0168 r3, C0179 r4) {
        m2056(r3);
        InputStream r32 = r4.m2198(r3);
        byte[] bArr = this.f1080;
        while (true) {
            int read = r32.read(bArr);
            if (read != -1) {
                m2058(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: ۦۢۗ  reason: contains not printable characters */
    public void m2062(String str) {
        this.f1077 = Charset.forName(str);
    }

    /* renamed from: ۦۥۚ  reason: contains not printable characters */
    public void m2063(String str) {
        m2038(new C0171(str, this.f1077));
    }

    /* renamed from: ۧۜ۫  reason: not valid java name and contains not printable characters */
    public void m2064(int i) {
        this.f1087.write(i);
    }
}
