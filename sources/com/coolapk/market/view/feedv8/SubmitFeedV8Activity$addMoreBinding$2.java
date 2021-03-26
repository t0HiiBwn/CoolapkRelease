package com.coolapk.market.view.feedv8;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.SubmitFeedBottomAddMoreV8Binding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/databinding/SubmitFeedBottomAddMoreV8Binding;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$addMoreBinding$2 extends Lambda implements Function0<SubmitFeedBottomAddMoreV8Binding> {
    final /* synthetic */ SubmitFeedV8Activity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitFeedV8Activity$addMoreBinding$2(SubmitFeedV8Activity submitFeedV8Activity) {
        super(0);
        this.this$0 = submitFeedV8Activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SubmitFeedBottomAddMoreV8Binding invoke() {
        SubmitFeedBottomAddMoreV8Binding submitFeedBottomAddMoreV8Binding = (SubmitFeedBottomAddMoreV8Binding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getActivity()), 2131559163, SubmitFeedV8Activity.access$getBinding$p(this.this$0).fakeKeyboardExtraContainer, false);
        Intrinsics.checkNotNullExpressionValue(submitFeedBottomAddMoreV8Binding, "moreBinding");
        submitFeedBottomAddMoreV8Binding.setUiConfig(this.this$0.getUiConfig());
        submitFeedBottomAddMoreV8Binding.setClick(this.this$0);
        submitFeedBottomAddMoreV8Binding.executePendingBindings();
        return submitFeedBottomAddMoreV8Binding;
    }
}
