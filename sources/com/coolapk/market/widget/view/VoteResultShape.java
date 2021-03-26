package com.coolapk.market.widget.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/view/VoteResultShape;", "Landroid/graphics/drawable/shapes/Shape;", "leftColor", "", "rightColor", "leftPercent", "", "slashWidth", "(IIFI)V", "path", "Landroid/graphics/Path;", "rightPercent", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "setPercents", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteResultShape.kt */
public final class VoteResultShape extends Shape {
    private final int leftColor;
    private float leftPercent;
    private Path path = new Path();
    private final int rightColor;
    private float rightPercent = (((float) 1) - this.leftPercent);
    private final int slashWidth;

    public VoteResultShape(int i, int i2, float f, int i3) {
        this.leftColor = i;
        this.rightColor = i2;
        this.leftPercent = f;
        this.slashWidth = i3;
    }

    public final void setPercents(float f, float f2) {
        this.leftPercent = f;
        this.rightPercent = f2;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float width = getWidth() * this.leftPercent;
        Path path2 = this.path;
        path2.reset();
        path2.moveTo(0.0f, 0.0f);
        path2.lineTo(((float) (this.slashWidth / 2)) + width, 0.0f);
        path2.lineTo(width - ((float) (this.slashWidth / 2)), getHeight());
        path2.lineTo(0.0f, getHeight());
        path2.close();
        paint.setColor(this.leftColor);
        canvas.drawPath(this.path, paint);
        float width2 = getWidth() * (((float) 1) - this.rightPercent);
        Path path3 = this.path;
        path3.reset();
        path3.moveTo(((float) (this.slashWidth / 2)) + width2, 0.0f);
        path3.lineTo(getWidth(), 0.0f);
        path3.lineTo(getWidth(), getHeight());
        path3.lineTo(width2 - ((float) (this.slashWidth / 2)), getHeight());
        path3.close();
        paint.setColor(this.rightColor);
        canvas.drawPath(this.path, paint);
    }
}
