package it.sephiroth.android.library.xtooltip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0001@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0018\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020,H\u0002R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058B@BX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058B@BX\u000e¢\u0006\f\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR$\u0010'\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8B@BX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0011¨\u0006A"}, d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipOverlayDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "defStyleResId", "", "(Landroid/content/Context;I)V", "value", "innerAlpha", "getInnerAlpha", "()I", "setInnerAlpha", "(I)V", "rippleRadius", "", "innerRadius", "setInnerRadius", "(F)V", "mDuration", "", "mFirstAnimator", "Landroid/animation/ValueAnimator;", "mFirstAnimatorSet", "Landroid/animation/AnimatorSet;", "mInnerAlpha", "mInnerPaint", "Landroid/graphics/Paint;", "mOuterAlpha", "mOuterPaint", "mOuterRadius", "mRepeatCount", "mRepeatIndex", "mSecondAnimator", "mSecondAnimatorSet", "mStarted", "", "outerAlpha", "getOuterAlpha", "setOuterAlpha", "outerRadius", "getOuterRadius", "()F", "setOuterRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "play", "replay", "setAlpha", "i", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setVisible", "visible", "restart", "stop", "Companion", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: TooltipOverlayDrawable.kt */
public final class TooltipOverlayDrawable extends Drawable {
    public static final float ALPHA_MAX = 255.0f;
    public static final Companion Companion = new Companion(null);
    public static final double FADEIN_DURATION = 0.3d;
    public static final double FADEOUT_START_DELAY = 0.55d;
    public static final double SECOND_ANIM_START_DELAY = 0.25d;
    private float innerRadius;
    private long mDuration = 400;
    private final ValueAnimator mFirstAnimator;
    private final AnimatorSet mFirstAnimatorSet;
    private final int mInnerAlpha;
    private final Paint mInnerPaint;
    private final int mOuterAlpha;
    private final Paint mOuterPaint;
    private float mOuterRadius;
    private int mRepeatCount = 1;
    private int mRepeatIndex;
    private final ValueAnimator mSecondAnimator;
    private final AnimatorSet mSecondAnimatorSet;
    private boolean mStarted;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 96;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 96;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TooltipOverlayDrawable(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Paint paint = new Paint(1);
        this.mOuterPaint = paint;
        Paint paint2 = new Paint(1);
        this.mInnerPaint = paint2;
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, R.styleable.TooltipOverlay);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "array");
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.TooltipOverlay_android_color) {
                int color = obtainStyledAttributes.getColor(index, 0);
                this.mOuterPaint.setColor(color);
                this.mInnerPaint.setColor(color);
            } else if (index == R.styleable.TooltipOverlay_ttlm_repeatCount) {
                this.mRepeatCount = obtainStyledAttributes.getInt(index, 1);
            } else if (index == R.styleable.TooltipOverlay_android_alpha) {
                int i3 = (int) (obtainStyledAttributes.getFloat(index, ((float) this.mInnerPaint.getAlpha()) / 255.0f) * ((float) 255));
                this.mInnerPaint.setAlpha(i3);
                this.mOuterPaint.setAlpha(i3);
            } else if (index == R.styleable.TooltipOverlay_ttlm_duration) {
                this.mDuration = (long) obtainStyledAttributes.getInt(index, 400);
            }
        }
        obtainStyledAttributes.recycle();
        int outerAlpha = getOuterAlpha();
        this.mOuterAlpha = outerAlpha;
        int innerAlpha = getInnerAlpha();
        this.mInnerAlpha = innerAlpha;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "outerAlpha", 0, outerAlpha);
        Intrinsics.checkExpressionValueIsNotNull(ofInt, "ObjectAnimator.ofInt(thi…erAlpha\", 0, mOuterAlpha)");
        ObjectAnimator objectAnimator = ofInt;
        objectAnimator.setDuration((long) (((double) this.mDuration) * 0.3d));
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "outerAlpha", outerAlpha, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(ofInt2, "ObjectAnimator.ofInt(thi…lpha\", mOuterAlpha, 0, 0)");
        ObjectAnimator objectAnimator2 = ofInt2;
        objectAnimator2.setStartDelay((long) (((double) this.mDuration) * 0.55d));
        objectAnimator2.setDuration((long) (((double) this.mDuration) * 0.44999999999999996d));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "outerRadius", 0.0f, 1.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(t…s, \"outerRadius\", 0f, 1f)");
        ObjectAnimator objectAnimator3 = ofFloat;
        this.mFirstAnimator = objectAnimator3;
        objectAnimator3.setDuration(this.mDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mFirstAnimatorSet = animatorSet;
        animatorSet.playTogether(objectAnimator, objectAnimator3, objectAnimator2);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(this.mDuration);
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this, "innerAlpha", 0, innerAlpha);
        Intrinsics.checkExpressionValueIsNotNull(ofInt3, "ObjectAnimator.ofInt(thi…erAlpha\", 0, mInnerAlpha)");
        ObjectAnimator objectAnimator4 = ofInt3;
        objectAnimator4.setDuration((long) (((double) this.mDuration) * 0.3d));
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this, "innerAlpha", innerAlpha, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(ofInt4, "ObjectAnimator.ofInt(thi…lpha\", mInnerAlpha, 0, 0)");
        ObjectAnimator objectAnimator5 = ofInt4;
        objectAnimator5.setStartDelay((long) (((double) this.mDuration) * 0.55d));
        objectAnimator5.setDuration((long) (((double) this.mDuration) * 0.44999999999999996d));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "innerRadius", 0.0f, 1.0f);
        Intrinsics.checkExpressionValueIsNotNull(ofFloat2, "ObjectAnimator.ofFloat(t…s, \"innerRadius\", 0f, 1f)");
        ObjectAnimator objectAnimator6 = ofFloat2;
        this.mSecondAnimator = objectAnimator6;
        objectAnimator6.setDuration(this.mDuration);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mSecondAnimatorSet = animatorSet2;
        animatorSet2.playTogether(objectAnimator4, objectAnimator6, objectAnimator5);
        animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet2.setStartDelay((long) (((double) this.mDuration) * 0.25d));
        animatorSet2.setDuration(this.mDuration);
        animatorSet.addListener(new AnimatorListenerAdapter(this) {
            /* class it.sephiroth.android.library.xtooltip.TooltipOverlayDrawable.AnonymousClass1 */
            private boolean cancelled;
            final /* synthetic */ TooltipOverlayDrawable this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animation");
                super.onAnimationCancel(animator);
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animation");
                if (!this.cancelled && this.this$0.isVisible()) {
                    TooltipOverlayDrawable tooltipOverlayDrawable = this.this$0;
                    tooltipOverlayDrawable.mRepeatIndex++;
                    if (tooltipOverlayDrawable.mRepeatIndex < this.this$0.mRepeatCount) {
                        this.this$0.mFirstAnimatorSet.start();
                    }
                }
            }
        });
        animatorSet2.addListener(new AnimatorListenerAdapter(this) {
            /* class it.sephiroth.android.library.xtooltip.TooltipOverlayDrawable.AnonymousClass2 */
            private boolean cancelled;
            final /* synthetic */ TooltipOverlayDrawable this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animation");
                super.onAnimationCancel(animator);
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animation");
                if (!this.cancelled && this.this$0.isVisible() && this.this$0.mRepeatIndex < this.this$0.mRepeatCount) {
                    this.this$0.mSecondAnimatorSet.setStartDelay(0);
                    this.this$0.mSecondAnimatorSet.start();
                }
            }
        });
    }

    private final void setInnerRadius(float f) {
        this.innerRadius = f;
        invalidateSelf();
    }

    private final int getOuterAlpha() {
        return this.mOuterPaint.getAlpha();
    }

    private final void setOuterAlpha(int i) {
        this.mOuterPaint.setAlpha(i);
        invalidateSelf();
    }

    private final int getInnerAlpha() {
        return this.mInnerPaint.getAlpha();
    }

    private final void setInnerAlpha(int i) {
        this.mInnerPaint.setAlpha(i);
        invalidateSelf();
    }

    private final float getOuterRadius() {
        return this.mOuterRadius;
    }

    private final void setOuterRadius(float f) {
        this.mOuterRadius = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Rect bounds = getBounds();
        float width = (float) (bounds.width() / 2);
        float height = (float) (bounds.height() / 2);
        canvas.drawCircle(width, height, this.mOuterRadius, this.mOuterPaint);
        canvas.drawCircle(width, height, this.innerRadius, this.mInnerPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = isVisible() != z;
        if (!z) {
            stop();
        } else if (z2 || !this.mStarted) {
            replay();
        }
        return z3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Intrinsics.checkParameterIsNotNull(rect, "bounds");
        Timber.i("onBoundsChange: " + rect, new Object[0]);
        super.onBoundsChange(rect);
        float min = (float) (Math.min(rect.width(), rect.height()) / 2);
        this.mOuterRadius = min;
        this.mFirstAnimator.setFloatValues(0.0f, min);
        this.mSecondAnimator.setFloatValues(0.0f, this.mOuterRadius);
    }

    private final void play() {
        this.mRepeatIndex = 0;
        this.mStarted = true;
        this.mFirstAnimatorSet.start();
        this.mSecondAnimatorSet.setStartDelay((long) (((double) this.mDuration) * 0.25d));
        this.mSecondAnimatorSet.start();
    }

    private final void replay() {
        stop();
        play();
    }

    private final void stop() {
        this.mFirstAnimatorSet.cancel();
        this.mSecondAnimatorSet.cancel();
        this.mRepeatIndex = 0;
        this.mStarted = false;
        setInnerRadius(0.0f);
        setOuterRadius(0.0f);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipOverlayDrawable$Companion;", "", "()V", "ALPHA_MAX", "", "FADEIN_DURATION", "", "FADEOUT_START_DELAY", "SECOND_ANIM_START_DELAY", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: TooltipOverlayDrawable.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
