package com.coolapk.market.view.feed;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feed/FeedDetailActivityV8$loadFeedInfo$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailActivityV8.kt */
public final class FeedDetailActivityV8$loadFeedInfo$1 extends EmptySubscriber<Entity> {
    final /* synthetic */ FeedDetailActivityV8 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedDetailActivityV8$loadFeedInfo$1(FeedDetailActivityV8 feedDetailActivityV8) {
        this.this$0 = feedDetailActivityV8;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        String str = "获取信息失败，请重试";
        if (th instanceof ClientException) {
            FeedDetailActivityV8 feedDetailActivityV8 = this.this$0;
            String message = th.getMessage();
            if (message != null) {
                str = message;
            }
            feedDetailActivityV8.setLoadingError(str);
        } else {
            this.this$0.setLoadingError(str);
        }
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "t");
        super.onNext((FeedDetailActivityV8$loadFeedInfo$1) entity);
        if (entity instanceof Feed) {
            this.this$0.feed = (Feed) entity;
            Feed feed = this.this$0.feed;
            Intrinsics.checkNotNull(feed);
            if (feed.isSecondHand()) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (loginSession.isLogin()) {
                    DataManager.getInstance().onCheckAgree().compose(RxUtils.applyIOSchedulers()).subscribe(new FeedDetailActivityV8$loadFeedInfo$1$onNext$1(this), new FeedDetailActivityV8$loadFeedInfo$1$onNext$2(this));
                    return;
                }
            }
            this.this$0.requestCreateFragment();
            this.this$0.setLoadingFinished();
        } else if (entity instanceof Album) {
            this.this$0.setLoadingFinished();
            ActionManager.startV8AlbumDetailActivity(this.this$0.getActivity(), entity);
            this.this$0.finish();
            this.this$0.overridePendingTransition(0, 0);
        }
    }
}
