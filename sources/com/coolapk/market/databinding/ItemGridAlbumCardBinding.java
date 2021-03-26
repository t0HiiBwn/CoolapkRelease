package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemGridAlbumCardBinding extends ViewDataBinding {
    public final RecyclerView gridView;
    public final View itemDivider;
    @Bindable
    protected String mTitle;
    public final LinearLayout moreView;

    public abstract void setTitle(String str);

    protected ItemGridAlbumCardBinding(Object obj, View view, int i, RecyclerView recyclerView, View view2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.gridView = recyclerView;
        this.itemDivider = view2;
        this.moreView = linearLayout;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemGridAlbumCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridAlbumCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridAlbumCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558771, viewGroup, z, obj);
    }

    public static ItemGridAlbumCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridAlbumCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridAlbumCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558771, null, false, obj);
    }

    public static ItemGridAlbumCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridAlbumCardBinding bind(View view, Object obj) {
        return (ItemGridAlbumCardBinding) bind(obj, view, 2131558771);
    }
}
