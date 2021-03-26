package com.coolapk.market.event;

import java.util.List;
import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductEvent.kt */
final class ProductEventRequester$requestAddToMediaList$1 implements Action0 {
    final /* synthetic */ List $idList;
    final /* synthetic */ String $mediaID;

    ProductEventRequester$requestAddToMediaList$1(List list, String str) {
        this.$idList = list;
        this.$mediaID = str;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$idList.remove(this.$mediaID);
    }
}
