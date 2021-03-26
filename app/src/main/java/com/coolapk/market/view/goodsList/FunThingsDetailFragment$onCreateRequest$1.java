package com.coolapk.market.view.goodsList;

import com.coolapk.market.model.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "collection", "Lcom/coolapk/market/model/Collection;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FunThingsDetailFragment.kt */
final class FunThingsDetailFragment$onCreateRequest$1<T> implements Action1<Collection> {
    final /* synthetic */ FunThingsDetailFragment this$0;

    FunThingsDetailFragment$onCreateRequest$1(FunThingsDetailFragment funThingsDetailFragment) {
        this.this$0 = funThingsDetailFragment;
    }

    public final void call(Collection collection) {
        FunThingsDetailFragment funThingsDetailFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(collection, "collection");
        FunThingsDetailFragment.access$onCollectionLoaded(funThingsDetailFragment, collection);
    }
}
