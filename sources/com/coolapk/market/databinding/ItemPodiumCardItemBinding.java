package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.ActionButton;

public abstract class ItemPodiumCardItemBinding extends ViewDataBinding {
    public final TextView actionButton2;
    public final ActionButton actionContainer;
    public final ImageView backgroundImageView;
    public final FrameLayout contentLayout;
    public final ImageView iconView;
    public final RelativeLayout itemView;
    @Bindable
    protected ServiceApp mApp;
    @Bindable
    protected String mLogo;
    @Bindable
    protected String mScore;
    @Bindable
    protected String mTitle;
    public final ImageView numView;
    public final TextView scoreView;
    public final ImageView scoreViewIcon;
    public final TextView titleView;

    public abstract void setApp(ServiceApp serviceApp);

    public abstract void setLogo(String str);

    public abstract void setScore(String str);

    public abstract void setTitle(String str);

    protected ItemPodiumCardItemBinding(Object obj, View view, int i, TextView textView, ActionButton actionButton, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, RelativeLayout relativeLayout, ImageView imageView3, TextView textView2, ImageView imageView4, TextView textView3) {
        super(obj, view, i);
        this.actionButton2 = textView;
        this.actionContainer = actionButton;
        this.backgroundImageView = imageView;
        this.contentLayout = frameLayout;
        this.iconView = imageView2;
        this.itemView = relativeLayout;
        this.numView = imageView3;
        this.scoreView = textView2;
        this.scoreViewIcon = imageView4;
        this.titleView = textView3;
    }

    public ServiceApp getApp() {
        return this.mApp;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getScore() {
        return this.mScore;
    }

    public static ItemPodiumCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPodiumCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558867, viewGroup, z, obj);
    }

    public static ItemPodiumCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPodiumCardItemBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558867, null, false, obj);
    }

    public static ItemPodiumCardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardItemBinding bind(View view, Object obj) {
        return (ItemPodiumCardItemBinding) bind(obj, view, 2131558867);
    }
}
