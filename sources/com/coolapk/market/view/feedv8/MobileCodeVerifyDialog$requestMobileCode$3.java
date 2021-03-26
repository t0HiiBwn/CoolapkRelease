package com.coolapk.market.view.feedv8;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.ToastKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/MobileCodeVerifyDialog$requestMobileCode$3", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
public final class MobileCodeVerifyDialog$requestMobileCode$3 extends EmptySubscriber<Result<String>> {
    final /* synthetic */ MobileCodeVerifyDialog this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MobileCodeVerifyDialog$requestMobileCode$3(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        this.this$0 = mobileCodeVerifyDialog;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        MobileCodeVerifyDialog.access$setVerifying$p(this.this$0, false);
        Throwable mayBeCause = ToastKt.getMayBeCause(th);
        if (mayBeCause instanceof ClientException) {
            MobileCodeVerifyDialog mobileCodeVerifyDialog = this.this$0;
            String message = mayBeCause.getMessage();
            if (message == null) {
                message = "";
            }
            MobileCodeVerifyDialog.access$setErrorText(mobileCodeVerifyDialog, message);
        } else {
            Toast.error(this.this$0.getActivity(), th);
        }
        MobileCodeVerifyDialog.access$setRequestMobileCodeEnable(this.this$0, true);
    }

    public void onNext(Result<String> result) {
        Intrinsics.checkNotNullParameter(result, "t");
        super.onNext((MobileCodeVerifyDialog$requestMobileCode$3) result);
        MobileCodeVerifyDialog.access$setVerifying$p(this.this$0, false);
        MobileCodeVerifyDialog.access$setHadSendSms$p(this.this$0, true);
        Toast.show$default(this.this$0.getActivity(), result.getData(), 0, false, 12, null);
    }
}
