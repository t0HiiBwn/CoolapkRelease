package com.coolapk.market.view.search;

import com.coolapk.market.view.main.TranslucentHeaderConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/TranslucentHeaderConverter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$translucentHeaderConverter$2 extends Lambda implements Function0<TranslucentHeaderConverter> {
    final /* synthetic */ SuperSearchFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperSearchFragment$translucentHeaderConverter$2(SuperSearchFragment superSearchFragment) {
        super(0);
        this.this$0 = superSearchFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TranslucentHeaderConverter invoke() {
        return new TranslucentHeaderConverter(this.this$0);
    }
}
