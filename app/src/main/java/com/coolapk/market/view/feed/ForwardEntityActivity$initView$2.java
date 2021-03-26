package com.coolapk.market.view.feed;

import android.widget.CompoundButton;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
final class ForwardEntityActivity$initView$2 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ForwardEntityActivity this$0;

    ForwardEntityActivity$initView$2(ForwardEntityActivity forwardEntityActivity) {
        this.this$0 = forwardEntityActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.this$0.forwardAndReply = z;
    }
}
