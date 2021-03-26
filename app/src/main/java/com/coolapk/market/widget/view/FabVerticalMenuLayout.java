package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J5\u0010\u001e\u001a\u00020\u00152\b\b\u0001\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J.\u0010\u001e\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\"2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\b\u0010'\u001a\u00020\u0012H\u0002J\u001c\u0010(\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0014J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$J-\u00101\u001a\u00020\u00152\b\b\u0001\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u00102J&\u00101\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\"2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u0010\u00103\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u000105R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/coolapk/market/widget/view/FabVerticalMenuLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cardMarginBottomPx", "", "getCardMarginBottomPx", "()I", "setCardMarginBottomPx", "(I)V", "isAnimating", "", "isExpanded", "mainFab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "onDismiss", "Lkotlin/Function0;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "subViews", "Ljava/util/ArrayList;", "Landroid/view/ViewGroup;", "Lkotlin/collections/ArrayList;", "addSubFabInfo", "iconRes", "backgroundColor", "text", "", "clickListener", "Landroid/view/View$OnClickListener;", "(ILjava/lang/Integer;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "iconUrl", "createFabView", "createSubView", "init", "onAttachedToWindow", "removeBackPressListener", "setBackPressToHide", "setCollapsed", "setExpand", "expand", "setFabClickListener", "setFabInfo", "(ILjava/lang/Integer;Landroid/view/View$OnClickListener;)V", "setFabLongClickListener", "longClick", "Landroid/view/View$OnLongClickListener;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FabVerticalMenuLayout.kt */
public final class FabVerticalMenuLayout extends FrameLayout {
    private int cardMarginBottomPx;
    private boolean isAnimating;
    private boolean isExpanded;
    private FloatingActionButton mainFab;
    private Function0<Unit> onDismiss;
    private ArrayList<ViewGroup> subViews;

    public final int getCardMarginBottomPx() {
        return this.cardMarginBottomPx;
    }

    public final void setCardMarginBottomPx(int i) {
        this.cardMarginBottomPx = i;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FabVerticalMenuLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FabVerticalMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subViews = new ArrayList<>();
        init();
    }

    private final void init() {
        setClipChildren(false);
        setClipToPadding(false);
        setOnClickListener(new FabVerticalMenuLayout$init$1(this));
        setClickable(false);
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewExtents2Kt.tryListenWindowsInset(this, new FabVerticalMenuLayout$onAttachedToWindow$1(this));
    }

