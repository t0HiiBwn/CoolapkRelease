package com.coolapk.market.view.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.util.PendingAppsUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import java.util.Iterator;

public class InstallErrorAlertDialog extends BaseDialogFragment {
    private static final String KEY_INSTALL_STATE = "INSTALL_STATE";

    static /* synthetic */ void lambda$onCreateDialog$2(DialogInterface dialogInterface, int i) {
    }

    public static InstallErrorAlertDialog newInstance(InstallState installState) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("INSTALL_STATE", installState);
        InstallErrorAlertDialog installErrorAlertDialog = new InstallErrorAlertDialog();
        installErrorAlertDialog.setArguments(bundle);
        return installErrorAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final InstallState installState = (InstallState) getArguments().getParcelable("INSTALL_STATE");
        if (!installState.hasError()) {
            super.setShowsDialog(false);
            return builder.create();
        } else if (installState.getExtra() == null) {
            super.setShowsDialog(false);
            return builder.create();
        } else {
            String string = installState.getExtra().getString("TITLE");
            final String string2 = installState.getExtra().getString("PACKAGE_NAME");
            if (TextUtils.isEmpty(string2)) {
                Toast.show(getActivity(), "包名为空，无法继续操作");
                super.setShowsDialog(false);
                return builder.create();
            }
            switch (installState.getErrorCode()) {
                case -8:
                    super.setShowsDialog(false);
                    return builder.create();
                case -7:
                    builder.setMessage(getString(2131887208, string, installState.getErrorMessage().split(",")[1].split(":")[1].trim()));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass9 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass10 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                case -6:
                    String trim = installState.getErrorMessage().split(",")[1].split(":")[1].trim();
                    String trim2 = installState.getErrorMessage().split(",")[2].split(":")[1].trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        trim = trim2 + "(" + trim + ")";
                    }
                    builder.setMessage(getString(2131887199, trim, string + "(" + string2 + ")"));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass7 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass8 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                case -5:
                    builder.setMessage(getString(2131887198, string));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass3 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass4 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                case -4:
                    builder.setMessage(getString(2131886728, string));
                    builder.setNegativeButton(2131886729, new DialogInterface.OnClickListener(string2, string, installState) {
                        /* class com.coolapk.market.view.app.$$Lambda$InstallErrorAlertDialog$HFhhsocTwPOAWxSb4JS4IEmmKU */
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ String f$2;
                        public final /* synthetic */ InstallState f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.lambda$onCreateDialog$0$InstallErrorAlertDialog(this.f$1, this.f$2, this.f$3, dialogInterface, i);
                        }
                    });
                    builder.setPositiveButton(2131886727, new DialogInterface.OnClickListener(installState) {
                        /* class com.coolapk.market.view.app.$$Lambda$InstallErrorAlertDialog$VsP2XsNzca_nfoWTgj6YGjhl6p8 */
                        public final /* synthetic */ InstallState f$1;

                        {
                            this.f$1 = r2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.lambda$onCreateDialog$1$InstallErrorAlertDialog(this.f$1, dialogInterface, i);
                        }
                    });
                    builder.setNeutralButton(2131886726, $$Lambda$InstallErrorAlertDialog$MpH7oJ2Tj1aitTgv6IfLixWA9Q.INSTANCE);
                    break;
                case -3:
                    builder.setMessage(getString(2131887200, string));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass5 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass6 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                case -2:
                    builder.setMessage(getString(2131887197, string));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass1 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass2 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
                default:
                    builder.setMessage(getString(2131887207, string));
                    builder.setPositiveButton(2131886129, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass11 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            InstallErrorAlertDialog.this.downloadAgain(string2, installState.getPath());
                        }
                    });
                    builder.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.app.InstallErrorAlertDialog.AnonymousClass12 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    break;
            }
            return builder.create();
        }
    }

    public /* synthetic */ void lambda$onCreateDialog$0$InstallErrorAlertDialog(String str, String str2, InstallState installState, DialogInterface dialogInterface, int i) {
        ActionManager.uninstall(getActivity(), str, str2);
        PendingAppsUtils.pendingAppToReinstall("re-install", installState.getKey(), str);
    }

    public /* synthetic */ void lambda$onCreateDialog$1$InstallErrorAlertDialog(InstallState installState, DialogInterface dialogInterface, int i) {
        ActionManager.install(getActivity(), installState.getPath(), installState.getFrom(), installState.getExtra(), false);
    }

    public void downloadAgain(String str, String str2) {
        DownloadState downloadState;
        Extra extra;
        Iterator<DownloadState> it2 = DataManager.getInstance().getDownloadStateList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                downloadState = null;
                break;
            }
            downloadState = it2.next();
            if (downloadState.isSuccess() && (extra = downloadState.getExtra()) != null && TextUtils.equals(extra.getString("PACKAGE_NAME"), str) && TextUtils.equals(UriUtils.trimScheme(downloadState.getFilePath()), UriUtils.trimScheme(str2))) {
                break;
            }
        }
        if (downloadState != null) {
            ActionManager.startDownload(getActivity(), downloadState.getUrl(), downloadState.getExtra(), 1);
        }
    }
}
