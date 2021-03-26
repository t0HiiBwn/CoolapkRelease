package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoControllerBinding extends ViewDataBinding {
    public final LinearLayout bottomContainer;
    public final TextView currentTimeView;
    public final ImageView fullScreenView;
    public final FrameLayout itemView;
    public final TextView liveView;
    public final LinearLayout liveViewContainer;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView moreView;
    public final ImageView navigationView;
    public final ImageView pipView;
    public final ImageView playView;
    public final ProgressBar progressBar;
    public final LinearLayout replayView;
    public final SeekBar seekBar;
    public final ImageView shareView;
    public final TextView titleView;
    public final LinearLayout topContainer;
    public final TextView totalTimeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected VideoControllerBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, ImageView imageView, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ProgressBar progressBar2, LinearLayout linearLayout3, SeekBar seekBar2, ImageView imageView6, TextView textView3, LinearLayout linearLayout4, TextView textView4) {
        super(obj, view, i);
        this.bottomContainer = linearLayout;
        this.currentTimeView = textView;
        this.fullScreenView = imageView;
        this.itemView = frameLayout;
        this.liveView = textView2;
        this.liveViewContainer = linearLayout2;
        this.moreView = imageView2;
        this.navigationView = imageView3;
        this.pipView = imageView4;
        this.playView = imageView5;
        this.progressBar = progressBar2;
        this.replayView = linearLayout3;
        this.seekBar = seekBar2;
        this.shareView = imageView6;
        this.titleView = textView3;
        this.topContainer = linearLayout4;
        this.totalTimeView = textView4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static VideoControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559289, viewGroup, z, obj);
    }

    public static VideoControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoControllerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559289, null, false, obj);
    }

    public static VideoControllerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoControllerBinding bind(View view, Object obj) {
        return (VideoControllerBinding) bind(obj, view, 2131559289);
    }
}
