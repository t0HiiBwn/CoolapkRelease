package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/widget/view/RoundRectView;", "Lcom/github/florent37/shapeofview/shapes/RoundRectView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "updating", "", "requiresShapeUpdate", "", "setBorderColor", "borderColor", "", "setRadius", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RoundRectView.kt */
public final class RoundRectView extends com.github.florent37.shapeofview.shapes.RoundRectView {
    private boolean updating;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundRectView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.updating = true;
        setBottomLeftRadius(f4);
        setTopLeftRadius(f);
        setTopRightRadius(f2);
        setBottomRightRadius(f3);
        this.updating = false;
        requiresShapeUpdate();
    }

    @Override // com.github.florent37.shapeofview.shapes.RoundRectView
    public void setBorderColor(int i) {
        this.updating = true;
        super.setBorderColor(i);
        this.updating = false;
    }

    @Override // com.github.florent37.shapeofview.shapes.RoundRectView, com.github.florent37.shapeofview.ShapeOfView
    public void requiresShapeUpdate() {
        if (!this.updating) {
            super.requiresShapeUpdate();
        }
    }
}
