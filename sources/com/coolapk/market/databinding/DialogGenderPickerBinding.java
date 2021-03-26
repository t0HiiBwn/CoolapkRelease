package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lany.picker.NumberPicker;

public abstract class DialogGenderPickerBinding extends ViewDataBinding {
    public final NumberPicker picker;

    protected DialogGenderPickerBinding(Object obj, View view, int i, NumberPicker numberPicker) {
        super(obj, view, i);
        this.picker = numberPicker;
    }

    public static DialogGenderPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGenderPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGenderPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558527, viewGroup, z, obj);
    }

    public static DialogGenderPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGenderPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGenderPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558527, null, false, obj);
    }

    public static DialogGenderPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGenderPickerBinding bind(View view, Object obj) {
        return (DialogGenderPickerBinding) bind(obj, view, 2131558527);
    }
}
