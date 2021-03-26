package com.coolapk.market.view.base.asynclist;

import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;

public interface AsyncListContract {

    public interface Presenter extends BasePresenter {
        void cancelLoadData();

        int getPage();

        void initData(boolean z);

        boolean isDataLoaded();

        boolean isLoadingMore();

        boolean isRefreshing();

        void loadMore();

        void reloadData();

        void setPage(int i);
    }

    public interface View<T> extends BaseView {
        void onLoadDataFailed(boolean z, boolean z2, int i, Throwable th);

        void onLoadDataReset(boolean z, boolean z2, int i);

        void onLoadDataStart(boolean z, boolean z2);

        boolean onLoadDataSuccess(boolean z, boolean z2, int i, T t);
    }
}
