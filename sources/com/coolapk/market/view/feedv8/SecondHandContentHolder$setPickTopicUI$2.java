package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandContentHolder.kt */
final class SecondHandContentHolder$setPickTopicUI$2 implements View.OnClickListener {
    final /* synthetic */ SecondHandContentHolder this$0;

    SecondHandContentHolder$setPickTopicUI$2(SecondHandContentHolder secondHandContentHolder) {
        this.this$0 = secondHandContentHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startProductBrandListInErshouActivity(this.this$0.getActivity(), 2, this.this$0.getUiConfig().secondHandDealType(), 2323);
    }
}
