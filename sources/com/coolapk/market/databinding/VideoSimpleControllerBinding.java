package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoSimpleControllerBinding extends ViewDataBinding {
    public final FrameLayout contentView;
    public final TextView liveView;
    public final LinearLayout liveViewContainer;
    @Bindable
    protected View.OnClickListener mClick;
    public final FrameLayout maskView;
    public final ImageView playView;
    public final ProgressBar progressBar;
    public final TextView remainTimeView;
    public final ImageView volumeIconView;
    public final FrameLayout volumeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected VideoSimpleControllerBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, FrameLayout frameLayout2, ImageView imageView, ProgressBar progressBar2, TextView textView2, ImageView imageView2, FrameLayout frameLayout3) {
        super(obj, view, i);
        this.contentView = frameLayout;
        this.liveView = textView;
        this.liveViewContainer = linearLayout;
        this.maskView = frameLayout2;
        this.playView = imageView;
        this.progressBar = progressBar2;
        this.remainTimeView = textView2;
        this.volumeIconView = imageView2;
        this.volumeView = frameLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static VideoSimpleControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoSimpleControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoSimpleControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559305, viewGroup, z, obj);
    }

    public static VideoSimpleControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoSimpleControllerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoSimpleControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559305, null, false, obj);
    }

    public static VideoSimpleControllerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoSimpleControllerBinding bind(View view, Object obj) {
        return (VideoSimpleControllerBinding) bind(obj, view, 2131559305);
    }
}
