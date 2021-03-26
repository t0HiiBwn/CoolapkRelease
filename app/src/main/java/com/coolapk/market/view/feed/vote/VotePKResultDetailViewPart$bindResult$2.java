package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VotePKResultDetailViewPart.kt */
final class VotePKResultDetailViewPart$bindResult$2 implements View.OnClickListener {
    final /* synthetic */ Feed $data;
    final /* synthetic */ VoteOption $optionRight;
    final /* synthetic */ int[] $pkOptionColors;
    final /* synthetic */ String[] $pkOptionIds;
    final /* synthetic */ VotePKResultDetailViewPart this$0;

    VotePKResultDetailViewPart$bindResult$2(VotePKResultDetailViewPart votePKResultDetailViewPart, Feed feed, VoteOption voteOption, String[] strArr, int[] iArr) {
        this.this$0 = votePKResultDetailViewPart;
        this.$data = feed;
        this.$optionRight = voteOption;
        this.$pkOptionIds = strArr;
        this.$pkOptionColors = iArr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String id = this.$data.getId();
        if (id == null) {
            id = "";
        }
        VoteOption voteOption = this.$optionRight;
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionRight");
        String id2 = voteOption.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "optionRight.id");
        actionManagerCompat.startVoteOptionDetailActivity(context, new VoteCommentConfig(id, id2, this.$pkOptionIds, this.$pkOptionColors));
    }
}
