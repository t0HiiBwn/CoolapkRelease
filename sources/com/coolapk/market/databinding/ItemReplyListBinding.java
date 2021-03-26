package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.viewholder.UserReplyViewHolder;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemReplyListBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final LinearLayout cardView;
    public final LinearLayout contentView;
    public final CoolapkCardView coolapkCardView;
    public final FrameLayout extraPartContainer;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected boolean mInLikeList;
    @Bindable
    protected FeedReply mModel;
    @Bindable
    protected String mTimeDescription;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    @Bindable
    protected UserReplyViewHolder mViewHolder;
    public final TextView textView;
    public final TextView textview1;
    public final TextView textview2;
    public final TextView textview3;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;
    public final TextView userNameView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setInLikeList(boolean z);

    public abstract void setModel(FeedReply feedReply);

    public abstract void setTimeDescription(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    public abstract void setViewHolder(UserReplyViewHolder userReplyViewHolder);

    protected ItemReplyListBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, LinearLayout linearLayout, LinearLayout linearLayout2, CoolapkCardView coolapkCardView2, FrameLayout frameLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, UserAvatarView userAvatarView2, TextView textView7) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.cardView = linearLayout;
        this.contentView = linearLayout2;
        this.coolapkCardView = coolapkCardView2;
        this.extraPartContainer = frameLayout;
        this.textView = textView2;
        this.textview1 = textView3;
        this.textview2 = textView4;
        this.textview3 = textView5;
        this.titleView = textView6;
        this.userAvatarView = userAvatarView2;
        this.userNameView = textView7;
    }

    public FeedReply getModel() {
        return this.mModel;
    }

    public boolean getInLikeList() {
        return this.mInLikeList;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public UserReplyViewHolder getViewHolder() {
        return this.mViewHolder;
    }

    public String getTimeDescription() {
        return this.mTimeDescription;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558905, viewGroup, z, obj);
    }

    public static ItemReplyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemReplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558905, null, false, obj);
    }

    public static ItemReplyListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplyListBinding bind(View view, Object obj) {
        return (ItemReplyListBinding) bind(obj, view, 2131558905);
    }
}
