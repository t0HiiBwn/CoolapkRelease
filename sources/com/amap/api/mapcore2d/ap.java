package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.LatLng;

/* compiled from: LocationView */
class ap extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private ImageView d;
    private y e;
    private boolean f = false;

    public void a() {
        try {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                bitmap3.recycle();
            }
            this.a = null;
            this.b = null;
            this.c = null;
        } catch (Exception e2) {
            cm.a(e2, "LocationView", "destory");
        }
    }

    public ap(Context context, as asVar, y yVar) {
        super(context);
        this.e = yVar;
        try {
            this.a = cm.a("location_selected2d.png");
            this.b = cm.a("location_pressed2d.png");
            this.a = cm.a(this.a, q.a);
            this.b = cm.a(this.b, q.a);
            Bitmap a2 = cm.a("location_unselected2d.png");
            this.c = a2;
            this.c = cm.a(a2, q.a);
        } catch (Throwable th) {
            cm.a(th, "LocationView", "LocationView");
        }
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setImageBitmap(this.a);
        this.d.setPadding(0, 20, 20, 0);
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.mapcore2d.ap.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.d.setOnTouchListener(new View.OnTouchListener() {
            /* class com.amap.api.mapcore2d.ap.AnonymousClass2 */

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!ap.this.f) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    ap.this.d.setImageBitmap(ap.this.b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        ap.this.d.setImageBitmap(ap.this.a);
                        ap.this.e.setMyLocationEnabled(true);
                        Location myLocation = ap.this.e.getMyLocation();
                        if (myLocation == null) {
                            return false;
                        }
                        LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                        ap.this.e.showMyLocationOverlay(myLocation);
                        ap.this.e.moveCamera(new CameraUpdate(m.a(latLng, ap.this.e.getZoomLevel())));
                    } catch (Exception e) {
                        cm.a(e, "LocationView", "onTouch");
                    }
                }
                return false;
            }
        });
        addView(this.d);
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.d.setImageBitmap(this.a);
        } else {
            this.d.setImageBitmap(this.c);
        }
        this.d.postInvalidate();
    }
}
