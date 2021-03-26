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

public class DownloadExtend2Dialog extends BaseDialogFragment {
    private boolean again;
    private AppForum appForum;

    public static DownloadExtend2Dialog newInstance(AppForum appForum2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("app", appForum2);
        bundle.putBoolean("again", z);
        DownloadExtend2Dialog downloadExtend2Dialog = new DownloadExtend2Dialog();
        downloadExtend2Dialog.setArguments(bundle);
        return downloadExtend2Dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appForum = (AppForum) getArguments().getParcelable("app");
        this.again = getArguments().getBoolean("again");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(2131887298).setItems(new String[]{getString(2131886747), getString(2131886750, this.appForum.packageName())}, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.DownloadExtend2Dialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int i2 = i == 0 ? 0 : 2;
                boolean z = DownloadExtend2Dialog.this.again;
                String downloadUrlMd5 = DownloadExtend2Dialog.this.appForum.getDownloadUrlMd5(i2);
                DownloadState downloadState = DataManager.getInstance().getDownloadState(downloadUrlMd5);
                Extra extra = null;
                if (downloadState != null) {
                    extra = downloadState.getExtra();
                }
                if (extra == null) {
                    extra = new Extra();
                }
                extra.put("EXTRA_ANALYSIS_DATA", DownloadExtend2Dialog.this.appForum.extraAnalysisData());
                ActionManager.startDownload(DownloadExtend2Dialog.this.getActivity(), downloadUrlMd5, extra, z ? 1 : 0);
            }
        }).create();
    }
}
