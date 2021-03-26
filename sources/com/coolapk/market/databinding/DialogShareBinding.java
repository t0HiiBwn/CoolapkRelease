package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogShareBinding extends ViewDataBinding {
    public final TextView dialogCancel;
    public final TextView dialogConfirm;
    public final TextView dialogTitleView;
    public final TextView messageView;
    public final TextView urlView;

    protected DialogShareBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.dialogCancel = textView;
        this.dialogConfirm = textView2;
        this.dialogTitleView = textView3;
        this.messageView = textView4;
        this.urlView = textView5;
    }

    public static DialogShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogShareBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558539, viewGroup, z, obj);
    }

    public static DialogShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogShareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogShareBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558539, null, false, obj);
    }

    public static DialogShareBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogShareBinding bind(View view, Object obj) {
        return (DialogShareBinding) bind(obj, view, 2131558539);
    }
}
