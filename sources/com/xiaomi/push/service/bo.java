package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hc;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ih;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;

public class bo {
    public static in a(Context context, hy hyVar) {
        if (hyVar.m464b()) {
            return null;
        }
        byte[] a = hyVar.m462a();
        in a2 = a(hyVar.a(), hyVar.f704b);
        if (a2 != null) {
            im.a(a2, a);
        }
        return a2;
    }

    private static in a(hc hcVar, boolean z) {
        switch (bp.a[hcVar.ordinal()]) {
            case 1:
                return new id();
            case 2:
                return new ij();
            case 3:
                return new ih();
            case 4:
                return new il();
            case 5:
                return new Cif();
            case 6:
                return new hs();
            case 7:
                return new hx();
            case 8:
                return new ie();
            case 9:
                if (z) {
                    return new ib();
                }
                ht htVar = new ht();
                htVar.a(true);
                return htVar;
            case 10:
                return new hx();
            default:
                return null;
        }
    }
}
