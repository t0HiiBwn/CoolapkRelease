package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lany.picker.NumberPicker;

public abstract class DialogCityPickerBinding extends ViewDataBinding {
    public final NumberPicker cityPicker;
    public final NumberPicker provincePicker;

    protected DialogCityPickerBinding(Object obj, View view, int i, NumberPicker numberPicker, NumberPicker numberPicker2) {
        super(obj, view, i);
        this.cityPicker = numberPicker;
        this.provincePicker = numberPicker2;
    }

    public static DialogCityPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCityPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCityPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558520, viewGroup, z, obj);
    }

    public static DialogCityPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCityPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCityPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558520, null, false, obj);
    }

    public static DialogCityPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCityPickerBinding bind(View view, Object obj) {
        return (DialogCityPickerBinding) bind(obj, view, 2131558520);
    }
}
