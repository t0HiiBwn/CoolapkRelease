package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class TopicPickerBinding extends ViewDataBinding {
    public final AppBarLayout appBar;
    public final FrameLayout contentFragment;
    public final DrawSystemBarFrameLayout mainContent;
    public final SearchBackHeaderBinding searchHeader;

    protected TopicPickerBinding(Object obj, View view, int i, AppBarLayout appBarLayout, FrameLayout frameLayout, DrawSystemBarFrameLayout drawSystemBarFrameLayout, SearchBackHeaderBinding searchBackHeaderBinding) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.contentFragment = frameLayout;
        this.mainContent = drawSystemBarFrameLayout;
        this.searchHeader = searchBackHeaderBinding;
    }

    public static TopicPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559205, viewGroup, z, obj);
    }

    public static TopicPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559205, null, false, obj);
    }

    public static TopicPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicPickerBinding bind(View view, Object obj) {
        return (TopicPickerBinding) bind(obj, view, 2131559205);
    }
}
