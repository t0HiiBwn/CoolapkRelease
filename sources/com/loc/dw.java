package com.loc;

import android.content.Context;
import android.os.Build;
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
public final class dw {
    private static int r;
    private static boolean v;
    int a = 0;
    ArrayList<dv> b = new ArrayList<>();
    ArrayList<cw> c = new ArrayList<>();
    TelephonyManager d = null;
    long e = 0;
    CellLocation f;
    boolean g = false;
    PhoneStateListener h = null;
    String i = null;
    boolean j = false;
    StringBuilder k = null;
    private Context l;
    private String m = null;
    private ArrayList<dv> n = new ArrayList<>();
    private int o = -113;
    private du p = null;
    private Object q;
    private long s = 0;
    private TelephonyManager.CellInfoCallback t;
    private boolean u = false;
    private Cdo w;
    private boolean x = false;
    private Object y = new Object();

    /* compiled from: CgiManager */
    class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            dw.this.u = true;
            CellLocation a2 = dw.this.a(list);
            if (a2 != null) {
                dw.this.f = a2;
                dw.this.g = true;
                dw.this.a(false);
                dw.this.s = ep.b();
            }
        }
    }

    /* compiled from: CgiManager */
    class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (dw.this.w != null) {
                    dw.this.w.c();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            try {
                if (dw.this.a(cellLocation)) {
                    dw.this.f = cellLocation;
                    dw.this.g = true;
                    dw.this.a(false);
                    dw.this.s = ep.b();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    dw.this.a(false, false);
                } else if (state == 1) {
                    dw.this.i();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            int i2 = -113;
            try {
                int i3 = dw.this.a;
                if (i3 == 1 || i3 == 2) {
                    i2 = ep.a(i);
                }
                dw.this.b(i2);
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                int i = -113;
                try {
                    int i2 = dw.this.a;
                    if (i2 == 1) {
                        i = ep.a(signalStrength.getGsmSignalStrength());
                    } else if (i2 == 2) {
                        i = signalStrength.getCdmaDbm();
                    }
                    dw.this.b(i);
                    if (dw.this.w != null) {
                        dw.this.w.c();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public dw(Context context) {
        Object a2;
        this.l = context;
        if (this.d == null) {
            this.d = (TelephonyManager) ep.a(context, "phone");
        }
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                this.a = c(telephonyManager.getCellLocation());
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            } catch (Throwable th) {
                this.i = null;
                ej.a(th, "CgiManager", "CgiManager");
                this.a = 0;
            }
            try {
                int i2 = r;
                if (i2 != 1) {
                    a2 = ep.a(i2 != 2 ? this.l : this.l, "phone2");
                } else {
                    a2 = ep.a(this.l, "phone_msim");
                }
                this.q = a2;
            } catch (Throwable unused) {
            }
            ab.d().submit(new Runnable() {
                /* class com.loc.dw.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (dw.this.y) {
                        if (!dw.this.x) {
                            dw.c(dw.this);
                        }
                    }
                }
            });
        }
        this.p = new du();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = em.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.telephony.cdma.CdmaCellLocation] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public synchronized CellLocation a(List<CellInfo> list) {
        GsmCellLocation gsmCellLocation;
        GsmCellLocation gsmCellLocation2;
        ?? r11;
        gsmCellLocation = null;
        if (list != null) {
            if (!list.isEmpty()) {
                dv dvVar = null;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    CellInfo cellInfo = list.get(i2);
                    if (cellInfo != null) {
                        try {
                            dvVar = a(cellInfo);
                            if (dvVar != null) {
                                break;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
                if (dvVar != null) {
                    try {
                        if (dvVar.k == 2) {
                            r11 = new CdmaCellLocation();
                            try {
                                r11.setCellLocationData(dvVar.i, dvVar.e, dvVar.f, dvVar.g, dvVar.h);
                            } catch (Throwable unused2) {
                            }
                            gsmCellLocation = r11;
                            gsmCellLocation2 = gsmCellLocation;
                        } else {
                            gsmCellLocation2 = new GsmCellLocation();
                            try {
                                gsmCellLocation2.setLacAndCid(dvVar.c, dvVar.d);
                            } catch (Throwable unused3) {
                                gsmCellLocation = gsmCellLocation2;
                                r11 = 0;
                            }
                        }
                    } catch (Throwable unused4) {
                        r11 = 0;
                    }
                } else {
                    gsmCellLocation2 = null;
                }
            }
        }
        return null;
        return gsmCellLocation == null ? gsmCellLocation2 : gsmCellLocation;
    }

    private static dv a(int i2, boolean z, int i3, int i4, int i5, int i6, int i7) {
        dv dvVar = new dv(i2, z);
        dvVar.a = i3;
        dvVar.b = i4;
        dvVar.c = i5;
        dvVar.d = i6;
        dvVar.j = i7;
        return dvVar;
    }

    private dv a(CellInfo cellInfo) {
        dv dvVar;
        CellInfoLte cellInfoLte;
        int pci;
        boolean isRegistered = cellInfo.isRegistered();
        if (cellInfo instanceof CellInfoCdma) {
            dvVar = a((CellInfoCdma) cellInfo, isRegistered);
        } else if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
                return null;
            }
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (!c(cellIdentity.getLac()) || !d(cellIdentity.getCid())) {
                return null;
            }
            dvVar = a(1, isRegistered, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        } else {
            if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
                    return null;
                }
                CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                if (!c(cellIdentity2.getLac()) || !d(cellIdentity2.getCid())) {
                    return null;
                }
                dvVar = a(4, isRegistered, cellIdentity2.getMcc(), cellIdentity2.getMnc(), cellIdentity2.getLac(), cellIdentity2.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
                pci = cellIdentity2.getPsc();
            } else if (!(cellInfo instanceof CellInfoLte) || (cellInfoLte = (CellInfoLte) cellInfo) == null || cellInfoLte.getCellIdentity() == null) {
                return null;
            } else {
                CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                if (!c(cellIdentity3.getTac()) || !d(cellIdentity3.getCi())) {
                    return null;
                }
                dvVar = a(3, isRegistered, cellIdentity3.getMcc(), cellIdentity3.getMnc(), cellIdentity3.getTac(), cellIdentity3.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
                pci = cellIdentity3.getPci();
            }
            dvVar.o = pci;
        }
        return dvVar;
    }

    private dv a(CellInfoCdma cellInfoCdma, boolean z) {
        int i2;
        int i3;
        int i4;
        if (!(cellInfoCdma == null || cellInfoCdma.getCellIdentity() == null)) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a2 = ep.a(this.d);
                try {
                    i4 = Integer.parseInt(a2[0]);
                    try {
                        i2 = Integer.parseInt(a2[1]);
                        i3 = i4;
                    } catch (Throwable unused) {
                        i3 = i4;
                        i2 = 0;
                        dv a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a3.g = cellIdentity2.getSystemId();
                        a3.h = cellIdentity2.getNetworkId();
                        a3.i = cellIdentity2.getBasestationId();
                        a3.e = cellIdentity2.getLatitude();
                        a3.f = cellIdentity2.getLongitude();
                        return a3;
                    }
                } catch (Throwable unused2) {
                    i4 = 0;
                    i3 = i4;
                    i2 = 0;
                    dv a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    a3.g = cellIdentity2.getSystemId();
                    a3.h = cellIdentity2.getNetworkId();
                    a3.i = cellIdentity2.getBasestationId();
                    a3.e = cellIdentity2.getLatitude();
                    a3.f = cellIdentity2.getLongitude();
                    return a3;
                }
                dv a3 = a(2, z, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a3.g = cellIdentity2.getSystemId();
                a3.h = cellIdentity2.getNetworkId();
                a3.i = cellIdentity2.getBasestationId();
                a3.e = cellIdentity2.getLatitude();
                a3.f = cellIdentity2.getLongitude();
                return a3;
            }
        }
        return null;
    }

    private static dv a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            dv dvVar = new dv(1, false);
            dvVar.a = Integer.parseInt(strArr[0]);
            dvVar.b = Integer.parseInt(strArr[1]);
            dvVar.c = em.b(neighboringCellInfo, "getLac", new Object[0]);
            dvVar.d = neighboringCellInfo.getCid();
            dvVar.j = ep.a(neighboringCellInfo.getRssi());
            return dvVar;
        } catch (Throwable th) {
            ej.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private synchronized void a(CellLocation cellLocation, String[] strArr, boolean z) {
        dv a2;
        if (cellLocation != null) {
            if (this.d != null) {
                this.b.clear();
                if (b(cellLocation)) {
                    this.a = 1;
                    ArrayList<dv> arrayList = this.b;
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    dv dvVar = new dv(1, true);
                    dvVar.a = ep.g(strArr[0]);
                    dvVar.b = ep.g(strArr[1]);
                    dvVar.c = gsmCellLocation.getLac();
                    dvVar.d = gsmCellLocation.getCid();
                    dvVar.j = this.o;
                    arrayList.add(dvVar);
                    if (!z) {
                        if (Build.VERSION.SDK_INT <= 28) {
                            List<NeighboringCellInfo> list = (List) em.a(this.d, "getNeighboringCellInfo", new Object[0]);
                            if (list != null && !list.isEmpty()) {
                                for (NeighboringCellInfo neighboringCellInfo : list) {
                                    if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (a2 = a(neighboringCellInfo, strArr)) != null && !this.b.contains(a2)) {
                                        this.b.add(a2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[DONT_GENERATE] */
    public synchronized void a(boolean z) {
        boolean z2;
        String[] a2 = ep.a(this.d);
        int c2 = c(this.f);
        boolean z3 = true;
        if (c2 != 1) {
            if (c2 == 2) {
                CellLocation cellLocation = this.f;
                if (cellLocation != null) {
                    this.b.clear();
                    try {
                        if (this.q != null) {
                            try {
                                Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                                if (!declaredField.isAccessible()) {
                                    declaredField.setAccessible(true);
                                }
                                GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                                if (gsmCellLocation != null && b(gsmCellLocation)) {
                                    a(gsmCellLocation, a2, z);
                                    z2 = true;
                                    if (z2) {
                                        return;
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            z2 = false;
                            if (z2) {
                            }
                        }
                        if (b(cellLocation)) {
                            this.a = 2;
                            dv dvVar = new dv(2, true);
                            dvVar.a = Integer.parseInt(a2[0]);
                            dvVar.b = Integer.parseInt(a2[1]);
                            dvVar.g = em.b(cellLocation, "getSystemId", new Object[0]);
                            dvVar.h = em.b(cellLocation, "getNetworkId", new Object[0]);
                            dvVar.i = em.b(cellLocation, "getBaseStationId", new Object[0]);
                            dvVar.j = this.o;
                            dvVar.e = em.b(cellLocation, "getBaseStationLatitude", new Object[0]);
                            dvVar.f = em.b(cellLocation, "getBaseStationLongitude", new Object[0]);
                            if (dvVar.e != dvVar.f || dvVar.e <= 0) {
                                z3 = false;
                            }
                            if (dvVar.e < 0 || dvVar.f < 0 || dvVar.e == Integer.MAX_VALUE || dvVar.f == Integer.MAX_VALUE || z3) {
                                dvVar.e = 0;
                                dvVar.f = 0;
                            }
                            if (!this.b.contains(dvVar)) {
                                this.b.add(dvVar);
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        ej.a(th, "CgiManager", "hdlCdmaLocChange");
                    }
                }
            }
            return;
        }
        a(this.f, a2, z);
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 15;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    /* access modifiers changed from: private */
    public synchronized void b(int i2) {
        ArrayList<dv> arrayList;
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

    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0114  */
    private synchronized void b(boolean z, boolean z2) {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        List<CellInfo> list;
        int size;
        SecurityException e2;
        if (!this.j && this.d != null) {
            if (Build.VERSION.SDK_INT >= 29 && this.l.getApplicationInfo().targetSdkVersion >= 29) {
                if (this.t == null) {
                    this.t = new a();
                }
                this.d.requestCellInfoUpdate(ab.d(), this.t);
                if (z2 || z) {
                    int i2 = 0;
                    while (!this.u && i2 < 20) {
                        try {
                            Thread.sleep(5);
                        } catch (Throwable unused) {
                        }
                        i2++;
                    }
                }
            }
            CellLocation q2 = q();
            if (!b(q2)) {
                q2 = r();
            }
            if (b(q2)) {
                this.f = q2;
                this.s = ep.b();
            } else if (ep.b() - this.s > 60000) {
                this.f = null;
                this.b.clear();
                this.n.clear();
            }
        }
        if (!this.g && this.f == null && z2) {
            int i3 = 0;
            do {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                i3++;
                if (this.f != null) {
                    break;
                }
            } while (i3 < 50);
        }
        this.g = true;
        if (b(this.f)) {
            a(z);
        }
        try {
            if (ep.c() >= 18 && (telephonyManager2 = this.d) != null) {
                ArrayList<dv> arrayList = this.n;
                du duVar = this.p;
                try {
                    list = telephonyManager2.getAllCellInfo();
                    try {
                        this.i = null;
                    } catch (SecurityException e4) {
                        e2 = e4;
                    }
                } catch (SecurityException e5) {
                    e2 = e5;
                    list = null;
                    this.i = e2.getMessage();
                    if (arrayList != null) {
                    }
                    while (r2 < size) {
                    }
                    this.a |= 4;
                    duVar.a(arrayList);
                    telephonyManager = this.d;
                    if (telephonyManager != null) {
                    }
                }
                if (!(list == null || (size = list.size()) == 0)) {
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        CellInfo cellInfo = list.get(i4);
                        if (cellInfo != null) {
                            try {
                                dv a2 = a(cellInfo);
                                if (a2 != null) {
                                    a2.l = (short) ((int) Math.min(65535L, duVar.a(a2)));
                                    arrayList.add(a2);
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    this.a |= 4;
                    duVar.a(arrayList);
                }
            }
        } catch (Throwable unused3) {
        }
        telephonyManager = this.d;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.a |= 8;
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
        if (this.j || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            ej.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    static /* synthetic */ void c(dw dwVar) {
        int i2;
        dwVar.h = new b();
        try {
            i2 = em.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            try {
                dwVar.d.listen(dwVar.h, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                dwVar.d.listen(dwVar.h, i2 | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private static boolean c(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean d(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    public static int j() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            r = 1;
        } catch (Throwable unused) {
        }
        if (r == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                r = 2;
            } catch (Throwable unused2) {
            }
        }
        return r;
    }

    private CellLocation o() {
        TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.i = null;
                if (b(cellLocation)) {
                    this.f = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            } catch (Throwable th) {
                this.i = null;
                ej.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private synchronized void p() {
        int i2 = this.a & 3;
        if (i2 != 1) {
            if (i2 == 2) {
                if (this.b.isEmpty()) {
                    this.a = 0;
                }
            }
        } else if (this.b.isEmpty()) {
            this.a = 0;
        }
    }

    private CellLocation q() {
        TelephonyManager telephonyManager = this.d;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        if (ep.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.i = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation o2 = o();
        if (b(o2)) {
            return o2;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        return a2 != null ? a2 : a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation r() {
        if (!v) {
            v = true;
        }
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
            ej.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private static Class<?> s() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i2 = r;
        try {
            return systemClassLoader.loadClass(i2 != 0 ? i2 != 1 ? i2 != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            ej.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: com.loc.cy */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: com.loc.cx */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<cw> a() {
        da daVar;
        cz czVar;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = this.d.getAllCellInfo();
        if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    cx cxVar = new cx(cellInfo.isRegistered(), true);
                    cxVar.m = cellIdentity.getLatitude();
                    cxVar.n = cellIdentity.getLongitude();
                    cxVar.j = cellIdentity.getSystemId();
                    cxVar.k = cellIdentity.getNetworkId();
                    cxVar.l = cellIdentity.getBasestationId();
                    cxVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    cxVar.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    czVar = cxVar;
                } else {
                    if (cellInfo instanceof CellInfoGsm) {
                        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                        CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                        cy cyVar = new cy(cellInfo.isRegistered(), true);
                        cyVar.a = String.valueOf(cellIdentity2.getMcc());
                        cyVar.b = String.valueOf(cellIdentity2.getMnc());
                        cyVar.j = cellIdentity2.getLac();
                        cyVar.k = cellIdentity2.getCid();
                        cyVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                        cyVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                        daVar = cyVar;
                        if (Build.VERSION.SDK_INT >= 24) {
                            cyVar.m = cellIdentity2.getArfcn();
                            cyVar.n = cellIdentity2.getBsic();
                            daVar = cyVar;
                        }
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                        cz czVar2 = new cz(cellInfo.isRegistered());
                        czVar2.a = String.valueOf(cellIdentity3.getMcc());
                        czVar2.b = String.valueOf(cellIdentity3.getMnc());
                        czVar2.l = cellIdentity3.getPci();
                        czVar2.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                        czVar2.k = cellIdentity3.getCi();
                        czVar2.j = cellIdentity3.getTac();
                        czVar2.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                        czVar2.c = cellInfoLte.getCellSignalStrength().getDbm();
                        czVar = czVar2;
                        if (Build.VERSION.SDK_INT >= 24) {
                            czVar2.m = cellIdentity3.getEarfcn();
                            czVar = czVar2;
                        }
                    } else if (Build.VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        da daVar2 = new da(cellInfo.isRegistered(), true);
                        daVar2.a = String.valueOf(cellIdentity4.getMcc());
                        daVar2.b = String.valueOf(cellIdentity4.getMnc());
                        daVar2.j = cellIdentity4.getLac();
                        daVar2.k = cellIdentity4.getCid();
                        daVar2.l = cellIdentity4.getPsc();
                        daVar2.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        daVar2.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        daVar = daVar2;
                        if (Build.VERSION.SDK_INT >= 24) {
                            daVar2.m = cellIdentity4.getUarfcn();
                            daVar = daVar2;
                        }
                    }
                    arrayList.add(daVar == 1 ? 1 : 0);
                }
                arrayList.add(czVar == 1 ? 1 : 0);
            }
        }
        return arrayList;
    }

    public final void a(Cdo doVar) {
        this.w = doVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ SecurityException -> 0x0048, all -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    public final synchronized void a(boolean z, boolean z2) {
        try {
            boolean a2 = ep.a(this.l);
            this.j = a2;
            boolean z3 = true;
            if (!a2) {
                if (ep.b() - this.e < 10000) {
                }
                if (z3 || this.b.isEmpty()) {
                    b(z, z2);
                    this.e = ep.b();
                }
                if (!this.j) {
                    i();
                    return;
                } else {
                    p();
                    return;
                }
            }
            z3 = false;
            b(z, z2);
            this.e = ep.b();
            if (!this.j) {
            }
        } catch (SecurityException e2) {
            this.i = e2.getMessage();
        } catch (Throwable th) {
            ej.a(th, "CgiManager", "refresh");
        }
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
                if (em.b(cellLocation, "getSystemId", new Object[0]) > 0 && em.b(cellLocation, "getNetworkId", new Object[0]) >= 0 && em.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                    z = true;
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                str = "cgiUseful Cgi.I_CDMA_T";
                ej.a(th, "CgiManager", str);
                return true;
            }
        }
    }

    public final synchronized ArrayList<dv> b() {
        return this.b;
    }

    public final ArrayList<dv> c() {
        return this.n;
    }

    public final synchronized dv d() {
        if (this.j) {
            return null;
        }
        ArrayList<dv> arrayList = this.b;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.a & 3;
    }

    public final TelephonyManager g() {
        return this.d;
    }

    public final void h() {
        PhoneStateListener phoneStateListener;
        this.p.a();
        this.s = 0;
        synchronized (this.y) {
            this.x = true;
        }
        TelephonyManager telephonyManager = this.d;
        if (!(telephonyManager == null || (phoneStateListener = this.h) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                ej.a(th, "CgiManager", "destroy");
            }
        }
        this.h = null;
        this.o = -113;
        this.d = null;
        this.q = null;
    }

    final synchronized void i() {
        this.i = null;
        this.f = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final String k() {
        return this.i;
    }

    public final String l() {
        return this.m;
    }

    public final synchronized String m() {
        if (this.j) {
            i();
        }
        StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if ((this.a & 3) == 1) {
            for (int i2 = 1; i2 < this.b.size(); i2++) {
                StringBuilder sb2 = this.k;
                sb2.append("#");
                sb2.append(this.b.get(i2).b);
                StringBuilder sb3 = this.k;
                sb3.append("|");
                sb3.append(this.b.get(i2).c);
                StringBuilder sb4 = this.k;
                sb4.append("|");
                sb4.append(this.b.get(i2).d);
            }
        }
        if (this.k.length() > 0) {
            this.k.deleteCharAt(0);
        }
        return this.k.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.d;
            if (telephonyManager != null && (!TextUtils.isEmpty(telephonyManager.getSimOperator()) || !TextUtils.isEmpty(this.d.getSimCountryIso()))) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            int a2 = ep.a(ep.c(this.l));
            return a2 == 0 || a2 == 4 || a2 == 2 || a2 == 5 || a2 == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
