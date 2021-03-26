package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemNewGridCardBinding extends ViewDataBinding {
    public final TextView actionMoreView;
    public final ImageView closeView;
    public final ImageView enterView;
    public final RecyclerView gridView;
    @Bindable
    protected String mTitle;
    public final LinearLayout moreView;

    public abstract void setTitle(String str);

    protected ItemNewGridCardBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionMoreView = textView;
        this.closeView = imageView;
        this.enterView = imageView2;
        this.gridView = recyclerView;
        this.moreView = linearLayout;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemNewGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewGridCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNewGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558842, viewGroup, z, obj);
    }

    public static ItemNewGridCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewGridCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNewGridCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558842, null, false, obj);
    }

    public static ItemNewGridCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNewGridCardBinding bind(View view, Object obj) {
        return (ItemNewGridCardBinding) bind(obj, view, 2131558842);
    }
}
