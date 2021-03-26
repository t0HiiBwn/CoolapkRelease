package group.infotech.drawable.dsl;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.StateSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0006\u001a\u00020\u00042\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u001a-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\b\u0002\u0010\u0010\u001a\u00060\bj\u0002`\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\b\u001a\n\u0010\u0014\u001a\u00020\u0004*\u00020\u0004*\n\u0010\u0015\"\u00020\b2\u00020\b*\n\u0010\u0016\"\u00020\u000f2\u00020\u000f*\n\u0010\u0017\"\u00020\b2\u00020\b*\n\u0010\u0018\"\u00020\b2\u00020\b*\n\u0010\u0019\"\u00020\b2\u00020\b¨\u0006\u001a"}, d2 = {"layerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "ds", "", "Landroid/graphics/drawable/Drawable;", "([Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/LayerDrawable;", "rippleCompat", "color", "", "Lgroup/infotech/drawable/dsl/ColorInt;", "content", "mask", "scaleDrawable", "Landroid/graphics/drawable/ScaleDrawable;", "scale", "", "gravity", "Lgroup/infotech/drawable/dsl/GravityInt;", "block", "Lkotlin/Function0;", "copy", "ColorInt", "FloatPx", "GravityInt", "Milliseconds", "Px", "build_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: drawable-dsl.kt */
public final class Drawable_dslKt {
    public static /* bridge */ /* synthetic */ ScaleDrawable scaleDrawable$default(float f, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 17;
        }
        Intrinsics.checkParameterIsNotNull(function0, "block");
        ScaleDrawable scaleDrawable = new ScaleDrawable((Drawable) function0.invoke(), i, f, f);
        scaleDrawable.setLevel(1);
        return scaleDrawable;
    }

    public static final ScaleDrawable scaleDrawable(float f, int i, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        ScaleDrawable scaleDrawable = new ScaleDrawable((Drawable) function0.invoke(), i, f, f);
        scaleDrawable.setLevel(1);
        return scaleDrawable;
    }

    public static final Drawable copy(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "$receiver");
        Drawable mutate = drawable.getConstantState().newDrawable().mutate();
        Intrinsics.checkExpressionValueIsNotNull(mutate, "constantState.newDrawable().mutate()");
        return mutate;
    }

    public static /* bridge */ /* synthetic */ Drawable rippleCompat$default(int i, Drawable drawable, Drawable drawable2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            drawable2 = null;
        }
        return rippleCompat(i, drawable, drawable2);
    }

    public static final Drawable rippleCompat(int i, Drawable drawable, Drawable drawable2) {
        Intrinsics.checkParameterIsNotNull(drawable, "content");
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(ColorStateList.valueOf(i), drawable, drawable2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        StatesKt.setExitFadeDuration(stateListDrawable, 300);
        int[] pressed = ViewStates.INSTANCE.pressed();
        Drawable copy = copy(drawable);
        copy.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        stateListDrawable.addState(pressed, copy);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        stateListDrawable.addState(iArr, drawable);
        return stateListDrawable;
    }

    public static final LayerDrawable layerDrawable(Drawable... drawableArr) {
        Intrinsics.checkParameterIsNotNull(drawableArr, "ds");
        return new LayerDrawable(drawableArr);
    }
}
