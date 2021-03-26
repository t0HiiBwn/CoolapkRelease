package com.coolapk.market.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.widget.view.TabLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0016J0\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0014J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u000eH\u0016J\u0018\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0002J\u0016\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\bJ\u000e\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u000eJ\u000e\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020\u000eJ\u000e\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u000eJ\b\u0010=\u001a\u00020#H\u0002R\u0014\u0010\u0007\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006?"}, d2 = {"Lcom/coolapk/market/widget/FakeTabIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "tabs", "Lcom/coolapk/market/widget/view/TabLayout;", "(Landroid/content/Context;Lcom/coolapk/market/widget/view/TabLayout;)V", "indicatorPosition", "", "getIndicatorPosition$presentation_coolapkAppRelease", "()F", "mIndicatorAnimator", "Landroid/animation/ValueAnimator;", "mIndicatorLeft", "", "mIndicatorRight", "mIndicatorWidth", "mLayoutDirection", "mSelectedIndicatorHeight", "mSelectedIndicatorPaint", "Landroid/graphics/Paint;", "mSelectedPosition", "getMSelectedPosition$presentation_coolapkAppRelease", "()I", "setMSelectedPosition$presentation_coolapkAppRelease", "(I)V", "mSelectionOffset", "getMSelectionOffset$presentation_coolapkAppRelease", "setMSelectionOffset$presentation_coolapkAppRelease", "(F)V", "mTabStrip", "Landroid/view/ViewGroup;", "getTabs", "()Lcom/coolapk/market/widget/view/TabLayout;", "animateIndicatorToPosition", "", "position", "duration", "draw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "l", "t", "r", "b", "onRtlPropertiesChanged", "layoutDirection", "setIndicatorPosition", "left", "right", "setIndicatorPositionFromTabPosition", "positionOffset", "setIndicatorWidth", "width", "setSelectedIndicatorColor", "color", "setSelectedIndicatorHeight", "height", "updateIndicatorPosition", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FakeTabIndicator.kt */
public final class FakeTabIndicator extends LinearLayout {
    public static final Companion Companion = new Companion(null);
    private static final FastOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private ValueAnimator mIndicatorAnimator;
    private int mIndicatorLeft = -1;
    private int mIndicatorRight = -1;
    private int mIndicatorWidth = -1;
    private int mLayoutDirection = -1;
    private int mSelectedIndicatorHeight;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition = -1;
    private float mSelectionOffset;
    private final ViewGroup mTabStrip;
    private final TabLayout tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FakeTabIndicator(Context context, TabLayout tabLayout) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tabLayout, "tabs");
        this.tabs = tabLayout;
        View childAt = tabLayout.getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mTabStrip = (ViewGroup) childAt;
        setWillNotDraw(false);
        this.mSelectedIndicatorPaint = new Paint();
    }

    public final TabLayout getTabs() {
        return this.tabs;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/FakeTabIndicator$Companion;", "", "()V", "FAST_OUT_SLOW_IN_INTERPOLATOR", "Landroidx/interpolator/view/animation/FastOutSlowInInterpolator;", "MOTION_NON_ADJACENT_OFFSET", "", "lerp", "startValue", "endValue", "fraction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FakeTabIndicator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int lerp(int i, int i2, float f) {
            return i + Math.round(f * ((float) (i2 - i)));
        }
    }

    public final int getMSelectedPosition$presentation_coolapkAppRelease() {
        return this.mSelectedPosition;
    }

    public final void setMSelectedPosition$presentation_coolapkAppRelease(int i) {
        this.mSelectedPosition = i;
    }

    public final float getMSelectionOffset$presentation_coolapkAppRelease() {
        return this.mSelectionOffset;
    }

    public final void setMSelectionOffset$presentation_coolapkAppRelease(float f) {
        this.mSelectionOffset = f;
    }

    public final float getIndicatorPosition$presentation_coolapkAppRelease() {
        return ((float) this.mSelectedPosition) + this.mSelectionOffset;
    }

    public final void setIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
    }

    public final void setSelectedIndicatorColor(int i) {
        if (this.mSelectedIndicatorPaint.getColor() != i) {
            this.mSelectedIndicatorPaint.setColor(i);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void setSelectedIndicatorHeight(int i) {
        if (this.mSelectedIndicatorHeight != i) {
            this.mSelectedIndicatorHeight = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void setIndicatorPositionFromTabPosition(int i, float f) {
        ValueAnimator valueAnimator = this.mIndicatorAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mIndicatorAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
        this.mSelectedPosition = i;
        this.mSelectionOffset = f;
        updateIndicatorPosition();
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.mIndicatorAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mIndicatorAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
                ValueAnimator valueAnimator3 = this.mIndicatorAnimator;
                Intrinsics.checkNotNull(valueAnimator3);
                long duration = valueAnimator3.getDuration();
                int i5 = this.mSelectedPosition;
                ValueAnimator valueAnimator4 = this.mIndicatorAnimator;
                Intrinsics.checkNotNull(valueAnimator4);
                animateIndicatorToPosition(i5, Math.round((1.0f - valueAnimator4.getAnimatedFraction()) * ((float) duration)));
                return;
            }
        }
        updateIndicatorPosition();
    }

    private final void updateIndicatorPosition() {
        int i;
        int i2;
        View childAt = this.mTabStrip.getChildAt(this.mSelectedPosition);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i = childAt.getLeft();
            i2 = childAt.getRight();
            if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                View childAt2 = this.mTabStrip.getChildAt(this.mSelectedPosition + 1);
                float f = this.mSelectionOffset;
                Intrinsics.checkNotNullExpressionValue(childAt2, "nextTitle");
                float left = f * ((float) childAt2.getLeft());
                float f2 = this.mSelectionOffset;
                i = (int) (left + ((1.0f - f2) * ((float) i)));
                i2 = (int) ((f2 * ((float) childAt2.getRight())) + ((1.0f - this.mSelectionOffset) * ((float) i2)));
            }
        }
        setIndicatorPosition(i, i2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (Build.VERSION.SDK_INT < 23 && this.mLayoutDirection != i) {
            requestLayout();
            this.mLayoutDirection = i;
        }
    }

    /* access modifiers changed from: private */
    public final void setIndicatorPosition(int i, int i2) {
        int i3 = this.mIndicatorWidth;
        if (i3 >= 0) {
            int i4 = (i + i2) / 2;
            i2 = i4 + (i3 / 2);
            i = i4 - (i3 / 2);
        }
        if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
            this.mIndicatorLeft = i;
            this.mIndicatorRight = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void animateIndicatorToPosition(int i, int i2) {
        int i3;
        int i4;
        ValueAnimator valueAnimator = this.mIndicatorAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mIndicatorAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        View childAt = this.mTabStrip.getChildAt(i);
        if (childAt == null) {
            updateIndicatorPosition();
            return;
        }
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.mSelectedPosition) <= 1) {
            i4 = this.mIndicatorLeft;
            i3 = this.mIndicatorRight;
        } else {
            int dp2px = DisplayUtils.dp2px(null, (float) MOTION_NON_ADJACENT_OFFSET);
            i4 = (i >= this.mSelectedPosition ? !z : z) ? left - dp2px : dp2px + right;
            i3 = i4;
        }
        if (i4 != left || i3 != right) {
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.mIndicatorAnimator = valueAnimator3;
            valueAnimator3.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator3.setDuration((long) i2);
            valueAnimator3.setFloatValues(0.0f, 1.0f);
            valueAnimator3.addUpdateListener(new FakeTabIndicator$animateIndicatorToPosition$1(this, i4, left, i3, right));
            valueAnimator3.addListener(new FakeTabIndicator$animateIndicatorToPosition$2(this, i));
            valueAnimator3.start();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        int i = this.mIndicatorLeft;
        if (i >= 0 && this.mIndicatorRight > i) {
            canvas.drawRect((float) i, (float) (getHeight() - this.mSelectedIndicatorHeight), (float) this.mIndicatorRight, (float) getHeight(), this.mSelectedIndicatorPaint);
        }
    }
}
