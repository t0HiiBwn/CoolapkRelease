package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemGridCardViewBinding extends ViewDataBinding {
    public final RecyclerView gridView;
    public final TextView moreView;
    public final LinearLayout rootView;
    public final TextView titleView;

    protected ItemGridCardViewBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.gridView = recyclerView;
        this.moreView = textView;
        this.rootView = linearLayout;
        this.titleView = textView2;
    }

    public static ItemGridCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGridCardViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558767, viewGroup, z, obj);
    }

    public static ItemGridCardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGridCardViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558767, null, false, obj);
    }

    public static ItemGridCardViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGridCardViewBinding bind(View view, Object obj) {
        return (ItemGridCardViewBinding) bind(obj, view, 2131558767);
    }
}
