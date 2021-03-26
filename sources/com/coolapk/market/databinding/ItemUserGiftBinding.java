package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Gift;

public abstract class ItemUserGiftBinding extends ViewDataBinding {
    public final TextView giftContent;
    public final TextView giftDateLine;
    public final TextView giftGetText;
    public final ImageView giftLogoView;
    public final LinearLayout itemView;
    @Bindable
    protected Gift mGift;
    public final TextView titleGameView;

    public abstract void setGift(Gift gift);

    protected ItemUserGiftBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, LinearLayout linearLayout, TextView textView4) {
        super(obj, view, i);
        this.giftContent = textView;
        this.giftDateLine = textView2;
        this.giftGetText = textView3;
        this.giftLogoView = imageView;
        this.itemView = linearLayout;
        this.titleGameView = textView4;
    }

    public Gift getGift() {
        return this.mGift;
    }

    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558972, viewGroup, z, obj);
    }

    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558972, null, false, obj);
    }

    public static ItemUserGiftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserGiftBinding bind(View view, Object obj) {
        return (ItemUserGiftBinding) bind(obj, view, 2131558972);
    }
}
