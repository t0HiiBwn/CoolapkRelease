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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.viewholder.EntityItemModel;

public abstract class ItemEntityVideoDetailViewPartBinding extends ViewDataBinding {
    public final LinearLayout bottomContainer;
    public final CoolapkCardView coolapkCardView;
    public final TextView currentTimeView;
    public final ImageView fullScreenView;
    public final ItemAppInsideImageCardBinding includeApp;
    public final FrameLayout itemView;
    public final TextView liveView;
    public final LinearLayout liveViewContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected EntityItemModel mModel;
    public final ImageView moreView;
    public final ImageView navigationView;
    public final ImageView pipView;
    public final ImageView playView;
    public final ProgressBar progressBar;
    public final LinearLayout replayView;
    public final SeekBar seekBar;
    public final TextView titleView;
    public final LinearLayout topContainer;
    public final TextView totalTimeView;
    public final FrameLayout videoContainer;
    public final ImageView volumeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(EntityItemModel entityItemModel);

    protected ItemEntityVideoDetailViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, TextView textView, ImageView imageView, ItemAppInsideImageCardBinding itemAppInsideImageCardBinding, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ProgressBar progressBar2, LinearLayout linearLayout3, SeekBar seekBar2, TextView textView3, LinearLayout linearLayout4, TextView textView4, FrameLayout frameLayout2, ImageView imageView6) {
        super(obj, view, i);
        this.bottomContainer = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.currentTimeView = textView;
        this.fullScreenView = imageView;
        this.includeApp = itemAppInsideImageCardBinding;
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
        this.titleView = textView3;
        this.topContainer = linearLayout4;
        this.totalTimeView = textView4;
        this.videoContainer = frameLayout2;
        this.volumeView = imageView6;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public EntityItemModel getModel() {
        return this.mModel;
    }

    public static ItemEntityVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEntityVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemEntityVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558688, viewGroup, z, obj);
    }

    public static ItemEntityVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEntityVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemEntityVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558688, null, false, obj);
    }

    public static ItemEntityVideoDetailViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEntityVideoDetailViewPartBinding bind(View view, Object obj) {
        return (ItemEntityVideoDetailViewPartBinding) bind(obj, view, 2131558688);
    }
}
