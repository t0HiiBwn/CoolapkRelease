package com.coolapk.market.view.feedv8.article;

import android.widget.CompoundButton;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.view.feedv8.ArticleRatingContentHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditProductTopHolder.kt */
final class ArticleEditProductTopHolder$bindTo$4 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ FeedMultiPart $multiPart;
    final /* synthetic */ ArticleEditProductTopHolder this$0;

    ArticleEditProductTopHolder$bindTo$4(ArticleEditProductTopHolder articleEditProductTopHolder, FeedMultiPart feedMultiPart) {
        this.this$0 = articleEditProductTopHolder;
        this.$multiPart = feedMultiPart;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ArticleRatingContentHolder content = this.this$0.getContent();
        FeedMultiPart build = this.$multiPart.newBuilder().buyStatus(z).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …Status(isChecked).build()");
        content.updateMultiPart$presentation_coolapkAppRelease(build);
    }
}
