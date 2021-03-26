package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.OverScroller;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/widget/view/SimpleIndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "color", "", "drawOffset", "indicatorWidth", "getIndicatorWidth", "()I", "setIndicatorWidth", "(I)V", "paint", "Landroid/graphics/Paint;", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "scroller", "Landroid/widget/OverScroller;", "animatorToOffset", "", "toOffset", "computeScroll", "onDraw", "canvas", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleIndicatorView.kt */
public final class SimpleIndicatorView extends View {
    private final int color;
    private int drawOffset = -1;
    private int indicatorWidth = NumberExtendsKt.getDp((Number) 24);
    private final Paint paint;
    private float radius = ((float) NumberExtendsKt.getDp((Number) 1));
    private OverScroller scroller;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleIndicatorView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        this.color = colorAccent;
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setColor(colorAccent);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        this.color = colorAccent;
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setColor(colorAccent);
    }

    public final int getIndicatorWidth() {
        return this.indicatorWidth;
    }

    public final void setIndicatorWidth(int i) {
        this.indicatorWidth = i;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final void animatorToOffset(int i) {
        OverScroller overScroller = this.scroller;
        if (overScroller != null && !overScroller.isFinished()) {
            overScroller.abortAnimation();
        }
        if (this.drawOffset < 0) {
            this.drawOffset = i;
        } else {
            OverScroller overScroller2 = new OverScroller(getContext());
            this.scroller = overScroller2;
            if (overScroller2 != null) {
                int i2 = this.drawOffset;
                overScroller2.startScroll(i2, 0, i - i2, 0);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i = this.drawOffset;
        if (i >= 0) {
            float f = this.radius;
            canvas.drawRoundRect((float) i, 0.0f, (float) (i + this.indicatorWidth), (float) getHeight(), f, f, this.paint);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        OverScroller overScroller = this.scroller;
        if (overScroller != null && overScroller.computeScrollOffset()) {
            this.drawOffset = overScroller.getCurrX();
            invalidate();
        }
    }
}
