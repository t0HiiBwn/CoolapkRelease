package com.coolapk.market.view.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import com.coolapk.market.util.ResourceUtils;
import group.infotech.drawable.dsl.ViewStates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/main/NavigationItem;", "", "titleRes", "", "iconRes", "iconSelectedRes", "clazz", "Ljava/lang/Class;", "(IIILjava/lang/Class;)V", "getClazz$presentation_coolapkAppRelease", "()Ljava/lang/Class;", "setClazz$presentation_coolapkAppRelease", "(Ljava/lang/Class;)V", "fragmentTag", "", "kotlin.jvm.PlatformType", "getFragmentTag", "()Ljava/lang/String;", "getIconRes$presentation_coolapkAppRelease", "()I", "setIconRes$presentation_coolapkAppRelease", "(I)V", "getIconSelectedRes$presentation_coolapkAppRelease", "setIconSelectedRes$presentation_coolapkAppRelease", "getTitleRes$presentation_coolapkAppRelease", "setTitleRes$presentation_coolapkAppRelease", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
public final class NavigationItem {
    private Class<?> clazz;
    private final String fragmentTag;
    private int iconRes;
    private int iconSelectedRes;
    private int titleRes;

    public NavigationItem(int i, int i2, int i3, Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.titleRes = i;
        this.iconRes = i2;
        this.iconSelectedRes = i3;
        this.clazz = cls;
        this.fragmentTag = cls.getSimpleName();
    }

    public final int getTitleRes$presentation_coolapkAppRelease() {
        return this.titleRes;
    }

    public final void setTitleRes$presentation_coolapkAppRelease(int i) {
        this.titleRes = i;
    }

    public final int getIconRes$presentation_coolapkAppRelease() {
        return this.iconRes;
    }

    public final void setIconRes$presentation_coolapkAppRelease(int i) {
        this.iconRes = i;
    }

    public final int getIconSelectedRes$presentation_coolapkAppRelease() {
        return this.iconSelectedRes;
    }

    public final void setIconSelectedRes$presentation_coolapkAppRelease(int i) {
        this.iconSelectedRes = i;
    }

    public final Class<?> getClazz$presentation_coolapkAppRelease() {
        return this.clazz;
    }

    public final void setClazz$presentation_coolapkAppRelease(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.clazz = cls;
    }

    public final String getFragmentTag() {
        return this.fragmentTag;
    }

    public final Drawable getIconDrawable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ResourceUtils.getDrawable(context, this.iconSelectedRes);
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        Intrinsics.checkNotNullExpressionValue(drawable, "iconSelectedDrawable");
        stateListDrawable.addState(selected, drawable);
        stateListDrawable.addState(ViewStates.INSTANCE.checked(), drawable);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        Drawable drawable2 = ResourceUtils.getDrawable(context, this.iconRes);
        Intrinsics.checkNotNullExpressionValue(drawable2, "ResourceUtils.getDrawable(context, iconRes)");
        stateListDrawable.addState(iArr, drawable2);
        return stateListDrawable;
    }
}
