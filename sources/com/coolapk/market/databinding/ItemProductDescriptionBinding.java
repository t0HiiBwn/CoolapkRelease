package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.lankton.flowlayout.FlowLayout;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemProductDescriptionBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final LinearLayout itemView;
    public final FlowLayout tagsContainer;

    protected ItemProductDescriptionBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView, LinearLayout linearLayout, FlowLayout flowLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView;
        this.itemView = linearLayout;
        this.tagsContainer = flowLayout;
    }

    public static ItemProductDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductDescriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558873, viewGroup, z, obj);
    }

    public static ItemProductDescriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductDescriptionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductDescriptionBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558873, null, false, obj);
    }

    public static ItemProductDescriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductDescriptionBinding bind(View view, Object obj) {
        return (ItemProductDescriptionBinding) bind(obj, view, 2131558873);
    }
}
