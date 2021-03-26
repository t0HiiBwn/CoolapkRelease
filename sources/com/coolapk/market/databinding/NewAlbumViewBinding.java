package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class NewAlbumViewBinding extends ViewDataBinding {
    public final LinearLayout actionView;
    public final TextView albumInfoView;
    public final FrameLayout albumListContent;
    public final TextView albumTitleView;
    public final AppBarLayout appBar;
    public final View fixStatusBar;
    public final ImageView headerImageView;
    public final LinearLayout headerView;
    public final Toolbar toolbar;
    public final CollapsingToolbarFixLayout toolbarLayout;
    public final TextView userFollowActionButton;
    public final CardView userInfoView;
    public final ImageView userLogoView;
    public final TextView userNameView;

    protected NewAlbumViewBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, TextView textView2, AppBarLayout appBarLayout, View view2, ImageView imageView, LinearLayout linearLayout2, Toolbar toolbar2, CollapsingToolbarFixLayout collapsingToolbarFixLayout, TextView textView3, CardView cardView, ImageView imageView2, TextView textView4) {
        super(obj, view, i);
        this.actionView = linearLayout;
        this.albumInfoView = textView;
        this.albumListContent = frameLayout;
        this.albumTitleView = textView2;
        this.appBar = appBarLayout;
        this.fixStatusBar = view2;
        this.headerImageView = imageView;
        this.headerView = linearLayout2;
        this.toolbar = toolbar2;
        this.toolbarLayout = collapsingToolbarFixLayout;
        this.userFollowActionButton = textView3;
        this.userInfoView = cardView;
        this.userLogoView = imageView2;
        this.userNameView = textView4;
    }

    public static NewAlbumViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewAlbumViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NewAlbumViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559060, viewGroup, z, obj);
    }

    public static NewAlbumViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewAlbumViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NewAlbumViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559060, null, false, obj);
    }

    public static NewAlbumViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NewAlbumViewBinding bind(View view, Object obj) {
        return (NewAlbumViewBinding) bind(obj, view, 2131559060);
    }
}
