package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemMessageSelectViewBinding extends ViewDataBinding {
    public final LinearLayout allSelectView;
    public final CheckBox checkBox;
    public final TextView deleteView;
    public final ProgressBar loadingView;
    public final LinearLayout rootView;
    public final TextView textView;

    protected ItemMessageSelectViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox2, TextView textView2, ProgressBar progressBar, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i);
        this.allSelectView = linearLayout;
        this.checkBox = checkBox2;
        this.deleteView = textView2;
        this.loadingView = progressBar;
        this.rootView = linearLayout2;
        this.textView = textView3;
    }

    public static ItemMessageSelectViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageSelectViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMessageSelectViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558834, viewGroup, z, obj);
    }

    public static ItemMessageSelectViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageSelectViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMessageSelectViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558834, null, false, obj);
    }

    public static ItemMessageSelectViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMessageSelectViewBinding bind(View view, Object obj) {
        return (ItemMessageSelectViewBinding) bind(obj, view, 2131558834);
    }
}
