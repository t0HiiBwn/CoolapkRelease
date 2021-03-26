package com.coolapk.market.view.product;

import com.coolapk.market.model.Product;

/* compiled from: ProductViewModel.kt */
public interface ProductView {
    void onFollowStateChanged(boolean z, boolean z2, Throwable th);

    void onProductChanged(Product product);

    void onWishStateChanged(boolean z, boolean z2, Throwable th);

    /* compiled from: ProductViewModel.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onFollowStateChanged$default(ProductView productView, boolean z, boolean z2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                productView.onFollowStateChanged(z, z2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFollowStateChanged");
        }

        public static /* synthetic */ void onWishStateChanged$default(ProductView productView, boolean z, boolean z2, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    th = null;
                }
                productView.onWishStateChanged(z, z2, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onWishStateChanged");
        }
    }
}
