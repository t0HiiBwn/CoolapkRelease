package com.coolapk.market.view.feedv8;

import android.app.ProgressDialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/SubmitFeedV8Activity$loadVideoInfo$subscription$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
public final class SubmitFeedV8Activity$loadVideoInfo$subscription$1 extends EmptySubscriber<String> {
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ String $url;
    final /* synthetic */ SubmitFeedV8Activity this$0;

    SubmitFeedV8Activity$loadVideoInfo$subscription$1(SubmitFeedV8Activity submitFeedV8Activity, ProgressDialog progressDialog, String str) {
        this.this$0 = submitFeedV8Activity;
        this.$pDialog = progressDialog;
        this.$url = str;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        this.$pDialog.dismiss();
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.$pDialog.dismiss();
        SubmitFeedV8Activity.access$getContentHolder$p(this.this$0).onVideoDataLoaded(str, this.$url);
        this.this$0.closeKeyboardOrFakeKeyboard();
    }
}
