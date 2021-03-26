package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class SearchBackHeaderBinding extends ViewDataBinding {
    public final ImageView arrowView;
    public final ImageView clearButton;
    public final ProgressBar loadingView;
    public final FrameLayout navigationButton;
    public final ImageView navigationIcon;
    public final FrameLayout qrOrClearButton;
    public final ImageView qrView;
    public final LinearLayout searchBoxLayout;
    public final FrameLayout searchButton;
    public final ImageView searchIcon;
    public final AutoCompleteTextView searchText;
    public final LinearLayout searchType;
    public final TextView searchTypeText;

    protected SearchBackHeaderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ProgressBar progressBar, FrameLayout frameLayout, ImageView imageView3, FrameLayout frameLayout2, ImageView imageView4, LinearLayout linearLayout, FrameLayout frameLayout3, ImageView imageView5, AutoCompleteTextView autoCompleteTextView, LinearLayout linearLayout2, TextView textView) {
        super(obj, view, i);
        this.arrowView = imageView;
        this.clearButton = imageView2;
        this.loadingView = progressBar;
        this.navigationButton = frameLayout;
        this.navigationIcon = imageView3;
        this.qrOrClearButton = frameLayout2;
        this.qrView = imageView4;
        this.searchBoxLayout = linearLayout;
        this.searchButton = frameLayout3;
        this.searchIcon = imageView5;
        this.searchText = autoCompleteTextView;
        this.searchType = linearLayout2;
        this.searchTypeText = textView;
    }

    public static SearchBackHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBackHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SearchBackHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559122, viewGroup, z, obj);
    }

    public static SearchBackHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBackHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SearchBackHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559122, null, false, obj);
    }

    public static SearchBackHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SearchBackHeaderBinding bind(View view, Object obj) {
        return (SearchBackHeaderBinding) bind(obj, view, 2131559122);
    }
}
