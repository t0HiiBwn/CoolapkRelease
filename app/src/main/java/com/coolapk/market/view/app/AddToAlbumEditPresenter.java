package com.coolapk.market.view.app;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.app.AddToAlbumEditContract;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public class AddToAlbumEditPresenter implements AddToAlbumEditContract.Presenter {
    private boolean isInSubmit;
    private Subscription subscription;
    private AddToAlbumEditContract.View view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
    }

    public AddToAlbumEditPresenter(AddToAlbumEditContract.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.app.AddToAlbumEditContract.Presenter
    public void addToAlbum(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        this.subscription = DataManager.getInstance().addApkToAlbum(str, str2, str3, str4, str5, i, str6).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).doOnSubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AddToAlbumEditPresenter.AnonymousClass3 */

            @Override // rx.functions.Action0
            public void call() {
                AddToAlbumEditPresenter.this.isInSubmit = true;
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.app.AddToAlbumEditPresenter.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                AddToAlbumEditPresenter.this.isInSubmit = false;
            }
        }).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
            /* class com.coolapk.market.view.app.AddToAlbumEditPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AddToAlbumEditPresenter.this.isInSubmit = false;
                AddToAlbumEditPresenter.this.view.onAddToAlbumComplete(th);
            }

            public void onNext(Result<String> result) {
                AddToAlbumEditPresenter.this.isInSubmit = false;
                AddToAlbumEditPresenter.this.view.onAddToAlbumComplete(null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AddToAlbumEditContract.Presenter
    public void cancelAddToAlbum() {
        RxUtils.unsubscribe(this.subscription);
    }

    @Override // com.coolapk.market.view.app.AddToAlbumEditContract.Presenter
    public boolean isInSubmit() {
        return this.isInSubmit;
    }
}
