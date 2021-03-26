package com.coolapk.market.view.node.app;

import com.coolapk.market.view.node.app.AppNodePresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/node/app/AppNodePresenter$Request$Companion$run$1", "Lcom/coolapk/market/view/node/app/AppNodePresenter$Request;", "onCreate", "Lrx/Subscription;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeContract.kt */
public final class AppNodePresenter$Request$Companion$run$1 extends AppNodePresenter.Request {
    final /* synthetic */ Function1 $create;

    AppNodePresenter$Request$Companion$run$1(Function1 function1) {
        this.$create = function1;
    }

    @Override // com.coolapk.market.view.node.app.AppNodePresenter.Request
    public Subscription onCreate() {
        return (Subscription) this.$create.invoke(this);
    }
}
