package com.coolapk.market.view.node.app;

import com.coolapk.market.view.app.AppDetailPresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/app/AppDetailPresenter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppDetailListFragment.kt */
final class AppDetailListFragment$presenter$2 extends Lambda implements Function0<AppDetailPresenter> {
    final /* synthetic */ AppDetailListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppDetailListFragment$presenter$2(AppDetailListFragment appDetailListFragment) {
        super(0);
        this.this$0 = appDetailListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AppDetailPresenter invoke() {
        return new AppDetailPresenter(this.this$0);
    }
}
