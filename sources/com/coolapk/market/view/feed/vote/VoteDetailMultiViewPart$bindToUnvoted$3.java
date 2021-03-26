package com.coolapk.market.view.feed.vote;

import android.view.View;
import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
final class VoteDetailMultiViewPart$bindToUnvoted$3 implements View.OnClickListener {
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ Function2 $onCheckListener;
    final /* synthetic */ VoteOption $option;
    final /* synthetic */ VoteDetailMultiViewPart this$0;

    VoteDetailMultiViewPart$bindToUnvoted$3(VoteDetailMultiViewPart voteDetailMultiViewPart, Function2 function2, VoteOption voteOption, boolean z) {
        this.this$0 = voteDetailMultiViewPart;
        this.$onCheckListener = function2;
        this.$option = voteOption;
        this.$isChecked = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2 = this.$onCheckListener;
        String id = this.$option.getId();
        Intrinsics.checkNotNullExpressionValue(id, "option.id");
        if (((Boolean) function2.invoke(id, Boolean.valueOf(!this.$isChecked))).booleanValue()) {
            this.this$0.bindToUnvoted(this.$option, !this.$isChecked, this.$onCheckListener);
        }
    }
}
