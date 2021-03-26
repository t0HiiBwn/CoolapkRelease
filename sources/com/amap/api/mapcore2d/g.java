package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.mapcore2d.cr;
import com.amap.api.maps2d.MapsInitializer;
import org.json.JSONObject;

/* compiled from: AuthTask */
public class g extends Thread {
    private Context a;
    private y b;

    public g(Context context, y yVar) {
        this.a = context;
        this.b = yVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (MapsInitializer.getNetworkEnable()) {
                cw.a().a(this.a);
                da a2 = cm.a();
                cr.a a3 = cr.a(this.a, a2, "002;11K;001;145", null);
                if (cr.a != 1) {
                    Message obtainMessage = this.b.getMainHandler().obtainMessage();
                    obtainMessage.what = 2;
                    if (a3.a != null) {
                        obtainMessage.obj = a3.a;
                    }
                    this.b.getMainHandler().sendMessage(obtainMessage);
                }
                if (a3 != null) {
                    if (a3.x != null) {
                        cm.a().a(a3.x.a);
                    }
                    if (!db.b(this.a) && a3.A != null) {
                        new cz(this.a, "2dmap", a3.A.a, a3.A.b).a();
                    }
                    if (a3.t != null) {
                        JSONObject jSONObject = a3.t;
                        int i = q.q;
                        if (jSONObject.has("t")) {
                            i = jSONObject.getInt("t");
                        }
                        bg.a().b("period_day", i);
                        if (jSONObject.has("able")) {
                            boolean a4 = cr.a(jSONObject.getString("able"), false);
                            bg.a();
                            bg.b("UpdateDataActiveEnable", a4);
                            MapsInitializer.setUpdateDataActiveEnable(a4);
                        }
                        if (jSONObject.has("oi")) {
                            q.a(cr.a(jSONObject.getString("oi"), false));
                        }
                    }
                }
                if (!(a3 == null || a3.y == null)) {
                    cr.a.d dVar = a3.y;
                    if (dVar != null) {
                        String str = dVar.b;
                        String str2 = dVar.a;
                        String str3 = dVar.c;
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            if (!TextUtils.isEmpty(str3)) {
                                new dz(this.a, new ea(str2, str, str3, a3.a()), cm.a()).a();
                            }
                        }
                        new dz(this.a, null, cm.a()).a();
                    } else {
                        new dz(this.a, null, cm.a()).a();
                    }
                }
                q.p = a2;
                Cdo.a(this.a, a2);
                interrupt();
            }
        } catch (Throwable th) {
            interrupt();
            Cdo.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }
}
