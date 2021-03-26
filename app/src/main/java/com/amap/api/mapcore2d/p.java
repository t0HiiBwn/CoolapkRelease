package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.CameraPosition;

/* compiled from: CompassView */
class p extends LinearLayout {
    private Bitmap a;
    private Bitmap b;
    private ImageView c;
    private as d;
    private y e;

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
            this.a = null;
            this.b = null;
        } catch (Exception e2) {
            cm.a(e2, "CompassView", "destory");
        }
    }

    public p(Context context, as asVar, y yVar) {
        super(context);
        this.d = asVar;
        this.e = yVar;
        try {
            Bitmap a2 = cm.a("maps_dav_compass_needle_large2d.png");
            Bitmap a3 = cm.a(a2, q.a * 0.8f);
            this.b = a3;
            if (a3 != null) {
                Bitmap a4 = cm.a(a2, q.a * 0.7f);
                this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(a4, (float) ((this.b.getWidth() - a4.getWidth()) / 2), (float) ((this.b.getHeight() - a4.getHeight()) / 2), paint);
            }
        } catch (Throwable th) {
            cm.a(th, "CompassView", "CompassView");
        }
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        this.c.setImageBitmap(this.a);
        this.c.setOnClickListener(new View.OnClickListener() {
            /* class com.amap.api.mapcore2d.p.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.c.setOnTouchListener(new View.OnTouchListener() {
            /* class com.amap.api.mapcore2d.p.AnonymousClass2 */

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    p.this.c.setImageBitmap(p.this.b);
                    return false;
                } else if (motionEvent.getAction() != 1) {
                    return false;
                } else {
                    try {
                        p.this.c.setImageBitmap(p.this.a);
                        CameraPosition cameraPosition = p.this.e.getCameraPosition();
                        p.this.e.animateCamera(new CameraUpdate(m.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f))));
                        return false;
                    } catch (Exception e) {
                        cm.a(e, "CompassView", "onTouch");
                        return false;
                    }
                }
            }
        });
        addView(this.c);
    }
}
