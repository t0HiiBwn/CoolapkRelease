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
import com.coolapk.market.widget.view.TimeTextView;

public abstract class ItemVideoDetailViewPartBinding extends ViewDataBinding {
    public final LinearLayout bottomContainer;
    public final FrameLayout commentContainer;
    public final TimeTextView currentTimeView;
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
    public final TextView titleView;
    public final LinearLayout topContainer;
    public final TimeTextView totalTimeView;
    public final FrameLayout videoContainer;
    public final FrameLayout videoTopView;
    public final ImageView volumeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemVideoDetailViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, TimeTextView timeTextView, ImageView imageView, FrameLayout frameLayout2, TextView textView, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ProgressBar progressBar2, LinearLayout linearLayout3, SeekBar seekBar2, TextView textView2, LinearLayout linearLayout4, TimeTextView timeTextView2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView6) {
        super(obj, view, i);
        this.bottomContainer = linearLayout;
        this.commentContainer = frameLayout;
        this.currentTimeView = timeTextView;
        this.fullScreenView = imageView;
        this.itemView = frameLayout2;
        this.liveView = textView;
        this.liveViewContainer = linearLayout2;
        this.moreView = imageView2;
        this.navigationView = imageView3;
        this.pipView = imageView4;
        this.playView = imageView5;
        this.progressBar = progressBar2;
        this.replayView = linearLayout3;
        this.seekBar = seekBar2;
        this.titleView = textView2;
        this.topContainer = linearLayout4;
        this.totalTimeView = timeTextView2;
        this.videoContainer = frameLayout3;
        this.videoTopView = frameLayout4;
        this.volumeView = imageView6;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558991, viewGroup, z, obj);
    }

    public static ItemVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558991, null, false, obj);
    }

    public static ItemVideoDetailViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemVideoDetailViewPartBinding bind(View view, Object obj) {
        return (ItemVideoDetailViewPartBinding) bind(obj, view, 2131558991);
    }
}
