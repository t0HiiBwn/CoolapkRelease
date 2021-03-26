package com.coolapk.market.view.feed.reply;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.view.feed.article.ArticleGoodsCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
final class ArticlePreviewFragment$onActivityCreated$14 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ ArticlePreviewFragment$onActivityCreated$articlePresenter$1 $articlePresenter;
    final /* synthetic */ FragmentBindingComponent $bindingComponent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticlePreviewFragment$onActivityCreated$14(FragmentBindingComponent fragmentBindingComponent, ArticlePreviewFragment$onActivityCreated$articlePresenter$1 articlePreviewFragment$onActivityCreated$articlePresenter$1) {
        super(1);
        this.$bindingComponent = fragmentBindingComponent;
        this.$articlePresenter = articlePreviewFragment$onActivityCreated$articlePresenter$1;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new ArticleGoodsCardViewHolder(view, this.$bindingComponent, this.$articlePresenter);
    }
}
