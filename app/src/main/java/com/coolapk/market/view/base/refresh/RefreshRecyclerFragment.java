package com.coolapk.market.view.base.refresh;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.RefreshRecyclerBinding;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.OnLoadMoreListener;
import com.coolapk.market.widget.NavigationClipViewHelper;

public abstract class RefreshRecyclerFragment extends BaseFragment implements ScrollableFragment {
    private boolean autoUpdateContentUiOnDataChanged;
    private RefreshRecyclerBinding binding;
    private boolean loadMoreEnable = true;
    private View.OnClickListener onEmptyViewClickListener = onEmptyViewClickListener();
    private Runnable refreshRunnable;
    private RefreshRecyclerViewModel viewModel;

    protected abstract void onEmptyViewClick();

    protected abstract void onLoadMore();

    protected abstract void onRefresh();

    protected abstract boolean shouldShowEmptyView();

    protected abstract boolean shouldShowList();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.viewModel = new RefreshRecyclerViewModel(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RefreshRecyclerBinding inflate = RefreshRecyclerBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        ViewUtil.clickListener(inflate.emptyView, this.onEmptyViewClickListener);
        this.binding.recyclerView.addOnScrollListener(onScrollListener());
        this.binding.recyclerView.getItemAnimator().setChangeDuration(0);
        this.binding.recyclerView.getItemAnimator().setMoveDuration(0);
        this.binding.recyclerView.getItemAnimator().setAddDuration(0);
        this.binding.recyclerView.getItemAnimator().setRemoveDuration(0);
        this.binding.swipeRefreshView.setOnRefreshListener(onRefreshListener());
        this.binding.swipeRefreshView.setDistanceToTriggerSync(DisplayUtils.dp2px(getActivity(), 96.0f));
        TintHelper.setTint(this.binding.loadingView, AppHolder.getAppTheme().getColorAccent());
        new NavigationClipViewHelper(this.binding.recyclerView).adapterToNavigationBar();
        this.binding.swipeRefreshView.setColorSchemeColors(AppHolder.getAppTheme().getColorAccent());
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.binding.setViewModel(this.viewModel);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.binding.recyclerView.setLayoutManager(layoutManager);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.binding.recyclerView.setAdapter(adapter);
        adapter.registerAdapterDataObserver(adapterDataObserver());
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.binding.recyclerView.addItemDecoration(itemDecoration);
    }

    public void setEmptyData(String str, int i) {
        this.viewModel.setEmptyData(str, i);
    }

    public RecyclerView getRecyclerView() {
        return this.binding.recyclerView;
    }

    public View getEmptyView() {
        return this.binding.emptyView;
    }

    public View getLoadingView() {
        return this.binding.loadingView;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return this.binding.swipeRefreshView;
    }

    public void setViewModel(RefreshRecyclerViewModel refreshRecyclerViewModel) {
        this.viewModel = refreshRecyclerViewModel;
    }

    public void updateContentUI() {
        this.viewModel.showContent(shouldShowList());
        this.viewModel.showEmptyView(shouldShowEmptyView());
    }

    public void setLoading(boolean z) {
        this.viewModel.setLoading(z);
    }

    public void setRefreshEnable(boolean z) {
        getSwipeRefreshLayout().setEnabled(z);
    }

    public void setAutoUpdateContentUiOnDataChanged(boolean z) {
        this.autoUpdateContentUiOnDataChanged = z;
    }

    public void setLoadMoreEnable(boolean z) {
        this.loadMoreEnable = z;
    }

    public boolean getLoadMoreEnable() {
        return this.loadMoreEnable;
    }

    private View.OnClickListener onEmptyViewClickListener() {
        return new View.OnClickListener() {
            /* class com.coolapk.market.view.base.refresh.RefreshRecyclerFragment.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefreshRecyclerFragment.this.onEmptyViewClick();
            }
        };
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            /* class com.coolapk.market.view.base.refresh.RefreshRecyclerFragment.AnonymousClass2 */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RefreshRecyclerFragment.this.onRefresh();
            }
        };
    }

    private RecyclerView.OnScrollListener onScrollListener() {
        return new OnLoadMoreListener() {
            /* class com.coolapk.market.view.base.refresh.RefreshRecyclerFragment.AnonymousClass3 */

            @Override // com.coolapk.market.view.base.OnLoadMoreListener
            protected void onLoadMore(int i) {
                if (RefreshRecyclerFragment.this.loadMoreEnable) {
                    RefreshRecyclerFragment.this.onLoadMore();
                }
            }
        };
    }

    @Override // com.coolapk.market.view.base.refresh.ScrollableFragment
    public void scrollToTop(boolean z) {
        if (getRecyclerView() != null && getRecyclerView().isShown()) {
            if (z) {
                UiUtils.fastScrollToTop(getRecyclerView());
            } else {
                getRecyclerView().smoothScrollToPosition(0);
            }
            startDelayRefresh(null);
        }
    }

    public void startDelayRefresh(final Runnable runnable) {
        if (this.binding.swipeRefreshView.isEnabled() && !this.binding.swipeRefreshView.isRefreshing() && !this.binding.loadingView.isShown()) {
            this.binding.swipeRefreshView.setRefreshing(true);
            if (this.refreshRunnable == null) {
                this.refreshRunnable = new RefreshRunnable(new Runnable() {
                    /* class com.coolapk.market.view.base.refresh.RefreshRecyclerFragment.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        RefreshRecyclerFragment.this.refreshRunnable = null;
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
            }
            this.binding.swipeRefreshView.postDelayed(this.refreshRunnable, 800);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        RefreshRecyclerBinding refreshRecyclerBinding;
        super.onDestroy();
        if (!(this.refreshRunnable == null || (refreshRecyclerBinding = this.binding) == null)) {
            refreshRecyclerBinding.swipeRefreshView.removeCallbacks(this.refreshRunnable);
        }
        this.refreshRunnable = null;
    }

    private RecyclerView.AdapterDataObserver adapterDataObserver() {
        return new RecyclerView.AdapterDataObserver() {
            /* class com.coolapk.market.view.base.refresh.RefreshRecyclerFragment.AnonymousClass5 */

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                if (RefreshRecyclerFragment.this.autoUpdateContentUiOnDataChanged) {
                    RefreshRecyclerFragment.this.updateContentUI();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                if (RefreshRecyclerFragment.this.autoUpdateContentUiOnDataChanged) {
                    RefreshRecyclerFragment.this.updateContentUI();
                }
            }
        };
    }

    private class RefreshRunnable implements Runnable {
        private Runnable callback;

        public RefreshRunnable(Runnable runnable) {
            this.callback = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            RefreshRecyclerFragment.this.onRefresh();
            Runnable runnable = this.callback;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
