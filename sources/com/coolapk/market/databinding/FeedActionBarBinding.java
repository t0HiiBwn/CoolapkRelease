package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.AlbumActionView;

public abstract class FeedActionBarBinding extends ViewDataBinding {
    public final TextView albumAddAppView;
    public final TextView editView;
    public final AlbumActionView feedAction;
    public final LinearLayout userActionView;

    protected FeedActionBarBinding(Object obj, View view, int i, TextView textView, TextView textView2, AlbumActionView albumActionView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.albumAddAppView = textView;
        this.editView = textView2;
        this.feedAction = albumActionView;
        this.userActionView = linearLayout;
    }

    public static FeedActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FeedActionBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558552, viewGroup, z, obj);
    }

    public static FeedActionBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedActionBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeedActionBarBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558552, null, false, obj);
    }

    public static FeedActionBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeedActionBarBinding bind(View view, Object obj) {
        return (FeedActionBarBinding) bind(obj, view, 2131558552);
    }
}
