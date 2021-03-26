package com.coolapk.market.event;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/event/ProductEventDispatcher;", "", "()V", "dispatchFollowResult", "", "id", "", "error", "", "resultState", "", "dispatchLikeResult", "product", "Lcom/coolapk/market/model/Product;", "dispatchWishResult", "wishState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductEvent.kt */
public final class ProductEventDispatcher {
    public static final ProductEventDispatcher INSTANCE = new ProductEventDispatcher();

    private ProductEventDispatcher() {
    }

    public final void dispatchFollowResult(String str, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (th == null) {
            EventBus.getDefault().post(new ProductEvent(str, "follow_event", Boolean.valueOf(z)));
        } else {
            Toast.error(AppHolder.getApplication(), th);
        }
    }

    public final void dispatchLikeResult(String str, Throwable th, Product product) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (th == null) {
            EventBus.getDefault().post(new ProductEvent(str, "like_event", product));
        } else {
            Toast.error(AppHolder.getApplication(), th);
        }
    }

    public final void dispatchWishResult(String str, Throwable th, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (th == null) {
            EventBus.getDefault().post(new ProductEvent(str, "wish_event", Boolean.valueOf(z)));
        } else {
            Toast.error(AppHolder.getApplication(), th);
        }
    }
}
