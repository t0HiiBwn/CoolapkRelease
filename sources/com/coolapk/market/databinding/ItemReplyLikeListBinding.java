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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemReplyLikeListBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final ImageView imgView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedReply mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView textView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedReply feedReply);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemReplyLikeListBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, ImageView imageView, TextView textView2, TextView textView3, UserAvatarView userAvatarView2, TextView textView4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.contentView = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.imgView = imageView;
        this.infoView = textView2;
        this.textView = textView3;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView4;
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

    public static ItemReplyLikeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyLikeListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReplyLikeListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558904, viewGroup, z, obj);
    }

    public static ItemReplyLikeListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyLikeListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReplyLikeListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558904, null, false, obj);
    }

    public static ItemReplyLikeListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyLikeListBinding bind(View view, Object obj) {
        return (ItemReplyLikeListBinding) bind(obj, view, 2131558904);
    }
}
