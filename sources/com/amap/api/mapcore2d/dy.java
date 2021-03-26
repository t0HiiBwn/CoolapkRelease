package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class dy {
    private dt a;
    private Context b;

    public dy(Context context, boolean z) {
        this.b = context;
        this.a = a(context, z);
    }

    private dt a(Context context, boolean z) {
        try {
            return new dt(context, dt.a((Class<? extends ds>) dx.class));
        } catch (Throwable th) {
            if (!z) {
                Cdo.c(th, "sd", "gdb");
            }
            return null;
        }
    }

    public void a(da daVar) {
        if (daVar != null) {
            try {
                if (this.a == null) {
                    this.a = a(this.b, false);
                }
                String a2 = da.a(daVar.a());
                List<da> b2 = this.a.b(a2, da.class);
                if (b2 != null) {
                    if (b2.size() != 0) {
                        if (a(b2, daVar)) {
                            this.a.a(a2, daVar);
                            return;
                        }
                        return;
                    }
                }
                this.a.a((dt) daVar);
            } catch (Throwable th) {
                Cdo.c(th, "sd", "it");
            }
        }
    }

    private boolean a(List<da> list, da daVar) {
        for (da daVar2 : list) {
            if (daVar2.equals(daVar)) {
                return false;
            }
        }
        return true;
    }

    public List<da> a() {
        try {
            return this.a.a(da.h(), da.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
