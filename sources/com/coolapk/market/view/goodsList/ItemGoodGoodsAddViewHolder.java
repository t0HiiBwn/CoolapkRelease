package com.coolapk.market.view.goodsList;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemGoodGoodsAddBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodGoodsAddViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodGoodsAddBinding;", "Lcom/coolapk/market/model/HolderItem;", "feed", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Lcom/coolapk/market/model/Feed;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "getFeed", "()Lcom/coolapk/market/model/Feed;", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGoodGoodsAddViewHolder.kt */
public final class ItemGoodGoodsAddViewHolder extends GenericBindHolder<ItemGoodGoodsAddBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558753;
    private final Feed feed;

    public final Feed getFeed() {
        return this.feed;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGoodGoodsAddViewHolder(Feed feed2, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(feed2, "feed");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.feed = feed2;
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "entity");
        Drawable createActionCornerBg = ShapeUtils.createActionCornerBg(getContext(), AppHolder.getAppTheme().getContentBackgroundColor());
        Intrinsics.checkNotNullExpressionValue(createActionCornerBg, "colorBg");
        createActionCornerBg.setAlpha(150);
        LinearLayout linearLayout = ((ItemGoodGoodsAddBinding) getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
        linearLayout.setMinimumHeight((int) (((double) DisplayUtils.getHeightPixels(getContext())) * 0.6d));
        TextView textView = ((ItemGoodGoodsAddBinding) getBinding()).actionAdd;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionAdd");
        textView.setBackground(createActionCornerBg);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean areEqual = Intrinsics.areEqual(loginSession.getUid(), this.feed.getUid());
        TextView textView2 = ((ItemGoodGoodsAddBinding) getBinding()).actionAdd;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionAdd");
        textView2.setVisibility(areEqual ? 0 : 8);
        ItemGoodGoodsAddBinding itemGoodGoodsAddBinding = (ItemGoodGoodsAddBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodGoodsAddBinding, "binding");
        itemGoodGoodsAddBinding.setClick(this);
        ((ItemGoodGoodsAddBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131361853) {
            Activity activityNullable = UiUtils.getActivityNullable(getContext());
            FeedGoodsHelper feedGoodsHelper = FeedGoodsHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(activityNullable, "activity");
            FeedGoodsHelper.showAddGoodsDialog$default(feedGoodsHelper, activityNullable, null, new ItemGoodGoodsAddViewHolder$onClick$1(this, activityNullable), 2, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodGoodsAddViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGoodGoodsAddViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
