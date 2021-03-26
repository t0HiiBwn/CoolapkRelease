package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemImageCardBinding extends ViewDataBinding {
    public final AspectRatioImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected Entity mCard;

    public abstract void setCard(Entity entity);

    protected ItemImageCardBinding(Object obj, View view, int i, AspectRatioImageView aspectRatioImageView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.imageView = aspectRatioImageView;
        this.itemView = frameLayout;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558794, viewGroup, z, obj);
    }

    public static ItemImageCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558794, null, false, obj);
    }

    public static ItemImageCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageCardBinding bind(View view, Object obj) {
        return (ItemImageCardBinding) bind(obj, view, 2131558794);
    }
}
