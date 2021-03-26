package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Feed;

public abstract class ItemQuestionDetailBottomBinding extends ViewDataBinding {
    public final LinearLayout actionViewContainer;
    public final ImageView addAnswerImage;
    public final ProgressBar addAnswerProgress;
    public final TextView addAnswerText;
    public final LinearLayout addAnswerView;
    public final TextView followTextView;
    public final LinearLayout followView;
    public final LinearLayout inviteFriendView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Feed feed);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemQuestionDetailBottomBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, ProgressBar progressBar, TextView textView, LinearLayout linearLayout2, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.actionViewContainer = linearLayout;
        this.addAnswerImage = imageView;
        this.addAnswerProgress = progressBar;
        this.addAnswerText = textView;
        this.addAnswerView = linearLayout2;
        this.followTextView = textView2;
        this.followView = linearLayout3;
        this.inviteFriendView = linearLayout4;
        this.rootView = linearLayout5;
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

    public static ItemQuestionDetailBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailBottomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemQuestionDetailBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558891, viewGroup, z, obj);
    }

    public static ItemQuestionDetailBottomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailBottomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemQuestionDetailBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558891, null, false, obj);
    }

    public static ItemQuestionDetailBottomBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemQuestionDetailBottomBinding bind(View view, Object obj) {
        return (ItemQuestionDetailBottomBinding) bind(obj, view, 2131558891);
    }
}
