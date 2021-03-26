package com.coolapk.market.view.app;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.app.AddToAlbumDialogContract;
import java.util.List;
import rx.Subscriber;
import rx.Subscription;

public class AddToAlbumDialogPresenter implements AddToAlbumDialogContract.Presenter {
    private List<Entity> albumList;
    private Subscription subscription;
    private AddToAlbumDialogContract.View view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
    }

    public AddToAlbumDialogPresenter(AddToAlbumDialogContract.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.app.AddToAlbumDialogContract.Presenter
    public void loadAlbumList(String str, int i) {
        this.subscription = DataManager.getInstance().getUserAlbumList(str, i).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<List<Entity>>>() {
            /* class com.coolapk.market.view.app.AddToAlbumDialogPresenter.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                AddToAlbumDialogPresenter.this.view.onAlbumListLoadComplete(null, th);
            }

            public void onNext(Result<List<Entity>> result) {
                AddToAlbumDialogPresenter.this.albumList = result.getData();
                AddToAlbumDialogPresenter.this.view.onAlbumListLoadComplete(result, null);
            }
        });
    }

    @Override // com.coolapk.market.view.app.AddToAlbumDialogContract.Presenter
    public void cancelLoadAlbumList() {
        RxUtils.unsubscribe(this.subscription);
    }

    @Override // com.coolapk.market.view.app.AddToAlbumDialogContract.Presenter
    public List<Entity> getAlbumList() {
        return this.albumList;
    }
}
