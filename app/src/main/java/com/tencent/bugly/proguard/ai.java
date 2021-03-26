package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
public final class ai extends k implements Cloneable {
    private static ArrayList<String> c;
    private String a = "";
    private ArrayList<String> b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.b(0, true);
        if (c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) iVar.a((i) c, 1, false);
    }
}
