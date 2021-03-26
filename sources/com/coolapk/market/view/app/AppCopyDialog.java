package com.coolapk.market.view.app;

import android.os.Bundle;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/app/AppCopyDialog;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCopyDialog.kt */
public final class AppCopyDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_SERVICE_APP = "SERVICE_APP";

    @JvmStatic
    public static final AppCopyDialog newInstance(ServiceApp serviceApp) {
        return Companion.newInstance(serviceApp);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/app/AppCopyDialog$Companion;", "", "()V", "KEY_SERVICE_APP", "", "newInstance", "Lcom/coolapk/market/view/app/AppCopyDialog;", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppCopyDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppCopyDialog newInstance(ServiceApp serviceApp) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("SERVICE_APP", serviceApp);
            AppCopyDialog appCopyDialog = new AppCopyDialog();
            appCopyDialog.setArguments(bundle);
            return appCopyDialog;
        }
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(new AppCopyDialog$onActivityCreated$1(this));
    }
}
