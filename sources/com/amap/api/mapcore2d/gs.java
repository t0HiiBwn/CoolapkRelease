package com.amap.api.mapcore2d;

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
public final class gs {
    protected static String J;
    protected static String L;
    protected String A = null;
    protected String B = null;
    protected ArrayList<gm> C = new ArrayList<>();
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
    protected String l = null;
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
            gu.a(th, "Req", "copyContentWithByteLen");
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
                gu.a(th, "Req", "getMacBa " + str);
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
        String str2 = this.A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + ">");
        String str4 = this.A;
        return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    private void b() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = "";
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = "";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = "";
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = "";
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = "";
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = "";
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = "";
        }
        if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.l)) {
            this.l = "";
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = "";
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = "";
        }
        if (TextUtils.isEmpty(this.o)) {
            this.o = "";
        }
        if (TextUtils.isEmpty(this.p)) {
            this.p = "";
        }
        if (TextUtils.isEmpty(this.q)) {
            this.q = "";
        }
        if (TextUtils.isEmpty(this.r)) {
            this.r = "";
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = "";
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = "";
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = "";
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = "";
        }
        if (TextUtils.isEmpty(this.w)) {
            this.w = "";
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = "";
        }
        if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!gn.a(this.z)) {
            this.z = 0;
        }
        if (TextUtils.isEmpty(this.A)) {
            this.A = "";
        }
        if (TextUtils.isEmpty(this.B)) {
            this.B = "";
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = "";
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = "";
        }
        if (TextUtils.isEmpty(this.H)) {
            this.H = "";
        }
        if (TextUtils.isEmpty(J)) {
            J = "";
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
        if (TextUtils.isEmpty(this.N)) {
            this.N = "";
        }
    }

    public final void a(Context context, boolean z2, boolean z3, gn gnVar, go goVar, ConnectivityManager connectivityManager, String str) {
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
        String f2 = cq.f(context);
        int f3 = gy.f();
        this.K = str;
        if (!z3) {
            str3 = "UC_nlp_20131029";
            str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str3 = "api_serverSDK_130905";
            str2 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        StringBuilder sb = new StringBuilder();
        int c2 = gnVar.c();
        int d2 = gnVar.d();
        TelephonyManager e2 = gnVar.e();
        ArrayList<gm> a2 = gnVar.a();
        ArrayList<gm> b2 = gnVar.b();
        ArrayList<ScanResult> a3 = goVar.a();
        String str12 = d2 == 2 ? "1" : "0";
        if (e2 != null) {
            if (TextUtils.isEmpty(gu.d)) {
                try {
                    gu.d = cu.v(context);
                } catch (Throwable th) {
                    str4 = "1";
                    gu.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            i2 = f3;
            if (TextUtils.isEmpty(gu.d) && Build.VERSION.SDK_INT < 29) {
                gu.d = "888888888888888";
            }
            if (TextUtils.isEmpty(gu.e)) {
                try {
                    gu.e = e2.getSubscriberId();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    gu.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(gu.e) && Build.VERSION.SDK_INT < 29) {
                gu.e = "888888888888888";
            }
        } else {
            i2 = f3;
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            gu.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a4 = goVar.a(connectivityManager);
        if (gy.a(networkInfo) != -1) {
            str6 = gy.b(e2);
            str5 = a4 ? "2" : str4;
        } else {
            str6 = "";
            str5 = str6;
        }
        if (!a2.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            str10 = f2;
            str9 = "0";
            str8 = str2;
            str7 = str3;
            if (d2 == 1) {
                gm gmVar = a2.get(0);
                arrayList = a3;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(gmVar.a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(gmVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(gmVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(gmVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(gmVar.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                for (int i4 = 1; i4 < a2.size(); i4++) {
                    gm gmVar2 = a2.get(i4);
                    sb.append(gmVar2.c);
                    sb.append(",");
                    sb.append(gmVar2.d);
                    sb.append(",");
                    sb.append(gmVar2.j);
                    if (i4 < a2.size() - 1) {
                        sb.append("*");
                    }
                }
            } else if (d2 != 2) {
                arrayList = a3;
                str11 = "";
            } else {
                gm gmVar3 = a2.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(gmVar3.a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(gmVar3.g);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(gmVar3.h);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(gmVar3.i);
                sb2.append("</bid>");
                if (gmVar3.f > 0 && gmVar3.e > 0) {
                    sb2.append("<lon>");
                    sb2.append(gmVar3.f);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(gmVar3.e);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(gmVar3.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                arrayList = a3;
            }
            sb2.delete(0, sb2.length());
        } else {
            str10 = f2;
            str7 = str3;
            str8 = str2;
            arrayList = a3;
            str9 = "0";
            str11 = "";
        }
        if ((c2 & 4) != 4 || b2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(b2);
        }
        StringBuilder sb3 = new StringBuilder();
        if (goVar.e()) {
            if (a4) {
                WifiInfo f4 = goVar.f();
                if (go.a(f4)) {
                    sb3.append(f4.getBSSID());
                    sb3.append(",");
                    int rssi = f4.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = f4.getSSID();
                    try {
                        i3 = f4.getSSID().getBytes("UTF-8").length;
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
            goVar.b();
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
        this.f = gy.d();
        this.g = "android" + gy.e();
        this.h = gy.b(context);
        this.i = str12;
        this.j = str9;
        this.k = str9;
        this.l = str9;
        this.m = str9;
        this.n = str9;
        this.o = str10;
        this.p = gu.d;
        this.q = gu.e;
        this.s = String.valueOf(i2);
        this.t = gy.d(context);
        this.v = "4.7.0";
        this.w = null;
        this.u = "";
        this.x = str6;
        this.y = str5;
        this.z = c2;
        this.A = str11;
        this.B = sb.toString();
        this.D = gnVar.i();
        this.G = go.i();
        this.E = sb3.toString();
        try {
            if (TextUtils.isEmpty(J)) {
                J = cu.h(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(L)) {
                L = cu.b(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = cu.i(context);
            }
        } catch (Throwable unused5) {
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0483 A[Catch:{ all -> 0x0499 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0486 A[Catch:{ all -> 0x0499 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x048b A[Catch:{ all -> 0x0499 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x04ac A[Catch:{ all -> 0x04cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x04be A[SYNTHETIC, Splitter:B:182:0x04be] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x021e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x030f  */
    public final byte[] a() {
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        int min;
        byte b2;
        int i8;
        int i9;
        int i10;
        byte[] bArr;
        int i11;
        int i12;
        byte[] bArr2;
        int i13;
        byte[] bArr3;
        boolean isEmpty;
        int i14;
        byte[] bytes;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int parseInt;
        int length;
        int length2;
        b();
        byte[] bArr4 = new byte[2];
        byte[] bArr5 = new byte[4];
        byte[] bArr6 = this.I;
        int i21 = 4096;
        int i22 = 1;
        if (bArr6 != null) {
            i21 = 4096 + bArr6.length + 1;
        }
        byte[] bArr7 = this.O;
        if (bArr7 == null || i21 > this.P) {
            bArr7 = new byte[i21];
            this.O = bArr7;
            this.P = i21;
        }
        byte b3 = 0;
        bArr7[0] = gy.e(this.a);
        byte[] a2 = gy.a(this.b, (byte[]) null);
        System.arraycopy(a2, 0, bArr7, 1, a2.length);
        int a3 = a(this.q, bArr7, a(this.p, bArr7, a(this.h, bArr7, a(this.u, bArr7, a(this.g, bArr7, a(this.f, bArr7, a(this.e, bArr7, a(this.o, bArr7, a(this.d, bArr7, a(this.c, bArr7, a2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.t)) {
                bArr7[a3] = 0;
                i2 = a3 + 1;
                int a4 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i2)))));
                bArr7[a4] = Byte.parseByte(this.y);
                int i23 = a4 + 1;
                bArr7[i23] = Byte.parseByte(this.j);
                int i24 = i23 + 1;
                int i25 = this.z;
                i3 = i25 & 3;
                bArr7[i24] = (byte) i25;
                i4 = i24 + 1;
                if (i3 == 1 || i3 == 2) {
                    byte[] b4 = gy.b(b("mcc"));
                    System.arraycopy(b4, 0, bArr7, i4, b4.length);
                    int length3 = i4 + b4.length;
                    if (i3 != 1) {
                        byte[] b5 = gy.b(b("mnc"));
                        System.arraycopy(b5, 0, bArr7, length3, b5.length);
                        int length4 = length3 + b5.length;
                        byte[] b6 = gy.b(b("lac"));
                        System.arraycopy(b6, 0, bArr7, length4, b6.length);
                        length = length4 + b6.length;
                        byte[] c2 = gy.c(b("cellid"));
                        System.arraycopy(c2, 0, bArr7, length, c2.length);
                        length2 = c2.length;
                    } else {
                        if (i3 == 2) {
                            byte[] b7 = gy.b(b("sid"));
                            System.arraycopy(b7, 0, bArr7, length3, b7.length);
                            int length5 = length3 + b7.length;
                            byte[] b8 = gy.b(b("nid"));
                            System.arraycopy(b8, 0, bArr7, length5, b8.length);
                            int length6 = length5 + b8.length;
                            byte[] b9 = gy.b(b("bid"));
                            System.arraycopy(b9, 0, bArr7, length6, b9.length);
                            int length7 = length6 + b9.length;
                            byte[] c3 = gy.c(b("lon"));
                            System.arraycopy(c3, 0, bArr7, length7, c3.length);
                            length = length7 + c3.length;
                            byte[] c4 = gy.c(b("lat"));
                            System.arraycopy(c4, 0, bArr7, length, c4.length);
                            length2 = c4.length;
                        }
                        parseInt = Integer.parseInt(b("signal"));
                        if (parseInt > 127 || parseInt < -128) {
                            parseInt = 0;
                        }
                        bArr7[length3] = (byte) parseInt;
                        int i26 = length3 + 1;
                        byte[] a5 = gy.a(0, bArr4);
                        System.arraycopy(a5, 0, bArr7, i26, a5.length);
                        i4 = i26 + 2;
                        if (i3 == 1) {
                            if (TextUtils.isEmpty(this.B)) {
                                bArr7[i4] = 0;
                            } else {
                                int length8 = this.B.split("\\*").length;
                                bArr7[i4] = (byte) length8;
                                i4++;
                                for (int i27 = 0; i27 < length8; i27++) {
                                    byte[] b10 = gy.b(a("lac", i27));
                                    System.arraycopy(b10, 0, bArr7, i4, b10.length);
                                    int length9 = i4 + b10.length;
                                    byte[] c5 = gy.c(a("cellid", i27));
                                    System.arraycopy(c5, 0, bArr7, length9, c5.length);
                                    int length10 = length9 + c5.length;
                                    int parseInt2 = Integer.parseInt(a("signal", i27));
                                    if (parseInt2 > 127 || parseInt2 < -128) {
                                        parseInt2 = 0;
                                    }
                                    bArr7[length10] = (byte) parseInt2;
                                    i4 = length10 + 1;
                                }
                            }
                        } else if (i3 == 2) {
                            bArr7[i4] = 0;
                        }
                        i4++;
                    }
                    length3 = length + length2;
                    parseInt = Integer.parseInt(b("signal"));
                    parseInt = 0;
                    bArr7[length3] = (byte) parseInt;
                    int i26 = length3 + 1;
                    byte[] a5 = gy.a(0, bArr4);
                    System.arraycopy(a5, 0, bArr7, i26, a5.length);
                    i4 = i26 + 2;
                    if (i3 == 1) {
                    }
                    i4++;
                }
                str = this.D;
                if (str != null && (this.z & 8) == 8) {
                    try {
                        byte[] bytes2 = str.getBytes("GBK");
                        int min2 = Math.min(bytes2.length, 60);
                        bArr7[i4] = (byte) min2;
                        i4++;
                        System.arraycopy(bytes2, 0, bArr7, i4, min2);
                        i5 = i4 + min2;
                    } catch (Exception unused) {
                    }
                    ArrayList<gm> arrayList = this.C;
                    int size = arrayList.size();
                    if ((this.z & 4) == 4 || size <= 0) {
                        bArr7[i5] = 0;
                        i6 = i5 + 1;
                    } else {
                        if (!arrayList.get(0).p) {
                            size--;
                        }
                        bArr7[i5] = (byte) size;
                        i6 = i5 + 1;
                        for (int i28 = 0; i28 < size; i28++) {
                            gm gmVar = arrayList.get(i28);
                            if (gmVar.p) {
                                if (gmVar.k == 1 || gmVar.k == 3 || gmVar.k == 4) {
                                    byte b11 = (byte) gmVar.k;
                                    if (gmVar.n) {
                                        b11 = (byte) (b11 | 8);
                                    }
                                    bArr7[i6] = b11;
                                    int i29 = i6 + 1;
                                    byte[] a6 = gy.a(gmVar.a, bArr4);
                                    System.arraycopy(a6, 0, bArr7, i29, a6.length);
                                    int length11 = i29 + a6.length;
                                    byte[] a7 = gy.a(gmVar.b, bArr4);
                                    System.arraycopy(a7, 0, bArr7, length11, a7.length);
                                    int length12 = length11 + a7.length;
                                    byte[] a8 = gy.a(gmVar.c, bArr4);
                                    System.arraycopy(a8, 0, bArr7, length12, a8.length);
                                    i20 = length12 + a8.length;
                                    byte[] b12 = gy.b(gmVar.d, bArr5);
                                    System.arraycopy(b12, 0, bArr7, i20, b12.length);
                                    i19 = b12.length;
                                } else {
                                    if (gmVar.k == 2) {
                                        byte b13 = (byte) gmVar.k;
                                        if (gmVar.n) {
                                            b13 = (byte) (b13 | 8);
                                        }
                                        bArr7[i6] = b13;
                                        int i30 = i6 + 1;
                                        byte[] a9 = gy.a(gmVar.a, bArr4);
                                        System.arraycopy(a9, 0, bArr7, i30, a9.length);
                                        int length13 = i30 + a9.length;
                                        byte[] a10 = gy.a(gmVar.g, bArr4);
                                        System.arraycopy(a10, 0, bArr7, length13, a10.length);
                                        int length14 = length13 + a10.length;
                                        byte[] a11 = gy.a(gmVar.h, bArr4);
                                        System.arraycopy(a11, 0, bArr7, length14, a11.length);
                                        int length15 = length14 + a11.length;
                                        byte[] a12 = gy.a(gmVar.i, bArr4);
                                        System.arraycopy(a12, 0, bArr7, length15, a12.length);
                                        int length16 = length15 + a12.length;
                                        byte[] b14 = gy.b(gmVar.f, bArr5);
                                        System.arraycopy(b14, 0, bArr7, length16, b14.length);
                                        i20 = length16 + b14.length;
                                        byte[] b15 = gy.b(gmVar.e, bArr5);
                                        System.arraycopy(b15, 0, bArr7, i20, b15.length);
                                        i19 = b15.length;
                                    }
                                    i18 = gmVar.j;
                                    if (i18 > 127 || i18 < -128) {
                                        i18 = 99;
                                    }
                                    bArr7[i6] = (byte) i18;
                                    int i31 = i6 + 1;
                                    byte[] a13 = gy.a(gmVar.l, bArr4);
                                    System.arraycopy(a13, 0, bArr7, i31, a13.length);
                                    i6 = i31 + a13.length;
                                    if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                        if (gmVar.k != 3) {
                                            if (gmVar.k != 4) {
                                            }
                                        }
                                        int i32 = gmVar.o;
                                        int i33 = 32767;
                                        if (i32 > 32767) {
                                            i32 = 32767;
                                        }
                                        if (i32 >= 0) {
                                            i33 = i32;
                                        }
                                        byte[] a14 = gy.a(i33, bArr4);
                                        System.arraycopy(a14, 0, bArr7, i6, a14.length);
                                        i6 += a14.length;
                                    }
                                }
                                i6 = i20 + i19;
                                i18 = gmVar.j;
                                i18 = 99;
                                bArr7[i6] = (byte) i18;
                                int i31 = i6 + 1;
                                byte[] a13 = gy.a(gmVar.l, bArr4);
                                System.arraycopy(a13, 0, bArr7, i31, a13.length);
                                i6 = i31 + a13.length;
                                if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                }
                            }
                        }
                    }
                    if (this.E.length() == 0) {
                        bArr7[i6] = 0;
                        i7 = i6 + 1;
                    } else {
                        bArr7[i6] = 1;
                        int i34 = i6 + 1;
                        try {
                            String[] split = this.E.split(",");
                            byte[] a15 = a(split[0]);
                            System.arraycopy(a15, 0, bArr7, i34, a15.length);
                            int length17 = i34 + a15.length;
                            try {
                                byte[] bytes3 = split[2].getBytes("GBK");
                                int length18 = bytes3.length;
                                if (length18 > 127) {
                                    length18 = 127;
                                }
                                bArr7[length17] = (byte) length18;
                                int i35 = length17 + 1;
                                System.arraycopy(bytes3, 0, bArr7, i35, length18);
                                i17 = i35 + length18;
                            } catch (Throwable th) {
                                gu.a(th, "Req", "buildV4Dot214");
                                bArr7[length17] = 0;
                                i17 = length17 + 1;
                            }
                            int parseInt3 = Integer.parseInt(split[1]);
                            if (parseInt3 > 127 || parseInt3 < -128) {
                                parseInt3 = 0;
                            }
                            bArr7[i17] = Byte.parseByte(String.valueOf(parseInt3));
                        } catch (Throwable th2) {
                            gu.a(th2, "Req", "buildV4Dot216");
                            byte[] a16 = a("00:00:00:00:00:00");
                            System.arraycopy(a16, 0, bArr7, i34, a16.length);
                            int length19 = i34 + a16.length;
                            bArr7[length19] = 0;
                            i17 = length19 + 1;
                            bArr7[i17] = Byte.parseByte("0");
                        }
                        i7 = i17 + 1;
                    }
                    ArrayList<ScanResult> arrayList2 = this.F;
                    min = Math.min(arrayList2.size(), 25);
                    if (min == 0) {
                        bArr7[i7] = 0;
                        i8 = i7 + 1;
                        b2 = 0;
                    } else {
                        bArr7[i7] = (byte) min;
                        int i36 = i7 + 1;
                        boolean z2 = gy.c() >= 17;
                        long j2 = 0;
                        if (z2) {
                            j2 = gy.b() / 1000;
                        }
                        int i37 = 0;
                        while (i37 < min) {
                            ScanResult scanResult = arrayList2.get(i37);
                            byte[] a17 = a(scanResult.BSSID);
                            System.arraycopy(a17, b3, bArr7, i36, a17.length);
                            int length20 = i36 + a17.length;
                            try {
                                byte[] bytes4 = scanResult.SSID.getBytes("GBK");
                                bArr7[length20] = (byte) bytes4.length;
                                length20++;
                                System.arraycopy(bytes4, b3, bArr7, length20, bytes4.length);
                                i15 = length20 + bytes4.length;
                            } catch (Exception unused2) {
                                bArr7[length20] = b3;
                                i15 = length20 + i22;
                            }
                            int i38 = scanResult.level;
                            if (i38 > 127) {
                                i38 = 0;
                            } else if (i38 < -128) {
                                i38 = 0;
                            }
                            bArr7[i15] = Byte.parseByte(String.valueOf(i38));
                            int i39 = i15 + i22;
                            if (!z2 || (i16 = (int) (j2 - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                                i16 = 0;
                            }
                            if (i16 > 65535) {
                                i16 = 65535;
                            }
                            byte[] a18 = gy.a(i16, bArr4);
                            System.arraycopy(a18, 0, bArr7, i39, a18.length);
                            int length21 = i39 + a18.length;
                            byte[] a19 = gy.a(scanResult.frequency, bArr4);
                            System.arraycopy(a19, 0, bArr7, length21, a19.length);
                            i36 = length21 + a19.length;
                            i37++;
                            i22 = 1;
                            b3 = 0;
                        }
                        b2 = 0;
                        byte[] a20 = gy.a(Integer.parseInt(this.G), bArr4);
                        System.arraycopy(a20, 0, bArr7, i36, a20.length);
                        i8 = i36 + a20.length;
                    }
                    bArr7[i8] = b2;
                    i9 = i8 + 1;
                    bytes = this.H.getBytes("GBK");
                    if (bytes.length > 127) {
                        bytes = null;
                    }
                    if (bytes == null) {
                        bArr7[i9] = 0;
                        i14 = 1;
                        i10 = i9 + i14;
                        bArr = new byte[]{0, 0};
                        try {
                            isEmpty = TextUtils.isEmpty(this.K);
                            if (!isEmpty) {
                                bArr = gy.a(this.K.length(), bArr4);
                            }
                            System.arraycopy(bArr, 0, bArr7, i10, 2);
                            i12 = i10 + 2;
                            if (!isEmpty) {
                                try {
                                    byte[] bytes5 = this.K.getBytes("GBK");
                                    System.arraycopy(bytes5, 0, bArr7, i12, bytes5.length);
                                    i12 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i11 = 2;
                        } catch (Throwable unused4) {
                            i11 = 2;
                            i12 = i10 + 2;
                        }
                        try {
                            System.arraycopy(gy.a(0, bArr4), 0, bArr7, i12, i11);
                        } catch (Throwable unused5) {
                        }
                        int i40 = i12 + i11;
                        byte[] bArr8 = new byte[i11];
                        // fill-array-data instruction
                        bArr8[0] = 0;
                        bArr8[1] = 0;
                        try {
                            System.arraycopy(bArr8, 0, bArr7, i40, i11);
                        } catch (Throwable unused6) {
                        }
                        int i41 = i40 + i11;
                        bArr2 = this.I;
                        if (bArr2 == null) {
                            i13 = bArr2.length;
                            bArr3 = null;
                        } else {
                            bArr3 = null;
                            i13 = 0;
                        }
                        byte[] a21 = gy.a(i13, bArr3);
                        System.arraycopy(a21, 0, bArr7, i41, a21.length);
                        int length22 = i41 + a21.length;
                        if (i13 > 0) {
                            byte[] bArr9 = this.I;
                            System.arraycopy(bArr9, 0, bArr7, length22, bArr9.length);
                            length22 += this.I.length;
                        }
                        if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                            bArr7[length22] = 0;
                            length22 = a(this.N, bArr7, length22 + 1);
                        }
                        byte[] bArr10 = new byte[length22];
                        System.arraycopy(bArr7, 0, bArr10, 0, length22);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr10);
                        byte[] a22 = gy.a(crc32.getValue());
                        byte[] bArr11 = new byte[(a22.length + length22)];
                        System.arraycopy(bArr10, 0, bArr11, 0, length22);
                        System.arraycopy(a22, 0, bArr11, length22, a22.length);
                        return bArr11;
                    }
                    bArr7[i9] = (byte) bytes.length;
                    int i42 = i9 + 1;
                    System.arraycopy(bytes, 0, bArr7, i42, bytes.length);
                    i10 = i42 + bytes.length;
                    bArr = new byte[]{0, 0};
                    isEmpty = TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                    }
                    System.arraycopy(bArr, 0, bArr7, i10, 2);
                    i12 = i10 + 2;
                    if (!isEmpty) {
                    }
                    i11 = 2;
                    System.arraycopy(gy.a(0, bArr4), 0, bArr7, i12, i11);
                    int i40 = i12 + i11;
                    byte[] bArr8 = new byte[i11];
                    // fill-array-data instruction
                    bArr8[0] = 0;
                    bArr8[1] = 0;
                    System.arraycopy(bArr8, 0, bArr7, i40, i11);
                    int i41 = i40 + i11;
                    bArr2 = this.I;
                    if (bArr2 == null) {
                    }
                    byte[] a21 = gy.a(i13, bArr3);
                    System.arraycopy(a21, 0, bArr7, i41, a21.length);
                    int length22 = i41 + a21.length;
                    if (i13 > 0) {
                    }
                    if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                    }
                    byte[] bArr10 = new byte[length22];
                    System.arraycopy(bArr7, 0, bArr10, 0, length22);
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr10);
                    byte[] a22 = gy.a(crc32.getValue());
                    byte[] bArr11 = new byte[(a22.length + length22)];
                    System.arraycopy(bArr10, 0, bArr11, 0, length22);
                    System.arraycopy(a22, 0, bArr11, length22, a22.length);
                    return bArr11;
                }
                bArr7[i4] = 0;
                i5 = i4 + 1;
                ArrayList<gm> arrayList = this.C;
                int size = arrayList.size();
                if ((this.z & 4) == 4) {
                }
                bArr7[i5] = 0;
                i6 = i5 + 1;
                if (this.E.length() == 0) {
                }
                ArrayList<ScanResult> arrayList2 = this.F;
                min = Math.min(arrayList2.size(), 25);
                if (min == 0) {
                }
                bArr7[i8] = b2;
                i9 = i8 + 1;
                try {
                    bytes = this.H.getBytes("GBK");
                    if (bytes.length > 127) {
                    }
                    if (bytes == null) {
                    }
                } catch (Throwable unused7) {
                    bArr7[i9] = 0;
                    i14 = 1;
                }
            } else {
                byte[] a23 = a(this.t);
                bArr7[a3] = (byte) a23.length;
                int i43 = a3 + 1;
                System.arraycopy(a23, 0, bArr7, i43, a23.length);
                i2 = i43 + a23.length;
                int a4 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i2)))));
                bArr7[a4] = Byte.parseByte(this.y);
                int i23 = a4 + 1;
                bArr7[i23] = Byte.parseByte(this.j);
                int i24 = i23 + 1;
                int i25 = this.z;
                i3 = i25 & 3;
                bArr7[i24] = (byte) i25;
                i4 = i24 + 1;
                byte[] b4 = gy.b(b("mcc"));
                System.arraycopy(b4, 0, bArr7, i4, b4.length);
                int length3 = i4 + b4.length;
                if (i3 != 1) {
                }
                length3 = length + length2;
                parseInt = Integer.parseInt(b("signal"));
                parseInt = 0;
                bArr7[length3] = (byte) parseInt;
                int i26 = length3 + 1;
                byte[] a5 = gy.a(0, bArr4);
                System.arraycopy(a5, 0, bArr7, i26, a5.length);
                i4 = i26 + 2;
                if (i3 == 1) {
                }
                i4++;
                str = this.D;
                byte[] bytes2 = str.getBytes("GBK");
                int min2 = Math.min(bytes2.length, 60);
                bArr7[i4] = (byte) min2;
                i4++;
                System.arraycopy(bytes2, 0, bArr7, i4, min2);
                i5 = i4 + min2;
                ArrayList<gm> arrayList = this.C;
                int size = arrayList.size();
                if ((this.z & 4) == 4) {
                }
                bArr7[i5] = 0;
                i6 = i5 + 1;
                if (this.E.length() == 0) {
                }
                ArrayList<ScanResult> arrayList2 = this.F;
                min = Math.min(arrayList2.size(), 25);
                if (min == 0) {
                }
                bArr7[i8] = b2;
                i9 = i8 + 1;
                bytes = this.H.getBytes("GBK");
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
        } catch (Throwable th3) {
            gu.a(th3, "Req", "buildV4Dot219");
            bArr7[a3] = 0;
        }
    }
}
