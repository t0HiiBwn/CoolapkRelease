package group.infotech.drawable.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0016\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0004j\u0002`\u0005H\u0000¢\u0006\u0002\b\u0017R\u001e\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lgroup/infotech/drawable/dsl/Corners;", "", "()V", "bottomLeft", "", "Lgroup/infotech/drawable/dsl/FloatPx;", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "bottomRight", "getBottomRight", "setBottomRight", "radius", "getRadius", "setRadius", "topLeft", "getTopLeft", "setTopLeft", "topRight", "getTopRight", "setTopRight", "orRadius", "orRadius$build_release", "build_release"}, k = 1, mv = {1, 1, 7})
/* compiled from: shapes.kt */
public final class Corners {
    private float bottomLeft = FloatCompanionObject.INSTANCE.getNaN();
    private float bottomRight = FloatCompanionObject.INSTANCE.getNaN();
    private float radius;
    private float topLeft = FloatCompanionObject.INSTANCE.getNaN();
    private float topRight = FloatCompanionObject.INSTANCE.getNaN();

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final float getTopLeft() {
        return this.topLeft;
    }

    public final void setTopLeft(float f) {
        this.topLeft = f;
    }

    public final float getTopRight() {
        return this.topRight;
    }

    public final void setTopRight(float f) {
        this.topRight = f;
    }

    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    public final void setBottomLeft(float f) {
        this.bottomLeft = f;
    }

    public final float getBottomRight() {
        return this.bottomRight;
    }

    public final void setBottomRight(float f) {
        this.bottomRight = f;
    }

    public final float orRadius$build_release(float f) {
        Float valueOf = Float.valueOf(f);
        boolean z = false;
        if (valueOf.floatValue() >= ((float) 0)) {
            z = true;
        }
        if (!z) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.floatValue() : this.radius;
    }
}
