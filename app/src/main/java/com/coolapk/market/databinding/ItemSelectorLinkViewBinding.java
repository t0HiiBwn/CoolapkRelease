package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemSelectorLinkViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final FrameLayout frameView;
    public final LinearAdapterLayout itemView;
    @Bindable
    protected Entity mModel;

    public abstract void setModel(Entity entity);

    protected ItemSelectorLinkViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, FrameLayout frameLayout, LinearAdapterLayout linearAdapterLayout) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.frameView = frameLayout;
        this.itemView = linearAdapterLayout;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public static ItemSelectorLinkViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSelectorLinkViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSelectorLinkViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558923, viewGroup, z, obj);
    }

    public static ItemSelectorLinkViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSelectorLinkViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSelectorLinkViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558923, null, false, obj);
    }

    public static ItemSelectorLinkViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSelectorLinkViewBinding bind(View view, Object obj) {
        return (ItemSelectorLinkViewBinding) bind(obj, view, 2131558923);
    }
}
