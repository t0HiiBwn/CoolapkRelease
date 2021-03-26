package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;

/* compiled from: ScaleView */
class bk extends View {
    private String a = "";
    private int b = 0;
    private b c;
    private Paint d;
    private Paint e;
    private Rect f;

    public void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
    }

    public bk(Context context, b bVar) {
        super(context);
        this.c = bVar;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(-16777216);
        this.d.setStrokeWidth(q.a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.e.setTextSize(q.a * 20.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        try {
            if (!this.c.c().isScaleControlsEnabled()) {
                return;
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (!this.a.equals("") && (i = this.b) != 0) {
            try {
                if (i > this.c.getWidth() / 5) {
                    i = this.c.getWidth() / 5;
                }
            } catch (Exception e3) {
                cm.a(e3, "ScaleView", "onDraw");
            }
            Point f2 = this.c.f();
            Paint paint = this.e;
            String str = this.a;
            paint.getTextBounds(str, 0, str.length(), this.f);
            if (f2.x + i > this.c.getWidth() - 10) {
                i2 = (this.c.getWidth() - 10) - ((this.f.width() + i) / 2);
            } else {
                i2 = f2.x + ((i - this.f.width()) / 2);
            }
            int height = (f2.y - this.f.height()) + 5;
            canvas.drawText(this.a, (float) i2, (float) height, this.e);
            int width = i2 - ((i - this.f.width()) / 2);
            int height2 = height + (this.f.height() - 5);
            float f3 = (float) width;
            float f4 = (float) (height2 - 2);
            float f5 = (float) (height2 + 2);
            canvas.drawLine(f3, f4, f3, f5, this.d);
            float f6 = (float) height2;
            float f7 = (float) (width + i);
            canvas.drawLine(f3, f6, f7, f6, this.d);
            canvas.drawLine(f7, f4, f7, f5, this.d);
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(int i) {
        this.b = i;
    }
}
