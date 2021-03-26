package com.coolapk.market.view.block;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/block/AddBlockDialog$updateBlockNodes$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
public final class AddBlockDialog$updateBlockNodes$2 extends EmptySubscriber<String> {
    AddBlockDialog$updateBlockNodes$2() {
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Toast.error(AppHolder.getApplication(), th);
    }
}
