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
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.UserAvatarView;

public abstract class ItemArticleAnswerPreviewTopBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout cardView;
    public final TextView countView;
    public final View dividerView;
    public final TextView fromWhereView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView nameView;
    public final TextView otherView;
    public final TextView timeView;
    public final LinearLayout titleContainer;
    public final TextView titleView;
    public final UserAvatarView userAvatarView;
    public final LinearLayout userViewContainer;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemArticleAnswerPreviewTopBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, View view2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout2, TextView textView7, UserAvatarView userAvatarView2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.actionView = textView;
        this.cardView = linearLayout;
        this.countView = textView2;
        this.dividerView = view2;
        this.fromWhereView = textView3;
        this.nameView = textView4;
        this.otherView = textView5;
        this.timeView = textView6;
        this.titleContainer = linearLayout2;
        this.titleView = textView7;
        this.userAvatarView = userAvatarView2;
        this.userViewContainer = linearLayout3;
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

    public static ItemArticleAnswerPreviewTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleAnswerPreviewTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemArticleAnswerPreviewTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558612, viewGroup, z, obj);
    }

    public static ItemArticleAnswerPreviewTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleAnswerPreviewTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemArticleAnswerPreviewTopBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558612, null, false, obj);
    }

    public static ItemArticleAnswerPreviewTopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemArticleAnswerPreviewTopBinding bind(View view, Object obj) {
        return (ItemArticleAnswerPreviewTopBinding) bind(obj, view, 2131558612);
    }
}
