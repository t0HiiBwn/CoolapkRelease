package group.infotech.drawable.dsl;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00060\u000bj\u0002`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00060\u000bj\u0002`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00060\u0004j\u0002`\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lgroup/infotech/drawable/dsl/Stroke;", "", "()V", "color", "", "Lgroup/infotech/drawable/dsl/ColorInt;", "getColor", "()I", "setColor", "(I)V", "dashGap", "", "Lgroup/infotech/drawable/dsl/FloatPx;", "getDashGap", "()F", "setDashGap", "(F)V", "dashWidth", "getDashWidth", "setDashWidth", "width", "Lgroup/infotech/drawable/dsl/Px;", "getWidth", "setWidth", "build_release"}, k = 1, mv = {1, 1, 7})
/* compiled from: shapes.kt */
public final class Stroke {
    private int color = -1;
    private float dashGap;
    private float dashWidth;
    private int width = -1;

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final float getDashWidth() {
        return this.dashWidth;
    }

    public final void setDashWidth(float f) {
        this.dashWidth = f;
    }

    public final float getDashGap() {
        return this.dashGap;
    }

    public final void setDashGap(float f) {
        this.dashGap = f;
    }
}
