package com.coolapk.market.view.webview;

import com.coolapk.market.network.Result;
import com.coolapk.market.view.dyhv8.DyhActionPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001ab\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002 \u0004*0\u0012*\b\u0001\u0012&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "aBoolean", "", "call", "(Ljava/lang/Boolean;)Lrx/Observable;", "com/coolapk/market/view/webview/DyhBrowserFragment$setupCommentBar$1$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhBrowserFragemnt.kt */
final class DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$3<T, R> implements Func1<Boolean, Observable<? extends Result<Integer>>> {
    final /* synthetic */ DyhBrowserFragment$setupCommentBar$1 this$0;

    DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$3(DyhBrowserFragment$setupCommentBar$1 dyhBrowserFragment$setupCommentBar$1) {
        this.this$0 = dyhBrowserFragment$setupCommentBar$1;
    }

    public final Observable<? extends Result<Integer>> call(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            DyhActionPresenter dyhActionPresenter = this.this$0.this$0.dyhArticlePresenter;
            Intrinsics.checkNotNull(dyhActionPresenter);
            return dyhActionPresenter.dyhArticleUnFavorite(DyhBrowserFragment.access$getDyhArticle$p(this.this$0.this$0));
        }
        DyhActionPresenter dyhActionPresenter2 = this.this$0.this$0.dyhArticlePresenter;
        Intrinsics.checkNotNull(dyhActionPresenter2);
        return dyhActionPresenter2.dyhArticleFavorite(DyhBrowserFragment.access$getDyhArticle$p(this.this$0.this$0));
    }
}
