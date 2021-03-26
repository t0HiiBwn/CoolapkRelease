package com.coolapk.market.view.userv9;

import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/coolapk/market/model/UserProfile;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
final /* synthetic */ class UserSpaceV9Presenter$loadUserProfile$1 extends FunctionReferenceImpl implements Function1<UserProfile, Unit> {
    UserSpaceV9Presenter$loadUserProfile$1(UserSpaceV9Presenter userSpaceV9Presenter) {
        super(1, userSpaceV9Presenter, UserSpaceV9Presenter.class, "internalOnUserProfiledLoad", "internalOnUserProfiledLoad(Lcom/coolapk/market/model/UserProfile;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
        invoke(userProfile);
        return Unit.INSTANCE;
    }

    public final void invoke(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "p1");
        ((UserSpaceV9Presenter) this.receiver).internalOnUserProfiledLoad(userProfile);
    }
}
