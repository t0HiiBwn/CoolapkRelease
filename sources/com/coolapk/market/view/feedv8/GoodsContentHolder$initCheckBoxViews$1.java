package com.coolapk.market.view.feedv8;

import android.widget.CheckBox;
import com.coolapk.market.model.FeedMultiPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"updateBuyStatus", "", "buy", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$initCheckBoxViews$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.BooleanRef $handleCheckBox;
    final /* synthetic */ GoodsContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsContentHolder$initCheckBoxViews$1(GoodsContentHolder goodsContentHolder, Ref.BooleanRef booleanRef) {
        super(1);
        this.this$0 = goodsContentHolder;
        this.$handleCheckBox = booleanRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$handleCheckBox.element = false;
        GoodsContentHolder goodsContentHolder = this.this$0;
        FeedMultiPart build = goodsContentHolder.getMultiPart().newBuilder().buyStatus(z).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().buyStatus(buy).build()");
        goodsContentHolder.updateMultiPart$presentation_coolapkAppRelease(build);
        CheckBox checkBox = this.this$0.getBinding$presentation_coolapkAppRelease().wishCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.wishCheckBox");
        checkBox.setChecked(!z);
        CheckBox checkBox2 = this.this$0.getBinding$presentation_coolapkAppRelease().buyCheckBox;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.buyCheckBox");
        checkBox2.setChecked(z);
        this.$handleCheckBox.element = true;
    }
}
