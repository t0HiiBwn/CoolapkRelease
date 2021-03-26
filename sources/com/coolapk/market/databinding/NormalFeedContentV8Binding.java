package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.FeedUIConfig;

public abstract class NormalFeedContentV8Binding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final TextView commentBoardTip1;
    public final TextView commentBoardTip2;
    public final EditText editText;
    public final EditText editTitle;
    public final TextView editTitleFreeNum;
    public final CardView extraView;
    public final FrameLayout extraViewContainer;
    public final LinearLayout forwardView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final RelativeLayout photoContainer;
    public final RatingBar ratingBar;
    public final TextView ratingTextView;
    public final RecyclerView recyclerView;
    public final LinearLayout relativeView;
    public final ImageView removeExtraEntityView;
    public final ImageView removeExtraView;
    public final Space spaceView;
    public final Space videoPlayerSpaceView;
    public final LinearLayout warningView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected NormalFeedContentV8Binding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, TextView textView, TextView textView2, EditText editText2, EditText editText3, TextView textView3, CardView cardView, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, RatingBar ratingBar2, TextView textView4, RecyclerView recyclerView2, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, Space space, Space space2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.commentBoardTip1 = textView;
        this.commentBoardTip2 = textView2;
        this.editText = editText2;
        this.editTitle = editText3;
        this.editTitleFreeNum = textView3;
        this.extraView = cardView;
        this.extraViewContainer = frameLayout;
        this.forwardView = linearLayout;
        this.logoView = imageView;
        this.photoContainer = relativeLayout;
        this.ratingBar = ratingBar2;
        this.ratingTextView = textView4;
        this.recyclerView = recyclerView2;
        this.relativeView = linearLayout2;
        this.removeExtraEntityView = imageView2;
        this.removeExtraView = imageView3;
        this.spaceView = space;
        this.videoPlayerSpaceView = space2;
        this.warningView = linearLayout3;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static NormalFeedContentV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NormalFeedContentV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NormalFeedContentV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559058, viewGroup, z, obj);
    }

    public static NormalFeedContentV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NormalFeedContentV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NormalFeedContentV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559058, null, false, obj);
    }

    public static NormalFeedContentV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NormalFeedContentV8Binding bind(View view, Object obj) {
        return (NormalFeedContentV8Binding) bind(obj, view, 2131559058);
    }
}
