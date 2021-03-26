package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.goodsList.FunThingsViewModel;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ItemGoodGoodsListHeaderBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final UserAvatarView avatarView;
    public final View backgroundBottomView;
    public final LinearLayout backgroundContainer;
    public final View backgroundPlaceholderView;
    public final View backgroundTopView;
    public final LinearLayout contentView;
    public final ImageView coverView;
    public final MaxWidthFrameLayout coverViewContainer;
    public final TextView infoView;
    public final LinearLayout itemView;
    public final PreventAutoScrollRecyclerView listItem;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected FunThingsViewModel mViewModel;
    public final View maskView;
    public final View spaceHolder;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setViewModel(FunThingsViewModel funThingsViewModel);

    protected ItemGoodGoodsListHeaderBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, UserAvatarView userAvatarView, View view2, LinearLayout linearLayout, View view3, View view4, LinearLayout linearLayout2, ImageView imageView, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView, LinearLayout linearLayout3, PreventAutoScrollRecyclerView preventAutoScrollRecyclerView, View view5, View view6) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.avatarView = userAvatarView;
        this.backgroundBottomView = view2;
        this.backgroundContainer = linearLayout;
        this.backgroundPlaceholderView = view3;
        this.backgroundTopView = view4;
        this.contentView = linearLayout2;
        this.coverView = imageView;
        this.coverViewContainer = maxWidthFrameLayout;
        this.infoView = textView;
        this.itemView = linearLayout3;
        this.listItem = preventAutoScrollRecyclerView;
        this.maskView = view5;
        this.spaceHolder = view6;
    }

    public FunThingsViewModel getViewModel() {
        return this.mViewModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemGoodGoodsListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoodGoodsListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558754, viewGroup, z, obj);
    }

    public static ItemGoodGoodsListHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsListHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoodGoodsListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558754, null, false, obj);
    }

    public static ItemGoodGoodsListHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemGoodGoodsListHeaderBinding bind(View view, Object obj) {
        return (ItemGoodGoodsListHeaderBinding) bind(obj, view, 2131558754);
    }
}
