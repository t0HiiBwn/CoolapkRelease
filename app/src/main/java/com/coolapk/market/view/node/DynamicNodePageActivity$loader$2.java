package com.coolapk.market.view.node;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/node/Loader;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
final class DynamicNodePageActivity$loader$2 extends Lambda implements Function0<Loader> {
    final /* synthetic */ DynamicNodePageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamicNodePageActivity$loader$2(DynamicNodePageActivity dynamicNodePageActivity) {
        super(0);
        this.this$0 = dynamicNodePageActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Loader invoke() {
        DynamicNodePageActivity dynamicNodePageActivity = this.this$0;
        String stringExtra = dynamicNodePageActivity.getIntent().getStringExtra("LOADER_NAME");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_LOADER_NAME)!!");
        return dynamicNodePageActivity.getLoader(stringExtra);
    }
}
