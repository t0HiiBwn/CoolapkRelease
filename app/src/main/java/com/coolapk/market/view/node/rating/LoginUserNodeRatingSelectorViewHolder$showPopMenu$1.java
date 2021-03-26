package com.coolapk.market.view.node.rating;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LoginUserNodeRatingSelectorViewHolder.kt */
final class LoginUserNodeRatingSelectorViewHolder$showPopMenu$1 implements PopupMenu.OnMenuItemClickListener {
    final /* synthetic */ NodeRatingArgs $args;
    final /* synthetic */ LoginUserNodeRatingSelectorViewHolder this$0;

    LoginUserNodeRatingSelectorViewHolder$showPopMenu$1(LoginUserNodeRatingSelectorViewHolder loginUserNodeRatingSelectorViewHolder, NodeRatingArgs nodeRatingArgs) {
        this.this$0 = loginUserNodeRatingSelectorViewHolder;
        this.$args = nodeRatingArgs;
    }

    /* renamed from: invoke */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intrinsics.checkNotNullExpressionValue(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            this.this$0.updateArgs(NodeRatingArgs.copy$default(this.$args, null, null, null, null, false, null, null, null, 0, 0, 1021, null));
        } else if (itemId == 1) {
            this.this$0.updateArgs(NodeRatingArgs.copy$default(this.$args, null, "7", null, null, false, null, null, null, 0, 0, 1021, null));
        } else if (itemId == 2) {
            this.this$0.updateArgs(NodeRatingArgs.copy$default(this.$args, null, "1", null, null, false, null, null, null, 0, 0, 1021, null));
        }
        return true;
    }
}
