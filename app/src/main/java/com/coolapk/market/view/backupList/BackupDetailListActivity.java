package com.coolapk.market.view.backupList;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "appList", "", "Lcom/coolapk/market/model/ServiceApp;", "getAppList", "()Ljava/util/List;", "setAppList", "(Ljava/util/List;)V", "backupTitle", "", "getBackupTitle", "()Ljava/lang/String;", "setBackupTitle", "(Ljava/lang/String;)V", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupDetailListActivity.kt */
public final class BackupDetailListActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_BACKUP_ID = "EXTRA_BACKUP_ID";
    public static final String TITLE_BACKUP = "TITLE_BACKUP";
    private List<? extends ServiceApp> appList;
    public String backupTitle;

    public final String getBackupTitle() {
        String str = this.backupTitle;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backupTitle");
        }
        return str;
    }

    public final void setBackupTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backupTitle = str;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.ServiceApp>, java.util.List<com.coolapk.market.model.ServiceApp> */
    public final List<ServiceApp> getAppList() {
        return this.appList;
    }

    public final void setAppList(List<? extends ServiceApp> list) {
        this.appList = list;
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        String string = extras.getString("EXTRA_BACKUP_ID");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "intent.extras!!.getString(EXTRA_BACKUP_ID)!!");
        return BackupDetailListFragment.Companion.newInstance(string);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupDetailListActivity$Companion;", "", "()V", "EXTRA_BACKUP_ID", "", "TITLE_BACKUP", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupDetailListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
