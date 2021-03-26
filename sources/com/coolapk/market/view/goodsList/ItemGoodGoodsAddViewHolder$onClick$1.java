package com.coolapk.market.view.goodsList;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.view.feedv8.util.FeedGoodsUrlUtils;
import com.coolapk.market.view.goodsList.AddGoodsDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FeedGoods;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ItemGoodGoodsAddViewHolder.kt */
final class ItemGoodGoodsAddViewHolder$onClick$1 extends Lambda implements Function1<FeedGoods, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ItemGoodGoodsAddViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ItemGoodGoodsAddViewHolder$onClick$1(ItemGoodGoodsAddViewHolder itemGoodGoodsAddViewHolder, Activity activity) {
        super(1);
        this.this$0 = itemGoodGoodsAddViewHolder;
        this.$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
        invoke(feedGoods);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "it");
        GoodsListItem build = GoodsListItem.newBuilder().goodsUrl(feedGoods.getSellUrl()).productGoodsLogo(feedGoods.getCover()).productGoodsTitle(feedGoods.getTitle()).price(feedGoods.getPrice()).mallName(feedGoods.getMallName()).url(feedGoods.getUrl()).feedId(this.this$0.getFeed().getId()).entityId(feedGoods.getId()).id("").note("").productGoodsId(feedGoods.getId()).sort(0).dateline(Long.valueOf(feedGoods.getUpdateTime())).entityTypeId(0).build();
        GoodsListItemViewModel goodsListItemViewModel = new GoodsListItemViewModel();
        goodsListItemViewModel.setGoodsListItem(build);
        goodsListItemViewModel.setGoodsItemLogo(build != null ? build.getProductGoodsLogo() : null);
        goodsListItemViewModel.setGoodsItemTitle(build != null ? build.getProductGoodsTitle() : null);
        AddGoodsDialogFragment.Companion companion = AddGoodsDialogFragment.Companion;
        String id = this.this$0.getFeed().getId();
        Intrinsics.checkNotNull(id);
        Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
        String id2 = feedGoods.getId();
        Intrinsics.checkNotNull(id2);
        Intrinsics.checkNotNullExpressionValue(id2, "it.id!!");
        String cover = feedGoods.getCover();
        Intrinsics.checkNotNull(cover);
        Intrinsics.checkNotNullExpressionValue(cover, "it.cover!!");
        String title = feedGoods.getTitle();
        Intrinsics.checkNotNull(title);
        Intrinsics.checkNotNullExpressionValue(title, "it.title!!");
        AddGoodsDialogFragment newInstance$default = AddGoodsDialogFragment.Companion.newInstance$default(companion, id, id2, cover, title, "", false, 32, null);
        newInstance$default.setViewModel(goodsListItemViewModel);
        Activity activity = this.$activity;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance$default.show(supportFragmentManager, (String) null);
        FeedGoodsUrlUtils.INSTANCE.markTempIgnoreGoods(feedGoods);
    }
}
