package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lany.picker.DatePicker;

public abstract class DialogDatePickerBinding extends ViewDataBinding {
    public final DatePicker datePicker;

    protected DialogDatePickerBinding(Object obj, View view, int i, DatePicker datePicker2) {
        super(obj, view, i);
        this.datePicker = datePicker2;
    }

    public static DialogDatePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDatePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDatePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558524, viewGroup, z, obj);
    }

    public static DialogDatePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDatePickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDatePickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558524, null, false, obj);
    }

    public static DialogDatePickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogDatePickerBinding bind(View view, Object obj) {
        return (DialogDatePickerBinding) bind(obj, view, 2131558524);
    }
}
