package l;

import cc.binmt.signature.Hook;
import java.nio.charset.Charset;
import java.util.zip.CRC32;

/* renamed from: l.ۤۛۜ  reason: contains not printable characters */
public class C0168 implements Cloneable {

    /* renamed from: ۖۤۢ  reason: not valid java name and contains not printable characters */
    private String f1104;

    /* renamed from: ۘۙۢ  reason: not valid java name and contains not printable characters */
    private int f1105 = 0;

    /* renamed from: ۘ۠۠  reason: not valid java name and contains not printable characters */
    private long f1106;

    /* renamed from: ۙۛۤ  reason: not valid java name and contains not printable characters */
    private long f1107;

    /* renamed from: ۙۡۖ  reason: not valid java name and contains not printable characters */
    private long f1108;

    /* renamed from: ۛۨۖ  reason: not valid java name and contains not printable characters */
    private long f1109;

    /* renamed from: ۛ۬۫  reason: not valid java name and contains not printable characters */
    private int f1110;

    /* renamed from: ۡۨۧ  reason: not valid java name and contains not printable characters */
    private int f1111;

    /* renamed from: ۤۦۘ  reason: not valid java name and contains not printable characters */
    private int f1112;

    /* renamed from: ۥ۠ۡ  reason: contains not printable characters */
    private String f1113;

    /* renamed from: ۦۗۘ  reason: contains not printable characters */
    private int f1114 = 0;

    /* renamed from: ۨ۬ۜ  reason: not valid java name and contains not printable characters */
    private byte[] f1115;

    /* renamed from: ۫ۙۗ  reason: not valid java name and contains not printable characters */
    private C0174 f1116;

    /* renamed from: ۫۠ۘ  reason: not valid java name and contains not printable characters */
    private byte[] f1117;

    /* renamed from: ۫ۧۦ  reason: not valid java name and contains not printable characters */
    private byte[] f1118;

    /* renamed from: ۬ۤۙ  reason: not valid java name and contains not printable characters */
    private int f1119 = 0;

    /* renamed from: ۬ۦۧ  reason: not valid java name and contains not printable characters */
    private long f1120;

    /* renamed from: ۟ۜۜ  reason: not valid java name and contains not printable characters */
    private String m2082(C0174 r7, byte[] bArr) {
        byte[] r1;
        int length;
        if (r7 == null || bArr == null || (length = (r1 = r7.m2174()).length) < 5 || r7.m2172(0) != 1) {
            return null;
        }
        int r72 = r7.m2175(1);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        if (r72 != ((int) crc32.getValue())) {
            return null;
        }
        return new String(r1, 5, length - 5, C0159.f1058);
    }

    /* renamed from: ۖۖ۟  reason: not valid java name and contains not printable characters */
    public void m2083(Charset charset, boolean z) {
        byte[] bArr = this.f1118;
        if (bArr == null || bArr.length == 0) {
            z = false;
        }
        String r1 = z ? m2082(C0174.m2171(28789, this.f1118), this.f1117) : null;
        if (r1 == null) {
            r1 = new String(this.f1117, charset);
        }
        m2096(r1);
        this.f1117 = null;
        if (this.f1115 != null) {
            String r5 = z ? m2082(C0174.m2171(25461, this.f1118), this.f1115) : null;
            if (r5 == null) {
                r5 = new String(this.f1115, charset);
            }
            m2087(r5);
            this.f1115 = null;
        }
    }

    /* renamed from: ۖۛۢ  reason: not valid java name and contains not printable characters */
    public int m2084() {
        return this.f1114;
    }

    /* renamed from: ۖ۟ۘ  reason: not valid java name and contains not printable characters */
    public void m2085(long j) {
        this.f1109 = j;
    }

    /* renamed from: ۖۤ۠  reason: not valid java name and contains not printable characters */
    public void m2086(byte[] bArr) {
        this.f1118 = bArr;
    }

    /* renamed from: ۗۘۖ  reason: not valid java name and contains not printable characters */
    public void m2087(String str) {
        this.f1104 = str;
    }

    /* renamed from: ۗۚۤ  reason: not valid java name and contains not printable characters */
    public byte[] m2088() {
        return this.f1118;
    }

    /* renamed from: ۘۡۥ  reason: not valid java name and contains not printable characters */
    public void m2089(int i) {
        this.f1111 = i;
    }

    /* renamed from: ۘۦۙ  reason: not valid java name and contains not printable characters */
    public void m2090(int i) {
        this.f1114 = i;
    }

    /* renamed from: ۙۖۥ  reason: not valid java name and contains not printable characters */
    public long m2091() {
        return this.f1107;
    }

    /* renamed from: ۙۘۚ  reason: not valid java name and contains not printable characters */
    public void m2092(int i) {
        this.f1112 = i;
    }

    /* renamed from: ۙۛۜ  reason: not valid java name and contains not printable characters */
    public void m2093(long j) {
        this.f1107 = j;
    }

    /* renamed from: ۙۡۡ  reason: not valid java name and contains not printable characters */
    public int m2094() {
        return this.f1119;
    }

