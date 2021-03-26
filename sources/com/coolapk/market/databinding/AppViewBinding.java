package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.AppExtensionBar;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class AppViewBinding extends ViewDataBinding {
    public final TextView actionFabText;
    public final FloatingActionButton actionView;
    public final FrameLayout actionViewContainer;
    public final AppBarLayout appBar;
    public final AppExtensionBar appExtensionBar;
    public final ImageView appIcon;
    public final ItemAppViewDownloadBinding appViewDownload;
    public final FrameLayout appViewRecycler;
    public final ImageView arrowView;
    public final FrameLayout bottomLayout;
    public final CollapsingToolbarFixLayout collapsingToolbar;
    public final LinearLayout commentBox;
    public final LinearLayout commentView;
    public final ImageView coverView;
    public final View coverViewMask;
    public final TextView emptyTextView;
    public final Button followView;
    public final LinearLayout headerView;
    public final LinearLayout infoView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final CoordinatorLayout mainContent;
    public final ImageView moreView;
    public final ProgressBar progressBar;
    public final TextView titleView;
    public final Toolbar toolbar;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected AppViewBinding(Object obj, View view, int i, TextView textView, FloatingActionButton floatingActionButton, FrameLayout frameLayout, AppBarLayout appBarLayout, AppExtensionBar appExtensionBar2, ImageView imageView, ItemAppViewDownloadBinding itemAppViewDownloadBinding, FrameLayout frameLayout2, ImageView imageView2, FrameLayout frameLayout3, CollapsingToolbarFixLayout collapsingToolbarFixLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, View view2, TextView textView2, Button button, LinearLayout linearLayout3, LinearLayout linearLayout4, CoordinatorLayout coordinatorLayout, ImageView imageView4, ProgressBar progressBar2, TextView textView3, Toolbar toolbar2) {
        super(obj, view, i);
        this.actionFabText = textView;
        this.actionView = floatingActionButton;
        this.actionViewContainer = frameLayout;
        this.appBar = appBarLayout;
        this.appExtensionBar = appExtensionBar2;
        this.appIcon = imageView;
        this.appViewDownload = itemAppViewDownloadBinding;
        this.appViewRecycler = frameLayout2;
        this.arrowView = imageView2;
        this.bottomLayout = frameLayout3;
        this.collapsingToolbar = collapsingToolbarFixLayout;
        this.commentBox = linearLayout;
        this.commentView = linearLayout2;
        this.coverView = imageView3;
        this.coverViewMask = view2;
        this.emptyTextView = textView2;
        this.followView = button;
        this.headerView = linearLayout3;
        this.infoView = linearLayout4;
        this.mainContent = coordinatorLayout;
        this.moreView = imageView4;
        this.progressBar = progressBar2;
        this.titleView = textView3;
        this.toolbar = toolbar2;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static AppViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558467, viewGroup, z, obj);
    }

    public static AppViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558467, null, false, obj);
    }

    public static AppViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppViewBinding bind(View view, Object obj) {
        return (AppViewBinding) bind(obj, view, 2131558467);
    }
}
