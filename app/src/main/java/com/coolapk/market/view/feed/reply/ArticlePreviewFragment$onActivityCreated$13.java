package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ArticlePreviewFragment.kt */
final class ArticlePreviewFragment$onActivityCreated$13 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ ArticlePreviewFragment$onActivityCreated$articlePresenter$1 $articlePresenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticlePreviewFragment$onActivityCreated$13(ArticlePreviewFragment$onActivityCreated$articlePresenter$1 articlePreviewFragment$onActivityCreated$articlePresenter$1) {
        super(1);
        this.$articlePresenter = articlePreviewFragment$onActivityCreated$articlePresenter$1;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        if (obj instanceof HolderItem) {
            HolderItem holderItem = (HolderItem) obj;
            if (Intrinsics.areEqual(holderItem.getEntityType(), ArticleModel.Type.Card.getLongName()) && (this.$articlePresenter.getUrlEntityMap().get(holderItem.getUrl()) instanceof FeedGoods)) {
                return 1;
            }
        }
        return null;
    }
}
