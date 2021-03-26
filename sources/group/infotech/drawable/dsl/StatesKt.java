package group.infotech.drawable.dsl;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\u001a\"\u0010\u000b\u001a\u00020\u00062\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\b\u001a\u001b\u0010\u0010\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u0013\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u0014\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u0015\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u0016\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u0017\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a#\u0010\u0018\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u001a\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u001b\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\u001a\u001b\u0010\u001c\u001a\u00020\u000e*\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"0\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00062\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048G@FX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"NO_GETTER", "", "value", "", "Lgroup/infotech/drawable/dsl/Milliseconds;", "exitFadeDuration", "Landroid/graphics/drawable/StateListDrawable;", "getExitFadeDuration", "(Landroid/graphics/drawable/StateListDrawable;)I", "setExitFadeDuration", "(Landroid/graphics/drawable/StateListDrawable;I)V", "stateListDrawable", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkedState", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "defaultState", "disabledState", "enabledState", "pressedState", "selectedState", "state", "", "unCheckedState", "unPressedState", "unSelectedState", "build_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: states.kt */
public final class StatesKt {
    public static final String NO_GETTER = "Getter not available";

    public static final StateListDrawable stateListDrawable(Function1<? super StateListDrawable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        StateListDrawable stateListDrawable = new StateListDrawable();
        function1.invoke(stateListDrawable);
        return stateListDrawable;
    }

    public static final void state(StateListDrawable stateListDrawable, int[] iArr, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(iArr, "state");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(iArr, (Drawable) function0.invoke());
    }

    public static final void enabledState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.enabled(), (Drawable) function0.invoke());
    }

    public static final void disabledState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.disabled(), (Drawable) function0.invoke());
    }

    public static final void selectedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.selected(), (Drawable) function0.invoke());
    }

    public static final void unSelectedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.notSelected(), (Drawable) function0.invoke());
    }

    public static final void pressedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.pressed(), (Drawable) function0.invoke());
    }

    public static final void unPressedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.notPressed(), (Drawable) function0.invoke());
    }

    public static final void checkedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.checked(), (Drawable) function0.invoke());
    }

    public static final void unCheckedState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        stateListDrawable.addState(ViewStates.INSTANCE.unchecked(), (Drawable) function0.invoke());
    }

    public static final void defaultState(StateListDrawable stateListDrawable, Function0<? extends Drawable> function0) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        stateListDrawable.addState(iArr, (Drawable) function0.invoke());
    }

    public static final void setExitFadeDuration(StateListDrawable stateListDrawable, int i) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        stateListDrawable.setExitFadeDuration(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Getter not available")
    public static final int getExitFadeDuration(StateListDrawable stateListDrawable) {
        Intrinsics.checkParameterIsNotNull(stateListDrawable, "$receiver");
        throw new IllegalStateException("Getter not available".toString());
    }
}
