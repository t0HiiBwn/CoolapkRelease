package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemDyhSourceTitleBinding extends ViewDataBinding {
    public final RecyclerView articleList;
    public final CoolapkCardView coolapkCardView;

    protected ItemDyhSourceTitleBinding(Object obj, View view, int i, RecyclerView recyclerView, CoolapkCardView coolapkCardView2) {
        super(obj, view, i);
        this.articleList = recyclerView;
        this.coolapkCardView = coolapkCardView2;
    }

    public static ItemDyhSourceTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourceTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDyhSourceTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558690, viewGroup, z, obj);
    }

    public static ItemDyhSourceTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourceTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDyhSourceTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558690, null, false, obj);
    }

    public static ItemDyhSourceTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDyhSourceTitleBinding bind(View view, Object obj) {
        return (ItemDyhSourceTitleBinding) bind(obj, view, 2131558690);
    }
}
