package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SearchSceneListBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected SearchSceneListBinding(Object obj, View view, int i, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
    }

    public static SearchSceneListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchSceneListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559131, viewGroup, z, obj);
    }

    public static SearchSceneListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchSceneListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559131, null, false, obj);
    }

    public static SearchSceneListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchSceneListBinding bind(View view, Object obj) {
        return (SearchSceneListBinding) bind(obj, view, 2131559131);
    }
}
