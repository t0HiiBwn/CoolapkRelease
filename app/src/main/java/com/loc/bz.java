package com.loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: WifiCollector */
public final class bz {
    private List<dd> a = new ArrayList();
    private dc b;
    private ArrayList<dd> c = new ArrayList<>();

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<com.loc.dd> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(List<dd> list, List<dd> list2) {
        list.clear();
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < list2.size(); i++) {
                dd ddVar = list2.get(i);
                hashMap.put(Integer.valueOf(ddVar.c), ddVar);
            }
            arrayList.addAll(hashMap.values());
            Collections.sort(arrayList, new Comparator<dd>() {
                /* class com.loc.bz.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(dd ddVar, dd ddVar2) {
                    return ddVar2.c - ddVar.c;
                }
            });
            int size = arrayList.size();
            if (size > 40) {
                size = 40;
            }
            for (int i2 = 0; i2 < size; i2++) {
                list.add(arrayList.get(i2));
            }
        }
    }

    final List<dd> a(dc dcVar, List<dd> list, boolean z, long j, long j2) {
        List<dd> list2;
        boolean z2 = false;
        if (z) {
            int i = 3500;
            float f = 10.0f;
            if (dcVar.g >= 10.0f) {
                i = 2000;
            }
            if ((j > 0 && j2 - j < ((long) i)) && list != null && list.size() > 0) {
                if (this.b != null) {
                    if (dcVar.g > 10.0f) {
                        f = 200.0f;
                    } else if (dcVar.g > 2.0f) {
                        f = 50.0f;
                    }
                    boolean z3 = dcVar.a(this.b) > ((double) f);
                    if (!z3) {
                        List<dd> list3 = this.a;
                        if (!(list == null || list3 == null)) {
                            int size = list.size();
                            int size2 = list3.size();
                            int i2 = size + size2;
                            if (size > size2) {
                                list2 = list3;
                                list3 = list;
                            } else {
                                list2 = list;
                            }
                            HashMap hashMap = new HashMap(list3.size());
                            for (dd ddVar : list3) {
                                hashMap.put(Long.valueOf(ddVar.a), 1);
                            }
                            int i3 = 0;
                            for (dd ddVar2 : list2) {
                                if (((Integer) hashMap.get(Long.valueOf(ddVar2.a))) != null) {
                                    i3++;
                                }
                            }
                            if (((double) i3) * 2.0d >= ((double) i2) * 0.5d) {
                                z2 = true;
                            }
                        }
                        z2 = !z2;
                    } else {
                        z2 = z3;
                    }
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return null;
        }
        a(this.c, list);
        this.a.clear();
        this.a.addAll(list);
        this.b = dcVar;
        return this.c;
    }
}
