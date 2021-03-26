package com.coolapk.market.view.node.app;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getRateNumMax", "", "rateNums", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeViewPart.kt */
final class AppNodeViewPart$bindRatingContent$1 extends Lambda implements Function1<int[], Integer> {
    public static final AppNodeViewPart$bindRatingContent$1 INSTANCE = new AppNodeViewPart$bindRatingContent$1();

    AppNodeViewPart$bindRatingContent$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(int[] iArr) {
        return Integer.valueOf(invoke(iArr));
    }

    public final int invoke(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "rateNums");
        Arrays.sort(iArr);
        return Math.max(0, iArr[iArr.length - 1]);
    }
}
