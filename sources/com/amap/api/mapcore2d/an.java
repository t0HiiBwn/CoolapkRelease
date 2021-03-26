package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.amap.api.maps2d.model.TileProvider;
import java.util.Iterator;

/* compiled from: LayerPropertys */
class an extends ao {
    av a;
    public String b = "";
    public int c = 19;
    public int d = 3;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public long i = 0;
    public cb j = null;
    TileProvider k = null;
    public int l = -1;
    public String m = "";
    ba n = null;
    u o = null;
    bn<bs> p = null;
    private String r = "LayerPropertys";
    private boolean s = false;

    public an(av avVar) {
        this.a = avVar;
    }

    void a(boolean z) {
        this.s = z;
        if (z) {
            this.q.d();
            return;
        }
        this.n.c();
        this.q.c();
    }

    boolean a() {
        return this.s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof an)) {
            return false;
        }
        return this.b.equals(((an) obj).b);
    }

    public int hashCode() {
        return this.l;
    }

    public String toString() {
        return this.b;
    }

    protected void a(Canvas canvas) {
        try {
            bn<bs> bnVar = this.p;
            if (bnVar != null) {
                Iterator<bs> it2 = bnVar.iterator();
                while (it2.hasNext()) {
                    bs next = it2.next();
                    if (next != null) {
                        if (next.h < 0) {
                            boolean z = this.e;
                        } else {
                            Bitmap a2 = this.n.a(next.h);
                            PointF a3 = this.a.a(next.b, next.c);
                            if (!(a2 == null || a3 == null)) {
                                canvas.drawBitmap(a2, (Rect) null, new RectF(a3.x, a3.y, a3.x + ((float) this.a.a), a3.y + ((float) this.a.a)), (Paint) null);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            cm.a(th, this.r, "drawLayer");
        }
    }

    protected void b() {
        this.q.e();
        this.o.a((ba) null);
        this.n.c();
        this.p.clear();
    }
}
