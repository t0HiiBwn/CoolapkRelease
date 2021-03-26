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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.LinearAdapterLayout;

public abstract class ItemFeedBaseBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final FrameLayout feedContentView;
    public final LinearAdapterLayout feedReplyContainer;
    public final ImageView likeTextIndicator;
    public final TextView likeThumbView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected String mSingleImg;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView moreCommentView;
    public final LinearLayout replayLayout;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setSingleImg(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemFeedBaseBinding(Object obj, View view, int i, LinearLayout linearLayout, FrameLayout frameLayout, LinearAdapterLayout linearAdapterLayout, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.feedContentView = frameLayout;
        this.feedReplyContainer = linearAdapterLayout;
        this.likeTextIndicator = imageView;
        this.likeThumbView = textView;
        this.moreCommentView = textView2;
        this.replayLayout = linearLayout2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getSingleImg() {
        return this.mSingleImg;
    }

    public static ItemFeedBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedBaseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558692, viewGroup, z, obj);
    }

    public static ItemFeedBaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBaseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedBaseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558692, null, false, obj);
    }

    public static ItemFeedBaseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedBaseBinding bind(View view, Object obj) {
        return (ItemFeedBaseBinding) bind(obj, view, 2131558692);
    }
}
