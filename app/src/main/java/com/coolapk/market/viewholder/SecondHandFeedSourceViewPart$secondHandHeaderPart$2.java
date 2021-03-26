package com.coolapk.market.viewholder;

import android.view.ViewGroup;
import android.widget.Space;
import com.coolapk.market.databinding.ItemFeedSourcePartBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.widget.hotplug.BaseSecondHandFeedSourceHeaderHotPlug;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/coolapk/market/viewholder/SecondHandFeedSourceViewPart$secondHandHeaderPart$2$1", "invoke", "()Lcom/coolapk/market/viewholder/SecondHandFeedSourceViewPart$secondHandHeaderPart$2$1;"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandFeedSourceViewPart.kt */
final class SecondHandFeedSourceViewPart$secondHandHeaderPart$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ SecondHandFeedSourceViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandFeedSourceViewPart$secondHandHeaderPart$2(SecondHandFeedSourceViewPart secondHandFeedSourceViewPart) {
        super(0);
        this.this$0 = secondHandFeedSourceViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        Space space = ((ItemFeedSourcePartBinding) this.this$0.getBinding()).secondHandInfoSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.secondHandInfoSpaceView");
        return new BaseSecondHandFeedSourceHeaderHotPlug(this, space, SecondHandFeedSourceViewPart.access$getComponent$p(this.this$0)) {
            /* class com.coolapk.market.viewholder.SecondHandFeedSourceViewPart$secondHandHeaderPart$2.AnonymousClass1 */
            final /* synthetic */ SecondHandFeedSourceViewPart$secondHandHeaderPart$2 this$0;

            {
                this.this$0 = r8;
            }

            /* access modifiers changed from: protected */
            @Override // com.coolapk.market.widget.hotplug.BaseSecondHandFeedSourceHeaderHotPlug
            public void onViewPartLoad(FeedSourceSecondHandHeaderViewPart feedSourceSecondHandHeaderViewPart) {
                Intrinsics.checkNotNullParameter(feedSourceSecondHandHeaderViewPart, "viewPart");
                super.onViewPartLoad(feedSourceSecondHandHeaderViewPart);
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(feedSourceSecondHandHeaderViewPart.getView());
                if (marginParams != null) {
                    marginParams.leftMargin = 0;
                    marginParams.rightMargin = 0;
                }
            }
        };
    }
}
