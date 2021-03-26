package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CgiManager */
public final class gn {
    int a = 0;
    ArrayList<gm> b = new ArrayList<>();
    TelephonyManager c = null;
    long d = 0;
    CellLocation e;
    boolean f = false;
    PhoneStateListener g = null;
    String h = null;
    boolean i = false;
    StringBuilder j = null;
    HandlerThread k = null;
    private Context l;
    private String m = null;
    private ArrayList<gm> n = new ArrayList<>();
    private int o = -113;
    private gl p = null;
    private Object q;
    private int r = 0;
    private long s = 0;
    private boolean t = false;
    private Object u = new Object();

    /* compiled from: CgiManager */
    class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (gn.this.u) {
                    if (!gn.this.t) {
                        gn.this.k();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public gn(Context context) {
        this.l = context;
        if (this.c == null) {
            this.c = (TelephonyManager) gy.a(context, "phone");
        }
        j();
        this.p = new gl();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = gw.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.telephony.cdma.CdmaCellLocation] */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        r11 = null;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    private CellLocation a(List<CellInfo> list) {
        gm gmVar;
        GsmCellLocation gsmCellLocation;
        ?? r1;
        GsmCellLocation gsmCellLocation2 = null;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                CellInfo cellInfo = list.get(i2);
                if (cellInfo != null) {
                    try {
                        boolean isRegistered = cellInfo.isRegistered();
                        if (!(cellInfo instanceof CellInfoCdma)) {
                            if (!(cellInfo instanceof CellInfoGsm)) {
                                if (!(cellInfo instanceof CellInfoWcdma)) {
                                    if (!(cellInfo instanceof CellInfoLte)) {
                                        break;
                                    }
                                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                    if (a(cellInfoLte.getCellIdentity())) {
                                        gmVar = a(cellInfoLte, isRegistered);
                                        break;
                                    }
                                } else {
                                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                    if (a(cellInfoWcdma.getCellIdentity())) {
                                        gmVar = a(cellInfoWcdma, isRegistered);
                                        break;
                                    }
                                }
                            } else {
                                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                                if (a(cellInfoGsm.getCellIdentity())) {
                                    gmVar = a(cellInfoGsm, isRegistered);
                                    break;
                                }
                            }
                        } else {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            if (a(cellInfoCdma.getCellIdentity())) {
                                gmVar = a(cellInfoCdma, isRegistered);
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        continue;
                    }
                }
                i2++;
            }
            if (gmVar != null) {
                try {
                    if (gmVar.k == 2) {
                        r1 = new CdmaCellLocation();
                        try {
                            r1.setCellLocationData(gmVar.i, gmVar.e, gmVar.f, gmVar.g, gmVar.h);
                        } catch (Throwable unused2) {
                        }
                        gsmCellLocation = gsmCellLocation2;
                        gsmCellLocation2 = r1;
                    } else {
                        gsmCellLocation = new GsmCellLocation();
                        try {
                            gsmCellLocation.setLacAndCid(gmVar.c, gmVar.d);
                        } catch (Throwable unused3) {
                            r1 = 0;
                            gsmCellLocation2 = gsmCellLocation;
                        }
                    }
                } catch (Throwable unused4) {
                    r1 = 0;
                }
            } else {
                gsmCellLocation = null;
            }
            if (gsmCellLocation2 == null) {
                return gsmCellLocation;
            }
        }
        return gsmCellLocation2;
    }

    private static gm a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        gm gmVar = new gm(i2, z);
        gmVar.a = i3;
        gmVar.b = i4;
        gmVar.c = i5;
        gmVar.d = i6;
        gmVar.j = i7;
        return gmVar;
    }

