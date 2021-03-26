package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SubmitPickColorBinding extends ViewDataBinding {
    public final Button actionCancel;
    public final Button actionNext;
    public final View colorView1;
    public final View colorView2;
    public final LinearLayout contentView1;

    protected SubmitPickColorBinding(Object obj, View view, int i, Button button, Button button2, View view2, View view3, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionCancel = button;
        this.actionNext = button2;
        this.colorView1 = view2;
        this.colorView2 = view3;
        this.contentView1 = linearLayout;
    }

    public static SubmitPickColorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitPickColorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitPickColorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559163, viewGroup, z, obj);
    }

    public static SubmitPickColorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitPickColorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitPickColorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559163, null, false, obj);
    }

    public static SubmitPickColorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitPickColorBinding bind(View view, Object obj) {
        return (SubmitPickColorBinding) bind(obj, view, 2131559163);
    }
}
