package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemGoodsListFeedBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.FeedIntegratedHeaderViewPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListFeedItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsListFeedBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListFeedItemViewHolder.kt */
public final class GoodsListFeedItemViewHolder extends GenericBindHolder<ItemGoodsListFeedBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558767;
    private Feed feed;
    private final Lazy headerViewPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(GoodsListFeedItemViewHolder goodsListFeedItemViewHolder) {
        Feed feed2 = goodsListFeedItemViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsListFeedItemViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new GoodsListFeedItemViewHolder$headerViewPart$2(this, dataBindingComponent));
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "entity");
        this.feed = feed2;
        ItemGoodsListFeedBinding itemGoodsListFeedBinding = (ItemGoodsListFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListFeedBinding, "binding");
        itemGoodsListFeedBinding.setModel(feed2);
        FeedIntegratedHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindTo(feed3);
        ItemGoodsListFeedBinding itemGoodsListFeedBinding2 = (ItemGoodsListFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListFeedBinding2, "binding");
        itemGoodsListFeedBinding2.setFollowNum(feed2.getExtraInfo() + "  " + feed2.getFavoriteNum() + "个收藏");
        ItemGoodsListFeedBinding itemGoodsListFeedBinding3 = (ItemGoodsListFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListFeedBinding3, "binding");
        itemGoodsListFeedBinding3.setClick(this);
        ((ItemGoodsListFeedBinding) getBinding()).executePendingBindings();
        FrameLayout frameLayout = ((ItemGoodsListFeedBinding) getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.itemView");
        LinearLayout linearLayout = ((ItemGoodsListFeedBinding) getBinding()).cardLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardLayout");
        ViewGroup[] viewGroupArr = {frameLayout, linearLayout};
        for (int i = 0; i < 2; i++) {
            viewGroupArr[i].setOnLongClickListener(new GoodsListFeedItemViewHolder$bindToContent$$inlined$forEach$lambda$1(this));
        }
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemGoodsListFeedBinding itemGoodsListFeedBinding4 = (ItemGoodsListFeedBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListFeedBinding4, "binding");
        View root = itemGoodsListFeedBinding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        instance.traceFeedStayInList(root, feed4.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362204 || id == 2131362779) {
            Context context = getContext();
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            ActionManager.startFeedDetailActivity(context, feed2.getId(), (String) null);
        } else if (id == 2131362982) {
            Feed feed3 = this.feed;
            if (feed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            EntityExtendsKt.showItemDialog(feed3, context2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListFeedItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListFeedItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
