package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.FeedActionView2;

public abstract class ItemGoodsListFeedBinding extends ViewDataBinding {
    public final LinearLayout cardLayout;
    public final CoolapkCardView coolapkCardView;
    public final AspectRatioImageView coverView;
    public final FeedActionView2 feedActionView;
    public final CoolapkCardView goodsListCardView;
    public final Space headerSpaceView;
    public final FrameLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mFollowNum;
    @Bindable
    protected Feed mModel;
    @Bindable
    protected boolean mShowFromView;
    @Bindable
    protected String mVerifyLabel;
    @Bindable
    protected String mVerifyStatusIcon;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setFollowNum(String str);

    public abstract void setModel(Feed feed);

    public abstract void setShowFromView(boolean z);

    public abstract void setVerifyLabel(String str);

    public abstract void setVerifyStatusIcon(String str);

    protected ItemGoodsListFeedBinding(Object obj, View view, int i, LinearLayout linearLayout, CoolapkCardView coolapkCardView2, AspectRatioImageView aspectRatioImageView, FeedActionView2 feedActionView2, CoolapkCardView coolapkCardView3, Space space, FrameLayout frameLayout) {
        super(obj, view, i);
        this.cardLayout = linearLayout;
        this.coolapkCardView = coolapkCardView2;
        this.coverView = aspectRatioImageView;
        this.feedActionView = feedActionView2;
        this.goodsListCardView = coolapkCardView3;
        this.headerSpaceView = space;
        this.itemView = frameLayout;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getVerifyLabel() {
        return this.mVerifyLabel;
    }

    public String getVerifyStatusIcon() {
        return this.mVerifyStatusIcon;
    }

    public boolean getShowFromView() {
        return this.mShowFromView;
    }

    public String getFollowNum() {
        return this.mFollowNum;
    }

    public static ItemGoodsListFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListFeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodsListFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558767, viewGroup, z, obj);
    }

    public static ItemGoodsListFeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListFeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodsListFeedBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558767, null, false, obj);
    }

    public static ItemGoodsListFeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodsListFeedBinding bind(View view, Object obj) {
        return (ItemGoodsListFeedBinding) bind(obj, view, 2131558767);
    }
}
