package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SearchListBinding extends ViewDataBinding {
    @Bindable
    protected String mPic;
    public final RecyclerView recyclerView;
    public final TextView titleView;

    public abstract void setPic(String str);

    protected SearchListBinding(Object obj, View view, int i, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i);
        this.recyclerView = recyclerView2;
        this.titleView = textView;
    }

    public String getPic() {
        return this.mPic;
    }

    public static SearchListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559127, viewGroup, z, obj);
    }

    public static SearchListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559127, null, false, obj);
    }

    public static SearchListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchListBinding bind(View view, Object obj) {
        return (SearchListBinding) bind(obj, view, 2131559127);
    }
}
