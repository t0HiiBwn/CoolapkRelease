package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class VideoGestureBinding extends ViewDataBinding {
    public final LinearLayout brightnessBoxView;
    public final ImageView brightnessIconView;
    public final TextView brightnessTextView;
    public final LinearLayout fastForwardBoxView;
    public final TextView fastForwardProgressTimeView;
    public final TextView fastForwardStepTimeView;
    public final LinearLayout volumeBoxView;
    public final ImageView volumeIconView;
    public final TextView volumeTextView;

    protected VideoGestureBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, LinearLayout linearLayout3, ImageView imageView2, TextView textView4) {
        super(obj, view, i);
        this.brightnessBoxView = linearLayout;
        this.brightnessIconView = imageView;
        this.brightnessTextView = textView;
        this.fastForwardBoxView = linearLayout2;
        this.fastForwardProgressTimeView = textView2;
        this.fastForwardStepTimeView = textView3;
        this.volumeBoxView = linearLayout3;
        this.volumeIconView = imageView2;
        this.volumeTextView = textView4;
    }

    public static VideoGestureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoGestureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoGestureBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559293, viewGroup, z, obj);
    }

    public static VideoGestureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoGestureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoGestureBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559293, null, false, obj);
    }

    public static VideoGestureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static VideoGestureBinding bind(View view, Object obj) {
        return (VideoGestureBinding) bind(obj, view, 2131559293);
    }
}
