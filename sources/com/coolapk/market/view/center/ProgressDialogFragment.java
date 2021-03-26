package com.coolapk.market.view.center;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.databinding.DialogPrograssViewBinding;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/ProgressDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogPrograssViewBinding;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProgressDialogFragment.kt */
public final class ProgressDialogFragment extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private DialogPrograssViewBinding binding;

    @JvmStatic
    public static final ProgressDialogFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/ProgressDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/center/ProgressDialogFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProgressDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProgressDialogFragment newInstance() {
            Bundle bundle = new Bundle();
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            progressDialogFragment.setArguments(bundle);
            return progressDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558531, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ograss_view, null, false)");
        DialogPrograssViewBinding dialogPrograssViewBinding = (DialogPrograssViewBinding) inflate;
        this.binding = dialogPrograssViewBinding;
        if (dialogPrograssViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = dialogPrograssViewBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText("正在提交，请稍后...");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        DialogPrograssViewBinding dialogPrograssViewBinding2 = this.binding;
        if (dialogPrograssViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = builder.setView(dialogPrograssViewBinding2.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }
}
