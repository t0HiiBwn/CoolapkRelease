package com.loopeer.shadow;

import android.graphics.Path;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rJF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/loopeer/shadow/ShapeUtils;", "", "()V", "roundedRect", "Landroid/graphics/Path;", "left", "", "top", "right", "bottom", "rx", "ry", "tl", "", "tr", "br", "bl", "shadow_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: ShapeUtils.kt */
public final class ShapeUtils {
    public static final ShapeUtils INSTANCE = new ShapeUtils();

    private ShapeUtils() {
    }

    public static /* bridge */ /* synthetic */ Path roundedRect$default(ShapeUtils shapeUtils, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return shapeUtils.roundedRect(f, f2, f3, f4, f5, f6, (i & 64) != 0 ? true : z, (i & 128) != 0 ? true : z2, (i & 256) != 0 ? true : z3, (i & 512) != 0 ? true : z4);
    }

    public final Path roundedRect(float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4) {
        Path path = new Path();
        float f7 = (float) 0;
        if (f5 < f7) {
            f5 = 0.0f;
        }
        if (f6 < f7) {
            f6 = 0.0f;
        }
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (float) 2;
        float f11 = f8 / f10;
        if (f5 > f11) {
            f5 = f11;
        }
        float f12 = f9 / f10;
        if (f6 > f12) {
            f6 = f12;
        }
        float f13 = f8 - (f10 * f5);
        float f14 = f9 - (f10 * f6);
        path.moveTo(f3, f2 + f6);
        if (z2) {
            float f15 = -f6;
            path.rQuadTo(0.0f, f15, -f5, f15);
        } else {
            path.rLineTo(0.0f, -f6);
            path.rLineTo(-f5, 0.0f);
        }
        path.rLineTo(-f13, 0.0f);
        if (z) {
            float f16 = -f5;
            path.rQuadTo(f16, 0.0f, f16, f6);
        } else {
            path.rLineTo(-f5, 0.0f);
            path.rLineTo(0.0f, f6);
        }
        path.rLineTo(0.0f, f14);
        if (z4) {
            path.rQuadTo(0.0f, f6, f5, f6);
        } else {
            path.rLineTo(0.0f, f6);
            path.rLineTo(f5, 0.0f);
        }
        path.rLineTo(f13, 0.0f);
        if (z3) {
            path.rQuadTo(f5, 0.0f, f5, -f6);
        } else {
            path.rLineTo(f5, 0.0f);
            path.rLineTo(0.0f, -f6);
        }
        path.rLineTo(0.0f, -f14);
        path.close();
        return path;
    }

    public final Path roundedRect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Path path = new Path();
        float f9 = (float) 0;
        if (f5 < f9) {
            f5 = 0.0f;
        }
        if (f6 < f9) {
            f6 = 0.0f;
        }
        if (f7 < f9) {
            f7 = 0.0f;
        }
        if (f8 < f9) {
            f8 = 0.0f;
        }
        float f10 = f3 - f;
        float f11 = f4 - f2;
        float min = Math.min(f10, f11);
        float f12 = min / ((float) 2);
        if (f5 > f12) {
            f5 = f12;
        }
        if (f6 > f12) {
            f6 = f12;
        }
        if (f7 > f12) {
            f7 = f12;
        }
        if (f8 > f12) {
            f8 = f12;
        }
        if (f5 == f6 && f6 == f7 && f7 == f8 && f5 == f12) {
            float f13 = min / 2.0f;
            path.addCircle(f + f13, f2 + f13, f13, Path.Direction.CW);
            return path;
        }
        path.moveTo(f3, f2 + f6);
        if (f6 > f9) {
            float f14 = -f6;
            path.rQuadTo(0.0f, f14, f14, f14);
        } else {
            float f15 = -f6;
            path.rLineTo(0.0f, f15);
            path.rLineTo(f15, 0.0f);
        }
        path.rLineTo(-((f10 - f6) - f5), 0.0f);
        if (f5 > f9) {
            float f16 = -f5;
            path.rQuadTo(f16, 0.0f, f16, f5);
        } else {
            path.rLineTo(-f5, 0.0f);
            path.rLineTo(0.0f, f5);
        }
        path.rLineTo(0.0f, (f11 - f5) - f8);
        if (f8 > f9) {
            path.rQuadTo(0.0f, f8, f8, f8);
        } else {
            path.rLineTo(0.0f, f8);
            path.rLineTo(f8, 0.0f);
        }
        path.rLineTo((f10 - f8) - f7, 0.0f);
        if (f7 > f9) {
            path.rQuadTo(f7, 0.0f, f7, -f7);
        } else {
            path.rLineTo(f7, 0.0f);
            path.rLineTo(0.0f, -f7);
        }
        path.rLineTo(0.0f, -((f11 - f7) - f6));
        path.close();
        return path;
    }
}
