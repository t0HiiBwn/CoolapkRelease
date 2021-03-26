package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
public class e extends View {
    private Paint a = new Paint();
    private Paint b = new Paint();
    private Paint c = new Paint();
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i = false;

    public e(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.a.setAntiAlias(true);
        this.a.setColor(-2236963);
        this.a.setStrokeWidth(2.0f);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setAntiAlias(true);
        this.b.setColor(-6710887);
        this.b.setStrokeWidth(2.0f);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.setAntiAlias(true);
        this.c.setColor(-16777216);
        this.c.setStrokeWidth(3.0f);
        this.c.setStyle(Paint.Style.FILL_AND_STROKE);
        float f2 = (float) i.b;
        this.d = f2;
        this.e = f2 * 0.33333334f;
        this.g = f2 * 0.6666667f;
        this.f = 0.33333334f * f2;
        this.h = f2 * 0.6666667f;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.i = true;
            invalidate();
            return true;
        } else if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.i = false;
            invalidate();
            performClick();
            return true;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
        float f2 = this.d;
        setMeasuredDimension((int) f2, (int) f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) getWidth()) / 2.0f) - 1.0f, this.i ? this.b : this.a);
        canvas.drawLine(this.e, this.f, this.g, this.h, this.c);
        canvas.drawLine(this.g, this.f, this.e, this.h, this.c);
    }
}
