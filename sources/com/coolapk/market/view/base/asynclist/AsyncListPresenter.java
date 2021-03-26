package com.coolapk.market.view.base.asynclist;

import android.os.Bundle;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public abstract class AsyncListPresenter<T> implements AsyncListContract.Presenter {
    private static final String KEY_IS_DATA_LOADED = "AsyncListPresenter.IS_DATA_LOADED";
    private static final String KEY_PAGE = "AsyncListPresenter.PAGE";
    private static final String KEY_STOP_LOAD_MORE = "AsyncListPresenter.STOP_LOAD_MORE";
    private static final String TAG = "AsyncListPresenter";
    private boolean isDataLoaded;
    private boolean isFirstInit = true;
    private boolean loadingMore;
    private AtomicInteger pageCounter;
    private boolean refreshing;
    private boolean stopLoadMore;
    private Subscription subscription;
    private AsyncListContract.View<T> view;

    protected abstract Observable<T> onCreateRequest(boolean z, int i);

    public AsyncListPresenter(AsyncListContract.View<T> view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.stopLoadMore = bundle.getBoolean("AsyncListPresenter.STOP_LOAD_MORE");
            this.isDataLoaded = bundle.getBoolean("AsyncListPresenter.IS_DATA_LOADED");
            this.pageCounter = new AtomicInteger(bundle.getInt("AsyncListPresenter.PAGE", 1));
        } else if (this.isFirstInit) {
            this.stopLoadMore = false;
            this.isDataLoaded = false;
            this.pageCounter = new AtomicInteger(1);
        }
        this.isFirstInit = false;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("AsyncListPresenter.STOP_LOAD_MORE", this.stopLoadMore);
        bundle.putBoolean("AsyncListPresenter.IS_DATA_LOADED", this.isDataLoaded);
        AtomicInteger atomicInteger = this.pageCounter;
        if (atomicInteger != null) {
            bundle.putInt("AsyncListPresenter.PAGE", atomicInteger.get());
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public int getPage() {
        return this.pageCounter.get();
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public void setPage(int i) {
        this.pageCounter.set(i);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public boolean isDataLoaded() {
        return this.isDataLoaded;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public boolean isRefreshing() {
        return this.refreshing;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public boolean isLoadingMore() {
        return this.loadingMore;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public void initData(boolean z) {
        if (this.refreshing && !z) {
            return;
        }
        if (!isDataLoaded()) {
            loadData(true, true, 1);
        } else if (z) {
            loadData(true, true, 1);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public void reloadData() {
        loadData(true, false, 1);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public void loadMore() {
        if (!this.stopLoadMore && !this.loadingMore && this.pageCounter != null) {
            LogUtils.d("LoadMore", new Object[0]);
            loadData(false, false, this.pageCounter.get());
        }
    }

    private void loadData(final boolean z, final boolean z2, final int i) {
        cancelLoadData();
        Observable<T> onCreateRequest = onCreateRequest(z, i);
        Objects.requireNonNull(onCreateRequest, "Request is necessary!");
        this.subscription = onCreateRequest.compose(RxUtils.applyIOSchedulers()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.base.asynclist.AsyncListPresenter.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                if (z) {
                    AsyncListPresenter.this.refreshing = true;
                } else {
                    AsyncListPresenter.this.loadingMore = true;
                }
                AsyncListPresenter.this.view.onLoadDataStart(z, z2);
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.base.asynclist.AsyncListPresenter.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                if (z) {
                    AsyncListPresenter.this.refreshing = false;
                } else {
                    AsyncListPresenter.this.loadingMore = false;
                }
                AsyncListPresenter.this.view.onLoadDataReset(z, z2, i);
            }
        }).subscribe((Subscriber<? super R>) new Subscriber<T>() {
            /* class com.coolapk.market.view.base.asynclist.AsyncListPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (z) {
                    AsyncListPresenter.this.refreshing = false;
                } else {
                    AsyncListPresenter.this.loadingMore = false;
                }
                AsyncListPresenter.this.view.onLoadDataFailed(z, z2, i, th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (z) {
                    AsyncListPresenter.this.refreshing = false;
                } else {
                    AsyncListPresenter.this.loadingMore = false;
                }
                AsyncListPresenter.this.isDataLoaded = true;
                if (AsyncListPresenter.this.view.onLoadDataSuccess(z, z2, i, t)) {
                    if (z) {
                        AsyncListPresenter.this.stopLoadMore = false;
                    }
                    if (AsyncListPresenter.this.pageCounter.get() == 1 || !z) {
                        AsyncListPresenter.this.pageCounter.incrementAndGet();
                    }
                } else if (!z) {
                    AsyncListPresenter.this.stopLoadMore = true;
                }
            }
        });
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListContract.Presenter
    public void cancelLoadData() {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }
}
