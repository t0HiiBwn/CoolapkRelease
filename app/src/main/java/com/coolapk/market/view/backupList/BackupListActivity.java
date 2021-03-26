package com.coolapk.market.view.backupList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupListActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "backupTitle", "", "getBackupTitle", "()Ljava/lang/String;", "setBackupTitle", "(Ljava/lang/String;)V", "isFromEntrance", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "postAppList", "json", "title", "isCover", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupListActivity.kt */
public final class BackupListActivity extends AlphaToolbarActivity {
    public static final int APP_PICK_REQUEST_CODE = 424;
    public static final Companion Companion = new Companion(null);
    public static final String KEY_BACKUP_CREATE = "KEY_BACKUP_CREATE";
    public static final String TITLE_BACKUP = "TITLE_BACKUP";
    public String backupTitle;
    private boolean isFromEntrance;

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

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        return BackupListFragment.Companion.newInstance();
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_BACKUP_CREATE", false);
        this.isFromEntrance = booleanExtra;
        if (booleanExtra) {
            BackupCreateDialog.Companion.newInstance().show(getSupportFragmentManager(), (String) null);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 424 && intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            String string = extras.getString("app_json");
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNullExpressionValue(string, "data.extras!!.getString(\"app_json\")!!");
            Bundle extras2 = intent.getExtras();
            Intrinsics.checkNotNull(extras2);
            String string2 = extras2.getString("TITLE_BACKUP");
            Intrinsics.checkNotNull(string2);
            Intrinsics.checkNotNullExpressionValue(string2, "data.extras!!.getString(TITLE_BACKUP)!!");
            postAppList$default(this, string, string2, false, 4, null);
        }
    }

    static /* synthetic */ void postAppList$default(BackupListActivity backupListActivity, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        backupListActivity.postAppList(str, str2, z);
    }

    /* access modifiers changed from: private */
    public final void postAppList(String str, String str2, boolean z) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("正在备份中…");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) null;
        DataManager.getInstance().createBackupList(str2, z ? 1 : 0, str).flatMap(new BackupListActivity$postAppList$1(this, objectRef, progressDialog, str, str2, z)).flatMap(new BackupListActivity$postAppList$2(this)).flatMap(new BackupListActivity$postAppList$3(objectRef)).map(RxUtils.checkResult()).compose(RxUtils.apiCommon()).subscribe(new BackupListActivity$postAppList$4(this, progressDialog), new BackupListActivity$postAppList$5(this, progressDialog));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupListActivity$Companion;", "", "()V", "APP_PICK_REQUEST_CODE", "", "KEY_BACKUP_CREATE", "", "TITLE_BACKUP", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
