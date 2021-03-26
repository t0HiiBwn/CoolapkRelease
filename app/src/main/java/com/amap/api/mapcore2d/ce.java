package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;

/* compiled from: ZoomControllerView */
class ce extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private ImageView g;
    private ImageView h;
    private aq i;
    private y j;
    private int k = 0;

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
            Bitmap bitmap4 = this.d;
            if (bitmap4 != null) {
                bitmap4.recycle();
            }
            Bitmap bitmap5 = this.e;
            if (bitmap5 != null) {
                bitmap5.recycle();
            }
            Bitmap bitmap6 = this.f;
            if (bitmap6 != null) {
                bitmap6.recycle();
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        } catch (Exception e2) {
            cm.a(e2, "ZoomControllerView", "destory");
        }
    }

    public ce(Context context, aq aqVar, y yVar) {
        super(context);
        setWillNotDraw(false);
        this.i = aqVar;
        this.j = yVar;
        try {
            Bitmap a2 = cm.a("zoomin_selected2d.png");
            this.a = a2;
            this.a = cm.a(a2, q.a);
            Bitmap a3 = cm.a("zoomin_unselected2d.png");
            this.b = a3;
            this.b = cm.a(a3, q.a);
            Bitmap a4 = cm.a("zoomout_selected2d.png");
            this.c = a4;
            this.c = cm.a(a4, q.a);
            Bitmap a5 = cm.a("zoomout_unselected2d.png");
            this.d = a5;
            this.d = cm.a(a5, q.a);
            this.e = cm.a("zoomin_pressed2d.png");
            this.f = cm.a("zoomout_pressed2d.png");
            this.e = cm.a(this.e, q.a);
            this.f = cm.a(this.f, q.a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.a);
            this.g.setOnClickListener(new View.OnClickListener() {
                /* class com.amap.api.mapcore2d.ce.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ce.this.h.setImageBitmap(ce.this.c);
                    if (ce.this.j.getZoomLevel() > ((float) (((int) ce.this.j.getMaxZoomLevel()) - 2))) {
                        ce.this.g.setImageBitmap(ce.this.b);
                    } else {
                        ce.this.g.setImageBitmap(ce.this.a);
                    }
                    ce ceVar = ce.this;
                    ceVar.a(ceVar.j.getZoomLevel() + 1.0f);
                    ce.this.i.c();
                }
            });
            ImageView imageView2 = new ImageView(context);
            this.h = imageView2;
            imageView2.setImageBitmap(this.c);
            this.h.setOnClickListener(new View.OnClickListener() {
                /* class com.amap.api.mapcore2d.ce.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ce.this.g.setImageBitmap(ce.this.a);
                    ce ceVar = ce.this;
                    ceVar.a(ceVar.j.getZoomLevel() - 1.0f);
                    if (ce.this.j.getZoomLevel() < ((float) (((int) ce.this.j.getMinZoomLevel()) + 2))) {
                        ce.this.h.setImageBitmap(ce.this.d);
                    } else {
                        ce.this.h.setImageBitmap(ce.this.c);
                    }
                    ce.this.i.d();
                }
            });
            this.g.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.mapcore2d.ce.AnonymousClass3 */

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ce.this.j.getZoomLevel() >= ce.this.j.getMaxZoomLevel()) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        ce.this.g.setImageBitmap(ce.this.e);
                    } else if (motionEvent.getAction() == 1) {
                        ce.this.g.setImageBitmap(ce.this.a);
                        try {
                            ce.this.j.animateCamera(new CameraUpdate(m.b()));
                        } catch (RemoteException e) {
                            cm.a(e, "ZoomControllerView", "ontouch");
                        }
                    }
                    return false;
                }
            });
            this.h.setOnTouchListener(new View.OnTouchListener() {
                /* class com.amap.api.mapcore2d.ce.AnonymousClass4 */

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ce.this.j.getZoomLevel() <= ce.this.j.getMinZoomLevel()) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        ce.this.h.setImageBitmap(ce.this.f);
                    } else if (motionEvent.getAction() == 1) {
                        ce.this.h.setImageBitmap(ce.this.c);
                        try {
                            ce.this.j.animateCamera(new CameraUpdate(m.c()));
                        } catch (RemoteException e) {
                            cm.a(e, "ZoomControllerView", "onTouch");
                        }
                    }
                    return false;
                }
            });
            this.g.setPadding(0, 0, 20, -2);
            this.h.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.g);
            addView(this.h);
        } catch (Throwable th) {
            cm.a(th, "ZoomControllerView", "ZoomControllerView");
        }
    }

    public void a(int i2) {
        this.k = i2;
        removeView(this.g);
        removeView(this.h);
        addView(this.g);
        addView(this.h);
    }

    public int b() {
        return this.k;
    }

    public void a(float f2) {
        try {
            if (f2 < this.j.getMaxZoomLevel() && f2 > this.j.getMinZoomLevel()) {
                this.g.setImageBitmap(this.a);
                this.h.setImageBitmap(this.c);
            } else if (f2 <= this.j.getMinZoomLevel()) {
                this.h.setImageBitmap(this.d);
                this.g.setImageBitmap(this.a);
            } else if (f2 >= this.j.getMaxZoomLevel()) {
                this.g.setImageBitmap(this.b);
                this.h.setImageBitmap(this.c);
            }
        } catch (Throwable th) {
            cm.a(th, "ZoomControllerView", "setZoomBitmap");
        }
    }
}
