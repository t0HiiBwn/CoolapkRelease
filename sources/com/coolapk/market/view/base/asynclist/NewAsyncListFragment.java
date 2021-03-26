package com.coolapk.market.view.base.asynclist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.preference.PreferenceManager;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.view.base.asynclist.NewAsyncListContract;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;

public abstract class NewAsyncListFragment<T> extends RefreshRecyclerFragment implements NewAsyncListContract.View<T>, InitBehavior {
    private static final long DEFAULT_EXPIRED_TIME = 300000;
    private static final String KEY_DATA_EXPIRED_TIME_PREFIX = "DATA_EXPIRED_TIME_";
    private boolean checkDataExpired;
    private long expiredTime;
    private NewAsyncListContract.Presenter<T> presenter;

    protected abstract void onRequestFailure(boolean z, Throwable th);

    protected abstract boolean onRequestResponse(boolean z, T t);

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NewAsyncListPresenter newAsyncListPresenter = new NewAsyncListPresenter(this);
        this.presenter = newAsyncListPresenter;
        newAsyncListPresenter.onInitPresenterState(bundle);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886765), 0);
        if (!this.presenter.isDataLoaded()) {
            setLoading(true);
        }
        updateContentUI();
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        NewAsyncListContract.Presenter<T> presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.presenter.cancelLoadData();
        super.onDestroyView();
    }

    public final void setCheckDataExpired(boolean z, long j) {
        this.checkDataExpired = z;
        if (j <= 0) {
            j = 300000;
        }
        this.expiredTime = j;
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        initData(isDataExpired(), true);
    }

    public void initData(boolean z, boolean z2) {
        this.presenter.initData(z, z2);
    }

    public void reloadData() {
        reloadData(false);
    }

    public void reloadData(boolean z) {
        this.presenter.reloadData(z);
    }

    public void setPage(int i) {
        this.presenter.setPage(i);
    }

    public void setStopLoadMore(boolean z) {
        this.presenter.setStopLoadMore(z);
    }

    public boolean isDataLoaded() {
        return this.presenter.isDataLoaded();
    }

    public void loadMore() {
        this.presenter.loadMore();
    }

    public void loadMore(boolean z) {
        this.presenter.loadMore(z);
    }

    public boolean isLoadingMore() {
        return this.presenter.isLoadingMore();
    }

    public boolean isRefreshing() {
        return this.presenter.isRefreshing();
    }

    public void cancelLoadData() {
        this.presenter.cancelLoadData();
    }

    public int getPage() {
        return this.presenter.getPage();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return getRecyclerView().getAdapter() != null && getRecyclerView().getAdapter().getItemCount() == 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
        this.presenter.reloadData(true);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        this.presenter.reloadData(false);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        this.presenter.loadMore();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public void onLoadDataStart(boolean z, boolean z2) {
        updateContentUI();
        setLoading(z2);
    }

    public void setExtraRequestProvider(NewAsyncListContract.RequestProvider<T> requestProvider) {
        this.presenter.setExtraRequestProvider(requestProvider);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public boolean onLoadDataSuccess(boolean z, boolean z2, int i, T t) {
        if (z) {
            resetRefreshing(z2);
        } else if (z2) {
            setLoading(false);
        }
        markDataExpireTime();
        return onRequestResponse(z, t);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public void onLoadDataFailed(boolean z, boolean z2, int i, Throwable th) {
        if (z) {
            resetRefreshing(z2);
        } else if (z2) {
            setLoading(false);
        }
        updateContentUI();
        onRequestFailure(z, th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public void onLoadDataReset(boolean z, boolean z2, int i) {
        if (z) {
            resetRefreshing(z2);
        } else if (z2) {
            setLoading(false);
        }
    }

    private void resetRefreshing(boolean z) {
        if (z) {
            setLoading(false);
        } else {
            getSwipeRefreshLayout().setRefreshing(false);
        }
    }

    private void markDataExpireTime() {
        if (this.checkDataExpired) {
            PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putLong("DATA_EXPIRED_TIME_" + getClass().getName(), SystemClock.elapsedRealtime() + this.expiredTime).apply();
        }
    }

    private boolean isDataExpired() {
        if (!this.checkDataExpired) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (defaultSharedPreferences.getLong("DATA_EXPIRED_TIME_" + getClass().getName(), 0) < SystemClock.elapsedRealtime()) {
            return true;
        }
        return false;
    }
}
