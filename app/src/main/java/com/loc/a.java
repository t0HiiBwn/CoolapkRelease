package com.loc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GeoFenceManager */
public final class a {
    private static boolean A;
    en a = null;
    Context b = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    volatile int f = 1;
    ArrayList<GeoFence> g = new ArrayList<>();
    c h = null;
    Object i = new Object();
    Object j = new Object();
    HandlerC0073a k = null;

    /* renamed from: l  reason: collision with root package name */
    b f1354l = null;
    volatile boolean m = false;
    volatile boolean n = false;
    volatile boolean o = false;
    b p = null;
    c q = null;
    AMapLocationClient r = null;
    volatile AMapLocation s = null;
    long t = 0;
    AMapLocationClientOption u = null;
    int v = 0;
    AMapLocationListener w = new AMapLocationListener() {
        /* class com.loc.a.AnonymousClass1 */

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!a.this.y && a.this.o) {
                    a.this.s = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.t = ep.b();
                            a.this.a(5, (Bundle) null, 0);
                            z = true;
                        } else {
                            a.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        a.this.v = 0;
                        a.this.a(6, (Bundle) null, 0);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.m) {
                        a.this.b(7);
                        bundle.putLong("interval", 2000);
                        a.this.a(8, bundle, 2000);
                    }
                    a.this.v++;
                    if (a.this.v >= 3) {
                        bundle.putInt("location_errorcode", i);
                        a.this.a(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    };
    final int x = 3;
    volatile boolean y = false;
    private Object z = new Object();

    /* renamed from: com.loc.a$a  reason: collision with other inner class name */
    /* compiled from: GeoFenceManager */
    class HandlerC0073a extends Handler {
        public HandlerC0073a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            try {
                String str2 = "";
                int i = 1;
                switch (message.what) {
                    case 0:
                        a aVar = a.this;
                        Bundle data = message.getData();
                        try {
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                            if (data != null && !data.isEmpty()) {
                                DPoint dPoint = (DPoint) data.getParcelable("centerPoint");
                                str = data.getString("customId");
                                if (dPoint != null) {
                                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d) {
                                        if (dPoint.getLongitude() >= -180.0d) {
                                            GeoFence a2 = aVar.a(data, false);
                                            i = aVar.b(a2);
                                            if (i == 0) {
                                                arrayList.add(a2);
                                            }
                                            Bundle bundle = new Bundle();
                                            bundle.putInt("errorCode", i);
                                            bundle.putParcelableArrayList("resultList", arrayList);
                                            bundle.putString("customId", str);
                                            aVar.a(1000, bundle);
                                            return;
                                        }
                                    }
                                    a.a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("errorCode", i);
                                    bundle.putParcelableArrayList("resultList", arrayList);
                                    bundle.putString("customId", str);
                                    aVar.a(1000, bundle);
                                    return;
                                }
                                str2 = str;
                            }
                            str = str2;
                            Bundle bundle = new Bundle();
                            bundle.putInt("errorCode", i);
                            bundle.putParcelableArrayList("resultList", arrayList);
                            bundle.putString("customId", str);
                            aVar.a(1000, bundle);
                            return;
                        } catch (Throwable th) {
                            ej.a(th, "GeoFenceManager", "doAddGeoFenceRound");
                            return;
                        }
                    case 1:
                        a aVar2 = a.this;
                        Bundle data2 = message.getData();
                        try {
                            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                            if (data2 != null && !data2.isEmpty()) {
                                ArrayList parcelableArrayList = data2.getParcelableArrayList("pointList");
                                String string = data2.getString("customId");
                                if (parcelableArrayList != null) {
                                    if (parcelableArrayList.size() > 2) {
                                        GeoFence a3 = aVar2.a(data2, true);
                                        i = aVar2.b(a3);
                                        if (i == 0) {
                                            arrayList2.add(a3);
                                        }
                                    }
                                }
                                str2 = string;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("customId", str2);
                            bundle2.putInt("errorCode", i);
                            bundle2.putParcelableArrayList("resultList", arrayList2);
                            aVar2.a(1000, bundle2);
                            return;
                        } catch (Throwable th2) {
                            ej.a(th2, "GeoFenceManager", "doAddGeoFencePolygon");
                            return;
                        }
                    case 2:
                        a.this.c(message.getData());
                        return;
                    case 3:
                        a.this.b(message.getData());
                        return;
                    case 4:
                        a.this.d(message.getData());
                        return;
                    case 5:
                        a.this.f();
                        return;
                    case 6:
                        a aVar3 = a.this;
                        aVar3.a(aVar3.s);
                        return;
                    case 7:
                        a aVar4 = a.this;
                        try {
                            if (aVar4.r != null) {
                                aVar4.e();
                                aVar4.u.setOnceLocation(true);
                                aVar4.r.setLocationOption(aVar4.u);
                                aVar4.r.startLocation();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            ej.a(th3, "GeoFenceManager", "doStartOnceLocation");
                            return;
                        }
                    case 8:
                        a aVar5 = a.this;
                        Bundle data3 = message.getData();
                        try {
                            if (aVar5.r != null) {
                                long j = 2000;
                                if (data3 != null && !data3.isEmpty()) {
                                    j = data3.getLong("interval", 2000);
                                }
                                aVar5.u.setOnceLocation(false);
                                aVar5.u.setInterval(j);
                                aVar5.r.setLocationOption(aVar5.u);
                                if (!aVar5.m) {
                                    aVar5.r.stopLocation();
                                    aVar5.r.startLocation();
                                    aVar5.m = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th4) {
                            ej.a(th4, "GeoFenceManager", "doStartContinueLocation");
                            return;
                        }
                    case 9:
                        a.this.a(message.getData());
                        return;
                    case 10:
                        a.this.c();
                        return;
                    case 11:
                        a.this.f(message.getData());
                        return;
                    case 12:
                        a.this.e(message.getData());
                        return;
                    case 13:
                        a.this.h();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager */
    static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager */
    class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a aVar = a.this;
                        if (data != null) {
                            try {
                                if (!data.isEmpty()) {
                                    int i = data.getInt("errorCode");
                                    ArrayList parcelableArrayList = data.getParcelableArrayList("resultList");
                                    if (parcelableArrayList == null) {
                                        parcelableArrayList = new ArrayList();
                                    }
                                    String string = data.getString("customId");
                                    if (string == null) {
                                        string = "";
                                    }
                                    if (aVar.e != null) {
                                        aVar.e.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                                    }
                                    if (i == 0) {
                                        aVar.d();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                ej.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
                                return;
                            }
                        } else {
                            return;
                        }
                    case 1001:
                        try {
                            a.this.c((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            a.this.c(data.getInt("location_errorcode"));
                            return;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        try {
            this.b = context.getApplicationContext();
            k();
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManger", "<init>");
        }
    }

    static float a(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.min(f2, ep.a(dPoint, dPoint2));
            }
        }
        return f2;
    }

    private int a(List<GeoFence> list) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                b(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static Bundle a(GeoFence geoFence, String str, String str2, int i2, int i3) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString("fenceid", str);
        bundle.putString("customId", str2);
        bundle.putInt("event", i2);
        bundle.putInt("location_errorcode", i3);
        bundle.putParcelable("fence", geoFence);
        return bundle;
    }

    static void a(String str, int i2, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:" + i2);
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:" + str2);
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean a(GeoFence geoFence, int i2) {
        boolean z2 = true;
        boolean z3 = false;
        if ((i2 & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z3 = true;
                }
            } catch (Throwable th) {
                ej.a(th, "Utils", "remindStatus");
                return false;
            }
        }
        if ((i2 & 2) == 2 && geoFence.getStatus() == 2) {
            z3 = true;
        }
        if (!((i2 & 4) == 4 && geoFence.getStatus() == 3)) {
            z2 = z3;
        }
        return z2;
    }

    private static boolean a(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2 = false;
        try {
            if (ep.a(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    boolean z3 = false;
                    for (List<DPoint> list : geoFence.getPointList()) {
                        try {
                            if (list.size() < 3 ? false : ej.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list)) {
                                z3 = true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = z3;
                            ej.a(th, "Utils", "isInGeoFence");
                            return z2;
                        }
                    }
                    z2 = z3;
                }
                DPoint center = geoFence.getCenter();
                if (ep.a(new double[]{center.getLatitude(), center.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= geoFence.getRadius()) {
                    return true;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            ej.a(th, "Utils", "isInGeoFence");
            return z2;
        }
        return z2;
    }

    static float b(DPoint dPoint, List<DPoint> list) {
        float f2 = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint dPoint2 : list) {
                f2 = Math.max(f2, ep.a(dPoint, dPoint2));
            }
        }
        return f2;
    }

    private static DPoint b(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (DPoint dPoint2 : list) {
                d2 += dPoint2.getLatitude();
                d3 += dPoint2.getLongitude();
            }
            return new DPoint(ep.b(d2 / ((double) list.size())), ep.b(d3 / ((double) list.size())));
        } catch (Throwable th) {
            ej.a(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cf, code lost:
        if (android.text.TextUtils.isEmpty(r19) != false) goto L_0x0068;
     */
    private void b(int i2, Bundle bundle) {
        int i3;
        String str;
        Throwable th;
        int i4;
        String str2;
        boolean z2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i5;
        boolean z3;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        List<GeoFence> arrayList2 = new ArrayList<>();
                        String string = bundle.getString("customId");
                        String string2 = bundle.getString("keyWords");
                        String string3 = bundle.getString("city");
                        String string4 = bundle.getString("poiType");
                        DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                        int i6 = bundle.getInt("searchSize", 10);
                        float f2 = bundle.getFloat("aroundRadius", 3000.0f);
                        if (TextUtils.isEmpty(string2)) {
                            str3 = "添加围栏失败";
                            z2 = false;
                        } else {
                            if (i2 != 1) {
                                if (i2 == 2) {
                                    if (dPoint == null) {
                                        str3 = "添加围栏失败";
                                    } else {
                                        try {
                                            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                                                str3 = "添加围栏失败";
                                                a(str3, 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = "errorCode";
                                            i3 = 0;
                                            try {
                                                ej.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                bundle2.putInt(str, 8);
                                                a(1000, bundle2);
                                            } catch (Throwable th3) {
                                                bundle2.putInt(str, i3);
                                                a(1000, bundle2);
                                                throw th3;
                                            }
                                        }
                                    }
                                }
                                str3 = "添加围栏失败";
                                z3 = true;
                                z2 = z3;
                            } else {
                                str3 = "添加围栏失败";
                            }
                            z3 = false;
                            z2 = z3;
                        }
                        if (z2) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("customId", string);
                            bundle3.putString("pendingIntentAction", this.d);
                            str5 = "customId";
                            str4 = "errorCode";
                            try {
                                bundle3.putLong("expiration", -1);
                                bundle3.putInt("activatesAction", this.f);
                                if (i2 == 1) {
                                    bundle3.putFloat("fenceRadius", 1000.0f);
                                    str6 = this.p.a(this.b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i6));
                                } else if (i2 == 2) {
                                    double b2 = ep.b(dPoint.getLatitude());
                                    double b3 = ep.b(dPoint.getLongitude());
                                    int intValue = Float.valueOf(f2).intValue();
                                    bundle3.putFloat("fenceRadius", 200.0f);
                                    str6 = this.p.a(this.b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i6), String.valueOf(b2), String.valueOf(b3), String.valueOf(intValue));
                                } else if (i2 != 3) {
                                    str6 = null;
                                } else {
                                    try {
                                        str6 = this.p.a(this.b, "http://restsdk.amap.com/v3/config/district?", string2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str = str4;
                                        i3 = 0;
                                        ej.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                        bundle2.putInt(str, 8);
                                        a(1000, bundle2);
                                    }
                                }
                                int i7 = 4;
                                if (str6 != null) {
                                    int a2 = 1 == i2 ? c.a(str6, arrayList2, bundle3) : 0;
                                    if (2 == i2) {
                                        a2 = c.a(str6, arrayList2, bundle3);
                                    }
                                    if (3 == i2) {
                                        a2 = this.q.b(str6, arrayList2, bundle3);
                                    }
                                    if (a2 != 10000) {
                                        if (a2 != 1 && a2 != 7 && a2 != 4 && a2 != 5 && a2 != 16 && a2 != 17) {
                                            switch (a2) {
                                                case 10000:
                                                    i5 = 0;
                                                    break;
                                                case 10001:
                                                case 10002:
                                                case 10007:
                                                case 10008:
                                                case 10009:
                                                case 10012:
                                                case 10013:
                                                    i5 = 7;
                                                    break;
                                                case 10003:
                                                case 10004:
                                                case 10005:
                                                case 10006:
                                                case 10010:
                                                case 10011:
                                                case 10014:
                                                case 10015:
                                                case 10016:
                                                case 10017:
                                                    i5 = 4;
                                                    break;
                                                default:
                                                    switch (a2) {
                                                        case 20000:
                                                        case 20001:
                                                        case 20002:
                                                            i5 = 1;
                                                            break;
                                                        case 20003:
                                                        default:
                                                            i5 = 8;
                                                            break;
                                                    }
                                            }
                                        } else {
                                            i5 = a2;
                                        }
                                        if (i5 != 0) {
                                            a(str3, i5, "searchErrCode is " + i5, new String[0]);
                                        }
                                        i3 = i5;
                                    } else if (arrayList2.isEmpty()) {
                                        i3 = 16;
                                    } else {
                                        i3 = a(arrayList2);
                                        if (i3 == 0) {
                                            try {
                                                arrayList.addAll(arrayList2);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                str = str4;
                                            }
                                        } else {
                                            i7 = i3;
                                        }
                                    }
                                }
                                i3 = i7;
                            } catch (Throwable th6) {
                                th = th6;
                                str = str4;
                                i3 = 0;
                                ej.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                bundle2.putInt(str, 8);
                                a(1000, bundle2);
                            }
                        } else {
                            str5 = "customId";
                            str4 = "errorCode";
                            i3 = 1;
                        }
                        bundle2.putString(str5, string);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        i4 = i3;
                        str2 = str4;
                        bundle2.putInt(str2, i4);
                        a(1000, bundle2);
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = "errorCode";
                    i3 = 0;
                    ej.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                    bundle2.putInt(str, 8);
                    a(1000, bundle2);
                }
            }
            str2 = "errorCode";
            i4 = 1;
            bundle2.putInt(str2, i4);
            a(1000, bundle2);
        } catch (Throwable th8) {
            th = th8;
            str = "errorCode";
            i3 = 0;
            ej.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
            bundle2.putInt(str, 8);
            a(1000, bundle2);
        }
    }

    private static boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        Throwable th;
        boolean z2 = true;
        try {
            if (a(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(ep.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && ep.b() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            ej.a(th, "Utils", "isFenceStatusChanged");
            return z2;
        }
    }

    private void k() {
        if (!this.o) {
            this.o = true;
        }
        if (!this.n) {
            try {
                this.h = Looper.myLooper() == null ? new c(this.b.getMainLooper()) : new c();
            } catch (Throwable th) {
                ej.a(th, "GeoFenceManger", "init 1");
            }
            try {
                b bVar = new b("fenceActionThread");
                this.f1354l = bVar;
                bVar.setPriority(5);
                this.f1354l.start();
                this.k = new HandlerC0073a(this.f1354l.getLooper());
            } catch (Throwable th2) {
                ej.a(th2, "GeoFenceManger", "init 2");
            }
            try {
                this.p = new b(this.b);
                this.q = new c();
                this.u = new AMapLocationClientOption();
                this.r = new AMapLocationClient(this.b);
                this.u.setLocationCacheEnable(true);
                this.u.setNeedAddress(false);
                this.r.setLocationListener(this.w);
                if (this.a == null) {
                    this.a = new en();
                }
            } catch (Throwable th3) {
                ej.a(th3, "GeoFenceManger", "initBase");
            }
            this.n = true;
            try {
                String str = this.d;
                if (str != null && this.c == null) {
                    a(str);
                }
            } catch (Throwable th4) {
                ej.a(th4, "GeoFenceManger", "init 4");
            }
            if (!A) {
                A = true;
                en.a(this.b, "O020", (JSONObject) null);
            }
        }
    }

    public final PendingIntent a(String str) {
        synchronized (this.z) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(k.c(this.b));
                this.c = PendingIntent.getBroadcast(this.b, 0, intent, 0);
                this.d = str;
                ArrayList<GeoFence> arrayList = this.g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        GeoFence next = it2.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            } catch (Throwable th) {
                ej.a(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.c;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x008a: INVOKE  (r1v2 long) =  type: STATIC call: com.loc.c.a():long)] */
    final GeoFence a(Bundle bundle, boolean z2) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z2) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = b(arrayList);
            }
            geoFence.setMaxDis2Center(b(dPoint, arrayList));
            geoFence.setMinDis2Center(a(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f2 = 1000.0f;
            float f3 = bundle.getFloat("fenceRadius", 1000.0f);
            if (f3 > 0.0f) {
                f2 = f3;
            }
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.f);
        geoFence.setCustomId(bundle.getString("customId"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1);
        geoFence.setPendingIntent(this.c);
        StringBuilder sb = new StringBuilder();
        sb.append(c.a());
        geoFence.setFenceId(sb.toString());
        en enVar = this.a;
        if (enVar != null) {
            enVar.a(this.b, 2);
        }
        return geoFence;
    }

    public final void a() {
        try {
            this.o = false;
            a(10, (Bundle) null, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void a(int i2) {
        try {
            k();
            if (i2 > 7 || i2 <= 0) {
                i2 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i2);
            a(9, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    final void a(int i2, Bundle bundle) {
        try {
            synchronized (this.j) {
                c cVar = this.h;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.h.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    final void a(int i2, Bundle bundle, long j2) {
        try {
            synchronized (this.i) {
                HandlerC0073a aVar = this.k;
                if (aVar != null) {
                    Message obtainMessage = aVar.obtainMessage();
                    obtainMessage.what = i2;
                    obtainMessage.setData(bundle);
                    this.k.sendMessageDelayed(obtainMessage, j2);
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    final void a(Bundle bundle) {
        int i2 = 1;
        if (bundle != null) {
            try {
                i2 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                ej.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f != i2) {
            ArrayList<GeoFence> arrayList = this.g;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> it2 = this.g.iterator();
                while (it2.hasNext()) {
                    GeoFence next = it2.next();
                    next.setStatus(0);
                    next.setEnterTime(-1);
                }
            }
            d();
        }
        this.f = i2;
    }

    public final void a(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    final void a(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.y || (arrayList = this.g) == null) {
                return;
            }
            if (!arrayList.isEmpty()) {
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                    Iterator<GeoFence> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        GeoFence next = it2.next();
                        if (next.isAble() && b(aMapLocation, next) && a(next, this.f)) {
                            next.setCurrentLocation(aMapLocation);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("geoFence", next);
                            a(1001, bundle);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void a(DPoint dPoint, float f2, String str) {
        try {
            k();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f2);
            bundle.putString("customId", str);
            a(0, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void a(String str, String str2) {
        try {
            k();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("customId", str2);
            a(4, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void a(String str, String str2, DPoint dPoint, float f2, int i2, String str3) {
        try {
            k();
            if (f2 <= 0.0f || f2 > 50000.0f) {
                f2 = 3000.0f;
            }
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f2);
            bundle.putInt("searchSize", i2);
            bundle.putString("customId", str3);
            a(3, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void a(String str, String str2, String str3, int i2, String str4) {
        try {
            k();
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i2 > 25) {
                i2 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i2);
            bundle.putString("customId", str4);
            a(2, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void a(String str, boolean z2) {
        try {
            k();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z2);
            a(12, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void a(List<DPoint> list, String str) {
        try {
            k();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString("customId", str);
            a(1, bundle, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean a(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.g;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    if (!this.g.contains(geoFence)) {
                        return false;
                    }
                    if (this.g.size() == 1) {
                        this.o = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    a(11, bundle, 0);
                    return true;
                }
            }
            this.o = false;
            a(10, (Bundle) null, 0);
            return true;
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    final int b(GeoFence geoFence) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            if (this.g.contains(geoFence)) {
                return 17;
            }
            this.g.add(geoFence);
            return 0;
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    public final List<GeoFence> b() {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            return (ArrayList) this.g.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    final void b(int i2) {
        try {
            synchronized (this.i) {
                HandlerC0073a aVar = this.k;
                if (aVar != null) {
                    aVar.removeMessages(i2);
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    final void b(Bundle bundle) {
        b(2, bundle);
    }

    final void c() {
        try {
            if (this.n) {
                ArrayList<GeoFence> arrayList = this.g;
                if (arrayList != null) {
                    arrayList.clear();
                    this.g = null;
                }
                if (!this.o) {
                    try {
                        synchronized (this.i) {
                            HandlerC0073a aVar = this.k;
                            if (aVar != null) {
                                aVar.removeCallbacksAndMessages(null);
                            }
                            this.k = null;
                        }
                    } catch (Throwable th) {
                        ej.a(th, "GeoFenceManager", "destroyActionHandler");
                    }
                    AMapLocationClient aMapLocationClient = this.r;
                    if (aMapLocationClient != null) {
                        aMapLocationClient.stopLocation();
                        this.r.onDestroy();
                    }
                    this.r = null;
                    if (this.f1354l != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.f1354l.quitSafely();
                        } else {
                            this.f1354l.quit();
                        }
                    }
                    this.f1354l = null;
                    this.p = null;
                    synchronized (this.z) {
                        PendingIntent pendingIntent = this.c;
                        if (pendingIntent != null) {
                            pendingIntent.cancel();
                        }
                        this.c = null;
                    }
                    try {
                        synchronized (this.j) {
                            c cVar = this.h;
                            if (cVar != null) {
                                cVar.removeCallbacksAndMessages(null);
                            }
                            this.h = null;
                        }
                    } catch (Throwable th2) {
                        ej.a(th2, "GeoFenceManager", "destroyResultHandler");
                    }
                    en enVar = this.a;
                    if (enVar != null) {
                        enVar.b(this.b);
                    }
                    this.m = false;
                    this.n = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    final void c(int i2) {
        try {
            if (this.b != null) {
                synchronized (this.z) {
                    if (this.c != null) {
                        Intent intent = new Intent();
                        intent.putExtras(a((GeoFence) null, (String) null, (String) null, 4, i2));
                        this.c.send(this.b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    final void c(Bundle bundle) {
        b(1, bundle);
    }

    final void c(GeoFence geoFence) {
        PendingIntent pendingIntent;
        Context context;
        try {
            synchronized (this.z) {
                if (this.b != null) {
                    if (this.c != null || geoFence.getPendingIntent() != null) {
                        Intent intent = new Intent();
                        intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                        String str = this.d;
                        if (str != null) {
                            intent.setAction(str);
                        }
                        intent.setPackage(k.c(this.b));
                        if (geoFence.getPendingIntent() != null) {
                            pendingIntent = geoFence.getPendingIntent();
                            context = this.b;
                        } else {
                            pendingIntent = this.c;
                            context = this.b;
                        }
                        pendingIntent.send(context, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    final void d() {
        if (!this.y && this.k != null) {
            boolean z2 = false;
            if (this.s != null && ep.a(this.s) && ep.b() - this.t < 10000) {
                z2 = true;
            }
            if (z2) {
                a(6, (Bundle) null, 0);
                a(5, (Bundle) null, 0);
                return;
            }
            b(7);
            a(7, (Bundle) null, 0);
        }
    }

    final void d(Bundle bundle) {
        b(3, bundle);
    }

    final void e() {
        try {
            if (this.m) {
                b(8);
            }
            AMapLocationClient aMapLocationClient = this.r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.m = false;
        } catch (Throwable unused) {
        }
    }

    final void e(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z2 = true;
                        boolean z3 = bundle.getBoolean("ab", true);
                        ArrayList<GeoFence> arrayList = this.g;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator<GeoFence> it2 = this.g.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                GeoFence next = it2.next();
                                if (next.getFenceId().equals(string)) {
                                    next.setAble(z3);
                                    break;
                                }
                            }
                        }
                        if (!z3) {
                            ArrayList<GeoFence> arrayList2 = this.g;
                            if (arrayList2 != null) {
                                if (!arrayList2.isEmpty()) {
                                    Iterator<GeoFence> it3 = this.g.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (it3.next().isAble()) {
                                                z2 = false;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (z2) {
                                h();
                                return;
                            }
                            return;
                        }
                        d();
                    }
                }
            } catch (Throwable th) {
                ej.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    final void f() {
        float f2;
        float f3;
        try {
            if (!this.y && ep.a(this.s)) {
                AMapLocation aMapLocation = this.s;
                ArrayList<GeoFence> arrayList = this.g;
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && arrayList != null && !arrayList.isEmpty()) {
                    DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    Iterator<GeoFence> it2 = arrayList.iterator();
                    f3 = Float.MAX_VALUE;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        GeoFence next = it2.next();
                        if (next.isAble()) {
                            float a2 = ep.a(dPoint, next.getCenter());
                            if (a2 > next.getMinDis2Center() && a2 < next.getMaxDis2Center()) {
                                f2 = 0.0f;
                                break;
                            }
                            if (a2 > next.getMaxDis2Center()) {
                                f3 = Math.min(f3, a2 - next.getMaxDis2Center());
                            }
                            if (a2 < next.getMinDis2Center()) {
                                f3 = Math.min(f3, next.getMinDis2Center() - a2);
                            }
                        }
                    }
                } else {
                    f3 = Float.MAX_VALUE;
                }
                f2 = f3;
                if (f2 != Float.MAX_VALUE) {
                    if (f2 < 1000.0f) {
                        b(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong("interval", 2000);
                        a(8, bundle, 500);
                    } else if (f2 < 5000.0f) {
                        e();
                        b(7);
                        a(7, (Bundle) null, 10000);
                    } else {
                        e();
                        b(7);
                        a(7, (Bundle) null, (long) (((f2 - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    final void f(Bundle bundle) {
        try {
            if (this.g != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.g.contains(geoFence)) {
                    this.g.remove(geoFence);
                }
                if (this.g.size() <= 0) {
                    c();
                } else {
                    d();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        try {
            k();
            this.y = true;
            a(13, (Bundle) null, 0);
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    final void h() {
        try {
            b(7);
            b(8);
            AMapLocationClient aMapLocationClient = this.r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void i() {
        try {
            k();
            if (this.y) {
                this.y = false;
                d();
            }
        } catch (Throwable th) {
            ej.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final boolean j() {
        return this.y;
    }
}
