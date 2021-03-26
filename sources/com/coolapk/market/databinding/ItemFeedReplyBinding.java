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
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemFeedReplyBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final ImageView commentIcon;
    public final TextView commentNum;
    public final LinearLayout commentView;
    public final FrameLayout extraPartContainer;
    public final ImageView foldedSignView;
    public final TextView infoView;
    public final ImageView likeIcon;
    public final TextView likeNum;
    public final LinearLayout likeView;
    public final LinearAdapterLayout linearAdapterView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedReply mModel;
    public final TextView moreSubReplyView;
    public final TextView replyReplyInfoText;
    public final LinearLayout replyReplyInfoView;
    public final LinearLayout subReplyContainer;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(FeedReply feedReply);

    protected ItemFeedReplyBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, FrameLayout frameLayout, ImageView imageView2, TextView textView2, ImageView imageView3, TextView textView3, LinearLayout linearLayout3, LinearAdapterLayout linearAdapterLayout, TextView textView4, TextView textView5, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView6, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.commentIcon = imageView;
        this.commentNum = textView;
        this.commentView = linearLayout2;
        this.extraPartContainer = frameLayout;
        this.foldedSignView = imageView2;
        this.infoView = textView2;
        this.likeIcon = imageView3;
        this.likeNum = textView3;
        this.likeView = linearLayout3;
        this.linearAdapterView = linearAdapterLayout;
        this.moreSubReplyView = textView4;
        this.replyReplyInfoText = textView5;
        this.replyReplyInfoView = linearLayout4;
        this.subReplyContainer = linearLayout5;
        this.titleView = textView6;
        this.userAvatarView = userAvatarView2;
    }

    public FeedReply getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemFeedReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558723, viewGroup, z, obj);
    }

    public static ItemFeedReplyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558723, null, false, obj);
    }

    public static ItemFeedReplyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedReplyBinding bind(View view, Object obj) {
        return (ItemFeedReplyBinding) bind(obj, view, 2131558723);
    }
}
