package com.coolapk.market.view.main;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslucentHeaderConverter.kt */
public final class TranslucentHeaderConverter {
    private final EntityListFragment fragment;
    private final List<RecyclerView.OnScrollListener> scrollListeners = new ArrayList();

    public TranslucentHeaderConverter(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    private final FragmentActivity getActivity() {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return requireActivity;
    }

    public final boolean getShouldHandleHeader() {
        return (this.fragment.requireActivity() instanceof AlphableToolbar) && !(this.fragment.getParentFragment() instanceof ConvertViewPagerFragment);
    }

    public final int getHeaderRange() {
        return UiUtils.getStatusBarHeight(getActivity()) + UiUtils.getActionBarSize(getActivity());
    }

    public static /* synthetic */ void resetToolbarHeader$default(TranslucentHeaderConverter translucentHeaderConverter, boolean z, String str, DataListViewPagerConverter dataListViewPagerConverter, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = !translucentHeaderConverter.fragment.getDataList().isEmpty();
        }
        translucentHeaderConverter.resetToolbarHeader(z, str, dataListViewPagerConverter, z2);
    }

    public final void resetToolbarHeader(boolean z, String str, DataListViewPagerConverter dataListViewPagerConverter, boolean z2) {
        ViewGroup.MarginLayoutParams marginParams;
        ViewGroup.MarginLayoutParams marginParams2;
        if (getShouldHandleHeader()) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.AlphableToolbar");
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            RecyclerView recyclerView = this.fragment.getRecyclerView();
            View view = this.fragment.getView();
            for (RecyclerView.OnScrollListener onScrollListener : this.scrollListeners) {
                recyclerView.removeOnScrollListener(onScrollListener);
            }
            this.scrollListeners.clear();
            if (z) {
                alphableToolbar.setToolbarAlpha(0.0f);
                alphableToolbar.setToolbarTitle(null);
                if (!(view == null || (marginParams2 = ViewExtendsKt.getMarginParams(view)) == null)) {
                    marginParams2.topMargin = 0;
                }
                if (view != null) {
                    view.requestLayout();
                }
                compatScrollWithTitleVisible(str, dataListViewPagerConverter);
                return;
            }
            alphableToolbar.setToolbarAlpha(1.0f);
            alphableToolbar.setToolbarTitle(str);
            if (!(view == null || (marginParams = ViewExtendsKt.getMarginParams(view)) == null)) {
                marginParams.topMargin = getHeaderRange();
            }
            if (view != null) {
                view.requestLayout();
            }
            compatDefaultWithViewPagerConverter(!z2, dataListViewPagerConverter);
        }
    }

    private final void compatScrollWithTitleVisible(String str, DataListViewPagerConverter dataListViewPagerConverter) {
        RefreshRecyclerTabsBinding obtainTabBinding = dataListViewPagerConverter != null ? dataListViewPagerConverter.obtainTabBinding() : null;
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.AlphableToolbar");
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        RecyclerView recyclerView = this.fragment.getRecyclerView();
        if (obtainTabBinding != null) {
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setMinimumHeight(getHeaderRange());
            obtainTabBinding.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new TranslucentHeaderConverter$compatScrollWithTitleVisible$1(this, alphableToolbar, str, obtainTabBinding));
            return;
        }
        this.scrollListeners.add(new RecyclerScrollHeaderListener(getHeaderRange(), new TranslucentHeaderConverter$compatScrollWithTitleVisible$2(alphableToolbar)));
        this.scrollListeners.add(new RecyclerScrollHeaderListener(getHeaderRange(), new TranslucentHeaderConverter$compatScrollWithTitleVisible$3(alphableToolbar, str)));
        for (RecyclerView.OnScrollListener onScrollListener : this.scrollListeners) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    private final void compatDefaultWithViewPagerConverter(boolean z, DataListViewPagerConverter dataListViewPagerConverter) {
        RefreshRecyclerTabsBinding obtainTabBinding;
        ViewGroup.MarginLayoutParams marginParams;
        if (dataListViewPagerConverter != null && (obtainTabBinding = dataListViewPagerConverter.obtainTabBinding()) != null) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.AlphableToolbar");
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            View view = this.fragment.getView();
            if (z) {
                View view2 = obtainTabBinding.divider;
                Intrinsics.checkNotNullExpressionValue(view2, "tabBinding.divider");
                view2.setVisibility(8);
                if (!(alphableToolbar instanceof AlphaToolbarActivity)) {
                    alphableToolbar = null;
                }
                AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) alphableToolbar;
                if (alphaToolbarActivity != null) {
                    alphaToolbarActivity.setToolbarElevationVisible(false);
                }
                View findFirstChildViewByType = UiUtils.findFirstChildViewByType(UiUtils.getContentView(getActivity()), Toolbar.class);
                if (findFirstChildViewByType != null) {
                    Toolbar toolbar = (Toolbar) findFirstChildViewByType;
                    Toolbar toolbar2 = toolbar;
                    ViewExtendsKt.detachFromParent(toolbar2);
                    obtainTabBinding.appBar.addView(toolbar2, 0);
                    ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (!(layoutParams instanceof AppBarLayout.LayoutParams)) {
                        layoutParams = null;
                    }
                    AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.setScrollFlags(19);
                    }
                    toolbar.requestLayout();
                    toolbar.setMinimumHeight(0);
                    if (!(view == null || (marginParams = ViewExtendsKt.getMarginParams(view)) == null)) {
                        marginParams.topMargin = UiUtils.getStatusBarHeight(getActivity());
                    }
                    if (view != null) {
                        view.requestLayout();
                    }
                    FrameLayout frameLayout = obtainTabBinding.tabContainer;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "tabBinding.tabContainer");
                    frameLayout.setBackground(null);
                    obtainTabBinding.appBar.setBackgroundColor(AppHolder.getAppTheme().getColorPrimary());
                    if (Build.VERSION.SDK_INT > 21) {
                        StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(getActivity(), 2130837511);
                        AppBarLayout appBarLayout = obtainTabBinding.appBar;
                        Intrinsics.checkNotNullExpressionValue(appBarLayout, "tabBinding.appBar");
                        appBarLayout.setStateListAnimator(loadStateListAnimator);
                    }
                    TabLayout tabLayout = obtainTabBinding.tabs;
                    Intrinsics.checkNotNullExpressionValue(tabLayout, "tabBinding.tabs");
                    ViewExtendsKt.setV9TabColor(tabLayout, true);
                    return;
                }
                return;
            }
            obtainTabBinding.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new TranslucentHeaderConverter$compatDefaultWithViewPagerConverter$3(alphableToolbar, obtainTabBinding));
        }
    }
}
