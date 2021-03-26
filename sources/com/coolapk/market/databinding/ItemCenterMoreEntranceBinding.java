package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.center.InternalRecyclerView;

public abstract class ItemCenterMoreEntranceBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout itemView;
    public final InternalRecyclerView recyclerView;
    public final TextView titleView;

    protected ItemCenterMoreEntranceBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, InternalRecyclerView internalRecyclerView, TextView textView2) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = linearLayout;
        this.recyclerView = internalRecyclerView;
        this.titleView = textView2;
    }

    public static ItemCenterMoreEntranceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCenterMoreEntranceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558645, viewGroup, z, obj);
    }

    public static ItemCenterMoreEntranceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCenterMoreEntranceBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558645, null, false, obj);
    }

    public static ItemCenterMoreEntranceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCenterMoreEntranceBinding bind(View view, Object obj) {
        return (ItemCenterMoreEntranceBinding) bind(obj, view, 2131558645);
    }
}
