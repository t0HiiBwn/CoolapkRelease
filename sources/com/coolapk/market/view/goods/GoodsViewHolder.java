package com.coolapk.market.view.goods;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemGoodsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewHolderExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Goods;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0019B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0006\u0010\u0018\u001a\u00020\u0012R\u000e\u0010\f\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsBinding;", "Lcom/coolapk/market/model/Goods;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "goods", "ignoreBindTags", "", "tagView", "Lcom/coolapk/market/view/goods/GoodsTagPlug;", "bindToContent", "", "entity", "fixStrangeLayoutBug", "onClick", "view", "onRecycled", "setInitLargeIconMode", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsViewHolder.kt */
public final class GoodsViewHolder extends GenericBindHolder<ItemGoodsBinding, Goods> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558762;
    private Goods goods;
    private boolean ignoreBindTags;
    private final GoodsTagPlug tagView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Space space = ((ItemGoodsBinding) getBinding()).tagSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.tagSpaceView");
        this.tagView = new GoodsTagPlug(space, dataBindingComponent, null, 4, null);
        ItemGoodsBinding itemGoodsBinding = (ItemGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsBinding, "binding");
        itemGoodsBinding.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 8), false));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void setInitLargeIconMode() {
        ItemGoodsBinding itemGoodsBinding = (ItemGoodsBinding) getBinding();
        LinearLayout linearLayout = itemGoodsBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "it.itemView");
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setPadding(0, 0, linearLayout2.getPaddingRight(), 0);
        LinearLayout linearLayout3 = itemGoodsBinding.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "it.contentView");
        LinearLayout linearLayout4 = linearLayout3;
        linearLayout4.setPadding(linearLayout4.getPaddingLeft(), NumberExtendsKt.getDp((Number) 8), linearLayout4.getPaddingRight(), NumberExtendsKt.getDp((Number) 8));
        TextView textView = itemGoodsBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "it.titleView");
        textView.setTextSize(14.0f);
        LinearLayout linearLayout5 = itemGoodsBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "it.actionView");
        LinearLayout linearLayout6 = linearLayout5;
        ViewGroup.LayoutParams layoutParams = linearLayout6.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = -NumberExtendsKt.getDp((Number) 12);
        linearLayout6.setLayoutParams(marginLayoutParams);
        TextView textView2 = itemGoodsBinding.discountPriceView;
        Intrinsics.checkNotNullExpressionValue(textView2, "it.discountPriceView");
        TextView textView3 = textView2;
        ViewGroup.LayoutParams layoutParams2 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
        layoutParams3.gravity = 80;
        textView3.setLayoutParams(layoutParams3);
        Space space = itemGoodsBinding.tagSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "it.tagSpaceView");
        space.setVisibility(8);
        this.ignoreBindTags = true;
    }

    public void bindToContent(Goods goods2) {
        Intrinsics.checkNotNullParameter(goods2, "entity");
        if (!this.ignoreBindTags) {
            this.tagView.bindTo(goods2);
        }
        this.goods = goods2;
        GoodsViewHolder goodsViewHolder = this;
        ViewUtil.clickListener(((ItemGoodsBinding) getBinding()).coolapkCardView, goodsViewHolder);
        ViewUtil.clickListener(((ItemGoodsBinding) getBinding()).itemView, goodsViewHolder);
        ViewUtil.clickListener(((ItemGoodsBinding) getBinding()).goShoppingView, goodsViewHolder);
        ItemGoodsBinding itemGoodsBinding = (ItemGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsBinding, "binding");
        itemGoodsBinding.setModel(goods2);
        TextView textView = ((ItemGoodsBinding) getBinding()).goShoppingView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.goShoppingView");
        textView.setBackground(ShapeUtils.createActionCornerBg(getContext(), ResourceUtils.getColorInt(getContext(), 2131100040)));
        ((ItemGoodsBinding) getBinding()).executePendingBindings();
        fixStrangeLayoutBug();
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.tagView.onRecycled();
    }

    private final void fixStrangeLayoutBug() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        if (!view.isLayoutRequested()) {
            this.itemView.requestLayout();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemGoodsBinding itemGoodsBinding = (ItemGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsBinding, "binding");
        Goods model = itemGoodsBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            int id = view.getId();
            String str = null;
            if (id == 2131362631) {
                ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Goods goods2 = this.goods;
                if (goods2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goods");
                }
                actionManagerCompat.startWithGoodsBuyUrl(context, goods2);
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
                if (baseFragment != null) {
                    str = baseFragment.getFixedRecordId();
                }
                StatisticHelper.recordEntityEvent$default(instance, str, model, getAdapterPosition(), ViewHolderExtendsKt.findParentEntity(this), null, 16, null);
            } else if (id != 2131362779) {
                super.onClick(view);
            } else {
                Goods goods3 = this.goods;
                if (goods3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goods");
                }
                if (goods3.isDirect()) {
                    ActionManagerCompat actionManagerCompat2 = ActionManagerCompat.INSTANCE;
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    Goods goods4 = this.goods;
                    if (goods4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goods");
                    }
                    actionManagerCompat2.startWithGoodsBuyUrl(context2, goods4);
                } else {
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    Goods goods5 = this.goods;
                    if (goods5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goods");
                    }
                    String goodsUrl = goods5.getGoodsUrl();
                    Goods goods6 = this.goods;
                    if (goods6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goods");
                    }
                    String title = goods6.getTitle();
                    Goods goods7 = this.goods;
                    if (goods7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goods");
                    }
                    ActionManagerCompat.startActivityByUrl(context3, goodsUrl, title, goods7.getSubTitle());
                }
                StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
                DataBindingComponent component2 = getComponent();
                if (!(component2 instanceof FragmentBindingComponent)) {
                    component2 = null;
                }
                FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                if (!(fragment2 instanceof BaseFragment)) {
                    fragment2 = null;
                }
                BaseFragment baseFragment2 = (BaseFragment) fragment2;
                if (baseFragment2 != null) {
                    str = baseFragment2.getFixedRecordId();
                }
                StatisticHelper.recordEntityEvent$default(instance2, str, model, getAdapterPosition(), ViewHolderExtendsKt.findParentEntity(this), null, 16, null);
            }
        }
    }
}
