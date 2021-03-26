package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public final class en {
    static AMapLocation g = null;
    static boolean h = false;
    private static List<bb> i = new ArrayList();
    private static JSONArray j = null;
    public SparseArray<Long> a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;

    /* renamed from: com.loc.en$1  reason: invalid class name */
    /* compiled from: ReportUtil */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void a(long j2, long j3) {
        try {
            if (!h) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("gpsTime:");
                stringBuffer.append(ep.a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                stringBuffer.append("sysTime:");
                stringBuffer.append(ep.a(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                long u = ei.u();
                String str = "0";
                int i2 = (0 > u ? 1 : (0 == u ? 0 : -1));
                if (i2 != 0) {
                    str = ep.a(u, "yyyy-MM-dd HH:mm:ss.SSS");
                }
                stringBuffer.append("serverTime:");
                stringBuffer.append(str);
                a("checkgpstime", stringBuffer.toString());
                if (i2 != 0 && Math.abs(j2 - u) < 31536000000L) {
                    stringBuffer.append(", correctError");
                    a("checkgpstimeerror", stringBuffer.toString());
                }
                stringBuffer.delete(0, stringBuffer.length());
                h = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (en.class) {
            if (context != null) {
                try {
                    if (ei.a()) {
                        List<bb> list = i;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(i);
                            bc.b(arrayList, context);
                            i.clear();
                        }
                        f(context);
                    }
                } catch (Throwable th) {
                    ej.a(th, "ReportUtil", "destroy");
                }
            }
        }
    }

    public static void a(Context context, int i2, int i3, long j2, long j3) {
        if (i2 != -1 && i3 != -1 && context != null) {
            try {
                if (ei.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    a(context, "O012", jSONObject);
                }
            } catch (Throwable th) {
                ej.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static void a(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (ei.a()) {
                    int intValue = Long.valueOf(j2).intValue();
                    String str = "domestic";
                    if (!z) {
                        str = "abroad";
                    }
                    if (context != null) {
                        try {
                            if (ei.a()) {
                                JSONObject jSONObject = new JSONObject();
                                if (!TextUtils.isEmpty(str)) {
                                    jSONObject.put("param_string_first", str);
                                }
                                if (!TextUtils.isEmpty(null)) {
                                    jSONObject.put("param_string_second", (Object) null);
                                }
                                if (intValue != Integer.MAX_VALUE) {
                                    jSONObject.put("param_int_first", intValue);
                                }
                                a(context, "O015", jSONObject);
                            }
                        } catch (Throwable th) {
                            ej.a(th, "ReportUtil", "applyStatisticsEx");
                        }
                    }
                }
            } catch (Throwable th2) {
                ej.a(th2, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x002e  */
    public static synchronized void a(Context context, AMapLocation aMapLocation) {
        int i2;
        synchronized (en.class) {
            try {
                if (ep.a(aMapLocation)) {
                    int locationType = aMapLocation.getLocationType();
                    boolean z = false;
                    if (locationType == 1) {
                        i2 = 0;
                    } else if (locationType == 2 || locationType == 4) {
                        i2 = 1;
                    } else if (locationType == 8) {
                        i2 = 3;
                    } else if (locationType != 9) {
                        i2 = 0;
                        if (z) {
                            int c2 = ei.c();
                            if (c2 != 0) {
                                if (i2 == 0) {
                                    if (c2 == 2) {
                                        return;
                                    }
                                } else if (c2 == 1) {
                                    return;
                                }
                            }
                            if (j == null) {
                                j = new JSONArray();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("lon", ep.b(aMapLocation.getLongitude()));
                            jSONObject.put("lat", ep.b(aMapLocation.getLatitude()));
                            jSONObject.put("type", i2);
                            jSONObject.put("timestamp", ep.a());
                            if (aMapLocation.getCoordType().equalsIgnoreCase("WGS84")) {
                                jSONObject.put("coordType", 1);
                            } else {
                                jSONObject.put("coordType", 2);
                            }
                            if (i2 == 0) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("accuracy", ep.c((double) aMapLocation.getAccuracy()));
                                jSONObject2.put("altitude", ep.c(aMapLocation.getAltitude()));
                                jSONObject2.put("bearing", ep.c((double) aMapLocation.getBearing()));
                                jSONObject2.put("speed", ep.c((double) aMapLocation.getSpeed()));
                                jSONObject.put("extension", jSONObject2);
                            }
                            JSONArray put = j.put(jSONObject);
                            j = put;
                            if (put.length() >= ei.b()) {
                                f(context);
                            }
                        }
                    } else {
                        i2 = 2;
                    }
                    z = true;
                    if (z) {
                    }
                }
            } catch (Throwable th) {
                ej.a(th, "ReportUtil", "recordOfflineLocLog");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if ("http://abroad.apilocate.amap.com/mobile/binary".equals(com.loc.ej.a) != false) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041 A[Catch:{ all -> 0x0153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[SYNTHETIC, Splitter:B:38:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    public static void a(Context context, AMapLocation aMapLocation, dm dmVar) {
        boolean z;
        if (aMapLocation != null) {
            try {
                if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
                    int i2 = 1;
                    if (aMapLocation.getLocationType() != 1) {
                        String str = "domestic";
                        if (ep.a(aMapLocation)) {
                            if (!ej.a(aMapLocation.getLatitude(), aMapLocation.getLongitude())) {
                            }
                            z = false;
                            if (z) {
                                str = "abroad";
                            }
                            String str2 = "cache";
                            if (aMapLocation.getErrorCode() == 0) {
                                int errorCode = aMapLocation.getErrorCode();
                                if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                                    str2 = "net";
                                }
                                i2 = 0;
                            } else {
                                int locationType = aMapLocation.getLocationType();
                                if (locationType == 5 || locationType == 6) {
                                    str2 = "net";
                                }
                            }
                            int errorCode2 = aMapLocation.getErrorCode();
                            if (context == null) {
                                try {
                                    if (ei.a()) {
                                        JSONObject jSONObject = new JSONObject();
                                        if (!TextUtils.isEmpty(str2)) {
                                            jSONObject.put("param_string_first", str2);
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            jSONObject.put("param_string_second", str);
                                        }
                                        if (i2 != Integer.MAX_VALUE) {
                                            jSONObject.put("param_int_first", i2);
                                        }
                                        if (errorCode2 != Integer.MAX_VALUE) {
                                            jSONObject.put("param_int_second", errorCode2);
                                        }
                                        if (dmVar != null) {
                                            if (!TextUtils.isEmpty(dmVar.d())) {
                                                jSONObject.put("dns", dmVar.d());
                                            }
                                            if (!TextUtils.isEmpty(dmVar.e())) {
                                                jSONObject.put("domain", dmVar.e());
                                            }
                                            if (!TextUtils.isEmpty(dmVar.f())) {
                                                jSONObject.put("type", dmVar.f());
                                            }
                                            if (!TextUtils.isEmpty(dmVar.g())) {
                                                jSONObject.put("reason", dmVar.g());
                                            }
                                            if (!TextUtils.isEmpty(dmVar.c())) {
                                                jSONObject.put("ip", dmVar.c());
                                            }
                                            if (!TextUtils.isEmpty(dmVar.b())) {
                                                jSONObject.put("stack", dmVar.b());
                                            }
                                            if (dmVar.h() > 0) {
                                                jSONObject.put("ctime", String.valueOf(dmVar.h()));
                                            }
                                            if (dmVar.a() > 0) {
                                                jSONObject.put("ntime", String.valueOf(dmVar.a()));
                                            }
                                        }
                                        a(context, "O016", jSONObject);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    ej.a(th, "ReportUtil", "applyStatisticsEx");
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        String str2 = "cache";
                        if (aMapLocation.getErrorCode() == 0) {
                        }
                        int errorCode2 = aMapLocation.getErrorCode();
                        if (context == null) {
                        }
                    }
                }
            } catch (Throwable th2) {
                ej.a(th2, "ReportUtil", "reportBatting");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        synchronized (en.class) {
            if (context != null) {
                try {
                    if (ei.a()) {
                        bb bbVar = new bb(context, "loc", "5.2.0", str);
                        if (jSONObject != null) {
                            bbVar.a(jSONObject.toString());
                        }
                        i.add(bbVar);
                        if (i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(i);
                            bc.b(arrayList, context);
                            i.clear();
                        }
                    }
                } catch (Throwable th) {
                    ej.a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!ep.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.clone();
            }
            if (ep.a(g) && ep.a(aMapLocation2)) {
                AMapLocation clone = aMapLocation2.clone();
                if (!(g.getLocationType() == 1 || g.getLocationType() == 9 || "gps".equalsIgnoreCase(g.getProvider()) || g.getLocationType() == 7 || clone.getLocationType() == 1 || clone.getLocationType() == 9 || "gps".equalsIgnoreCase(clone.getProvider()) || clone.getLocationType() == 7)) {
                    long abs = Math.abs(clone.getTime() - g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float a2 = ep.a(g, clone);
                        float f2 = a2 / ((float) abs);
                        if (a2 > 30000.0f && f2 > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(ep.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(clone.getLatitude());
                            sb.append(",");
                            sb.append(clone.getLongitude());
                            sb.append(",");
                            sb.append(clone.getAccuracy());
                            sb.append(",");
                            sb.append(clone.getLocationType());
                            sb.append(",");
                            if (clone.getTime() != 0) {
                                sb.append(ep.a(clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, int i2) {
        String str2;
        String valueOf = String.valueOf(i2);
        if (i2 == 2011) {
            str2 = "ContextIsNull";
        } else if (i2 == 2031) {
            str2 = "CreateApsReqException";
        } else if (i2 == 2041) {
            str2 = "ResponseResultIsNull";
        } else if (i2 == 2081) {
            str2 = "LocalLocException";
        } else if (i2 == 2091) {
            str2 = "InitException";
        } else if (i2 == 2111) {
            str2 = "ErrorCgiInfo";
        } else if (i2 == 2121) {
            str2 = "NotLocPermission";
        } else if (i2 == 2141) {
            str2 = "NoEnoughStatellites";
        } else if (i2 == 2021) {
            str2 = "OnlyMainWifi";
        } else if (i2 == 2022) {
            str2 = "OnlyOneWifiButNotMain";
        } else if (i2 == 2061) {
            str2 = "ServerRetypeError";
        } else if (i2 == 2062) {
            str2 = "ServerLocFail";
        } else if (i2 == 2151) {
            str2 = "MaybeMockNetLoc";
        } else if (i2 != 2152) {
            switch (i2) {
                case 2051:
                    str2 = "NeedLoginNetWork\t";
                    break;
                case 2052:
                    str2 = "MaybeIntercepted";
                    break;
                case 2053:
                    str2 = "DecryptResponseException";
                    break;
                case 2054:
                    str2 = "ParserDataException";
                    break;
                default:
                    switch (i2) {
                        case 2101:
                            str2 = "BindAPSServiceException";
                            break;
                        case 2102:
                            str2 = "AuthClientScodeFail";
                            break;
                        case 2103:
                            str2 = "NotConfigAPSService";
                            break;
                        default:
                            switch (i2) {
                                case 2131:
                                    str2 = "NoCgiOAndWifiInfo";
                                    break;
                                case 2132:
                                    str2 = "AirPlaneModeAndWifiOff";
                                    break;
                                case 2133:
                                    str2 = "NoCgiAndWifiOff";
                                    break;
                                default:
                                    str2 = "";
                                    break;
                            }
                    }
            }
        } else {
            str2 = "MaybeMockGPSLoc";
        }
        a(str, valueOf, str2);
    }

    public static void a(String str, String str2) {
        try {
            ab.b(ej.c(), str2, str);
        } catch (Throwable th) {
            ej.a(th, "ReportUtil", "reportLog");
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            ab.a(ej.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof j) {
                ab.a(ej.c(), str, (j) th);
            }
        } catch (Throwable unused) {
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = j;
            if (jSONArray != null && jSONArray.length() > 0) {
                ba.a(new az(context, ej.c(), j.toString()), context);
                j = null;
            }
        } catch (Throwable th) {
            ej.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void a(Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 != i2) {
                if (!(i3 == -1 || i3 == i2)) {
                    this.a.append(this.b, Long.valueOf((ep.b() - this.c) + this.a.get(this.b, 0L).longValue()));
                }
                this.c = ep.b() - eo.a(context, "pref1", this.d[i2], 0L);
                this.b = i2;
            }
        } catch (Throwable th) {
            ej.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i2 = AnonymousClass1.a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i3 = 3;
            if (i2 == 1) {
                i3 = 4;
            } else if (i2 == 2) {
                i3 = 5;
            } else if (i2 != 3) {
                i3 = -1;
            }
            int i4 = this.e;
            if (i4 != i3) {
                if (!(i4 == -1 || i4 == i3)) {
                    this.a.append(this.e, Long.valueOf((ep.b() - this.f) + this.a.get(this.e, 0L).longValue()));
                }
                this.f = ep.b() - eo.a(context, "pref1", this.d[i3], 0L);
                this.e = i3;
            }
        } catch (Throwable th) {
            ej.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void b(Context context) {
        try {
            long b2 = ep.b() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.a.append(this.b, Long.valueOf(b2 + this.a.get(i2, 0L).longValue()));
            }
            long b3 = ep.b() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.a.append(this.e, Long.valueOf(b3 + this.a.get(i3, 0L).longValue()));
            }
            SharedPreferences.Editor a2 = eo.a(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long longValue = this.a.get(i4, 0L).longValue();
                if (longValue > 0 && longValue > eo.a(context, "pref1", this.d[i4], 0L)) {
                    eo.a(a2, this.d[i4], longValue);
                }
            }
            eo.a(a2);
        } catch (Throwable th) {
            ej.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int c(Context context) {
        try {
            long a2 = eo.a(context, "pref1", this.d[2], 0L);
            long a3 = eo.a(context, "pref1", this.d[0], 0L);
            long a4 = eo.a(context, "pref1", this.d[1], 0L);
            if (a2 == 0 && a3 == 0 && a4 == 0) {
                return -1;
            }
            long j2 = a3 - a2;
            long j3 = a4 - a2;
            return a2 > j2 ? a2 > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long a2 = eo.a(context, "pref1", this.d[3], 0L);
            long a3 = eo.a(context, "pref1", this.d[4], 0L);
            long a4 = eo.a(context, "pref1", this.d[5], 0L);
            if (a2 == 0 && a3 == 0 && a4 == 0) {
                return -1;
            }
            return a2 > a3 ? a2 > a4 ? 3 : 5 : a3 > a4 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor a2 = eo.a(context, "pref1");
            int i2 = 0;
            while (true) {
                String[] strArr = this.d;
                if (i2 < strArr.length) {
                    eo.a(a2, strArr[i2], 0L);
                    i2++;
                } else {
                    eo.a(a2);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
