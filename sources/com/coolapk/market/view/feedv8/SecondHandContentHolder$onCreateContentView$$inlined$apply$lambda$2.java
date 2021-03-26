package com.coolapk.market.view.feedv8;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u0006H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "count", "", "kotlin.jvm.PlatformType", "pickedList", "", "", "", "call", "(Ljava/lang/Integer;Ljava/util/List;)V", "com/coolapk/market/view/feedv8/SecondHandContentHolder$onCreateContentView$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandContentHolder.kt */
final class SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$2<T1, T2> implements Action2<Integer, List<String>> {
    final /* synthetic */ SecondHandContentHolder this$0;

    SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$2(SecondHandContentHolder secondHandContentHolder) {
        this.this$0 = secondHandContentHolder;
    }

    public final void call(Integer num, List<String> list) {
        SecondHandContentHolder secondHandContentHolder = this.this$0;
        Intrinsics.checkNotNullExpressionValue(num, "count");
        int intValue = num.intValue();
        Intrinsics.checkNotNullExpressionValue(list, "pickedList");
        secondHandContentHolder.requestPickPhotos$presentation_coolapkAppRelease(intValue, list);
    }
}
