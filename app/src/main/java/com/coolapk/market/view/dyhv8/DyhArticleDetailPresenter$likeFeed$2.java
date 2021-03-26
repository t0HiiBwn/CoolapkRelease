package com.coolapk.market.view.dyhv8;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/dyhv8/DyhArticleDetailPresenter$likeFeed$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailPresenter.kt */
public final class DyhArticleDetailPresenter$likeFeed$2 extends EmptySubscriber<Integer> {
    final /* synthetic */ boolean $isLiking;
    final /* synthetic */ DyhArticleDetailPresenter this$0;

    DyhArticleDetailPresenter$likeFeed$2(DyhArticleDetailPresenter dyhArticleDetailPresenter, boolean z) {
        this.this$0 = dyhArticleDetailPresenter;
        this.$isLiking = z;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext(((Number) obj).intValue());
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        DyhArticleDetailPresenter.access$setPostingLike$p(this.this$0, false);
        this.this$0.getView().onLikeResult(this.$isLiking, null, th);
    }

    public void onNext(int i) {
        super.onNext((DyhArticleDetailPresenter$likeFeed$2) Integer.valueOf(i));
        DyhArticleDetailPresenter.access$setPostingLike$p(this.this$0, false);
        this.this$0.getView().onLikeResult(!this.$isLiking, Integer.valueOf(i), null);
    }
}
