package com.coolapk.market.view.user;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.user.UserRatingContract;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;

public class UserRatingPresenter extends UserRatingContract.Presenter {
    private UserRatingContract.View mView;
    private String uid;

    public UserRatingPresenter(UserRatingContract.View view, String str) {
        super(view);
        this.mView = view;
        this.uid = str;
    }

    @Override // com.coolapk.market.view.user.UserRatingContract.Presenter
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.view.user.UserRatingContract.Presenter
    public void unrateApp(final ServiceApp serviceApp) {
        DataManager.getInstance().unratingApp(serviceApp.getApkId()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<Map<String, String>>>() {
            /* class com.coolapk.market.view.user.UserRatingPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                LogUtils.e(th);
            }

            public void onNext(Result<Map<String, String>> result) {
                UserRatingPresenter.this.mView.onEntityUnrated(serviceApp);
            }
        });
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getApkRatingList(this.uid, i, this.mView.findFirstItem(), this.mView.findLastItem());
    }
}
