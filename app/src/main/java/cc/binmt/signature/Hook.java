package cc.binmt.signature;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.DataInput;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import l.C0161;
import l.C0163;
import l.C0166;
import l.C0169;
import l.C0171;
import l.C0172;

public class Hook {

    /* renamed from: ۚۜۜ  reason: not valid java name and contains not printable characters */
    public static boolean f0 = true;

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0473, code lost:
        r1 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0479, code lost:
        if (l.C0172.f1141 == false) goto L_0x047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x047b, code lost:
        r1 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0033, code lost:
        r1 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0106, code lost:
        r11 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010c, code lost:
        if (l.C0171.f1122 == 0) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0110, code lost:
        if (l.C0166.f1088 == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0114, code lost:
        if (l.C0172.f1141 != false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0116, code lost:
        r0 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0039, code lost:
        if (l.C0161.f1060 == 0) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015a, code lost:
        if (l.C0172.f1141 == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003b, code lost:
        r0 = l.C0172.m2156();
        r0 = l.C0166.m2073();
     */
    /* JADX WARNING: Removed duplicated region for block: B:213:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0123  */
    public static void bind(Context context) {
        C0161 r0 = new C0161();
        if (r0.f1066 != null) {
            File file = null;
            String str = null;
            int i = 0;
            int i2 = 0;
            String str2 = null;
            long j = 0;
            short[] r8 = C0161.m2026(3);
            // fill-array-data instruction
            r8[0] = 29728;
            r8[1] = -31564;
            r8[2] = -30991;
            if (C0166.f1088 || C0171.m2152()) {
                int r82 = m6(C0169.m2124(r8)) ^ 2127072163;
                while (true) {
                    switch ((r82 ^ -1) ^ 20319) {
                        case -2132365300:
                            i = m6(str);
                            ApplicationInfo r4 = C0171.m2151(context);
                            short[] r83 = C0161.m2026(3);
                            // fill-array-data instruction
                            r83[0] = 26421;
                            r83[1] = -32201;
                            r83[2] = -27561;
                            String r84 = C0172.m2164(r83);
                            if (m0() <= 0) {
                                m0();
                                if (m0() < 0) {
                                    break;
                                }
                            }
                            r82 = m6(r84) ^ 2123926923;
                            i2 = r4.uid;
                            break;
                        case -2131969881:
                            if (!f0 && C0171.f1122 == 0) {
                                break;
                            } else {
                                file = new File(C0172.m2157(context));
                                short[] r85 = C0161.m2026(3);
                                // fill-array-data instruction
                                r85[0] = 29118;
                                r85[1] = 27349;
                                r85[2] = -22226;
                                if (!C0172.f1141 && C0166.f1088) {
                                    break;
                                } else {
                                    r82 = m6(C0166.m2070(r85)) ^ 2101276745;
                                    str = C0166.m2077(context);
                                    break;
                                }
                            }
                            break;
                        case -2131575937:
                            short[] r86 = C0161.m2026(6);
                            // fill-array-data instruction
                            r86[0] = 83;
                            r86[1] = -124;
                            r86[2] = -2;
                            r86[3] = -122;
                            r86[4] = 81;
                            r86[5] = -101;
                            String r87 = C0161.m2029(r86);
                            if (C0171.f1122 != 0) {
                            }
                            if (!C0171.m2152() && C0169.f1121 == 0) {
                                break;
                            } else {
                                short[] r9 = C0161.m2026(3);
                                // fill-array-data instruction
                                r9[0] = -27807;
                                r9[1] = -25253;
                                r9[2] = -21231;
                                if (!C0171.m2152() && C0161.f1060 == 0) {
                                    break;
                                } else {
                                    int r92 = m6(C0171.m2148(r9)) ^ 2125866597;
                                    if (C0172.m2156()) {
                                        m0();
                                        if (!C0172.m2156()) {
                                            break;
                                        }
                                    }
                                    C0172.m2162(r87);
                                    short[] r88 = C0161.m2026(3);
                                    // fill-array-data instruction
                                    r88[0] = -29748;
                                    r88[1] = -27957;
                                    r88[2] = 23525;
                                    r82 = m6(C0169.m2124(r88)) ^ 2098134688;
                                    break;
                                }
                            }
                            break;
                        case -2131445024:
                            str2 = C0166.m2079(i + i2);
                            if (C0161.m2027() && C0166.m2073()) {
                                break;
                            } else {
                                if (C0166.m2073()) {
                                    C0172.m2156();
                                    if (!C0161.m2027() || !C0161.m2027()) {
                                        if (C0161.f1060 < 0) {
                                            if (!C0172.m2156()) {
                                                C0161.m2027();
                                                m0();
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                short[] r89 = C0161.m2026(3);
                                // fill-array-data instruction
                                r89[0] = -24506;
                                r89[1] = -27998;
                                r89[2] = -24067;
                                if (C0169.m2121() < 0) {
                                    if (C0171.f1122 != 0) {
                                        C0161.m2027();
                                        if (C0172.m2156()) {
                                            break;
                                        }
                                    }
                                    if (C0171.f1122 > 0) {
                                        break;
                                    }
                                }
                                String r810 = C0171.m2148(r89);
                                if (!f0 && C0161.f1060 == 0) {
                                    break;
                                } else {
                                    r82 = m6(r810) ^ 2120625005;
                                    j = m9(file);
                                    break;
                                }
                            }
                            break;
                        default:
                            try {
                                j += C0169.m2122(C0169.m2127(context), C0166.m2077(context), 1).lastUpdateTime;
                            } catch (PackageManager.NameNotFoundException e) {
                                C0172.m2159(e);
                            }
                            StringBuilder sb = null;
                            String str3 = null;
                            File file2 = null;
                            short[] r811 = C0161.m2026(3);
                            // fill-array-data instruction
                            r811[0] = 20137;
                            r811[1] = 20618;
                            r811[2] = 22839;
                            int r812 = m6(C0169.m2124(r811)) ^ 2117948421;
                            while (true) {
                                switch ((r812 ^ -1) ^ 25817) {
                                    case -2132044954:
                                        String r813 = C0169.m2125(file);
                                        String r93 = C0169.m2125(file2);
                                        if (C0171.f1122 != 0 && m0() == 0) {
                                            break;
                                        } else {
                                            if (!f0) {
                                                C0166.m2073();
                                            }
                                            C0172.m2169(r813, r93);
                                            byte[] bArr = r0.f1064;
                                            short[] r94 = C0161.m2026(3);
                                            // fill-array-data instruction
                                            r94[0] = 26322;
                                            r94[1] = 25916;
                                            r94[2] = 26196;
                                            String r95 = C0172.m2164(r94);
                                            if (!C0166.f1088) {
                                                C0172.m2156();
                                                if (C0171.f1122 != 0) {
                                                    break;
                                                }
                                            }
                                            int r96 = m6(r95) ^ 2122637531;
                                            C0163.m2034(context, bArr);
                                            short[] r814 = C0161.m2026(3);
                                            // fill-array-data instruction
                                            r814[0] = -29358;
                                            r814[1] = 28410;
                                            r814[2] = 30836;
                                            String r815 = m1(r814);
                                            if (!C0171.m2152() && m0() == 0) {
                                                break;
                                            } else {
                                                r812 = m6(r815) ^ 2098167967;
                                                break;
                                            }
                                        }
                                        break;
                                    case -2131781271:
                                        File r97 = C0172.m2165(context);
                                        short[] r10 = C0161.m2026(4);
                                        // fill-array-data instruction
                                        r10[0] = -116;
                                        r10[1] = 9;
                                        r10[2] = -125;
                                        r10[3] = -113;
                                        File file3 = new File(r97, C0172.m2164(r10));
                                        short[] r98 = C0161.m2026(3);
                                        // fill-array-data instruction
                                        r98[0] = -29562;
                                        r98[1] = -27166;
                                        r98[2] = -26180;
                                        int r99 = m6(C0169.m2124(r98)) ^ 2101292909;
                                        C0169.m2120(file3);
                                        short[] r816 = C0161.m2026(3);
                                        // fill-array-data instruction
                                        r816[0] = -32057;
                                        r816[1] = 32137;
                                        r816[2] = 31242;
                                        if (m0() < 0 && C0169.f1121 == 0) {
                                            break;
                                        } else {
                                            String r817 = C0166.m2070(r816);
                                            if (!C0171.m2152() && C0172.m2156()) {
                                                break;
                                            } else {
                                                r812 = m6(r817) ^ 2130366938;
                                                break;
                                            }
                                        }
                                    case -2131715632:
                                        sb = new StringBuilder();
                                        short[] r102 = C0161.m2026(3);
                                        // fill-array-data instruction
                                        r102[0] = 30759;
                                        r102[1] = -28161;
                                        r102[2] = -25224;
                                        int r103 = m6(m1(r102)) ^ 2127707515;
                                        C0166.m2074(sb, j / 1000);
                                        short[] r818 = C0161.m2026(3);
                                        // fill-array-data instruction
                                        r818[0] = 26370;
                                        r818[1] = 25402;
                                        r818[2] = -20120;
                                        if (!C0166.f1088) {
                                            m0();
                                        }
                                        r812 = m6(C0166.m2070(r818)) ^ 2102666601;
                                        break;
                                    case -2130995679:
                                        short[] r3 = C0161.m2026(4);
                                        // fill-array-data instruction
                                        r3[0] = 111;
                                        r3[1] = 32;
                                        r3[2] = 49;
                                        r3[3] = 42;
                                        C0171.m2153(sb, C0169.m2124(r3));
                                        if (C0169.m2121() <= 0 && !f0) {
                                            break;
                                        } else {
                                            short[] r819 = C0161.m2026(3);
                                            // fill-array-data instruction
                                            r819[0] = -31922;
                                            r819[1] = -24826;
                                            r819[2] = -31497;
                                            String r820 = m1(r819);
                                            if (!C0171.m2152()) {
                                                if (C0161.f1060 != 0 && C0169.m2121() <= 0) {
                                                    break;
                                                } else {
                                                    if (C0161.m2027()) {
                                                        C0172.m2156();
                                                        if (C0169.f1121 == 0) {
                                                            break;
                                                        }
                                                    }
                                                    C0166.m2073();
                                                    if (C0169.f1121 > 0) {
                                                        break;
                                                    }
                                                }
                                            }
                                            r812 = m6(r820) ^ 2130555819;
                                            str3 = C0166.m2071(sb);
                                            break;
                                        }
                                        break;
                                    case -2130862866:
                                        File r821 = C0171.m2146(context);
                                        StringBuilder sb2 = new StringBuilder();
                                        C0171.m2153(sb2, str2);
                                        short[] r104 = C0161.m2026(1);
                                        // fill-array-data instruction
                                        r104[0] = 19;
                                        C0171.m2153(sb2, m1(r104));
                                        C0171.m2153(sb2, str3);
                                        file2 = new File(r821, C0166.m2071(sb2));
                                        short[] r822 = C0161.m2026(3);
                                        // fill-array-data instruction
                                        r822[0] = -21000;
                                        r822[1] = 29901;
                                        r822[2] = 28386;
                                        r812 = m6(C0166.m2070(r822)) ^ 2119354671;
                                        C0169.m2128(file, file2, r0);
                                        break;
                                    default:
                                        return;
                                }
                            }
                            C0166.m2073();
                            if (!f0) {
                                C0169.m2121();
                            }
                            if (C0169.m2121() >= 0) {
                                C0169.m2121();
                                break;
                            }
                            break;
                    }
                }
                C0161.m2027();
                if (C0161.f1060 >= 0) {
                    C0172.m2156();
                    C0166.m2073();
                } else {
                    C0169.m2121();
                    if (!C0171.m2152()) {
                        C0172.m2156();
                        C0166.m2073();
                        C0161.m2027();
                        C0172.m2156();
                        return;
                    }
                }
                C0169.m2121();
                if (!C0166.m2073()) {
                    C0166.m2073();
                }
                C0166.m2073();
                C0161.m2027();
                C0172.m2156();
                return;
            }
            C0172.m2156();
            if (!C0171.m2152()) {
                m0();
            }
            if (C0171.f1122 != 0) {
                C0169.m2121();
            }
            C0172.m2156();
            if (C0172.f1141) {
                C0166.m2073();
                C0169.m2121();
                if (C0161.f1060 == 0) {
                    m0();
                    if (C0172.f1141) {
                        return;
                    }
                    if (C0171.m2152()) {
                        C0171.m2152();
                    }
                    C0161.m2027();
                    if (C0166.f1088) {
                        C0171.m2152();
                        C0166.m2073();
                        C0169.m2121();
                        return;
                    }
                    C0172.m2156();
                    if (C0161.f1060 == 0) {
                        C0171.m2152();
                        C0161.m2027();
                    } else {
                        m0();
                        C0161.m2027();
                    }
                    C0169.m2121();
                    return;
                }
                return;
            }
            C0169.m2121();
            m0();
            C0166.m2073();
            C0169.m2121();
            if (C0161.f1060 == 0) {
            }
        } else {
            C0163.m2034(context, r0.f1064);
        }
    }

    public static byte[] getData() {
    }

    public static native void hookOpen(String str, String str2);

    /* renamed from: ۚۜۜ  reason: not valid java name and contains not printable characters */
    public static int m0() {
        return 30060;
    }

    /* renamed from: ۤۧ۫  reason: not valid java name and contains not printable characters */
    public static void m2(Object obj, Object obj2, Object obj3) {
        ((Field) obj).set(obj2, obj3);
    }

    /* renamed from: ۥۚۧ  reason: contains not printable characters */
    public static boolean m3(Object obj) {
        return ((File) obj).exists();
    }

    /* renamed from: ۦۙ۠  reason: contains not printable characters */
    public static CertificateFactory m4(Object obj) {
        return CertificateFactory.getInstance((String) obj);
    }

    /* renamed from: ۨۛۥ  reason: not valid java name and contains not printable characters */
    public static int m6(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۨۢۤ  reason: not valid java name and contains not printable characters */
    public static int m7(Object obj) {
        return ((DataInput) obj).readInt();
    }

    /* renamed from: ۫ۛ۬  reason: not valid java name and contains not printable characters */
    public static ClassLoader m8() {
        return ClassLoader.getSystemClassLoader();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        if (l.C0171.m2152() != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013a, code lost:
        if (l.C0161.m2027() == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (l.C0171.f1122 != 0) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7  */
    /* renamed from: ۦۨ۠  reason: contains not printable characters */
    public static Method m5(Object obj, Object obj2, Object obj3) {
        Method declaredMethod = ((Class) obj).getDeclaredMethod((String) obj2, (Class[]) obj3);
        if (C0171.f1122 != 0) {
            if (!C0166.f1088) {
            }
            C0166.m2073();
            if (C0169.m2121() < 0) {
            }
        }
        if (C0161.m2027()) {
            C0161.m2027();
            if (!C0166.m2073() || C0161.m2027()) {
                int i = C0169.f1121;
                if (C0172.f1141 || C0171.f1122 <= 0) {
                    if (i != 0) {
                        C0166.m2073();
                        if (C0171.f1122 == 0 || !C0172.m2156()) {
                            if (!C0171.m2152()) {
                                C0161.m2027();
                                if (!C0172.f1141) {
                                    C0172.m2156();
                                    if (C0169.m2121() <= 0) {
                                        C0166.m2073();
                                        if (C0169.m2121() < 0) {
                                            C0169.m2121();
                                            if (C0161.f1060 == 0) {
                                                C0166.m2073();
                                                if (C0171.m2152()) {
                                                    C0161.m2027();
                                                }
                                            }
                                        }
                                        C0171.m2152();
                                        C0169.m2121();
                                        if (C0169.f1121 != 0) {
                                            C0171.m2152();
                                        }
                                        C0171.m2152();
                                        m0();
                                        if (f0 || !C0166.m2073()) {
                                            return null;
                                        }
                                        C0169.m2121();
                                        if (!C0172.f1141) {
                                            C0166.m2073();
                                        }
                                        C0172.m2156();
                                        if (C0169.m2121() != 0) {
                                            C0171.m2152();
                                        }
                                        C0166.m2073();
                                        m0();
                                    }
                                }
                            }
                            return null;
                        }
                        C0161.m2027();
                        if (C0172.m2156()) {
                            m0();
                        }
                        C0169.m2121();
                        if (!C0172.f1141) {
                        }
                        C0172.m2156();
                        if (C0169.m2121() != 0) {
                        }
                        C0166.m2073();
                        m0();
                    }
                }
                m0();
                return null;
            }
            C0161.m2027();
            if (C0169.f1121 == 0 || C0172.f1141) {
                boolean z = C0172.f1141;
                if (C0172.f1141 || !C0171.m2152()) {
                    if (!z) {
                        m0();
                        if (!C0171.m2152()) {
                            m0();
                        }
                        C0169.m2121();
                        m0();
                        return null;
                    }
                    C0169.m2121();
                    if (C0169.f1121 != 0) {
                    }
                    C0171.m2152();
                    m0();
                    return null;
                }
                C0161.m2027();
                if (C0172.m2156()) {
                }
                C0169.m2121();
                if (!C0172.f1141) {
                }
                C0172.m2156();
                if (C0169.m2121() != 0) {
                }
                C0166.m2073();
                m0();
                m0();
                return null;
            }
            C0172.m2156();
            if (!C0172.f1141) {
                C0171.m2152();
                m0();
            }
            C0166.m2073();
            m0();
            m0();
            return null;
        }
        return declaredMethod;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (l.C0169.m2121() <= 0) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        if (l.C0161.f1060 != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0102, code lost:
        if (l.C0161.f1060 <= 0) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0167, code lost:
        if (l.C0172.m2156() != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (l.C0171.m2152() != false) goto L_0x0026;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012f  */
    /* renamed from: ۬ۡۦ  reason: not valid java name and contains not printable characters */
    public static long m9(Object obj) {
        if (!f0) {
            if (C0172.m2156() && C0166.m2073()) {
                C0169.m2121();
                boolean z = f0;
                if (C0172.f1141 || C0169.m2121() <= 0) {
                    if (z) {
                        C0171.m2152();
                        if (C0171.f1122 >= 0) {
                            C0169.m2121();
                            C0171.m2152();
                        }
                        C0169.m2121();
                        if (C0171.f1122 != 0) {
                            m0();
                        }
                        boolean r1 = C0166.m2073();
                        if (C0171.m2152() || !C0172.m2156()) {
                            if (!r1) {
                                C0172.m2156();
                                if (!C0172.m2156()) {
                                    C0161.m2027();
                                    m0();
                                }
                            } else if (!C0172.m2156() || m0() < 0) {
                                C0161.m2027();
                            }
                            m0();
                            if (C0161.f1060 != 0) {
                                if (m0() <= 0) {
                                    C0172.m2156();
                                }
                                C0166.m2073();
                            }
                            m0();
                            m0();
                            C0171.m2152();
                            C0169.m2121();
                            return 0;
                        }
                        C0161.m2027();
                        if (C0161.f1060 <= 0) {
                            C0166.m2073();
                            m0();
                            m0();
                            C0171.m2152();
                            m0();
                            return 0;
                        }
                        m0();
                        if (C0171.f1122 != 0) {
                            C0166.m2073();
                            C0172.m2156();
                            m0();
                            return 0;
                        }
                        m0();
                        m0();
                        C0171.m2152();
                        m0();
                        return 0;
                    } else if (!C0166.m2073() || C0172.m2156()) {
                        C0172.m2156();
                        if (!f0) {
                            C0166.m2073();
                        }
                        C0161.m2027();
                        m0();
                        m0();
                        C0171.m2152();
                        C0169.m2121();
                        return 0;
                    }
                }
                C0161.m2027();
                if (C0161.f1060 != 0) {
                    C0171.m2152();
                    m0();
                    if (C0171.f1122 != 0) {
                    }
                    m0();
                    m0();
                    C0171.m2152();
                    m0();
                    return 0;
                }
                C0161.m2027();
                if (C0161.f1060 <= 0) {
                }
                m0();
                if (C0171.f1122 != 0) {
                }
                m0();
                m0();
                C0171.m2152();
                m0();
                return 0;
            }
        }
        File file = (File) obj;
        if (C0171.m2152() || !C0171.m2152()) {
            if (C0161.m2027()) {
                C0161.m2027();
            }
            if (!C0166.m2073() || f0) {
                return file.lastModified();
            }
            C0171.m2152();
            return 0;
        }
        C0161.m2027();
        if (C0161.f1060 <= 0) {
        }
        m0();
        if (C0171.f1122 != 0) {
        }
        m0();
        m0();
        C0171.m2152();
        m0();
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01c9, code lost:
        r0 = new java.lang.String(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d2, code lost:
        if (l.C0169.m2121() > 0) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01d8, code lost:
        if (l.C0169.m2121() <= 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01dc, code lost:
        if (l.C0172.f1141 != false) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01e2, code lost:
        if (m0() < 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01e4, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0201, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0209, code lost:
        if (m0() >= 0) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x020b, code lost:
        m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0212, code lost:
        if (m0() > 0) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0214, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x021a, code lost:
        if (l.C0161.f1060 == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0220, code lost:
        if (l.C0161.m2027() != false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0222, code lost:
        if (r3 <= 0) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0239, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0241, code lost:
        if (l.C0166.m2073() == false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0243, code lost:
        m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0248, code lost:
        if (l.C0172.f1141 != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x024a, code lost:
        r3 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x024f, code lost:
        r3 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0255, code lost:
        if (l.C0172.f1141 == false) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0257, code lost:
        r3 = l.C0171.m2152();
        r3 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x025f, code lost:
        r3 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0265, code lost:
        if (l.C0166.f1088 == false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0267, code lost:
        r0 = l.C0166.m2073();
        r0 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0271, code lost:
        r3 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0279, code lost:
        if (l.C0166.m2073() == false) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x027b, code lost:
        l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (cc.binmt.signature.Hook.f0 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0280, code lost:
        if (l.C0166.f1088 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0283, code lost:
        r2 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0289, code lost:
        if (l.C0172.f1141 != false) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x028b, code lost:
        r2 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x028f, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0295, code lost:
        if (l.C0169.f1121 == 0) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0297, code lost:
        r0 = m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x029d, code lost:
        r3 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02a3, code lost:
        if (l.C0166.f1088 != false) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        r3 = m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02a9, code lost:
        if (l.C0172.m2156() != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02ab, code lost:
        if (r3 == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02ad, code lost:
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02b5, code lost:
        if (l.C0161.m2027() == false) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02b7, code lost:
        r0 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (l.C0161.m2027() != false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r0 = l.C0166.m2073();
        r0 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        r3 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (m0() < 0) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        r0 = l.C0171.m2152();
        r0 = m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r3 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        if (l.C0171.m2152() == false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (l.C0172.f1141 != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (l.C0171.f1122 < 0) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (r3 <= 0) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        r3 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        r1 = l.C0161.m2027();
        r0 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (l.C0161.m2027() == false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
        r0 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        if (cc.binmt.signature.Hook.f0 == false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bc, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c0, code lost:
        r3 = m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c6, code lost:
        if (l.C0172.f1141 != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cf, code lost:
        if (l.C0169.m2121() <= 0) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
        if (l.C0172.f1141 != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d5, code lost:
        r0 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
        if (m0() < 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011a, code lost:
        r3 = m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r3 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (l.C0171.m2152() == false) goto L_0x0283;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f8  */
    /* renamed from: ۜۜ۠  reason: not valid java name and contains not printable characters */
    public static String m1(Object obj) {
        if (C0169.f1121 == 0 || C0169.f1121 != 0) {
            if (C0166.m2073()) {
                if (C0171.m2152() || !f0) {
                }
                if (!C0172.m2156()) {
                    C0169.m2121();
                }
                m0();
                C0169.m2121();
                C0166.m2073();
                if (!f0) {
                    C0166.m2073();
                }
                return null;
            }
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            char[] cArr = new char[length];
            while (true) {
                int i = length - 1;
                cArr[i] = (char) (sArr[i] ^ 60);
                if (C0169.m2121() >= 0 || C0172.m2156()) {
                    if (i != 0) {
                        if (C0169.f1121 != 0) {
                            m0();
                            if (!C0161.m2027()) {
                                break;
                            }
                        }
                        if (C0161.f1060 != 0) {
                            C0166.m2073();
                            if (C0171.f1122 == 0) {
                                break;
                            }
                        }
                        int i2 = i - 1;
                        cArr[i2] = (char) (sArr[i2] ^ 52);
                        if (C0161.f1060 != 0) {
                            if (m0() <= 0 && !C0161.m2027()) {
                                break;
                            } else if (!C0171.m2152()) {
                                C0166.m2073();
                                boolean r3 = C0166.m2073();
                                if (m0() <= 0) {
                                    m0();
                                }
                                if (!r3) {
                                    m0();
                                    m0();
                                }
                            }
                        }
                        if (i2 != 0) {
                            if (f0 || C0166.f1088) {
                                if (C0169.m2121() < 0 && C0161.f1060 == 0) {
                                    break;
                                }
                                int i3 = i2 - 1;
                                cArr[i3] = (char) (sArr[i3] ^ 68);
                                if (!C0171.m2152()) {
                                }
                                if (i3 == 0) {
                                    break;
                                }
                                int i4 = i3 - 1;
                                cArr[i4] = (char) (sArr[i4] ^ -39);
                                if (!C0171.m2152()) {
                                }
                                if (i4 == 0) {
                                    break;
                                }
                                length = i4 - 1;
                                cArr[length] = (char) (sArr[length] ^ 25);
                                if (!C0166.f1088) {
                                    C0161.m2027();
                                    if (C0171.f1122 == 0 || C0169.f1121 != 0) {
                                        if (!C0161.m2027()) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (length == 0) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (m0() != 0) {
                C0166.m2073();
                C0166.m2073();
            }
            m0();
            C0171.m2152();
            C0166.m2073();
            return null;
        }
        C0169.m2121();
        if (C0172.f1141) {
            C0161.m2027();
        }
        m0();
        if (m0() <= 0) {
            C0171.m2152();
            m0();
            C0171.m2152();
            C0166.m2073();
            return null;
        }
        if (m0() != 0) {
        }
        m0();
        C0171.m2152();
        C0166.m2073();
        return null;
    }
}