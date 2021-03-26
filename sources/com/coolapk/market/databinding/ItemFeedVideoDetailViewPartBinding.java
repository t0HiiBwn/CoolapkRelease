package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.TimeTextView;

public abstract class ItemFeedVideoDetailViewPartBinding extends ViewDataBinding {
    public final LinearLayout actionContainer;
    public final LinearLayout bottomContainer;
    public final FrameLayout commentContainer;
    public final TextView commentText;
    public final LinearLayout commentView;
    public final TimeTextView currentTimeView;
    public final ImageView favoriteImageView;
    public final TextView favoriteTextView;
    public final LinearLayout favoriteView;
    public final RelativeLayout feedContentView;
    public final TextView feedTimeView;
    public final ImageView fullScreenView;
    public final FrameLayout itemView;
    public final ImageView likeImageView;
    public final TextView likeText;
    public final LinearLayout likeView;
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
    public final TextView shareText;
    public final LinearLayout shareView;
    public final TextView textView;
    public final TextView titleView;
    public final LinearLayout topContainer;
    public final TimeTextView totalTimeView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;
    public final FrameLayout videoContainer;
    public final FrameLayout videoTopView;
    public final ImageView volumeView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemFeedVideoDetailViewPartBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView2, LinearLayout linearLayout3, TimeTextView timeTextView, ImageView imageView, TextView textView3, LinearLayout linearLayout4, RelativeLayout relativeLayout, TextView textView4, ImageView imageView2, FrameLayout frameLayout2, ImageView imageView3, TextView textView5, LinearLayout linearLayout5, TextView textView6, LinearLayout linearLayout6, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ProgressBar progressBar2, LinearLayout linearLayout7, SeekBar seekBar2, TextView textView7, LinearLayout linearLayout8, TextView textView8, TextView textView9, LinearLayout linearLayout9, TimeTextView timeTextView2, UserAvatarView userAvatarView2, TextView textView10, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView8) {
        super(obj, view, i);
        this.actionContainer = linearLayout;
        this.bottomContainer = linearLayout2;
        this.commentContainer = frameLayout;
        this.commentText = textView2;
        this.commentView = linearLayout3;
        this.currentTimeView = timeTextView;
        this.favoriteImageView = imageView;
        this.favoriteTextView = textView3;
        this.favoriteView = linearLayout4;
        this.feedContentView = relativeLayout;
        this.feedTimeView = textView4;
        this.fullScreenView = imageView2;
        this.itemView = frameLayout2;
        this.likeImageView = imageView3;
        this.likeText = textView5;
        this.likeView = linearLayout5;
        this.liveView = textView6;
        this.liveViewContainer = linearLayout6;
        this.moreView = imageView4;
        this.navigationView = imageView5;
        this.pipView = imageView6;
        this.playView = imageView7;
        this.progressBar = progressBar2;
        this.replayView = linearLayout7;
        this.seekBar = seekBar2;
        this.shareText = textView7;
        this.shareView = linearLayout8;
        this.textView = textView8;
        this.titleView = textView9;
        this.topContainer = linearLayout9;
        this.totalTimeView = timeTextView2;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView10;
        this.videoContainer = frameLayout3;
        this.videoTopView = frameLayout4;
        this.volumeView = imageView8;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558741, viewGroup, z, obj);
    }

    public static ItemFeedVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVideoDetailViewPartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVideoDetailViewPartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558741, null, false, obj);
    }

    public static ItemFeedVideoDetailViewPartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVideoDetailViewPartBinding bind(View view, Object obj) {
        return (ItemFeedVideoDetailViewPartBinding) bind(obj, view, 2131558741);
    }
}
