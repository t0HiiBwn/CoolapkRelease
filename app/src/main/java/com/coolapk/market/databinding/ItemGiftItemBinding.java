package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Gift;

public abstract class ItemGiftItemBinding extends ViewDataBinding {
    public final TextView giftContent;
    public final TextView giftDateLine;
    public final TextView giftGetText;
    public final ImageView giftLogoView;
    public final ProgressBar giftProgressView;
    public final LinearLayout itemView;
    @Bindable
    protected Gift mGift;
    public final TextView progressBarText;
    public final TextView titleGameView;

    public abstract void setGift(Gift gift);

    protected ItemGiftItemBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ProgressBar progressBar, LinearLayout linearLayout, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.giftContent = textView;
        this.giftDateLine = textView2;
        this.giftGetText = textView3;
        this.giftLogoView = imageView;
        this.giftProgressView = progressBar;
        this.itemView = linearLayout;
        this.progressBarText = textView4;
        this.titleGameView = textView5;
    }

    public Gift getGift() {
        return this.mGift;
    }

    public static ItemGiftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGiftItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGiftItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558751, viewGroup, z, obj);
    }

    public static ItemGiftItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGiftItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGiftItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558751, null, false, obj);
    }

    public static ItemGiftItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGiftItemBinding bind(View view, Object obj) {
        return (ItemGiftItemBinding) bind(obj, view, 2131558751);
    }
}
