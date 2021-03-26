package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutTabConfigBinding extends ViewDataBinding {
    public final RadioButton radioFi;
    public final RadioButton radioFiv;
    public final RadioButton radioFo;
    public final RadioGroup radioGroup;
    public final RadioButton radioSe;
    public final RadioButton radioTh;
    public final TextView titleView;

    protected LayoutTabConfigBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup2, RadioButton radioButton4, RadioButton radioButton5, TextView textView) {
        super(obj, view, i);
        this.radioFi = radioButton;
        this.radioFiv = radioButton2;
        this.radioFo = radioButton3;
        this.radioGroup = radioGroup2;
        this.radioSe = radioButton4;
        this.radioTh = radioButton5;
        this.titleView = textView;
    }

    public static LayoutTabConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTabConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutTabConfigBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559010, viewGroup, z, obj);
    }

    public static LayoutTabConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTabConfigBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutTabConfigBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559010, null, false, obj);
    }

    public static LayoutTabConfigBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutTabConfigBinding bind(View view, Object obj) {
        return (LayoutTabConfigBinding) bind(obj, view, 2131559010);
    }
}
