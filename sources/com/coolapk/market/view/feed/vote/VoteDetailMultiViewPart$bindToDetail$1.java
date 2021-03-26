package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
final class VoteDetailMultiViewPart$bindToDetail$1 implements View.OnClickListener {
    final /* synthetic */ VoteOption $option;
    final /* synthetic */ String $voteId;
    final /* synthetic */ VoteDetailMultiViewPart this$0;

    VoteDetailMultiViewPart$bindToDetail$1(VoteDetailMultiViewPart voteDetailMultiViewPart, String str, VoteOption voteOption) {
        this.this$0 = voteDetailMultiViewPart;
        this.$voteId = str;
        this.$option = voteOption;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
        Context context = this.this$0.getContext();
        String str = this.$voteId;
        String id = this.$option.getId();
        Intrinsics.checkNotNullExpressionValue(id, "option.id");
        actionManagerCompat.startVoteOptionDetailActivity(context, new VoteCommentConfig(str, id, null, null, 12, null));
    }
}
