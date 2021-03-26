package com.coolapk.market.view.dyhv8;

import com.coolapk.market.model.DyhModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dyh", "Lcom/coolapk/market/model/DyhModel;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
final class DyhDetailFragment$onCreateRequest$1<T> implements Action1<DyhModel> {
    final /* synthetic */ DyhDetailFragment this$0;

    DyhDetailFragment$onCreateRequest$1(DyhDetailFragment dyhDetailFragment) {
        this.this$0 = dyhDetailFragment;
    }

    public final void call(DyhModel dyhModel) {
        DyhDetailFragment dyhDetailFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(dyhModel, "dyh");
        dyhDetailFragment.onDyhLoaded(dyhModel);
    }
}
