package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.dyhv8.DyhContract;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class DyhPresenter implements DyhContract.Presenter {
    private static final String KEY_DYH = "DYH";
    private static final String KEY_ID = "ID";
    private DyhModel dyhModel;
    private Subscription followDyhSub;
    private String id;
    private boolean isLoading = true;
    private Subscription loadDyhSub;
    private Subscription unFollowDyhSub;
    private final DyhContract.View view;

    public DyhPresenter(DyhContract.View view2, String str) {
        this.view = view2;
        this.id = str;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.dyhModel = (DyhModel) bundle.getParcelable("DYH");
            this.id = bundle.getString("ID");
        }
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("DYH", this.dyhModel);
        bundle.putString("ID", this.id);
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public Observable<Result<DyhModel>> loadDyh() {
        Observable<Result<DyhModel>> dyhDetail = DataManager.getInstance().getDyhDetail(this.id);
        this.loadDyhSub = dyhDetail.compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<DyhModel>>() {
            /* class com.coolapk.market.view.dyhv8.DyhPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                DyhPresenter.this.isLoading = false;
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                DyhPresenter.this.isLoading = false;
            }

            public void onNext(Result<DyhModel> result) {
                DyhPresenter.this.isLoading = false;
                DyhPresenter.this.dyhModel = result.getData();
            }
        });
        return dyhDetail;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public DyhModel getDyhModel() {
        return this.dyhModel;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public Observable<Result<DyhArticle>> getDyhArticleDetail() {
        return DataManager.getInstance().getDyhArticleDetail(getId());
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public Observable<Result<String>> followDyh() {
        Observable<Result<String>> followDyh = DataManager.getInstance().followDyh(getId());
        this.followDyhSub = followDyh.compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.dyhv8.DyhPresenter.AnonymousClass2 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                DyhPresenter.this.view.DyhFollowedFailed(th, true);
            }

            public void onNext(Result<String> result) {
                if (result.getData() != null) {
                    DyhPresenter.this.view.DyhFollowed(result.getData(), true);
                }
            }
        });
        return followDyh;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public Observable<Result<String>> unFollowDyh() {
        Observable<Result<String>> unFollowDyh = DataManager.getInstance().unFollowDyh(getId());
        this.followDyhSub = unFollowDyh.compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.dyhv8.DyhPresenter.AnonymousClass3 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                DyhPresenter.this.view.DyhFollowedFailed(th, false);
            }

            public void onNext(Result<String> result) {
                if (result.getData() != null) {
                    DyhPresenter.this.view.DyhFollowed(result.getData(), false);
                }
            }
        });
        return unFollowDyh;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public boolean getIsLoading() {
        return this.isLoading;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.Presenter
    public void cancelLoadDyhModel() {
        RxUtils.unsubscribe(this.loadDyhSub);
    }
}
