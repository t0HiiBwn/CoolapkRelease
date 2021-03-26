package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LastLocationManager */
public final class i {
    static ea b;
    static ae e;
    static long g;
    String a = null;
    ea c = null;
    ea d = null;
    long f = 0;
    boolean h = false;
    private Context i;

    public i(Context context) {
        this.i = context.getApplicationContext();
    }

    private void e() {
        if (b == null || ep.b() - g > 180000) {
            ea f2 = f();
            g = ep.b();
            if (f2 != null && ep.a(f2.a())) {
                b = f2;
            }
        }
    }

    private ea f() {
        ea eaVar;
        Throwable th;
        byte[] b2;
        byte[] b3;
        String str = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
            ae aeVar = e;
            if (aeVar == null) {
                return null;
            }
            List a2 = aeVar.a("_id=1", ea.class);
            if (a2.size() > 0) {
                eaVar = (ea) a2.get(0);
                try {
                    byte[] b4 = o.b(eaVar.c());
                    String str2 = (b4 == null || b4.length <= 0 || (b3 = dy.b(b4, this.a)) == null || b3.length <= 0) ? null : new String(b3, "UTF-8");
                    byte[] b5 = o.b(eaVar.b());
                    if (b5 != null && b5.length > 0 && (b2 = dy.b(b5, this.a)) != null && b2.length > 0) {
                        str = new String(b2, "UTF-8");
                    }
                    eaVar.a(str);
                    str = str2;
                } catch (Throwable th2) {
                    th = th2;
                    ej.a(th, "LastLocationManager", "readLastFix");
                    return eaVar;
                }
            } else {
                eaVar = null;
            }
            if (!TextUtils.isEmpty(str)) {
                AMapLocation aMapLocation = new AMapLocation("");
                ej.a(aMapLocation, new JSONObject(str));
                if (ep.b(aMapLocation)) {
                    eaVar.a(aMapLocation);
                }
            }
            return eaVar;
        } catch (Throwable th3) {
            th = th3;
            eaVar = null;
            ej.a(th, "LastLocationManager", "readLastFix");
            return eaVar;
        }
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        Throwable th;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            e();
            ea eaVar = b;
            if (eaVar != null) {
                if (eaVar.a() != null) {
                    boolean z = false;
                    if (TextUtils.isEmpty(str)) {
                        long b2 = ep.b() - b.d();
                        if (b2 >= 0 && b2 <= j) {
                            z = true;
                        }
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        z = ep.a(b.b(), str);
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (!z) {
                        return aMapLocation;
                    }
                    AMapLocation a2 = b.a();
                    try {
                        a2.setLocationType(9);
                        a2.setFixLastLocation(true);
                        a2.setLocationDetail(aMapLocation.getLocationDetail());
                        return a2;
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = a2;
                        ej.a(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            }
            return aMapLocation;
        } catch (Throwable th3) {
            th = th3;
            ej.a(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
    }

    public final void a() {
        if (!this.h) {
            try {
                if (this.a == null) {
                    this.a = dy.a("MD5", n.x(this.i));
                }
                if (e == null) {
                    e = new ae(this.i, ae.a(eb.class));
                }
            } catch (Throwable th) {
                ej.a(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.h = true;
        }
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.i != null && aMapLocation != null && ep.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            ea eaVar = new ea();
            eaVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                eaVar.a((String) null);
            } else {
                eaVar.a(str);
            }
            try {
                b = eaVar;
                g = ep.b();
                this.c = eaVar;
                ea eaVar2 = this.d;
                if ((eaVar2 == null || ep.a(eaVar2.a(), eaVar.a()) > 500.0f) && ep.b() - this.f > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                ej.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation b() {
        e();
        ea eaVar = b;
        if (eaVar != null && ep.a(eaVar.a())) {
            return b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f = 0;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            ej.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        ea eaVar;
        String str;
        try {
            a();
            ea eaVar2 = this.c;
            if (eaVar2 != null && ep.a(eaVar2.a()) && e != null && (eaVar = this.c) != this.d) {
                if (eaVar.d() == 0) {
                    String str2 = this.c.a().toStr();
                    String b2 = this.c.b();
                    this.d = this.c;
                    String str3 = null;
                    if (!TextUtils.isEmpty(str2)) {
                        String b3 = o.b(dy.a(str2.getBytes("UTF-8"), this.a));
                        if (!TextUtils.isEmpty(b2)) {
                            str3 = o.b(dy.a(b2.getBytes("UTF-8"), this.a));
                        }
                        str = str3;
                        str3 = b3;
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        ea eaVar3 = new ea();
                        eaVar3.b(str3);
                        eaVar3.a(ep.b());
                        eaVar3.a(str);
                        e.a(eaVar3, "_id=1");
                        this.f = ep.b();
                        ea eaVar4 = b;
                        if (eaVar4 != null) {
                            eaVar4.a(ep.b());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ej.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
