package com.coolapk.market.view.user.profile;

import android.os.Parcelable;
import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
final class UserCoverFragment$presenter$2 extends Lambda implements Function0<UserCoverPresenter> {
    final /* synthetic */ UserCoverFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserCoverFragment$presenter$2(UserCoverFragment userCoverFragment) {
        super(0);
        this.this$0 = userCoverFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final UserCoverPresenter invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("extra_entity");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…rProfile>(EXTRA_ENTITY)!!");
        return new UserCoverPresenter((UserProfile) parcelable, this.this$0);
    }
}
