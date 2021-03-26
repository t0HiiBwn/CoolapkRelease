package com.coolapk.market.view.photo;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FileDetail;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PicAdminDialog.kt */
public final class PicAdminDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);
    private String url;

    public static final /* synthetic */ String access$getUrl$p(PicAdminDialog picAdminDialog) {
        String str = picAdminDialog.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        return str;
    }

    /* compiled from: PicAdminDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PicAdminDialog newInstance(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            PicAdminDialog picAdminDialog = new PicAdminDialog();
            picAdminDialog.setArguments(bundle);
            return picAdminDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("url");
        Intrinsics.checkNotNull(string);
        this.url = string;
    }

    @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        updateDataList(PicAdminDialog$onActivityCreated$1.INSTANCE);
        DataManager instance = DataManager.getInstance();
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        instance.getFileDetail(str).compose(RxUtils.apiCommonToData()).subscribe(new PicAdminDialog$onActivityCreated$2(this), new PicAdminDialog$onActivityCreated$3(this));
    }

    public final void updateList(FileDetail fileDetail) {
        updateDataList(new PicAdminDialog$updateList$1(this, fileDetail));
    }
}
