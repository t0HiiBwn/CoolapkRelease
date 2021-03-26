package com.coolapk.market.view.notification;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.notification.FeedLikeContract;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

public class FeedLikeListPresenter extends FeedLikeContract.Presenter {
    private FeedLikeContract.View view;

    public FeedLikeListPresenter(FeedLikeContract.View view2) {
        super(view2);
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(final boolean z, int i) {
        return DataManager.getInstance().getNotificationFeedLikeList(i, this.view.findFirstItem(), this.view.findLastItem()).map(RxUtils.checkResult()).doOnNext(new Action1<Result<List<Entity>>>() {
            /* class com.coolapk.market.view.notification.FeedLikeListPresenter.AnonymousClass1 */

            public void call(Result<List<Entity>> result) {
                if (z) {
                    AppHolder.getAppNotification().clearByPage(5);
                }
            }
        });
    }
}
