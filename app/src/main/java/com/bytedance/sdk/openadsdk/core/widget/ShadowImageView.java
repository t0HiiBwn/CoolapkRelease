package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ShadowImageView extends ImageView {
    private Paint a;
    private RectF b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(Color.parseColor("#99333333"));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.right != ((float) getMeasuredWidth()) || this.b.bottom != ((float) getMeasuredHeight())) {
            this.b.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.b.bottom / 2.0f, this.a);
        super.onDraw(canvas);
    }
}
