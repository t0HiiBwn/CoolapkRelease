package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lany.picker.HourMinutePicker;

public abstract class DialogTimePickerBinding extends ViewDataBinding {
    public final HourMinutePicker endTimePicker;
    public final HourMinutePicker startTimePicker;

    protected DialogTimePickerBinding(Object obj, View view, int i, HourMinutePicker hourMinutePicker, HourMinutePicker hourMinutePicker2) {
        super(obj, view, i);
        this.endTimePicker = hourMinutePicker;
        this.startTimePicker = hourMinutePicker2;
    }

    public static DialogTimePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTimePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogTimePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558538, viewGroup, z, obj);
    }

    public static DialogTimePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTimePickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTimePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558538, null, false, obj);
    }

    public static DialogTimePickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTimePickerBinding bind(View view, Object obj) {
        return (DialogTimePickerBinding) bind(obj, view, 2131558538);
    }
}
