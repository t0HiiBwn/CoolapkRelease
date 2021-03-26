package com.coolapk.market.view.base.asynclist;

import android.os.Bundle;
import com.coolapk.market.util.CommonUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListContract;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public class NewAsyncListPresenter<T> implements NewAsyncListContract.Presenter<T> {
    private static final String KEY_IS_DATA_LOADED = "NewAsyncListPresenter.IS_DATA_LOADED";
    private static final String KEY_PAGE = "NewAsyncListPresenter.PAGE";
    private static final String KEY_STOP_LOAD_MORE = "NewAsyncListPresenter.STOP_LOAD_MORE";
    private static final int STATE_IDLE = 0;
    private static final int STATE_LOADING_MORE = 2;
    private static final int STATE_REFRESHING = 1;
    private static final String TAG = "NewAsyncListPresenter";
    private NewAsyncListContract.RequestProvider<T> extraProvider;
    private boolean isDataLoaded = false;
    private AtomicInteger pageCounter = new AtomicInteger(1);
    private int state = 0;
    private boolean stopLoadMore = false;
    private Subscription subscription;
    private NewAsyncListContract.View<T> view;

    public NewAsyncListPresenter(NewAsyncListContract.View<T> view2) {
        this.view = (NewAsyncListContract.View) CommonUtils.checkNotNull(view2);
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.stopLoadMore = bundle.getBoolean("NewAsyncListPresenter.STOP_LOAD_MORE");
            this.isDataLoaded = bundle.getBoolean("NewAsyncListPresenter.IS_DATA_LOADED");
            this.pageCounter = new AtomicInteger(bundle.getInt("NewAsyncListPresenter.PAGE", 1));
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void setExtraRequestProvider(NewAsyncListContract.RequestProvider<T> requestProvider) {
        this.extraProvider = requestProvider;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("NewAsyncListPresenter.STOP_LOAD_MORE", this.stopLoadMore);
        bundle.putBoolean("NewAsyncListPresenter.IS_DATA_LOADED", this.isDataLoaded);
        bundle.putInt("NewAsyncListPresenter.PAGE", this.pageCounter.get());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void initData(boolean z, boolean z2) {
        if (isRefreshing() && !z) {
            return;
        }
        if (!isDataLoaded()) {
            loadData(true, z2, 1);
        } else if (z) {
            loadData(true, z2, 1);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void reloadData(boolean z) {
        loadData(true, z, 1);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void loadMore() {
        loadMore(false);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void loadMore(boolean z) {
        if (!this.stopLoadMore && !isLoadingMore()) {
            loadData(false, z, this.pageCounter.get());
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void cancelLoadData() {
        RxUtils.unsubscribe(this.subscription);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public boolean isDataLoaded() {
        return this.isDataLoaded;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public boolean isRefreshing() {
        return this.state == 1;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public boolean isLoadingMore() {
        return this.state == 2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void setPage(int i) {
        this.pageCounter.set(i);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public int getPage() {
        return this.pageCounter.get();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.Presenter
    public void setStopLoadMore(boolean z) {
        this.stopLoadMore = z;
    }

    private void loadData(final boolean z, final boolean z2, final int i) {
        cancelLoadData();
        NewAsyncListContract.RequestProvider<T> requestProvider = this.extraProvider;
        Observable<T> createRequest = requestProvider != null ? requestProvider.createRequest(z, i) : null;
        if (createRequest == null) {
            createRequest = (Observable) CommonUtils.checkNotNull(this.view.onCreateRequest(z, i), "Request is necessary!");
        }
        this.subscription = createRequest.compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.base.asynclist.NewAsyncListPresenter.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                NewAsyncListPresenter.this.setInternalLoading(z);
                NewAsyncListPresenter.this.view.onLoadDataStart(z, z2);
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.base.asynclist.NewAsyncListPresenter.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                if (NewAsyncListPresenter.this.state != 0) {
                    NewAsyncListPresenter.this.setInternalIdle();
                    NewAsyncListPresenter.this.view.onLoadDataReset(z, z2, i);
                }
            }
        }).subscribe((Subscriber<? super R>) new Subscriber<T>() {
            /* class com.coolapk.market.view.base.asynclist.NewAsyncListPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                NewAsyncListPresenter.this.setInternalIdle();
                NewAsyncListPresenter.this.view.onLoadDataFailed(z, z2, i, th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                NewAsyncListPresenter.this.setInternalIdle();
                NewAsyncListPresenter.this.isDataLoaded = true;
                if (NewAsyncListPresenter.this.view.onLoadDataSuccess(z, z2, i, t)) {
                    if (z) {
                        NewAsyncListPresenter.this.stopLoadMore = false;
                    }
                    if (NewAsyncListPresenter.this.pageCounter.get() == 1 || !z) {
                        NewAsyncListPresenter.this.pageCounter.incrementAndGet();
                    }
                } else if (!NewAsyncListPresenter.this.isDataLoaded) {
                    NewAsyncListPresenter.this.stopLoadMore = true;
                } else if (!z) {
                    NewAsyncListPresenter.this.stopLoadMore = true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setInternalLoading(boolean z) {
        int i = this.state;
        int i2 = 1;
        if (i != 0) {
            LogUtils.e("State error, state: %d, should idle", Integer.valueOf(i));
            return;
        }
        if (!z) {
            i2 = 2;
        }
        this.state = i2;
    }

    /* access modifiers changed from: private */
    public void setInternalIdle() {
        int i = this.state;
        if (i == 0) {
            LogUtils.e("State error, state: %d, should not idle", Integer.valueOf(i));
        } else {
            this.state = 0;
        }
    }
}
