package com.coolapk.market.view.base.asynclist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.widget.AdapterListChangedCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class AsyncListFragment<RESULT, DATA extends Parcelable> extends RefreshRecyclerFragment implements AsyncListContract.View<RESULT>, InitBehavior {
    private static final long DEFAULT_EXPIRED_TIME = 300000;
    private static final String KEY_DATA = "DATA";
    private static final String KEY_DATA_EXPIRED_TIME_PREFIX = "DATA_EXPIRED_TIME_";
    private boolean checkDataExpired;
    public final ObservableArrayList<DATA> dataList = new ObservableArrayList<>();
    private long expiredTime;
    private ObservableList.OnListChangedCallback onListChangeCallback;
    private AsyncListContract.Presenter presenter;

    protected abstract void onRequestFailure(boolean z, Throwable th);

    protected abstract boolean onRequestResponse(boolean z, RESULT result);

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886765), 0);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
        if (this.presenter == null) {
            LogUtils.e(new RuntimeException("Did you invoke setPresenter()? activity: " + getActivity().getClass().getName()));
        }
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.onInitPresenterState(bundle);
            if (!this.presenter.isDataLoaded()) {
                setLoading(true);
            }
        }
        updateContentUI();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onListChangeCallback == null) {
            throw new RuntimeException("Did you invoke setAdapter()?");
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.cancelLoadData();
        }
        this.dataList.removeOnListChangedCallback(this.onListChangeCallback);
        this.onListChangeCallback = null;
        super.onDestroyView();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (this.onListChangeCallback == null) {
            AdapterListChangedCallback adapterListChangedCallback = new AdapterListChangedCallback(adapter);
            this.onListChangeCallback = adapterListChangedCallback;
            this.dataList.addOnListChangedCallback(adapterListChangedCallback);
        }
    }

    public void setNotifyAdapter(boolean z) {
        ObservableList.OnListChangedCallback onListChangedCallback;
        this.dataList.removeOnListChangedCallback(this.onListChangeCallback);
        if (z && (onListChangedCallback = this.onListChangeCallback) != null) {
            this.dataList.addOnListChangedCallback(onListChangedCallback);
        }
    }

    public void setPresenter(AsyncListContract.Presenter presenter2) {
        this.presenter = presenter2;
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
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.initData(isDataExpired());
        }
    }

    public void reloadData() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.reloadData();
        }
    }

    public void setPage(int i) {
        this.presenter.setPage(i);
    }

    public boolean isDataLoaded() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            return presenter2.isDataLoaded();
        }
        return false;
    }

    public void loadMore() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.loadMore();
        }
    }

    public List<DATA> getDataList() {
        return this.dataList;
    }

    public DATA getFirstData() {
        if (this.dataList.isEmpty()) {
            return null;
        }
        return (DATA) ((Parcelable) this.dataList.get(0));
    }

    public DATA getLastData() {
        if (this.dataList.isEmpty()) {
            return null;
        }
        ObservableArrayList<DATA> observableArrayList = this.dataList;
        return (DATA) ((Parcelable) observableArrayList.get(observableArrayList.size() - 1));
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        AsyncListContract.Presenter presenter2;
        return getDataList().isEmpty() && (!getRecyclerView().isShown() || ((presenter2 = this.presenter) != null && presenter2.isDataLoaded()));
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.initData(true);
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        AsyncListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.reloadData();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        loadMore();
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.View
    public void onLoadDataStart(boolean z, boolean z2) {
        if (z && z2) {
            setLoading(true);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.View
    public void onLoadDataReset(boolean z, boolean z2, int i) {
        if (!z) {
            return;
        }
        if (z2) {
            setLoading(false);
        } else {
            getSwipeRefreshLayout().setRefreshing(false);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.View
    public boolean onLoadDataSuccess(boolean z, boolean z2, int i, RESULT result) {
        if (z) {
            if (z2) {
                setLoading(false);
            } else {
                getSwipeRefreshLayout().setRefreshing(false);
            }
        }
        markDataExpireTime();
        return onRequestResponse(z, result);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.View
    public void onLoadDataFailed(boolean z, boolean z2, int i, Throwable th) {
        if (z) {
            if (z2) {
                setLoading(false);
            } else {
                getSwipeRefreshLayout().setRefreshing(false);
            }
        }
        updateContentUI();
        onRequestFailure(z, th);
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
