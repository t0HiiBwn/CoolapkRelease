package l;

import android.content.Context;
import cc.binmt.signature.Hook;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Calendar;
import java.util.Iterator;

/* renamed from: l.ۦۛ۟  reason: contains not printable characters */
public class C0172 {

    /* renamed from: ۗۢۤ  reason: not valid java name and contains not printable characters */
    public static boolean f1141 = true;

    /* renamed from: ۖۙۡ  reason: not valid java name and contains not printable characters */
    public static byte[] m2154() {
        return Hook.getData();
    }

    /* renamed from: ۗۢۡ  reason: not valid java name and contains not printable characters */
    public static boolean m2155(Object obj, Object obj2) {
        return ((String) obj).matches((String) obj2);
    }

    /* renamed from: ۗۢۤ  reason: not valid java name and contains not printable characters */
    public static boolean m2156() {
        return false;
    }

    /* renamed from: ۘۤۗ  reason: not valid java name and contains not printable characters */
    public static String m2157(Object obj) {
        return ((Context) obj).getPackageResourcePath();
    }

    /* renamed from: ۙۗۜ  reason: not valid java name and contains not printable characters */
    public static Certificate m2158(Object obj, Object obj2) {
        return ((CertificateFactory) obj).generateCertificate((InputStream) obj2);
    }

    /* renamed from: ۚۗۙ  reason: not valid java name and contains not printable characters */
    public static void m2159(Object obj) {
        ((Throwable) obj).printStackTrace();
    }

    /* renamed from: ۚۘۨ  reason: not valid java name and contains not printable characters */
    public static boolean m2160(Object obj) {
        return ((File) obj).delete();
    }

    /* renamed from: ۚ۠ۥ  reason: not valid java name and contains not printable characters */
    public static boolean m2161(Object obj) {
        return ((Iterator) obj).hasNext();
    }

    /* renamed from: ۛۤۦ  reason: not valid java name and contains not printable characters */
    public static void m2162(Object obj) {
        System.loadLibrary((String) obj);
    }

    /* renamed from: ۡ۫ۘ  reason: not valid java name and contains not printable characters */
    public static int m2163(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    /* renamed from: ۤۖۘ  reason: not valid java name and contains not printable characters */
    public static String m2164(Object obj) {
        short[] sArr = (short[]) obj;
        int length = sArr.length;
        char[] cArr = new char[length];
        do {
            int i = length - 1;
            cArr[i] = (char) (sArr[i] ^ -28);
            if (i == 0) {
                break;
            }
            int i2 = i - 1;
            cArr[i2] = (char) (sArr[i2] ^ -20);
            if (i2 == 0) {
                break;
            }
            length = i2 - 1;
            cArr[length] = (char) (sArr[length] ^ 102);
        } while (length != 0);
        return new String(cArr);
    }

    /* renamed from: ۥ۟ۡ  reason: contains not printable characters */
    public static File m2165(Object obj) {
        return ((Context) obj).getCacheDir();
    }

    /* renamed from: ۥۥۖ  reason: contains not printable characters */
    public static long m2166(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        if (i < 1980) {
            return 2162688;
        }
        return (long) ((instance.get(13) >> 1) | ((i - 1980) << 25) | ((instance.get(2) + 1) << 21) | (instance.get(5) << 16) | (instance.get(11) << 11) | (instance.get(12) << 5));
    }

    /* renamed from: ۧۛ۫  reason: not valid java name and contains not printable characters */
    public static int m2167(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: ۨ۟ۙ  reason: not valid java name and contains not printable characters */
    public static int m2168(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    /* renamed from: ۬ۦۤ  reason: not valid java name and contains not printable characters */
    public static void m2169(Object obj, Object obj2) {
        Hook.hookOpen((String) obj, (String) obj2);
    }

    /* renamed from: ۬۫ۗ  reason: not valid java name and contains not printable characters */
    public static long m2170(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, ((int) ((j >> 25) & 127)) + 1980);
        instance.set(2, ((int) ((j >> 21) & 15)) - 1);
        instance.set(5, ((int) (j >> 16)) & 31);
        instance.set(11, ((int) (j >> 11)) & 31);
        instance.set(12, ((int) (j >> 5)) & 63);
        instance.set(13, ((int) (j << 1)) & 62);
        return instance.getTime().getTime();
    }
}
