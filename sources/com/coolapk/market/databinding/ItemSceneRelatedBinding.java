package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemSceneRelatedBinding extends ViewDataBinding {
    public final ImageView closeView;
    public final LinearLayout itemView;
    public final RecyclerView recyclerView;
    public final TextView titleView;

    protected ItemSceneRelatedBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i);
        this.closeView = imageView;
        this.itemView = linearLayout;
        this.recyclerView = recyclerView2;
        this.titleView = textView;
    }

    public static ItemSceneRelatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSceneRelatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSceneRelatedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558903, viewGroup, z, obj);
    }

    public static ItemSceneRelatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSceneRelatedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSceneRelatedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558903, null, false, obj);
    }

    public static ItemSceneRelatedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSceneRelatedBinding bind(View view, Object obj) {
        return (ItemSceneRelatedBinding) bind(obj, view, 2131558903);
    }
}
