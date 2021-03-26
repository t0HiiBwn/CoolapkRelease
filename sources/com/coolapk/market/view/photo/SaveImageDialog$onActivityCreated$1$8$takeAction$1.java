package com.coolapk.market.view.photo;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "aBoolean", "", "call", "(Ljava/lang/Boolean;)Lrx/Observable;"}, k = 3, mv = {1, 4, 2})
/* compiled from: SaveImageDialog.kt */
final class SaveImageDialog$onActivityCreated$1$8$takeAction$1<T, R> implements Func1<Boolean, Observable<? extends Result<String>>> {
    final /* synthetic */ SaveImageDialog$onActivityCreated$1.AnonymousClass8 this$0;

    SaveImageDialog$onActivityCreated$1$8$takeAction$1(SaveImageDialog$onActivityCreated$1.AnonymousClass8 r1) {
        this.this$0 = r1;
    }

    public final Observable<? extends Result<String>> call(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        String str = null;
        if (bool.booleanValue()) {
            DataManager instance = DataManager.getInstance();
            Feed feed = this.this$0.this$0.this$0.feed;
            if (feed != null) {
                str = feed.getId();
            }
            return instance.cancelRecommend(str).map(RxUtils.checkResult());
        }
        DataManager instance2 = DataManager.getInstance();
        Feed feed2 = this.this$0.this$0.this$0.feed;
        if (feed2 != null) {
            str = feed2.getId();
        }
        return instance2.feedRecommend(str).map(RxUtils.checkResult());
    }
}
