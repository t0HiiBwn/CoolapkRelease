package com.umeng.analytics.pro;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: UMSysLocation */
public class an {
    private static final String a = "UMSysLocation";
    private static final int c = 10000;
    private LocationManager b;
    private Context d;
    private ap e;

    private an() {
    }

    public an(Context context) {
        if (context == null) {
            MLog.e("Context参数不能为null");
            return;
        }
        this.d = context.getApplicationContext();
        this.b = (LocationManager) context.getApplicationContext().getSystemService("location");
    }

    public synchronized void a(ap apVar) {
        boolean z;
        boolean z2;
        Location location;
        ULog.i("UMSysLocation", "getSystemLocation");
        if (apVar != null) {
            Context context = this.d;
            if (context != null) {
                this.e = apVar;
                boolean checkPermission = UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                boolean checkPermission2 = UMUtils.checkPermission(this.d, "android.permission.ACCESS_FINE_LOCATION");
                if (!checkPermission) {
                    if (!checkPermission2) {
                        ap apVar2 = this.e;
                        if (apVar2 != null) {
                            apVar2.a(null);
                        }
                        return;
                    }
                }
                try {
                    if (this.b != null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            z2 = this.b.isProviderEnabled("gps");
                            z = this.b.isProviderEnabled("network");
                        } else {
                            z2 = checkPermission2 ? this.b.isProviderEnabled("gps") : false;
                            z = checkPermission ? this.b.isProviderEnabled("network") : false;
                        }
                        if (z2 || z) {
                            ULog.i("UMSysLocation", "getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)");
                            if (checkPermission2) {
                                location = this.b.getLastKnownLocation("passive");
                            } else if (checkPermission) {
                                location = this.b.getLastKnownLocation("network");
                            }
                            this.e.a(location);
                        }
                        location = null;
                        this.e.a(location);
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(this.d, th);
                }
            }
        }
        return;
        UMCrashManager.reportCrash(this.d, th);
    }

    public synchronized void a() {
        ULog.i("UMSysLocation", "destroy");
        try {
            if (this.b != null) {
                this.b = null;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.d, th);
        }
    }
}
