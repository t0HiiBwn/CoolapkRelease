package com.coolapk.market.view.feed.article;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemArticleCardGoodsBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleGoodsCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/article/ArticlePresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/article/ArticlePresenter;)V", "binding", "Lcom/coolapk/market/databinding/ItemArticleCardGoodsBinding;", "kotlin.jvm.PlatformType", "goodsInfoViewPart", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "getGoodsInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "goodsInfoViewPart$delegate", "Lkotlin/Lazy;", "getPresenter", "()Lcom/coolapk/market/view/feed/article/ArticlePresenter;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleGoodsCardViewHolder.kt */
public final class ArticleGoodsCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558613;
    private final ItemArticleCardGoodsBinding binding = ((ItemArticleCardGoodsBinding) getBinding());
    private final Lazy goodsInfoViewPart$delegate;
    private final ArticlePresenter presenter;

    private final FeedGoodsInfoViewPart getGoodsInfoViewPart() {
        return (FeedGoodsInfoViewPart) this.goodsInfoViewPart$delegate.getValue();
    }

    public final ArticlePresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleGoodsCardViewHolder(View view, DataBindingComponent dataBindingComponent, ArticlePresenter articlePresenter) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(articlePresenter, "presenter");
        this.presenter = articlePresenter;
        this.goodsInfoViewPart$delegate = LazyKt.lazy(new ArticleGoodsCardViewHolder$goodsInfoViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleGoodsCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleGoodsCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        List<ArticleModel> articleModelList = this.presenter.getArticleModelList();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.HolderItem");
        Integer intValue = ((HolderItem) obj).getIntValue();
        Intrinsics.checkNotNullExpressionValue(intValue, "(data as HolderItem).intValue");
        ArticleModel articleModel = articleModelList.get(intValue.intValue());
        Objects.requireNonNull(articleModel, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleCard");
        Entity entity = this.presenter.getUrlEntityMap().get(((ArticleCard) articleModel).getUrlKey());
        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.FeedGoods");
        getGoodsInfoViewPart().bindToContent(FeedGoodsInfoViewPartKt.toGoodsSimpleInfo((FeedGoods) entity));
    }
}
