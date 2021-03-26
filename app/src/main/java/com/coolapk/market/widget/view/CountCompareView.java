package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\r¨\u0006&"}, d2 = {"Lcom/coolapk/market/widget/view/CountCompareView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "leftColor", "", "getLeftColor", "()I", "setLeftColor", "(I)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "percent", "", "getPercent", "()F", "setPercent", "(F)V", "rightColor", "getRightColor", "setRightColor", "slashWidth", "getSlashWidth", "setSlashWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CountCompareView.kt */
public final class CountCompareView extends RelativeLayout {
    private int leftColor = -65536;
    private final Paint paint;
    private final Path path = new Path();
    private float percent = 0.5f;
    private int rightColor = -16711936;
    private int slashWidth = NumberExtendsKt.getDp((Number) 16);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountCompareView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        setWillNotDraw(false);
        paint2.setStyle(Paint.Style.FILL);
        int colorInt = ResourceUtils.getColorInt(getContext(), 2131099789);
        this.leftColor = ColorUtils.setAlphaComponent(ResourceUtils.getColorInt(getContext(), 2131099790), 26);
        this.rightColor = ColorUtils.setAlphaComponent(colorInt, 26);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountCompareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        setWillNotDraw(false);
        paint2.setStyle(Paint.Style.FILL);
        int colorInt = ResourceUtils.getColorInt(getContext(), 2131099789);
        this.leftColor = ColorUtils.setAlphaComponent(ResourceUtils.getColorInt(getContext(), 2131099790), 26);
        this.rightColor = ColorUtils.setAlphaComponent(colorInt, 26);
    }

    public final int getLeftColor() {
        return this.leftColor;
    }

    public final void setLeftColor(int i) {
        this.leftColor = i;
    }

    public final int getRightColor() {
        return this.rightColor;
    }

    public final void setRightColor(int i) {
        this.rightColor = i;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final void setPercent(float f) {
        this.percent = f;
    }

    public final int getSlashWidth() {
        return this.slashWidth;
    }

    public final void setSlashWidth(int i) {
        this.slashWidth = i;
    }

    public final Path getPath() {
        return this.path;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.percent;
        if (f >= 0.0f && f <= 1.0f) {
            float width = ((float) getWidth()) * this.percent;
            Path path2 = this.path;
            path2.reset();
            path2.moveTo(0.0f, 0.0f);
            path2.lineTo(((float) (this.slashWidth / 2)) + width, 0.0f);
            path2.lineTo(width - ((float) (this.slashWidth / 2)), (float) getHeight());
            path2.lineTo(0.0f, (float) getHeight());
            path2.close();
            this.paint.setColor(this.leftColor);
            canvas.drawPath(this.path, this.paint);
            Path path3 = this.path;
            path3.reset();
            path3.moveTo(((float) (this.slashWidth / 2)) + width, 0.0f);
            path3.lineTo((float) getWidth(), 0.0f);
            path3.lineTo((float) getWidth(), (float) getHeight());
            path3.lineTo(width - ((float) (this.slashWidth / 2)), (float) getHeight());
            path3.close();
            this.paint.setColor(this.rightColor);
            canvas.drawPath(this.path, this.paint);
        }
    }
}
