package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/widget/view/BoughtShape;", "Landroid/graphics/drawable/shapes/Shape;", "()V", "color", "", "path", "Landroid/graphics/Path;", "buildConvexPath", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onResize", "width", "", "height", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BoughtShape.kt */
public final class BoughtShape extends Shape {
    private final int color = ((int) 4289098239L);
    private Path path;

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(this.color);
        if (this.path == null) {
            buildConvexPath();
        }
        Path path2 = this.path;
        if (path2 != null) {
            canvas.drawPath(path2, paint);
        }
    }

    @Override // android.graphics.drawable.shapes.Shape
    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        buildConvexPath();
    }

    private final void buildConvexPath() {
        Path path2 = new Path();
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo(getWidth(), getHeight());
        path2.lineTo(0.0f, getHeight());
        path2.lineTo(getWidth() / ((float) 8), getHeight() / ((float) 2));
        path2.close();
        Unit unit = Unit.INSTANCE;
        this.path = path2;
    }
}
