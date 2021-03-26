package com.coolapk.market.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.RvInFragmentLayoutBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/main/DataListFallConvert;", "", "fragment", "Lcom/coolapk/market/view/main/DataListFragment;", "(Lcom/coolapk/market/view/main/DataListFragment;)V", "binding", "Lcom/coolapk/market/databinding/RvInFragmentLayoutBinding;", "getFragment", "()Lcom/coolapk/market/view/main/DataListFragment;", "isFallInitialized", "", "()Z", "convertToFlexLayout", "", "flexUrl", "", "convertToFlexLayoutStep1", "convertToFlexStep2ParseFlexUrl", "dispatchScrollToTop", "fastScroll", "obtainBinding", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListFallConvert.kt */
public final class DataListFallConvert {
    private RvInFragmentLayoutBinding binding;
    private final DataListFragment fragment;

    public DataListFallConvert(DataListFragment dataListFragment) {
        Intrinsics.checkNotNullParameter(dataListFragment, "fragment");
        this.fragment = dataListFragment;
    }

    public static final /* synthetic */ RvInFragmentLayoutBinding access$getBinding$p(DataListFallConvert dataListFallConvert) {
        RvInFragmentLayoutBinding rvInFragmentLayoutBinding = dataListFallConvert.binding;
        if (rvInFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return rvInFragmentLayoutBinding;
    }

    public final DataListFragment getFragment() {
        return this.fragment;
    }

    public final boolean isFallInitialized() {
        return this.binding != null;
    }

    public final RvInFragmentLayoutBinding obtainBinding() {
        if (!isFallInitialized()) {
            return null;
        }
        RvInFragmentLayoutBinding rvInFragmentLayoutBinding = this.binding;
        if (rvInFragmentLayoutBinding != null) {
            return rvInFragmentLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return rvInFragmentLayoutBinding;
    }

    public final void convertToFlexLayout(String str) {
        Intrinsics.checkNotNullParameter(str, "flexUrl");
        convertToFlexLayoutStep1();
        convertToFlexStep2ParseFlexUrl(str);
    }

    private final void convertToFlexLayoutStep1() {
        if (!isFallInitialized()) {
            DataListFragment dataListFragment = this.fragment;
            dataListFragment.setLoadMoreEnable(false);
            dataListFragment.setRefreshEnable(false);
            SwipeRefreshLayout swipeRefreshLayout = dataListFragment.getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            ViewExtendsKt.detachFromParent(swipeRefreshLayout);
            RecyclerView recyclerView = dataListFragment.getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
            ViewExtendsKt.detachFromParent(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            Intrinsics.checkNotNullExpressionValue(layoutManager, "layoutManager!!");
            layoutManager.setAutoMeasureEnabled(true);
            recyclerView.setHasFixedSize(true);
            View view = this.fragment.getView();
            AppBarLayout.LayoutParams layoutParams = null;
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                RecyclerView recyclerView2 = this.fragment.getRecyclerView();
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(frameLayout.getContext()), 2131559118, frameLayout, false, new FragmentBindingComponent(this.fragment));
                Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(fragment))");
                RvInFragmentLayoutBinding rvInFragmentLayoutBinding = (RvInFragmentLayoutBinding) inflate;
                this.binding = rvInFragmentLayoutBinding;
                if (rvInFragmentLayoutBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                rvInFragmentLayoutBinding.appBar.addView(recyclerView2, 0);
                if (recyclerView2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = recyclerView2.getLayoutParams();
                    if (layoutParams2 instanceof AppBarLayout.LayoutParams) {
                        layoutParams = layoutParams2;
                    }
                    AppBarLayout.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = -2;
                        layoutParams3.setScrollFlags(3);
                    }
                    recyclerView2.setPadding(0, 0, 0, 0);
                }
                View emptyView = this.fragment.getEmptyView();
                int indexOfChild = frameLayout.indexOfChild(emptyView);
                Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
                ViewExtendsKt.detachFromParent(emptyView);
                RvInFragmentLayoutBinding rvInFragmentLayoutBinding2 = this.binding;
                if (rvInFragmentLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                frameLayout.addView(rvInFragmentLayoutBinding2.getRoot(), indexOfChild);
            }
        }
    }

    private final void convertToFlexStep2ParseFlexUrl(String str) {
        FallsListFragment newInstance = FallsListFragment.Companion.newInstance(str, "", "");
        RvInFragmentLayoutBinding rvInFragmentLayoutBinding = this.binding;
        if (rvInFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = rvInFragmentLayoutBinding.contentFragment;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentFragment");
        int id = frameLayout.getId();
        FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        if (childFragmentManager.findFragmentById(id) != null) {
            childFragmentManager.beginTransaction().replace(id, newInstance).commitAllowingStateLoss();
        } else {
            childFragmentManager.beginTransaction().add(id, newInstance).commitAllowingStateLoss();
        }
    }

    public final void dispatchScrollToTop(boolean z) {
        if (isFallInitialized()) {
            FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            RvInFragmentLayoutBinding rvInFragmentLayoutBinding = this.binding;
            if (rvInFragmentLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = rvInFragmentLayoutBinding.contentFragment;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentFragment");
            Fragment findFragmentById = childFragmentManager.findFragmentById(frameLayout.getId());
            if (findFragmentById instanceof FallsListFragment) {
                ((FallsListFragment) findFragmentById).scrollToTop(true);
            }
        }
    }
}
