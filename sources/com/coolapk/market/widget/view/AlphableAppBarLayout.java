package com.coolapk.market.widget.view;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ColorUtils;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/widget/view/AlphableAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/ValueAnimator;", "behindAppBarContentLight", "", "<set-?>", "", "bgAlpha", "getBgAlpha", "()F", "disableAnimator", "Landroid/animation/StateListAnimator;", "kotlin.jvm.PlatformType", "enableAnimator", "lightAnimator", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "onFinishInflate", "", "setBackgroundAlpha", "alpha", "setBehindAppBarContentLight", "isLight", "setElevationVisible", "visible", "setLightElevation", "setToolbarTitle", "title", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlphableAppBarLayout.kt */
public final class AlphableAppBarLayout extends AppBarLayout {
    private ValueAnimator animator;
    private boolean behindAppBarContentLight;
    private float bgAlpha = -1.0f;
    private final StateListAnimator disableAnimator;
    private final StateListAnimator enableAnimator = AnimatorInflater.loadStateListAnimator(getContext(), 2130837511);
    private final StateListAnimator lightAnimator = AnimatorInflater.loadStateListAnimator(getContext(), 2130837513);
    private Toolbar toolbar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlphableAppBarLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(getContext(), 2130837510);
        this.disableAnimator = loadStateListAnimator;
        setStateListAnimator(loadStateListAnimator);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlphableAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(getContext(), 2130837510);
        this.disableAnimator = loadStateListAnimator;
        setStateListAnimator(loadStateListAnimator);
    }

    public final float getBgAlpha() {
        return this.bgAlpha;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Toolbar) {
                this.toolbar = (Toolbar) childAt;
                return;
            }
        }
    }

    public final void setBackgroundAlpha(float f) {
        boolean z = true;
        if (f == this.bgAlpha || f < ((float) 0)) {
            if (f != 1.0f) {
                z = false;
            }
            setElevationVisible(z);
            return;
        }
        this.bgAlpha = f;
        setBackgroundColor(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorPrimary(), f));
        if (f != 1.0f) {
            z = false;
        }
        setElevationVisible(z);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            ViewExtendsKt.adjustTintColorByAlpha(toolbar2, f, this.behindAppBarContentLight);
        }
    }

    public final void setBehindAppBarContentLight(boolean z) {
        this.behindAppBarContentLight = z;
    }

    public final void setElevationVisible(boolean z) {
        if (Build.VERSION.SDK_INT > 21) {
            if (z && (!Intrinsics.areEqual(getStateListAnimator(), this.enableAnimator))) {
                setStateListAnimator(this.enableAnimator);
            } else if (!z && (!Intrinsics.areEqual(getStateListAnimator(), this.disableAnimator))) {
                setStateListAnimator(this.disableAnimator);
            }
        }
    }

    public final void setToolbarTitle(String str) {
        String obj;
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            String str2 = str;
            boolean z = false;
            String str3 = "";
            if (str2 == null || StringsKt.isBlank(str2)) {
                str = " ";
            } else if (str == null) {
                str = str3;
            }
            CharSequence title = toolbar2.getTitle();
            if (title == null || StringsKt.isBlank(title)) {
                z = true;
            }
            if (!z && (obj = toolbar2.getTitle().toString()) != null) {
                str3 = obj;
            }
            if (!Intrinsics.areEqual(str, str3)) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimator2 = new ValueAnimator();
                if (StringsKt.isBlank(str)) {
                    valueAnimator2.setFloatValues(1.0f, 0.0f);
                    valueAnimator2.addListener(new AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$1(str, toolbar2));
                } else {
                    valueAnimator2.setFloatValues(0.0f, 1.0f);
                    valueAnimator2.addListener(new AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$2(str, toolbar2));
                }
                valueAnimator2.setDuration(100L);
                valueAnimator2.addUpdateListener(new AlphableAppBarLayout$setToolbarTitle$$inlined$apply$lambda$3(str, toolbar2));
                Unit unit = Unit.INSTANCE;
                this.animator = valueAnimator2;
                if (valueAnimator2 != null) {
                    valueAnimator2.start();
                }
            }
        }
    }

    public final void setLightElevation() {
        if (Build.VERSION.SDK_INT > 21 && (!Intrinsics.areEqual(getStateListAnimator(), this.lightAnimator))) {
            setStateListAnimator(this.lightAnimator);
        }
    }
}
