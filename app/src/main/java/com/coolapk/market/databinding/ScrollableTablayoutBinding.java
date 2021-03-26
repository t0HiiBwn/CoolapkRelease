package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.TabLayout;

public abstract class ScrollableTablayoutBinding extends ViewDataBinding {
    public final TabLayout tabs;

    protected ScrollableTablayoutBinding(Object obj, View view, int i, TabLayout tabLayout) {
        super(obj, view, i);
        this.tabs = tabLayout;
    }

    public static ScrollableTablayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ScrollableTablayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ScrollableTablayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559119, viewGroup, z, obj);
    }

    public static ScrollableTablayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ScrollableTablayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ScrollableTablayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559119, null, false, obj);
    }

    public static ScrollableTablayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ScrollableTablayoutBinding bind(View view, Object obj) {
        return (ScrollableTablayoutBinding) bind(obj, view, 2131559119);
    }
}
