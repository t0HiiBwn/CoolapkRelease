package com.coolapk.market.view.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.view.base.BaseDialogFragment;

public class VersionLower2AlertDialog extends BaseDialogFragment {
    public static final int TYPE_DOWNLOAD = 1;

    public static VersionLower2AlertDialog newInstance(AppForum appForum, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("app", appForum);
        bundle.putInt("urlType", i);
        bundle.putInt("flag", i2);
        VersionLower2AlertDialog versionLower2AlertDialog = new VersionLower2AlertDialog();
        versionLower2AlertDialog.setArguments(bundle);
        return versionLower2AlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final AppForum appForum = (AppForum) getArguments().getParcelable("app");
        if (appForum == null) {
            return null;
        }
        int i = getArguments().getInt("urlType");
        final int i2 = getArguments().getInt("flag");
        final String downloadUrlMd5 = appForum.getDownloadUrlMd5(i);
        return new AlertDialog.Builder(getActivity()).setMessage(getString(2131886767, appForum.appName())).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.VersionLower2AlertDialog.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DownloadState downloadState = DataManager.getInstance().getDownloadState(downloadUrlMd5);
                Extra extra = downloadState != null ? downloadState.getExtra() : null;
                if (extra == null) {
                    extra = new Extra();
                }
                extra.put("EXTRA_ANALYSIS_DATA", appForum.extraAnalysisData());
                ActionManager.startDownload(VersionLower2AlertDialog.this.getActivity(), downloadUrlMd5, extra, i2);
            }
        }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.VersionLower2AlertDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create();
    }
}
