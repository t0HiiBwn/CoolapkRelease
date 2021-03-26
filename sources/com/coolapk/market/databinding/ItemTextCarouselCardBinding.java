package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.EntityCard;
import com.gongwen.marqueen.MarqueeView;

public abstract class ItemTextCarouselCardBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    public final ImageView imageView;
    @Bindable
    protected EntityCard mEntity;
    public final MarqueeView marqueeView;

    public abstract void setEntity(EntityCard entityCard);

    protected ItemTextCarouselCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, ImageView imageView2, MarqueeView marqueeView2) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.imageView = imageView2;
        this.marqueeView = marqueeView2;
    }

    public EntityCard getEntity() {
        return this.mEntity;
    }

    public static ItemTextCarouselCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCarouselCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextCarouselCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558955, viewGroup, z, obj);
    }

    public static ItemTextCarouselCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCarouselCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextCarouselCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558955, null, false, obj);
    }

    public static ItemTextCarouselCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemTextCarouselCardBinding bind(View view, Object obj) {
        return (ItemTextCarouselCardBinding) bind(obj, view, 2131558955);
    }
}
