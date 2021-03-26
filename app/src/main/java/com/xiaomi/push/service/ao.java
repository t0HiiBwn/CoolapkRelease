package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.ad;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import java.util.ArrayList;
import java.util.List;

public class ao {
    public static int a(an anVar, hi hiVar) {
        String a = a(hiVar);
        int i = 1;
        if (ap.a[hiVar.ordinal()] != 1) {
            i = 0;
        }
        return anVar.f955a.getInt(a, i);
    }

    private static String a(hi hiVar) {
        return "oc_version_" + hiVar.a();
    }

    private static List<Pair<Integer, Object>> a(List<hn> list, boolean z) {
        if (ad.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hn hnVar : list) {
            int a = hnVar.a();
            hj a2 = hj.a(hnVar.b());
            if (a2 != null) {
                if (!z || !hnVar.f582a) {
                    int i = ap.b[a2.ordinal()];
                    arrayList.add(i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(hnVar.g())) : new Pair(Integer.valueOf(a), hnVar.m408a()) : new Pair(Integer.valueOf(a), Long.valueOf(hnVar.m407a())) : new Pair(Integer.valueOf(a), Integer.valueOf(hnVar.c())));
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                }
            }
        }
        return arrayList;
    }

    public static void a(an anVar, hi hiVar, int i) {
        anVar.f955a.edit().putInt(a(hiVar), i).commit();
    }

    public static void a(an anVar, hz hzVar) {
        anVar.b(a(hzVar.a(), true));
        anVar.b();
    }

    public static void a(an anVar, ia iaVar) {
        for (hl hlVar : iaVar.a()) {
            if (hlVar.a() > a(anVar, hlVar.m403a())) {
                a(anVar, hlVar.m403a(), hlVar.a());
                anVar.a(a(hlVar.f574a, false));
            }
        }
        anVar.b();
    }
}
