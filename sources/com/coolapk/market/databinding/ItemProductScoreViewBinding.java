package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemProductScoreViewBinding extends ViewDataBinding {
    public final FrameLayout itemView;
    public final LinearAdapterLayout linearAdapterView;
    @Bindable
    protected Entity mCard;

    public abstract void setCard(Entity entity);

    protected ItemProductScoreViewBinding(Object obj, View view, int i, FrameLayout frameLayout, LinearAdapterLayout linearAdapterLayout) {
        super(obj, view, i);
        this.itemView = frameLayout;
        this.linearAdapterView = linearAdapterLayout;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemProductScoreViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductScoreViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductScoreViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558878, viewGroup, z, obj);
    }

    public static ItemProductScoreViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductScoreViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductScoreViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558878, null, false, obj);
    }

    public static ItemProductScoreViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductScoreViewBinding bind(View view, Object obj) {
        return (ItemProductScoreViewBinding) bind(obj, view, 2131558878);
    }
}
