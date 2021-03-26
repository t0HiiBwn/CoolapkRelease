package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;

public abstract class ItemFeedNewsViewBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final CoolapkCardView coolapkCardView;
    public final DividerLineView dividerView;
    public final ImageView extraImageView;
    public final ForegroundTextView foregroundTextView;
    public final CardView imageCardView;
    public final TextView leftBottomText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mImageUrl;
    @Bindable
    protected Feed mModel;
    public final Space nineImageSpaceView;
    public final CoolEllipsizeTextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setImageUrl(String str);

    public abstract void setModel(Feed feed);

    protected ItemFeedNewsViewBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, DividerLineView dividerLineView, ImageView imageView, ForegroundTextView foregroundTextView2, CardView cardView2, TextView textView, Space space, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.dividerView = dividerLineView;
        this.extraImageView = imageView;
        this.foregroundTextView = foregroundTextView2;
        this.imageCardView = cardView2;
        this.leftBottomText = textView;
        this.nineImageSpaceView = space;
        this.titleView = coolEllipsizeTextView;
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

    public static ItemFeedNewsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedNewsViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558717, viewGroup, z, obj);
    }

    public static ItemFeedNewsViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedNewsViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558717, null, false, obj);
    }

    public static ItemFeedNewsViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedNewsViewBinding bind(View view, Object obj) {
        return (ItemFeedNewsViewBinding) bind(obj, view, 2131558717);
    }
}
