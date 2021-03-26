package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class DialogEditBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final TextInputEditText editText;
    public final ProgressBar loadingView;
    public final TextView okButton;
    public final TextInputLayout textInputLayout;
    public final TextView tipView;

    protected DialogEditBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextInputEditText textInputEditText, ProgressBar progressBar, TextView textView2, TextInputLayout textInputLayout2, TextView textView3) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.contentView = linearLayout;
        this.editText = textInputEditText;
        this.loadingView = progressBar;
        this.okButton = textView2;
        this.textInputLayout = textInputLayout2;
        this.tipView = textView3;
    }

    public static DialogEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558525, viewGroup, z, obj);
    }

    public static DialogEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558525, null, false, obj);
    }

    public static DialogEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditBinding bind(View view, Object obj) {
        return (DialogEditBinding) bind(obj, view, 2131558525);
    }
}
