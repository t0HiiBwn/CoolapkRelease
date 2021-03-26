package com.coolapk.market.view.feedv8;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.ToastKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feedv8/MobileCodeVerifyDialog$requestVerify$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
public final class MobileCodeVerifyDialog$requestVerify$2 extends EmptySubscriber<Result<String>> {
    final /* synthetic */ MobileCodeVerifyDialog this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MobileCodeVerifyDialog$requestVerify$2(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        this.this$0 = mobileCodeVerifyDialog;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        this.this$0.isVerifying = false;
        Throwable mayBeCause = ToastKt.getMayBeCause(th);
        if (mayBeCause instanceof ClientException) {
            MobileCodeVerifyDialog mobileCodeVerifyDialog = this.this$0;
            String message = mayBeCause.getMessage();
            if (message == null) {
                message = "";
            }
            mobileCodeVerifyDialog.setErrorText(message);
            return;
        }
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(Result<String> result) {
        Intrinsics.checkNotNullParameter(result, "t");
        super.onNext((MobileCodeVerifyDialog$requestVerify$2) result);
        AppHolder.getMainThreadHandler().postDelayed(new MobileCodeVerifyDialog$requestVerify$2$onNext$1(this, result), 400);
        this.this$0.isVerifying = false;
        this.this$0.dismiss();
        Function0 function0 = this.this$0.callback;
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}