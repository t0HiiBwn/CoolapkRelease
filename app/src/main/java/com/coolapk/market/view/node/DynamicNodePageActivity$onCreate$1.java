package com.coolapk.market.view.node;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "t", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
final class DynamicNodePageActivity$onCreate$1<T> implements Action1<Entity> {
    final /* synthetic */ DynamicNodePageActivity this$0;

    DynamicNodePageActivity$onCreate$1(DynamicNodePageActivity dynamicNodePageActivity) {
        this.this$0 = dynamicNodePageActivity;
    }

    public final void call(Entity entity) {
        DynamicNodePageActivity dynamicNodePageActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(entity, "t");
        dynamicNodePageActivity.onDataLoad(entity);
        this.this$0.delayShowContentView();
    }
}