    /* renamed from: ۚۖ۠  reason: not valid java name and contains not printable characters */
    public boolean m2095() {
        String r0 = m2116();
        short[] r1 = C0161.m2026(1);
        // fill-array-data instruction
        r1[0] = 19;
        return r0.endsWith(Hook.m1(r1));
    }

    /* renamed from: ۚۛۖ  reason: not valid java name and contains not printable characters */
    public void m2096(String str) {
        if (str == null) {
            throw new NullPointerException();
        } else if (!str.isEmpty()) {
            if (m2103() == 0) {
                short[] r0 = C0161.m2026(1);
                // fill-array-data instruction
                r0[0] = -33;
                if (!str.contains(C0161.m2029(r0))) {
                    str = str.replace('\\', '/');
                }
            }
            this.f1113 = str;
        } else {
            short[] r02 = C0161.m2026(21);
            // fill-array-data instruction
            r02[0] = 15;
            r02[1] = 32;
            r02[2] = 44;
            r02[3] = 36;
            r02[4] = 97;
            r02[5] = 34;
            r02[6] = 32;
            r02[7] = 47;
            r02[8] = 97;
            r02[9] = 47;
            r02[10] = 46;
            r02[11] = 53;
            r02[12] = 97;
            r02[13] = 35;
            r02[14] = 36;
            r02[15] = 97;
            r02[16] = 36;
            r02[17] = 44;
            r02[18] = 49;
            r02[19] = 53;
            r02[20] = 56;
            throw new IllegalArgumentException(C0169.m2124(r02));
        }
    }

    /* renamed from: ۚۨۗ  reason: not valid java name and contains not printable characters */
    public void m2097(byte[] bArr) {
        this.f1117 = bArr;
    }

    /* renamed from: ۚ۫ۘ  reason: not valid java name and contains not printable characters */
    public int m2098() {
        return this.f1112;
    }

    /* renamed from: ۜۥۤ  reason: not valid java name and contains not printable characters */
    public C0168 clone() {
        C0168 r1;
        CloneNotSupportedException e;
        try {
            r1 = (C0168) super.clone();
            try {
                if (this.f1116 != null) {
                    r1.f1116 = this.f1116.clone();
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return r1;
            }
        } catch (CloneNotSupportedException e3) {
            r1 = null;
            e = e3;
            e.printStackTrace();
            return r1;
        }
        return r1;
    }

    /* renamed from: ۜ۫۫  reason: not valid java name and contains not printable characters */
    public long m2100() {
        return this.f1109;
    }

    /* renamed from: ۟ۛۘ  reason: not valid java name and contains not printable characters */
    public long m2101() {
        return this.f1120;
    }

    /* renamed from: ۠۫ۡ  reason: not valid java name and contains not printable characters */
    public void m2102(int i) {
        this.f1110 = i;
    }

    /* renamed from: ۢۜۙ  reason: not valid java name and contains not printable characters */
    public int m2103() {
        return this.f1105;
    }

    /* renamed from: ۢ۟ۗ  reason: not valid java name and contains not printable characters */
    public int m2104() {
        return this.f1111;
    }

    /* renamed from: ۤۙۥ  reason: not valid java name and contains not printable characters */
    public void m2105(int i) {
        this.f1105 = i;
    }

    /* renamed from: ۤۛۘ  reason: not valid java name and contains not printable characters */
    public void m2106(int i) {
        this.f1119 = i;
    }

    /* renamed from: ۤۜۙ  reason: not valid java name and contains not printable characters */
    public void m2107(byte[] bArr) {
        this.f1115 = bArr;
    }

    /* renamed from: ۤ۫ۛ  reason: not valid java name and contains not printable characters */
    public boolean m2108() {
        return (this.f1112 & 1) != 0;
    }

    /* renamed from: ۥۘۜ  reason: contains not printable characters */
    public long m2109() {
        return this.f1108;
    }

    /* renamed from: ۥ۠ۡ  reason: contains not printable characters */
    public String m2110() {
        return this.f1104;
    }

    /* renamed from: ۥۢۜ  reason: contains not printable characters */
    public void m2111(long j) {
        this.f1108 = j;
    }

    /* renamed from: ۥۨ۬  reason: contains not printable characters */
    public boolean m2112() {
        return (m2098() & 2048) != 0;
    }

    /* renamed from: ۧۛۚ  reason: not valid java name and contains not printable characters */
    public int m2113() {
        return this.f1110;
    }

    /* renamed from: ۧۛۧ  reason: not valid java name and contains not printable characters */
    public long m2114() {
        return this.f1106;
    }

    /* renamed from: ۨ۫ۗ  reason: not valid java name and contains not printable characters */
    public void m2115(long j) {
        this.f1106 = j;
    }

    /* renamed from: ۫ۖۨ  reason: not valid java name and contains not printable characters */
    public String m2116() {
        return this.f1113;
    }

    /* renamed from: ۬ۙۗ  reason: not valid java name and contains not printable characters */
    public void m2117(long j) {
        this.f1120 = j;
    }
}
