package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CoolFlowLayout;

public abstract class DialogBlockNodeBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final LinearLayout contentView;
    public final CoolFlowLayout flowLayout;
    public final TextView neutralButton;
    public final TextView okButton;
    public final TextView textView;
    public final ImageView warningView;

    protected DialogBlockNodeBinding(Object obj, View view, int i, TextView textView2, LinearLayout linearLayout, CoolFlowLayout coolFlowLayout, TextView textView3, TextView textView4, TextView textView5, ImageView imageView) {
        super(obj, view, i);
        this.cancelButton = textView2;
        this.contentView = linearLayout;
        this.flowLayout = coolFlowLayout;
        this.neutralButton = textView3;
        this.okButton = textView4;
        this.textView = textView5;
        this.warningView = imageView;
    }

    public static DialogBlockNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBlockNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogBlockNodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558519, viewGroup, z, obj);
    }

    public static DialogBlockNodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBlockNodeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogBlockNodeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558519, null, false, obj);
    }

    public static DialogBlockNodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBlockNodeBinding bind(View view, Object obj) {
        return (DialogBlockNodeBinding) bind(obj, view, 2131558519);
    }
}
