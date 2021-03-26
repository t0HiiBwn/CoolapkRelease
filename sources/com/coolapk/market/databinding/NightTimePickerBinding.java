package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lany.picker.HourMinutePicker;

public abstract class NightTimePickerBinding extends ViewDataBinding {
    public final HourMinutePicker endTimePicker;
    public final HourMinutePicker startTimePicker;

    protected NightTimePickerBinding(Object obj, View view, int i, HourMinutePicker hourMinutePicker, HourMinutePicker hourMinutePicker2) {
        super(obj, view, i);
        this.endTimePicker = hourMinutePicker;
        this.startTimePicker = hourMinutePicker2;
    }

    public static NightTimePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NightTimePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NightTimePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559062, viewGroup, z, obj);
    }

    public static NightTimePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NightTimePickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NightTimePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559062, null, false, obj);
    }

    public static NightTimePickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NightTimePickerBinding bind(View view, Object obj) {
        return (NightTimePickerBinding) bind(obj, view, 2131559062);
    }
}
