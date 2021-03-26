package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogAddBlockWordBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView okButton;
    public final TextView textView;

    protected DialogAddBlockWordBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, EditText editText2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.cancelButton = textView2;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.okButton = textView3;
        this.textView = textView4;
    }

    public static DialogAddBlockWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddBlockWordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAddBlockWordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558513, viewGroup, z, obj);
    }

    public static DialogAddBlockWordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddBlockWordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAddBlockWordBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558513, null, false, obj);
    }

    public static DialogAddBlockWordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddBlockWordBinding bind(View view, Object obj) {
        return (DialogAddBlockWordBinding) bind(obj, view, 2131558513);
    }
}
