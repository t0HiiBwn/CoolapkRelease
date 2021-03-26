package com.coolapk.market.view.product.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import com.coolapk.market.databinding.ItemSingleRatingBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.node.util.BaseSingleRatingViewHolder;
import com.coolapk.market.view.product.ProductPresenter;
import com.coolapk.market.view.product.ProductViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSingleRatingViewHolder;", "Lcom/coolapk/market/view/node/util/BaseSingleRatingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "presenter", "Lcom/coolapk/market/view/product/ProductPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/product/ProductViewModel;Lcom/coolapk/market/view/product/ProductPresenter;)V", "bindToContent", "", "data", "Lcom/coolapk/market/model/Entity;", "getRatingFeedUrl", "", "getStarCount", "", "onRequestRatingFeed", "rating", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductSingleRatingViewHolder.kt */
public final class ProductSingleRatingViewHolder extends BaseSingleRatingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558934;
    private final ProductPresenter presenter;
    private final ProductViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductSingleRatingViewHolder(View view, DataBindingComponent dataBindingComponent, ProductViewModel productViewModel, ProductPresenter productPresenter) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(productPresenter, "presenter");
        this.viewModel = productViewModel;
        this.presenter = productPresenter;
        productViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback(this) {
            /* class com.coolapk.market.view.product.viewholder.ProductSingleRatingViewHolder.AnonymousClass1 */
            final /* synthetic */ ProductSingleRatingViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 228) {
                    this.this$0.requestStarCountChanged();
                }
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/ProductSingleRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductSingleRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder, com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        ItemSingleRatingBinding itemSingleRatingBinding = (ItemSingleRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSingleRatingBinding, "binding");
        itemSingleRatingBinding.setBuyStatus(this.viewModel.getBuyStatus() ? 1 : 0);
        super.bindToContent(entity);
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public int getStarCount() {
        return this.viewModel.getRatingScore();
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public String getRatingFeedUrl() {
        return this.viewModel.getRatingFeedUrl();
    }

    @Override // com.coolapk.market.view.node.util.BaseSingleRatingViewHolder
    public void onRequestRatingFeed(int i) {
        ProductPresenter productPresenter = this.presenter;
        ProductViewModel productViewModel = this.viewModel;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        Intrinsics.checkNotNull(activityNullable);
        productPresenter.ratingProduct(productViewModel, activityNullable, i, true);
    }
}
