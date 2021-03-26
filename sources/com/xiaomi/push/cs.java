package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

class cs extends cm {
    cm a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cq f286a;
    final /* synthetic */ cm b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cs(cq cqVar, String str, cm cmVar) {
        super(str);
        this.f286a = cqVar;
        this.b = cmVar;
        this.a = cmVar;
        this.f272b = this.f272b;
        if (cmVar != null) {
            this.f = cmVar.f;
        }
    }

    @Override // com.xiaomi.push.cm
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        cm cmVar = this.a;
        if (cmVar != null) {
            arrayList.addAll(cmVar.a(true));
        }
        synchronized (cq.b) {
            cm cmVar2 = cq.b.get(this.f272b);
            if (cmVar2 != null) {
                Iterator<String> it2 = cmVar2.a(true).iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f272b);
                arrayList.add(this.f272b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cm
    public synchronized void a(String str, cl clVar) {
        cm cmVar = this.a;
        if (cmVar != null) {
            cmVar.a(str, clVar);
        }
    }

    @Override // com.xiaomi.push.cm
    public boolean b() {
        return false;
    }
}
