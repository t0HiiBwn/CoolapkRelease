package group.infotech.drawable.dsl;

import android.graphics.drawable.GradientDrawable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0013\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\bj\u0002`\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\u0010\u0017\u001a\u00060\bj\u0002`\u0018\u001a7\u0010\u0019\u001a\u00020\u00032\f\b\u0002\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\n\u0010\u0014\u001a\u00060\bj\u0002`\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\u001d\u001a\"\u0010\u001e\u001a\u00020\u00032\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\b\u001a\u0012\u0010#\u001a\u00060\bj\u0002`\u00182\u0006\u0010\u0017\u001a\u00020\u0001\u001a&\u0010$\u001a\u00020%*\u00020\u00032\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\b\u001a\n\u0010&\u001a\u00020'*\u00020%\u001a&\u0010\n\u001a\u00020(*\u00020\u00032\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\b\u001a&\u0010)\u001a\u00020**\u00020\u00032\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\b\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"0\u0010\n\u001a\u00060\bj\u0002`\t*\u00020\u00032\n\u0010\u0000\u001a\u00060\bj\u0002`\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"0\u0010\u0010\u001a\u00060\bj\u0002`\u000f*\u00020\u00032\n\u0010\u0000\u001a\u00060\bj\u0002`\u000f8G@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e*\n\u0010+\"\u00020\b2\u00020\b¨\u0006,"}, d2 = {"value", "Lgroup/infotech/drawable/dsl/Shape;", "shapeEnum", "Landroid/graphics/drawable/GradientDrawable;", "getShapeEnum", "(Landroid/graphics/drawable/GradientDrawable;)Lgroup/infotech/drawable/dsl/Shape;", "setShapeEnum", "(Landroid/graphics/drawable/GradientDrawable;Lgroup/infotech/drawable/dsl/Shape;)V", "", "Lgroup/infotech/drawable/dsl/Px;", "size", "getSize", "(Landroid/graphics/drawable/GradientDrawable;)I", "setSize", "(Landroid/graphics/drawable/GradientDrawable;I)V", "Lgroup/infotech/drawable/dsl/ColorInt;", "solidColor", "getSolidColor", "setSolidColor", "circleShape", "color", "(ILjava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable;", "fromInt", "s", "Lgroup/infotech/drawable/dsl/ShapeInt;", "rectangleShape", "radius", "", "Lgroup/infotech/drawable/dsl/FloatPx;", "(FILjava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable;", "shapeDrawable", "fill", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "toInt", "corners", "Lgroup/infotech/drawable/dsl/Corners;", "render", "", "Lgroup/infotech/drawable/dsl/Size;", "stroke", "Lgroup/infotech/drawable/dsl/Stroke;", "ShapeInt", "build_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: shapes.kt */
public final class ShapesKt {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 7})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shape.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Shape.RECTANGLE.ordinal()] = 1;
            iArr[Shape.OVAL.ordinal()] = 2;
            iArr[Shape.LINE.ordinal()] = 3;
            iArr[Shape.RING.ordinal()] = 4;
        }
    }

    public static final GradientDrawable shapeDrawable(Function1<? super GradientDrawable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "fill");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        function1.invoke(gradientDrawable);
        return gradientDrawable;
    }

    public static final int toInt(Shape shape) {
        Intrinsics.checkParameterIsNotNull(shape, "s");
        int i = WhenMappings.$EnumSwitchMapping$0[shape.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Shape fromInt(int i) {
        if (i == 0) {
            return Shape.RECTANGLE;
        }
        if (i == 1) {
            return Shape.OVAL;
        }
        if (i == 2) {
            return Shape.LINE;
        }
        if (i != 3) {
            return null;
        }
        return Shape.RING;
    }

    public static final void setShapeEnum(GradientDrawable gradientDrawable, Shape shape) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(shape, "value");
        gradientDrawable.setShape(toInt(shape));
    }

    public static final Shape getShapeEnum(GradientDrawable gradientDrawable) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        Shape fromInt = fromInt(gradientDrawable.getShape());
        if (fromInt != null) {
            return fromInt;
        }
        throw new IllegalStateException(("Illegal shape int " + gradientDrawable.getShape()).toString());
    }

    public static /* bridge */ /* synthetic */ GradientDrawable rectangleShape$default(float f, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = FloatCompanionObject.INSTANCE.getNaN();
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        return rectangleShape(f, i, num);
    }

    public static /* bridge */ /* synthetic */ GradientDrawable circleShape$default(int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return circleShape(i, num);
    }

    public static final void setSolidColor(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        gradientDrawable.setColor(i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Getter not available")
    public static final /* synthetic */ int getSolidColor(GradientDrawable gradientDrawable) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        throw new IllegalStateException("Getter not available".toString());
    }

    public static final void setSize(GradientDrawable gradientDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        gradientDrawable.setSize(i, i);
    }

    public static final int getSize(GradientDrawable gradientDrawable) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        return gradientDrawable.getIntrinsicWidth();
    }

    public static final Stroke stroke(GradientDrawable gradientDrawable, Function1<? super Stroke, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "fill");
        Stroke stroke = new Stroke();
        function1.invoke(stroke);
        gradientDrawable.setStroke(stroke.getWidth(), stroke.getColor(), stroke.getDashWidth(), stroke.getDashGap());
        return stroke;
    }

    public static final Size size(GradientDrawable gradientDrawable, Function1<? super Size, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "fill");
        Size size = new Size();
        function1.invoke(size);
        gradientDrawable.setSize(size.getWidth(), size.getHeight());
        return size;
    }

    public static final float[] render(Corners corners) {
        Intrinsics.checkParameterIsNotNull(corners, "$receiver");
        return new float[]{corners.orRadius$build_release(corners.getTopLeft()), corners.orRadius$build_release(corners.getTopLeft()), corners.orRadius$build_release(corners.getTopRight()), corners.orRadius$build_release(corners.getTopRight()), corners.orRadius$build_release(corners.getBottomRight()), corners.orRadius$build_release(corners.getBottomRight()), corners.orRadius$build_release(corners.getBottomLeft()), corners.orRadius$build_release(corners.getBottomLeft())};
    }

    public static final Corners corners(GradientDrawable gradientDrawable, Function1<? super Corners, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gradientDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "fill");
        Corners corners = new Corners();
        function1.invoke(corners);
        gradientDrawable.setCornerRadii(render(corners));
        return corners;
    }

    public static final GradientDrawable rectangleShape(float f, int i, Integer num) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        setShapeEnum(gradientDrawable, Shape.RECTANGLE);
        if (f != FloatCompanionObject.INSTANCE.getNaN()) {
            gradientDrawable.setCornerRadius(f);
        }
        setSolidColor(gradientDrawable, i);
        if (num != null) {
            setSize(gradientDrawable, num.intValue());
        }
        return gradientDrawable;
    }

    public static final GradientDrawable circleShape(int i, Integer num) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(1);
        setSolidColor(gradientDrawable, i);
        if (num != null) {
            setSize(gradientDrawable, num.intValue());
        }
        return gradientDrawable;
    }
}
