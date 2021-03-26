package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/view/HorizonExpandedCircle;", "Landroid/graphics/drawable/ShapeDrawable;", "()V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HorizonExpandedCircle.kt */
public final class HorizonExpandedCircle extends ShapeDrawable {
    public HorizonExpandedCircle() {
        setShape(new Shape() {
            /* class com.coolapk.market.widget.view.HorizonExpandedCircle.AnonymousClass1 */
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
                if (path2 != null) {
                    canvas.drawPath(path2, paint);
                }
            }

            @Override // android.graphics.drawable.shapes.Shape
            public void getOutline(Outline outline) {
                Intrinsics.checkNotNullParameter(outline, "outline");
                super.getOutline(outline);
                if (this.path == null) {
                    buildConvexPath();
                }
                Path path2 = this.path;
                if (path2 != null) {
                    outline.setConvexPath(path2);
                }
            }

            @Override // android.graphics.drawable.shapes.Shape
            protected void onResize(float f, float f2) {
                super.onResize(f, f2);
                buildConvexPath();
            }

            private final void buildConvexPath() {
                Path path2 = new Path();
                RectF rectF = new RectF();
                float f = (float) 2;
                path2.moveTo(getHeight() / f, 0.0f);
                path2.lineTo(getWidth() - (getHeight() / f), 0.0f);
                rectF.set(getWidth() - getHeight(), 0.0f, getWidth(), getHeight());
                path2.arcTo(rectF, -90.0f, 180.0f);
                path2.lineTo(getHeight() / f, getHeight());
                rectF.set(0.0f, 0.0f, getHeight(), getHeight());
                path2.arcTo(rectF, 90.0f, 180.0f);
                path2.close();
                Unit unit = Unit.INSTANCE;
                this.path = path2;
            }
        });
    }
}
