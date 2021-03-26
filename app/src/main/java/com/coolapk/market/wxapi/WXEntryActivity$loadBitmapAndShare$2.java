package com.coolapk.market.wxapi;

import android.app.ProgressDialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.view.base.BaseActivity;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/wxapi/WXEntryActivity$loadBitmapAndShare$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WXEntryActivity.kt */
public final class WXEntryActivity$loadBitmapAndShare$2 extends EmptySubscriber<byte[]> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ WXMediaMessage $msg;
    final /* synthetic */ boolean $timeline;
    final /* synthetic */ WXEntryActivity this$0;

    WXEntryActivity$loadBitmapAndShare$2(WXEntryActivity wXEntryActivity, WXMediaMessage wXMediaMessage, boolean z, ProgressDialog progressDialog) {
        this.this$0 = wXEntryActivity;
        this.$msg = wXMediaMessage;
        this.$timeline = z;
        this.$dialog = progressDialog;
    }

    public void onNext(byte[] bArr) {
        super.onNext((WXEntryActivity$loadBitmapAndShare$2) bArr);
        if (bArr != null) {
            this.$msg.thumbData = bArr;
        } else {
            WXMediaMessage wXMediaMessage = this.$msg;
            WXEntryActivity wXEntryActivity = this.this$0;
            BaseActivity activity = wXEntryActivity.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            wXMediaMessage.thumbData = wXEntryActivity.loadDefaultThumbBitmap(activity);
        }
        this.this$0.sendWxRequest(this.$msg, this.$timeline);
        this.$dialog.dismiss();
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        WXMediaMessage wXMediaMessage = this.$msg;
        WXEntryActivity wXEntryActivity = this.this$0;
        BaseActivity activity = wXEntryActivity.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        wXMediaMessage.thumbData = wXEntryActivity.loadDefaultThumbBitmap(activity);
        this.this$0.sendWxRequest(this.$msg, this.$timeline);
        this.$dialog.dismiss();
    }
}
