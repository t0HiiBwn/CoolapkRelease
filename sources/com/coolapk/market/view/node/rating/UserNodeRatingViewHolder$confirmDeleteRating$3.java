package com.coolapk.market.view.node.rating;

import android.content.DialogInterface;
import com.coolapk.market.model.NodeRating;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserNodeRatingViewHolder.kt */
final class UserNodeRatingViewHolder$confirmDeleteRating$3 implements DialogInterface.OnClickListener {
    final /* synthetic */ NodeRating $data;
    final /* synthetic */ UserNodeRatingViewHolder this$0;

    UserNodeRatingViewHolder$confirmDeleteRating$3(UserNodeRatingViewHolder userNodeRatingViewHolder, NodeRating nodeRating) {
        this.this$0 = userNodeRatingViewHolder;
        this.$data = nodeRating;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        UserNodeRatingViewHolder.access$deleteNodeRating(this.this$0, this.$data, 1);
    }
}
