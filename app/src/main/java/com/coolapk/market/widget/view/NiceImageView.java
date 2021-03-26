package com.coolapk.market.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.R;
import com.coolapk.market.util.DisplayUtils;

public class NiceImageView extends AppCompatImageView {
    private int borderColor;
    private float[] borderRadii;
    private RectF borderRectF;
    private int borderWidth;
    private Context context;
    private int cornerBottomLeftRadius;
    private int cornerBottomRightRadius;
    private int cornerRadius;
    private int cornerTopLeftRadius;
    private int cornerTopRightRadius;
    private int height;
    private int innerBorderColor;
    private int innerBorderWidth;
    private boolean isCircle;
    private boolean isCoverSrc;
    private int maskColor;
    private Paint paint;
    private Path path;
    private float radius;
    private float[] srcRadii;
    private RectF srcRectF;
    private int width;
    private Xfermode xfermode;

    public NiceImageView(Context context2) {
        this(context2, null);
    }

    public NiceImageView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public NiceImageView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.borderColor = -1;
        this.innerBorderColor = -1;
        this.path = new Path();
        this.paint = new Paint();
        this.context = context2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.NiceImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 10) {
                this.isCoverSrc = obtainStyledAttributes.getBoolean(index, this.isCoverSrc);
            } else if (index == 9) {
                this.isCircle = obtainStyledAttributes.getBoolean(index, this.isCircle);
            } else if (index == 1) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == 0) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == 8) {
                this.innerBorderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.innerBorderWidth);
            } else if (index == 7) {
                this.innerBorderColor = obtainStyledAttributes.getColor(index, this.innerBorderColor);
            } else if (index == 4) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == 5) {
                this.cornerTopLeftRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopLeftRadius);
            } else if (index == 6) {
                this.cornerTopRightRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopRightRadius);
            } else if (index == 2) {
                this.cornerBottomLeftRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomLeftRadius);
            } else if (index == 3) {
                this.cornerBottomRightRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomRightRadius);
            } else if (index == 11) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        obtainStyledAttributes.recycle();
        this.borderRadii = new float[8];
        this.srcRadii = new float[8];
        this.borderRectF = new RectF();
        this.srcRectF = new RectF();
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        calculateRadii();
        clearInnerBorderWidth();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        initBorderRectF();
        initSrcRectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        this.paint.reset();
        this.path.reset();
        if (!this.isCoverSrc) {
            int i = this.width;
            int i2 = this.borderWidth;
            int i3 = this.innerBorderWidth;
            int i4 = this.height;
            canvas.scale((((float) ((i - (i2 * 2)) - (i3 * 2))) * 1.0f) / ((float) i), (((float) ((i4 - (i2 * 2)) - (i3 * 2))) * 1.0f) / ((float) i4), ((float) i) / 2.0f, ((float) i4) / 2.0f);
        }
        if (this.isCircle) {
            this.path.addCircle(((float) this.width) / 2.0f, ((float) this.height) / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.srcRectF, this.srcRadii, Path.Direction.CCW);
        }
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.path, this.paint);
        this.paint.setXfermode(this.xfermode);
        canvas.drawBitmap(zoomDrawable(drawable), 0.0f, 0.0f, this.paint);
        this.paint.setXfermode(null);
        int i5 = this.maskColor;
        if (i5 != 0) {
            this.paint.setColor(i5);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        drawBorders(canvas);
    }

    private void drawBorders(Canvas canvas) {
        if (this.isCircle) {
            int i = this.borderWidth;
            if (i > 0) {
                drawCircleBorder(canvas, i, this.borderColor, this.radius - (((float) i) / 2.0f));
            }
            int i2 = this.innerBorderWidth;
            if (i2 > 0) {
                drawCircleBorder(canvas, i2, this.innerBorderColor, (this.radius - ((float) this.borderWidth)) - (((float) i2) / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.borderWidth;
        if (i3 > 0) {
            drawRectFBorder(canvas, i3, this.borderColor, this.borderRectF, this.borderRadii);
        }
    }

    private void drawCircleBorder(Canvas canvas, int i, int i2, float f) {
        initBorderPaint(i, i2);
        this.path.addCircle(((float) this.width) / 2.0f, ((float) this.height) / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void drawRectFBorder(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        initBorderPaint(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void initBorderPaint(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth((float) i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void initBorderRectF() {
        if (!this.isCircle) {
            RectF rectF = this.borderRectF;
            int i = this.borderWidth;
            rectF.set(((float) i) / 2.0f, ((float) i) / 2.0f, ((float) this.width) - (((float) i) / 2.0f), ((float) this.height) - (((float) i) / 2.0f));
        }
    }

    private void initSrcRectF() {
        if (this.isCircle) {
            float min = ((float) Math.min(this.width, this.height)) / 2.0f;
            this.radius = min;
            RectF rectF = this.srcRectF;
            int i = this.width;
            int i2 = this.height;
            rectF.set((((float) i) / 2.0f) - min, (((float) i2) / 2.0f) - min, (((float) i) / 2.0f) + min, (((float) i2) / 2.0f) + min);
            return;
        }
        this.srcRectF.set(0.0f, 0.0f, (float) this.width, (float) this.height);
        if (this.isCoverSrc) {
            this.srcRectF = this.borderRectF;
        }
    }

    private void calculateRadii() {
        if (!this.isCircle) {
            int i = 0;
            if (this.cornerRadius > 0) {
                while (true) {
                    float[] fArr = this.borderRadii;
                    if (i < fArr.length) {
                        int i2 = this.cornerRadius;
                        fArr[i] = (float) i2;
                        this.srcRadii[i] = ((float) i2) - (((float) this.borderWidth) / 2.0f);
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                float[] fArr2 = this.borderRadii;
                int i3 = this.cornerTopLeftRadius;
                float f = (float) i3;
                fArr2[1] = f;
                fArr2[0] = f;
                int i4 = this.cornerTopRightRadius;
                float f2 = (float) i4;
                fArr2[3] = f2;
                fArr2[2] = f2;
                int i5 = this.cornerBottomRightRadius;
                float f3 = (float) i5;
                fArr2[5] = f3;
                fArr2[4] = f3;
                int i6 = this.cornerBottomLeftRadius;
                float f4 = (float) i6;
                fArr2[7] = f4;
                fArr2[6] = f4;
                float[] fArr3 = this.srcRadii;
                int i7 = this.borderWidth;
                float f5 = ((float) i3) - (((float) i7) / 2.0f);
                fArr3[1] = f5;
                fArr3[0] = f5;
                float f6 = ((float) i4) - (((float) i7) / 2.0f);
                fArr3[3] = f6;
                fArr3[2] = f6;
                float f7 = ((float) i5) - (((float) i7) / 2.0f);
                fArr3[5] = f7;
                fArr3[4] = f7;
                float f8 = ((float) i6) - (((float) i7) / 2.0f);
                fArr3[7] = f8;
                fArr3[6] = f8;
            }
        }
    }

    private void calculateRadiiAndRectF(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        calculateRadii();
        initBorderRectF();
        invalidate();
    }

    private void clearInnerBorderWidth() {
        if (!this.isCircle) {
            this.innerBorderWidth = 0;
        }
    }

    public void isCoverSrc(boolean z) {
        this.isCoverSrc = z;
        initSrcRectF();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.isCircle = z;
        clearInnerBorderWidth();
        initSrcRectF();
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(false);
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.innerBorderWidth = DisplayUtils.dp2px(this.context, (float) i);
        clearInnerBorderWidth();
        invalidate();
    }

    public void setInnerBorderColor(int i) {
        this.innerBorderColor = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.cornerTopLeftRadius = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.cornerTopRightRadius = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.cornerBottomLeftRadius = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.cornerBottomRightRadius = DisplayUtils.dp2px(this.context, (float) i);
        calculateRadiiAndRectF(true);
    }

    public void setMaskColor(int i) {
        this.maskColor = i;
        invalidate();
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width2 = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height2 = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width2, height2);
        drawable.draw(canvas);
        return createBitmap;
    }

    private Bitmap zoomDrawable(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap drawableToBitamp = drawableToBitamp(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) getWidth()) / ((float) intrinsicWidth), ((float) getHeight()) / ((float) intrinsicHeight));
        return Bitmap.createBitmap(drawableToBitamp, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true);
    }
}
