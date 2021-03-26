package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemChannelTabBinding extends ViewDataBinding {
    public final ImageView addView;
    public final RelativeLayout backgroundView;
    public final LinearLayout contentView;
    public final ImageView deleteView;
    public final ImageView imageView;
    public final FrameLayout itemView;
    @Bindable
    protected String mLogoUrl;
    public final TextView textView;

    public abstract void setLogoUrl(String str);

    protected ItemChannelTabBinding(Object obj, View view, int i, ImageView imageView2, RelativeLayout relativeLayout, LinearLayout linearLayout, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout, TextView textView2) {
        super(obj, view, i);
        this.addView = imageView2;
        this.backgroundView = relativeLayout;
        this.contentView = linearLayout;
        this.deleteView = imageView3;
        this.imageView = imageView4;
        this.itemView = frameLayout;
        this.textView = textView2;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    public static ItemChannelTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChannelTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558646, viewGroup, z, obj);
    }

    public static ItemChannelTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTabBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChannelTabBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558646, null, false, obj);
    }

    public static ItemChannelTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChannelTabBinding bind(View view, Object obj) {
        return (ItemChannelTabBinding) bind(obj, view, 2131558646);
    }
}
