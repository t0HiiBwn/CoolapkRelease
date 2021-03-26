package com.coolapk.market.view.center;

import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/UserProfile;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
final class CenterV9Fragment$onCreateRequest$2<T> implements Action1<UserProfile> {
    final /* synthetic */ CenterV9Fragment this$0;

    CenterV9Fragment$onCreateRequest$2(CenterV9Fragment centerV9Fragment) {
        this.this$0 = centerV9Fragment;
    }

    public final void call(UserProfile userProfile) {
        CenterPresenter centerPresenter = this.this$0.centerPresenter;
        Intrinsics.checkNotNullExpressionValue(userProfile, "it");
        centerPresenter.requestUpdateProfile(userProfile);
        if (userProfile.getUserNameStatus() < 0) {
            this.this$0.showUserNameInvalidDialog();
        }
    }
}
