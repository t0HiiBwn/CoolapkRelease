package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class PhotoPickerBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final LinearLayout bottomClickView;
    public final LinearLayout bottomView;
    public final DrawSystemBarFrameLayout contentView;
    public final RelativeLayout directoryView;
    public final View dividerView;
    public final ImageView externalImage;
    public final ImageView imageView;
    public final ListView listView;
    public final RecyclerView recyclerView;
    public final TextView textView;
    public final Toolbar toolbar;

    protected PhotoPickerBinding(Object obj, View view, int i, AppBarLayout appBarLayout, LinearLayout linearLayout, LinearLayout linearLayout2, DrawSystemBarFrameLayout drawSystemBarFrameLayout, RelativeLayout relativeLayout, View view2, ImageView imageView2, ImageView imageView3, ListView listView2, RecyclerView recyclerView2, TextView textView2, Toolbar toolbar2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.bottomClickView = linearLayout;
        this.bottomView = linearLayout2;
        this.contentView = drawSystemBarFrameLayout;
        this.directoryView = relativeLayout;
        this.dividerView = view2;
        this.externalImage = imageView2;
        this.imageView = imageView3;
        this.listView = listView2;
        this.recyclerView = recyclerView2;
        this.textView = textView2;
        this.toolbar = toolbar2;
    }

    public static PhotoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PhotoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559080, viewGroup, z, obj);
    }

    public static PhotoPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PhotoPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559080, null, false, obj);
    }

    public static PhotoPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PhotoPickerBinding bind(View view, Object obj) {
        return (PhotoPickerBinding) bind(obj, view, 2131559080);
    }
}
