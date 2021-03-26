package com.coolapk.market.view.base.asynclist;

import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.view.base.BaseView;
import rx.Observable;

public class NewAsyncListContract {

    public interface Presenter<T> extends BasePresenter {
        void cancelLoadData();

        int getPage();

        void initData(boolean z, boolean z2);

        boolean isDataLoaded();

        boolean isLoadingMore();

        boolean isRefreshing();

        void loadMore();

        void loadMore(boolean z);

        void reloadData(boolean z);

        void setExtraRequestProvider(RequestProvider<T> requestProvider);

        void setPage(int i);

        void setStopLoadMore(boolean z);
    }

    public interface RequestProvider<T> {
        Observable<T> createRequest(boolean z, int i);
    }

    public interface View<T> extends BaseView {
        Observable<T> onCreateRequest(boolean z, int i);

        void onLoadDataFailed(boolean z, boolean z2, int i, Throwable th);

        void onLoadDataReset(boolean z, boolean z2, int i);

        void onLoadDataStart(boolean z, boolean z2);

        boolean onLoadDataSuccess(boolean z, boolean z2, int i, T t);
    }
}
