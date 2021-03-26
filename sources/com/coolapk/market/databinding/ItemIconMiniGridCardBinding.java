package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemIconMiniGridCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView recyclerView;

    protected ItemIconMiniGridCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.recyclerView = recyclerView2;
    }

    public static ItemIconMiniGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconMiniGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558789, viewGroup, z, obj);
    }

    public static ItemIconMiniGridCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconMiniGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558789, null, false, obj);
    }

    public static ItemIconMiniGridCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconMiniGridCardBinding bind(View view, Object obj) {
        return (ItemIconMiniGridCardBinding) bind(obj, view, 2131558789);
    }
}
