package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.coolapk.market.databinding.ItemArticleDetailTopBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleFeedTopViewHolder.kt */
final class ArticleFeedTopViewHolder$populateCover$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Feed $feed;
    final /* synthetic */ String $url;
    final /* synthetic */ ArticleFeedTopViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFeedTopViewHolder$populateCover$1(ArticleFeedTopViewHolder articleFeedTopViewHolder, Feed feed, String str) {
        super(1);
        this.this$0 = articleFeedTopViewHolder;
        this.$feed = feed;
        this.$url = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        String[] strArr = {this.$feed.getMessageCover()};
        String[] strArr2 = {this.$url};
        ScalingImageView scalingImageView = ((ItemArticleDetailTopBinding) this.this$0.getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        ActionManager.startPhotoViewActivity(activityNullable, strArr, strArr2, 0, null, null, new Rect[]{ViewExtendsKt.getGlobalRect(scalingImageView)});
    }
}
