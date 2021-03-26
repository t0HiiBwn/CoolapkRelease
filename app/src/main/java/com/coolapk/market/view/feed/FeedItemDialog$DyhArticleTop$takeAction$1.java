package com.coolapk.market.view.feed;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.feed.FeedItemDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "aBoolean", "", "call", "(Ljava/lang/Boolean;)Lrx/Observable;"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedItemDialog.kt */
final class FeedItemDialog$DyhArticleTop$takeAction$1<T, R> implements Func1<Boolean, Observable<? extends Result<String>>> {
    final /* synthetic */ FeedItemDialog.DyhArticleTop this$0;

    FeedItemDialog$DyhArticleTop$takeAction$1(FeedItemDialog.DyhArticleTop dyhArticleTop) {
        this.this$0 = dyhArticleTop;
    }

    public final Observable<? extends Result<String>> call(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            return DataManager.getInstance().onStick(this.this$0.getFeed$presentation_coolapkAppRelease().getArticleId(), 2);
        }
        return DataManager.getInstance().onStick(this.this$0.getFeed$presentation_coolapkAppRelease().getArticleId(), 1);
    }
}
