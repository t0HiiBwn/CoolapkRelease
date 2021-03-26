package com.coolapk.market.view.backupList;

import android.app.ProgressDialog;
import androidx.fragment.app.Fragment;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.network.Result;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/BackupInfo;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
final class BackupListActivity$postAppList$4<T> implements Action1<Result<BackupInfo>> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ BackupListActivity this$0;

    BackupListActivity$postAppList$4(BackupListActivity backupListActivity, ProgressDialog progressDialog) {
        this.this$0 = backupListActivity;
        this.$dialog = progressDialog;
    }

    public final void call(Result<BackupInfo> result) {
        Fragment fragment = this.this$0.getFragment();
        Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.coolapk.market.view.backupList.BackupListFragment");
        Intrinsics.checkNotNullExpressionValue(result, "it");
        BackupInfo data = result.getData();
        Intrinsics.checkNotNullExpressionValue(data, "it.data");
        BackupListFragment.putBackupInfo$default((BackupListFragment) fragment, data, false, 2, null);
        this.$dialog.dismiss();
    }
}
