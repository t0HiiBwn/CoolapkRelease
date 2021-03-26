package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Ads;
import com.coolapk.market.util.CircleTransform;

public abstract class ItemAdsBinding extends ViewDataBinding {
    public final TextView actionText;
    public final FrameLayout actionView;
    public final CoolapkCardView coolapkCardView;
    public final ImageView iconView;
    public final LinearLayout itemView;
    @Bindable
    protected Ads mCard;
    @Bindable
    protected CircleTransform mCircleTransform;
    @Bindable
    protected boolean mShowAction;

    public abstract void setCard(Ads ads);

    public abstract void setCircleTransform(CircleTransform circleTransform);

    public abstract void setShowAction(boolean z);

    protected ItemAdsBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, CoolapkCardView coolapkCardView2, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.actionText = textView;
        this.actionView = frameLayout;
        this.coolapkCardView = coolapkCardView2;
        this.iconView = imageView;
        this.itemView = linearLayout;
    }

    public Ads getCard() {
        return this.mCard;
    }

    public boolean getShowAction() {
        return this.mShowAction;
    }

    public CircleTransform getCircleTransform() {
        return this.mCircleTransform;
    }

    public static ItemAdsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAdsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558581, viewGroup, z, obj);
    }

    public static ItemAdsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAdsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAdsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558581, null, false, obj);
    }

    public static ItemAdsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAdsBinding bind(View view, Object obj) {
        return (ItemAdsBinding) bind(obj, view, 2131558581);
    }
}
