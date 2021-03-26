package com.coolapk.market.view.dyhv8;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.DyhArticle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/dyhv8/DyhArticleDetailActivity$loadDyhArticleInfo$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/DyhArticle;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailActivity.kt */
public final class DyhArticleDetailActivity$loadDyhArticleInfo$2 extends EmptySubscriber<DyhArticle> {
    final /* synthetic */ DyhArticleDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    DyhArticleDetailActivity$loadDyhArticleInfo$2(DyhArticleDetailActivity dyhArticleDetailActivity) {
        this.this$0 = dyhArticleDetailActivity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        this.this$0.setLoadingError("获取信息失败，请重试");
    }

    public void onNext(DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(dyhArticle, "t");
        super.onNext((DyhArticleDetailActivity$loadDyhArticleInfo$2) dyhArticle);
        this.this$0.dyhArticle = dyhArticle;
        this.this$0.requestCreateFragment();
        this.this$0.setLoadingFinished();
    }
}
