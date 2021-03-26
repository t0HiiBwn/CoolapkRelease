package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;

public abstract class ItemApkScrollWithBackgroundBinding extends ViewDataBinding {
    public final ImageView backgroundImageView;
    public final CoolapkCardView coolapkCardView;
    public final RecyclerView listView;
    @Bindable
    protected EntityCard mCard;
    public final ImageView maskView;

    public abstract void setCard(EntityCard entityCard);

    protected ItemApkScrollWithBackgroundBinding(Object obj, View view, int i, ImageView imageView, CoolapkCardView coolapkCardView2, RecyclerView recyclerView, ImageView imageView2) {
        super(obj, view, i);
        this.backgroundImageView = imageView;
        this.coolapkCardView = coolapkCardView2;
        this.listView = recyclerView;
        this.maskView = imageView2;
    }

    public EntityCard getCard() {
        return this.mCard;
    }

    public static ItemApkScrollWithBackgroundBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemApkScrollWithBackgroundBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemApkScrollWithBackgroundBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558592, viewGroup, z, obj);
    }

    public static ItemApkScrollWithBackgroundBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemApkScrollWithBackgroundBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemApkScrollWithBackgroundBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558592, null, false, obj);
    }

    public static ItemApkScrollWithBackgroundBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemApkScrollWithBackgroundBinding bind(View view, Object obj) {
        return (ItemApkScrollWithBackgroundBinding) bind(obj, view, 2131558592);
    }
}
