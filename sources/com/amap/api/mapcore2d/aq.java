package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import com.amap.api.mapcore2d.az;
import java.util.LinkedList;

/* compiled from: MapController */
final class aq implements View.OnKeyListener {
    private float a = 0.0f;
    private float b = 0.0f;
    private az c;
    private boolean d;
    private b e;
    private a f;

    aq(az azVar) {
        this.c = azVar;
        this.d = false;
        this.e = new b();
        this.f = new a();
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public void a(float f2) {
        this.a = f2;
    }

    public void b(float f2) {
        this.b = f2;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (i) {
            case 19:
                d(0, -10);
                break;
            case 20:
                d(0, 10);
                break;
            case 21:
                d(-10, 0);
                break;
            case 22:
                d(10, 0);
                break;
            default:
                return false;
        }
        return true;
    }

    public void a(w wVar) {
        if (b(wVar)) {
            c(wVar);
        }
    }

    private boolean b(w wVar) {
        az azVar;
        w f2;
        if (wVar == null || (azVar = this.c) == null || azVar.c == null || (f2 = this.c.c.f()) == null) {
            return false;
        }
        if (wVar.b() == f2.b() && wVar.a() == f2.a()) {
            return false;
        }
        return true;
    }

    public void a(w wVar, float f2) {
        if (b(wVar) || f(f2)) {
            c(wVar);
            e(f2);
        }
    }

    private void c(w wVar) {
        az azVar = this.c;
        if (!(azVar == null || azVar.g == null)) {
            this.c.g.r();
        }
        az azVar2 = this.c;
        if (azVar2 != null && azVar2.c != null) {
            this.c.c.a(wVar);
        }
    }

    public float c(float f2) {
        if (!f(f2)) {
            return f2;
        }
        e(f2);
        return f2;
    }

    public float a(float f2, int i) {
        if (f2 >= ((float) q.c)) {
            f2 = (float) q.c;
        }
        if (f2 <= ((float) q.d)) {
            f2 = (float) q.d;
        }
        if (!f(f2)) {
            return f2;
        }
        b(f2, i);
        return f2;
    }

    private float e(float f2) {
        az azVar = this.c;
        if (!(azVar == null || azVar.c == null)) {
            b g = this.c.c.g();
            g.r();
            f2 = g.a(f2);
            this.c.c.a(f2);
            try {
                if (this.c.g.c().isScaleControlsEnabled()) {
                    this.c.g.s();
                }
            } catch (RemoteException e2) {
                cm.a(e2, "MapController", "setZoom");
            }
        }
        return f2;
    }

    private boolean f(float f2) {
        az azVar = this.c;
        if (azVar == null || azVar.c == null || f2 == this.c.c.e()) {
            return false;
        }
        return true;
    }

    public void a(float f2, float f3) {
        a(f2, f3, 0, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A[Catch:{ Exception -> 0x00d5 }] */
    public Pair<Float, Boolean> a(float f2, float f3, int i, int i2, int i3, int i4) {
        az azVar;
        double d2;
        double d3;
        if (!(f2 <= 0.0f || f3 <= 0.0f || (azVar = this.c) == null || azVar.c == null || this.c.b == null)) {
            try {
                this.c.c.e();
                int b2 = this.c.b.b(i, i2, i3);
                int a2 = this.c.b.a(i, i2, i4);
                if (b2 == 0 && a2 == 0) {
                    this.a = f2;
                    this.b = f3;
                    return null;
                }
                double d4 = (double) (((float) b2) / f3);
                double min = Math.min((double) (((float) a2) / f2), d4);
                double d5 = this.c.h.k / min;
                double d6 = this.c.h.d;
                boolean z = false;
                int i5 = 0;
                while (true) {
                    d6 /= 2.0d;
                    if (d6 <= d5) {
                        break;
                    }
                    i5++;
                }
                float d7 = d((float) (((double) i5) + (Math.log((this.c.h.d / ((double) (1 << i5))) / d5) / Math.log(2.0d))));
                float f4 = (float) ((int) d7);
                double d8 = (double) (d7 - f4);
                if (d8 > 1.0d - ((1.0d - az.a) * 0.4d)) {
                    d3 = az.a;
                } else {
                    if (d8 > az.a) {
                        d2 = az.a;
                    } else {
                        if (Math.abs(d8 - az.a) <= 9.999999747378752E-5d) {
                            d2 = az.a;
                        }
                        Float valueOf = Float.valueOf(d7);
                        if (min == d4) {
                            z = true;
                        }
                        return new Pair<>(valueOf, Boolean.valueOf(z));
                    }
                    d3 = d2 - 9.999999747378752E-5d;
                }
                d7 = ((float) d3) + f4;
                Float valueOf = Float.valueOf(d7);
                if (min == d4) {
                }
                return new Pair<>(valueOf, Boolean.valueOf(z));
            } catch (Exception e2) {
                cm.a(e2, "MapController", "zoomToSpan");
            }
        }
        return null;
    }

    public void a(float f2, float f3, int i, int i2, int i3) {
        az azVar;
        Exception e2;
        double d2;
        double d3;
        float f4 = 0.0f;
        if (f2 > 0.0f && f3 > 0.0f && (azVar = this.c) != null && azVar.c != null && this.c.b != null) {
            try {
                float e3 = this.c.c.e();
                int b2 = this.c.b.b(i, i2, i3);
                int a2 = this.c.b.a(i, i2, i3);
                if (b2 == 0 && a2 == 0) {
                    this.a = f2;
                    this.b = f3;
                    return;
                }
                try {
                    double min = this.c.h.k / Math.min((double) (((float) a2) / f2), (double) (((float) b2) / f3));
                    int i4 = 0;
                    double d4 = this.c.h.d;
                    while (true) {
                        d4 /= 2.0d;
                        if (d4 <= min) {
                            break;
                        }
                        i4++;
                    }
                    f4 = d((float) (((double) i4) + (Math.log((this.c.h.d / ((double) (1 << i4))) / min) / Math.log(2.0d))));
                    float f5 = (float) ((int) f4);
                    double d5 = (double) (f4 - f5);
                    if (d5 > 1.0d - ((1.0d - az.a) * 0.4d)) {
                        d3 = az.a;
                    } else {
                        if (d5 > az.a) {
                            d2 = az.a;
                        } else {
                            if (Math.abs(d5 - az.a) <= 9.999999747378752E-5d) {
                                d2 = az.a;
                            }
                            c(f4);
                        }
                        d3 = d2 - 9.999999747378752E-5d;
                    }
                    f4 = f5 + ((float) d3);
                } catch (Exception e4) {
                    e2 = e4;
                    f4 = e3;
                    cm.a(e2, "MapController", "zoomToSpan");
                    c(f4);
                }
                c(f4);
            } catch (Exception e5) {
                e2 = e5;
                cm.a(e2, "MapController", "zoomToSpan");
                c(f4);
            }
        }
    }

    public float d(float f2) {
        az azVar = this.c;
        if (azVar == null || azVar.c == null) {
            return f2;
        }
        if (f2 < ((float) this.c.c.b())) {
            f2 = (float) this.c.c.b();
        }
        return f2 > ((float) this.c.c.a()) ? (float) this.c.c.a() : f2;
    }

    public boolean c() {
        return a(0);
    }

    public boolean d() {
        return b(0);
    }

    public boolean a(int i) {
        return a(1, i);
    }

    boolean a(int i, int i2) {
        az azVar = this.c;
        if (azVar == null || azVar.c == null) {
            return false;
        }
        return a(this.c.c.c() / 2, this.c.c.d() / 2, true, false, i, i2);
    }

    boolean b(int i, int i2) {
        az azVar = this.c;
        if (azVar == null || azVar.c == null) {
            return false;
        }
        return a(this.c.c.c() / 2, this.c.c.d() / 2, false, false, i, i2);
    }

    public boolean b(int i) {
        return b(1, i);
    }

    public void a(boolean z) {
        float f2;
        this.c.c.g().r();
        if (z) {
            f2 = this.c.c.e() + ((float) 1);
        } else {
            f2 = this.c.c.e() - ((float) 1);
        }
        float a2 = this.c.c.g().a(f2);
        if (a2 != this.c.c.e()) {
            c(a2);
        }
    }

    public boolean b(float f2, int i) {
        return a(this.c.c.c() / 2, this.c.c.d() / 2, f2, i);
    }

    public boolean a(float f2, int i, int i2, int i3) {
        return a(i, i2, f2, i3);
    }

    public boolean c(int i, int i2) {
        return a(i, i2, true, true);
    }

    public void a(w wVar, int i) {
        this.f.a(wVar, null, null, i);
    }

    public void b(boolean z) {
        this.e.a();
        this.f.b();
    }

    public void d(int i, int i2) {
        if (this.d) {
            this.d = false;
        } else if ((i != 0 || i2 != 0) && this.c != null) {
            try {
                if (q.s) {
                    this.c.h.a(new PointF(0.0f, 0.0f), new PointF((float) i, (float) i2), this.c.c.e());
                }
                this.c.c.a(false, false);
            } catch (Throwable th) {
                cm.a(th, "MapController", "scrollBy");
            }
        }
    }

    public void a(int i, int i2, int i3) {
        if (this.d) {
            this.d = false;
        } else if ((i != 0 || i2 != 0) && this.c != null) {
            try {
                if (q.s) {
                    a(this.c.h.a(new PointF(0.0f, 0.0f), new PointF((float) i, (float) i2)), i3);
                }
                this.c.c.a(false, false);
            } catch (Throwable th) {
                cm.a(th, "MapController", "scrollBy");
            }
        }
    }

    public void e() {
        this.d = true;
    }

    public void a(int i, int i2, float f2, boolean z, boolean z2, int i3) {
        this.e.a(i, i2, f2, z, z2, i3);
    }

    private boolean a(int i, int i2, boolean z, boolean z2, int i3, int i4) {
        float f2;
        az azVar = this.c;
        boolean z3 = false;
        if (!(azVar == null || azVar.c == null)) {
            this.c.c.g().r();
            az.c cVar = this.c.c;
            if (z) {
                f2 = cVar.e() + ((float) i3);
            } else {
                f2 = cVar.e() - ((float) i3);
            }
            float a2 = this.c.c.g().a(f2);
            if (a2 != this.c.c.e()) {
                a(i, i2, a2, z, z2, i4);
                z3 = true;
            }
            try {
                if (this.c.g.c().isScaleControlsEnabled()) {
                    this.c.g.s();
                }
            } catch (RemoteException e2) {
                cm.a(e2, "MapController", "zoomWithAnimation");
            }
        }
        return z3;
    }

    public boolean a(int i, int i2, float f2, int i3) {
        az azVar = this.c;
        boolean z = false;
        if (!(azVar == null || azVar.c == null)) {
            this.c.c.g().r();
            float e2 = this.c.c.e();
            if (f2 != e2) {
                this.e.a(i, i2, f2, e2, i3);
                z = true;
            }
            try {
                if (this.c.g.c().isScaleControlsEnabled()) {
                    this.c.g.s();
                }
            } catch (RemoteException e3) {
                cm.a(e3, "MapController", "zoomToAnimation");
            }
        }
        return z;
    }

    private boolean a(int i, int i2, boolean z, boolean z2) {
        return a(i, i2, z, z2, 1, 0);
    }

    public boolean f() {
        return this.f.a();
    }

    public void g() {
        this.f.b();
    }

    /* compiled from: MapController */
    private class a implements bz {
        private by b;
        private Message c;
        private Runnable d;

        private a() {
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public boolean a() {
            by byVar = this.b;
            if (byVar != null) {
                return byVar.f();
            }
            return false;
        }

        public void a(w wVar, Message message, Runnable runnable, int i) {
            if (aq.this.c != null) {
                aq.this.c.d.a = true;
                aq.this.c.h.m = wVar.g();
            }
            by a2 = a(wVar, i);
            this.b = a2;
            this.c = message;
            this.d = runnable;
            if (a2 != null) {
                a2.d();
            }
        }

        private by a(w wVar, int i) {
            int i2 = i < 500 ? 500 : i;
            try {
                return new by(i2, 10, aq.this.c.h.l, wVar, i2, this);
            } catch (Throwable th) {
                cm.a(th, "MapController", "makeTransTool");
                return null;
            }
        }

        private void d() {
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public void b() {
            by byVar = this.b;
            if (byVar != null) {
                byVar.e();
            }
        }

        @Override // com.amap.api.mapcore2d.bz
        public void a(w wVar) {
            if (wVar != null && aq.this.c != null) {
                if (wVar.d() == Long.MIN_VALUE || wVar.c() == Long.MIN_VALUE) {
                    aq.this.a(aq.this.c.h.b(wVar));
                    return;
                }
                aq.this.a(wVar);
            }
        }

        @Override // com.amap.api.mapcore2d.bz
        public void c() {
            Message message = this.c;
            if (message != null) {
                message.getTarget().sendMessage(this.c);
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
            d();
            if (aq.this.c != null && aq.this.c.d != null) {
                aq.this.c.d.a = false;
            }
        }
    }

    /* compiled from: MapController */
    private class b implements Animation.AnimationListener {
        private LinkedList<Animation> b;
        private cf c;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        private b() {
            this.b = new LinkedList<>();
            this.c = null;
        }

        public void a() {
            this.b.clear();
        }

        public void a(int i, int i2, float f, boolean z, boolean z2, int i3) {
            if (!z) {
                a(f, i, i2, z2, i3);
            } else {
                b(f, i, i2, z2, i3);
            }
        }

        private void a(float f, int i, int i2, boolean z, int i3) {
            try {
                if (this.c != null || aq.this.c == null || aq.this.c.c == null) {
                    cf cfVar = this.c;
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cfVar.a(i3);
                } else {
                    this.c = new cf(aq.this.c.c.g(), this, i3);
                }
                cf cfVar2 = this.c;
                if (cfVar2 != null) {
                    cfVar2.d = z;
                    this.c.c = f;
                    this.c.a(f, false, (float) i, (float) i2);
                }
            } catch (Throwable th) {
                cm.a(th, "MapController", "doZoomOut");
            }
        }

        private void b(float f, int i, int i2, boolean z, int i3) {
            try {
                cf cfVar = this.c;
                if (cfVar == null) {
                    this.c = new cf(aq.this.c.c.g(), this, i3);
                } else {
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cfVar.a(i3);
                }
                this.c.c = f;
                this.c.d = z;
                if (this.c.d) {
                    Point point = new Point(i, i2);
                    w a2 = aq.this.c.c.g().d().a(i, i2);
                    aq.this.c.h.l = aq.this.c.h.a(a2);
                    aq.this.c.h.a(point);
                }
                this.c.a(f, true, (float) i, (float) i2);
            } catch (Throwable th) {
                cm.a(th, "MapController", "doZoomIn");
            }
        }

        public void a(int i, int i2, float f, float f2, int i3) {
            try {
                cf cfVar = this.c;
                if (cfVar == null) {
                    this.c = new cf(aq.this.c.c.g(), this, i3);
                } else {
                    if (i3 <= 160) {
                        i3 = 160;
                    }
                    cfVar.a(i3);
                }
                this.c.c = f;
                this.c.a(f, f > f2, (float) i, (float) i2);
            } catch (Throwable th) {
                cm.a(th, "MapController", "zoomTo");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (aq.this.c != null) {
                if (this.b.size() == 0) {
                    aq.this.c.e.b();
                } else {
                    aq.this.c.c.g().startAnimation(this.b.remove());
                }
            }
        }
    }
}
