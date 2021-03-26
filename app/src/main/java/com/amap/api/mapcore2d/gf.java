package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* compiled from: MapLocationManagerResultHandler */
public final class gf extends Handler {
    gd a = null;

    public gf(Looper looper, gd gdVar) {
        super(looper);
        this.a = gdVar;
    }

    public gf(gd gdVar) {
        this.a = gdVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                gd gdVar = this.a;
                if (gdVar != null) {
                    gdVar.a((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                gu.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
