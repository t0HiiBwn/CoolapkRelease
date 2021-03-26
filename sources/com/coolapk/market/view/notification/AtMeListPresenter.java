package com.coolapk.market.view.notification;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;
import com.coolapk.market.view.feed.FeedContract;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

public class AtMeListPresenter extends FeedContract.Presenter {
    private boolean hasAddIntercept = false;
    private CompatFeedListFragment view;

    public AtMeListPresenter(CompatFeedListFragment compatFeedListFragment) {
        super(compatFeedListFragment);
        this.view = compatFeedListFragment;
    }

    @Override // com.coolapk.market.view.feed.FeedContract.Presenter
    public Observable<Result<List<Entity>>> onCreateRequest(final boolean z, int i) {
        if (!this.hasAddIntercept) {
            AppHolder.getAppNotification().interceptInLifeCycle(this.view, new AppNotification.MessageIntercept() {
                /* class com.coolapk.market.view.notification.$$Lambda$AtMeListPresenter$jBIN9wyaWe_EsxKAKPRsd0AAFtU */

                @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
                public final boolean interceptNotification(PushMessage pushMessage) {
                    return AtMeListPresenter.this.lambda$onCreateRequest$1$AtMeListPresenter(pushMessage);
                }
            });
            this.hasAddIntercept = true;
        }
        return DataManager.getInstance().getNotificationAtMeList(i, this.view.findFirstItem(), this.view.findLastItem()).map(RxUtils.checkResult()).doOnNext(new Action1<Result<List<Entity>>>() {
            /* class com.coolapk.market.view.notification.AtMeListPresenter.AnonymousClass1 */

            public void call(Result<List<Entity>> result) {
                if (z) {
                    AppHolder.getAppNotification().clearByPage(1);
                }
            }
        });
    }

    public /* synthetic */ boolean lambda$onCreateRequest$1$AtMeListPresenter(PushMessage pushMessage) {
        if (!"atme".equals(pushMessage.getType()) || !this.view.isResumed()) {
            return false;
        }
        AppHolder.getMainThreadHandler().post(new Runnable() {
            /* class com.coolapk.market.view.notification.$$Lambda$AtMeListPresenter$bLVVrZD8E9Si0HGxU6NVXr6PcWo */

            @Override // java.lang.Runnable
            public final void run() {
                AtMeListPresenter.this.lambda$null$0$AtMeListPresenter();
            }
        });
        return true;
    }

    public /* synthetic */ void lambda$null$0$AtMeListPresenter() {
        this.view.scrollToTop(true);
    }
}
