package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitVerifyMobileCodeDialogBinding extends ViewDataBinding {
    public final TextView actionView;
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView errorView;
    public final TextView numView;
    public final TextView okButton;
    public final ProgressBar progressBar;
    public final TextView textView;

    protected SubmitVerifyMobileCodeDialogBinding(Object obj, View view, int i, TextView textView2, TextView textView3, LinearLayout linearLayout, EditText editText2, TextView textView4, TextView textView5, TextView textView6, ProgressBar progressBar2, TextView textView7) {
        super(obj, view, i);
        this.actionView = textView2;
        this.cancelButton = textView3;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.errorView = textView4;
        this.numView = textView5;
        this.okButton = textView6;
        this.progressBar = progressBar2;
        this.textView = textView7;
    }

    public static SubmitVerifyMobileCodeDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVerifyMobileCodeDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitVerifyMobileCodeDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559171, viewGroup, z, obj);
    }

    public static SubmitVerifyMobileCodeDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVerifyMobileCodeDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitVerifyMobileCodeDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559171, null, false, obj);
    }

    public static SubmitVerifyMobileCodeDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVerifyMobileCodeDialogBinding bind(View view, Object obj) {
        return (SubmitVerifyMobileCodeDialogBinding) bind(obj, view, 2131559171);
    }
}
