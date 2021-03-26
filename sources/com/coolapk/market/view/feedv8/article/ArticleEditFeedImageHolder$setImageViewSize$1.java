package com.coolapk.market.view.feedv8.article;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import com.coolapk.market.databinding.SubmitFeedArticleImagePartBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleEditFeedImageHolder.kt */
final class ArticleEditFeedImageHolder$setImageViewSize$1 implements View.OnClickListener {
    final /* synthetic */ SubmitFeedArticleImagePartBinding $binding;
    final /* synthetic */ Uri $data;
    final /* synthetic */ ArticleEditFeedImageHolder this$0;

    ArticleEditFeedImageHolder$setImageViewSize$1(ArticleEditFeedImageHolder articleEditFeedImageHolder, Uri uri, SubmitFeedArticleImagePartBinding submitFeedArticleImagePartBinding) {
        this.this$0 = articleEditFeedImageHolder;
        this.$data = uri;
        this.$binding = submitFeedArticleImagePartBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.$data.toString(), "(data.toString())");
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        String[] strArr = {this.$data.toString()};
        ScalingImageView scalingImageView = this.$binding.ivCover;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
        ActionManager.startPhotoViewActivity(activityNullable, strArr, null, 0, null, null, new Rect[]{ViewExtendsKt.getGlobalRect(scalingImageView)});
    }
}
