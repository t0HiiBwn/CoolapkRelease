package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemLiveVideoViewPartBinding extends ViewDataBinding {
    public final LinearLayout bottomContainer;
    public final TextView currentTimeView;
    public final FrameLayout danmakuFrame;
    public final ImageView danmakuOpenView;
    public final ImageView danmakuPencilView;
    public final EditText danmakuSendEdit;
    public final LinearLayout danmakuSendLayout;
    public final ProgressBar danmakuSendProgressView;
    public final ImageView danmakuSendView;
    public final ImageView fullScreenView;
    public final ImageView imageCover;
    public final TextView infoView;
    public final MaxWidthFrameLayout itemView;
    public final TextView lineTextView;
    public final TextView liveTimeView;
    public final TextView liveTypeView;
    public final TextView liveTypeView2;
    public final LinearLayout liveViewContainer;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView moreView;
    public final ImageView navigationView;
    public final TextView peopleNumView;
    public final ImageView playView;
    public final ImageView refreshView;
    public final SeekBar seekBar;
    public final FrameLayout selectLineView;
    public final ImageView shareView;
    public final TextView subscribeView;
    public final TextView titleView;
    public final LinearLayout topContainer;
    public final TextView totalTimeView;
    public final LinearLayout upperCoverBottomView;
    public final RelativeLayout upperCoverSubscribeView;
    public final FrameLayout upperCoverView;
    public final FrameLayout videoPlayer;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemLiveVideoViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, EditText editText, LinearLayout linearLayout2, ProgressBar progressBar, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView2, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout3, ImageView imageView6, ImageView imageView7, TextView textView7, ImageView imageView8, ImageView imageView9, SeekBar seekBar2, FrameLayout frameLayout2, ImageView imageView10, TextView textView8, TextView textView9, LinearLayout linearLayout4, TextView textView10, LinearLayout linearLayout5, RelativeLayout relativeLayout, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        super(obj, view, i);
        this.bottomContainer = linearLayout;
        this.currentTimeView = textView;
        this.danmakuFrame = frameLayout;
        this.danmakuOpenView = imageView;
        this.danmakuPencilView = imageView2;
        this.danmakuSendEdit = editText;
        this.danmakuSendLayout = linearLayout2;
        this.danmakuSendProgressView = progressBar;
        this.danmakuSendView = imageView3;
        this.fullScreenView = imageView4;
        this.imageCover = imageView5;
        this.infoView = textView2;
        this.itemView = maxWidthFrameLayout;
        this.lineTextView = textView3;
        this.liveTimeView = textView4;
        this.liveTypeView = textView5;
        this.liveTypeView2 = textView6;
        this.liveViewContainer = linearLayout3;
        this.moreView = imageView6;
        this.navigationView = imageView7;
        this.peopleNumView = textView7;
        this.playView = imageView8;
        this.refreshView = imageView9;
        this.seekBar = seekBar2;
        this.selectLineView = frameLayout2;
        this.shareView = imageView10;
        this.subscribeView = textView8;
        this.titleView = textView9;
        this.topContainer = linearLayout4;
        this.totalTimeView = textView10;
        this.upperCoverBottomView = linearLayout5;
        this.upperCoverSubscribeView = relativeLayout;
        this.upperCoverView = frameLayout3;
        this.videoPlayer = frameLayout4;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemLiveVideoViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveVideoViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveVideoViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558810, viewGroup, z, obj);
    }

    public static ItemLiveVideoViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveVideoViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveVideoViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558810, null, false, obj);
    }

    public static ItemLiveVideoViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveVideoViewPartBinding bind(View view, Object obj) {
        return (ItemLiveVideoViewPartBinding) bind(obj, view, 2131558810);
    }
}
