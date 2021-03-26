package com.coolapk.market.view.node.app;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$viewModel$2 extends Lambda implements Function0<AppNodeViewModel> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$viewModel$2(AppNodeFragment appNodeFragment) {
        super(0);
        this.this$0 = appNodeFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AppNodeViewModel invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Application application = requireActivity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
        return new AppNodeViewModel(application);
    }
}
