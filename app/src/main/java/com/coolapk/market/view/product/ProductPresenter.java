package com.coolapk.market.view.product;

import android.app.Activity;
import com.coolapk.market.event.ProductEventRequester;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Product;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.view.product.ProductView;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/product/ProductPresenter;", "", "view", "Lcom/coolapk/market/view/product/ProductView;", "(Lcom/coolapk/market/view/product/ProductView;)V", "getView", "()Lcom/coolapk/market/view/product/ProductView;", "commentProduct", "", "activity", "Landroid/app/Activity;", "product", "Lcom/coolapk/market/model/Product;", "followProduct", "", "id", "", "oldValue", "newValue", "ratingProduct", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "context", "startCount", "", "collapsedRatingText", "wishProduct", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductViewModel.kt */
public final class ProductPresenter {
    private final ProductView view;

    public ProductPresenter(ProductView productView) {
        Intrinsics.checkNotNullParameter(productView, "view");
        this.view = productView;
    }

    public final ProductView getView() {
        return this.view;
    }

    public final boolean followProduct(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        boolean requestFollow = ProductEventRequester.INSTANCE.requestFollow(str, z2, new ProductPresenter$followProduct$accepted$2(this, z, z2), new ProductPresenter$followProduct$accepted$1(this, z, z2));
        if (requestFollow) {
            StatisticHelper.Companion.getInstance().recordPhoneBarAction("点击关注");
            ProductView.DefaultImpls.onFollowStateChanged$default(this.view, z, z2, null, 4, null);
        }
        return requestFollow;
    }

    public final boolean wishProduct(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        boolean requestWish = ProductEventRequester.INSTANCE.requestWish(str, z2, new ProductPresenter$wishProduct$accepted$2(this, z, z2), new ProductPresenter$wishProduct$accepted$1(this, z, z2));
        if (requestWish) {
            ProductView.DefaultImpls.onWishStateChanged$default(this.view, z, z2, null, 4, null);
        }
        return requestWish;
    }

    public final void commentProduct(Activity activity, Product product) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(product, "product");
        FeedMultiPart build = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), product).build();
        Activity activity2 = activity;
        FeedUIConfig build2 = FeedArgsFactoryKt.applyProduct(FeedArgsFactory.uiConfigForFeed(activity2), activity2, product).title("发讨论").build();
        StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("讨论");
        ActionManager.startSubmitFeedV8Activity(activity, build2, build);
    }

    public static /* synthetic */ void ratingProduct$default(ProductPresenter productPresenter, ProductViewModel productViewModel, Activity activity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = productViewModel.getRatingScore();
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        productPresenter.ratingProduct(productViewModel, activity, i, z);
    }

    public final void ratingProduct(ProductViewModel productViewModel, Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(activity, "context");
        if (!productViewModel.getModel().isReleased()) {
            Toast.show$default(activity, "产品暂未发布，无法点评", 0, false, 12, null);
        } else if (productViewModel.getModel().getAllowRating() == 0) {
            Toast.show$default(activity, "产品暂未开放点评", 0, false, 12, null);
        } else {
            if (productViewModel.getRatingState()) {
                if (productViewModel.getRatingFeedUrl().length() > 0) {
                    ActionManagerCompat.startActivityByUrl$default(activity, productViewModel.getRatingFeedUrl(), null, null, 12, null);
                    return;
                }
            }
            Product model = productViewModel.getModel();
            FeedMultiPart build = FeedArgsFactoryKt.applyToRating(FeedArgsFactoryKt.applyProduct(FeedArgsFactory.multiPartForFeed(), model)).ratingScore1(i).buyStatus(productViewModel.getBuyStatus()).build();
            Activity activity2 = activity;
            FeedUIConfig build2 = FeedArgsFactoryKt.applyToRating(FeedArgsFactoryKt.applyProduct(FeedArgsFactory.uiConfigForFeed(activity2), activity2, model), "product_phone").isRatingTextCollapsed(z).build();
            StatisticHelper.Companion.getInstance().recordPhoneBarPostEvent("点评");
            ActionManager.startSubmitFeedV8Activity(activity, build2, build);
        }
    }
}
