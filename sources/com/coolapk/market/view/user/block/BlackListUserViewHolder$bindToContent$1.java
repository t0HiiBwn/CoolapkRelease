package com.coolapk.market.view.user.block;

import android.view.View;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.widget.UserAvatarView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlackListUserViewHolder.kt */
final class BlackListUserViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ User $user;
    final /* synthetic */ BlackListUserViewHolder this$0;

    BlackListUserViewHolder$bindToContent$1(BlackListUserViewHolder blackListUserViewHolder, User user) {
        this.this$0 = blackListUserViewHolder;
        this.$user = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UserAvatarView userAvatarView = ((ItemUserBinding) this.this$0.getBinding()).iconView;
        User user = this.$user;
        String str = null;
        String uid = user != null ? user.getUid() : null;
        User user2 = this.$user;
        if (user2 != null) {
            str = user2.getUserAvatar();
        }
        ActionManager.startUserSpaceActivity(userAvatarView, uid, str);
    }
}
