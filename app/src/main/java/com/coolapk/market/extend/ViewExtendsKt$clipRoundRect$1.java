package com.coolapk.market.extend;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$clipRoundRect$1", "Landroid/view/ViewOutlineProvider;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$clipRoundRect$1 extends ViewOutlineProvider {
    final /* synthetic */ float[] $radiusArray;
    private final Path path = new Path();
    private final RectF rectF = new RectF();

    ViewExtendsKt$clipRoundRect$1(float[] fArr) {
        this.$radiusArray = fArr;
    }

    public final Path getPath() {
        return this.path;
    }

    public final RectF getRectF() {
        return this.rectF;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        this.rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        this.path.reset();
        this.path.addRoundRect(this.rectF, this.$radiusArray, Path.Direction.CW);
        outline.setConvexPath(this.path);
    }
}
