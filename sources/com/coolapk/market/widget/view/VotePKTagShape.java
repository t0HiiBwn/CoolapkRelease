package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/view/VotePKTagShape;", "Landroid/graphics/drawable/shapes/Shape;", "isLeft", "", "(Z)V", "()Z", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "buildConvexPath", "", "width", "", "height", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onResize", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VotePKTagShape.kt */
public final class VotePKTagShape extends Shape {
    private final boolean isLeft;
    private Path path;

    public VotePKTagShape(boolean z) {
        this.isLeft = z;
    }

    public final boolean isLeft() {
        return this.isLeft;
    }

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
        Path path2 = this.path;
        if (path2 != null) {
            Intrinsics.checkNotNull(path2);
            canvas.drawPath(path2, paint);
        }
    }

    @Override // android.graphics.drawable.shapes.Shape
    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        if (f >= f2) {
            buildConvexPath(f, f2);
        }
    }

    private final void buildConvexPath(float f, float f2) {
        if (this.isLeft) {
            Path path2 = new Path();
            float f3 = f2 / ((float) 2);
            path2.moveTo(f3, 0.0f);
            path2.arcTo(0.0f, 0.0f, f2, f2, -90.0f, -180.0f, false);
            path2.lineTo(f - f3, f2);
            path2.lineTo(f, 0.0f);
            path2.close();
            Unit unit = Unit.INSTANCE;
            this.path = path2;
            return;
        }
        Path path3 = new Path();
        float f4 = f2 / ((float) 2);
        path3.moveTo(f4, 0.0f);
        path3.lineTo(0.0f, f2);
        path3.lineTo(f - f4, f2);
        path3.arcTo(f - f2, 0.0f, f, f2, 90.0f, -180.0f, false);
        path3.close();
        Unit unit2 = Unit.INSTANCE;
        this.path = path3;
    }
}
