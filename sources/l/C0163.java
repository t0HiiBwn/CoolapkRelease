package l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import cc.binmt.signature.Hook;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* renamed from: l.۟ۖۙ  reason: contains not printable characters */
public class C0163 implements InvocationHandler {

    /* renamed from: ۧۖۡ  reason: not valid java name and contains not printable characters */
    private static final int f1067 = 64;

    /* renamed from: ۙۛۖ  reason: not valid java name and contains not printable characters */
    private byte[] f1068;

    /* renamed from: ۚ۫ۖ  reason: not valid java name and contains not printable characters */
    private Object f1069;

    /* renamed from: ۛۨۥ  reason: not valid java name and contains not printable characters */
    private String f1070;

    /* renamed from: ۚۧۡ  reason: not valid java name and contains not printable characters */
    public static void m2034(Context context, byte[] bArr) {
        new C0163(context, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006a, code lost:
        if (l.C0166.f1088 != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0279, code lost:
        if (cc.binmt.signature.Hook.m0() > 0) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0284, code lost:
        if (l.C0169.f1121 == 0) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ec, code lost:
        if (l.C0169.m2121() != 0) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ff, code lost:
        if (l.C0172.m2156() == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a4, code lost:
        if (l.C0161.f1060 != 0) goto L_0x01a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0143  */
    @SuppressLint({"PrivateApi"})
    private C0163(Context context, byte[] bArr) {
        ClassLoader r0 = Hook.m8();
        try {
            short[] r1 = C0161.m2026(26);
            // fill-array-data instruction
            r1[0] = -115;
            r1[1] = -118;
            r1[2] = 2;
            r1[3] = -98;
            r1[4] = -117;
            r1[5] = 15;
            r1[6] = -120;
            r1[7] = -54;
            r1[8] = 7;
            r1[9] = -100;
            r1[10] = -108;
            r1[11] = 72;
            r1[12] = -83;
            r1[13] = -121;
            r1[14] = 18;
            r1[15] = -123;
            r1[16] = -110;
            r1[17] = 15;
            r1[18] = -104;
            r1[19] = -99;
            r1[20] = 50;
            r1[21] = -124;
            r1[22] = -106;
            r1[23] = 3;
            r1[24] = -115;
            r1[25] = -128;
            Class r12 = C0166.m2076(C0172.m2164(r1), true, r0);
            short[] r3 = C0161.m2026(21);
            // fill-array-data instruction
            r3[0] = 5;
            r3[1] = -103;
            r3[2] = -106;
            r3[3] = 20;
            r3[4] = -119;
            r3[5] = -118;
            r3[6] = 18;
            r3[7] = -83;
            r3[8] = -121;
            r3[9] = 18;
            r3[10] = -123;
            r3[11] = -110;
            r3[12] = 15;
            r3[13] = -104;
            r3[14] = -99;
            r3[15] = 50;
            r3[16] = -124;
            r3[17] = -106;
            r3[18] = 3;
            r3[19] = -115;
            r3[20] = -128;
            if (!C0172.m2156() || !C0172.m2156()) {
                Object r32 = C0161.m2028(Hook.m5(r12, C0172.m2164(r3), new Class[0]), null, new Object[0]);
                short[] r5 = C0161.m2026(15);
                // fill-array-data instruction
                r5[0] = -19;
                r5[1] = -50;
                r5[2] = -1;
                r5[3] = -3;
                r5[4] = -11;
                r5[5] = -1;
                r5[6] = -7;
                r5[7] = -5;
                r5[8] = -45;
                r5[9] = -1;
                r5[10] = -16;
                r5[11] = -1;
                r5[12] = -7;
                r5[13] = -5;
                r5[14] = -20;
                Field r13 = C0169.m2118(r12, C0166.m2070(r5));
                if (C0172.m2156()) {
                    C0166.m2073();
                }
                if (!C0172.f1141) {
                }
                C0166.m2078(r13, true);
                Object r52 = C0166.m2075(r13, r32);
                if (Hook.f0 || C0171.f1122 <= 0) {
                    if (C0161.f1060 == 0 || !Hook.f0) {
                        if (C0169.m2121() < 0) {
                            if (C0169.f1121 == 0 || C0172.m2156()) {
                                if (C0172.f1141) {
                                    C0166.m2073();
                                    if (C0161.f1060 != 0) {
                                        Hook.m0();
                                        C0161.m2027();
                                    }
                                    Hook.m0();
                                    if (C0161.m2027()) {
                                        if (C0161.m2027()) {
                                        }
                                        C0169.m2121();
                                        C0161.m2027();
                                        if (C0172.f1141) {
                                        }
                                        if (C0166.m2073()) {
                                            C0172.m2156();
                                            C0166.m2073();
                                            throw new RuntimeException();
                                        }
                                        C0161.m2027();
                                        if (C0166.m2073()) {
                                            C0171.m2152();
                                        }
                                        C0172.m2156();
                                        Hook.m0();
                                        C0172.m2156();
                                        C0166.m2073();
                                        throw new RuntimeException();
                                    }
                                    C0161.m2027();
                                    if (!C0171.m2152()) {
                                        C0172.m2156();
                                    }
                                    if (!C0172.f1141) {
                                        C0169.m2121();
                                    }
                                    if (C0166.m2073()) {
                                        C0171.m2152();
                                    }
                                    C0161.m2027();
                                    if (C0172.f1141) {
                                    }
                                    if (C0166.m2073()) {
                                    }
                                    C0161.m2027();
                                    if (C0166.m2073()) {
                                    }
                                    C0172.m2156();
                                    Hook.m0();
                                    C0172.m2156();
                                    C0166.m2073();
                                    throw new RuntimeException();
                                }
                            }
                            C0161.m2027();
                            C0161.m2027();
                        }
                        short[] r6 = C0161.m2026(34);
                        // fill-array-data instruction
                        r6[0] = -72;
                        r6[1] = 42;
                        r6[2] = 80;
                        r6[3] = 78;
                        r6[4] = 118;
                        r6[5] = -80;
                        r6[6] = 32;
                        r6[7] = 26;
                        r6[8] = 95;
                        r6[9] = 118;
                        r6[10] = -73;
                        r6[11] = 48;
                        r6[12] = 81;
                        r6[13] = 82;
                        r6[14] = 109;
                        r6[15] = -9;
                        r6[16] = 52;
                        r6[17] = 89;
                        r6[18] = 18;
                        r6[19] = 80;
                        r6[20] = -119;
                        r6[21] = 37;
                        r6[22] = 87;
                        r6[23] = 87;
                        r6[24] = 120;
                        r6[25] = -66;
                        r6[26] = 33;
                        r6[27] = 121;
                        r6[28] = 93;
                        r6[29] = 119;
                        r6[30] = -72;
                        r6[31] = 35;
                        r6[32] = 81;
                        r6[33] = 78;
                        if (!C0166.m2073() || C0171.m2152()) {
                            Class r02 = C0166.m2076(Hook.m1(r6), true, r0);
                            if (Hook.f0 || !C0171.m2152()) {
                                short[] r62 = C0161.m2026(4);
                                // fill-array-data instruction
                                r62[0] = -27;
                                r62[1] = -72;
                                r62[2] = -115;
                                r62[3] = -76;
                                if (C0172.m2156()) {
                                    if (C0166.m2073() && !C0166.f1088) {
                                        C0172.m2156();
                                        if (!C0172.m2156()) {
                                            C0169.m2121();
                                        }
                                        C0171.m2152();
                                        if (C0172.m2156()) {
                                            C0172.m2156();
                                        } else {
                                            C0166.m2073();
                                            C0172.m2156();
                                        }
                                        Hook.m0();
                                        throw new RuntimeException();
                                    }
                                }
                                String r63 = C0171.m2148(r62);
                                if (C0169.m2121() < 0) {
                                    C0172.m2156();
                                }
                                CertificateFactory r64 = Hook.m4(r63);
                                if (C0166.f1088 || C0172.f1141) {
                                    X509Certificate x509Certificate = (X509Certificate) C0172.m2158(r64, new ByteArrayInputStream(bArr));
                                    this.f1069 = r52;
                                    if (C0169.m2121() > 0 || Hook.m0() < 0) {
                                        if (C0169.f1121 == 0 || Hook.m0() != 0) {
                                            this.f1068 = C0171.m2149(x509Certificate);
                                            if (Hook.m0() > 0 || !C0161.m2027()) {
                                                this.f1070 = C0166.m2077(context);
                                                if (C0166.m2073()) {
                                                    C0166.m2073();
                                                }
                                                ClassLoader r10 = C0171.m2150(r02);
                                                Class[] clsArr = {r02};
                                                if (C0161.m2027()) {
                                                }
                                                Object r102 = C0169.m2119(r10, clsArr, this);
                                                Hook.m2(r13, r32, r102);
                                                if (C0169.f1121 == 0 || C0171.f1122 != 0) {
                                                    PackageManager r9 = C0169.m2127(context);
                                                    if (C0161.m2027()) {
                                                        if (C0172.f1141 || Hook.f0) {
                                                            Hook.m0();
                                                        }
                                                        C0171.m2152();
                                                        if (C0172.m2156()) {
                                                        }
                                                    }
                                                    Class r03 = C0171.m2143(r9);
                                                    short[] r14 = C0161.m2026(3);
                                                    // fill-array-data instruction
                                                    r14[0] = 44;
                                                    r14[1] = 17;
                                                    r14[2] = 12;
                                                    Field r04 = C0169.m2118(r03, C0169.m2124(r14));
                                                    C0166.m2078(r04, true);
                                                    Hook.m2(r04, r9, r102);
                                                    if (!C0166.f1088) {
                                                    }
                                                    if (C0169.f1121 == 0 || !C0166.f1088) {
                                                        PrintStream printStream = System.out;
                                                        if (C0169.m2121() > 0 || C0161.m2027()) {
                                                            short[] r103 = C0161.m2026(15);
                                                            // fill-array-data instruction
                                                            r103[0] = -50;
                                                            r103[1] = -45;
                                                            r103[2] = -42;
                                                            r103[3] = -15;
                                                            r103[4] = -15;
                                                            r103[5] = -11;
                                                            r103[6] = -66;
                                                            r103[7] = -19;
                                                            r103[8] = -21;
                                                            r103[9] = -3;
                                                            r103[10] = -3;
                                                            r103[11] = -5;
                                                            r103[12] = -19;
                                                            r103[13] = -19;
                                                            r103[14] = -80;
                                                            if (Hook.m0() <= 0) {
                                                            }
                                                            C0166.m2069(printStream, C0166.m2070(r103));
                                                            return;
                                                        }
                                                        C0161.m2027();
                                                        if (C0172.f1141) {
                                                        }
                                                        if (C0166.m2073()) {
                                                        }
                                                        C0161.m2027();
                                                        if (C0166.m2073()) {
                                                        }
                                                        C0172.m2156();
                                                        Hook.m0();
                                                        C0172.m2156();
                                                        C0166.m2073();
                                                        throw new RuntimeException();
                                                    }
                                                    C0166.m2073();
                                                    if (C0161.m2027()) {
                                                        C0166.m2073();
                                                        C0172.m2156();
                                                    }
                                                    C0161.m2027();
                                                    C0161.m2027();
                                                }
                                            }
                                            Hook.m0();
                                            throw new RuntimeException();
                                        }
                                        Hook.m0();
                                        if (C0161.m2027()) {
                                        }
                                    }
                                }
                            }
                            C0161.m2027();
                            if (!C0171.m2152()) {
                            }
                            if (!C0172.f1141) {
                            }
                            if (C0166.m2073()) {
                            }
                            C0161.m2027();
                            if (C0172.f1141) {
                            }
                            if (C0166.m2073()) {
                            }
                            C0161.m2027();
                            if (C0166.m2073()) {
                            }
                            C0172.m2156();
                            Hook.m0();
                            C0172.m2156();
                            C0166.m2073();
                            throw new RuntimeException();
                        }
                        C0172.m2156();
                        if (C0166.f1088) {
                            Hook.m0();
                            C0161.m2027();
                            C0161.m2027();
                        }
                        C0166.m2073();
                        if (C0161.m2027() || C0169.m2121() >= 0) {
                            if (C0169.m2121() > 0) {
                                C0169.m2121();
                                C0161.m2027();
                                C0161.m2027();
                            }
                            C0166.m2073();
                            if (C0161.m2027()) {
                            }
                            C0161.m2027();
                            C0161.m2027();
                        } else {
                            C0166.m2073();
                            if (C0161.m2027()) {
                                C0171.m2152();
                            }
                        }
                    }
                    C0161.m2027();
                    throw new RuntimeException();
                }
                C0161.m2027();
                if (C0169.f1121 <= 0) {
                    C0172.m2156();
                    C0161.m2027();
                    Hook.m0();
                    throw new RuntimeException();
                }
                C0171.m2152();
                if (C0172.m2156()) {
                }
                Hook.m0();
                throw new RuntimeException();
            }
            if (!C0166.f1088) {
                C0169.m2121();
                C0166.m2073();
            }
            C0166.m2073();
            if (C0161.m2027()) {
            }
            if (C0169.m2121() > 0) {
            }
            C0166.m2073();
            if (C0161.m2027()) {
            }
            C0161.m2027();
            C0161.m2027();
            C0161.m2027();
            throw new RuntimeException();
        } catch (Exception e) {
            PrintStream printStream2 = System.err;
            short[] r05 = C0161.m2026(14);
            // fill-array-data instruction
            r05[0] = -19;
            r05[1] = -64;
            r05[2] = -11;
            r05[3] = -30;
            r05[4] = -46;
            r05[5] = -26;
            r05[6] = -99;
            r05[7] = -21;
            r05[8] = -36;
            r05[9] = -28;
            r05[10] = -47;
            r05[11] = -24;
            r05[12] = -39;
            r05[13] = -93;
            C0166.m2069(printStream2, C0171.m2148(r05));
            C0172.m2159(e);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x020b: APUT  
      (r6v26 android.content.pm.Signature[])
      (0 ??[int, short, byte, char])
      (wrap: android.content.pm.Signature : 0x0208: CONSTRUCTOR  (r0v50 android.content.pm.Signature) = (wrap: byte[] : 0x0206: IGET  (r1v11 byte[]) = (r3v0 'this' l.۟ۖۙ A[IMMUTABLE_TYPE, THIS]) l.۟ۖۙ.ۙۛۖ byte[]) call: android.content.pm.Signature.<init>(byte[]):void type: CONSTRUCTOR)
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c8, code lost:
        r1 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d0, code lost:
        if (l.C0161.m2027() != false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01d2, code lost:
        r1 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x022c, code lost:
        if (l.C0161.m2027() != false) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0282, code lost:
        if (cc.binmt.signature.Hook.m0() < 0) goto L_0x0284;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (l.C0161.m2027() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02a2, code lost:
        r3 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02a8, code lost:
        if (l.C0161.f1060 != 0) goto L_0x02ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02aa, code lost:
        r3 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02ae, code lost:
        r3 = l.C0172.m2156();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02b4, code lost:
        if (l.C0161.f1060 != 0) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b6, code lost:
        r0 = cc.binmt.signature.Hook.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02c1, code lost:
        r6 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02c7, code lost:
        if (l.C0171.f1122 == 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c9, code lost:
        r0 = l.C0169.m2121();
        r0 = l.C0161.m2027();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (l.C0172.m2156() != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        if (l.C0171.f1122 != 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (l.C0161.f1060 <= 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c1, code lost:
        if (cc.binmt.signature.Hook.f0 != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d9, code lost:
        if (l.C0161.f1060 == 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00db, code lost:
        r6 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00df, code lost:
        r1 = l.C0169.m2121();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e5, code lost:
        if (l.C0172.f1141 != false) goto L_0x02a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (l.C0166.m2073() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e7, code lost:
        r0 = l.C0171.m2152();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (l.C0172.f1141 == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x018e, code lost:
        if (l.C0161.m2027() != false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0192, code lost:
        if (l.C0171.f1122 != 0) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x019d, code lost:
        if (l.C0161.f1060 == 0) goto L_0x01bf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String r4 = C0169.m2129(method);
        short[] r0 = C0161.m2026(14);
        // fill-array-data instruction
        r0[0] = 38;
        r0[1] = 36;
        r0[2] = 53;
        r0[3] = 17;
        r0[4] = 32;
        r0[5] = 34;
        r0[6] = 42;
        r0[7] = 32;
        r0[8] = 38;
        r0[9] = 36;
        r0[10] = 8;
        r0[11] = 47;
        r0[12] = 39;
        r0[13] = 46;
        if (!Hook.f0) {
            if (C0171.f1122 != 0) {
                Hook.m0();
            }
        }
        String r02 = C0169.m2124(r0);
        if (!C0172.f1141) {
            if (!C0171.m2152()) {
                C0166.m2073();
            }
        }
        boolean r42 = C0169.m2123(r02, r4);
        if (!C0171.m2152()) {
            if (!C0166.f1088) {
                C0172.m2156();
            }
            if (C0166.m2073()) {
                C0171.m2152();
            }
        }
        if (r42) {
            Object obj2 = objArr[0];
            if (!C0172.m2156() || C0166.f1088) {
                String str = (String) obj2;
                if ((C0171.m2147((Integer) objArr[1]) & 64) != 0 && C0169.m2123(this.f1070, str)) {
                    if (Hook.m0() <= 0) {
                        ((PackageInfo) C0161.m2028(method, this.f1069, objArr)).signatures = new Signature[]{new Signature(this.f1068)};
                        Hook.m0();
                        if (!C0161.m2027() || !C0171.m2152()) {
                            if (!C0166.f1088) {
                                if (!C0171.m2152()) {
                                }
                                C0172.m2156();
                                C0171.m2152();
                            }
                            Hook.m0();
                            if (C0169.m2121() > 0) {
                                C0172.m2156();
                                if (C0169.m2121() < 0) {
                                }
                                Hook.m0();
                            } else if (C0161.f1060 >= 0) {
                                C0171.m2152();
                                if (!C0166.m2073() || C0161.m2027()) {
                                    Hook.m0();
                                }
                                C0171.m2152();
                                C0172.m2156();
                                C0161.m2027();
                                return null;
                            }
                            Hook.m0();
                            if (C0166.f1088 || !C0166.m2073()) {
                                C0169.m2121();
                                C0169.m2121();
                                if (C0169.m2121() > 0 || C0172.m2156()) {
                                    return null;
                                }
                                C0169.m2121();
                                if (C0172.m2156()) {
                                    C0166.m2073();
                                    C0171.m2152();
                                }
                            }
                            C0166.m2073();
                            if (C0166.m2073()) {
                                C0171.m2152();
                                C0172.m2156();
                                return null;
                            }
                        }
                        Hook.m0();
                        C0166.m2073();
                        C0172.m2156();
                        C0172.m2156();
                        return null;
                    }
                    Object obj3 = this.f1069;
                    if (C0171.m2152() || C0166.m2073()) {
                        if (!C0161.m2027() || !C0161.m2027()) {
                            Object r5 = C0161.m2028(method, obj3, objArr);
                            if (Hook.m0() < 0) {
                                if (Hook.m0() < 0) {
                                    C0172.m2156();
                                }
                            }
                            if (C0169.f1121 != 0) {
                                Hook.m0();
                            }
                            PackageInfo packageInfo = (PackageInfo) r5;
                            Signature[] signatureArr = new Signature[1];
                            if (C0169.f1121 == 0 || C0171.m2152()) {
                                signatureArr[0] = new Signature(this.f1068);
                                packageInfo.signatures = signatureArr;
                                if (!C0171.m2152()) {
                                    C0172.m2156();
                                }
                                return packageInfo;
                            }
                        }
                        Hook.m0();
                        if (C0169.m2121() > 0) {
                        }
                        Hook.m0();
                        C0169.m2121();
                        C0169.m2121();
                        return null;
                    }
                    C0166.m2073();
                    if (!C0166.m2073()) {
                        if (C0166.m2073()) {
                            C0161.m2027();
                        }
                        C0161.m2027();
                        C0166.m2073();
                        if (C0166.m2073()) {
                        }
                        Hook.m0();
                        C0166.m2073();
                        C0172.m2156();
                        C0172.m2156();
                        return null;
                    }
                    C0169.m2121();
                    if (C0172.m2156()) {
                    }
                    C0166.m2073();
                    if (C0166.m2073()) {
                    }
                    Hook.m0();
                    C0166.m2073();
                    C0172.m2156();
                    C0172.m2156();
                    return null;
                }
            }
            Hook.m0();
            if (C0169.m2121() < 0) {
            }
            if (C0169.f1121 != 0) {
                C0166.m2073();
            }
            Hook.m0();
            if (C0169.m2121() > 0) {
            }
            Hook.m0();
            C0169.m2121();
            C0169.m2121();
            return null;
        }
        Object obj4 = this.f1069;
        if (C0166.f1088 || C0171.m2152()) {
            if (C0166.f1088 || Hook.m0() != 0) {
                Object r43 = C0161.m2028(method, obj4, objArr);
                if (!C0161.m2027() || C0171.m2152()) {
                    if (C0171.f1122 != 0) {
                        if (C0166.f1088 || C0169.m2121() < 0) {
                        }
                        C0161.m2027();
                        return null;
                    }
                    return r43;
                }
            }
            C0161.m2027();
            if (C0161.f1060 >= 0) {
                if (!C0172.f1141) {
                    C0166.m2073();
                }
                C0166.m2073();
            }
            Hook.m0();
            if (!C0166.f1088) {
            }
            Hook.m0();
            if (C0169.m2121() > 0) {
            }
            Hook.m0();
            C0169.m2121();
            C0169.m2121();
            return null;
        }
        if (C0171.m2152()) {
            C0166.m2073();
            C0166.m2073();
        }
        C0169.m2121();
        if (C0172.m2156()) {
        }
        C0166.m2073();
        if (C0166.m2073()) {
        }
        Hook.m0();
        C0166.m2073();
        C0172.m2156();
        C0172.m2156();
        return null;
    }
}
