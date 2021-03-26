package com.coolapk.market.view.userv9;

import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserHeaderInfoViewPart.kt */
final class UserHeaderInfoViewPart$setFlowLayoutView$userDataListener$1 implements View.OnClickListener {
    final /* synthetic */ UserProfile $data;
    final /* synthetic */ UserHeaderInfoViewPart this$0;

    UserHeaderInfoViewPart$setFlowLayoutView$userDataListener$1(UserHeaderInfoViewPart userHeaderInfoViewPart, UserProfile userProfile) {
        this.this$0 = userHeaderInfoViewPart;
        this.$data = userProfile;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManagerCompat.INSTANCE.startUserDataActivity(this.this$0.getContext(), this.$data);
    }
}
