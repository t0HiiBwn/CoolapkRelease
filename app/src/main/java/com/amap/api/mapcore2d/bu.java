package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: TileOverlayView */
class bu extends View {
    CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
    private y b;
    private CopyOnWriteArrayList<ak> c = new CopyOnWriteArrayList<>();
    private a d = new a();

    /* compiled from: TileOverlayView */
    private class a implements Comparator<Object> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ak akVar = (ak) obj;
            ak akVar2 = (ak) obj2;
            if (akVar == null || akVar2 == null) {
                return 0;
            }
            try {
                if (akVar.getZIndex() > akVar2.getZIndex()) {
                    return 1;
                }
                if (akVar.getZIndex() < akVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Exception e) {
                cm.a(e, "TileOverlayView", "compare");
                return 0;
            }
        }
    }

    public bu(Context context, y yVar) {
        super(context);
        this.b = yVar;
    }

    protected void a(Canvas canvas) {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next.isVisible()) {
                next.a(canvas);
            }
        }
    }

    protected boolean a() {
        return this.c.size() > 0;
    }

    public void b() {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next != null) {
                next.remove();
            }
        }
        this.c.clear();
    }

    void c() {
        Object[] array = this.c.toArray();
        Arrays.sort(array, this.d);
        this.c.clear();
        for (Object obj : array) {
            if (obj != null) {
                this.c.add((ak) obj);
            }
        }
    }

    public void a(ak akVar) {
        if (akVar != null) {
            b(akVar);
            this.c.add(akVar);
            c();
        }
    }

    public boolean b(ak akVar) {
        return this.c.remove(akVar);
    }

    public void a(boolean z) {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next != null && next.isVisible()) {
                next.a(z);
            }
        }
    }

    public void d() {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next != null) {
                next.a();
            }
        }
    }

    public void e() {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next != null) {
                next.b();
            }
        }
    }

    public void f() {
        Iterator<ak> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ak next = it2.next();
            if (next != null) {
                next.c();
            }
        }
    }
}
