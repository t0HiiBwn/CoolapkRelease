package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.BadBadRatingBar;

public abstract class SubmitFeedGoodsBinding extends ViewDataBinding {
    public final LinearLayout addGoodsView;
    public final CheckBox buyCheckBox;
    public final ImageView closeView;
    public final TextView commentBoardTip1;
    public final TextView commentBoardTip2;
    public final LinearLayout contentView;
    public final View dividerView;
    public final EditText editText;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FeedGoods mFeedGoods;
    @Bindable
    protected FeedUIConfig mUiConfig;
    public final RelativeLayout photoContainer;
    public final BadBadRatingBar ratingBar;
    public final RecyclerView recyclerView;
    public final TextView titleView;
    public final LinearLayout warningView;
    public final CheckBox wishCheckBox;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFeedGoods(FeedGoods feedGoods);

    public abstract void setUiConfig(FeedUIConfig feedUIConfig);

    protected SubmitFeedGoodsBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2, LinearLayout linearLayout2, View view2, EditText editText2, RelativeLayout relativeLayout, BadBadRatingBar badBadRatingBar, RecyclerView recyclerView2, TextView textView3, LinearLayout linearLayout3, CheckBox checkBox2) {
        super(obj, view, i);
        this.addGoodsView = linearLayout;
        this.buyCheckBox = checkBox;
        this.closeView = imageView;
        this.commentBoardTip1 = textView;
        this.commentBoardTip2 = textView2;
        this.contentView = linearLayout2;
        this.dividerView = view2;
        this.editText = editText2;
        this.photoContainer = relativeLayout;
        this.ratingBar = badBadRatingBar;
        this.recyclerView = recyclerView2;
        this.titleView = textView3;
        this.warningView = linearLayout3;
        this.wishCheckBox = checkBox2;
    }

    public FeedUIConfig getUiConfig() {
        return this.mUiConfig;
    }

    public FeedGoods getFeedGoods() {
        return this.mFeedGoods;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static SubmitFeedGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SubmitFeedGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559167, viewGroup, z, obj);
    }

    public static SubmitFeedGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedGoodsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SubmitFeedGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559167, null, false, obj);
    }

    public static SubmitFeedGoodsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SubmitFeedGoodsBinding bind(View view, Object obj) {
        return (SubmitFeedGoodsBinding) bind(obj, view, 2131559167);
    }
}
