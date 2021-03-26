package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class DialogGoodsListEditBinding extends ViewDataBinding {
    public final TextView dialogCancel;
    public final TextView dialogConfirm;
    public final TextView dialogTitleView;
    public final TextInputEditText introEditText;
    public final TextInputLayout introInputLayout;
    public final TextInputEditText titleEditText;
    public final TextInputLayout titleInputLayout;

    protected DialogGoodsListEditBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2) {
        super(obj, view, i);
        this.dialogCancel = textView;
        this.dialogConfirm = textView2;
        this.dialogTitleView = textView3;
        this.introEditText = textInputEditText;
        this.introInputLayout = textInputLayout;
        this.titleEditText = textInputEditText2;
        this.titleInputLayout = textInputLayout2;
    }

    public static DialogGoodsListEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGoodsListEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGoodsListEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558528, viewGroup, z, obj);
    }

    public static DialogGoodsListEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGoodsListEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGoodsListEditBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558528, null, false, obj);
    }

    public static DialogGoodsListEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGoodsListEditBinding bind(View view, Object obj) {
        return (DialogGoodsListEditBinding) bind(obj, view, 2131558528);
    }
}
