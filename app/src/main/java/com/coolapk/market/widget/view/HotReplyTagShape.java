package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/widget/view/HotReplyTagShape;", "Landroid/graphics/drawable/shapes/Shape;", "bottomRightEdge", "", "bottomRightRadius", "(II)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "buildConvexPath", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onResize", "width", "", "height", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HotReplyTagShape.kt */
public final class HotReplyTagShape extends Shape {
    private final int bottomRightEdge;
    private final int bottomRightRadius;
    private Path path;

    public HotReplyTagShape() {
        this(0, 0, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotReplyTagShape(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NumberExtendsKt.getDp((Number) 6) : i, (i3 & 2) != 0 ? NumberExtendsKt.getDp((Number) 4) : i2);
    }

    public HotReplyTagShape(int i, int i2) {
        this.bottomRightEdge = i;
        this.bottomRightRadius = i2;
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
        paint.setColor(AppHolder.getAppTheme().getColorAccent());
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
        int i = this.bottomRightRadius;
        float f = (float) i;
        RectF rectF = new RectF((getWidth() - ((float) this.bottomRightEdge)) - f, getHeight() - ((float) (i * 2)), (getWidth() - ((float) this.bottomRightEdge)) + f, getHeight());
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo((getWidth() - ((float) this.bottomRightEdge)) + f, getHeight() - f);
        path2.arcTo(rectF, 0.0f, 90.0f);
        path2.lineTo(0.0f, getHeight());
        path2.close();
        Unit unit = Unit.INSTANCE;
        this.path = path2;
    }
}
