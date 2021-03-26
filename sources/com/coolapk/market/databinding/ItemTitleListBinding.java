package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemTitleListBinding extends ViewDataBinding {
    public final ImageView backgroundImageView;
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView listView;
    @Bindable
    protected String mTitle;

    public abstract void setTitle(String str);

    protected ItemTitleListBinding(Object obj, View view, int i, ImageView imageView, CoolapkCardView coolapkCardView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.backgroundImageView = imageView;
        this.coolapkCardView = coolapkCardView2;
        this.listView = recyclerView;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemTitleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTitleListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558963, viewGroup, z, obj);
    }

    public static ItemTitleListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTitleListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558963, null, false, obj);
    }

    public static ItemTitleListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleListBinding bind(View view, Object obj) {
        return (ItemTitleListBinding) bind(obj, view, 2131558963);
    }
}
