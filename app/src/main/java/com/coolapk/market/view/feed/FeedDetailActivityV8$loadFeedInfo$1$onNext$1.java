package com.coolapk.market.view.feed;

import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.webview.SecondHandAgreementDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailActivityV8.kt */
final class FeedDetailActivityV8$loadFeedInfo$1$onNext$1<T> implements Action1<Result<Integer>> {
    final /* synthetic */ FeedDetailActivityV8$loadFeedInfo$1 this$0;

    FeedDetailActivityV8$loadFeedInfo$1$onNext$1(FeedDetailActivityV8$loadFeedInfo$1 feedDetailActivityV8$loadFeedInfo$1) {
        this.this$0 = feedDetailActivityV8$loadFeedInfo$1;
    }

    public final void call(Result<Integer> result) {
        Integer status;
        Intrinsics.checkNotNullExpressionValue(result, "it");
        if (!result.isSuccess() && (status = result.getStatus()) != null && status.intValue() == -1) {
            SecondHandAgreementDialogFragment newInstance = SecondHandAgreementDialogFragment.Companion.newInstance();
            newInstance.setListener(new Action1<Integer>(this) {
                /* class com.coolapk.market.view.feed.FeedDetailActivityV8$loadFeedInfo$1$onNext$1.AnonymousClass1 */
                final /* synthetic */ FeedDetailActivityV8$loadFeedInfo$1$onNext$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Integer num) {
                    this.this$0.this$0.this$0.requestCreateFragment();
                    this.this$0.this$0.this$0.setLoadingFinished();
                }
            });
            newInstance.setCacelListener(new Action1<Integer>(this) {
                /* class com.coolapk.market.view.feed.FeedDetailActivityV8$loadFeedInfo$1$onNext$1.AnonymousClass2 */
                final /* synthetic */ FeedDetailActivityV8$loadFeedInfo$1$onNext$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Integer num) {
                    this.this$0.this$0.this$0.setLoadingError("没有同意二手安全协议无法浏览二手动态");
                }
            });
            BaseActivity activity = this.this$0.this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        } else if (result.isSuccess()) {
            this.this$0.this$0.requestCreateFragment();
            this.this$0.this$0.setLoadingFinished();
        }
    }
}
