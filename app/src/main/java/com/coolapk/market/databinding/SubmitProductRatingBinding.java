package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.FeedUIConfig;

public abstract class SubmitProductRatingBinding extends ViewDataBinding {
    public final TextView commentBoardTip1;
    public final TextView commentBoardTip2;
    public final AppCompatEditText editText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final RelativeLayout photoContainer;
    public final RatingBar ratingBar;
    public final RecyclerView recyclerView;
    public final LinearLayout relativeView;
    public final TextView scoreTextView;
    public final Space spaceView;
    public final TextView toArticleView;
    public final LinearLayout warningView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitProductRatingBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatEditText appCompatEditText, RelativeLayout relativeLayout, RatingBar ratingBar2, RecyclerView recyclerView2, LinearLayout linearLayout, TextView textView3, Space space, TextView textView4, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.commentBoardTip1 = textView;
        this.commentBoardTip2 = textView2;
        this.editText = appCompatEditText;
        this.photoContainer = relativeLayout;
        this.ratingBar = ratingBar2;
        this.recyclerView = recyclerView2;
        this.relativeView = linearLayout;
        this.scoreTextView = textView3;
        this.spaceView = space;
        this.toArticleView = textView4;
        this.warningView = linearLayout2;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitProductRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitProductRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559167, viewGroup, z, obj);
    }

    public static SubmitProductRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitProductRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559167, null, false, obj);
    }

    public static SubmitProductRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitProductRatingBinding bind(View view, Object obj) {
        return (SubmitProductRatingBinding) bind(obj, view, 2131559167);
    }
}
