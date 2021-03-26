package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemUserRatingBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final LinearLayout cardView;
    public final ImageView iconView;
    @Bindable
    protected ServiceApp mApp;
    @Bindable
    protected BindingViewHolder mViewHolder;
    public final LinearLayout optionLayout;
    public final RatingBar ratingBar;
    public final TextView titleView;

    public abstract void setApp(ServiceApp serviceApp);

    public abstract void setViewHolder(BindingViewHolder bindingViewHolder);

    protected ItemUserRatingBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RatingBar ratingBar2, TextView textView2) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.cardView = linearLayout;
        this.iconView = imageView;
        this.optionLayout = linearLayout2;
        this.ratingBar = ratingBar2;
        this.titleView = textView2;
    }

    public BindingViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public ServiceApp getApp() {
        return this.mApp;
    }

    public static ItemUserRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558988, viewGroup, z, obj);
    }

    public static ItemUserRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558988, null, false, obj);
    }

    public static ItemUserRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserRatingBinding bind(View view, Object obj) {
        return (ItemUserRatingBinding) bind(obj, view, 2131558988);
    }
}
