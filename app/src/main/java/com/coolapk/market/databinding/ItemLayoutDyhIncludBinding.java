package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemLayoutDyhIncludBinding extends ViewDataBinding {
    public final TextView actionDone;
    public final TextView descriptionView;
    public final LinearLayout headContainer;
    public final TextView headText;
    public final RecyclerView listView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemLayoutDyhIncludBinding(Object obj, View view, int i, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, RecyclerView recyclerView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.actionDone = textView;
        this.descriptionView = textView2;
        this.headContainer = linearLayout;
        this.headText = textView3;
        this.listView = recyclerView;
        this.rootView = linearLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemLayoutDyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLayoutDyhIncludBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLayoutDyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558798, viewGroup, z, obj);
    }

    public static ItemLayoutDyhIncludBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLayoutDyhIncludBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLayoutDyhIncludBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558798, null, false, obj);
    }

    public static ItemLayoutDyhIncludBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLayoutDyhIncludBinding bind(View view, Object obj) {
        return (ItemLayoutDyhIncludBinding) bind(obj, view, 2131558798);
    }
}
