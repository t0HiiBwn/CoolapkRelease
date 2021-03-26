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

public abstract class DialogEditSubmitBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView errorView;
    public final TextView okButton;
    public final TextView pasteButton;
    public final ProgressBar progressBar;
    public final TextView titleView;

    protected DialogEditSubmitBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, EditText editText2, TextView textView2, TextView textView3, TextView textView4, ProgressBar progressBar2, TextView textView5) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.errorView = textView2;
        this.okButton = textView3;
        this.pasteButton = textView4;
        this.progressBar = progressBar2;
        this.titleView = textView5;
    }

    public static DialogEditSubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditSubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogEditSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558526, viewGroup, z, obj);
    }

    public static DialogEditSubmitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditSubmitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogEditSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558526, null, false, obj);
    }

    public static DialogEditSubmitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditSubmitBinding bind(View view, Object obj) {
        return (DialogEditSubmitBinding) bind(obj, view, 2131558526);
    }
}
