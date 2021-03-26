package com.amap.api.mapcore2d;

import java.util.ArrayList;

/* compiled from: TaskPool */
class br extends bo<bs> {
    br() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x004a A[EDGE_INSN: B:33:0x004a->B:25:0x004a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0047 A[SYNTHETIC] */
    @Override // com.amap.api.mapcore2d.bo
    protected synchronized ArrayList<bs> b(int i, boolean z) {
        if (this.a == null) {
            return null;
        }
        try {
            int size = this.a.size();
            if (i > size) {
                i = size;
            }
            ArrayList<bs> arrayList = new ArrayList<>(i);
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                bs bsVar = (bs) this.a.get(i2);
                if (bsVar != null) {
                    int i4 = bsVar.a;
                    if (z) {
                        if (i4 == 0) {
                            arrayList.add(bsVar);
                            this.a.remove(i2);
                        }
                        if (i3 >= i) {
                            break;
                        }
                    } else {
                        if (i4 < 0) {
                            arrayList.add(bsVar);
                            this.a.remove(i2);
                        }
                        if (i3 >= i) {
                        }
                    }
                    size--;
                    i2--;
                    i3++;
                    if (i3 >= i) {
                    }
                }
                i2++;
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }
}
