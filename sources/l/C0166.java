package l;

import android.content.Context;
import java.io.DataInput;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Iterator;

/* renamed from: l.ۢ۠۬  reason: contains not printable characters */
public class C0166 {

    /* renamed from: ۠ۤۛ  reason: not valid java name and contains not printable characters */
    public static boolean f1088 = true;

    /* renamed from: ۖۛ۫  reason: not valid java name and contains not printable characters */
    public static Object m2065(Object obj) {
        return ((Iterator) obj).next();
    }

    /* renamed from: ۗۙۘ  reason: not valid java name and contains not printable characters */
    public static File[] m2066(Object obj) {
        return ((File) obj).listFiles();
    }

    /* renamed from: ۙۥ۫  reason: not valid java name and contains not printable characters */
    public static int m2067(Object obj) {
        return ((InputStream) obj).available();
    }

    /* renamed from: ۙۦۖ  reason: not valid java name and contains not printable characters */
    public static boolean m2068(Object obj, Object obj2) {
        return ((String) obj).endsWith((String) obj2);
    }

    /* renamed from: ۚۦۚ  reason: not valid java name and contains not printable characters */
    public static void m2069(Object obj, Object obj2) {
        ((PrintStream) obj).println((String) obj2);
    }

    /* renamed from: ۛ۫ۖ  reason: not valid java name and contains not printable characters */
    public static String m2070(Object obj) {
        short[] sArr = (short[]) obj;
        int length = sArr.length;
        char[] cArr = new char[length];
        do {
            length--;
            cArr[length] = (char) (sArr[length] ^ -98);
        } while (length != 0);
        return new String(cArr);
    }

    /* renamed from: ۜۗۜ  reason: not valid java name and contains not printable characters */
    public static String m2071(Object obj) {
        return obj.toString();
    }

    /* renamed from: ۠ۗۜ  reason: not valid java name and contains not printable characters */
    public static AbstractC0170 m2072(File file, String str) {
        return new C0176(new C0175(file, str));
    }

    /* renamed from: ۠ۤۛ  reason: not valid java name and contains not printable characters */
    public static boolean m2073() {
        return false;
    }

    /* renamed from: ۠ۧۥ  reason: not valid java name and contains not printable characters */
    public static StringBuilder m2074(Object obj, long j) {
        return ((StringBuilder) obj).append(j);
    }

    /* renamed from: ۠۬ۘ  reason: not valid java name and contains not printable characters */
    public static Object m2075(Object obj, Object obj2) {
        return ((Field) obj).get(obj2);
    }

    /* renamed from: ۤۘۙ  reason: not valid java name and contains not printable characters */
    public static Class m2076(Object obj, boolean z, Object obj2) {
        return Class.forName((String) obj, z, (ClassLoader) obj2);
    }

    /* renamed from: ۤۘ۬  reason: not valid java name and contains not printable characters */
    public static String m2077(Object obj) {
        return ((Context) obj).getPackageName();
    }

    /* renamed from: ۤ۠ۜ  reason: not valid java name and contains not printable characters */
    public static void m2078(Object obj, boolean z) {
        ((AccessibleObject) obj).setAccessible(z);
    }

    /* renamed from: ۥ۠ۗ  reason: contains not printable characters */
    public static String m2079(int i) {
        return Integer.toHexString(i);
    }

    /* renamed from: ۧۡۦ  reason: not valid java name and contains not printable characters */
    public static void m2080(Object obj, Object obj2) {
        ((DataInput) obj).readFully((byte[]) obj2);
    }

    /* renamed from: ۬ۡۧ  reason: not valid java name and contains not printable characters */
    public static boolean m2081(Object obj) {
        return ((File) obj).isDirectory();
    }
}
