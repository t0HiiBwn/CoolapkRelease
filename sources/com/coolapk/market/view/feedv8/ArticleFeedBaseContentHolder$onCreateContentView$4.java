package com.coolapk.market.view.feedv8;

import androidx.lifecycle.Observer;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedBaseContentHolder.kt */
final class ArticleFeedBaseContentHolder$onCreateContentView$4<T> implements Observer<Boolean> {
    final /* synthetic */ ArticleFeedBaseContentHolder this$0;

    ArticleFeedBaseContentHolder$onCreateContentView$4(ArticleFeedBaseContentHolder articleFeedBaseContentHolder) {
        this.this$0 = articleFeedBaseContentHolder;
    }

    public final void onChanged(Boolean bool) {
        if (!Intrinsics.areEqual(Boolean.valueOf(this.this$0.getUiConfig().isMenuItemEnabled()), bool)) {
            ArticleFeedBaseContentHolder articleFeedBaseContentHolder = this.this$0;
            FeedUIConfig.Builder builder = FeedUIConfig.builder(articleFeedBaseContentHolder.getUiConfig());
            Intrinsics.checkNotNullExpressionValue(bool, "it");
            FeedUIConfig build = builder.isMenuItemEnabled(bool.booleanValue()).build();
            Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
            articleFeedBaseContentHolder.updateUiConfig$presentation_coolapkAppRelease(build);
        }
    }
}
