package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemImageScrollCardItemBinding extends ViewDataBinding {
    public final AspectRatioImageView imageView;
    public final CardView itemView;
    @Bindable
    protected Entity mImageCard;

    public abstract void setImageCard(Entity entity);

    protected ItemImageScrollCardItemBinding(Object obj, View view, int i, AspectRatioImageView aspectRatioImageView, CardView cardView) {
        super(obj, view, i);
        this.imageView = aspectRatioImageView;
        this.itemView = cardView;
    }

    public Entity getImageCard() {
        return this.mImageCard;
    }

    public static ItemImageScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558793, viewGroup, z, obj);
    }

    public static ItemImageScrollCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageScrollCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558793, null, false, obj);
    }

    public static ItemImageScrollCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageScrollCardItemBinding bind(View view, Object obj) {
        return (ItemImageScrollCardItemBinding) bind(obj, view, 2131558793);
    }
}
