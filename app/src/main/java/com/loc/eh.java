package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.zip.CRC32;

/* compiled from: Req */
public final class eh {
    protected static String J;
    protected static String L;
    protected String A = null;
    protected String B = null;
    protected ArrayList<dv> C = new ArrayList<>();
    protected String D = null;
    protected String E = null;
    protected ArrayList<ScanResult> F = new ArrayList<>();
    protected String G = null;
    protected String H = null;
    protected byte[] I = null;
    protected String K = null;
    protected String M = null;
    protected String N = null;
    private byte[] O = null;
    private int P = 0;
    public String a = "1";
    protected short b = 0;
    protected String c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;

    /* renamed from: l  reason: collision with root package name */
    protected String f1374l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;

    private static int a(String str, byte[] bArr, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i2] = 0;
                return i2 + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i2] = (byte) length;
            int i3 = i2 + 1;
            System.arraycopy(bytes, 0, bArr, i3, length);
            return i3 + length;
        } catch (Throwable th) {
            ej.a(th, "Req", "copyContentWithByteLen");
            bArr[i2] = 0;
        }
    }

    private String a(String str, int i2) {
        String[] split = this.B.split("\\*")[i2].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    private byte[] a(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[6];
        if (split != null) {
            try {
            } catch (Throwable th) {
                ej.a(th, "Req", "getMacBa " + str);
                return a("00:00:00:00:00:00");
            }
        }
        split = new String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            split[i2] = "0";
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].length() > 2) {
                split[i3] = split[i3].substring(0, 2);
            }
            bArr[i3] = (byte) Integer.parseInt(split[i3], 16);
        }
        return bArr;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(this.A)) {
            return "0";
        }
        String str2 = this.A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + ">");
        String str4 = this.A;
        return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    public final void a(Context context, boolean z2, boolean z3, dw dwVar, dx dxVar, ConnectivityManager connectivityManager, String str) {
        String str2;
        String str3;
        String str4;
        int i2;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<ScanResult> arrayList;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        ArrayList<ScanResult> arrayList2;
        int i3;
        String f2 = k.f(context);
        int d2 = ep.d();
        this.K = str;
        if (!z3) {
            str3 = "UC_nlp_20131029";
            str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str3 = "api_serverSDK_130905";
            str2 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        StringBuilder sb = new StringBuilder();
        int e2 = dwVar.e();
        int f3 = dwVar.f();
        TelephonyManager g2 = dwVar.g();
        ArrayList<dv> b2 = dwVar.b();
        ArrayList<dv> c2 = dwVar.c();
        ArrayList<ScanResult> e3 = dxVar.e();
        String str12 = f3 == 2 ? "1" : "0";
        if (g2 != null) {
            if (TextUtils.isEmpty(ej.e)) {
                try {
                    ej.e = n.x(context);
                } catch (Throwable th) {
                    str4 = "1";
                    ej.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            i2 = d2;
            if (TextUtils.isEmpty(ej.e) && Build.VERSION.SDK_INT < 29) {
                ej.e = "888888888888888";
            }
            if (TextUtils.isEmpty(ej.f)) {
                try {
                    ej.f = n.A(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    ej.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(ej.f) && Build.VERSION.SDK_INT < 29) {
                ej.f = "888888888888888";
            }
        } else {
            i2 = d2;
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            ej.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a2 = dxVar.a(connectivityManager);
        if (ep.a(networkInfo) != -1) {
            str6 = ep.b(g2);
            str5 = a2 ? "2" : str4;
        } else {
            str6 = "";
            str5 = str6;
        }
        if (!b2.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            str10 = f2;
            str9 = "0";
            str8 = str2;
            str7 = str3;
            if (f3 == 1) {
                dv dvVar = b2.get(0);
                arrayList = e3;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(dvVar.a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(dvVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(dvVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(dvVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(dvVar.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                for (int i4 = 1; i4 < b2.size(); i4++) {
                    dv dvVar2 = b2.get(i4);
                    sb.append(dvVar2.c);
                    sb.append(",");
                    sb.append(dvVar2.d);
                    sb.append(",");
                    sb.append(dvVar2.j);
                    if (i4 < b2.size() - 1) {
                        sb.append("*");
                    }
                }
            } else if (f3 != 2) {
                arrayList = e3;
                str11 = "";
            } else {
                dv dvVar3 = b2.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(dvVar3.a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(dvVar3.g);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(dvVar3.h);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(dvVar3.i);
                sb2.append("</bid>");
                if (dvVar3.f > 0 && dvVar3.e > 0) {
                    sb2.append("<lon>");
                    sb2.append(dvVar3.f);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(dvVar3.e);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(dvVar3.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                arrayList = e3;
            }
            sb2.delete(0, sb2.length());
        } else {
            str10 = f2;
            str7 = str3;
            str8 = str2;
            arrayList = e3;
            str9 = "0";
            str11 = "";
        }
        if ((e2 & 4) != 4 || c2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(c2);
        }
        StringBuilder sb3 = new StringBuilder();
        if (dxVar.q) {
            if (a2) {
                WifiInfo k2 = dxVar.k();
                if (dx.a(k2)) {
                    sb3.append(k2.getBSSID());
                    sb3.append(",");
                    int rssi = k2.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = k2.getSSID();
                    try {
                        i3 = k2.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i3 = 32;
                    }
                    if (i3 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            }
            if (!(arrayList == null || (arrayList2 = this.F) == null)) {
                arrayList2.clear();
                this.F.addAll(arrayList);
            }
        } else {
            dxVar.g();
            ArrayList<ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = 0;
        if (!z2) {
            this.b = (short) (2 | 0);
        }
        this.c = str7;
        this.d = str8;
        this.f = Build.MODEL;
        this.g = "android" + Build.VERSION.RELEASE;
        this.h = ep.b(context);
        this.i = str12;
        this.j = str9;
        this.k = str9;
        this.f1374l = str9;
        this.m = str9;
        this.n = str9;
        this.o = str10;
        this.p = ej.e;
        this.q = ej.f;
        this.s = String.valueOf(i2);
        this.t = ep.j(context);
        this.v = "5.2.0";
        this.w = null;
        this.u = "";
        this.x = str6;
        this.y = str5;
        this.z = e2;
        this.A = str11;
        this.B = sb.toString();
        this.D = dwVar.l();
        this.G = dx.o();
        this.E = sb3.toString();
        try {
            if (TextUtils.isEmpty(J)) {
                J = n.h(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(L)) {
                L = n.a(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = n.i(context);
            }
        } catch (Throwable unused5) {
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0553, code lost:
        if (r15 < -128) goto L_0x054f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x05b8 A[Catch:{ all -> 0x05cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x05bb A[Catch:{ all -> 0x05cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x05bf A[Catch:{ all -> 0x05cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x05de A[Catch:{ all -> 0x05fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x05ef A[SYNTHETIC, Splitter:B:218:0x05ef] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0614  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0616  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x033b A[ADDED_TO_REGION] */
    public final byte[] a() {
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        int i5;
        byte b2;
        int i6;
        int i7;
        int i8;
        int min;
        String str3;
        int i9;
        int i10;
        int i11;
        byte[] bArr;
        int i12;
        int i13;
        int length;
        boolean isEmpty;
        int i14;
        byte[] bytes;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int parseInt;
        int length2;
        int length3;
        String[] strArr = {this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.f1374l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.A, this.B, this.E, this.G, this.H, J, this.N};
        for (int i22 = 0; i22 < 28; i22++) {
            if (TextUtils.isEmpty(strArr[i22])) {
                strArr[i22] = "";
            }
        }
        if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!dw.a(this.z)) {
            this.z = 0;
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
        byte[] bArr2 = new byte[2];
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = this.I;
        int i23 = 4096;
        if (bArr4 != null) {
            i23 = 4096 + bArr4.length + 1;
        }
        byte[] bArr5 = this.O;
        if (bArr5 == null || i23 > this.P) {
            bArr5 = new byte[i23];
            this.O = bArr5;
            this.P = i23;
        }
        bArr5[0] = ep.i(this.a);
        byte[] a2 = ep.a(this.b, (byte[]) null);
        System.arraycopy(a2, 0, bArr5, 1, a2.length);
        int a3 = a(this.q, bArr5, a(this.p, bArr5, a(this.h, bArr5, a(this.u, bArr5, a(this.g, bArr5, a(this.f, bArr5, a(this.e, bArr5, a(this.o, bArr5, a(this.d, bArr5, a(this.c, bArr5, a2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.t)) {
                bArr5[a3] = 0;
                i2 = a3 + 1;
                int a4 = a(this.x, bArr5, a(L, bArr5, a(J, bArr5, a(this.w, bArr5, a(this.v, bArr5, i2)))));
                bArr5[a4] = Byte.parseByte(this.y);
                int i24 = a4 + 1;
                bArr5[i24] = Byte.parseByte(this.j);
                int i25 = i24 + 1;
                int i26 = this.z;
                i3 = i26 & 3;
                bArr5[i25] = (byte) i26;
                i4 = i25 + 1;
                if (i3 == 1 || i3 == 2) {
                    byte[] b3 = ep.b(b("mcc"));
                    System.arraycopy(b3, 0, bArr5, i4, b3.length);
                    int length4 = i4 + b3.length;
                    if (i3 != 1) {
                        byte[] b4 = ep.b(b("mnc"));
                        System.arraycopy(b4, 0, bArr5, length4, b4.length);
                        int length5 = length4 + b4.length;
                        byte[] b5 = ep.b(b("lac"));
                        System.arraycopy(b5, 0, bArr5, length5, b5.length);
                        length2 = length5 + b5.length;
                        byte[] c2 = ep.c(b("cellid"));
                        System.arraycopy(c2, 0, bArr5, length2, c2.length);
                        length3 = c2.length;
                    } else {
                        if (i3 == 2) {
                            byte[] b6 = ep.b(b("sid"));
                            System.arraycopy(b6, 0, bArr5, length4, b6.length);
                            int length6 = length4 + b6.length;
                            byte[] b7 = ep.b(b("nid"));
                            System.arraycopy(b7, 0, bArr5, length6, b7.length);
                            int length7 = length6 + b7.length;
                            byte[] b8 = ep.b(b("bid"));
                            System.arraycopy(b8, 0, bArr5, length7, b8.length);
                            int length8 = length7 + b8.length;
                            byte[] c3 = ep.c(b("lon"));
                            System.arraycopy(c3, 0, bArr5, length8, c3.length);
                            length2 = length8 + c3.length;
                            byte[] c4 = ep.c(b("lat"));
                            System.arraycopy(c4, 0, bArr5, length2, c4.length);
                            length3 = c4.length;
                        }
                        parseInt = Integer.parseInt(b("signal"));
                        if (parseInt > 127 || parseInt < -128) {
                            parseInt = 0;
                        }
                        bArr5[length4] = (byte) parseInt;
                        int i27 = length4 + 1;
                        byte[] a5 = ep.a(0, bArr2);
                        System.arraycopy(a5, 0, bArr5, i27, a5.length);
                        i4 = i27 + 2;
                        if (i3 == 1) {
                            if (TextUtils.isEmpty(this.B)) {
                                bArr5[i4] = 0;
                            } else {
                                int length9 = this.B.split("\\*").length;
                                bArr5[i4] = (byte) length9;
                                i4++;
                                for (int i28 = 0; i28 < length9; i28++) {
                                    byte[] b9 = ep.b(a("lac", i28));
                                    System.arraycopy(b9, 0, bArr5, i4, b9.length);
                                    int length10 = i4 + b9.length;
                                    byte[] c5 = ep.c(a("cellid", i28));
                                    System.arraycopy(c5, 0, bArr5, length10, c5.length);
                                    int length11 = length10 + c5.length;
                                    int parseInt2 = Integer.parseInt(a("signal", i28));
                                    if (parseInt2 > 127 || parseInt2 < -128) {
                                        parseInt2 = 0;
                                    }
                                    bArr5[length11] = (byte) parseInt2;
                                    i4 = length11 + 1;
                                }
                            }
                        } else if (i3 == 2) {
                            bArr5[i4] = 0;
                        }
                        i4++;
                    }
                    length4 = length2 + length3;
                    parseInt = Integer.parseInt(b("signal"));
                    parseInt = 0;
                    bArr5[length4] = (byte) parseInt;
                    int i27 = length4 + 1;
                    byte[] a5 = ep.a(0, bArr2);
                    System.arraycopy(a5, 0, bArr5, i27, a5.length);
                    i4 = i27 + 2;
                    if (i3 == 1) {
                    }
                    i4++;
                }
                str = this.D;
                str2 = "GBK";
                if (str != null && (this.z & 8) == 8) {
                    try {
                        byte[] bytes2 = str.getBytes(str2);
                        int min2 = Math.min(bytes2.length, 60);
                        bArr5[i4] = (byte) min2;
                        i4++;
                        System.arraycopy(bytes2, 0, bArr5, i4, min2);
                        i5 = i4 + min2;
                    } catch (Exception unused) {
                    }
                    ArrayList<dv> arrayList = this.C;
                    int size = arrayList.size();
                    if ((this.z & 4) == 4 || size <= 0) {
                        bArr5[i5] = 0;
                        b2 = 1;
                        i6 = i5 + 1;
                    } else {
                        if (!arrayList.get(0).p) {
                            size--;
                        }
                        bArr5[i5] = (byte) size;
                        int i29 = 1;
                        i6 = i5 + 1;
                        int i30 = 0;
                        while (i30 < size) {
                            dv dvVar = arrayList.get(i30);
                            if (dvVar.p) {
                                if (dvVar.k == i29 || dvVar.k == 3 || dvVar.k == 4) {
                                    byte b10 = (byte) dvVar.k;
                                    if (dvVar.n) {
                                        b10 = (byte) (b10 | 8);
                                    }
                                    bArr5[i6] = b10;
                                    int i31 = i6 + 1;
                                    byte[] a6 = ep.a(dvVar.a, bArr2);
                                    System.arraycopy(a6, 0, bArr5, i31, a6.length);
                                    int length12 = i31 + a6.length;
                                    byte[] a7 = ep.a(dvVar.b, bArr2);
                                    System.arraycopy(a7, 0, bArr5, length12, a7.length);
                                    int length13 = length12 + a7.length;
                                    byte[] a8 = ep.a(dvVar.c, bArr2);
                                    System.arraycopy(a8, 0, bArr5, length13, a8.length);
                                    i21 = length13 + a8.length;
                                    byte[] b11 = ep.b(dvVar.d, bArr3);
                                    System.arraycopy(b11, 0, bArr5, i21, b11.length);
                                    i20 = b11.length;
                                } else {
                                    if (dvVar.k == 2) {
                                        byte b12 = (byte) dvVar.k;
                                        if (dvVar.n) {
                                            b12 = (byte) (b12 | 8);
                                        }
                                        bArr5[i6] = b12;
                                        int i32 = i6 + 1;
                                        byte[] a9 = ep.a(dvVar.a, bArr2);
                                        System.arraycopy(a9, 0, bArr5, i32, a9.length);
                                        int length14 = i32 + a9.length;
                                        byte[] a10 = ep.a(dvVar.g, bArr2);
                                        System.arraycopy(a10, 0, bArr5, length14, a10.length);
                                        int length15 = length14 + a10.length;
                                        byte[] a11 = ep.a(dvVar.h, bArr2);
                                        System.arraycopy(a11, 0, bArr5, length15, a11.length);
                                        int length16 = length15 + a11.length;
                                        byte[] a12 = ep.a(dvVar.i, bArr2);
                                        System.arraycopy(a12, 0, bArr5, length16, a12.length);
                                        int length17 = length16 + a12.length;
                                        byte[] b13 = ep.b(dvVar.f, bArr3);
                                        System.arraycopy(b13, 0, bArr5, length17, b13.length);
                                        i21 = length17 + b13.length;
                                        byte[] b14 = ep.b(dvVar.e, bArr3);
                                        System.arraycopy(b14, 0, bArr5, i21, b14.length);
                                        i20 = b14.length;
                                    }
                                    i19 = dvVar.j;
                                    if (i19 > 127 || i19 < -128) {
                                        i19 = 99;
                                    }
                                    bArr5[i6] = (byte) i19;
                                    int i33 = i6 + 1;
                                    byte[] a13 = ep.a(dvVar.f1367l, bArr2);
                                    System.arraycopy(a13, 0, bArr5, i33, a13.length);
                                    i6 = i33 + a13.length;
                                    if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                        if (dvVar.k != 3) {
                                            if (dvVar.k != 4) {
                                                i30++;
                                                i29 = 1;
                                            }
                                        }
                                        int i34 = dvVar.o;
                                        int i35 = 32767;
                                        if (i34 > 32767) {
                                            i34 = 32767;
                                        }
                                        if (i34 >= 0) {
                                            i35 = i34;
                                        }
                                        byte[] a14 = ep.a(i35, bArr2);
                                        System.arraycopy(a14, 0, bArr5, i6, a14.length);
                                        i6 += a14.length;
                                        i30++;
                                        i29 = 1;
                                    }
                                }
                                i6 = i21 + i20;
                                i19 = dvVar.j;
                                i19 = 99;
                                bArr5[i6] = (byte) i19;
                                int i33 = i6 + 1;
                                byte[] a13 = ep.a(dvVar.f1367l, bArr2);
                                System.arraycopy(a13, 0, bArr5, i33, a13.length);
                                i6 = i33 + a13.length;
                                if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                }
                            }
                            i30++;
                            i29 = 1;
                        }
                        b2 = 1;
                    }
                    if (!TextUtils.isEmpty(this.E) || this.E.length() == 0) {
                        i8 = 1;
                        bArr5[i6] = 0;
                        i7 = i6 + 1;
                    } else {
                        bArr5[i6] = b2;
                        int i36 = i6 + 1;
                        try {
                            String[] split = this.E.split(",");
                            byte[] a15 = a(split[0]);
                            System.arraycopy(a15, 0, bArr5, i36, a15.length);
                            int length18 = i36 + a15.length;
                            try {
                                byte[] bytes3 = split[2].getBytes(str2);
                                int length19 = bytes3.length;
                                if (length19 > 127) {
                                    length19 = 127;
                                }
                                bArr5[length18] = (byte) length19;
                                int i37 = length18 + 1;
                                System.arraycopy(bytes3, 0, bArr5, i37, length19);
                                i18 = i37 + length19;
                            } catch (Throwable th) {
                                ej.a(th, "Req", "buildV4Dot214");
                                bArr5[length18] = 0;
                                i18 = length18 + 1;
                            }
                            int parseInt3 = Integer.parseInt(split[1]);
                            if (parseInt3 > 127 || parseInt3 < -128) {
                                parseInt3 = 0;
                            }
                            bArr5[i18] = Byte.parseByte(String.valueOf(parseInt3));
                            i8 = 1;
                        } catch (Throwable th2) {
                            ej.a(th2, "Req", "buildV4Dot216");
                            byte[] a16 = a("00:00:00:00:00:00");
                            System.arraycopy(a16, 0, bArr5, i36, a16.length);
                            int length20 = i36 + a16.length;
                            bArr5[length20] = 0;
                            i8 = 1;
                            i18 = length20 + 1;
                            bArr5[i18] = Byte.parseByte("0");
                        }
                        i7 = i18 + i8;
                    }
                    ArrayList<ScanResult> arrayList2 = this.F;
                    min = Math.min(arrayList2.size(), 25);
                    if (min == 0) {
                        bArr5[i7] = 0;
                        i9 = i7 + i8;
                        str3 = str2;
                    } else {
                        bArr5[i7] = (byte) min;
                        int i38 = i7 + i8;
                        boolean z2 = ep.c() >= 17;
                        long j2 = 0;
                        if (z2) {
                            j2 = ep.b() / 1000;
                        }
                        int i39 = 0;
                        while (i39 < min) {
                            ScanResult scanResult = arrayList2.get(i39);
                            byte[] a17 = a(scanResult.BSSID);
                            System.arraycopy(a17, 0, bArr5, i38, a17.length);
                            int length21 = i38 + a17.length;
                            try {
                                byte[] bytes4 = scanResult.SSID.getBytes(str2);
                                bArr5[length21] = (byte) bytes4.length;
                                length21++;
                                System.arraycopy(bytes4, 0, bArr5, length21, bytes4.length);
                                i16 = length21 + bytes4.length;
                                i15 = 1;
                            } catch (Exception unused2) {
                                bArr5[length21] = 0;
                                i15 = 1;
                                i16 = length21 + 1;
                            }
                            int i40 = scanResult.level;
                            if (i40 > 127) {
                            }
                            i40 = 0;
                            bArr5[i16] = Byte.parseByte(String.valueOf(i40));
                            int i41 = i16 + i15;
                            if (!z2 || (i17 = (int) (j2 - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                                i17 = 0;
                            }
                            if (i17 > 65535) {
                                i17 = 65535;
                            }
                            byte[] a18 = ep.a(i17, bArr2);
                            System.arraycopy(a18, 0, bArr5, i41, a18.length);
                            int length22 = i41 + a18.length;
                            byte[] a19 = ep.a(scanResult.frequency, bArr2);
                            System.arraycopy(a19, 0, bArr5, length22, a19.length);
                            i38 = length22 + a19.length;
                            i39++;
                            str2 = str2;
                        }
                        str3 = str2;
                        byte[] a20 = ep.a(Integer.parseInt(this.G), bArr2);
                        System.arraycopy(a20, 0, bArr5, i38, a20.length);
                        i9 = i38 + a20.length;
                    }
                    bArr5[i9] = 0;
                    i10 = i9 + 1;
                    bytes = this.H.getBytes(str3);
                    if (bytes.length > 127) {
                        bytes = null;
                    }
                    if (bytes == null) {
                        bArr5[i10] = 0;
                        i14 = 1;
                        i11 = i10 + i14;
                        bArr = new byte[]{0, 0};
                        try {
                            isEmpty = TextUtils.isEmpty(this.K);
                            if (!isEmpty) {
                                bArr = ep.a(this.K.length(), bArr2);
                            }
                            System.arraycopy(bArr, 0, bArr5, i11, 2);
                            i12 = i11 + 2;
                            if (!isEmpty) {
                                try {
                                    byte[] bytes5 = this.K.getBytes(str3);
                                    System.arraycopy(bytes5, 0, bArr5, i12, bytes5.length);
                                    i12 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i13 = 2;
                        } catch (Throwable unused4) {
                            i13 = 2;
                            i12 = i11 + 2;
                        }
                        try {
                            System.arraycopy(ep.a(0, bArr2), 0, bArr5, i12, i13);
                        } catch (Throwable unused5) {
                        }
                        int i42 = i12 + i13;
                        byte[] bArr6 = new byte[i13];
                        // fill-array-data instruction
                        bArr6[0] = 0;
                        bArr6[1] = 0;
                        try {
                            System.arraycopy(bArr6, 0, bArr5, i42, i13);
                        } catch (Throwable unused6) {
                        }
                        int i43 = i42 + i13;
                        byte[] bArr7 = this.I;
                        length = bArr7 == null ? bArr7.length : 0;
                        byte[] a21 = ep.a(length, (byte[]) null);
                        System.arraycopy(a21, 0, bArr5, i43, a21.length);
                        int length23 = i43 + a21.length;
                        if (length > 0) {
                            byte[] bArr8 = this.I;
                            System.arraycopy(bArr8, 0, bArr5, length23, bArr8.length);
                            length23 += this.I.length;
                        }
                        if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                            bArr5[length23] = 0;
                            length23 = a(this.N, bArr5, length23 + 1);
                        }
                        byte[] bArr9 = new byte[length23];
                        System.arraycopy(bArr5, 0, bArr9, 0, length23);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr9);
                        byte[] a22 = ep.a(crc32.getValue());
                        byte[] bArr10 = new byte[(length23 + 8)];
                        System.arraycopy(bArr9, 0, bArr10, 0, length23);
                        System.arraycopy(a22, 0, bArr10, length23, 8);
                        return bArr10;
                    }
                    bArr5[i10] = (byte) bytes.length;
                    int i44 = i10 + 1;
                    System.arraycopy(bytes, 0, bArr5, i44, bytes.length);
                    i11 = i44 + bytes.length;
                    bArr = new byte[]{0, 0};
                    isEmpty = TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                    }
                    System.arraycopy(bArr, 0, bArr5, i11, 2);
                    i12 = i11 + 2;
                    if (!isEmpty) {
                    }
                    i13 = 2;
                    System.arraycopy(ep.a(0, bArr2), 0, bArr5, i12, i13);
                    int i42 = i12 + i13;
                    byte[] bArr6 = new byte[i13];
                    // fill-array-data instruction
                    bArr6[0] = 0;
                    bArr6[1] = 0;
                    System.arraycopy(bArr6, 0, bArr5, i42, i13);
                    int i43 = i42 + i13;
                    byte[] bArr7 = this.I;
                    if (bArr7 == null) {
                    }
                    byte[] a21 = ep.a(length, (byte[]) null);
                    System.arraycopy(a21, 0, bArr5, i43, a21.length);
                    int length23 = i43 + a21.length;
                    if (length > 0) {
                    }
                    if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                    }
                    byte[] bArr9 = new byte[length23];
                    System.arraycopy(bArr5, 0, bArr9, 0, length23);
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr9);
                    byte[] a22 = ep.a(crc32.getValue());
                    byte[] bArr10 = new byte[(length23 + 8)];
                    System.arraycopy(bArr9, 0, bArr10, 0, length23);
                    System.arraycopy(a22, 0, bArr10, length23, 8);
                    return bArr10;
                }
                bArr5[i4] = 0;
                i5 = i4 + 1;
                ArrayList<dv> arrayList = this.C;
                int size = arrayList.size();
                if ((this.z & 4) == 4) {
                }
                bArr5[i5] = 0;
                b2 = 1;
                i6 = i5 + 1;
                if (!TextUtils.isEmpty(this.E)) {
                }
                i8 = 1;
                bArr5[i6] = 0;
                i7 = i6 + 1;
                ArrayList<ScanResult> arrayList2 = this.F;
                min = Math.min(arrayList2.size(), 25);
                if (min == 0) {
                }
                bArr5[i9] = 0;
                i10 = i9 + 1;
                try {
                    bytes = this.H.getBytes(str3);
                    if (bytes.length > 127) {
                    }
                    if (bytes == null) {
                    }
                } catch (Throwable unused7) {
                    bArr5[i10] = 0;
                    i14 = 1;
                }
            } else {
                byte[] a23 = a(this.t);
                bArr5[a3] = (byte) a23.length;
                int i45 = a3 + 1;
                System.arraycopy(a23, 0, bArr5, i45, a23.length);
                i2 = i45 + a23.length;
                int a4 = a(this.x, bArr5, a(L, bArr5, a(J, bArr5, a(this.w, bArr5, a(this.v, bArr5, i2)))));
                bArr5[a4] = Byte.parseByte(this.y);
                int i24 = a4 + 1;
                bArr5[i24] = Byte.parseByte(this.j);
                int i25 = i24 + 1;
                int i26 = this.z;
                i3 = i26 & 3;
                bArr5[i25] = (byte) i26;
                i4 = i25 + 1;
                byte[] b3 = ep.b(b("mcc"));
                System.arraycopy(b3, 0, bArr5, i4, b3.length);
                int length4 = i4 + b3.length;
                if (i3 != 1) {
                }
                length4 = length2 + length3;
                parseInt = Integer.parseInt(b("signal"));
                parseInt = 0;
                bArr5[length4] = (byte) parseInt;
                int i27 = length4 + 1;
                byte[] a5 = ep.a(0, bArr2);
                System.arraycopy(a5, 0, bArr5, i27, a5.length);
                i4 = i27 + 2;
                if (i3 == 1) {
                }
                i4++;
                str = this.D;
                str2 = "GBK";
                byte[] bytes2 = str.getBytes(str2);
                int min2 = Math.min(bytes2.length, 60);
                bArr5[i4] = (byte) min2;
                i4++;
                System.arraycopy(bytes2, 0, bArr5, i4, min2);
                i5 = i4 + min2;
                ArrayList<dv> arrayList = this.C;
                int size = arrayList.size();
                if ((this.z & 4) == 4) {
                }
                bArr5[i5] = 0;
                b2 = 1;
                i6 = i5 + 1;
                if (!TextUtils.isEmpty(this.E)) {
                }
                i8 = 1;
                bArr5[i6] = 0;
                i7 = i6 + 1;
                ArrayList<ScanResult> arrayList2 = this.F;
                min = Math.min(arrayList2.size(), 25);
                if (min == 0) {
                }
                bArr5[i9] = 0;
                i10 = i9 + 1;
                bytes = this.H.getBytes(str3);
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
        } catch (Throwable th3) {
            ej.a(th3, "Req", "buildV4Dot219");
            bArr5[a3] = 0;
        }
    }
}
