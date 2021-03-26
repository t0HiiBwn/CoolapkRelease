package com.coolapk.market.view.backupList;

import android.app.ProgressDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
final class BackupListActivity$postAppList$5<T> implements Action1<Throwable> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ BackupListActivity this$0;

    BackupListActivity$postAppList$5(BackupListActivity backupListActivity, ProgressDialog progressDialog) {
        this.this$0 = backupListActivity;
        this.$dialog = progressDialog;
    }

    public final void call(Throwable th) {
        this.$dialog.dismiss();
        Toast.error(this.this$0.getActivity(), th);
    }
}
