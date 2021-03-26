package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.sencondhand.EditSecondHandPriceDialogFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitSecondHandExtraViewPart.kt */
final class SubmitSecondHandExtraViewPart$onRequestSecondHand$1<T> implements Action1<Pair<? extends Integer, ? extends String>> {
    final /* synthetic */ EditSecondHandPriceDialogFragment $dialog;
    final /* synthetic */ int $id;
    final /* synthetic */ SubmitSecondHandExtraViewPart this$0;

    SubmitSecondHandExtraViewPart$onRequestSecondHand$1(SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart, int i, EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment) {
        this.this$0 = submitSecondHandExtraViewPart;
        this.$id = i;
        this.$dialog = editSecondHandPriceDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Pair<? extends Integer, ? extends String> pair) {
        call((Pair<Integer, String>) pair);
    }

    public final void call(Pair<Integer, String> pair) {
        SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart = this.this$0;
        Intrinsics.checkNotNullExpressionValue(pair, "it");
        submitSecondHandExtraViewPart.onPickSHPirce(pair, this.$id);
        this.$dialog.dismiss();
    }
}
