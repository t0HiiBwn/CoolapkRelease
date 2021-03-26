package com.coolapk.market.view.photo;

import android.app.ProgressDialog;
import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$processAppQrCode$1 implements Action0 {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ QRCodeActivity this$0;

    QRCodeActivity$processAppQrCode$1(QRCodeActivity qRCodeActivity, ProgressDialog progressDialog) {
        this.this$0 = qRCodeActivity;
        this.$dialog = progressDialog;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.parsingQRText = false;
        this.$dialog.dismiss();
    }
}
