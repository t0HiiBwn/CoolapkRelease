package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemPicTypeTabBinding extends ViewDataBinding {
    public final CheckedTextView textView;

    protected ItemPicTypeTabBinding(Object obj, View view, int i, CheckedTextView checkedTextView) {
        super(obj, view, i);
        this.textView = checkedTextView;
    }

    public static ItemPicTypeTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicTypeTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPicTypeTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558854, viewGroup, z, obj);
    }

    public static ItemPicTypeTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicTypeTabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPicTypeTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558854, null, false, obj);
    }

    public static ItemPicTypeTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicTypeTabBinding bind(View view, Object obj) {
        return (ItemPicTypeTabBinding) bind(obj, view, 2131558854);
    }
}
