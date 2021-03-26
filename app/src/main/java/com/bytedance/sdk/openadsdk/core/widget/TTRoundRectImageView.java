package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TTRoundRectImageView extends ImageView {
    private Paint a;
    private int b;
    private int c;
    private Matrix d;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 25;
        this.c = 25;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setFilterBitmap(true);
        this.d = new Matrix();
    }

    public void setXRound(int i) {
        this.b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.c = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                BitmapShader bitmapShader = new BitmapShader(a2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                float f = 1.0f;
                if (!(a2.getWidth() == getWidth() && a2.getHeight() == getHeight())) {
                    f = Math.max((((float) getWidth()) * 1.0f) / ((float) a2.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a2.getHeight()));
                }
                this.d.setScale(f, f);
                bitmapShader.setLocalMatrix(this.d);
                this.a.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.b, (float) this.c, this.a);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }
}
