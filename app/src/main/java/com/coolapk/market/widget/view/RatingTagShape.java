package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/widget/view/RatingTagShape;", "Landroid/graphics/drawable/shapes/Shape;", "()V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "buildConvexPath", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onResize", "width", "", "height", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingTagShape.kt */
public final class RatingTagShape extends Shape {
    private Path path;

    public final Path getPath() {
        return this.path;
    }

    public final void setPath(Path path2) {
        this.path = path2;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(AppHolder.getAppTheme().getColorAccent());
        if (this.path == null) {
            buildConvexPath();
        }
        Path path2 = this.path;
        Intrinsics.checkNotNull(path2);
        canvas.drawPath(path2, paint);
    }

    @Override // android.graphics.drawable.shapes.Shape
    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        buildConvexPath();
    }

    private final void buildConvexPath() {
        Path path2 = new Path();
        float dp = (float) NumberExtendsKt.getDp((Number) 3);
        path2.moveTo(dp, 0.0f);
        float f = (float) 2;
        float f2 = f * dp;
        path2.arcTo(0.0f, 0.0f, f2, f2, -90.0f, -90.0f, false);
        path2.lineTo(0.0f, getHeight() - dp);
        path2.arcTo(0.0f, getHeight() - f2, f2, getHeight(), -180.0f, -90.0f, false);
        path2.lineTo(getWidth() - dp, getHeight());
        path2.arcTo(getWidth() - f2, getHeight() - f2, getWidth(), getHeight(), 90.0f, -110.0f, false);
        float dp2 = (float) NumberExtendsKt.getDp((Number) 3);
        float dp3 = (float) NumberExtendsKt.getDp((Number) 3);
        path2.lineTo(getWidth() - dp3, dp2);
        float f3 = f * dp2;
        path2.arcTo((getWidth() - dp3) - f3, 0.0f, getWidth() - dp3, f3, 0.0f, -70.0f, false);
        path2.close();
        Unit unit = Unit.INSTANCE;
        this.path = path2;
    }
}
