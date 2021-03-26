package com.coolapk.market.view.feed.article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feedv8.article.ShareInfoViewPart;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/article/ShareInfoViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticleShareUrlViewHolder.kt */
final class ArticleShareUrlViewHolder$viewPart$2 extends Lambda implements Function0<ShareInfoViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ ArticleShareUrlViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleShareUrlViewHolder$viewPart$2(ArticleShareUrlViewHolder articleShareUrlViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = articleShareUrlViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ShareInfoViewPart invoke() {
        ShareInfoViewPart shareInfoViewPart = new ShareInfoViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(ArticleShareUrlViewHolder.access$getBinding$p(this.this$0).spaceView, shareInfoViewPart.createView(from, ArticleShareUrlViewHolder.access$getBinding$p(this.this$0).itemView));
        View view = shareInfoViewPart.getView();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        marginLayoutParams2.leftMargin = NumberExtendsKt.getDp((Number) 16);
        marginLayoutParams2.rightMargin = NumberExtendsKt.getDp((Number) 16);
        view.setLayoutParams(marginLayoutParams);
        return shareInfoViewPart;
    }
}
