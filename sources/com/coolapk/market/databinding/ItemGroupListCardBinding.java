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
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemGroupListCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ImageView enterView;
    public final RecyclerView listView;
    @Bindable
    protected View.OnClickListener mClick;
    public final TextView titleView;
    public final LinearLayout topView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemGroupListCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ImageView imageView, RecyclerView recyclerView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.enterView = imageView;
        this.listView = recyclerView;
        this.titleView = textView;
        this.topView = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGroupListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGroupListCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558778, viewGroup, z, obj);
    }

    public static ItemGroupListCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGroupListCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupListCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558778, null, false, obj);
    }

    public static ItemGroupListCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGroupListCardBinding bind(View view, Object obj) {
        return (ItemGroupListCardBinding) bind(obj, view, 2131558778);
    }
}
