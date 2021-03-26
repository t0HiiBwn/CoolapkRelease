package com.coolapk.market.view.sencondhand;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.databinding.DialogSecondHandEditBinding;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u0019\u001a\u00020\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/sencondhand/EditSecondHandDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogSecondHandEditBinding;", "cancelListener", "Lrx/functions/Action1;", "", "listener", "", "shouldDismiss", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "onClick", "", "v", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setCancelListener", "setListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EditSecondHandDialogFragment.kt */
public final class EditSecondHandDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONTENT = "extra_content";
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TITLE = "extra_TITLE";
    private DialogSecondHandEditBinding binding;
    private Action1<Boolean> cancelListener;
    private Action1<String> listener;
    private boolean shouldDismiss = true;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/sencondhand/EditSecondHandDialogFragment$Companion;", "", "()V", "EXTRA_CONTENT", "", "EXTRA_ID", "EXTRA_TITLE", "newInstance", "Lcom/coolapk/market/view/sencondhand/EditSecondHandDialogFragment;", "title", "id", "", "content", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EditSecondHandDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ EditSecondHandDialogFragment newInstance$default(Companion companion, String str, int i, String str2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(str, i, str2);
        }

        public final EditSecondHandDialogFragment newInstance(String str, int i, String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "content");
            EditSecondHandDialogFragment editSecondHandDialogFragment = new EditSecondHandDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_TITLE", str);
            bundle.putInt("extra_id", i);
            bundle.putString("extra_content", str2);
            Unit unit = Unit.INSTANCE;
            editSecondHandDialogFragment.setArguments(bundle);
            return editSecondHandDialogFragment;
        }
    }

    public final boolean getShouldDismiss() {
        return this.shouldDismiss;
    }

    public final void setShouldDismiss(boolean z) {
        this.shouldDismiss = z;
    }

    public final void setListener(Action1<String> action1) {
        Intrinsics.checkNotNullParameter(action1, "listener");
        this.listener = action1;
    }

    public final void setCancelListener(Action1<Boolean> action1) {
        Intrinsics.checkNotNullParameter(action1, "listener");
        this.cancelListener = action1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = requireArguments().getString("extra_TITLE");
        int i = requireArguments().getInt("extra_id");
        String string2 = requireArguments().getString("extra_content");
        UserPermissionChecker userPermissionChecker = UserPermissionChecker.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String extraUrl = StringUtils.getExtraUrl(getActivity(), userPermissionChecker.getClipBoardText(requireActivity).toString());
        Intrinsics.checkNotNullExpressionValue(extraUrl, "url");
        String str = extraUrl;
        String str2 = "";
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "zhuanzhuan.com", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "market.m.taobao.com", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "2.taobao.com", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "m.jiaoyimao.com", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "www.jiaoyimao.com", false, 2, (Object) null)) {
            extraUrl = str2;
        }
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558533, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…d_hand_edit, null, false)");
        DialogSecondHandEditBinding dialogSecondHandEditBinding = (DialogSecondHandEditBinding) inflate;
        this.binding = dialogSecondHandEditBinding;
        if (dialogSecondHandEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditSecondHandDialogFragment editSecondHandDialogFragment = this;
        dialogSecondHandEditBinding.cacelView.setOnClickListener(editSecondHandDialogFragment);
        DialogSecondHandEditBinding dialogSecondHandEditBinding2 = this.binding;
        if (dialogSecondHandEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandEditBinding2.submitView.setOnClickListener(editSecondHandDialogFragment);
        int i2 = 1;
        boolean z = 2131363446 == i;
        DialogSecondHandEditBinding dialogSecondHandEditBinding3 = this.binding;
        if (dialogSecondHandEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = dialogSecondHandEditBinding3.editText;
        if (z) {
            i2 = 4;
        }
        editText.setLines(i2);
        DialogSecondHandEditBinding dialogSecondHandEditBinding4 = this.binding;
        if (dialogSecondHandEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = dialogSecondHandEditBinding4.editText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
        editText2.setHint(i != 2131363446 ? i != 2131363450 ? str2 : "输入出售价格" : "添加闲鱼/交易猫链接");
        if (i == 2131363450) {
            DialogSecondHandEditBinding dialogSecondHandEditBinding5 = this.binding;
            if (dialogSecondHandEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = dialogSecondHandEditBinding5.editText;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
            editText3.setInputType(8194);
        }
        if (!TextUtils.isEmpty(string2)) {
            DialogSecondHandEditBinding dialogSecondHandEditBinding6 = this.binding;
            if (dialogSecondHandEditBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText4 = dialogSecondHandEditBinding6.editText;
            if (string2 != null) {
                str2 = string2;
            }
            editText4.setText(str2);
            DialogSecondHandEditBinding dialogSecondHandEditBinding7 = this.binding;
            if (dialogSecondHandEditBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText5 = dialogSecondHandEditBinding7.editText;
            Intrinsics.checkNotNull(string2);
            editText5.setSelection(string2.length());
        } else {
            String str3 = extraUrl;
            if (!TextUtils.isEmpty(str3) && i == 2131363446) {
                DialogSecondHandEditBinding dialogSecondHandEditBinding8 = this.binding;
                if (dialogSecondHandEditBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                dialogSecondHandEditBinding8.editText.setText(str3);
                DialogSecondHandEditBinding dialogSecondHandEditBinding9 = this.binding;
                if (dialogSecondHandEditBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                dialogSecondHandEditBinding9.editText.setSelection(extraUrl.length());
            }
        }
        AlertDialog.Builder title = new AlertDialog.Builder(requireActivity()).setTitle(string);
        DialogSecondHandEditBinding dialogSecondHandEditBinding10 = this.binding;
        if (dialogSecondHandEditBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = title.setView(dialogSecondHandEditBinding10.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "androidx.appcompat.app.A…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362193) {
            DialogSecondHandEditBinding dialogSecondHandEditBinding = this.binding;
            if (dialogSecondHandEditBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            UiUtils.closeKeyboard(dialogSecondHandEditBinding.editText);
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            Action1<Boolean> action1 = this.cancelListener;
            if (action1 != null && action1 != null) {
                action1.call(false);
            }
        } else if (id == 2131363457 && this.listener != null) {
            DialogSecondHandEditBinding dialogSecondHandEditBinding2 = this.binding;
            if (dialogSecondHandEditBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            UiUtils.closeKeyboard(dialogSecondHandEditBinding2.editText);
            DialogSecondHandEditBinding dialogSecondHandEditBinding3 = this.binding;
            if (dialogSecondHandEditBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = dialogSecondHandEditBinding3.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            String obj = editText.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                Toast.show$default(getActivity(), "您还没有输入内容", 0, false, 12, null);
                return;
            }
            Action1<String> action12 = this.listener;
            if (action12 != null) {
                action12.call(obj);
            }
        }
    }
}
