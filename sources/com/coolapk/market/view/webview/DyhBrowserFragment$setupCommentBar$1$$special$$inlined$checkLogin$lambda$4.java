package com.coolapk.market.view.webview;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.view.dyhv8.DyhArticleCommentBarViewPart;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\t¨\u0006\n¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/webview/DyhBrowserFragment$setupCommentBar$1$2$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "stringResult", "(Ljava/lang/Integer;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhBrowserFragemnt.kt */
public final class DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$4 extends EmptySubscriber<Integer> {
    final /* synthetic */ DyhBrowserFragment$setupCommentBar$1 this$0;

    DyhBrowserFragment$setupCommentBar$1$$special$$inlined$checkLogin$lambda$4(DyhBrowserFragment$setupCommentBar$1 dyhBrowserFragment$setupCommentBar$1) {
        this.this$0 = dyhBrowserFragment$setupCommentBar$1;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.this$0.getActivity(), th);
        DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart = this.this$0.this$0.commentBarViewPart;
        Intrinsics.checkNotNull(dyhArticleCommentBarViewPart);
        dyhArticleCommentBarViewPart.bindToContent(DyhBrowserFragment.access$getDyhArticle$p(this.this$0.this$0));
    }

    public void onNext(Integer num) {
        if (num != null) {
            this.this$0.this$0.isSignFaved = !this.this$0.this$0.isSignFaved;
            EventBus.getDefault().post(new DyhArticleEvent(1, num.intValue(), DyhBrowserFragment.access$getDyhArticle$p(this.this$0.this$0).getId(), this.this$0.this$0.isSignFaved));
            this.this$0.this$0.posting = false;
        }
    }
}
