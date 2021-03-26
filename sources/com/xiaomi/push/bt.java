package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

class bt extends bm {
    bm i;
    final /* synthetic */ bm j;
    final /* synthetic */ bq k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bt(bq bqVar, String str, bm bmVar) {
        super(str);
        this.k = bqVar;
        this.j = bmVar;
        this.i = bmVar;
        this.b = this.b;
        if (bmVar != null) {
            this.f = bmVar.f;
        }
    }

    @Override // com.xiaomi.push.bm
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        bm bmVar = this.i;
        if (bmVar != null) {
            arrayList.addAll(bmVar.a(true));
        }
        synchronized (bq.b) {
            bm bmVar2 = bq.b.get(this.b);
            if (bmVar2 != null) {
                Iterator<String> it2 = bmVar2.a(true).iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.b);
                arrayList.add(this.b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.bm
    public synchronized void a(String str, bl blVar) {
        bm bmVar = this.i;
        if (bmVar != null) {
            bmVar.a(str, blVar);
        }
    }

    @Override // com.xiaomi.push.bm
    public boolean b() {
        return false;
    }
}
