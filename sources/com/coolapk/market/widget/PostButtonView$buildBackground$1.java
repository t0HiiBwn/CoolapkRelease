package com.coolapk.market.widget;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.RectShape;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/widget/PostButtonView$buildBackground$1", "Landroid/graphics/drawable/shapes/RectShape;", "buildConvexPath", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "getOutline", "outline", "Landroid/graphics/Outline;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PostButtonView.kt */
public final class PostButtonView$buildBackground$1 extends RectShape {
    PostButtonView$buildBackground$1() {
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(buildConvexPath(), paint);
    }

    @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
    public void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        outline.setConvexPath(buildConvexPath());
    }

    private final Path buildConvexPath() {
        Path path = new Path();
        float centerX = (float) ((int) rect().centerX());
        float centerY = (float) ((int) rect().centerY());
        path.moveTo(centerX, centerY);
        path.arcTo(rect(), 225.0f, 90.0f);
        path.lineTo(centerX, centerY);
        path.close();
        return path;
    }
}
