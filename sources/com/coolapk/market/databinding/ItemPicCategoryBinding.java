package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.PicCategory;

public abstract class ItemPicCategoryBinding extends ViewDataBinding {
    @Bindable
    protected PicCategory mModel;

    public abstract void setModel(PicCategory picCategory);

    protected ItemPicCategoryBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public PicCategory getModel() {
        return this.mModel;
    }

    public static ItemPicCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPicCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558860, viewGroup, z, obj);
    }

    public static ItemPicCategoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicCategoryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPicCategoryBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558860, null, false, obj);
    }

    public static ItemPicCategoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPicCategoryBinding bind(View view, Object obj) {
        return (ItemPicCategoryBinding) bind(obj, view, 2131558860);
    }
}
