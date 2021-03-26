package l;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import cc.binmt.signature.Hook;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: l.ۤۡ۟  reason: contains not printable characters */
public class C0169 {

    /* renamed from: ۛۚۜ  reason: not valid java name and contains not printable characters */
    public static int f1121;

    /* renamed from: ۛۚۜ  reason: not valid java name and contains not printable characters */
    public static int m2121() {
        return 13356;
    }

    /* renamed from: ۟ۗ۠  reason: not valid java name and contains not printable characters */
    public static boolean m2123(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: ۡۙۡ  reason: not valid java name and contains not printable characters */
    public static String m2125(Object obj) {
        return ((File) obj).getPath();
    }

    /* renamed from: ۥۚۡ  reason: contains not printable characters */
    public static boolean m2126(Object obj) {
        return ((File) obj).mkdirs();
    }

    /* renamed from: ۦۙۡ  reason: contains not printable characters */
    public static PackageManager m2127(Object obj) {
        return ((Context) obj).getPackageManager();
    }

    /* renamed from: ۦۨۤ  reason: contains not printable characters */
    public static String m2129(Object obj) {
        return ((Member) obj).getName();
    }

    /* renamed from: ۧۦۦ  reason: not valid java name and contains not printable characters */
    public static String m2130(Object obj) {
        return ((DataInput) obj).readUTF();
    }

    /* renamed from: ۫ۥۛ  reason: not valid java name and contains not printable characters */
    public static Iterator m2131(Object obj) {
        return ((Iterable) obj).iterator();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        if (l.C0169.f1121 != 0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014f, code lost:
        if (l.C0172.m2156() != false) goto L_0x0151;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0155  */
    /* renamed from: ۬ۗۦ  reason: not valid java name and contains not printable characters */
    public static boolean m2132(Object obj, Object obj2) {
        boolean startsWith = ((String) obj).startsWith((String) obj2);
        if (!C0172.f1141) {
            Hook.m0();
            if (!C0171.m2152()) {
                C0161.m2027();
            }
            if (C0161.f1060 == 0) {
                m2121();
                if (C0161.m2027()) {
                    C0161.m2027();
                    C0166.m2073();
                }
                C0161.m2027();
                if (!C0166.f1088) {
                    C0166.m2073();
                }
                if (C0171.f1122 == 0) {
                    m2121();
                } else if (!C0171.m2152()) {
                    C0172.m2156();
                    if (Hook.m0() > 0 || !C0172.m2156()) {
                        C0172.m2156();
                    }
                    C0172.m2156();
                    C0172.m2156();
                    C0166.m2073();
                    return false;
                }
                m2121();
                if (C0172.f1141) {
                    if (C0171.f1122 == 0 || C0172.f1141) {
                        C0161.m2027();
                    }
                    C0166.m2073();
                    return false;
                }
                C0166.m2073();
                if (C0161.f1060 >= 0) {
                    if (C0161.f1060 != 0) {
                        C0171.m2152();
                    }
                    C0172.m2156();
                    C0161.m2027();
                }
                m2121();
                m2121();
                C0166.m2073();
                if (C0171.f1122 == 0 || C0171.f1122 == 0) {
                    return false;
                }
                m2121();
                if (C0171.m2152()) {
                    C0161.m2027();
                    C0172.m2156();
                }
                C0172.m2156();
                C0172.m2156();
                C0166.m2073();
                return false;
            }
        }
        if (C0161.m2027()) {
            if (!Hook.f0 && C0161.f1060 == 0) {
                C0161.m2027();
                int r1 = m2121();
                if (Hook.f0 || C0172.m2156()) {
                    if (r1 <= 0) {
                        if (!C0161.m2027() || f1121 != 0) {
                            Hook.m0();
                        }
                        m2121();
                        if (C0171.m2152()) {
                        }
                        C0172.m2156();
                        C0172.m2156();
                        C0166.m2073();
                        return false;
                    }
                    C0161.m2027();
                    if (!C0166.f1088) {
                    }
                    if (C0171.f1122 == 0) {
                    }
                    m2121();
                    if (C0172.f1141) {
                    }
                    m2121();
                    m2121();
                    C0166.m2073();
                    return false;
                }
                Hook.m0();
                if (!C0171.m2152()) {
                    C0161.m2027();
                    C0166.m2073();
                    C0166.m2073();
                    return false;
                }
                m2121();
                if (C0171.m2152()) {
                }
                C0172.m2156();
                C0172.m2156();
                C0166.m2073();
                return false;
            } else if (C0166.f1088) {
                m2121();
                if (!C0166.m2073() || Hook.m0() >= 0) {
                    return false;
                }
                C0161.m2027();
                if (!C0166.f1088) {
                }
                if (C0171.f1122 == 0) {
                }
                m2121();
                if (C0172.f1141) {
                }
                m2121();
                m2121();
                C0166.m2073();
                return false;
            }
        }
        return startsWith;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0225, code lost:
        if (l.C0166.m2073() == false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d6, code lost:
        if (m2121() <= 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fb, code lost:
        if (l.C0161.m2027() != false) goto L_0x00fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0182  */
    /* renamed from: ۡۖۢ  reason: not valid java name and contains not printable characters */
    public static String m2124(Object obj) {
        if (!C0172.m2156() || C0171.f1122 <= 0) {
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            char[] cArr = new char[length];
            while (true) {
                length--;
                cArr[length] = (char) (sArr[length] ^ 65);
                if (f1121 != 0) {
                    C0166.m2073();
                    if (C0172.f1141) {
                        break;
                    }
                }
                if (C0172.m2156()) {
                    if (C0161.f1060 != 0) {
                        C0166.m2073();
                        if (C0161.m2027()) {
                            break;
                        }
                    }
                    if (f1121 != 0) {
                        break;
                    }
                }
                if (length == 0) {
                    String str = new String(cArr);
                    boolean z = C0172.f1141;
                    if (C0172.m2156()) {
                        C0172.m2156();
                    }
                    if (Hook.f0 || !C0172.m2156()) {
                        if (!z) {
                            if (!C0171.m2152()) {
                                C0166.m2073();
                            }
                            if (C0171.f1122 == 0 || m2121() >= 0) {
                            }
                        }
                        return str;
                    }
                }
            }
            C0166.m2073();
            if (!Hook.f0) {
                C0172.m2156();
            }
            C0161.m2027();
            return null;
        }
        C0171.m2152();
        int i = C0171.f1122;
        if (C0166.f1088 || !C0172.m2156()) {
            if (i != 0) {
                C0166.m2073();
            } else {
                m2121();
                if (C0171.m2152() || f1121 == 0) {
                    boolean z2 = C0172.f1141;
                    if (C0171.f1122 == 0 || C0161.m2027()) {
                        if (z2) {
                            C0172.m2156();
                        }
                        C0172.m2156();
                        if (!C0161.m2027() || C0172.m2156()) {
                            int r3 = Hook.m0();
                            if (C0171.f1122 != 0) {
                            }
                            if (!C0171.m2152()) {
                                C0166.m2073();
                                if (Hook.f0 || C0172.m2156()) {
                                }
                                C0166.m2073();
                                C0166.m2073();
                                C0161.m2027();
                                return null;
                            }
                            if (r3 != 0) {
                                if (f1121 != 0) {
                                }
                                Hook.m0();
                                m2121();
                            }
                        } else {
                            C0161.m2027();
                            if (!C0161.m2027() || C0166.f1088) {
                                if (m2121() > 0) {
                                    Hook.m0();
                                }
                                C0166.m2073();
                                if (C0166.m2073() && !Hook.f0) {
                                    m2121();
                                    if (C0172.m2156()) {
                                        m2121();
                                        C0161.m2027();
                                        return null;
                                    }
                                    if (!C0172.m2156()) {
                                        C0171.m2152();
                                        C0172.m2156();
                                    }
                                    C0161.m2027();
                                    if (m2121() > 0) {
                                        C0172.m2156();
                                        Hook.m0();
                                    } else {
                                        C0172.m2156();
                                        if (!C0171.m2152()) {
                                            C0161.m2027();
                                        }
                                    }
                                    C0166.m2073();
                                    C0166.m2073();
                                    C0161.m2027();
                                    return null;
                                } else if (f1121 <= 0) {
                                    Hook.m0();
                                    C0171.m2152();
                                    if (!C0172.m2156()) {
                                        if (f1121 != 0) {
                                        }
                                        C0161.m2027();
                                        m2121();
                                        C0172.m2156();
                                        if (!C0171.m2152()) {
                                            C0172.m2156();
                                        }
                                        return null;
                                    }
                                    Hook.m0();
                                    if (f1121 == 0 || C0161.f1060 >= 0) {
                                        if (!C0172.m2156()) {
                                            C0161.m2027();
                                            C0171.m2152();
                                        }
                                        C0166.m2073();
                                        if (C0171.f1122 != 0) {
                                            m2121();
                                        }
                                    }
                                }
                            }
                            C0166.m2073();
                            if (!Hook.f0) {
                            }
                            C0161.m2027();
                            return null;
                        }
                    }
                }
                m2121();
                C0166.m2073();
                C0172.m2156();
                C0172.m2156();
                if (!C0171.m2152()) {
                }
                return null;
            }
            C0171.m2152();
            C0166.m2073();
            C0171.m2152();
            return null;
        }
        C0172.m2156();
        if (!C0166.m2073()) {
            C0172.m2156();
            C0171.m2152();
        }
        C0171.m2152();
        if (!C0172.m2156()) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (l.C0161.f1060 != 0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (l.C0171.m2152() == false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0135, code lost:
        if (l.C0166.m2073() == false) goto L_0x0137;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d2  */
    /* renamed from: ۛۢ۠  reason: not valid java name and contains not printable characters */
    public static PackageInfo m2122(Object obj, Object obj2, int i) {
        PackageInfo packageInfo = ((PackageManager) obj).getPackageInfo((String) obj2, i);
        boolean r1 = C0171.m2152();
        if (C0171.f1122 != 0) {
            if (!C0166.f1088) {
                C0172.m2156();
            }
        }
        if (!r1) {
            boolean r12 = C0171.m2152();
            if (C0166.m2073()) {
                if (C0166.m2073()) {
                    C0172.m2156();
                }
                if (C0172.m2156()) {
                    if (C0161.m2027()) {
                        if (!C0172.m2156() || m2121() < 0) {
                            C0166.m2073();
                        }
                        m2121();
                        C0172.m2156();
                        Hook.m0();
                        C0172.m2156();
                        return null;
                    }
                    C0171.m2152();
                    if (C0166.f1088 || C0166.m2073()) {
                        return null;
                    }
                    C0172.m2156();
                    return null;
                }
            }
            if (!r12) {
                boolean r2 = C0171.m2152();
                if (Hook.m0() >= 0 || Hook.m0() > 0) {
                    if (!r2) {
                        if (m2121() >= 0 || C0161.f1060 <= 0) {
                            C0171.m2152();
                        } else {
                            C0172.m2156();
                            if (C0166.m2073()) {
                                C0171.m2152();
                            } else {
                                int i2 = f1121;
                                if (C0171.f1122 != 0) {
                                }
                                if (i2 <= 0) {
                                    if (C0171.f1122 == 0 || Hook.m0() > 0) {
                                        C0172.m2156();
                                    } else {
                                        if (Hook.f0) {
                                            m2121();
                                        }
                                        m2121();
                                        if (C0171.f1122 != 0) {
                                            C0161.m2027();
                                            m2121();
                                            C0172.m2156();
                                            Hook.m0();
                                            C0172.m2156();
                                            return null;
                                        }
                                        C0172.m2156();
                                        if (f1121 != 0) {
                                            C0161.m2027();
                                            m2121();
                                            C0172.m2156();
                                            return null;
                                        }
                                        C0172.m2156();
                                        if (C0171.f1122 != 0) {
                                            C0172.m2156();
                                            C0166.m2073();
                                            C0172.m2156();
                                            return null;
                                        }
                                        m2121();
                                        C0172.m2156();
                                        Hook.m0();
                                        C0172.m2156();
                                        return null;
                                    }
                                }
                            }
                            C0171.m2152();
                            if (!C0166.m2073()) {
                                C0171.m2152();
                                Hook.m0();
                            }
                            m2121();
                            C0172.m2156();
                            Hook.m0();
                            C0171.m2152();
                            return null;
                        }
                    }
                    m2121();
                    if (C0161.f1060 != 0) {
                        if (C0161.f1060 == 0 || Hook.f0) {
                        }
                    }
                    return null;
                }
                if (!C0166.f1088) {
                    m2121();
                }
                C0172.m2156();
                if (C0171.f1122 != 0) {
                }
                m2121();
                C0172.m2156();
                Hook.m0();
                C0172.m2156();
                return null;
            }
        }
        return packageInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
        if (l.C0171.m2152() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e4, code lost:
        if (l.C0169.f1121 == 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0100, code lost:
        if (cc.binmt.signature.Hook.f0 == false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0104, code lost:
        if (l.C0172.f1141 != false) goto L_0x0106;
     */
    /* renamed from: ۖ۟۠  reason: not valid java name and contains not printable characters */
    public static Field m2118(Object obj, Object obj2) {
        Field declaredField = ((Class) obj).getDeclaredField((String) obj2);
        if (m2121() > 0 || C0161.f1060 != 0) {
            if (C0172.m2156()) {
                if (!C0172.m2156() || C0172.m2156()) {
                    if (!C0172.m2156()) {
                        m2121();
                        if (C0172.m2156()) {
                            Hook.m0();
                        }
                        if (!C0166.f1088) {
                            if (Hook.m0() > 0 || Hook.f0) {
                                C0166.m2073();
                                if (C0171.f1122 != 0) {
                                    C0161.m2027();
                                }
                            }
                            m2121();
                            if (C0166.f1088) {
                                Hook.m0();
                            }
                            C0161.m2027();
                            if (!C0171.m2152()) {
                                C0172.m2156();
                                C0161.m2027();
                                C0166.m2073();
                                C0166.m2073();
                                return null;
                            }
                        }
                        return null;
                    }
                }
                C0161.m2027();
                if (!C0166.f1088) {
                    C0161.m2027();
                    C0161.m2027();
                }
                C0172.m2156();
                if (!C0172.f1141) {
                    C0166.m2073();
                }
                if (!C0171.m2152()) {
                    C0166.m2073();
                }
                C0166.m2073();
                m2121();
                Hook.m0();
                if (!C0166.f1088) {
                    C0172.m2156();
                    if (C0161.m2027()) {
                        C0171.m2152();
                        if (!C0161.m2027()) {
                            m2121();
                            C0166.m2073();
                        }
                        C0166.m2073();
                        return null;
                    }
                }
                return null;
            }
            return declaredField;
        }
        C0161.m2027();
        if (C0161.f1060 <= 0) {
            C0161.m2027();
            C0171.m2152();
            C0166.m2073();
            return null;
        }
        C0161.m2027();
        C0166.m2073();
        C0166.m2073();
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01de, code lost:
        if (l.C0169.f1121 == 0) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01f4, code lost:
        if (l.C0166.m2073() != false) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f6, code lost:
        r4 = m2121();
        r4 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01fe, code lost:
        r4 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0206, code lost:
        if (l.C0172.m2156() == false) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0208, code lost:
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0212, code lost:
        r4 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x021a, code lost:
        if (l.C0171.m2152() == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x021c, code lost:
        r0 = m2121();
        r0 = m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (l.C0161.f1060 != 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (l.C0166.m2073() == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (l.C0172.f1141 == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b8, code lost:
        if (m2121() <= 0) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0 != false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ea, code lost:
        r4 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f2, code lost:
        if (l.C0161.m2027() == false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f4, code lost:
        r0 = m2121();
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0125, code lost:
        if (r1 != false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (cc.binmt.signature.Hook.m0() < 0) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* renamed from: ۘۜۡ  reason: not valid java name and contains not printable characters */
    public static void m2120(File file) {
        if (C0172.m2156()) {
            C0166.m2073();
            boolean z = Hook.f0;
            if (Hook.m0() <= 0) {
                C0166.m2073();
            }
        }
        boolean r0 = C0166.m2081(file);
        if (C0171.f1122 != 0) {
            Hook.m0();
        }
        if (C0161.f1060 != 0) {
            m2121();
        }
        if (r0) {
            if (C0166.m2073()) {
                if (Hook.m0() <= 0) {
                    if (Hook.f0 || C0171.f1122 >= 0) {
                    }
                    C0171.m2152();
                }
                C0171.m2152();
            }
            File[] r02 = C0166.m2066(file);
            int r1 = Hook.m0();
            if (C0166.m2073()) {
                if (!C0166.m2073() || C0166.m2073()) {
                    if (C0172.f1141) {
                        C0171.m2152();
                        if (m2121() < 0) {
                            C0166.m2073();
                            m2121();
                            Hook.m0();
                            m2121();
                            if (C0161.f1060 == 0 || C0171.m2152()) {
                                return;
                            }
                        }
                        C0161.m2027();
                        if (C0171.f1122 != 0) {
                            if (m2121() <= 0) {
                                m2121();
                            }
                            Hook.m0();
                            m2121();
                            Hook.m0();
                            m2121();
                            return;
                        }
                        C0161.m2027();
                        if (C0166.f1088 || C0171.m2152()) {
                            if (C0172.f1141) {
                                C0171.m2152();
                                m2121();
                                return;
                            }
                            m2121();
                            Hook.m0();
                            m2121();
                            return;
                        }
                    }
                }
                C0171.m2152();
            }
            if (r1 < 0) {
                boolean r12 = C0171.m2152();
                if (f1121 == 0 || !C0166.m2073()) {
                }
                m2121();
                Hook.m0();
                m2121();
                return;
            }
            if (r02 != null) {
                int length = r02.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    m2120(r02[i]);
                    if (C0172.m2156()) {
                        m2121();
                        if (!C0161.m2027()) {
                            break;
                        }
                    }
                    if (C0161.f1060 != 0) {
                        C0166.m2073();
                        if (!C0161.m2027()) {
                            break;
                        }
                    }
                    i++;
                }
                C0171.m2152();
                Hook.m0();
                C0171.m2152();
            }
        }
        C0172.m2160(file);
        if (C0161.f1060 == 0 || C0171.f1122 != 0) {
            if (!Hook.f0) {
                m2121();
                boolean z2 = C0166.f1088;
                if (C0161.m2027()) {
                    C0161.m2027();
                }
                if (z2) {
                    return;
                }
                C0166.m2073();
                int r3 = Hook.m0();
                if (C0172.m2156()) {
                }
                if (r3 < 0) {
                    Hook.m0();
                } else {
                    C0172.m2156();
                    if (!C0166.m2073()) {
                        if (C0161.f1060 != 0) {
                        }
                        C0172.m2156();
                        C0172.m2156();
                        return;
                    }
                }
                C0166.m2073();
                if (C0161.f1060 == 0 || m2121() > 0) {
                    if (!C0166.m2073()) {
                        C0171.m2152();
                        C0172.m2156();
                    }
                    C0166.m2073();
                    if (C0171.f1122 != 0) {
                        C0166.m2073();
                    }
                    if (C0161.f1060 == 0 || !Hook.f0) {
                        C0166.m2073();
                        C0172.m2156();
                        return;
                    }
                    if (m2121() < 0) {
                        C0171.m2152();
                    }
                    C0161.m2027();
                    if (C0171.f1122 != 0) {
                    }
                }
                C0161.m2027();
                if (C0172.f1141) {
                }
                m2121();
                Hook.m0();
                m2121();
                return;
            }
            return;
        }
        C0171.m2152();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (l.C0161.f1060 != 0) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007f, code lost:
        if (m2121() <= 0) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (l.C0172.m2156() == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b1, code lost:
        if (l.C0172.m2156() != false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        if (m2121() < 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0192, code lost:
        if (cc.binmt.signature.Hook.m0() < 0) goto L_0x0194;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    /* renamed from: ۖۦۨ  reason: not valid java name and contains not printable characters */
    public static Object m2119(Object obj, Object obj2, Object obj3) {
        Object newProxyInstance = Proxy.newProxyInstance((ClassLoader) obj, (Class[]) obj2, (InvocationHandler) obj3);
        int r1 = Hook.m0();
        if (C0171.f1122 != 0) {
            C0172.m2156();
        }
        if (r1 >= 0 || !Hook.f0) {
            int r12 = Hook.m0();
            if (C0161.f1060 != 0) {
                if (f1121 != 0) {
                    m2121();
                }
                Hook.m0();
            }
            if (r12 < 0) {
                if (!C0166.f1088) {
                    C0166.m2073();
                    if (C0171.m2152()) {
                        C0171.m2152();
                        if (C0161.f1060 <= 0) {
                            if (Hook.m0() < 0) {
                                C0166.m2073();
                            }
                            C0161.m2027();
                            Hook.m0();
                        }
                        C0161.m2027();
                        return null;
                    }
                }
                int i = f1121;
                if (C0166.m2073()) {
                    C0171.m2152();
                }
                if (C0171.f1122 != 0) {
                    if (Hook.m0() <= 0) {
                        Hook.m0();
                    }
                    m2121();
                    if (f1121 == 0 || C0166.m2073()) {
                    }
                    Hook.m0();
                    if (!C0166.f1088) {
                        m2121();
                    }
                    C0172.m2156();
                    if (C0161.f1060 <= 0) {
                        m2121();
                        C0171.m2152();
                        C0171.m2152();
                        m2121();
                        return null;
                    }
                    m2121();
                    if (!C0161.m2027()) {
                        m2121();
                        C0171.m2152();
                        C0171.m2152();
                        m2121();
                        return null;
                    }
                    if (m2121() != 0) {
                        m2121();
                    }
                    C0161.m2027();
                    if (m2121() != 0) {
                        C0161.m2027();
                        m2121();
                    }
                    C0171.m2152();
                    C0171.m2152();
                    m2121();
                    return null;
                }
                if (i < 0) {
                    boolean z = C0172.f1141;
                    if (m2121() >= 0 || !C0172.f1141) {
                        if (!z) {
                            C0161.m2027();
                        }
                        C0171.m2152();
                        if (C0161.m2027()) {
                            Hook.m0();
                        }
                        return null;
                    }
                    Hook.m0();
                    if (!C0166.m2073() || C0171.m2152()) {
                        if (C0171.m2152()) {
                            C0161.m2027();
                            if (m2121() >= 0 || Hook.m0() > 0) {
                                C0161.m2027();
                            }
                            Hook.m0();
                            if (!C0166.f1088) {
                            }
                            C0172.m2156();
                            if (C0161.f1060 <= 0) {
                            }
                        }
                        C0172.m2156();
                        if (Hook.m0() < 0) {
                            if (C0171.f1122 == 0 || C0172.f1141) {
                                C0171.m2152();
                                C0161.m2027();
                                return null;
                            }
                            C0172.m2156();
                            if (C0171.f1122 <= 0) {
                                Hook.m0();
                            }
                            m2121();
                            return null;
                        }
                        C0172.m2156();
                        m2121();
                        C0161.m2027();
                        return null;
                    }
                    m2121();
                    if (!C0161.m2027()) {
                    }
                }
            }
            return newProxyInstance;
        }
        m2121();
        if (!Hook.f0) {
            C0166.m2073();
            C0172.m2156();
            m2121();
            C0161.m2027();
            return null;
        }
        Hook.m0();
        if (!C0172.m2156()) {
            Hook.m0();
            m2121();
        }
        Hook.m0();
        if (C0171.m2152()) {
        }
        C0172.m2156();
        if (Hook.m0() < 0) {
        }
        C0172.m2156();
        m2121();
        C0161.m2027();
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01d5, code lost:
        if (l.C0161.f1060 <= 0) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0293, code lost:
        if (l.C0166.f1088 == false) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c2, code lost:
        if (m2121() < 0) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0310, code lost:
        if (cc.binmt.signature.Hook.m0() < 0) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c9, code lost:
        if (cc.binmt.signature.Hook.m0() <= 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0196, code lost:
        if (m2121() < 0) goto L_0x0198;
     */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03f7  */
    /* renamed from: ۦۙۨ  reason: contains not printable characters */
    public static void m2128(File file, File file2, C0161 r7) {
        if (C0171.f1122 != 0) {
            Hook.m0();
        }
        if (!Hook.m3(file2)) {
            File r0 = C0171.m2144(file2);
            if (Hook.m3(r0)) {
                m2120(r0);
            }
            m2126(r0);
            try {
                C0179 r02 = new C0179(file);
                if (Hook.f0 || Hook.f0) {
                    if (C0171.m2152() || !Hook.f0) {
                        C0165 r5 = new C0165(file2);
                        ArrayList<C0168> r1 = r02.m2195();
                        if (C0161.f1060 != 0) {
                            Hook.m0();
                        }
                        Iterator r12 = m2131(r1);
                        while (true) {
                            boolean r2 = C0172.m2161(r12);
                            short[] r3 = C0161.m2026(9);
                            // fill-array-data instruction
                            r3[0] = -64;
                            r3[1] = -8;
                            r3[2] = -39;
                            r3[3] = -4;
                            r3[4] = -96;
                            r3[5] = -12;
                            r3[6] = -61;
                            r3[7] = -5;
                            r3[8] = -94;
                            String r32 = C0171.m2148(r3);
                            if (r2) {
                                Object r22 = C0166.m2065(r12);
                                if (!C0166.f1088) {
                                    m2121();
                                    if (C0171.m2152()) {
                                        break;
                                    }
                                }
                                if (!C0171.m2152()) {
                                    C0172.m2156();
                                }
                                C0168 r23 = (C0168) r22;
                                if (!Hook.f0) {
                                    C0166.m2073();
                                }
                                String r4 = r23.m2116();
                                if (m2132(r4, r32)) {
                                    short[] r33 = C0161.m2026(33);
                                    // fill-array-data instruction
                                    r33[0] = -40;
                                    r33[1] = -37;
                                    r33[2] = -84;
                                    r33[3] = 106;
                                    r33[4] = -79;
                                    r33[5] = -69;
                                    r33[6] = -96;
                                    r33[7] = 112;
                                    r33[8] = -74;
                                    r33[9] = -71;
                                    r33[10] = -57;
                                    r33[11] = 20;
                                    r33[12] = -39;
                                    r33[13] = -54;
                                    r33[14] = -57;
                                    r33[15] = 22;
                                    r33[16] = -94;
                                    r33[17] = -59;
                                    r33[18] = -88;
                                    r33[19] = 66;
                                    r33[20] = -76;
                                    r33[21] = -59;
                                    r33[22] = -88;
                                    r33[23] = 66;
                                    r33[24] = -75;
                                    r33[25] = -43;
                                    r33[26] = -107;
                                    r33[27] = 109;
                                    r33[28] = -74;
                                    r33[29] = -22;
                                    r33[30] = -92;
                                    r33[31] = 120;
                                    r33[32] = -39;
                                    if (C0172.m2155(r4, C0161.m2029(r33))) {
                                    }
                                }
                                short[] r34 = C0161.m2026(7);
                                // fill-array-data instruction
                                r34[0] = -119;
                                r34[1] = 18;
                                r34[2] = -124;
                                r34[3] = -117;
                                r34[4] = 9;
                                r34[5] = -121;
                                r34[6] = -53;
                                if (!m2132(r4, C0172.m2164(r34))) {
                                    short[] r35 = C0161.m2026(4);
                                    // fill-array-data instruction
                                    r35[0] = -6;
                                    r35[1] = -128;
                                    r35[2] = 92;
                                    r35[3] = -33;
                                    if (m2132(r4, C0161.m2029(r35))) {
                                        short[] r36 = C0161.m2026(12);
                                        // fill-array-data instruction
                                        r36[0] = 10;
                                        r36[1] = -123;
                                        r36[2] = -122;
                                        r36[3] = 11;
                                        r36[4] = -104;
                                        r36[5] = -116;
                                        r36[6] = 9;
                                        r36[7] = -125;
                                        r36[8] = -113;
                                        r36[9] = 72;
                                        r36[10] = -97;
                                        r36[11] = -117;
                                        if (C0166.m2068(r4, C0172.m2164(r36))) {
                                        }
                                    }
                                    r5.m2061(r23, r02);
                                }
                            } else {
                                if (m2121() < 0) {
                                    if (C0171.f1122 == 0 || Hook.f0) {
                                        StringBuilder sb = new StringBuilder();
                                        if (C0172.m2156()) {
                                            m2121();
                                        }
                                        C0171.m2153(sb, r32);
                                        C0171.m2153(sb, r7.f1065);
                                        String r13 = C0166.m2071(sb);
                                        if (f1121 == 0 || C0171.m2152()) {
                                            r5.m2063(r13);
                                            r5.m2048(r7.f1064);
                                            StringBuilder sb2 = new StringBuilder();
                                            C0171.m2153(sb2, r32);
                                            C0171.m2153(sb2, r7.f1066);
                                            if (C0166.m2073()) {
                                                if (!C0166.f1088) {
                                                    m2121();
                                                }
                                                C0166.m2073();
                                            }
                                            String r14 = C0166.m2071(sb2);
                                            if (C0172.f1141 || Hook.f0) {
                                                r5.m2063(r14);
                                                r5.m2048(r7.f1062);
                                                StringBuilder sb3 = new StringBuilder();
                                                if (m2121() < 0) {
                                                    C0166.m2073();
                                                }
                                                C0171.m2153(sb3, r32);
                                                C0171.m2153(sb3, r7.f1061);
                                                r5.m2063(C0166.m2071(sb3));
                                                r5.m2048(r7.f1063);
                                                C0171.m2145(r5);
                                                C0171.m2145(r02);
                                            } else {
                                                m2121();
                                                if (!Hook.f0) {
                                                    C0172.m2156();
                                                }
                                            }
                                        }
                                    }
                                    C0161.m2027();
                                    if (C0166.m2073()) {
                                        C0172.m2156();
                                    }
                                    Hook.m0();
                                    if (f1121 <= 0) {
                                        m2121();
                                        Hook.m0();
                                    }
                                } else {
                                    StringBuilder sb4 = new StringBuilder();
                                    C0171.m2153(sb4, r32);
                                    C0171.m2153(sb4, r7.f1065);
                                    if (C0161.f1060 == 0 || Hook.m0() < 0) {
                                        if (!C0172.f1141) {
                                            r5.m2063(C0166.m2071(sb4));
                                            r5.m2048(r7.f1064);
                                            StringBuilder sb5 = new StringBuilder();
                                            C0171.m2153(sb5, r32);
                                            C0171.m2153(sb5, r7.f1066);
                                            r5.m2063(C0166.m2071(sb5));
                                            r5.m2048(r7.f1062);
                                            Hook.m0();
                                            C0161.m2027();
                                            if (C0166.m2073()) {
                                            }
                                            Hook.m0();
                                            if (f1121 <= 0) {
                                            }
                                        } else {
                                            r5.m2063(C0166.m2071(sb4));
                                            r5.m2048(r7.f1064);
                                            if (C0166.m2073()) {
                                                Hook.m0();
                                            }
                                            StringBuilder sb6 = new StringBuilder();
                                            C0171.m2153(sb6, r32);
                                            C0171.m2153(sb6, r7.f1066);
                                            r5.m2063(C0166.m2071(sb6));
                                            r5.m2048(r7.f1062);
                                            if (Hook.m0() <= 0) {
                                                if (Hook.m0() >= 0 || C0166.f1088) {
                                                }
                                            }
                                            StringBuilder sb7 = new StringBuilder();
                                            if (!C0166.m2073() || m2121() <= 0) {
                                                if (!C0171.m2152()) {
                                                    C0171.m2153(sb7, r32);
                                                    C0171.m2153(sb7, r7.f1061);
                                                    r5.m2063(C0166.m2071(sb7));
                                                    byte[] bArr = r7.f1063;
                                                    C0166.m2073();
                                                } else {
                                                    C0171.m2153(sb7, r32);
                                                    C0171.m2153(sb7, r7.f1061);
                                                    r5.m2063(C0166.m2071(sb7));
                                                    byte[] bArr2 = r7.f1063;
                                                    if (C0166.m2073()) {
                                                        C0171.m2152();
                                                    }
                                                    r5.m2048(bArr2);
                                                    if (!Hook.f0) {
                                                        C0166.m2073();
                                                        if (!C0172.m2156() || f1121 == 0) {
                                                            if (!C0172.m2156()) {
                                                                C0172.m2156();
                                                                if (!C0171.m2152()) {
                                                                    if (Hook.m0() > 0 || !C0166.m2073()) {
                                                                        C0166.m2073();
                                                                        C0161.m2027();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    C0171.m2145(r5);
                                                    if (C0171.m2152() || C0171.f1122 <= 0) {
                                                        C0171.m2145(r02);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                C0172.m2156();
                                if (C0161.m2027()) {
                                    C0172.m2156();
                                    C0161.m2027();
                                }
                                C0161.m2027();
                                if (C0166.m2073()) {
                                }
                                Hook.m0();
                                if (f1121 <= 0) {
                                }
                            }
                        }
                        C0166.m2073();
                    }
                    m2121();
                    if (Hook.f0 || f1121 != 0) {
                        if (m2121() >= 0) {
                            C0171.m2152();
                            if (C0161.f1060 != 0) {
                                C0172.m2156();
                                C0172.m2156();
                            }
                        } else if (C0166.f1088 || C0161.f1060 != 0) {
                            C0166.m2073();
                        } else {
                            C0172.m2156();
                            if (C0161.m2027()) {
                                C0172.m2156();
                                Hook.m0();
                            }
                            C0166.m2073();
                            return;
                        }
                        m2121();
                        if (C0161.f1060 >= 0) {
                            if (Hook.m0() > 0 || C0161.f1060 != 0) {
                                C0166.m2073();
                                m2121();
                                if (Hook.m0() >= 0 || !C0161.m2027()) {
                                    return;
                                }
                                if (C0161.f1060 != 0) {
                                    C0161.m2027();
                                }
                                m2121();
                                if (f1121 != 0) {
                                    C0171.m2152();
                                    m2121();
                                    C0166.m2073();
                                }
                            }
                        }
                        C0161.m2027();
                        if (C0166.m2073()) {
                            C0161.m2027();
                            m2121();
                            return;
                        }
                        C0172.m2156();
                        Hook.m0();
                        m2121();
                        return;
                    }
                    C0172.m2156();
                    if (C0172.m2156()) {
                        C0166.m2073();
                    }
                    C0171.m2152();
                    if (!C0161.m2027()) {
                        C0171.m2152();
                        C0166.m2073();
                        return;
                    }
                    C0172.m2156();
                    if (m2121() > 0) {
                        m2121();
                        Hook.m0();
                        C0172.m2156();
                        C0166.m2073();
                        return;
                    }
                    C0171.m2152();
                    if (!C0172.f1141) {
                        C0161.m2027();
                        C0172.m2156();
                    }
                    Hook.m0();
                    C0172.m2156();
                    C0166.m2073();
                    return;
                }
            } catch (IOException e) {
                if (!C0171.m2152()) {
                    C0171.m2152();
                    if (f1121 < 0) {
                        if (f1121 >= 0) {
                            C0172.m2156();
                            if (!C0172.m2156() || !C0166.f1088) {
                                Hook.m0();
                            }
                        }
                    }
                }
                C0172.m2159(e);
                C0172.m2160(file2);
                return;
            }
            C0161.m2027();
            m2121();
            C0166.m2073();
        }
    }
}
