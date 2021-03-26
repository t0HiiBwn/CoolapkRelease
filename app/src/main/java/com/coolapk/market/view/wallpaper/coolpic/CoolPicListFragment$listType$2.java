package com.coolapk.market.view.wallpaper.coolpic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolPicListFragment.kt */
final class CoolPicListFragment$listType$2 extends Lambda implements Function0<String> {
    final /* synthetic */ CoolPicListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoolPicListFragment$listType$2(CoolPicListFragment coolPicListFragment) {
        super(0);
        this.this$0 = coolPicListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String string = this.this$0.requireArguments().getString("listType");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getSt…Activity.KEY_LIST_TYPE)!!");
        return string;
    }
}
