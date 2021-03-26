package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemMainCategoryLinkBinding extends ViewDataBinding {
    public final ItemMainCategoryChildBinding itemView1;
    public final ItemMainCategoryChildBinding itemView2;
    public final ItemMainCategoryChildBinding itemView3;
    public final ItemMainCategoryChildBinding itemView4;

    protected ItemMainCategoryLinkBinding(Object obj, View view, int i, ItemMainCategoryChildBinding itemMainCategoryChildBinding, ItemMainCategoryChildBinding itemMainCategoryChildBinding2, ItemMainCategoryChildBinding itemMainCategoryChildBinding3, ItemMainCategoryChildBinding itemMainCategoryChildBinding4) {
        super(obj, view, i);
        this.itemView1 = itemMainCategoryChildBinding;
        this.itemView2 = itemMainCategoryChildBinding2;
        this.itemView3 = itemMainCategoryChildBinding3;
        this.itemView4 = itemMainCategoryChildBinding4;
    }

    public static ItemMainCategoryLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMainCategoryLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558820, viewGroup, z, obj);
    }

    public static ItemMainCategoryLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMainCategoryLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558820, null, false, obj);
    }

    public static ItemMainCategoryLinkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMainCategoryLinkBinding bind(View view, Object obj) {
        return (ItemMainCategoryLinkBinding) bind(obj, view, 2131558820);
    }
}
