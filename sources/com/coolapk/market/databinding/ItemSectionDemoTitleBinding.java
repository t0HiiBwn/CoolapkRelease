package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.demo.SectionDemoFragment;

public abstract class ItemSectionDemoTitleBinding extends ViewDataBinding {
    @Bindable
    protected SectionDemoFragment.SectionViewHolder mVh;

    public abstract void setVh(SectionDemoFragment.SectionViewHolder sectionViewHolder);

    protected ItemSectionDemoTitleBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public SectionDemoFragment.SectionViewHolder getVh() {
        return this.mVh;
    }

    public static ItemSectionDemoTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSectionDemoTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSectionDemoTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558928, viewGroup, z, obj);
    }

    public static ItemSectionDemoTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSectionDemoTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSectionDemoTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558928, null, false, obj);
    }

    public static ItemSectionDemoTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSectionDemoTitleBinding bind(View view, Object obj) {
        return (ItemSectionDemoTitleBinding) bind(obj, view, 2131558928);
    }
}
