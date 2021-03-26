package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class CustomThemeBinding extends ViewDataBinding {
    public final TextView actionCancel;
    public final TextView actionNext;
    public final CheckBox checkBox1;
    public final CheckBox checkBox2;
    public final View colorView1;
    public final View colorView2;
    public final LinearLayout contentView1;

    protected CustomThemeBinding(Object obj, View view, int i, TextView textView, TextView textView2, CheckBox checkBox, CheckBox checkBox3, View view2, View view3, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionCancel = textView;
        this.actionNext = textView2;
        this.checkBox1 = checkBox;
        this.checkBox2 = checkBox3;
        this.colorView1 = view2;
        this.colorView2 = view3;
        this.contentView1 = linearLayout;
    }

    public static CustomThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CustomThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558496, viewGroup, z, obj);
    }

    public static CustomThemeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomThemeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CustomThemeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558496, null, false, obj);
    }

    public static CustomThemeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomThemeBinding bind(View view, Object obj) {
        return (CustomThemeBinding) bind(obj, view, 2131558496);
    }
}
