package com.coolapk.market.view.ad;

import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawNewsViewHolder.kt */
final class SponsorSelfDrawNewsViewHolder$updateContentView$6 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ int $videoHeight;
    final /* synthetic */ int $videoWidth;
    final /* synthetic */ SponsorSelfDrawNewsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SponsorSelfDrawNewsViewHolder$updateContentView$6(SponsorSelfDrawNewsViewHolder sponsorSelfDrawNewsViewHolder, int i, int i2) {
        super(1);
        this.this$0 = sponsorSelfDrawNewsViewHolder;
        this.$videoWidth = i;
        this.$videoHeight = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        MaxWidthFrameLayout maxWidthFrameLayout = this.this$0.binding.contentView;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.contentView");
        maxWidthFrameLayout.getLayoutParams().height = (int) (((double) i) / (((double) this.$videoWidth) / ((double) this.$videoHeight)));
    }
}
