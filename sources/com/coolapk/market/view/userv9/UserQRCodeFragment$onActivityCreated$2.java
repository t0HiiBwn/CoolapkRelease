package com.coolapk.market.view.userv9;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/userv9/UserQRCodeFragment$onActivityCreated$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/UserProfile;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserQRCodeFragment.kt */
public final class UserQRCodeFragment$onActivityCreated$2 extends EmptySubscriber<UserProfile> {
    final /* synthetic */ UserQRCodeFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    UserQRCodeFragment$onActivityCreated$2(UserQRCodeFragment userQRCodeFragment) {
        this.this$0 = userQRCodeFragment;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "t");
        super.onNext((UserQRCodeFragment$onActivityCreated$2) userProfile);
        this.this$0.setupView(userProfile);
    }
}
