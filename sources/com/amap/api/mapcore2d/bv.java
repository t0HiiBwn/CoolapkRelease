package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TileServer */
class bv extends f<bs, bs> implements cc {
    private an c;
    private am d = new am();

    @Override // com.amap.api.mapcore2d.f
    protected int f() {
        return 4;
    }

    @Override // com.amap.api.mapcore2d.f
    protected int g() {
        return 1;
    }

    @Override // com.amap.api.mapcore2d.f, com.amap.api.mapcore2d.aw
    public void b() {
        super.b();
        this.d.clear();
        if (!(this.b == null || this.b.c == null)) {
            this.b.c.b(this);
        }
        this.b = null;
    }

    public bv(az azVar, an anVar) {
        super(azVar);
        this.c = anVar;
        this.a = new br();
        this.b.c.a(this);
        a();
    }

    @Override // com.amap.api.mapcore2d.f
    protected ArrayList<bs> a(ArrayList<bs> arrayList) throws AMapException {
        ArrayList<bs> arrayList2 = null;
        if (!(arrayList == null || arrayList.size() == 0 || this.b == null || this.b.e == null || this.b.e.a == null)) {
            a((List<bs>) arrayList);
            if (arrayList.size() == 0) {
                return null;
            }
            if (!(this.c.j == null && this.c.k == null)) {
                bw bwVar = new bw(arrayList, this.c.k);
                bwVar.a(this.c);
                bwVar.a((an) null);
                arrayList2 = (ArrayList) bwVar.a();
            }
            c(arrayList);
            if (!(this.b == null || this.b.e == null)) {
                this.b.e.b();
            }
        }
        return arrayList2;
    }

    public void a(List<bs> list) {
        int size;
        if (list != null && (size = list.size()) != 0) {
            int i = 0;
            while (i < size) {
                if (!this.d.b(list.get(i))) {
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private void c(ArrayList<bs> arrayList) {
        int size;
        if (!(arrayList == null || this.d == null || (size = arrayList.size()) == 0)) {
            for (int i = 0; i < size; i++) {
                this.d.a(arrayList.get(i));
            }
        }
    }

    private void a(ArrayList<bs> arrayList, boolean z) {
        if (this.a != null && arrayList != null && arrayList.size() != 0) {
            this.a.a(arrayList, z);
        }
    }

    @Override // com.amap.api.mapcore2d.aw
    public void i() {
        a(false, false);
    }

    private boolean j() {
        if (this.b == null || this.b.e == null || this.b.e.a == null || this.b.e.a.size() <= 0) {
            return false;
        }
        return this.c.a();
    }

    private ArrayList<bs> a(ArrayList<bs> arrayList, an anVar, float f, boolean z) {
        int size;
        ArrayList<bs> arrayList2 = new ArrayList<>();
        if (arrayList == null || anVar == null || !anVar.a() || anVar.p == null) {
            return null;
        }
        anVar.p.clear();
        if (f > ((float) anVar.c) || f < ((float) anVar.d) || (size = arrayList.size()) <= 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            try {
                bs bsVar = arrayList.get(i);
                if (bsVar != null) {
                    int a = anVar.n.a(bsVar.c());
                    bs bsVar2 = new bs(bsVar.b, bsVar.c, bsVar.d, anVar.l);
                    bsVar2.h = a;
                    bsVar2.g = bsVar.g;
                    anVar.p.add(bsVar2);
                    if (a(bsVar2) && !z && !this.d.contains(bsVar2)) {
                        if (!anVar.f) {
                            bsVar2.a = -1;
                        }
                        arrayList2.add(bsVar2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList2;
    }

    @Override // com.amap.api.mapcore2d.cc
    public void a(boolean z, boolean z2) {
        ArrayList<bs> a;
        try {
            if (j() && (a = this.b.h.a(this.b.h.l, this.b.h.b(), this.b.c.c(), this.b.c.d())) != null && a.size() > 0) {
                ArrayList<bs> a2 = a(a, this.c, this.b.c.e(), z2);
                if (a2 != null) {
                    a(a2, true);
                    a2.clear();
                }
                a.clear();
                this.b.c.g().invalidate();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(bs bsVar) {
        return bsVar == null || bsVar.h < 0;
    }

    @Override // com.amap.api.mapcore2d.f
    protected ArrayList<bs> b(ArrayList<bs> arrayList) {
        int size;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return null;
        }
        int i = 0;
        ArrayList<bs> arrayList2 = null;
        int i2 = -1;
        while (i < size) {
            try {
                bs bsVar = arrayList.get(i);
                if (bsVar != null) {
                    if (!(this.b == null || this.b.e == null)) {
                        if (this.b.e.a != null) {
                            this.b.e.a.size();
                            if (!this.c.f) {
                                continue;
                            } else {
                                try {
                                    if (!MapsInitializer.getUpdateDataActiveEnable() || !q.b()) {
                                        i2 = this.c.o.a(bsVar);
                                    } else {
                                        i2 = -1;
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                if (i2 >= 0) {
                                    arrayList.remove(i);
                                    size--;
                                    i--;
                                    bn<bs> bnVar = this.c.p;
                                    if (bnVar == null) {
                                        continue;
                                    } else {
                                        synchronized (bnVar) {
                                            Iterator<bs> it2 = bnVar.iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    break;
                                                }
                                                bs next = it2.next();
                                                if (next != null) {
                                                    if (next.equals(bsVar)) {
                                                        next.h = i2;
                                                        this.b.e.b();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList<>();
                                    }
                                    bs bsVar2 = new bs(bsVar);
                                    bsVar2.a = -1;
                                    arrayList2.add(bsVar2);
                                }
                            }
                        }
                    }
                    return null;
                }
                i++;
            } catch (Throwable unused) {
            }
        }
        return arrayList2;
    }
}
