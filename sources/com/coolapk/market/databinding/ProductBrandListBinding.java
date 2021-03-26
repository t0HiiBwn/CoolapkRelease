package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;

public abstract class ProductBrandListBinding extends ViewDataBinding {
    public final FrameLayout contentView;
    public final FrameLayout frameView;
    public final LoadingViewBinding loadingView;
    public final PreventAutoScrollRecyclerView recyclerView;

    protected ProductBrandListBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, LoadingViewBinding loadingViewBinding, PreventAutoScrollRecyclerView preventAutoScrollRecyclerView) {
        super(obj, view, i);
        this.contentView = frameLayout;
        this.frameView = frameLayout2;
        this.loadingView = loadingViewBinding;
        this.recyclerView = preventAutoScrollRecyclerView;
    }

    public static ProductBrandListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductBrandListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ProductBrandListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559114, viewGroup, z, obj);
    }

    public static ProductBrandListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductBrandListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ProductBrandListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559114, null, false, obj);
    }

    public static ProductBrandListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductBrandListBinding bind(View view, Object obj) {
        return (ProductBrandListBinding) bind(obj, view, 2131559114);
    }
}
