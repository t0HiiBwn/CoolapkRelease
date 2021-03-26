package com.coolapk.market.view.feedv8;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.SubmitPickColorBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoteColorPickerFragment.kt */
public final class VoteColorPickerFragment extends BaseDialogFragment {
    private SubmitPickColorBinding binding;
    private int colorAccent;
    private int colorPrimary;
    private Function2<? super Integer, ? super Integer, Unit> onClick;

    public static final /* synthetic */ SubmitPickColorBinding access$getBinding$p(VoteColorPickerFragment voteColorPickerFragment) {
        SubmitPickColorBinding submitPickColorBinding = voteColorPickerFragment.binding;
        if (submitPickColorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitPickColorBinding;
    }

    public final void setInitValue(int i, int i2, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onClick");
        this.colorAccent = i2;
        this.colorPrimary = i;
        this.onClick = function2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559163, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_pick_color, null, false)");
        SubmitPickColorBinding submitPickColorBinding = (SubmitPickColorBinding) inflate;
        this.binding = submitPickColorBinding;
        if (submitPickColorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        builder.setView(submitPickColorBinding.getRoot());
        builder.setCancelable(false);
        SubmitPickColorBinding submitPickColorBinding2 = this.binding;
        if (submitPickColorBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding2.actionCancel.setOnClickListener(new VoteColorPickerFragment$onCreateDialog$1(this));
        SubmitPickColorBinding submitPickColorBinding3 = this.binding;
        if (submitPickColorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding3.actionNext.setOnClickListener(new VoteColorPickerFragment$onCreateDialog$2(this));
        SubmitPickColorBinding submitPickColorBinding4 = this.binding;
        if (submitPickColorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UiUtils.tintBackground(submitPickColorBinding4.colorView1, this.colorPrimary);
        SubmitPickColorBinding submitPickColorBinding5 = this.binding;
        if (submitPickColorBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding5.colorView1.setOnClickListener(new VoteColorPickerFragment$onCreateDialog$3(this));
        SubmitPickColorBinding submitPickColorBinding6 = this.binding;
        if (submitPickColorBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding6.colorView1.setOnLongClickListener(new VoteColorPickerFragment$onCreateDialog$4(this));
        SubmitPickColorBinding submitPickColorBinding7 = this.binding;
        if (submitPickColorBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UiUtils.tintBackground(submitPickColorBinding7.colorView2, this.colorAccent);
        SubmitPickColorBinding submitPickColorBinding8 = this.binding;
        if (submitPickColorBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding8.colorView2.setOnClickListener(new VoteColorPickerFragment$onCreateDialog$5(this));
        SubmitPickColorBinding submitPickColorBinding9 = this.binding;
        if (submitPickColorBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitPickColorBinding9.colorView2.setOnLongClickListener(new VoteColorPickerFragment$onCreateDialog$6(this));
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }
}
