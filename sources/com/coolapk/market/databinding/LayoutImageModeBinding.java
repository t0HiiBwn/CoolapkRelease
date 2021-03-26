package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutImageModeBinding extends ViewDataBinding {
    public final RadioButton radioFi;
    public final RadioGroup radioGroup;
    public final RadioButton radioSe;
    public final RadioButton radioTh;
    public final TextView titleView;

    protected LayoutImageModeBinding(Object obj, View view, int i, RadioButton radioButton, RadioGroup radioGroup2, RadioButton radioButton2, RadioButton radioButton3, TextView textView) {
        super(obj, view, i);
        this.radioFi = radioButton;
        this.radioGroup = radioGroup2;
        this.radioSe = radioButton2;
        this.radioTh = radioButton3;
        this.titleView = textView;
    }

    public static LayoutImageModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutImageModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutImageModeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558996, viewGroup, z, obj);
    }

    public static LayoutImageModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutImageModeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutImageModeBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558996, null, false, obj);
    }

    public static LayoutImageModeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutImageModeBinding bind(View view, Object obj) {
        return (LayoutImageModeBinding) bind(obj, view, 2131558996);
    }
}
