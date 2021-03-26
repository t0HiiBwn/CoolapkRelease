package com.coolapk.market.view.product;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemProductViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewHolderExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/product/ProductViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductViewBinding;", "Lcom/coolapk/market/model/Product;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "fireDrawable", "Landroid/graphics/drawable/Drawable;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductViewHolder.kt */
public final class ProductViewHolder extends GenericBindHolder<ItemProductViewBinding, Product> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558889;
    private final Drawable fireDrawable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemProductViewBinding itemProductViewBinding = (ItemProductViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductViewBinding, "binding");
        itemProductViewBinding.setClick(this);
        float dp = (float) NumberExtendsKt.getDp((Number) 2);
        TextView textView = ((ItemProductViewBinding) getBinding()).releaseTimeView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.releaseTimeView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, dp, dp, dp, dp});
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        TextView textView2 = ((ItemProductViewBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.scoreView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context));
        Drawable mutate = ResourceUtils.getDrawable(getContext(), 2131231311).mutate();
        mutate.setTint(ResourceUtils.getColorInt(getContext(), 2131100016));
        mutate.setBounds(0, 0, NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12));
        Intrinsics.checkNotNullExpressionValue(mutate, "ResourceUtils.getDrawabl… 12.dp)\n                }");
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{mutate});
        layerDrawable.setLayerInset(0, 0, 0, NumberExtendsKt.getDp((Number) 1), 0);
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 13), NumberExtendsKt.getDp((Number) 12));
        Unit unit2 = Unit.INSTANCE;
        this.fireDrawable = layerDrawable;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/ProductViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Product product) {
        Intrinsics.checkNotNullParameter(product, "data");
        ItemProductViewBinding itemProductViewBinding = (ItemProductViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductViewBinding, "binding");
        itemProductViewBinding.setModel(product);
        float ownerStarAverageScore = product.getCategoryId() == 1000 ? product.getOwnerStarAverageScore() : product.getRatingAverageScore();
        boolean z = true;
        if (!product.isReleased()) {
            LinearLayout linearLayout = ((ItemProductViewBinding) getBinding()).scoreViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.scoreViewContainer");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = ((ItemProductViewBinding) getBinding()).releaseTimeContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.releaseTimeContainer");
            linearLayout2.setVisibility(0);
            TextView textView = ((ItemProductViewBinding) getBinding()).noOneRatedView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.noOneRatedView");
            textView.setVisibility(8);
            String releaseTime = product.getReleaseTime();
            if (releaseTime == null || StringsKt.isBlank(releaseTime)) {
                TextView textView2 = ((ItemProductViewBinding) getBinding()).releaseTimeView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.releaseTimeView");
                textView2.setText("未公布");
            } else {
                TextView textView3 = ((ItemProductViewBinding) getBinding()).releaseTimeView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.releaseTimeView");
                textView3.setText(product.getReleaseTime());
            }
        } else if (ownerStarAverageScore <= ((float) 0)) {
            LinearLayout linearLayout3 = ((ItemProductViewBinding) getBinding()).scoreViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.scoreViewContainer");
            linearLayout3.setVisibility(8);
            LinearLayout linearLayout4 = ((ItemProductViewBinding) getBinding()).releaseTimeContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.releaseTimeContainer");
            linearLayout4.setVisibility(8);
            TextView textView4 = ((ItemProductViewBinding) getBinding()).noOneRatedView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.noOneRatedView");
            textView4.setVisibility(0);
        } else {
            LinearLayout linearLayout5 = ((ItemProductViewBinding) getBinding()).scoreViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.scoreViewContainer");
            linearLayout5.setVisibility(0);
            LinearLayout linearLayout6 = ((ItemProductViewBinding) getBinding()).releaseTimeContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.releaseTimeContainer");
            linearLayout6.setVisibility(8);
            TextView textView5 = ((ItemProductViewBinding) getBinding()).noOneRatedView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.noOneRatedView");
            textView5.setVisibility(8);
            RatingBar ratingBar = ((ItemProductViewBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
            ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(ownerStarAverageScore));
            RatingBar ratingBar2 = ((ItemProductViewBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(ratingBar2, "binding.ratingBar");
            ratingBar2.setVisibility(0);
            TextView textView6 = ((ItemProductViewBinding) getBinding()).scoreView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.scoreView");
            textView6.setText(KotlinExtendKt.toDisplayScore(ownerStarAverageScore));
        }
        Product product2 = product;
        String optSubTitle = EntityExtendsKt.optSubTitle(product2);
        if (optSubTitle != null) {
            TextView textView7 = ((ItemProductViewBinding) getBinding()).subtitleView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.subtitleView");
            textView7.setText(optSubTitle);
            ((ItemProductViewBinding) getBinding()).subtitleView.setCompoundDrawables(null, null, null, null);
        } else {
            TextView textView8 = ((ItemProductViewBinding) getBinding()).subtitleView;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.subtitleView");
            textView8.setText(KotlinExtendKt.toDisplayString(product.getHotNum()) + "热度  " + KotlinExtendKt.toDisplayString(product.getFeedCommentNum()) + "讨论");
            ((ItemProductViewBinding) getBinding()).subtitleView.setCompoundDrawables(this.fireDrawable, null, null, null);
        }
        if (EntityExtendsKt.getIntExtraData(product2, "showCancelFollowMenu", 0) != 1) {
            z = false;
        }
        if (z) {
            ((ItemProductViewBinding) getBinding()).itemView.setOnLongClickListener(new ProductViewHolder$bindToContent$1(this, product));
        } else {
            ((ItemProductViewBinding) getBinding()).itemView.setOnLongClickListener(null);
        }
        ((ItemProductViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemProductViewBinding itemProductViewBinding = (ItemProductViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductViewBinding, "binding");
        Product model = itemProductViewBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            if (view.getId() != 2131362779) {
                super.onClick(view);
                return;
            }
            ActionManager.startProductActivity(getContext(), model.getId());
            Entity findParentEntity = ViewHolderExtendsKt.findParentEntity(this);
            if (findParentEntity != null && EntityExtendsKt.hasCardStatName(findParentEntity)) {
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                String str = null;
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
                StatisticHelper.recordEntityEvent$default(instance, str, model, getAdapterPosition(), findParentEntity, null, 16, null);
            }
        }
    }
}
