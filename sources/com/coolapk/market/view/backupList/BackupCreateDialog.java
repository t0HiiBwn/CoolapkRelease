package com.coolapk.market.view.backupList;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogBackupCreateBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DeviceInfo;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupCreateDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "appList", "", "backupTitle", "binding", "Lcom/coolapk/market/databinding/DialogBackupCreateBinding;", "createSubscription", "Lrx/Subscription;", "deviceTitle", "intro", "Landroid/widget/EditText;", "titleView", "loadDeviceInfo", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDeviceInfoLoaded", "info", "Lcom/coolapk/market/model/DeviceInfo;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupCreatDialog.kt */
public final class BackupCreateDialog extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_APP_LIST = "ALBUMTITLE";
    private static final String KEY_INTRO = "ALBUMINTRO";
    private String appList;
    private String backupTitle;
    private DialogBackupCreateBinding binding;
    private Subscription createSubscription;
    private String deviceTitle;
    private EditText intro;
    private EditText titleView;

    public static final /* synthetic */ String access$getBackupTitle$p(BackupCreateDialog backupCreateDialog) {
        String str = backupCreateDialog.backupTitle;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backupTitle");
        }
        return str;
    }

    public static final /* synthetic */ DialogBackupCreateBinding access$getBinding$p(BackupCreateDialog backupCreateDialog) {
        DialogBackupCreateBinding dialogBackupCreateBinding = backupCreateDialog.binding;
        if (dialogBackupCreateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dialogBackupCreateBinding;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        RxUtils.unsubscribe(this.createSubscription);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558518, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ckup_create, null, false)");
        DialogBackupCreateBinding dialogBackupCreateBinding = (DialogBackupCreateBinding) inflate;
        this.binding = dialogBackupCreateBinding;
        if (dialogBackupCreateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = dialogBackupCreateBinding.titleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.titleEditText");
        this.titleView = editText;
        DialogBackupCreateBinding dialogBackupCreateBinding2 = this.binding;
        if (dialogBackupCreateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = dialogBackupCreateBinding2.titleEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.titleEditText");
        this.intro = editText2;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intro");
        }
        editText2.setHint("");
        loadDeviceInfo();
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        DialogBackupCreateBinding dialogBackupCreateBinding3 = this.binding;
        if (dialogBackupCreateBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogBackupCreateBinding3.dialogConfirm.setTextColor(colorAccent);
        DialogBackupCreateBinding dialogBackupCreateBinding4 = this.binding;
        if (dialogBackupCreateBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogBackupCreateBinding4.dialogCancel.setTextColor(colorAccent);
        EditText editText3 = this.intro;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intro");
        }
        TintHelper.setTint(editText3, colorAccent, false);
        EditText editText4 = this.titleView;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        TintHelper.setTint(editText4, colorAccent, false);
        DialogBackupCreateBinding dialogBackupCreateBinding5 = this.binding;
        if (dialogBackupCreateBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        builder.setView(dialogBackupCreateBinding5.getRoot());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }

    private final void loadDeviceInfo() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getDeviceInfo().compose(RxUtils.applyIOSchedulers()).subscribe(new BackupCreateDialog$loadDeviceInfo$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDeviceInfoLoaded(DeviceInfo deviceInfo) {
        String createTimeDescription = DateUtils.getCreateTimeDescription(getActivity(), Long.valueOf(DateUtils.getTimestamp()), false);
        boolean isEmpty = TextUtils.isEmpty(deviceInfo.getDeviceTitle());
        String str = Build.BRAND + '-' + Build.MODEL;
        String deviceTitle2 = deviceInfo.getDeviceTitle();
        if (!isEmpty) {
            str = deviceTitle2;
        }
        this.backupTitle = str + "的备份单 " + createTimeDescription;
        EditText editText = this.intro;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intro");
        }
        String str2 = this.backupTitle;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backupTitle");
        }
        editText.setHint(str2);
        DialogBackupCreateBinding dialogBackupCreateBinding = this.binding;
        if (dialogBackupCreateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(dialogBackupCreateBinding.dialogConfirm, new BackupCreateDialog$onDeviceInfoLoaded$1(this));
        DialogBackupCreateBinding dialogBackupCreateBinding2 = this.binding;
        if (dialogBackupCreateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(dialogBackupCreateBinding2.dialogCancel, new BackupCreateDialog$onDeviceInfoLoaded$2(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupCreateDialog$Companion;", "", "()V", "KEY_APP_LIST", "", "KEY_INTRO", "newInstance", "Lcom/coolapk/market/view/backupList/BackupCreateDialog;", "introtext", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupCreatDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupCreateDialog newInstance() {
            BackupCreateDialog backupCreateDialog = new BackupCreateDialog();
            backupCreateDialog.setArguments(new Bundle());
            return backupCreateDialog;
        }

        public final BackupCreateDialog newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "introtext");
            BackupCreateDialog backupCreateDialog = new BackupCreateDialog();
            Bundle bundle = new Bundle();
            bundle.putString(BackupCreateDialog.KEY_INTRO, str);
            backupCreateDialog.setArguments(bundle);
            return backupCreateDialog;
        }
    }
}
