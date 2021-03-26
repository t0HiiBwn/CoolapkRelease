package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitVertfiyCaptchaDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView errorView;
    public final ImageView imageView;
    public final TextView okButton;
    public final ProgressBar progressBar;
    public final TextView textView;

    protected SubmitVertfiyCaptchaDialogBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, EditText editText2, TextView textView3, ImageView imageView2, TextView textView4, ProgressBar progressBar2, TextView textView5) {
        super(obj, view, i);
        this.cancelButton = textView2;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.errorView = textView3;
        this.imageView = imageView2;
        this.okButton = textView4;
        this.progressBar = progressBar2;
        this.textView = textView5;
    }

    public static SubmitVertfiyCaptchaDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVertfiyCaptchaDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitVertfiyCaptchaDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559172, viewGroup, z, obj);
    }

    public static SubmitVertfiyCaptchaDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVertfiyCaptchaDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitVertfiyCaptchaDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559172, null, false, obj);
    }

    public static SubmitVertfiyCaptchaDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitVertfiyCaptchaDialogBinding bind(View view, Object obj) {
        return (SubmitVertfiyCaptchaDialogBinding) bind(obj, view, 2131559172);
    }
}
