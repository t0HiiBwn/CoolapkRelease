package com.coolapk.market.view.node.rating;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserNodeRatingViewHolder.kt */
final class UserNodeRatingViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ UserNodeRatingViewHolder this$0;

    UserNodeRatingViewHolder$bindToContent$1(UserNodeRatingViewHolder userNodeRatingViewHolder) {
        this.this$0 = userNodeRatingViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        UserNodeRatingViewHolder.access$showAdminDialog(this.this$0);
        return true;
    }
}
