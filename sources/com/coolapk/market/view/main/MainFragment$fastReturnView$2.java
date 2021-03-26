package com.coolapk.market.view.main;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.widget.FastReturnView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/FastReturnView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$fastReturnView$2 extends Lambda implements Function0<FastReturnView> {
    final /* synthetic */ MainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainFragment$fastReturnView$2(MainFragment mainFragment) {
        super(0);
        this.this$0 = mainFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FastReturnView invoke() {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return new FastReturnView(requireActivity);
    }
}
