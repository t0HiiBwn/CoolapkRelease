package com.coolapk.market.view.node.app;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeListFragment.kt */
final class AppNodeListFragment$onRequestResponse$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppNodeListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeListFragment$onRequestResponse$2(AppNodeListFragment appNodeListFragment) {
        super(0);
        this.this$0 = appNodeListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        AppNodePresenter presenter = this.this$0.getPresenter();
        AppNodeViewModel viewModel = this.this$0.getViewModel();
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AppNodePresenter.ratingAppV10$default(presenter, viewModel, requireActivity, 0, false, 12, null);
    }
}
