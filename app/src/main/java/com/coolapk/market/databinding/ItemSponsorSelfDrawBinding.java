package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

public abstract class ItemSponsorSelfDrawBinding extends ViewDataBinding {
    public final TextView adTextView;
    public final ImageView closeView;
    public final LinearLayout content3ImageContainer;
    public final ImageView contentImage1View;
    public final ImageView contentImage2View;
    public final ImageView contentImage3View;
    public final ImageView contentImageView;
    public final MaxWidthFrameLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final TextView descriptionView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final MediaView mediaView;
    public final NativeAdContainer nativeAdContainer;
    public final ItemRelativeChildBinding relativeView;
    public final ImageView topImageView;
    public final TextView topTextView;
    public final FrameLayout ttMediaView;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemSponsorSelfDrawBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, MaxWidthFrameLayout maxWidthFrameLayout, CoolapkCardView coolapkCardView2, TextView textView2, LinearLayout linearLayout2, MediaView mediaView2, NativeAdContainer nativeAdContainer2, ItemRelativeChildBinding itemRelativeChildBinding, ImageView imageView6, TextView textView3, FrameLayout frameLayout) {
        super(obj, view, i);
        this.adTextView = textView;
        this.closeView = imageView;
        this.content3ImageContainer = linearLayout;
        this.contentImage1View = imageView2;
        this.contentImage2View = imageView3;
        this.contentImage3View = imageView4;
        this.contentImageView = imageView5;
        this.contentView = maxWidthFrameLayout;
        this.coolapkCardView = coolapkCardView2;
        this.descriptionView = textView2;
        this.itemView = linearLayout2;
        this.mediaView = mediaView2;
        this.nativeAdContainer = nativeAdContainer2;
        this.relativeView = itemRelativeChildBinding;
        this.topImageView = imageView6;
        this.topTextView = textView3;
        this.ttMediaView = frameLayout;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemSponsorSelfDrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSponsorSelfDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558939, viewGroup, z, obj);
    }

    public static ItemSponsorSelfDrawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSponsorSelfDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558939, null, false, obj);
    }

    public static ItemSponsorSelfDrawBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawBinding bind(View view, Object obj) {
        return (ItemSponsorSelfDrawBinding) bind(obj, view, 2131558939);
    }
}
