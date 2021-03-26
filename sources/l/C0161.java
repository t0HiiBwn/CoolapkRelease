package l;

import cc.binmt.signature.Hook;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.zip.GZIPInputStream;

/* renamed from: l.ۚۦۛ  reason: contains not printable characters */
public class C0161 {

    /* renamed from: ۡۜۦ  reason: not valid java name and contains not printable characters */
    public static int f1060;

    /* renamed from: ۙۜ۟  reason: not valid java name and contains not printable characters */
    public final String f1061;

    /* renamed from: ۛ۫ۚ  reason: not valid java name and contains not printable characters */
    public final byte[] f1062;

    /* renamed from: ۟ۜ۠  reason: not valid java name and contains not printable characters */
    public final byte[] f1063;

    /* renamed from: ۤۖۢ  reason: not valid java name and contains not printable characters */
    public final byte[] f1064;

    /* renamed from: ۥ۠ۘ  reason: contains not printable characters */
    public final String f1065;

    /* renamed from: ۦ۫ۘ  reason: contains not printable characters */
    public final String f1066;

    /* renamed from: ۠ۗۗ  reason: not valid java name and contains not printable characters */
    public static short[] m2026(int i) {
        return new short[i];
    }

    /* renamed from: ۡۜۦ  reason: not valid java name and contains not printable characters */
    public static boolean m2027() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e5, code lost:
        if (l.C0166.f1088 != false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0200, code lost:
        if (l.C0171.m2152() != false) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x021d, code lost:
        if (l.C0171.m2152() == false) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x025a, code lost:
        if (m2027() != false) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a5, code lost:
        if (l.C0161.f1060 == 0) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (l.C0171.f1122 <= 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015c, code lost:
        if (l.C0166.m2073() != false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a9, code lost:
        if (l.C0169.m2121() > 0) goto L_0x01bc;
     */
    public C0161() {
        try {
            byte[] r0 = C0172.m2154();
            if (C0171.f1122 == 0 || C0169.f1121 >= 0) {
                if (!C0171.m2152()) {
                }
                if (C0172.f1141 || !m2027()) {
                    DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(r0)));
                    if (C0171.f1122 != 0) {
                        C0169.m2121();
                    }
                    if (C0169.m2121() < 0) {
                        this.f1065 = C0169.m2130(dataInputStream);
                        this.f1064 = new byte[Hook.m7(dataInputStream)];
                        byte[] bArr = this.f1064;
                        int i = C0171.f1122;
                    } else {
                        this.f1065 = C0169.m2130(dataInputStream);
                        this.f1064 = new byte[Hook.m7(dataInputStream)];
                        byte[] bArr2 = this.f1064;
                        if (C0171.f1122 == 0 || !C0166.m2073()) {
                            C0166.m2080(dataInputStream, bArr2);
                            boolean r02 = C0172.m2156();
                            if (C0171.m2152() || C0171.f1122 != 0) {
                                if (!r02 || Hook.m0() >= 0) {
                                    if (C0166.m2067(dataInputStream) == 0) {
                                        this.f1066 = null;
                                        this.f1062 = null;
                                        this.f1061 = null;
                                        this.f1063 = null;
                                        return;
                                    }
                                    this.f1066 = C0169.m2130(dataInputStream);
                                    if (C0171.f1122 == 0 || f1060 >= 0) {
                                        this.f1062 = new byte[Hook.m7(dataInputStream)];
                                        byte[] bArr3 = this.f1062;
                                        if (Hook.f0 || !C0166.m2073()) {
                                            C0166.m2080(dataInputStream, bArr3);
                                            if (C0172.f1141 || m2027()) {
                                                boolean r03 = m2027();
                                                if (C0169.m2121() <= 0) {
                                                    C0169.m2121();
                                                }
                                                if (!r03 || C0169.m2121() != 0) {
                                                    this.f1061 = C0169.m2130(dataInputStream);
                                                    if (C0166.f1088 || C0169.m2121() != 0) {
                                                        if (!C0171.m2152()) {
                                                            if (m2027()) {
                                                            }
                                                        }
                                                        this.f1063 = new byte[Hook.m7(dataInputStream)];
                                                        byte[] bArr4 = this.f1063;
                                                        if (C0169.m2121() >= 0 || C0171.m2152()) {
                                                            int r2 = Hook.m0();
                                                            if (Hook.m0() < 0) {
                                                                if (f1060 != 0) {
                                                                }
                                                                m2027();
                                                            }
                                                            if (r2 <= 0) {
                                                                if (C0166.m2073()) {
                                                                }
                                                                m2027();
                                                                if (C0169.m2121() >= 0 || f1060 != 0) {
                                                                }
                                                            }
                                                            C0166.m2080(dataInputStream, bArr4);
                                                            return;
                                                        }
                                                        Hook.m0();
                                                        if (C0171.m2152()) {
                                                            C0169.m2121();
                                                        } else {
                                                            Hook.m0();
                                                            if (C0172.m2156()) {
                                                                m2027();
                                                            }
                                                        }
                                                    }
                                                    m2027();
                                                    throw new RuntimeException();
                                                }
                                            }
                                        }
                                    } else {
                                        if (!C0172.f1141) {
                                            if (m2027()) {
                                                C0171.m2152();
                                                if (m2027()) {
                                                }
                                            }
                                            m2027();
                                            Hook.m0();
                                        }
                                        m2027();
                                        if (!C0172.f1141) {
                                        }
                                        if (C0172.f1141) {
                                            if (m2027()) {
                                                C0166.m2073();
                                                if (!C0166.f1088) {
                                                    Hook.m0();
                                                    if (!Hook.f0) {
                                                        C0171.m2152();
                                                        if (C0172.f1141) {
                                                            m2027();
                                                        } else {
                                                            C0171.m2152();
                                                            if (f1060 != 0) {
                                                                C0172.m2156();
                                                            }
                                                        }
                                                        Hook.m0();
                                                        m2027();
                                                        C0169.m2121();
                                                    }
                                                }
                                            }
                                            m2027();
                                        }
                                    }
                                    m2027();
                                    if (!C0166.m2073()) {
                                        C0172.m2156();
                                    }
                                    Hook.m0();
                                    m2027();
                                    C0169.m2121();
                                }
                                C0172.m2156();
                                if (C0172.m2156()) {
                                    C0166.m2073();
                                    m2027();
                                }
                                C0171.m2152();
                                if (!Hook.f0) {
                                    C0172.m2156();
                                }
                            }
                        }
                        C0169.m2121();
                        if (!m2027()) {
                            C0171.m2152();
                        }
                        m2027();
                        if (m2027()) {
                            m2027();
                            if (C0169.f1121 != 0) {
                                C0169.m2121();
                                if (!m2027()) {
                                    C0166.m2073();
                                }
                            }
                        }
                        C0166.m2073();
                        m2027();
                        throw new RuntimeException();
                    }
                    Hook.m0();
                    throw new RuntimeException();
                }
                C0166.m2073();
                throw new RuntimeException();
            }
            C0171.m2152();
            if (!C0172.f1141) {
                m2027();
            }
            C0171.m2152();
        } catch (IOException e) {
            if (Hook.m0() < 0) {
                if (C0171.f1122 == 0 || C0169.m2121() >= 0) {
                }
            }
            throw new RuntimeException(e);
        }
        C0166.m2073();
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (m2027() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (l.C0172.f1141 != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00dd, code lost:
        if (cc.binmt.signature.Hook.f0 != false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f1, code lost:
        if (r1 != false) goto L_0x00f3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014e  */
    /* renamed from: ۤۙ۠  reason: not valid java name and contains not printable characters */
    public static Object m2028(Object obj, Object obj2, Object obj3) {
        Object invoke = ((Method) obj).invoke(obj2, (Object[]) obj3);
        if (C0166.m2073()) {
            if (C0169.f1121 == 0 || !C0172.f1141) {
                m2027();
            }
            C0171.m2152();
            if (Hook.m0() <= 0) {
                C0166.m2073();
            } else {
                Hook.m0();
                if (!m2027()) {
                    C0172.m2156();
                    C0172.m2156();
                } else {
                    m2027();
                    if (f1060 <= 0) {
                        C0166.m2073();
                    }
                }
                C0172.m2156();
                C0166.m2073();
            }
            Hook.m0();
            return null;
        }
        int r1 = C0169.m2121();
        if (C0169.f1121 != 0) {
            m2027();
        }
        if (r1 <= 0) {
            int i = C0169.f1121;
            if (!Hook.f0) {
                C0166.m2073();
            }
            if (i != 0) {
                boolean r12 = C0171.m2152();
                if (!C0166.m2073() || Hook.m0() > 0) {
                }
                if (!C0166.f1088) {
                    C0166.m2073();
                    C0172.m2156();
                }
                C0169.m2121();
                if (C0171.m2152()) {
                    C0169.m2121();
                }
                C0171.m2152();
                if (Hook.m0() <= 0) {
                }
                Hook.m0();
                return null;
            }
            if (C0169.f1121 > 0) {
                C0166.m2073();
                if (C0171.m2152() || !Hook.f0) {
                    return null;
                }
                if (C0171.f1122 != 0) {
                    if (!C0166.m2073() || !C0166.m2073()) {
                        C0169.m2121();
                    }
                    Hook.m0();
                    return null;
                }
                C0172.m2156();
                C0166.m2073();
                Hook.m0();
                if (C0172.m2156()) {
                    C0169.m2121();
                }
                return null;
            }
        }
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x020e, code lost:
        r0 = new java.lang.String(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0215, code lost:
        if (l.C0169.f1121 == 0) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021b, code lost:
        if (l.C0169.m2121() >= 0) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x021f, code lost:
        if (l.C0166.f1088 != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0221, code lost:
        l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0226, code lost:
        if (cc.binmt.signature.Hook.f0 != false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0228, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x022b, code lost:
        if (l.C0166.f1088 == false) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x022d, code lost:
        r3 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0235, code lost:
        if (l.C0172.m2156() == false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0237, code lost:
        cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x023c, code lost:
        if (l.C0172.f1141 != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x023e, code lost:
        r3 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0242, code lost:
        r1 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024a, code lost:
        if (l.C0172.m2156() != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x024c, code lost:
        r0 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0268, code lost:
        r3 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0271, code lost:
        if (l.C0171.m2152() != false) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0273, code lost:
        l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x027a, code lost:
        if (l.C0166.m2073() != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (l.C0172.f1141 == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        if (l.C0169.m2121() <= 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        r3 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (m2027() != false) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        r0 = l.C0169.m2121();
        r0 = m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r3 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00af, code lost:
        if (l.C0172.m2156() == false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
        if (l.C0166.m2073() == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        if (m2027() == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
        r0 = l.C0169.m2121();
        r0 = l.C0166.m2073();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (l.C0169.f1121 == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        r3 = l.C0171.m2152();
        r3 = m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0109, code lost:
        if (l.C0166.f1088 != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0116, code lost:
        r3 = m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011e, code lost:
        if (l.C0169.m2121() <= 0) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0127, code lost:
        r0 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015a, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0162, code lost:
        if (cc.binmt.signature.Hook.m0() < 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0164, code lost:
        r0 = m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016a, code lost:
        r3 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0172, code lost:
        if (cc.binmt.signature.Hook.m0() > 0) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0178, code lost:
        if (l.C0171.m2152() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017a, code lost:
        r0 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* renamed from: ۦۤۧ  reason: contains not printable characters */
    public static String m2029(Object obj) {
        if (Hook.f0 || C0169.m2121() != 0) {
            boolean z = Hook.f0;
            if (C0171.f1122 == 0 || !C0172.f1141) {
                if (!z) {
                    if (C0169.m2121() <= 0) {
                        if (Hook.f0 || !m2027()) {
                        }
                        m2027();
                        if (!C0166.f1088) {
                            Hook.m0();
                            C0172.m2156();
                            return null;
                        }
                        C0169.m2121();
                        C0171.m2152();
                        C0172.m2156();
                        return null;
                    }
                }
                short[] sArr = (short[]) obj;
                int length = sArr.length;
                char[] cArr = new char[length];
                while (true) {
                    int i = length - 1;
                    cArr[i] = (char) (sArr[i] ^ -16);
                    if (!C0172.f1141) {
                        if (C0172.f1141 || C0166.f1088) {
                            if (C0166.m2073()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (i != 0) {
                        if (Hook.m0() < 0 && C0166.f1088) {
                            break;
                        }
                        int i2 = i - 1;
                        cArr[i2] = (char) (sArr[i2] ^ 62);
                        if (C0169.f1121 != 0) {
                            C0169.m2121();
                            if (C0166.m2073()) {
                                break;
                            }
                        }
                        if (m2027()) {
                            if (f1060 != 0 && C0171.m2152()) {
                                break;
                            }
                            C0171.m2152();
                            if (C0172.f1141) {
                                break;
                            }
                        }
                        if (i2 != 0) {
                            if (C0169.f1121 != 0) {
                                C0172.m2156();
                            }
                            int i3 = i2 - 1;
                            cArr[i3] = (char) (sArr[i3] ^ -23);
                            if (Hook.m0() <= 0) {
                            }
                            if (i3 == 0) {
                                break;
                            }
                            length = i3 - 1;
                            cArr[length] = (char) (sArr[length] ^ -106);
                            if (m2027()) {
                                Hook.m0();
                                if (Hook.m0() > 0) {
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
                }
                C0172.m2156();
                if (C0169.f1121 != 0) {
                    C0171.m2152();
                } else {
                    Hook.m0();
                    if (!C0172.m2156()) {
                        C0171.m2152();
                        C0171.m2152();
                    }
                    Hook.m0();
                    if (C0172.m2156()) {
                        C0166.m2073();
                    }
                    if (C0172.m2156()) {
                        C0166.m2073();
                    }
                    C0166.m2073();
                    Hook.m0();
                }
            }
            Hook.m0();
            return null;
        }
        if (C0172.m2156()) {
            C0166.m2073();
        }
        m2027();
        if (!C0166.f1088) {
        }
        C0169.m2121();
        C0171.m2152();
        C0172.m2156();
        return null;
    }
}
