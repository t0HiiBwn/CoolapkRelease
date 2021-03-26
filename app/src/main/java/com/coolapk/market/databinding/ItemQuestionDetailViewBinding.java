package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemQuestionDetailViewBinding extends ViewDataBinding {
    public final LinearLayout bottomView;
    public final LinearLayout cardView;
    public final TextView countView;
    public final TextView followNumView;
    public final TextView followView;
    public final ImageView imageView1;
    public final ImageView imageView2;
    public final ImageView imageView3;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    public final ImageView moreFollowerView;
    public final TextView nameView;
    public final Space nineImageSpaceView;
    public final TextView orderText;
    public final LinearLayout orderView;
    public final Space relativeSpaceView;
    public final TextView textView;
    public final FrameLayout textViewContainer;
    public final TextView timeView;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    protected ItemQuestionDetailViewBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView5, Space space, TextView textView6, LinearLayout linearLayout3, Space space2, TextView textView7, FrameLayout frameLayout, TextView textView8, TextView textView9, UserAvatarView userAvatarView2) {
        super(obj, view, i);
        this.bottomView = linearLayout;
        this.cardView = linearLayout2;
        this.countView = textView2;
        this.followNumView = textView3;
        this.followView = textView4;
        this.imageView1 = imageView;
        this.imageView2 = imageView4;
        this.imageView3 = imageView5;
        this.moreFollowerView = imageView6;
        this.nameView = textView5;
        this.nineImageSpaceView = space;
        this.orderText = textView6;
        this.orderView = linearLayout3;
        this.relativeSpaceView = space2;
        this.textView = textView7;
        this.textViewContainer = frameLayout;
        this.timeView = textView8;
        this.titleView = textView9;
        this.userAvatarView = userAvatarView2;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemQuestionDetailViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemQuestionDetailViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558885, viewGroup, z, obj);
    }

    public static ItemQuestionDetailViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemQuestionDetailViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558885, null, false, obj);
    }

    public static ItemQuestionDetailViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailViewBinding bind(View view, Object obj) {
        return (ItemQuestionDetailViewBinding) bind(obj, view, 2131558885);
    }
}
