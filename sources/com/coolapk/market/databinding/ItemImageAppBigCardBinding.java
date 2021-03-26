package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.EntityItemModel;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemImageAppBigCardBinding extends ViewDataBinding {
    public final AspectRatioImageView imageView;
    public final ItemAppInsideImageCardBinding includeApp;
    @Bindable
    protected EntityCard mCard;
    @Bindable
    protected EntityItemModel mModel;
    public final ImageView maskView;

    public abstract void setCard(EntityCard entityCard);

    public abstract void setModel(EntityItemModel entityItemModel);

    protected ItemImageAppBigCardBinding(Object obj, View view, int i, AspectRatioImageView aspectRatioImageView, ItemAppInsideImageCardBinding itemAppInsideImageCardBinding, ImageView imageView2) {
        super(obj, view, i);
        this.imageView = aspectRatioImageView;
        this.includeApp = itemAppInsideImageCardBinding;
        this.maskView = imageView2;
    }

    public EntityCard getCard() {
        return this.mCard;
    }

    public EntityItemModel getModel() {
        return this.mModel;
    }

    public static ItemImageAppBigCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppBigCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageAppBigCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558792, viewGroup, z, obj);
    }

    public static ItemImageAppBigCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppBigCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageAppBigCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558792, null, false, obj);
    }

    public static ItemImageAppBigCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageAppBigCardBinding bind(View view, Object obj) {
        return (ItemImageAppBigCardBinding) bind(obj, view, 2131558792);
    }
}
