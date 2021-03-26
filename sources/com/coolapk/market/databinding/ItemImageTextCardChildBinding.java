package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemImageTextCardChildBinding extends ViewDataBinding {
    public final CardView cardView;
    public final AspectRatioImageView imageView;
    @Bindable
    protected String mCover;
    @Bindable
    protected Entity mModel;
    public final FrameLayout titleContainer;
    public final TextView titleView;

    public abstract void setCover(String str);

    public abstract void setModel(Entity entity);

    protected ItemImageTextCardChildBinding(Object obj, View view, int i, CardView cardView2, AspectRatioImageView aspectRatioImageView, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.imageView = aspectRatioImageView;
        this.titleContainer = frameLayout;
        this.titleView = textView;
    }

    public Entity getModel() {
        return this.mModel;
    }

    public String getCover() {
        return this.mCover;
    }

    public static ItemImageTextCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageTextCardChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemImageTextCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558794, viewGroup, z, obj);
    }

    public static ItemImageTextCardChildBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageTextCardChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemImageTextCardChildBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558794, null, false, obj);
    }

    public static ItemImageTextCardChildBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemImageTextCardChildBinding bind(View view, Object obj) {
        return (ItemImageTextCardChildBinding) bind(obj, view, 2131558794);
    }
}
