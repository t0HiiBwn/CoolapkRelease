package com.coolapk.market.view.live;

import android.widget.FrameLayout;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$showSelectLineView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LiveVideoViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveVideoViewPart$showSelectLineView$1(LiveVideoViewPart liveVideoViewPart) {
        super(0);
        this.this$0 = liveVideoViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).selectLineView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.selectLineView");
        frameLayout.setVisibility(8);
    }
}
