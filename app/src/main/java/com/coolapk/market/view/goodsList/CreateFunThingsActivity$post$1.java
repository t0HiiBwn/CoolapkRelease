package com.coolapk.market.view.goodsList;

import android.app.ProgressDialog;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateFunThingsActivity.kt */
final class CreateFunThingsActivity$post$1<T> implements Action1<String> {
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ CreateFunThingsActivity this$0;

    CreateFunThingsActivity$post$1(CreateFunThingsActivity createFunThingsActivity, ProgressDialog progressDialog) {
        this.this$0 = createFunThingsActivity;
        this.$pDialog = progressDialog;
    }

    public final void call(String str) {
        CreateFunThingsActivity.access$getFunThingsViewModel$p(this.this$0).setFunThingsId(str);
        this.$pDialog.dismiss();
        ActionManager.startFeedDetailActivity(this.this$0.getActivity(), str, (String) null);
        this.this$0.finish();
    }
}