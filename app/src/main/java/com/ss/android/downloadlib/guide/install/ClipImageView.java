package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ClipImageView extends ImageView {
    private boolean a = true;
    private Path b;
    private RectF c;
    private Paint d;
    private float[] e;

    public ClipImageView(Context context) {
        super(context);
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    protected void a(Context context) {
        this.b = new Path();
        this.c = new RectF();
    }

    public void setRadius(float[] fArr) {
        if (fArr != null && fArr.length == 8) {
            this.e = fArr;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setColor(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a) {
            this.b.reset();
            this.c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            float[] fArr = this.e;
            if (fArr != null) {
                this.b.addRoundRect(this.c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.b);
            Paint paint = this.d;
            if (paint != null) {
                canvas.drawPath(this.b, paint);
            }
        }
        super.onDraw(canvas);
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = (float) i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void setClip(boolean z) {
        this.a = z;
    }
}
