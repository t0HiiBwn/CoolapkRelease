package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public abstract class ItemFeedExtraTypePartBinding extends ViewDataBinding {
    public final TextView actionButton;
    public final ActionButtonFrameLayout actionContainer;
    public final ImageView extendIcon;
    public final LinearLayout extendLayout;
    public final TextView extendSubtitle;
    public final TextView extendTitle;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mGifImage;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setGifImage(String str);

    public abstract void setModel(Feed feed);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedExtraTypePartBinding(Object obj, View view, int i, TextView textView, ActionButtonFrameLayout actionButtonFrameLayout, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionButton = textView;
        this.actionContainer = actionButtonFrameLayout;
        this.extendIcon = imageView;
        this.extendLayout = linearLayout;
        this.extendSubtitle = textView2;
        this.extendTitle = textView3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public String getGifImage() {
        return this.mGifImage;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public String getSingleImg() {
        return this.mSingleImg;
    }

    public static ItemFeedExtraTypePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedExtraTypePartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedExtraTypePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558705, viewGroup, z, obj);
    }

    public static ItemFeedExtraTypePartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedExtraTypePartBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedExtraTypePartBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558705, null, false, obj);
    }

    public static ItemFeedExtraTypePartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedExtraTypePartBinding bind(View view, Object obj) {
        return (ItemFeedExtraTypePartBinding) bind(obj, view, 2131558705);
    }
}
