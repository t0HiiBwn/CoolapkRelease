package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;

public abstract class ItemTitleCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final LinearLayout itemView;
    @Bindable
    protected String mTitle;
    public final Space spaceView;

    public abstract void setTitle(String str);

    protected ItemTitleCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, LinearLayout linearLayout, Space space) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.itemView = linearLayout;
        this.spaceView = space;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public static ItemTitleCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTitleCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558962, viewGroup, z, obj);
    }

    public static ItemTitleCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTitleCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558962, null, false, obj);
    }

    public static ItemTitleCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTitleCardBinding bind(View view, Object obj) {
        return (ItemTitleCardBinding) bind(obj, view, 2131558962);
    }
}
