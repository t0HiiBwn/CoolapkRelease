package com.coolapk.market.view.goods;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedGoodsInfoBinding;
import com.coolapk.market.databinding.ItemGoodsV10Binding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewHolderExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.GoodsSimpleInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0006\u0010\u0014\u001a\u00020\u0010R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsV10ViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsV10Binding;", "Lcom/coolapk/market/model/FeedGoods;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "goodsInfoViewPart", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "getGoodsInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "goodsInfoViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "entity", "onClick", "view", "setInitLargeIconMode", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsV10ViewHolder.kt */
public final class GoodsV10ViewHolder extends GenericBindHolder<ItemGoodsV10Binding, FeedGoods> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558763;
    private final Lazy goodsInfoViewPart$delegate;

    private final FeedGoodsInfoViewPart getGoodsInfoViewPart() {
        return (FeedGoodsInfoViewPart) this.goodsInfoViewPart$delegate.getValue();
    }

    public final void setInitLargeIconMode() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsV10ViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.goodsInfoViewPart$delegate = LazyKt.lazy(new GoodsV10ViewHolder$goodsInfoViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsV10ViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsV10ViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "entity");
        ItemGoodsV10Binding itemGoodsV10Binding = (ItemGoodsV10Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsV10Binding, "binding");
        itemGoodsV10Binding.setModel(feedGoods);
        GoodsSimpleInfo goodsSimpleInfo = FeedGoodsInfoViewPartKt.toGoodsSimpleInfo(feedGoods);
        if (StringsKt.isBlank(goodsSimpleInfo.getCategory())) {
            goodsSimpleInfo = GoodsSimpleInfo.copy$default(goodsSimpleInfo, null, null, null, "暂无分类", null, null, null, 119, null);
        }
        GoodsSimpleInfo goodsSimpleInfo2 = goodsSimpleInfo;
        String optSubTitle = EntityExtendsKt.optSubTitle(feedGoods);
        if (optSubTitle != null) {
            goodsSimpleInfo2 = GoodsSimpleInfo.copy$default(goodsSimpleInfo2, null, null, "", optSubTitle, null, null, null, 115, null);
        }
        getGoodsInfoViewPart().bindToContent(goodsSimpleInfo2);
        LinearLayout linearLayout = ((ItemFeedGoodsInfoBinding) getGoodsInfoViewPart().getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "goodsInfoViewPart.binding.itemView");
        Drawable drawable = null;
        linearLayout.setBackground(drawable);
        LinearLayout linearLayout2 = ((ItemFeedGoodsInfoBinding) getGoodsInfoViewPart().getBinding()).itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "goodsInfoViewPart.binding.itemView");
        ViewExtendsKt.setCompatForeground(linearLayout2, drawable);
        ((ItemGoodsV10Binding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        String id;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362768) {
            super.onClick(view);
            return;
        }
        ItemGoodsV10Binding itemGoodsV10Binding = (ItemGoodsV10Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsV10Binding, "binding");
        FeedGoods model = itemGoodsV10Binding.getModel();
        if (model != null && (id = model.getId()) != null) {
            Intrinsics.checkNotNullExpressionValue(id, "binding.model?.id ?: return");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startGoodsDetailActivity(context, id);
            ItemGoodsV10Binding itemGoodsV10Binding2 = (ItemGoodsV10Binding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemGoodsV10Binding2, "binding");
            FeedGoods model2 = itemGoodsV10Binding2.getModel();
            if (model2 != null) {
                Intrinsics.checkNotNullExpressionValue(model2, "binding.model ?: return");
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, model2, getAdapterPosition(), ViewHolderExtendsKt.findParentEntity(this), null, 16, null);
            }
        }
    }
}
