package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

final class cg {
    static cf a(Context context) {
        if (ac.b()) {
            return new ck(new b());
        }
        if (b.a()) {
            return new b();
        }
        if (cj.a()) {
            return new cj(context);
        }
        if (ac.a(context)) {
            return new bz();
        }
        if (ac.d()) {
            return new ck();
        }
        if (ac.c()) {
            return new cc();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (ac.e()) {
                return new cm();
            }
            if (ac.g()) {
                return new cd();
            }
            if (ac.f()) {
                return new cb();
            }
            if (ac.h()) {
                return new bd();
            }
            return new bv();
        } else if (ac.a() || !bz.c(context)) {
            return null;
        } else {
            return new bz();
        }
    }
}
