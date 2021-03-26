package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* compiled from: DynamicExceptionHandler */
public class ec implements Thread.UncaughtExceptionHandler {
    private static ec a;
    private Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;
    private da d;

    private ec(Context context, da daVar) {
        this.c = context.getApplicationContext();
        this.d = daVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static synchronized ec a(Context context, da daVar) {
        ec ecVar;
        synchronized (ec.class) {
            if (a == null) {
                a = new ec(context, daVar);
            }
            ecVar = a;
        }
        return ecVar;
    }

    void a(Throwable th) {
        String a2 = db.a(th);
        try {
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if ((a2.contains("amapdynamic") || a2.contains("admic")) && a2.contains("com.amap.api")) {
                dt dtVar = new dt(this.c, ed.c());
                if (a2.contains("loc")) {
                    eb.a(dtVar, this.c, "loc");
                }
                if (a2.contains("navi")) {
                    eb.a(dtVar, this.c, "navi");
                }
                if (a2.contains("sea")) {
                    eb.a(dtVar, this.c, "sea");
                }
                if (a2.contains("2dmap")) {
                    eb.a(dtVar, this.c, "2dmap");
                }
                if (a2.contains("3dmap")) {
                    eb.a(dtVar, this.c, "3dmap");
                }
            } else if (a2.contains("com.autonavi.aps.amapapi.offline")) {
                eb.a(new dt(this.c, ed.c()), this.c, "OfflineLocation");
            } else if (a2.contains("com.data.carrier_v4")) {
                eb.a(new dt(this.c, ed.c()), this.c, "Collection");
            } else {
                if (!a2.contains("com.autonavi.aps.amapapi.httpdns")) {
                    if (!a2.contains("com.autonavi.httpdns")) {
                        if (a2.contains("com.amap.api.aiunet")) {
                            eb.a(new dt(this.c, ed.c()), this.c, "aiu");
                            return;
                        } else if (a2.contains("com.amap.co") || a2.contains("com.amap.opensdk.co") || a2.contains("com.amap.location")) {
                            eb.a(new dt(this.c, ed.c()), this.c, "co");
                            return;
                        } else {
                            return;
                        }
                    }
                }
                eb.a(new dt(this.c, ed.c()), this.c, "HttpDNS");
            }
        } catch (Throwable th2) {
            dl.a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
