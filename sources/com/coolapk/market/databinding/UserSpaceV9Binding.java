package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.userv9.UserSpaceV9ViewModel;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class UserSpaceV9Binding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout actionViewContainer;
    public final AppBarLayout appBar;
    public final IgnoreInsetFrameLayout appBarHolder;
    public final ImageView backgroundView;
    public final FrameLayout backgroundViewContainer;
    public final CoordinatorLayout coordinator;
    public final View divider;
    public final FrameLayout infoViewContainer;
    public final ProgressBar loadingView;
    public final FrameLayout logoViewContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected UserSpaceV9ViewModel mViewModel;
    public final DrawSystemBarFrameLayout mainContent;
    public final TextView nameView;
    public final LinearLayout nameViewContainer;
    public final ImageView qrcodeView;
    public final TextView refreshTextView;
    public final FrameLayout refreshView;
    public final Space spaceHolder;
    public final IgnoreInsetFrameLayout tabContainer;
    public final TabLayout tabs;
    public final TextView textView3;
    public final Toolbar toolbar;
    public final UserAvatarView userAvatarView;
    public final ItemUserInfoPartBinding userInfoView;
    public final UserToolbarBinding userToolbar;
    public final ScrollStateViewPager viewPager;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewModel(UserSpaceV9ViewModel userSpaceV9ViewModel);

    protected UserSpaceV9Binding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, AppBarLayout appBarLayout, IgnoreInsetFrameLayout ignoreInsetFrameLayout, ImageView imageView, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout, View view2, FrameLayout frameLayout2, ProgressBar progressBar, FrameLayout frameLayout3, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TextView textView2, LinearLayout linearLayout2, ImageView imageView2, TextView textView4, FrameLayout frameLayout4, Space space, IgnoreInsetFrameLayout ignoreInsetFrameLayout2, TabLayout tabLayout, TextView textView5, Toolbar toolbar2, UserAvatarView userAvatarView2, ItemUserInfoPartBinding itemUserInfoPartBinding, UserToolbarBinding userToolbarBinding, ScrollStateViewPager scrollStateViewPager) {
        super(obj, view, i);
        this.actionView = textView;
        this.actionViewContainer = linearLayout;
        this.appBar = appBarLayout;
        this.appBarHolder = ignoreInsetFrameLayout;
        this.backgroundView = imageView;
        this.backgroundViewContainer = frameLayout;
        this.coordinator = coordinatorLayout;
        this.divider = view2;
        this.infoViewContainer = frameLayout2;
        this.loadingView = progressBar;
        this.logoViewContainer = frameLayout3;
        this.mainContent = drawSystemBarFrameLayout;
        this.nameView = textView2;
        this.nameViewContainer = linearLayout2;
        this.qrcodeView = imageView2;
        this.refreshTextView = textView4;
        this.refreshView = frameLayout4;
        this.spaceHolder = space;
        this.tabContainer = ignoreInsetFrameLayout2;
        this.tabs = tabLayout;
        this.textView3 = textView5;
        this.toolbar = toolbar2;
        this.userAvatarView = userAvatarView2;
        this.userInfoView = itemUserInfoPartBinding;
        this.userToolbar = userToolbarBinding;
        this.viewPager = scrollStateViewPager;
    }

    public UserSpaceV9ViewModel getViewModel() {
        return this.mViewModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static UserSpaceV9Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserSpaceV9Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UserSpaceV9Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559295, viewGroup, z, obj);
    }

    public static UserSpaceV9Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserSpaceV9Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UserSpaceV9Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559295, null, false, obj);
    }

    public static UserSpaceV9Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UserSpaceV9Binding bind(View view, Object obj) {
        return (UserSpaceV9Binding) bind(obj, view, 2131559295);
    }
}