    private final FloatingActionButton createFabView() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        floatingActionButton.setImageTintList(ColorStateList.valueOf(-1));
        floatingActionButton.setSize(1);
        floatingActionButton.setElevation((float) DisplayUtils.dp2px(floatingActionButton.getContext(), 6.0f));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int dp2px = DisplayUtils.dp2px(getContext(), 16.0f);
        layoutParams.gravity = 85;
        layoutParams.rightMargin = dp2px;
        layoutParams.bottomMargin = dp2px;
        layoutParams.topMargin = dp2px;
        layoutParams.leftMargin = dp2px;
        Unit unit = Unit.INSTANCE;
        addView(floatingActionButton, layoutParams);
        return floatingActionButton;
    }

    static /* synthetic */ ViewGroup createSubView$default(FabVerticalMenuLayout fabVerticalMenuLayout, String str, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        return fabVerticalMenuLayout.createSubView(str, onClickListener);
    }

    private final ViewGroup createSubView(String str, View.OnClickListener onClickListener) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165343);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131165342);
        FabVerticalMenuLayout$createSubView$wrapClickListener$1 fabVerticalMenuLayout$createSubView$wrapClickListener$1 = new FabVerticalMenuLayout$createSubView$wrapClickListener$1(this, onClickListener);
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        floatingActionButton.setImageTintList(ColorStateList.valueOf(-1));
        floatingActionButton.setSize(1);
        floatingActionButton.setElevation((float) DisplayUtils.dp2px(floatingActionButton.getContext(), 4.0f));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        floatingActionButton.setOnClickListener(fabVerticalMenuLayout$createSubView$wrapClickListener$1);
        floatingActionButton.setImportantForAccessibility(2);
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextColor(-1);
        Drawable mutate = ResourceUtils.getDrawable(textView.getContext(), 2131230897).mutate();
        mutate.setTint(ColorUtils.adjustAlpha(textView.getResources().getColor(2131099891), 0.8f));
        textView.setPadding(DisplayUtils.dp2px(textView.getContext(), 4.0f), DisplayUtils.dp2px(textView.getContext(), 2.0f), DisplayUtils.dp2px(textView.getContext(), 4.0f), DisplayUtils.dp2px(textView.getContext(), 2.0f));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(mutate);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = DisplayUtils.dp2px(linearLayout.getContext(), 16.0f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(floatingActionButton, layoutParams);
        linearLayout.setOnClickListener(fabVerticalMenuLayout$createSubView$wrapClickListener$1);
        linearLayout.setVisibility(4);
        int dp2px = DisplayUtils.dp2px(linearLayout.getContext(), 8.0f);
        linearLayout.setPadding(dp2px, dp2px, dp2px, dp2px);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        int dp2px2 = DisplayUtils.dp2px(getContext(), 4.0f);
        layoutParams2.rightMargin = ((dimensionPixelSize - dimensionPixelSize2) / 2) + dp2px2;
        layoutParams2.bottomMargin = dp2px2 + DisplayUtils.dp2px(getContext(), 16.0f);
        Unit unit3 = Unit.INSTANCE;
        addView(linearLayout, layoutParams2);
        this.subViews.add(linearLayout);
        FloatingActionButton floatingActionButton2 = this.mainFab;
        if (floatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        removeView(floatingActionButton2);
        FloatingActionButton floatingActionButton3 = this.mainFab;
        if (floatingActionButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        addView(floatingActionButton3);
        return linearLayout;
    }

    public final void setFabClickListener(View.OnClickListener onClickListener) {
        FloatingActionButton floatingActionButton = this.mainFab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        floatingActionButton.setOnClickListener(new FabVerticalMenuLayout$setFabClickListener$1(this, onClickListener));
    }

    public final void setFabLongClickListener(View.OnLongClickListener onLongClickListener) {
        FloatingActionButton floatingActionButton = this.mainFab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        floatingActionButton.setOnLongClickListener(new FabVerticalMenuLayout$setFabLongClickListener$1(this, onLongClickListener));
    }

    public static /* synthetic */ void setFabInfo$default(FabVerticalMenuLayout fabVerticalMenuLayout, int i, Integer num, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            onClickListener = null;
        }
        fabVerticalMenuLayout.setFabInfo(i, num, onClickListener);
    }

    public final void setFabInfo(int i, Integer num, View.OnClickListener onClickListener) {
        FloatingActionButton createFabView = createFabView();
        this.mainFab = createFabView;
        if (num != null) {
            if (createFabView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainFab");
            }
            createFabView.setBackgroundTintList(ColorStateList.valueOf(num.intValue()));
        }
        FloatingActionButton floatingActionButton = this.mainFab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        floatingActionButton.setImageResource(i);
        setFabClickListener(onClickListener);
    }

    public static /* synthetic */ void setFabInfo$default(FabVerticalMenuLayout fabVerticalMenuLayout, String str, String str2, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            onClickListener = null;
        }
        fabVerticalMenuLayout.setFabInfo(str, str2, onClickListener);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void setFabInfo(String str, String str2, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        FloatingActionButton createFabView = createFabView();
        this.mainFab = createFabView;
        if (createFabView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        createFabView.setScaleType(ImageView.ScaleType.FIT_XY);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165343);
        Field declaredField = FloatingActionButton.class.getDeclaredField("maxImageSize");
        declaredField.setAccessible(true);
        FloatingActionButton floatingActionButton = this.mainFab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        declaredField.setInt(floatingActionButton, dimensionPixelSize);
        if (str2 != null) {
            FloatingActionButton floatingActionButton2 = this.mainFab;
            if (floatingActionButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainFab");
            }
            floatingActionButton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(str2)));
        }
        FloatingActionButton floatingActionButton3 = this.mainFab;
        if (floatingActionButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        GlideImageHelper.setForceToLoad(floatingActionButton3, true);
        FloatingActionButton floatingActionButton4 = this.mainFab;
        if (floatingActionButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        GlideRequest override = GlideApp.with(floatingActionButton4).load(str).override(dimensionPixelSize);
        FloatingActionButton floatingActionButton5 = this.mainFab;
        if (floatingActionButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        override.into(floatingActionButton5);
        setFabClickListener(onClickListener);
    }

    public static /* synthetic */ void addSubFabInfo$default(FabVerticalMenuLayout fabVerticalMenuLayout, int i, Integer num, String str, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            onClickListener = null;
        }
        fabVerticalMenuLayout.addSubFabInfo(i, num, str, onClickListener);
    }

    public final void addSubFabInfo(int i, Integer num, String str, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(str, "text");
        View childAt = createSubView(str, onClickListener).getChildAt(1);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
        if (num != null) {
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(num.intValue()));
        }
        floatingActionButton.setImageResource(i);
    }

    public static /* synthetic */ void addSubFabInfo$default(FabVerticalMenuLayout fabVerticalMenuLayout, String str, String str2, String str3, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            onClickListener = null;
        }
        fabVerticalMenuLayout.addSubFabInfo(str, str2, str3, onClickListener);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void addSubFabInfo(String str, String str2, String str3, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "text");
        View childAt = createSubView(str3, onClickListener).getChildAt(1);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
        floatingActionButton.setScaleType(ImageView.ScaleType.FIT_XY);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165342);
        Field declaredField = FloatingActionButton.class.getDeclaredField("maxImageSize");
        declaredField.setAccessible(true);
        declaredField.setInt(floatingActionButton, dimensionPixelSize);
        if (str2 != null) {
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(str2)));
        }
        FloatingActionButton floatingActionButton2 = this.mainFab;
        if (floatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        GlideImageHelper.setForceToLoad(floatingActionButton2, true);
        GlideApp.with(floatingActionButton).load(str).override(dimensionPixelSize).into(floatingActionButton);
    }

    public final void setExpand(boolean z) {
        if (z != this.isExpanded) {
            if (z) {
                setExpand();
            } else {
                setCollapsed();
            }
        }
    }

    private final void setExpand() {
        this.isExpanded = true;
        this.isAnimating = true;
        int size = this.subViews.size();
        for (int i = 0; i < size; i++) {
            ViewGroup viewGroup = this.subViews.get(i);
            Intrinsics.checkNotNullExpressionValue(viewGroup, "subViews[i]");
            ViewGroup viewGroup2 = viewGroup;
            viewGroup2.setVisibility(0);
            viewGroup2.setAlpha(0.0f);
            FloatingActionButton floatingActionButton = this.mainFab;
            if (floatingActionButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainFab");
            }
            ViewPropertyAnimator duration = viewGroup2.animate().translationY(-((float) (floatingActionButton.getHeight() + (((this.subViews.size() - i) - 1) * viewGroup2.getHeight())))).alpha(1.0f).setDuration(200);
            duration.setListener(new FabVerticalMenuLayout$setExpand$$inlined$apply$lambda$1(viewGroup2));
            duration.start();
        }
        FloatingActionButton floatingActionButton2 = this.mainFab;
        if (floatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        floatingActionButton2.animate().rotation(135.0f).setDuration(200).setListener(new FabVerticalMenuLayout$setExpand$2(this)).start();
        setClickable(true);
        ValueAnimator duration2 = ValueAnimator.ofArgb(0, 838860800).setDuration(200L);
        duration2.addUpdateListener(new FabVerticalMenuLayout$setExpand$$inlined$apply$lambda$2(this));
        duration2.start();
    }

    private final void setCollapsed() {
        this.isExpanded = false;
        this.isAnimating = true;
        int size = this.subViews.size();
        for (int i = 0; i < size; i++) {
            ViewGroup viewGroup = this.subViews.get(i);
            Intrinsics.checkNotNullExpressionValue(viewGroup, "subViews[i]");
            ViewGroup viewGroup2 = viewGroup;
            ViewPropertyAnimator duration = viewGroup2.animate().translationX(0.0f).translationY(0.0f).alpha(0.0f).setDuration(200);
            duration.setListener(new FabVerticalMenuLayout$setCollapsed$$inlined$apply$lambda$1(this, viewGroup2));
            duration.start();
        }
        FloatingActionButton floatingActionButton = this.mainFab;
        if (floatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFab");
        }
        floatingActionButton.animate().rotation(0.0f).setDuration(200).setListener(new FabVerticalMenuLayout$setCollapsed$2(this)).start();
        ValueAnimator duration2 = ValueAnimator.ofArgb(838860800, 0).setDuration(200L);
        duration2.addUpdateListener(new FabVerticalMenuLayout$setCollapsed$$inlined$apply$lambda$2(this));
        duration2.addListener(new FabVerticalMenuLayout$setCollapsed$$inlined$apply$lambda$3(this));
        duration2.start();
        removeBackPressListener();
    }

    /* access modifiers changed from: private */
    public final void setBackPressToHide() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            baseActivity.setOnBackPressListener(new FabVerticalMenuLayout$setBackPressToHide$1(this));
        }
    }

    private final void removeBackPressListener() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            baseActivity.setOnBackPressListener(null);
        }
    }
}
