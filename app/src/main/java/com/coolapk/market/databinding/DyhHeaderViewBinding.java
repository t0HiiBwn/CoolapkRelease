package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.github.florent37.arclayout.ArcLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class DyhHeaderViewBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionView;
    public final ArcLayout arcLayout;
    public final ImageView coverView;
    public final TextView descriptionView;
    public final TextView dyhNumView;
    public final TextView editTypeView;
    public final TextView editView;
    public final TextView infoView;
    public final RoundedImageView logoView;
    @Bindable
    protected DyhViewModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final ImageView userAvatarView;

    public abstract void setModel(DyhViewModel dyhViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected DyhHeaderViewBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, ArcLayout arcLayout2, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RoundedImageView roundedImageView, TextView textView7, ImageView imageView2) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionView = actionButtonFrameLayout;
        this.arcLayout = arcLayout2;
        this.coverView = imageView;
        this.descriptionView = textView2;
        this.dyhNumView = textView3;
        this.editTypeView = textView4;
        this.editView = textView5;
        this.infoView = textView6;
        this.logoView = roundedImageView;
        this.titleView = textView7;
        this.userAvatarView = imageView2;
    }

    public DyhViewModel getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static DyhHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DyhHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558543, viewGroup, z, obj);
    }

    public static DyhHeaderViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhHeaderViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DyhHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558543, null, false, obj);
    }

    public static DyhHeaderViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DyhHeaderViewBinding bind(View view, Object obj) {
        return (DyhHeaderViewBinding) bind(obj, view, 2131558543);
    }
}
