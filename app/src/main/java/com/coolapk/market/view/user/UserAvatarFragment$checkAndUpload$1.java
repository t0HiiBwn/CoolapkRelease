package com.coolapk.market.view.user;

import android.app.ProgressDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/user/UserAvatarFragment$checkAndUpload$1", "Lrx/Subscriber;", "", "onCompleted", "", "onError", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserAvatarFragment.kt */
public final class UserAvatarFragment$checkAndUpload$1 extends Subscriber<String> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ UserAvatarFragment this$0;

    UserAvatarFragment$checkAndUpload$1(UserAvatarFragment userAvatarFragment, ProgressDialog progressDialog) {
        this.this$0 = userAvatarFragment;
        this.$dialog = progressDialog;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.this$0.mPostRequest = false;
        this.$dialog.dismiss();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        this.$dialog.dismiss();
        this.this$0.mPostRequest = false;
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        this.this$0.onUploadSucceed(str);
        this.this$0.mPostRequest = false;
    }
}