    private gm a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] a2 = gy.a(this.c);
        try {
            i4 = Integer.parseInt(a2[0]);
            try {
                i2 = Integer.parseInt(a2[1]);
                i3 = i4;
            } catch (Throwable unused) {
                i3 = i4;
                i2 = 0;
                gm a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a3.g = cellIdentity.getSystemId();
                a3.h = cellIdentity.getNetworkId();
                a3.i = cellIdentity.getBasestationId();
                a3.e = cellIdentity.getLatitude();
                a3.f = cellIdentity.getLongitude();
                return a3;
            }
        } catch (Throwable unused2) {
            i4 = 0;
            i3 = i4;
            i2 = 0;
            gm a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            a3.g = cellIdentity.getSystemId();
            a3.h = cellIdentity.getNetworkId();
            a3.i = cellIdentity.getBasestationId();
            a3.e = cellIdentity.getLatitude();
            a3.f = cellIdentity.getLongitude();
            return a3;
        }
        gm a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        a3.g = cellIdentity.getSystemId();
        a3.h = cellIdentity.getNetworkId();
        a3.i = cellIdentity.getBasestationId();
        a3.e = cellIdentity.getLatitude();
        a3.f = cellIdentity.getLongitude();
        return a3;
    }

    private static gm a(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    private static gm a(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        gm a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPci();
        return a2;
    }

    private static gm a(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        gm a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPsc();
        return a2;
    }

    private static gm a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            gm gmVar = new gm(1, false);
            gmVar.a = Integer.parseInt(strArr[0]);
            gmVar.b = Integer.parseInt(strArr[1]);
            gmVar.c = gw.b(neighboringCellInfo, "getLac", new Object[0]);
            gmVar.d = neighboringCellInfo.getCid();
            gmVar.j = gy.a(neighboringCellInfo.getRssi());
            return gmVar;
        } catch (Throwable th) {
            gu.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void a(CellLocation cellLocation, String[] strArr) {
        gm a2;
        if (!(cellLocation == null || this.c == null)) {
            this.b.clear();
            if (b(cellLocation)) {
                this.a = 1;
                List<NeighboringCellInfo> list = null;
                this.b.add(c(cellLocation, strArr));
                if (Build.VERSION.SDK_INT <= 28) {
                    list = (List) gw.a(this.c, "getNeighboringCellInfo", new Object[0]);
                }
                if (!(list == null || list.isEmpty())) {
                    for (NeighboringCellInfo neighboringCellInfo : list) {
                        if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (a2 = a(neighboringCellInfo, strArr)) != null && !this.b.contains(a2)) {
                            this.b.add(a2);
                        }
                    }
                }
            }
        }
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 15;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    private static boolean a(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    private static boolean a(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && c(cellIdentityGsm.getLac()) && d(cellIdentityGsm.getCid());
    }

    private static boolean a(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && c(cellIdentityLte.getTac()) && d(cellIdentityLte.getCi());
    }

    private static boolean a(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && c(cellIdentityWcdma.getLac()) && d(cellIdentityWcdma.getCid());
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        ArrayList<gm> arrayList;
        if (i2 == -113) {
            this.o = -113;
            return;
        }
        this.o = i2;
        int i3 = this.a;
        if ((i3 == 1 || i3 == 2) && (arrayList = this.b) != null && !arrayList.isEmpty()) {
            try {
                this.b.get(0).j = this.o;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[RETURN] */
    private void b(CellLocation cellLocation, String[] strArr) {
        boolean z;
        if (cellLocation != null) {
            this.b.clear();
            if (gy.c() >= 5) {
                try {
                    boolean z2 = true;
                    if (this.q != null) {
                        try {
                            Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                            if (!declaredField.isAccessible()) {
                                declaredField.setAccessible(true);
                            }
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                            if (gsmCellLocation != null && b(gsmCellLocation)) {
                                a(gsmCellLocation, strArr);
                                z = true;
                                if (z) {
                                    return;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    if (b(cellLocation)) {
                        this.a = 2;
                        gm gmVar = new gm(2, true);
                        gmVar.a = Integer.parseInt(strArr[0]);
                        gmVar.b = Integer.parseInt(strArr[1]);
                        gmVar.g = gw.b(cellLocation, "getSystemId", new Object[0]);
                        gmVar.h = gw.b(cellLocation, "getNetworkId", new Object[0]);
                        gmVar.i = gw.b(cellLocation, "getBaseStationId", new Object[0]);
                        gmVar.j = this.o;
                        gmVar.e = gw.b(cellLocation, "getBaseStationLatitude", new Object[0]);
                        gmVar.f = gw.b(cellLocation, "getBaseStationLongitude", new Object[0]);
                        if (gmVar.e != gmVar.f || gmVar.e <= 0) {
                            z2 = false;
                        }
                        if (gmVar.e < 0 || gmVar.f < 0 || gmVar.e == Integer.MAX_VALUE || gmVar.f == Integer.MAX_VALUE || z2) {
                            gmVar.e = 0;
                            gmVar.f = 0;
                        }
                        if (!this.b.contains(gmVar)) {
                            this.b.add(gmVar);
                        }
                    }
                } catch (Throwable th) {
                    gu.a(th, "CgiManager", "hdlCdmaLocChange");
                }
            }
        }
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.i || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            gu.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private gm c(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        gm gmVar = new gm(1, true);
        gmVar.a = gy.d(strArr[0]);
        gmVar.b = gy.d(strArr[1]);
        gmVar.c = gsmCellLocation.getLac();
        gmVar.d = gsmCellLocation.getCid();
        gmVar.j = this.o;
        return gmVar;
    }

    private static boolean c(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean d(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    private void j() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            try {
                this.a = c(telephonyManager.getCellLocation());
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                gu.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                int u2 = u();
                this.r = u2;
                this.q = u2 != 1 ? u2 != 2 ? gy.a(this.l, "phone2") : gy.a(this.l, "phone2") : gy.a(this.l, "phone_msim");
            } catch (Throwable unused) {
            }
            if (this.k == null) {
                a aVar = new a("listenerPhoneStateThread");
                this.k = aVar;
                aVar.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        int i2;
        this.g = new PhoneStateListener() {
            /* class com.amap.api.mapcore2d.gn.AnonymousClass1 */

            @Override // android.telephony.PhoneStateListener
            public final void onCellLocationChanged(CellLocation cellLocation) {
                try {
                    if (gn.this.a(cellLocation)) {
                        gn.this.e = cellLocation;
                        gn.this.f = true;
                        gn.this.s = gy.b();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onServiceStateChanged(ServiceState serviceState) {
                try {
                    int state = serviceState.getState();
                    if (state == 0) {
                        gn.this.f();
                    } else if (state == 1) {
                        gn.this.h();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onSignalStrengthChanged(int i) {
                int i2 = -113;
                try {
                    int i3 = gn.this.a;
                    if (i3 == 1 || i3 == 2) {
                        i2 = gy.a(i);
                    }
                    gn.this.b(i2);
                } catch (Throwable unused) {
                }
            }

            @Override // android.telephony.PhoneStateListener
            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength != null) {
                    int i = -113;
                    try {
                        int i2 = gn.this.a;
                        if (i2 == 1) {
                            i = gy.a(signalStrength.getGsmSignalStrength());
                        } else if (i2 == 2) {
                            i = signalStrength.getCdmaDbm();
                        }
                        gn.this.b(i);
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        try {
            i2 = gw.b("android.telephony.PhoneStateListener", gy.c() < 7 ? "LISTEN_SIGNAL_STRENGTH" : "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            try {
                this.c.listen(this.g, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                this.c.listen(this.g, i2 | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private CellLocation l() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.h = null;
                if (b(cellLocation)) {
                    this.e = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            } catch (Throwable th) {
                this.h = null;
                gu.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean m() {
        return !this.i && gy.b() - this.d >= 10000;
    }

    private void n() {
        h();
    }

    private void o() {
        int d2 = d();
        if (d2 != 1) {
            if (d2 == 2 && this.b.isEmpty()) {
                this.a = 0;
            }
        } else if (this.b.isEmpty()) {
            this.a = 0;
        }
    }

    private void p() {
        if (!this.i && this.c != null) {
            CellLocation q2 = q();
            if (!b(q2)) {
                q2 = r();
            }
            if (b(q2)) {
                this.e = q2;
                this.s = gy.b();
            } else if (gy.b() - this.s > 60000) {
                this.e = null;
                this.b.clear();
                this.n.clear();
            }
        }
        this.f = true;
        if (b(this.e)) {
            String[] a2 = gy.a(this.c);
            int c2 = c(this.e);
            if (c2 == 1) {
                a(this.e, a2);
            } else if (c2 == 2) {
                b(this.e, a2);
            }
        }
        try {
            if (gy.c() >= 18) {
                t();
            }
        } catch (Throwable unused) {
        }
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.a |= 8;
            }
        }
    }

    private CellLocation q() {
        TelephonyManager telephonyManager = this.c;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation l2 = l();
        if (b(l2)) {
            return l2;
        }
        if (gy.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.h = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        return a2 != null ? a2 : a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation r() {
        Object obj = this.q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> s2 = s();
            if (s2.isInstance(obj)) {
                Object cast = s2.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            gu.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> s() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i2 = this.r;
        try {
            return systemClassLoader.loadClass(i2 != 0 ? i2 != 1 ? i2 != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            gu.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d  */
    private void t() {
        List<CellInfo> list;
        int size;
        int i2;
        gm a2;
        long min;
        SecurityException e2;
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            ArrayList<gm> arrayList = this.n;
            gl glVar = this.p;
            try {
                list = telephonyManager.getAllCellInfo();
                try {
                    this.h = null;
                } catch (SecurityException e3) {
                    e2 = e3;
                }
            } catch (SecurityException e4) {
                e2 = e4;
                list = null;
                this.h = e2.getMessage();
                if (arrayList != null) {
                }
                while (i2 < size) {
                }
                if (arrayList != null) {
                    return;
                }
            }
            if (!(list == null || (size = list.size()) == 0)) {
                if (arrayList != null) {
                    arrayList.clear();
                }
                for (i2 = 0; i2 < size; i2++) {
                    CellInfo cellInfo = list.get(i2);
                    if (cellInfo != null) {
                        try {
                            boolean isRegistered = cellInfo.isRegistered();
                            if (cellInfo instanceof CellInfoCdma) {
                                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                if (a(cellInfoCdma.getCellIdentity())) {
                                    a2 = a(cellInfoCdma, isRegistered);
                                    min = Math.min(65535L, glVar.a(a2));
                                }
                            } else if (cellInfo instanceof CellInfoGsm) {
                                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                                if (a(cellInfoGsm.getCellIdentity())) {
                                    a2 = a(cellInfoGsm, isRegistered);
                                    min = Math.min(65535L, glVar.a(a2));
                                }
                            } else if (cellInfo instanceof CellInfoWcdma) {
                                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                if (a(cellInfoWcdma.getCellIdentity())) {
                                    a2 = a(cellInfoWcdma, isRegistered);
                                    min = Math.min(65535L, glVar.a(a2));
                                }
                            } else if (cellInfo instanceof CellInfoLte) {
                                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                if (a(cellInfoLte.getCellIdentity())) {
                                    a2 = a(cellInfoLte, isRegistered);
                                    min = Math.min(65535L, glVar.a(a2));
                                }
                            }
                            a2.l = (short) ((int) min);
                            arrayList.add(a2);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.a |= 4;
                glVar.a(arrayList);
            }
        }
    }

    private int u() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.r = 1;
        } catch (Throwable unused) {
        }
        if (this.r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.r = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.r;
    }

    public final ArrayList<gm> a() {
        return this.b;
    }

    final boolean a(CellLocation cellLocation) {
        Throwable th;
        String str;
        boolean z = false;
        if (cellLocation == null) {
            return false;
        }
        int c2 = c(cellLocation);
        if (c2 == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_GSM_T";
            }
        } else if (c2 != 2) {
            return true;
        } else {
            try {
                if (gw.b(cellLocation, "getSystemId", new Object[0]) > 0 && gw.b(cellLocation, "getNetworkId", new Object[0]) >= 0 && gw.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                    z = true;
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                str = "cgiUseful Cgi.I_CDMA_T";
                gu.a(th, "CgiManager", str);
                return true;
            }
        }
    }

    public final ArrayList<gm> b() {
        return this.n;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.a & 3;
    }

    public final TelephonyManager e() {
        return this.c;
    }

    public final void f() {
        try {
            this.i = gy.a(this.l);
            if (m() || this.b.isEmpty()) {
                p();
                this.d = gy.b();
            }
            if (this.i) {
                n();
            } else {
                o();
            }
        } catch (SecurityException e2) {
            this.h = e2.getMessage();
        } catch (Throwable th) {
            gu.a(th, "CgiManager", "refresh");
        }
    }

    public final void g() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0;
        synchronized (this.u) {
            this.t = true;
        }
        TelephonyManager telephonyManager = this.c;
        if (!(telephonyManager == null || (phoneStateListener = this.g) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                gu.a(th, "CgiManager", "destroy");
            }
        }
        this.g = null;
        HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.k = null;
        }
        this.o = -113;
        this.c = null;
        this.q = null;
    }

    final void h() {
        this.h = null;
        this.e = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String i() {
        return this.m;
    }
}
