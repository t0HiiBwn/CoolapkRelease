package com.coolapk.market.widget;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.AppHolder;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001dJ\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010(\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010)\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010*\u001a\u00020\u001dJ\u0006\u0010+\u001a\u00020\u001dR#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\fR#\u0010\u0015\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0016\u0010\fR\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/widget/BaseAppHeader;", "Lcom/google/android/material/appbar/AppBarLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoElevationAnim", "Landroid/animation/StateListAnimator;", "kotlin.jvm.PlatformType", "getAutoElevationAnim", "()Landroid/animation/StateListAnimator;", "autoElevationAnim$delegate", "Lkotlin/Lazy;", "bottomContainer", "Landroid/widget/FrameLayout;", "centerContainer", "disableElevationAnim", "getDisableElevationAnim", "disableElevationAnim$delegate", "enableElevationAnim", "getEnableElevationAnim", "enableElevationAnim$delegate", "leftContainer", "rightContainer", "topContainer", "Landroid/widget/LinearLayout;", "autoElevation", "", "fixStateListAnimator", "stateListAnimator", "hasBottomView", "", "hideElevation", "initUI", "setBottomView", "view", "Landroid/view/View;", "setCenterView", "setLeftView", "setRightView", "showElevation", "updateScrollFlags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseAppHeader.kt */
public class BaseAppHeader extends AppBarLayout {
    public static final Companion Companion = new Companion(null);
    public static final int SCROLL_FLAG = 7;
    public static final int SCROLL_FLAG_2 = 3;
    private final Lazy autoElevationAnim$delegate;
    private FrameLayout bottomContainer;
    private FrameLayout centerContainer;
    private final Lazy disableElevationAnim$delegate;
    private final Lazy enableElevationAnim$delegate;
    private FrameLayout leftContainer;
    private FrameLayout rightContainer;
    private LinearLayout topContainer;

    private final StateListAnimator getAutoElevationAnim() {
        return (StateListAnimator) this.autoElevationAnim$delegate.getValue();
    }

    private final StateListAnimator getDisableElevationAnim() {
        return (StateListAnimator) this.disableElevationAnim$delegate.getValue();
    }

    private final StateListAnimator getEnableElevationAnim() {
        return (StateListAnimator) this.enableElevationAnim$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseAppHeader(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseAppHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftContainer = new FrameLayout(getContext());
        this.rightContainer = new FrameLayout(getContext());
        this.centerContainer = new FrameLayout(getContext());
        this.topContainer = new LinearLayout(getContext());
        this.bottomContainer = new FrameLayout(getContext());
        this.enableElevationAnim$delegate = LazyKt.lazy(new BaseAppHeader$enableElevationAnim$2(this));
        this.disableElevationAnim$delegate = LazyKt.lazy(new BaseAppHeader$disableElevationAnim$2(this));
        this.autoElevationAnim$delegate = LazyKt.lazy(new BaseAppHeader$autoElevationAnim$2(this));
        initUI();
    }

    private final void initUI() {
        setClickable(true);
        setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setOrientation(1);
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(7);
        Unit unit = Unit.INSTANCE;
        addView(this.topContainer, layoutParams);
        addView(this.bottomContainer, new AppBarLayout.LayoutParams(-1, -2));
        this.topContainer.addView(this.leftContainer, new AppBarLayout.LayoutParams(-2, -2));
        AppBarLayout.LayoutParams layoutParams2 = new AppBarLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        Unit unit2 = Unit.INSTANCE;
        this.topContainer.addView(this.centerContainer, layoutParams2);
        this.topContainer.addView(this.rightContainer, new AppBarLayout.LayoutParams(-2, -2));
    }

    public final void setLeftView(View view) {
        if (this.leftContainer.getChildCount() > 0) {
            this.leftContainer.removeAllViews();
        }
        if (view != null) {
            this.leftContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void setRightView(View view) {
        if (this.rightContainer.getChildCount() > 0) {
            this.rightContainer.removeAllViews();
        }
        if (view != null) {
            this.rightContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void setCenterView(View view) {
        if (this.centerContainer.getChildCount() > 0) {
            this.centerContainer.removeAllViews();
        }
        if (view != null) {
            this.centerContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void setBottomView(View view) {
        if (this.bottomContainer.getChildCount() > 0) {
            this.bottomContainer.removeAllViews();
        }
        if (view != null) {
            this.bottomContainer.addView(view, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    public final void updateScrollFlags() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2.getBehavior() != null) {
            CoordinatorLayout.Behavior behavior = layoutParams2.getBehavior();
            Objects.requireNonNull(behavior, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.Behavior");
            ((AppBarLayout.Behavior) behavior).setTopAndBottomOffset(0);
            setExpanded(true, false);
        }
        if (this.bottomContainer.getChildCount() > 0) {
            LinearLayout linearLayout = this.topContainer;
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
            AppBarLayout.LayoutParams layoutParams4 = (AppBarLayout.LayoutParams) layoutParams3;
            layoutParams4.setScrollFlags(7);
            linearLayout.setLayoutParams(layoutParams4);
            return;
        }
        LinearLayout linearLayout2 = this.topContainer;
        ViewGroup.LayoutParams layoutParams5 = linearLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams6 = (AppBarLayout.LayoutParams) layoutParams5;
        layoutParams6.setScrollFlags(0);
        linearLayout2.setLayoutParams(layoutParams6);
    }

    public final boolean hasBottomView() {
        return this.bottomContainer.getChildCount() > 0;
    }

    public final void showElevation() {
        fixStateListAnimator(getEnableElevationAnim());
    }

    public final void hideElevation() {
        fixStateListAnimator(getDisableElevationAnim());
    }

    public final void autoElevation() {
        fixStateListAnimator(getAutoElevationAnim());
    }

    private final void fixStateListAnimator(StateListAnimator stateListAnimator) {
        if (Build.VERSION.SDK_INT > 21) {
            setStateListAnimator(stateListAnimator);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/BaseAppHeader$Companion;", "", "()V", "SCROLL_FLAG", "", "SCROLL_FLAG_2", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BaseAppHeader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
