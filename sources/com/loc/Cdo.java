package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.loc.ao;
import com.loc.by;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* renamed from: com.loc.do  reason: invalid class name */
/* compiled from: CollectionManager */
public final class Cdo implements dk {
    private static long k;
    Context a = null;
    dx b = null;
    dw c = null;
    cu d;
    ax e;
    private ArrayList<ca> f = new ArrayList<>();
    private Handler g;
    private LocationManager h;
    private a i;
    private volatile boolean j = false;

    /* renamed from: com.loc.do$a */
    /* compiled from: CollectionManager */
    static class a implements LocationListener {
        private Cdo a;

        a(Cdo doVar) {
            this.a = doVar;
        }

        final void a() {
            this.a = null;
        }

        final void a(Cdo doVar) {
            this.a = doVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                Cdo doVar = this.a;
                if (doVar != null) {
                    doVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: com.loc.do$b */
    /* compiled from: CollectionManager */
    class b implements Runnable {
        private int b;
        private Location c;

        b(int i) {
            this.b = 0;
            this.b = i;
        }

        b(Cdo doVar, Location location) {
            this(1);
            this.c = location;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == 1) {
                try {
                    if (this.c != null && Cdo.this.j) {
                        Bundle extras = this.c.getExtras();
                        int i2 = 0;
                        if (extras != null) {
                            i2 = extras.getInt("satellites");
                        }
                        if (!ep.a(this.c, i2)) {
                            if (Cdo.this.b != null && !Cdo.this.b.r) {
                                Cdo.this.b.f();
                            }
                            ArrayList<dd> a2 = Cdo.this.b.a();
                            List<cw> a3 = Cdo.this.c.a();
                            by.a aVar = new by.a();
                            dc dcVar = new dc();
                            dcVar.i = this.c.getAccuracy();
                            dcVar.f = this.c.getAltitude();
                            dcVar.d = this.c.getLatitude();
                            dcVar.h = this.c.getBearing();
                            dcVar.e = this.c.getLongitude();
                            dcVar.j = this.c.isFromMockProvider();
                            dcVar.a = this.c.getProvider();
                            dcVar.g = this.c.getSpeed();
                            dcVar.f1362l = (byte) i2;
                            dcVar.b = System.currentTimeMillis();
                            dcVar.c = this.c.getTime();
                            dcVar.k = this.c.getTime();
                            aVar.a = dcVar;
                            aVar.b = a2;
                            WifiInfo c2 = Cdo.this.b.c();
                            if (c2 != null) {
                                aVar.c = dd.a(c2.getBSSID());
                            }
                            aVar.d = dx.w;
                            aVar.f = this.c.getTime();
                            aVar.g = (byte) n.p(Cdo.this.a);
                            aVar.h = n.u(Cdo.this.a);
                            aVar.e = Cdo.this.b.q;
                            aVar.j = ep.a(Cdo.this.a);
                            aVar.i = a3;
                            ca a4 = cu.a(aVar);
                            if (a4 != null) {
                                synchronized (Cdo.this.f) {
                                    Cdo.this.f.add(a4);
                                    if (Cdo.this.f.size() >= 5) {
                                        try {
                                            ab.d().submit(new b(3));
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                                Cdo.this.d();
                            }
                        }
                    }
                } catch (Throwable th) {
                    ej.a(th, "cl", "coll");
                }
            } else if (i == 2) {
                ao aoVar = null;
                try {
                    long unused2 = Cdo.k = System.currentTimeMillis();
                    if (Cdo.this.e.f.c()) {
                        aoVar = ao.a(new File(Cdo.this.e.a), Cdo.this.e.b);
                        ArrayList arrayList = new ArrayList();
                        byte[] a5 = Cdo.a(128);
                        if (a5 == null) {
                            try {
                                aoVar.close();
                                return;
                            } catch (Throwable unused3) {
                                return;
                            }
                        } else {
                            List b2 = Cdo.b(aoVar, Cdo.this.e, arrayList, a5);
                            if (b2 == null || b2.size() == 0) {
                                try {
                                    aoVar.close();
                                    return;
                                } catch (Throwable unused4) {
                                    return;
                                }
                            } else {
                                Cdo.this.e.f.a(true);
                                if (cu.a(u.b(cu.a(dy.a(a5), o.b(a5, cu.a(), u.c()), b2)))) {
                                    Cdo.a(aoVar, arrayList);
                                }
                            }
                        }
                    }
                    if (aoVar != null) {
                        try {
                            aoVar.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable unused6) {
                }
            } else if (i == 3) {
                Cdo.this.f();
            }
        }
    }

    Cdo(Context context) {
        this.a = context;
        ax axVar = new ax();
        this.e = axVar;
        bd.a(this.a, axVar, z.k, 100, 1024000, "0");
        this.e.f = new bp(context, ei.g, "kKey", new bn(context, ei.e, ei.f, ei.f * 10, "carrierLocKey"));
        this.e.e = new am();
    }

    static /* synthetic */ void a(ao aoVar, List list) {
        if (aoVar != null) {
            try {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    aoVar.c((String) it2.next());
                }
                aoVar.close();
            } catch (Throwable th) {
                ab.b(th, "aps", "dlo");
            }
        }
    }

    /* access modifiers changed from: private */
    public static byte[] a(int i2) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            if (instance == null) {
                return null;
            }
            instance.init(i2);
            return instance.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r9 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        if (r9 == null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e9, code lost:
        if (r9 == null) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ff, code lost:
        if (r7 == null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
        if (r9 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0131 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f A[SYNTHETIC, Splitter:B:90:0x011f] */
    public static List<ca> b(ao aoVar, ax axVar, List<String> list, byte[] bArr) {
        File b2;
        String[] list2;
        String[] strArr;
        ao.b bVar;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            b2 = aoVar.b();
        } catch (Throwable th) {
            ab.b(th, "aps", "upc");
        }
        if (b2 == null || !b2.exists() || (list2 = b2.list()) == null) {
            return arrayList;
        }
        int length = list2.length;
        char c2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str2 = list2[i2];
            if (str2.contains(".0")) {
                InputStream inputStream = null;
                try {
                    str = str2.split("\\.")[c2];
                    try {
                        bVar = aoVar.a(str);
                        try {
                            bVar.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        strArr = list2;
                        bVar = null;
                        if (inputStream != null) {
                        }
                        if (bVar == null) {
                        }
                        try {
                            bVar.close();
                        } catch (Throwable unused3) {
                        }
                        i2++;
                        list2 = strArr;
                        c2 = 0;
                    }
                } catch (Throwable unused4) {
                    strArr = list2;
                    bVar = null;
                    if (inputStream != null) {
                    }
                    if (bVar == null) {
                    }
                    bVar.close();
                    i2++;
                    list2 = strArr;
                    c2 = 0;
                }
                if (bVar != null) {
                    try {
                        inputStream = bVar.a();
                    } catch (Throwable unused5) {
                        strArr = list2;
                        if (inputStream != null) {
                        }
                        if (bVar == null) {
                        }
                        bVar.close();
                        i2++;
                        list2 = strArr;
                        c2 = 0;
                    }
                    if (inputStream != null) {
                        char c3 = 2;
                        byte[] bArr2 = new byte[2];
                        inputStream.read(bArr2);
                        int b3 = ep.b(bArr2);
                        if (b3 == 0 || b3 > 65535) {
                            break;
                        }
                        byte[] bArr3 = new byte[b3];
                        inputStream.read(bArr3);
                        byte[] bArr4 = new byte[2];
                        int i4 = 0;
                        while (inputStream.read(bArr4) >= 0) {
                            try {
                                byte[] bArr5 = new byte[ep.b(bArr4)];
                                inputStream.read(bArr5);
                                byte[] a2 = o.a(bArr3, bArr5, u.c());
                                i4 += a2.length;
                                byte[] bArr6 = new byte[4];
                                inputStream.read(bArr6);
                                strArr = list2;
                                try {
                                    try {
                                        arrayList.add(new ca(((bArr6[c3] & 255) << 8) | (bArr6[3] & 255) | ((bArr6[1] & 255) << 16) | ((bArr6[0] & 255) << 24), o.b(bArr, u.b(a2), u.c())));
                                        list2 = strArr;
                                        c3 = 2;
                                    } catch (Throwable unused6) {
                                        if (inputStream != null) {
                                        }
                                        if (bVar == null) {
                                        }
                                        bVar.close();
                                        i2++;
                                        list2 = strArr;
                                        c2 = 0;
                                    }
                                } catch (Throwable unused7) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    if (bVar == null) {
                                        i2++;
                                        list2 = strArr;
                                        c2 = 0;
                                    }
                                    bVar.close();
                                    i2++;
                                    list2 = strArr;
                                    c2 = 0;
                                }
                            } catch (Throwable unused9) {
                                strArr = list2;
                                if (inputStream != null) {
                                }
                                if (bVar == null) {
                                }
                                bVar.close();
                                i2++;
                                list2 = strArr;
                                c2 = 0;
                            }
                        }
                        strArr = list2;
                        i3 += i4;
                        try {
                            list.add(str);
                            try {
                                if (i3 <= axVar.f.b()) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                    if (bVar == null) {
                                        i2++;
                                        list2 = strArr;
                                        c2 = 0;
                                    }
                                    bVar.close();
                                    i2++;
                                    list2 = strArr;
                                    c2 = 0;
                                } else if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                            } catch (Throwable unused12) {
                                if (inputStream != null) {
                                }
                                if (bVar == null) {
                                }
                                bVar.close();
                                i2++;
                                list2 = strArr;
                                c2 = 0;
                            }
                        } catch (Throwable unused13) {
                            if (inputStream != null) {
                            }
                            if (bVar == null) {
                            }
                            bVar.close();
                            i2++;
                            list2 = strArr;
                            c2 = 0;
                        }
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused14) {
                        }
                    }
                }
            }
            strArr = list2;
            i2++;
            list2 = strArr;
            c2 = 0;
        }
        return arrayList;
        return arrayList;
    }

    private static byte[] b(int i2) {
        byte[] bArr = new byte[2];
        bArr[1] = (byte) (i2 & 255);
        bArr[0] = (byte) ((i2 & 65280) >> 8);
        return bArr;
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            ArrayList<ca> arrayList = this.f;
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f) {
                    arrayList2.addAll(this.f);
                    this.f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] a2 = a(256);
                if (a2 != null) {
                    byteArrayOutputStream.write(b(a2.length));
                    byteArrayOutputStream.write(a2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ca caVar = (ca) it2.next();
                        byte[] b2 = caVar.b();
                        if (b2.length >= 10 && b2.length <= 65535) {
                            byte[] b3 = o.b(a2, b2, u.c());
                            byteArrayOutputStream.write(b(b3.length));
                            byteArrayOutputStream.write(b3);
                            int a3 = caVar.a();
                            byteArrayOutputStream.write(new byte[]{(byte) ((a3 >> 24) & 255), (byte) ((a3 >> 16) & 255), (byte) ((a3 >> 8) & 255), (byte) (a3 & 255)});
                        }
                    }
                    ay.a(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.e);
                }
            }
        } catch (Throwable th) {
            ej.a(th, "clm", "wtD");
        }
    }

    @Override // com.loc.dk
    public final dj a(di diVar) {
        try {
            ed edVar = new ed();
            edVar.a(diVar.b);
            edVar.a(diVar.a);
            edVar.a(diVar.d);
            aq.a();
            aw c2 = aq.c(edVar);
            dj djVar = new dj();
            djVar.c = c2.a;
            djVar.b = c2.b;
            djVar.a = 200;
            return djVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    final void a() {
        LocationManager locationManager;
        try {
            a aVar = this.i;
            if (!(aVar == null || (locationManager = this.h) == null)) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.j) {
                f();
                this.b.a((Cdo) null);
                this.c.a((Cdo) null);
                this.c = null;
                this.b = null;
                this.g = null;
                this.j = false;
            }
        } catch (Throwable th) {
            ej.a(th, "clm", "stc");
        }
    }

    public final void a(Location location) {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            ab.b(th, "cl", "olcc");
        }
    }

    public final void a(dw dwVar, dx dxVar, Handler handler) {
        LocationManager locationManager;
        if (!this.j && dwVar != null && dxVar != null && handler != null) {
            this.j = true;
            this.c = dwVar;
            this.b = dxVar;
            dxVar.a(this);
            this.c.a(this);
            this.g = handler;
            try {
                if (this.h == null && handler != null) {
                    this.h = (LocationManager) this.a.getSystemService("location");
                }
                if (this.i == null) {
                    this.i = new a(this);
                }
                this.i.a(this);
                a aVar = this.i;
                if (!(aVar == null || (locationManager = this.h) == null)) {
                    locationManager.requestLocationUpdates("passive", 1000, -1.0f, aVar);
                }
                if (this.d == null) {
                    cu cuVar = new cu("5.2.0", k.f(this.a), "S128DF1572465B890OE3F7A13167KLEI", k.c(this.a), this);
                    this.d = cuVar;
                    cuVar.a(n.x(this.a)).b(n.h(this.a)).c(n.a(this.a)).d(n.g(this.a)).e(n.A(this.a)).f(n.i(this.a)).g(Build.MODEL).h(Build.MANUFACTURER).i(Build.BRAND).a(Build.VERSION.SDK_INT).j(Build.VERSION.RELEASE).a(dd.a(n.m(this.a))).k(n.m(this.a));
                }
            } catch (Throwable th) {
                ej.a(th, "col", "init");
            }
        }
    }

    public final void b() {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new Runnable() {
                    /* class com.loc.Cdo.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (Cdo.this.d != null && Cdo.this.b != null) {
                                cu.b(Cdo.this.b.a());
                            }
                        } catch (Throwable th) {
                            ej.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ej.a(th, "cl", "upw");
        }
    }

    public final void c() {
        dw dwVar;
        try {
            if (this.d != null && (dwVar = this.c) != null) {
                cu.a(dwVar.a());
            }
        } catch (Throwable th) {
            ej.a(th, "cl", "upc");
        }
    }

    public final void d() {
        try {
            if (System.currentTimeMillis() - k >= 60000) {
                ab.d().submit(new b(2));
            }
        } catch (Throwable unused) {
        }
    }
}
