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
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemAlbumFeedBaseBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedReply mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedReply feedReply);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemAlbumFeedBaseBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.commentIcon = imageView;
        this.commentNum = textView;
        this.commentView = linearLayout2;
        this.infoView = textView2;
        this.titleView = textView3;
        this.userAvatarView = userAvatarView2;
    }

    public FeedReply getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAlbumFeedBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumFeedBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAlbumFeedBaseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558583, viewGroup, z, obj);
    }

    public static ItemAlbumFeedBaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumFeedBaseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAlbumFeedBaseBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558583, null, false, obj);
    }

    public static ItemAlbumFeedBaseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAlbumFeedBaseBinding bind(View view, Object obj) {
        return (ItemAlbumFeedBaseBinding) bind(obj, view, 2131558583);
    }
}
