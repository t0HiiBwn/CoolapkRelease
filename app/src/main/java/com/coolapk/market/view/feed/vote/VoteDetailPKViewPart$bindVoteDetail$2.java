package com.coolapk.market.view.feed.vote;

import android.view.View;
import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VotePKViewPart.kt */
final class VoteDetailPKViewPart$bindVoteDetail$2 implements View.OnClickListener {
    final /* synthetic */ VoteOption $optionRight;
    final /* synthetic */ Function1 $voteListener;

    VoteDetailPKViewPart$bindVoteDetail$2(Function1 function1, VoteOption voteOption) {
        this.$voteListener = function1;
        this.$optionRight = voteOption;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$voteListener;
        VoteOption voteOption = this.$optionRight;
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionRight");
        String id = voteOption.getId();
        Intrinsics.checkNotNullExpressionValue(id, "optionRight.id");
        function1.invoke(id);
    }
}
