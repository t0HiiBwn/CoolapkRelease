package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.BlockBackEventLayout;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.InstantAutoComplete;
import com.coolapk.market.widget.TagsView;

public abstract class SearchBinding extends ViewDataBinding {
    public final ImageView clearButton;
    public final DrawSystemBarFrameLayout clickableLayout;
    public final TagsView keywordsView;
    public final ImageView navigationButton;
    public final ImageView qrView;
    public final BlockBackEventLayout searchBoxBg;
    public final ImageView searchButton;
    public final InstantAutoComplete searchText;

    protected SearchBinding(Object obj, View view, int i, ImageView imageView, DrawSystemBarFrameLayout drawSystemBarFrameLayout, TagsView tagsView, ImageView imageView2, ImageView imageView3, BlockBackEventLayout blockBackEventLayout, ImageView imageView4, InstantAutoComplete instantAutoComplete) {
        super(obj, view, i);
        this.clearButton = imageView;
        this.clickableLayout = drawSystemBarFrameLayout;
        this.keywordsView = tagsView;
        this.navigationButton = imageView2;
        this.qrView = imageView3;
        this.searchBoxBg = blockBackEventLayout;
        this.searchButton = imageView4;
        this.searchText = instantAutoComplete;
    }

    public static SearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559121, viewGroup, z, obj);
    }

    public static SearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559121, null, false, obj);
    }

    public static SearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBinding bind(View view, Object obj) {
        return (SearchBinding) bind(obj, view, 2131559121);
    }
}
