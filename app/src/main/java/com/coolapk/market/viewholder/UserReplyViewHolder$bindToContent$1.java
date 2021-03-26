package com.coolapk.market.viewholder;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserReplyViewHolder.kt */
final class UserReplyViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ FeedReply $feedReply;
    final /* synthetic */ UserReplyViewHolder this$0;

    UserReplyViewHolder$bindToContent$1(UserReplyViewHolder userReplyViewHolder, FeedReply feedReply) {
        this.this$0 = userReplyViewHolder;
        this.$feedReply = feedReply;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (!loginSession.isAdmin() && !Intrinsics.areEqual(loginSession.getUid(), this.$feedReply.getUid())) {
            return false;
        }
        Activity activity = UiUtils.getActivity(this.this$0.getContext());
        FeedReply feedReply = this.$feedReply;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        EntityExtendsKt.showItemDialog(feedReply, activity);
        return true;
    }
}
