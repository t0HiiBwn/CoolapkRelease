package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogCompleteNavBinding extends ViewDataBinding {
    public final TextView dialogBack;
    public final TextView dialogGoMessage;
    public final ImageView imgView;
    @Bindable
    protected View.OnClickListener mClick;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected DialogCompleteNavBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.dialogBack = textView;
        this.dialogGoMessage = textView2;
        this.imgView = imageView;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static DialogCompleteNavBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCompleteNavBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCompleteNavBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558521, viewGroup, z, obj);
    }

    public static DialogCompleteNavBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCompleteNavBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCompleteNavBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558521, null, false, obj);
    }

    public static DialogCompleteNavBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCompleteNavBinding bind(View view, Object obj) {
        return (DialogCompleteNavBinding) bind(obj, view, 2131558521);
    }
}
