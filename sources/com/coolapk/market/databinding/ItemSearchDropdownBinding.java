package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSearchDropdownBinding extends ViewDataBinding {
    public final ImageView divider;
    @Bindable
    protected String mText;
    public final TextView text1;

    public abstract void setText(String str);

    protected ItemSearchDropdownBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.divider = imageView;
        this.text1 = textView;
    }

    public String getText() {
        return this.mText;
    }

    public static ItemSearchDropdownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchDropdownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchDropdownBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558914, viewGroup, z, obj);
    }

    public static ItemSearchDropdownBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchDropdownBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchDropdownBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558914, null, false, obj);
    }

    public static ItemSearchDropdownBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSearchDropdownBinding bind(View view, Object obj) {
        return (ItemSearchDropdownBinding) bind(obj, view, 2131558914);
    }
}
