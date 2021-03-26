package com.amap.api.mapcore2d;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;

/* compiled from: MyLocationOverlay */
class bc {
    a a = null;
    ValueAnimator b;
    Animator.AnimatorListener c = new Animator.AnimatorListener() {
        /* class com.amap.api.mapcore2d.bc.AnonymousClass1 */

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            bc.this.c();
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.amap.api.mapcore2d.bc.AnonymousClass2 */

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (bc.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    bc.this.g.setCenter(latLng);
                    bc.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private y e;
    private Marker f;
    private Circle g;
    private MyLocationStyle h;
    private LatLng i;
    private double j;
    private Context k;
    private bl l;
    private int m = 1;
    private boolean n = false;
    private final String o = "location_map_gps_locked.png";
    private final String p = "location_map_gps_3d.png";
    private BitmapDescriptor q = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;

    public bc(y yVar, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = yVar;
        this.l = new bl(applicationContext, yVar);
        a(1, true);
    }

    public void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                bl blVar = this.l;
                if (blVar != null) {
                    blVar.a(false);
                }
                this.m = this.h.getMyLocationType();
                return;
            }
            Marker marker = this.f;
            if (marker != null || this.g != null) {
                bl blVar2 = this.l;
                if (blVar2 != null) {
                    blVar2.a(marker);
                }
                d();
                a(this.h.getMyLocationType());
            }
        } catch (Throwable th) {
            Cdo.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void a(int i2) {
        a(i2, false);
    }

    private void a(int i2, boolean z) {
        this.m = i2;
        this.n = false;
        this.r = false;
        this.u = false;
        this.v = false;
        if (i2 == 1) {
            this.r = true;
            this.s = true;
            this.t = true;
        } else if (i2 == 2) {
            this.r = true;
            this.s = false;
            this.t = true;
        }
        if (this.l != null) {
            b();
        }
    }

    private void b() {
        this.l.b();
    }

    public void a(Location location) {
        if (location != null) {
            MyLocationStyle myLocationStyle = this.h;
            if (myLocationStyle != null) {
                a(myLocationStyle.isMyLocationShowing());
                if (!this.h.isMyLocationShowing()) {
                    return;
                }
            }
            this.i = new LatLng(location.getLatitude(), location.getLongitude());
            this.j = (double) location.getAccuracy();
            if (this.f == null && this.g == null) {
                d();
            }
            Circle circle = this.g;
            if (circle != null) {
                try {
                    double d2 = this.j;
                    if (d2 != -1.0d) {
                        circle.setRadius(d2);
                    }
                } catch (Throwable th) {
                    Cdo.c(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            b(location.getBearing());
            if (!this.i.equals(this.f.getPosition())) {
                a(this.i);
            } else {
                c();
            }
        }
    }

    private void b(float f2) {
        if (this.t) {
            float f3 = f2 % 360.0f;
            if (f3 > 180.0f) {
                f3 -= 360.0f;
            } else if (f3 < -180.0f) {
                f3 += 360.0f;
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f3);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.r) {
            if (!this.s || !this.n) {
                this.n = true;
                try {
                    this.e.animateCamera(CameraUpdateFactory.changeLatLng(this.i));
                } catch (Throwable th) {
                    Cdo.c(th, "MyLocationOverlay", "moveMapToLocation");
                    th.printStackTrace();
                }
            }
        }
    }

    private void d() {
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            f();
            return;
        }
        if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        f();
    }

    public void a() throws RemoteException {
        e();
        if (this.l != null) {
            b();
            this.l = null;
        }
    }

    private void e() {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                Cdo.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f.destroy();
            this.f = null;
            bl blVar = this.l;
            if (blVar != null) {
                blVar.a((Marker) null);
            }
        }
    }

    public void a(boolean z) {
        Circle circle = this.g;
        if (!(circle == null || circle.isVisible() == z)) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker != null && marker.isVisible() != z) {
            this.f.setVisible(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5 A[Catch:{ all -> 0x010c }] */
    private void f() {
        LatLng latLng;
        try {
            if (this.g == null) {
                this.g = this.e.addCircle(new CircleOptions().zIndex(1.0f));
            }
            Circle circle = this.g;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.h.getStrokeWidth()) {
                    this.g.setStrokeWidth(this.h.getStrokeWidth());
                }
                if (this.g.getFillColor() != this.h.getRadiusFillColor()) {
                    this.g.setFillColor(this.h.getRadiusFillColor());
                }
                if (this.g.getStrokeColor() != this.h.getStrokeColor()) {
                    this.g.setStrokeColor(this.h.getStrokeColor());
                }
                LatLng latLng2 = this.i;
                if (latLng2 != null) {
                    this.g.setCenter(latLng2);
                }
                this.g.setRadius(this.j);
                this.g.setVisible(true);
            }
            if (this.f == null) {
                this.f = this.e.addMarker(new MarkerOptions().visible(false));
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
                if (this.f.getIcons() != null) {
                    if (this.f.getIcons().size() != 0) {
                        if (this.h.getMyLocationIcon() != null && !this.f.getIcons().get(0).equals(this.h.getMyLocationIcon())) {
                            this.f.setIcon(this.h.getMyLocationIcon());
                        }
                        latLng = this.i;
                        if (latLng != null) {
                            this.f.setPosition(latLng);
                            this.f.setVisible(true);
                        }
                    }
                }
                this.f.setIcon(this.h.getMyLocationIcon());
                latLng = this.i;
                if (latLng != null) {
                }
            }
            c();
            bl blVar = this.l;
            if (blVar != null) {
                blVar.a(this.f);
            }
        } catch (Throwable th) {
            Cdo.c(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    public void a(float f2) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f2);
        }
    }

    private void a(LatLng latLng) {
        LatLng position = this.f.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.a == null) {
            this.a = new a();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), position, latLng);
            this.b = ofObject;
            ofObject.addListener(this.c);
            this.b.addUpdateListener(this.d);
            this.b.setDuration(1000L);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.b.setEvaluator(this.a);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }

    /* compiled from: MyLocationOverlay */
    public class a implements TypeEvaluator {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = (double) f;
            return new LatLng(latLng.latitude + ((latLng2.latitude - latLng.latitude) * d), latLng.longitude + (d * (latLng2.longitude - latLng.longitude)));
        }
    }
}
