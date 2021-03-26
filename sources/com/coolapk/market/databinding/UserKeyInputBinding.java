package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class UserKeyInputBinding extends ViewDataBinding {
    public final TextView actionConfirm;
    public final LinearLayout contentView;
    public final EditText editText;
    public final TextView hintView;
    public final TextView inputKeyHint;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected UserKeyInputBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, EditText editText2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionConfirm = textView;
        this.contentView = linearLayout;
        this.editText = editText2;
        this.hintView = textView2;
        this.inputKeyHint = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static UserKeyInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserKeyInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserKeyInputBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559292, viewGroup, z, obj);
    }

    public static UserKeyInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserKeyInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserKeyInputBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559292, null, false, obj);
    }

    public static UserKeyInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserKeyInputBinding bind(View view, Object obj) {
        return (UserKeyInputBinding) bind(obj, view, 2131559292);
    }
}
