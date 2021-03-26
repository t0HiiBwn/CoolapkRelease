package com.coolapk.market.view.message;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.DialogCompleteNavBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/message/CompleteNavDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogCompleteNavBinding;", "uid", "", "userName", "onClick", "", "v", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteNavDialogFragment.kt */
public final class CompleteNavDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_UID = "EXTRA_UID";
    public static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";
    private DialogCompleteNavBinding binding;
    private String uid = "";
    private String userName = "";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/message/CompleteNavDialogFragment$Companion;", "", "()V", "EXTRA_UID", "", "EXTRA_USER_NAME", "newInstance", "Lcom/coolapk/market/view/message/CompleteNavDialogFragment;", "uid", "userName", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CompleteNavDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CompleteNavDialogFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "uid");
            Intrinsics.checkNotNullParameter(str2, "userName");
            CompleteNavDialogFragment completeNavDialogFragment = new CompleteNavDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("EXTRA_UID", str);
            bundle.putString("EXTRA_USER_NAME", str2);
            Unit unit = Unit.INSTANCE;
            completeNavDialogFragment.setArguments(bundle);
            return completeNavDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = requireArguments().getString("EXTRA_UID");
        Intrinsics.checkNotNull(string);
        this.uid = string;
        String string2 = requireArguments().getString("EXTRA_USER_NAME");
        Intrinsics.checkNotNull(string2);
        this.userName = string2;
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558523, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        DialogCompleteNavBinding dialogCompleteNavBinding = (DialogCompleteNavBinding) inflate;
        this.binding = dialogCompleteNavBinding;
        if (dialogCompleteNavBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogCompleteNavBinding.imgView.setColorFilter(AppHolder.getAppTheme().getColorAccent());
        DialogCompleteNavBinding dialogCompleteNavBinding2 = this.binding;
        if (dialogCompleteNavBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogCompleteNavBinding2.dialogGoMessage.setTextColor(AppHolder.getAppTheme().getColorAccent());
        DialogCompleteNavBinding dialogCompleteNavBinding3 = this.binding;
        if (dialogCompleteNavBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogCompleteNavBinding3.dialogBack.setTextColor(AppHolder.getAppTheme().getColorAccent());
        DialogCompleteNavBinding dialogCompleteNavBinding4 = this.binding;
        if (dialogCompleteNavBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogCompleteNavBinding4.setClick(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        DialogCompleteNavBinding dialogCompleteNavBinding5 = this.binding;
        if (dialogCompleteNavBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = builder.setView(dialogCompleteNavBinding5.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "androidx.appcompat.app.A…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362400) {
            dismiss();
            Activity topActivity = AppHolder.getActivityStackManager().getTopActivity();
            if (topActivity != null) {
                topActivity.finish();
            }
        } else if (id == 2131362405) {
            dismiss();
            Activity topActivity2 = AppHolder.getActivityStackManager().getTopActivity();
            if (topActivity2 != null) {
                topActivity2.finish();
            }
            ActionManager.startChattingActivity(getActivity(), this.uid, this.userName);
        }
    }
}
