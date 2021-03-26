package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemImageAppCardBinding extends ViewDataBinding {
    public final AspectRatioImageView imageView;
    public final ItemAppInsideImageCardBinding includeApp;
    @Bindable
    protected EntityCard mCard;
    @Bindable
    protected EntityItemModel mModel;
    public final Space videoPlayerSpaceView;

    public abstract void setCard(EntityCard entityCard);

    public abstract void setModel(EntityItemModel entityItemModel);

    protected ItemImageAppCardBinding(Object obj, View view, int i, AspectRatioImageView aspectRatioImageView, ItemAppInsideImageCardBinding itemAppInsideImageCardBinding, Space space) {
        super(obj, view, i);
        this.imageView = aspectRatioImageView;
        this.includeApp = itemAppInsideImageCardBinding;
        this.videoPlayerSpaceView = space;
    }

    public EntityCard getCard() {
        return this.mCard;
    }

    public EntityItemModel getModel() {
        return this.mModel;
    }

    public static ItemImageAppCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageAppCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558793, viewGroup, z, obj);
    }

    public static ItemImageAppCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageAppCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558793, null, false, obj);
    }

    public static ItemImageAppCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppCardBinding bind(View view, Object obj) {
        return (ItemImageAppCardBinding) bind(obj, view, 2131558793);
    }
}
