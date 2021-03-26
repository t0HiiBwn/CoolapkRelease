package it.sephiroth.android.library.xtooltip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.util.ObjectsCompat;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 72\u00020\u0001:\u00017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002JP\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0017J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0010H\u0014J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\nH\u0016J \u00103\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipTextDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "builder", "Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "(Landroid/content/Context;Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;)V", "arrowRatio", "", "arrowWeight", "", "bgPaint", "Landroid/graphics/Paint;", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "outlineRect", "Landroid/graphics/Rect;", "padding", "path", "Landroid/graphics/Path;", "point", "Landroid/graphics/PointF;", "radius", "rectF", "Landroid/graphics/RectF;", "stPaint", "tmpPoint", "calculatePath", "", "outBounds", "calculatePathWithGravity", "left", "top", "right", "bottom", "maxY", "maxX", "minY", "minX", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getOpacity", "getOutline", "outline", "Landroid/graphics/Outline;", "onBoundsChange", "bounds", "setAlpha", "alpha", "setAnchor", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "Companion", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: TooltipTextDrawable.kt */
public final class TooltipTextDrawable extends Drawable {
    public static final float ARROW_RATIO_DEFAULT = 1.4f;
    public static final Companion Companion = new Companion(null);
    private final float arrowRatio;
    private int arrowWeight;
    private final Paint bgPaint;
    private Tooltip.Gravity gravity;
    private final Rect outlineRect = new Rect();
    private int padding;
    private final Path path;
    private PointF point;
    private final float radius;
    private final RectF rectF;
    private final Paint stPaint;
    private final PointF tmpPoint = new PointF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TooltipTextDrawable(Context context, Tooltip.Builder builder) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.TooltipLayout, builder.getDefStyleAttr$xtooltip_release(), builder.getDefStyleRes$xtooltip_release());
        this.radius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TooltipLayout_ttlm_cornerRadius, 4);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TooltipLayout_ttlm_strokeWeight, 2);
        int color = obtainStyledAttributes.getColor(R.styleable.TooltipLayout_ttlm_backgroundColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TooltipLayout_ttlm_strokeColor, 0);
        this.arrowRatio = obtainStyledAttributes.getFloat(R.styleable.TooltipLayout_ttlm_arrowRatio, 1.4f);
        obtainStyledAttributes.recycle();
        this.rectF = new RectF();
        if (color != 0) {
            Paint paint = new Paint(1);
            this.bgPaint = paint;
            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);
        } else {
            this.bgPaint = null;
        }
        if (color2 != 0) {
            Paint paint2 = new Paint(1);
            this.stPaint = paint2;
            paint2.setColor(color2);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth((float) dimensionPixelSize);
        } else {
            this.stPaint = null;
        }
        this.path = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Paint paint = this.bgPaint;
        if (paint != null) {
            canvas.drawPath(this.path, paint);
        }
        Paint paint2 = this.stPaint;
        if (paint2 != null) {
            canvas.drawPath(this.path, paint2);
        }
    }

    public final void setAnchor(Tooltip.Gravity gravity2, int i, PointF pointF) {
        Intrinsics.checkParameterIsNotNull(gravity2, "gravity");
        Timber.i("setAnchor(" + gravity2 + ", " + i + ", " + pointF + ')', new Object[0]);
        if (gravity2 != this.gravity || i != this.padding || !ObjectsCompat.equals(this.point, pointF)) {
            this.gravity = gravity2;
            this.padding = i;
            this.arrowWeight = (int) (((float) i) / this.arrowRatio);
            if (pointF != null) {
                this.point = new PointF(pointF.x, pointF.y);
            } else {
                this.point = null;
            }
            Rect bounds = getBounds();
            Intrinsics.checkExpressionValueIsNotNull(bounds, "bounds");
            if (!bounds.isEmpty()) {
                Rect bounds2 = getBounds();
                Intrinsics.checkExpressionValueIsNotNull(bounds2, "bounds");
                calculatePath(bounds2);
                invalidateSelf();
            }
        }
    }

    private final void calculatePath(Rect rect) {
        Timber.i("calculatePath: " + rect + ", radius: " + this.radius, new Object[0]);
        int i = rect.left + this.padding;
        int i2 = rect.top + this.padding;
        int i3 = rect.right - this.padding;
        int i4 = rect.bottom - this.padding;
        float f = (float) i4;
        float f2 = this.radius;
        float f3 = f - f2;
        float f4 = (float) i3;
        float f5 = f4 - f2;
        float f6 = (float) i2;
        float f7 = f6 + f2;
        float f8 = (float) i;
        float f9 = f2 + f8;
        if (this.point == null || this.gravity == null) {
            this.rectF.set(f8, f6, f4, f);
            Path path2 = this.path;
            RectF rectF2 = this.rectF;
            float f10 = this.radius;
            path2.addRoundRect(rectF2, f10, f10, Path.Direction.CW);
            return;
        }
        calculatePathWithGravity(rect, i, i2, i3, i4, f3, f5, f7, f9);
    }

    private final void calculatePathWithGravity(Rect rect, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4) {
        if (this.gravity == Tooltip.Gravity.LEFT || this.gravity == Tooltip.Gravity.RIGHT) {
            float f5 = f - f3;
            if (f5 < ((float) (this.arrowWeight * 2))) {
                this.arrowWeight = (int) ((float) Math.floor((double) (f5 / ((float) 2))));
                Timber.w("adjusted arrowWeight to " + this.arrowWeight, new Object[0]);
            }
        } else if (this.gravity == Tooltip.Gravity.BOTTOM || this.gravity == Tooltip.Gravity.TOP) {
            float f6 = f2 - f4;
            if (f6 < ((float) (this.arrowWeight * 2))) {
                this.arrowWeight = (int) ((float) Math.floor((double) (f6 / ((float) 2))));
                Timber.w("adjusted arrowWeight to " + this.arrowWeight, new Object[0]);
            }
        }
        Companion companion = Companion;
        PointF pointF = this.tmpPoint;
        PointF pointF2 = this.point;
        if (pointF2 == null) {
            Intrinsics.throwNpe();
        }
        boolean isDrawPoint = companion.isDrawPoint(i, i2, i3, i4, f, f2, f3, f4, pointF, pointF2, this.gravity, this.arrowWeight);
        Timber.v("drawPoint: " + isDrawPoint + ", point: " + this.point + ", tmpPoint: " + this.tmpPoint, new Object[0]);
        companion.clampPoint(i, i2, i3, i4, this.tmpPoint);
        this.path.reset();
        float f7 = (float) i;
        float f8 = (float) i2;
        this.path.moveTo(this.radius + f7, f8);
        if (isDrawPoint && this.gravity == Tooltip.Gravity.BOTTOM) {
            this.path.lineTo((this.tmpPoint.x + f7) - ((float) this.arrowWeight), f8);
            this.path.lineTo(this.tmpPoint.x + f7, (float) rect.top);
            this.path.lineTo(this.tmpPoint.x + f7 + ((float) this.arrowWeight), f8);
        }
        float f9 = (float) i3;
        this.path.lineTo(f9 - this.radius, f8);
        this.path.quadTo(f9, f8, f9, this.radius + f8);
        if (isDrawPoint && this.gravity == Tooltip.Gravity.LEFT) {
            this.path.lineTo(f9, (this.tmpPoint.y + f8) - ((float) this.arrowWeight));
            this.path.lineTo((float) rect.right, this.tmpPoint.y + f8);
            this.path.lineTo(f9, this.tmpPoint.y + f8 + ((float) this.arrowWeight));
        }
        float f10 = (float) i4;
        this.path.lineTo(f9, f10 - this.radius);
        this.path.quadTo(f9, f10, f9 - this.radius, f10);
        if (isDrawPoint && this.gravity == Tooltip.Gravity.TOP) {
            this.path.lineTo(this.tmpPoint.x + f7 + ((float) this.arrowWeight), f10);
            this.path.lineTo(this.tmpPoint.x + f7, (float) rect.bottom);
            this.path.lineTo((this.tmpPoint.x + f7) - ((float) this.arrowWeight), f10);
        }
        this.path.lineTo(this.radius + f7, f10);
        this.path.quadTo(f7, f10, f7, f10 - this.radius);
        if (isDrawPoint && this.gravity == Tooltip.Gravity.RIGHT) {
            this.path.lineTo(f7, this.tmpPoint.y + f8 + ((float) this.arrowWeight));
            this.path.lineTo((float) rect.left, this.tmpPoint.y + f8);
            this.path.lineTo(f7, (this.tmpPoint.y + f8) - ((float) this.arrowWeight));
        }
        this.path.lineTo(f7, this.radius + f8);
        this.path.quadTo(f7, f8, this.radius + f7, f8);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "bounds");
        super.onBoundsChange(rect);
        calculatePath(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Paint paint = this.bgPaint;
        if (paint != null) {
            return paint.getAlpha();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.bgPaint;
        if (paint != null) {
            paint.setAlpha(i);
        }
        Paint paint2 = this.stPaint;
        if (paint2 != null) {
            paint2.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkParameterIsNotNull(outline, "outline");
        copyBounds(this.outlineRect);
        Rect rect = this.outlineRect;
        int i = this.padding;
        rect.inset(i, i);
        outline.setRoundRect(this.outlineRect, this.radius);
        if (getAlpha() < 255) {
            outline.setAlpha(0.0f);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002Jj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipTextDrawable$Companion;", "", "()V", "ARROW_RATIO_DEFAULT", "", "clampPoint", "", "left", "", "top", "right", "bottom", "tmpPoint", "Landroid/graphics/PointF;", "isDrawPoint", "", "maxY", "maxX", "minY", "minX", "point", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "arrowWeight", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: TooltipTextDrawable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isDrawPoint(int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, PointF pointF, PointF pointF2, Tooltip.Gravity gravity, int i5) {
            Timber.i("isDrawPoint: Rect(" + i + ", " + i2 + ", " + i3 + ", " + i4 + "), x: [" + f4 + ", " + f2 + "], y: [" + f3 + ", " + f + "], point: " + pointF2 + ", " + i5, new Object[0]);
            pointF.set(pointF2.x, pointF2.y);
            boolean z = true;
            if (gravity == Tooltip.Gravity.RIGHT || gravity == Tooltip.Gravity.LEFT) {
                if (RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(i2, i4), pointF.y)) {
                    float f5 = (float) i2;
                    float f6 = (float) i5;
                    if (pointF.y + f5 + f6 > f) {
                        pointF.y = (f - f6) - f5;
                    } else if ((pointF.y + f5) - f6 < f3) {
                        pointF.y = (f3 + f6) - f5;
                    }
                    Timber.v("tmpPoint: " + pointF, new Object[0]);
                    return z;
                }
            } else if (RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(i, i3), pointF.x) && RangesKt.intRangeContains((ClosedRange<Integer>) new IntRange(i, i3), pointF.x)) {
                float f7 = (float) i;
                float f8 = (float) i5;
                if (pointF.x + f7 + f8 > f2) {
                    pointF.x = (f2 - f8) - f7;
                } else if ((pointF.x + f7) - f8 < f4) {
                    pointF.x = (f4 + f8) - f7;
                }
                Timber.v("tmpPoint: " + pointF, new Object[0]);
                return z;
            }
            z = false;
            Timber.v("tmpPoint: " + pointF, new Object[0]);
            return z;
        }

        /* access modifiers changed from: private */
        public final void clampPoint(int i, int i2, int i3, int i4, PointF pointF) {
            float f = (float) i2;
            if (pointF.y < f) {
                pointF.y = f;
            } else {
                float f2 = (float) i4;
                if (pointF.y > f2) {
                    pointF.y = f2;
                }
            }
            float f3 = (float) i;
            if (pointF.x < f3) {
                pointF.x = f3;
            }
            float f4 = (float) i3;
            if (pointF.x > f4) {
                pointF.x = f4;
            }
        }
    }
}
