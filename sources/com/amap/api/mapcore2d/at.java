package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapOverlayImageView */
class at extends View {
    b a;
    a b = new a();
    private ArrayList<aj> c = new ArrayList<>(8);
    private ArrayList<ab> d = new ArrayList<>(8);
    private volatile int e = 0;
    private Handler f = new Handler();
    private Runnable g = new Runnable() {
        /* class com.amap.api.mapcore2d.at.AnonymousClass1 */

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Collections.sort(at.this.d, at.this.b);
                Collections.sort(at.this.c, at.this.b);
                at.this.postInvalidate();
            } catch (Throwable unused) {
            }
        }
    };
    private ae h;
    private ab i;
    private ab j = null;
    private float k = 0.0f;
    private CopyOnWriteArrayList<Integer> l = new CopyOnWriteArrayList<>();

    private int h() {
        int i2 = this.e;
        this.e = i2 + 1;
        return i2;
    }

    /* compiled from: MapOverlayImageView */
    static class a implements Serializable, Comparator<ac> {
        a() {
        }

        /* renamed from: a */
        public int compare(ac acVar, ac acVar2) {
            if (acVar == null || acVar2 == null) {
                return 0;
            }
            try {
                if (acVar.getZIndex() > acVar2.getZIndex()) {
                    return 1;
                }
                if (acVar.getZIndex() < acVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Throwable th) {
                cm.a(th, "MapOverlayImageView", "compare");
                return 0;
            }
        }
    }

    public b a() {
        return this.a;
    }

    public at(Context context, AttributeSet attributeSet, b bVar) {
        super(context, attributeSet);
        this.a = bVar;
    }

    public synchronized ab a(String str) throws RemoteException {
        Iterator<ab> it2 = this.d.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (next != null && next.getId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    protected int b() {
        return this.d.size();
    }

    public synchronized void c() {
        try {
            ArrayList<ab> arrayList = this.d;
            if (arrayList != null) {
                Iterator<ab> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().destroy();
                }
                this.d.clear();
            }
            ArrayList<aj> arrayList2 = this.c;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.a.postInvalidate();
        } catch (Throwable th) {
            cm.a(th, "MapOverlayImageView", "clear");
        }
    }

    void d() {
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 5);
    }

    public synchronized void a(ab abVar) {
        try {
            e(abVar);
            abVar.setAddIndex(h());
            this.d.remove(abVar);
            this.d.add(abVar);
            Collections.sort(this.d, this.b);
        } catch (Throwable th) {
            cm.a(th, "MapOverlayImageView", "addMarker");
        }
    }

    public synchronized void a(aj ajVar) throws RemoteException {
        this.c.remove(ajVar);
        ajVar.setAddIndex(h());
        this.c.add(ajVar);
        Collections.sort(this.c, this.b);
    }

    public synchronized void b(aj ajVar) {
        this.c.remove(ajVar);
        postInvalidate();
    }

    public synchronized boolean b(ab abVar) {
        boolean remove;
        e(abVar);
        remove = this.d.remove(abVar);
        postInvalidate();
        this.a.postInvalidate();
        return remove;
    }

    public synchronized void c(ab abVar) {
        if (abVar != null) {
            ab abVar2 = this.j;
            if (abVar2 != abVar) {
                if (abVar2 != null && abVar2.getZIndex() == 2.14748365E9f) {
                    this.j.setZIndex(this.k);
                }
                this.k = abVar.getZIndex();
                this.j = abVar;
                abVar.setZIndex(2.14748365E9f);
                d();
            }
        }
    }

    public void d(ab abVar) {
        if (abVar != null) {
            if (this.h == null) {
                this.h = new ae();
            }
            Rect a2 = abVar.a();
            this.h = new ae(a2.left + (abVar.getWidth() / 2), a2.top);
            this.i = abVar;
            try {
                this.a.getMainHandler().post(new Runnable() {
                    /* class com.amap.api.mapcore2d.at.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            at.this.a.a(at.this.e());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                cm.a(th, "MapOverlayImageView", "showInfoWindow");
            }
        }
    }

    public void e(ab abVar) {
        if (f(abVar)) {
            this.a.e();
        }
    }

    public boolean f(ab abVar) {
        return this.a.b(abVar);
    }

    public synchronized void a(Canvas canvas) {
        i();
        Rect rect = new Rect(0, 0, this.a.getMapWidth(), this.a.getMapHeight());
        ae aeVar = new ae();
        Iterator<ab> it2 = this.d.iterator();
        Iterator<aj> it3 = this.c.iterator();
        ab b2 = b(it2, rect, aeVar);
        aj a2 = a(it3, rect, aeVar);
        while (true) {
            if (b2 != null || a2 != null) {
                if (b2 == null) {
                    a2.draw(canvas);
                    a2 = a(it3, rect, aeVar);
                } else if (a2 == null) {
                    b2.a(canvas, this.a);
                    b2 = b(it2, rect, aeVar);
                } else if (b2.getZIndex() < a2.getZIndex() || (b2.getZIndex() == a2.getZIndex() && b2.getAddIndex() < a2.getAddIndex())) {
                    b2.a(canvas, this.a);
                    b2 = b(it2, rect, aeVar);
                } else {
                    a2.draw(canvas);
                    a2 = a(it3, rect, aeVar);
                }
            }
        }
    }

    private aj a(Iterator<aj> it2, Rect rect, ae aeVar) {
        while (it2.hasNext()) {
            aj next = it2.next();
            LatLng position = next.getPosition();
            if (position != null) {
                this.a.b(position.latitude, position.longitude, aeVar);
                if (a(rect, aeVar.a, aeVar.b)) {
                    return next;
                }
            }
        }
        return null;
    }

    private ab b(Iterator<ab> it2, Rect rect, ae aeVar) {
        while (it2.hasNext()) {
            ab next = it2.next();
            LatLng realPosition = next.getRealPosition();
            if (realPosition != null) {
                this.a.b(realPosition.latitude, realPosition.longitude, aeVar);
                if (a(rect, aeVar.a, aeVar.b)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void i() {
        ab abVar;
        Iterator<ab> it2 = this.d.iterator();
        while (it2.hasNext()) {
            ab next = it2.next();
            if (!(next == null || (abVar = this.i) == null || !abVar.getId().equals(next.getId()))) {
                try {
                    if (this.i.isViewMode()) {
                        return;
                    }
                } catch (RemoteException e2) {
                    cm.a(e2, "MapOverlayImageView", "redrawInfoWindow");
                }
                Rect a2 = next.a();
                this.h = new ae(a2.left + (next.getWidth() / 2), a2.top);
                this.a.redrawInfoWindow();
            }
        }
    }

    public ab e() {
        return this.i;
    }

    public synchronized ab a(MotionEvent motionEvent) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            ab abVar = this.d.get(size);
            if (abVar != null) {
                if (a(abVar.a(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return abVar;
                }
            }
        }
        return null;
    }

    public void f() {
        try {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            c();
        } catch (Exception e2) {
            cm.a(e2, "MapOverlayImageView", "destory");
            Log.d("amapApi", "MapOverlayImageView clear erro" + e2.getMessage());
        }
    }

    public synchronized boolean b(MotionEvent motionEvent) {
        boolean z;
        z = false;
        int size = this.d.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            ab abVar = this.d.get(size);
            if (abVar != null) {
                Rect a2 = abVar.a();
                boolean a3 = a(a2, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (a3) {
                    this.h = new ae(a2.left + (abVar.getWidth() / 2), a2.top);
                    this.i = abVar;
                    z = a3;
                    break;
                }
            }
            size--;
        }
        return z;
    }

    public synchronized List<Marker> g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Rect rect = new Rect(0, 0, this.a.getMapWidth(), this.a.getMapHeight());
        ae aeVar = new ae();
        Iterator<ab> it2 = this.d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ab next = it2.next();
            LatLng realPosition = next.getRealPosition();
            if (realPosition == null) {
                break;
            }
            this.a.b(realPosition.latitude, realPosition.longitude, aeVar);
            if (a(rect, aeVar.a, aeVar.b)) {
                arrayList.add(new Marker(next));
            }
        }
        return arrayList;
    }

    public boolean a(Rect rect, int i2, int i3) {
        return rect.contains(i2, i3);
    }
}
