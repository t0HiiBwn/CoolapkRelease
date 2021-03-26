package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DialogPrograssViewBinding extends ViewDataBinding {
    public final LinearLayout itemView;
    public final ProgressBar loadingView;
    public final TextView titleView;

    protected DialogPrograssViewBinding(Object obj, View view, int i, LinearLayout linearLayout, ProgressBar progressBar, TextView textView) {
        super(obj, view, i);
        this.itemView = linearLayout;
        this.loadingView = progressBar;
        this.titleView = textView;
    }

    public static DialogPrograssViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrograssViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPrograssViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558531, viewGroup, z, obj);
    }

    public static DialogPrograssViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrograssViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPrograssViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558531, null, false, obj);
    }

    public static DialogPrograssViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPrograssViewBinding bind(View view, Object obj) {
        return (DialogPrograssViewBinding) bind(obj, view, 2131558531);
    }
}
