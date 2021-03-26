package com.coolapk.market.view.goods;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchHistoryHelper.kt */
final class GoodsSearchHistoryHelper$addWords$1$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ String $notBlankWord;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsSearchHistoryHelper$addWords$1$1(String str) {
        super(1);
        this.$notBlankWord = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke(str));
    }

    public final boolean invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return Intrinsics.areEqual(str, this.$notBlankWord);
    }
}
