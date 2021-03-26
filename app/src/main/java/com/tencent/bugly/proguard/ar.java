package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ar extends k implements Cloneable {
    private static ArrayList<aq> f;
    private static Map<String, String> g;
    public byte a = 0;
    public String b = "";
    public String c = "";
    public ArrayList<aq> d = null;
    public Map<String, String> e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        String str = this.b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        ArrayList<aq> arrayList = this.d;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.e;
        if (map != null) {
            jVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.b(1, false);
        this.c = iVar.b(2, false);
        if (f == null) {
            f = new ArrayList<>();
            f.add(new aq());
        }
        this.d = (ArrayList) iVar.a((i) f, 3, false);
        if (g == null) {
            HashMap hashMap = new HashMap();
            g = hashMap;
            hashMap.put("", "");
        }
        this.e = (Map) iVar.a((i) g, 4, false);
    }
}
