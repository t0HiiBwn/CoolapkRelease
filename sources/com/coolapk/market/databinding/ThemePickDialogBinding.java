package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.ColorPickerView;

public abstract class ThemePickDialogBinding extends ViewDataBinding {
    public final TextView cancelButton;
    public final ColorPickerView colorPickerView;
    public final LinearLayout contentView;
    public final TextView customButton;
    public final View iconView;
    public final TextView okButton;

    protected ThemePickDialogBinding(Object obj, View view, int i, TextView textView, ColorPickerView colorPickerView2, LinearLayout linearLayout, TextView textView2, View view2, TextView textView3) {
        super(obj, view, i);
        this.cancelButton = textView;
        this.colorPickerView = colorPickerView2;
        this.contentView = linearLayout;
        this.customButton = textView2;
        this.iconView = view2;
        this.okButton = textView3;
    }

    public static ThemePickDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ThemePickDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559195, viewGroup, z, obj);
    }

    public static ThemePickDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ThemePickDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559195, null, false, obj);
    }

    public static ThemePickDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ThemePickDialogBinding bind(View view, Object obj) {
        return (ThemePickDialogBinding) bind(obj, view, 2131559195);
    }
}
