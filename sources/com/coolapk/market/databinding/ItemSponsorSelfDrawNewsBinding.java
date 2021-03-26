package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

public abstract class ItemSponsorSelfDrawNewsBinding extends ViewDataBinding {
    public final TextView adTextView;
    public final ImageView closeView;
    public final LinearLayout content3ImageContainer;
    public final ImageView contentImage1View;
    public final ImageView contentImage2View;
    public final ImageView contentImage3View;
    public final ImageView contentImageView;
    public final MaxWidthFrameLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final DividerLineView dividerView;
    public final ImageView extraImageView;
    public final CardView imageCardView;
    public final RelativeLayout itemView;
    public final TextView leftBottomText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mImageUrl;
    @Bindable
    protected Feed mModel;
    public final MediaView mediaView;
    public final NativeAdContainer nativeAdContainer;
    public final CoolEllipsizeTextView titleView;
    public final FrameLayout ttMediaView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setImageUrl(String str);

    public abstract void setModel(Feed feed);

    protected ItemSponsorSelfDrawNewsBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, MaxWidthFrameLayout maxWidthFrameLayout, CoolapkCardView coolapkCardView2, DividerLineView dividerLineView, ImageView imageView6, CardView cardView, RelativeLayout relativeLayout, TextView textView2, MediaView mediaView2, NativeAdContainer nativeAdContainer2, CoolEllipsizeTextView coolEllipsizeTextView, FrameLayout frameLayout) {
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
        this.dividerView = dividerLineView;
        this.extraImageView = imageView6;
        this.imageCardView = cardView;
        this.itemView = relativeLayout;
        this.leftBottomText = textView2;
        this.mediaView = mediaView2;
        this.nativeAdContainer = nativeAdContainer2;
        this.titleView = coolEllipsizeTextView;
        this.ttMediaView = frameLayout;
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

    public static ItemSponsorSelfDrawNewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawNewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSponsorSelfDrawNewsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558947, viewGroup, z, obj);
    }

    public static ItemSponsorSelfDrawNewsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawNewsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSponsorSelfDrawNewsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558947, null, false, obj);
    }

    public static ItemSponsorSelfDrawNewsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSponsorSelfDrawNewsBinding bind(View view, Object obj) {
        return (ItemSponsorSelfDrawNewsBinding) bind(obj, view, 2131558947);
    }
}
