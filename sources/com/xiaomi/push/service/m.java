package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.e;
import com.xiaomi.push.go;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.gt;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import java.util.ArrayList;
import java.util.List;

public class m {
    public static int a(l lVar, go goVar) {
        String a = a(goVar);
        int i = 1;
        if (n.a[goVar.ordinal()] != 1) {
            i = 0;
        }
        return lVar.a.getInt(a, i);
    }

    private static String a(go goVar) {
        return "oc_version_" + goVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<gt> list, boolean z) {
        if (e.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gt gtVar : list) {
            int a = gtVar.a();
            gp a2 = gp.a(gtVar.c());
            if (a2 != null) {
                if (!z || !gtVar.c) {
                    int i = n.b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(gtVar.l())) : new Pair(Integer.valueOf(a), gtVar.j()) : new Pair(Integer.valueOf(a), Long.valueOf(gtVar.h())) : new Pair(Integer.valueOf(a), Integer.valueOf(gtVar.f())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                }
            }
        }
        return arrayList;
    }

    public static void a(l lVar, go goVar, int i) {
        lVar.a.edit().putInt(a(goVar), i).commit();
    }

    public static void a(l lVar, hg hgVar) {
        lVar.b(a(hgVar.a(), true));
        lVar.b();
    }

    public static void a(l lVar, hh hhVar) {
        for (gr grVar : hhVar.a()) {
            if (grVar.a() > a(lVar, grVar.d())) {
                a(lVar, grVar.d(), grVar.a());
                lVar.a(a(grVar.b, false));
            }
        }
        lVar.b();
    }
}
