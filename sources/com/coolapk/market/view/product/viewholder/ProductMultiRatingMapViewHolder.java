package com.coolapk.market.view.product.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductMultiRatingMapBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.view.product.ProductPresenter;
import com.coolapk.market.view.product.ProductViewModel;
import com.coolapk.market.view.product.RatingBarData;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.view.ProductScoreView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductMultiRatingMapViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemProductMultiRatingMapBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "presenter", "Lcom/coolapk/market/view/product/ProductPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/product/ProductViewModel;Lcom/coolapk/market/view/product/ProductPresenter;)V", "getViewModel", "()Lcom/coolapk/market/view/product/ProductViewModel;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductMultiRatingMapViewHolder.kt */
public final class ProductMultiRatingMapViewHolder extends GenericBindHolder<ItemProductMultiRatingMapBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558876;
    private final ProductPresenter presenter;
    private final ProductViewModel viewModel;

    public final ProductViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductMultiRatingMapViewHolder(View view, DataBindingComponent dataBindingComponent, ProductViewModel productViewModel, ProductPresenter productPresenter) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(productPresenter, "presenter");
        this.viewModel = productViewModel;
        this.presenter = productPresenter;
        ItemProductMultiRatingMapBinding itemProductMultiRatingMapBinding = (ItemProductMultiRatingMapBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductMultiRatingMapBinding, "binding");
        itemProductMultiRatingMapBinding.setClick(this);
        TextView textView = ((ItemProductMultiRatingMapBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductMultiRatingMapViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductMultiRatingMapViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        Product model = this.viewModel.getModel();
        ItemProductMultiRatingMapBinding itemProductMultiRatingMapBinding = (ItemProductMultiRatingMapBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemProductMultiRatingMapBinding, "binding");
        itemProductMultiRatingMapBinding.setModel(model);
        TextView textView = ((ItemProductMultiRatingMapBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setText(EntityExtendsKt.getDisplayPerferRatingScore(model));
        TextView textView2 = ((ItemProductMultiRatingMapBinding) getBinding()).ratingCountView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ratingCountView");
        int i = 0;
        textView2.setText(getContext().getString(2131886858, Integer.valueOf(model.getRatingTotalNum())));
        ((ItemProductMultiRatingMapBinding) getBinding()).linearView.setBackgroundColor(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
        ProductGlobalData productGlobalData = ProductGlobalData.INSTANCE;
        String type = model.getType();
        if (type == null) {
            type = "";
        }
        List<RatingBarData> ratingDataList = productGlobalData.getRatingDataList(type);
        if (ratingDataList.isEmpty() || model.getRatingAverageScore() <= ((float) 0)) {
            ProductScoreView productScoreView = ((ItemProductMultiRatingMapBinding) getBinding()).productScoreView;
            Intrinsics.checkNotNullExpressionValue(productScoreView, "binding.productScoreView");
            productScoreView.setVisibility(8);
        } else {
            ProductScoreView productScoreView2 = ((ItemProductMultiRatingMapBinding) getBinding()).productScoreView;
            Intrinsics.checkNotNullExpressionValue(productScoreView2, "binding.productScoreView");
            productScoreView2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (T t : ratingDataList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new Pair(t.getName(), Float.valueOf(EntityExtendsKt.getRatingAverageScoreByIndex(model, i))));
                i = i2;
            }
            ((ItemProductMultiRatingMapBinding) getBinding()).productScoreView.setTypeAndScore(arrayList);
            ((ItemProductMultiRatingMapBinding) getBinding()).productScoreView.requestLayout();
        }
        ((ItemProductMultiRatingMapBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131361982) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        Intrinsics.checkNotNull(activityNullable);
        ProductPresenter.ratingProduct$default(this.presenter, this.viewModel, activityNullable, 0, false, 12, null);
    }
}
