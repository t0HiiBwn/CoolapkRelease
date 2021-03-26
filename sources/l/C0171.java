package l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import java.security.cert.Certificate;

/* renamed from: l.ۥۤۖ  reason: contains not printable characters */
public class C0171 {

    /* renamed from: ۨۘ۟  reason: not valid java name and contains not printable characters */
    public static int f1122;

    /* renamed from: ۖۖۢ  reason: not valid java name and contains not printable characters */
    public int f1123;

    /* renamed from: ۗ۫ۖ  reason: not valid java name and contains not printable characters */
    public byte[] f1124;

    /* renamed from: ۗ۬ۢ  reason: not valid java name and contains not printable characters */
    public int f1125;

    /* renamed from: ۘۖۦ  reason: not valid java name and contains not printable characters */
    public long f1126;

    /* renamed from: ۘۛۖ  reason: not valid java name and contains not printable characters */
    public int f1127 = 10;

    /* renamed from: ۛ۟ۚ  reason: not valid java name and contains not printable characters */
    public long f1128;

    /* renamed from: ۜۤۗ  reason: not valid java name and contains not printable characters */
    public int f1129;

    /* renamed from: ۟۫ۢ  reason: not valid java name and contains not printable characters */
    public int f1130;

    /* renamed from: ۠ۙ۟  reason: not valid java name and contains not printable characters */
    public byte[] f1131;

    /* renamed from: ۠ۚۙ  reason: not valid java name and contains not printable characters */
    public int f1132;

    /* renamed from: ۠ۡۜ  reason: not valid java name and contains not printable characters */
    public int f1133;

    /* renamed from: ۡۧۖ  reason: not valid java name and contains not printable characters */
    public byte[] f1134;

    /* renamed from: ۤ۬ۖ  reason: not valid java name and contains not printable characters */
    public boolean f1135;

    /* renamed from: ۥۙۤ  reason: contains not printable characters */
    public int f1136 = 10;

    /* renamed from: ۥۤۢ  reason: contains not printable characters */
    public int f1137;

    /* renamed from: ۦۥۦ  reason: contains not printable characters */
    public int f1138;

    /* renamed from: ۨۦۤ  reason: not valid java name and contains not printable characters */
    public boolean f1139;

    /* renamed from: ۨۨ۟  reason: not valid java name and contains not printable characters */
    public int f1140;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0061, code lost:
        if (r3.endsWith(l.C0161.m2029(r0)) != false) goto L_0x0063;
     */
    public C0171(String str, Charset charset) {
        this.f1124 = str.getBytes(charset);
        String name = charset.name();
        short[] r0 = C0161.m2026(5);
        // fill-array-data instruction
        r0[0] = -71;
        r0[1] = -80;
        r0[2] = 32;
        r0[3] = -63;
        r0[4] = -36;
        this.f1135 = name.equalsIgnoreCase(C0172.m2164(r0));
        boolean z = false;
        this.f1131 = new byte[0];
        this.f1134 = new byte[0];
        this.f1130 = (int) C0172.m2166(System.currentTimeMillis());
        short[] r02 = C0161.m2026(1);
        // fill-array-data instruction
        r02[0] = -33;
        if (!str.endsWith(C0161.m2029(r02))) {
            short[] r03 = C0161.m2026(1);
            // fill-array-data instruction
            r03[0] = -84;
        }
        z = true;
        this.f1139 = z;
    }

    public C0171(C0168 r3, Charset charset) {
        if (r3.m2108()) {
            this.f1127 = 20;
            this.f1136 = 20;
        }
        this.f1124 = r3.m2116().getBytes(charset);
        String name = charset.name();
        short[] r1 = C0161.m2026(5);
        // fill-array-data instruction
        r1[0] = 20;
        r1[1] = 21;
        r1[2] = 7;
        r1[3] = 108;
        r1[4] = 121;
        this.f1135 = name.equalsIgnoreCase(C0169.m2124(r1));
        this.f1130 = (int) C0172.m2166(r3.m2101());
        this.f1131 = r3.m2088() == null ? new byte[0] : r3.m2088();
        this.f1134 = r3.m2110() == null ? new byte[0] : r3.m2110().getBytes(charset);
        this.f1140 = r3.m2084();
        this.f1133 = r3.m2094();
        this.f1139 = r3.m2095();
    }

    /* renamed from: ۖۥۚ  reason: not valid java name and contains not printable characters */
    public static Class m2143(Object obj) {
        return obj.getClass();
    }

    /* renamed from: ۚۦۙ  reason: not valid java name and contains not printable characters */
    public static File m2144(Object obj) {
        return ((File) obj).getParentFile();
    }

    /* renamed from: ۛۚ۠  reason: not valid java name and contains not printable characters */
    public static void m2145(Object obj) {
        ((Closeable) obj).close();
    }

    /* renamed from: ۛ۫ۘ  reason: not valid java name and contains not printable characters */
    public static File m2146(Object obj) {
        return ((Context) obj).getFilesDir();
    }

    /* renamed from: ۜۙۢ  reason: not valid java name and contains not printable characters */
    public static int m2147(Object obj) {
        return ((Number) obj).intValue();
    }

    /* renamed from: ۜ۬ۘ  reason: not valid java name and contains not printable characters */
    public static String m2148(Object obj) {
        short[] sArr = (short[]) obj;
        int length = sArr.length;
        char[] cArr = new char[length];
        do {
            int i = length - 1;
            cArr[i] = (char) (sArr[i] ^ -115);
            if (i == 0) {
                break;
            }
            length = i - 1;
            cArr[length] = (char) (sArr[length] ^ -67);
        } while (length != 0);
        return new String(cArr);
    }

    /* renamed from: ۜ۬۟  reason: not valid java name and contains not printable characters */
    public static byte[] m2149(Object obj) {
        return ((Certificate) obj).getEncoded();
    }

    /* renamed from: ۥۡۚ  reason: contains not printable characters */
    public static ClassLoader m2150(Object obj) {
        return ((Class) obj).getClassLoader();
    }

    /* renamed from: ۥ۫۟  reason: contains not printable characters */
    public static ApplicationInfo m2151(Object obj) {
        return ((Context) obj).getApplicationInfo();
    }

    /* renamed from: ۨۘ۟  reason: not valid java name and contains not printable characters */
    public static boolean m2152() {
        return true;
    }

    /* renamed from: ۨ۟۬  reason: not valid java name and contains not printable characters */
    public static StringBuilder m2153(Object obj, Object obj2) {
        return ((StringBuilder) obj).append((String) obj2);
    }
}
