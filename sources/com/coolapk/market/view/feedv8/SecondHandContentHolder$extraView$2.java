package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.view.LayoutInflater;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/SubmitSecondHandExtraViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandContentHolder.kt */
final class SecondHandContentHolder$extraView$2 extends Lambda implements Function0<SubmitSecondHandExtraViewPart> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandContentHolder$extraView$2(Activity activity) {
        super(0);
        this.$activity = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SubmitSecondHandExtraViewPart invoke() {
        SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart = new SubmitSecondHandExtraViewPart();
        LayoutInflater from = LayoutInflater.from(this.$activity);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        submitSecondHandExtraViewPart.createView(from, null);
        Activity activity = this.$activity;
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.SubmitFeedV8Activity");
        submitSecondHandExtraViewPart.initWith((SubmitFeedV8Activity) activity);
        return submitSecondHandExtraViewPart;
    }
}
