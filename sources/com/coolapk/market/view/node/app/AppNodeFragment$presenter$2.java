package com.coolapk.market.view.node.app;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$presenter$2 extends Lambda implements Function0<AppNodePresenter> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$presenter$2(AppNodeFragment appNodeFragment) {
        super(0);
        this.this$0 = appNodeFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AppNodePresenter invoke() {
        AppNodeFragment appNodeFragment = this.this$0;
        return new AppNodePresenter(appNodeFragment, appNodeFragment.getViewModel());
    }
}
