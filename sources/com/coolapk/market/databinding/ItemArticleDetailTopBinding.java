package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.ScalingImageView;

public abstract class ItemArticleDetailTopBinding extends ViewDataBinding {
    public final LinearLayout buyView;
    public final View coverViewMask;
    public final Space headerSpaceView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final BadBadRatingBar ratingBar;
    public final TextView ratingTagsView;
    public final TextView scoreView;
    public final LinearLayout scoreViewContainer;
    public final TextView titleView;
    public final ScalingImageView topImageView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemArticleDetailTopBinding(Object obj, View view, int i, LinearLayout linearLayout, View view2, Space space, BadBadRatingBar badBadRatingBar, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, ScalingImageView scalingImageView) {
        super(obj, view, i);
        this.buyView = linearLayout;
        this.coverViewMask = view2;
        this.headerSpaceView = space;
        this.ratingBar = badBadRatingBar;
        this.ratingTagsView = textView;
        this.scoreView = textView2;
        this.scoreViewContainer = linearLayout2;
        this.titleView = textView3;
        this.topImageView = scalingImageView;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemArticleDetailTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleDetailTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558615, viewGroup, z, obj);
    }

    public static ItemArticleDetailTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleDetailTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558615, null, false, obj);
    }

    public static ItemArticleDetailTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleDetailTopBinding bind(View view, Object obj) {
        return (ItemArticleDetailTopBinding) bind(obj, view, 2131558615);
    }
}
