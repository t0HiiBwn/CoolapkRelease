package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public abstract class ItemWebViewBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final AspectRatioImageView coverView;
    public final ImageView fullScreenButtom;
    public final FrameLayout holderView;
    public final LinearLayout itemView;
    @Bindable
    protected Entity mCard;
    public final FrameLayout webViewContainer;

    public abstract void setCard(Entity entity);

    protected ItemWebViewBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, AspectRatioImageView aspectRatioImageView, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.coverView = aspectRatioImageView;
        this.fullScreenButtom = imageView;
        this.holderView = frameLayout;
        this.itemView = linearLayout;
        this.webViewContainer = frameLayout2;
    }

    public Entity getCard() {
        return this.mCard;
    }

    public static ItemWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558990, viewGroup, z, obj);
    }

    public static ItemWebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558990, null, false, obj);
    }

    public static ItemWebViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWebViewBinding bind(View view, Object obj) {
        return (ItemWebViewBinding) bind(obj, view, 2131558990);
    }
}
