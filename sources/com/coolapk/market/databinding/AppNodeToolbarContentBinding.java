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
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;

public abstract class AppNodeToolbarContentBinding extends ViewDataBinding {
    public final ActionButton actionButton;
    public final ActionButton followActionView;
    public final TextView hotView;
    @Bindable
    protected AppNodeViewModel mModel;
    public final RatingBar ratingBar;
    public final TextView scoreView;
    public final LinearLayout scoreViewContainer;
    public final ImageView toolbarLogoView;
    public final TextView toolbarTitleView;

    public abstract void setModel(AppNodeViewModel appNodeViewModel);

    protected AppNodeToolbarContentBinding(Object obj, View view, int i, ActionButton actionButton2, ActionButton actionButton3, TextView textView, RatingBar ratingBar2, TextView textView2, LinearLayout linearLayout, ImageView imageView, TextView textView3) {
        super(obj, view, i);
        this.actionButton = actionButton2;
        this.followActionView = actionButton3;
        this.hotView = textView;
        this.ratingBar = ratingBar2;
        this.scoreView = textView2;
        this.scoreViewContainer = linearLayout;
        this.toolbarLogoView = imageView;
        this.toolbarTitleView = textView3;
    }

    public AppNodeViewModel getModel() {
        return this.mModel;
    }

    public static AppNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppNodeToolbarContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558465, viewGroup, z, obj);
    }

    public static AppNodeToolbarContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeToolbarContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppNodeToolbarContentBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558465, null, false, obj);
    }

    public static AppNodeToolbarContentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeToolbarContentBinding bind(View view, Object obj) {
        return (AppNodeToolbarContentBinding) bind(obj, view, 2131558465);
    }
}
