package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.TabLayout;

public abstract class FixedTablayoutBinding extends ViewDataBinding {
    public final TabLayout tabs;

    protected FixedTablayoutBinding(Object obj, View view, int i, TabLayout tabLayout) {
        super(obj, view, i);
        this.tabs = tabLayout;
    }

    public static FixedTablayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FixedTablayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FixedTablayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558568, viewGroup, z, obj);
    }

    public static FixedTablayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FixedTablayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FixedTablayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558568, null, false, obj);
    }

    public static FixedTablayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FixedTablayoutBinding bind(View view, Object obj) {
        return (FixedTablayoutBinding) bind(obj, view, 2131558568);
    }
}
