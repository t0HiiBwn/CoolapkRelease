package com.coolapk.market.view.search;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchMainListFragment.kt */
final class SearchMainListFragment$returnType$2 extends Lambda implements Function0<String> {
    final /* synthetic */ SearchMainListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchMainListFragment$returnType$2(SearchMainListFragment searchMainListFragment) {
        super(0);
        this.this$0 = searchMainListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("RETURN_TYPE", "all");
    }
}
