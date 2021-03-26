package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.WeUIItem;

public abstract class ItemTextBinding extends ViewDataBinding {
    public final WeUIItem itemText;

    protected ItemTextBinding(Object obj, View view, int i, WeUIItem weUIItem) {
        super(obj, view, i);
        this.itemText = weUIItem;
    }

    public static ItemTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558946, viewGroup, z, obj);
    }

    public static ItemTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558946, null, false, obj);
    }

    public static ItemTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextBinding bind(View view, Object obj) {
        return (ItemTextBinding) bind(obj, view, 2131558946);
    }
}
