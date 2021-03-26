package com.coolapk.market.view.collectionList;

import android.app.ProgressDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateCollectionActivity.kt */
final class CreateCollectionActivity$post$3<T> implements Action1<Throwable> {
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ CreateCollectionActivity this$0;

    CreateCollectionActivity$post$3(CreateCollectionActivity createCollectionActivity, ProgressDialog progressDialog) {
        this.this$0 = createCollectionActivity;
        this.$pDialog = progressDialog;
    }

    public final void call(Throwable th) {
        this.$pDialog.dismiss();
        Toast.error(this.this$0.getActivity(), th);
    }
}
