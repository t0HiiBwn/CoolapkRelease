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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.coolapk.market.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 82\u00020\u0001:\u000278B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010!\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0014J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0014J0\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0014J\u0012\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u00100\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0014J\b\u00106\u001a\u00020\"H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/coolapk/market/widget/view/ShapedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DST_IN", "Landroid/graphics/PorterDuffXfermode;", "DST_OUT", "alignType", "Lcom/coolapk/market/widget/view/ShapedImageView$AlignType;", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPathPaint", "mRadius_bottomLeft", "", "mRadius_bottomRight", "mRadius_topLeft", "mRadius_topRight", "mShape", "Landroid/graphics/drawable/shapes/Shape;", "mShapeBitmap", "Landroid/graphics/Bitmap;", "mShapeChanged", "", "mShapeMode", "init", "", "makeShapeBitmap", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "releaseBitmap", "bitmap", "setAlignType", "setFrame", "l", "t", "r", "b", "transformMatrix", "AlignType", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShapedImageView.kt */
public final class ShapedImageView extends AppCompatImageView {
    public static final Companion Companion = new Companion(null);
    private static final int SHAPE_MODE_CIRCLE = 2;
    private static final int SHAPE_MODE_ROUND_RECT = 1;
    private final PorterDuffXfermode DST_IN = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private final PorterDuffXfermode DST_OUT = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    private AlignType alignType;
    private Paint mPaint;
    private Path mPath;
    private Paint mPathPaint;
    private float mRadius_bottomLeft;
    private float mRadius_bottomRight;
    private float mRadius_topLeft;
    private float mRadius_topRight;
    private Shape mShape;
    private Bitmap mShapeBitmap;
    private boolean mShapeChanged;
    private int mShapeMode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/view/ShapedImageView$Companion;", "", "()V", "SHAPE_MODE_CIRCLE", "", "SHAPE_MODE_ROUND_RECT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShapedImageView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShapedImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShapedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShapedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        init(attributeSet);
    }

    private final void init(AttributeSet attributeSet) {
        setLayerType(2, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShapedImageView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.ShapedImageView)");
            this.mShapeMode = obtainStyledAttributes.getInt(5, 0);
            this.mRadius_topLeft = obtainStyledAttributes.getDimension(3, 0.0f);
            this.mRadius_topRight = obtainStyledAttributes.getDimension(4, 0.0f);
            this.mRadius_bottomLeft = obtainStyledAttributes.getDimension(1, 0.0f);
            this.mRadius_bottomRight = obtainStyledAttributes.getDimension(2, 0.0f);
            try {
                this.alignType = AlignType.values()[obtainStyledAttributes.getInt(0, AlignType.TOP.getNativeInt$presentation_coolapkAppRelease())];
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        Paint paint = new Paint(1);
        this.mPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setFilterBitmap(true);
        Paint paint3 = this.mPaint;
        Intrinsics.checkNotNull(paint3);
        paint3.setColor(-16777216);
        Paint paint4 = this.mPaint;
        Intrinsics.checkNotNull(paint4);
        paint4.setXfermode(this.DST_IN);
        Paint paint5 = new Paint(1);
        this.mPathPaint = paint5;
        Intrinsics.checkNotNull(paint5);
        paint5.setFilterBitmap(true);
        Paint paint6 = this.mPathPaint;
        Intrinsics.checkNotNull(paint6);
        paint6.setColor(-16777216);
        Paint paint7 = this.mPathPaint;
        Intrinsics.checkNotNull(paint7);
        paint7.setXfermode(this.DST_OUT);
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || this.mShapeChanged) {
            this.mShapeChanged = false;
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int i5 = this.mShapeMode;
            if (i5 != SHAPE_MODE_ROUND_RECT && i5 == SHAPE_MODE_CIRCLE) {
                float min = ((float) Math.min(measuredWidth, measuredHeight)) / ((float) 2);
                this.mRadius_bottomLeft = min;
                this.mRadius_bottomRight = min;
                this.mRadius_topLeft = min;
                this.mRadius_topRight = min;
            }
            if (this.mShape == null) {
                float[] fArr = new float[8];
                for (int i6 = 0; i6 < 8; i6++) {
                    switch (i6) {
                        case 0:
                        case 1:
                            fArr[i6] = this.mRadius_topLeft;
                            break;
                        case 2:
                        case 3:
                            fArr[i6] = this.mRadius_topRight;
                            break;
                        case 4:
                        case 5:
                            fArr[i6] = this.mRadius_bottomRight;
                            break;
                        case 6:
                        case 7:
                            fArr[i6] = this.mRadius_bottomLeft;
                            break;
                    }
                }
                this.mShape = new RoundRectShape(fArr, null, null);
            }
            Shape shape = this.mShape;
            Intrinsics.checkNotNull(shape);
            shape.resize((float) measuredWidth, (float) measuredHeight);
            makeShapeBitmap();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r0.isRecycled() != false) goto L_0x0024;
     */
    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i = this.mShapeMode;
        if ((i == SHAPE_MODE_ROUND_RECT || i == SHAPE_MODE_CIRCLE) && this.mShape != null) {
            Bitmap bitmap = this.mShapeBitmap;
            if (bitmap != null) {
                Intrinsics.checkNotNull(bitmap);
            }
            makeShapeBitmap();
            Bitmap bitmap2 = this.mShapeBitmap;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.mPaint);
            }
        }
    }

    public final void setAlignType(AlignType alignType2) {
        Intrinsics.checkNotNullParameter(alignType2, "alignType");
        this.alignType = alignType2;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (getScaleType() == ImageView.ScaleType.MATRIX && getDrawable() != null) {
            transformMatrix();
        }
        return frame;
    }

    private final void transformMatrix() {
        Matrix imageMatrix = getImageMatrix();
        imageMatrix.reset();
        float height = (float) getHeight();
        float width = (float) getWidth();
        Drawable drawable = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        float intrinsicHeight = (float) drawable.getIntrinsicHeight();
        Drawable drawable2 = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
        float intrinsicWidth = (float) drawable2.getIntrinsicWidth();
        float f = width / intrinsicWidth;
        float f2 = height / intrinsicHeight;
        if (this.alignType == AlignType.LEFT) {
            imageMatrix.postScale(f2, f2, 0.0f, 0.0f);
        } else if (this.alignType == AlignType.RIGHT) {
            imageMatrix.postTranslate(width - intrinsicWidth, 0.0f);
            imageMatrix.postScale(f2, f2, width, 0.0f);
        } else if (this.alignType == AlignType.BOTTOM) {
            imageMatrix.postTranslate(0.0f, height - intrinsicHeight);
            imageMatrix.postScale(f, f, 0.0f, height);
        } else if (this.alignType == AlignType.CENTER) {
            float f3 = (float) 2;
            imageMatrix.postTranslate((width - intrinsicWidth) / f3, 0.0f);
            imageMatrix.postScale(f2, f2, width / f3, 0.0f);
        } else {
            imageMatrix.postScale(f, f, 0.0f, 0.0f);
        }
        setImageMatrix(imageMatrix);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseBitmap(this.mShapeBitmap);
    }

    private final void releaseBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    private final void makeShapeBitmap() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            releaseBitmap(this.mShapeBitmap);
            this.mShapeBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            Bitmap bitmap = this.mShapeBitmap;
            Intrinsics.checkNotNull(bitmap);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            Shape shape = this.mShape;
            Intrinsics.checkNotNull(shape);
            shape.draw(canvas, paint);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/view/ShapedImageView$AlignType;", "", "nativeInt", "", "(Ljava/lang/String;II)V", "getNativeInt$presentation_coolapkAppRelease", "()I", "LEFT", "TOP", "RIGHT", "BOTTOM", "CENTER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShapedImageView.kt */
    public enum AlignType {
        LEFT(0),
        TOP(1),
        RIGHT(2),
        BOTTOM(3),
        CENTER(4);
        
        private final int nativeInt;

        private AlignType(int i) {
            this.nativeInt = i;
        }

        public final int getNativeInt$presentation_coolapkAppRelease() {
            return this.nativeInt;
        }
    }
}
