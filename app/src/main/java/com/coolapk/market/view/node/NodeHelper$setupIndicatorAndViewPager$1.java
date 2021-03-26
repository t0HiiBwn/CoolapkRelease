package com.coolapk.market.view.node;

import com.coolapk.market.viewholder.v8.image.ImageArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lkotlin/ParameterName;", "name", "source", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final /* synthetic */ class NodeHelper$setupIndicatorAndViewPager$1 extends FunctionReferenceImpl implements Function1<String, String> {
    NodeHelper$setupIndicatorAndViewPager$1(ImageArgs.Companion companion) {
        super(1, companion, ImageArgs.Companion.class, "noneProvider", "noneProvider(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        return ((ImageArgs.Companion) this.receiver).noneProvider(str);
    }
}
