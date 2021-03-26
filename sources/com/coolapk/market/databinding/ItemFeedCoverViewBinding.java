package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;

public abstract class ItemFeedCoverViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final DividerLineView dividerView;
    public final ImageView extraImageView;
    public final FeedActionView2 feedActionView;
    public final ForegroundTextView foregroundTextView;
    public final Space headerSpaceView;
    public final Space hotReplySpaceView;
    public final CardView imageCardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mImageUrl;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final Space ratingDataSpaceView;
    public final Space ratingSpaceView;
    public final Space relativeSpaceView;
    public final CoolEllipsizeTextView textView;
    public final CoolEllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setImageUrl(String str);

    public abstract void setModel(Feed feed);

    protected ItemFeedCoverViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, DividerLineView dividerLineView, ImageView imageView, FeedActionView2 feedActionView2, ForegroundTextView foregroundTextView2, Space space, Space space2, CardView cardView2, Space space3, Space space4, Space space5, Space space6, CoolEllipsizeTextView coolEllipsizeTextView, CoolEllipsizeTextView coolEllipsizeTextView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.dividerView = dividerLineView;
        this.extraImageView = imageView;
        this.feedActionView = feedActionView2;
        this.foregroundTextView = foregroundTextView2;
        this.headerSpaceView = space;
        this.hotReplySpaceView = space2;
        this.imageCardView = cardView2;
        this.nineImageSpaceView = space3;
        this.ratingDataSpaceView = space4;
        this.ratingSpaceView = space5;
        this.relativeSpaceView = space6;
        this.textView = coolEllipsizeTextView;
        this.titleView = coolEllipsizeTextView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public static ItemFeedCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoverViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558702, viewGroup, z, obj);
    }

    public static ItemFeedCoverViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoverViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedCoverViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558702, null, false, obj);
    }

    public static ItemFeedCoverViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedCoverViewBinding bind(View view, Object obj) {
        return (ItemFeedCoverViewBinding) bind(obj, view, 2131558702);
    }
}
