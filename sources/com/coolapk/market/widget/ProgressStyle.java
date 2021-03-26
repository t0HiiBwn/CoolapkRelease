package com.coolapk.market.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import group.infotech.drawable.dsl.Drawable_dslKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0006\u0010\u0015\u001a\u00020\u0016J*\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\n2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/widget/ProgressStyle;", "Lcom/coolapk/market/widget/Style;", "context", "Landroid/content/Context;", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "(Landroid/content/Context;Lcom/coolapk/market/widget/ActionButton;)V", "progressDrawable", "Landroid/graphics/drawable/Drawable;", "showSize", "", "getShowSize", "()Z", "setShowSize", "(Z)V", "createBackground", "createButtonBackground", "createForeground", "getBackgroundColor", "Landroid/content/res/ColorStateList;", "getForegroundColor", "resetProgress", "", "setProgress", "level", "", "anim", "callback", "Lkotlin/Function0;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public abstract class ProgressStyle implements Style {
    private final ActionButton actionButton;
    private final Context context;
    private Drawable progressDrawable;
    private boolean showSize;

    public abstract ColorStateList getBackgroundColor();

    public abstract ColorStateList getForegroundColor();

    public ProgressStyle(Context context2, ActionButton actionButton2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        this.context = context2;
        this.actionButton = actionButton2;
    }

    public final boolean getShowSize() {
        return this.showSize;
    }

    public final void setShowSize(boolean z) {
        this.showSize = z;
    }

    @Override // com.coolapk.market.widget.Style
    public Drawable createButtonBackground() {
        LayerDrawable layerDrawable = Drawable_dslKt.layerDrawable(createBackground(), createForeground());
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        Unit unit = Unit.INSTANCE;
        return Drawable_dslKt.rippleCompat(-3355444, layerDrawable, null);
    }

    public final void resetProgress() {
        setProgress$default(this, 10000, false, null, 6, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.widget.ProgressStyle */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setProgress$default(ProgressStyle progressStyle, int i, boolean z, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                function0 = null;
            }
            progressStyle.setProgress(i, z, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setProgress");
    }

    public final void setProgress(int i, boolean z, Function0<Unit> function0) {
        if (!z) {
            Drawable drawable = this.progressDrawable;
            if (drawable != null) {
                drawable.setLevel(i);
            }
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        Drawable drawable2 = this.progressDrawable;
        if (drawable2 != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(drawable2, "level", 0, i);
            Intrinsics.checkNotNullExpressionValue(ofInt, "it");
            ofInt.setDuration(((long) (i * 350)) / 10000);
            ofInt.addListener(new ProgressStyle$setProgress$$inlined$also$lambda$1(i, function0));
            ofInt.start();
        }
    }

    private final Drawable createBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getBackgroundColor());
        gradientDrawable.setCornerRadius(this.actionButton.getRadius());
        return gradientDrawable;
    }

    private final Drawable createForeground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getForegroundColor());
        gradientDrawable.setCornerRadius(this.actionButton.getRadius());
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
        clipDrawable.setLevel(10000);
        ClipDrawable clipDrawable2 = clipDrawable;
        this.progressDrawable = clipDrawable2;
        return clipDrawable2;
    }
}
