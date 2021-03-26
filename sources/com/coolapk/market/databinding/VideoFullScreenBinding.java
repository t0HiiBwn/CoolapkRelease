package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public abstract class VideoFullScreenBinding extends ViewDataBinding {
    public final DrawSystemBarFrameLayout contentView;
    @Bindable
    protected View.OnClickListener mClick;
    public final LinearLayout videoContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected VideoFullScreenBinding(Object obj, View view, int i, DrawSystemBarFrameLayout drawSystemBarFrameLayout, LinearLayout linearLayout) {
        super(obj, view, i);
        this.contentView = drawSystemBarFrameLayout;
        this.videoContainer = linearLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static VideoFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559302, viewGroup, z, obj);
    }

    public static VideoFullScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFullScreenBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoFullScreenBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559302, null, false, obj);
    }

    public static VideoFullScreenBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoFullScreenBinding bind(View view, Object obj) {
        return (VideoFullScreenBinding) bind(obj, view, 2131559302);
    }
}
