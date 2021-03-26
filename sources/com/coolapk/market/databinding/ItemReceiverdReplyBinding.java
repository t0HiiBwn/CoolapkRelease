package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.view.user.UserReceivedReplyListFragment;
import com.coolapk.market.widget.SquareImageView;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemReceiverdReplyBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final SquareImageView imageView;
    public final TextView infoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedReply mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder mViewHolder;
    public final TextView textView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedReply feedReply);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewHolder(UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder receivedFeedReplyViewHolder);

    protected ItemReceiverdReplyBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView, TextView textView2, TextView textView3, UserAvatarView userAvatarView2, TextView textView4) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.contentView = linearLayout2;
        this.imageView = squareImageView;
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

    public UserReceivedReplyListFragment.ReceivedFeedReplyViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemReceiverdReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReceiverdReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReceiverdReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558890, viewGroup, z, obj);
    }

    public static ItemReceiverdReplyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReceiverdReplyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReceiverdReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558890, null, false, obj);
    }

    public static ItemReceiverdReplyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReceiverdReplyBinding bind(View view, Object obj) {
        return (ItemReceiverdReplyBinding) bind(obj, view, 2131558890);
    }
}
