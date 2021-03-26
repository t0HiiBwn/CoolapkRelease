package com.coolapk.market.view.feed.reply;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/reply/FeedDetailPresenter$favoriteFeed$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "(Ljava/lang/Integer;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailPresenter.kt */
public final class FeedDetailPresenter$favoriteFeed$2 extends EmptySubscriber<Integer> {
    final /* synthetic */ boolean $isFavoriting;
    final /* synthetic */ FeedDetailPresenter this$0;

    FeedDetailPresenter$favoriteFeed$2(FeedDetailPresenter feedDetailPresenter, boolean z) {
        this.this$0 = feedDetailPresenter;
        this.$isFavoriting = z;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.this$0.isPostingFavorite = false;
        this.this$0.getView().onFavoriteResult(this.$isFavoriting, null, th);
    }

    public void onNext(Integer num) {
        super.onNext((FeedDetailPresenter$favoriteFeed$2) num);
        this.this$0.isPostingFavorite = false;
        this.this$0.getView().onFavoriteResult(!this.$isFavoriting, num, null);
    }
}