package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutWaterMarkBinding extends ViewDataBinding {
    public final RadioButton radioFi;
    public final RadioButton radioFo;
    public final RadioGroup radioGroup;
    public final RadioButton radioSe;
    public final RadioButton radioTh;
    public final TextView titleView;

    protected LayoutWaterMarkBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup2, RadioButton radioButton3, RadioButton radioButton4, TextView textView) {
        super(obj, view, i);
        this.radioFi = radioButton;
        this.radioFo = radioButton2;
        this.radioGroup = radioGroup2;
        this.radioSe = radioButton3;
        this.radioTh = radioButton4;
        this.titleView = textView;
    }

    public static LayoutWaterMarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutWaterMarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutWaterMarkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559015, viewGroup, z, obj);
    }

    public static LayoutWaterMarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutWaterMarkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutWaterMarkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559015, null, false, obj);
    }

    public static LayoutWaterMarkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutWaterMarkBinding bind(View view, Object obj) {
        return (LayoutWaterMarkBinding) bind(obj, view, 2131559015);
    }
}
