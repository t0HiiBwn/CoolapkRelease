package com.coolapk.market.view.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.base.BaseDialogFragment;

public class DownloadExtendDialog extends BaseDialogFragment {
    private boolean again;
    private ServiceApp serviceApp;

    public static DownloadExtendDialog newInstance(ServiceApp serviceApp2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("app", serviceApp2);
        bundle.putBoolean("again", z);
        DownloadExtendDialog downloadExtendDialog = new DownloadExtendDialog();
        downloadExtendDialog.setArguments(bundle);
        return downloadExtendDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.serviceApp = (ServiceApp) getArguments().getParcelable("app");
        this.again = getArguments().getBoolean("again");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(2131887298).setItems(new String[]{getString(2131886747), getString(2131886750, this.serviceApp.getExtendName())}, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.DownloadExtendDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ActionManager.startDownload(DownloadExtendDialog.this.getActivity(), DownloadExtendDialog.this.serviceApp, i == 0 ? 0 : 2, DownloadExtendDialog.this.again ? 1 : 0);
            }
        }).create();
    }
}
