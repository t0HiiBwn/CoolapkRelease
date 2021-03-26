package com.coolapk.market.view.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.base.BaseDialogFragment;

public class VersionLowerAlertDialog extends BaseDialogFragment {
    public static final int TYPE_DOWNLOAD = 1;

    public static VersionLowerAlertDialog newInstance(ServiceApp serviceApp, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("app", serviceApp);
        bundle.putInt("urlType", i);
        bundle.putInt("flag", i2);
        VersionLowerAlertDialog versionLowerAlertDialog = new VersionLowerAlertDialog();
        versionLowerAlertDialog.setArguments(bundle);
        return versionLowerAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final ServiceApp serviceApp = (ServiceApp) getArguments().getParcelable("app");
        if (serviceApp == null) {
            return null;
        }
        final int i = getArguments().getInt("urlType");
        final int i2 = getArguments().getInt("flag");
        return new AlertDialog.Builder(getActivity()).setMessage(getString(2131886767, serviceApp.getAppName())).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.VersionLowerAlertDialog.AnonymousClass2 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ActionManager.startDownload(VersionLowerAlertDialog.this.getActivity(), serviceApp, i, i2);
            }
        }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.app.VersionLowerAlertDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create();
    }
}
