package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemIconLinkGridCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView gridView;
    public final LinearLayout itemView;

    protected ItemIconLinkGridCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.gridView = recyclerView;
        this.itemView = linearLayout;
    }

    public static ItemIconLinkGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemIconLinkGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558779, viewGroup, z, obj);
    }

    public static ItemIconLinkGridCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemIconLinkGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558779, null, false, obj);
    }

    public static ItemIconLinkGridCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemIconLinkGridCardBinding bind(View view, Object obj) {
        return (ItemIconLinkGridCardBinding) bind(obj, view, 2131558779);
    }
}
