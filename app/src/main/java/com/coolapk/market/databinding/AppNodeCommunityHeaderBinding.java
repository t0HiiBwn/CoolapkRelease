package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class AppNodeCommunityHeaderBinding extends ViewDataBinding {
    public final FrameLayout alsoDownloadLayout;
    public final View backgroundBottomView;
    public final LinearLayout backgroundContainer;
    public final View backgroundPlaceholderView;
    public final View backgroundTopView;
    public final MaxWidthFrameLayout coverViewContainer;
    public final ActionButton followActionView;
    public final TextView followNumView;
    public final LinearLayout followerLayout;
    public final LinearLayout headerContainer;
    public final ViewPager imageViewPager;
    public final IndicatorView indicatorView;
    public final LinearLayout introduceActionView;
    public final CoolEllipsizeTextView introduceView;
    public final LinearLayout introductionLayout;
    public final LinearLayout itemView;
    public final LinearAdapterLayout linearView;
    public final RoundedImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected AppNodeViewModel mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final View maskView;
    public final TextView remarkAuthor;
    public final Space tripleAvatarSpaceHolder;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(AppNodeViewModel appNodeViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected AppNodeCommunityHeaderBinding(Object obj, View view, int i, FrameLayout frameLayout, View view2, LinearLayout linearLayout, View view3, View view4, MaxWidthFrameLayout maxWidthFrameLayout, ActionButton actionButton, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, ViewPager viewPager, IndicatorView indicatorView2, LinearLayout linearLayout4, CoolEllipsizeTextView coolEllipsizeTextView, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearAdapterLayout linearAdapterLayout, RoundedImageView roundedImageView, View view5, TextView textView2, Space space) {
        super(obj, view, i);
        this.alsoDownloadLayout = frameLayout;
        this.backgroundBottomView = view2;
        this.backgroundContainer = linearLayout;
        this.backgroundPlaceholderView = view3;
        this.backgroundTopView = view4;
        this.coverViewContainer = maxWidthFrameLayout;
        this.followActionView = actionButton;
        this.followNumView = textView;
        this.followerLayout = linearLayout2;
        this.headerContainer = linearLayout3;
        this.imageViewPager = viewPager;
        this.indicatorView = indicatorView2;
        this.introduceActionView = linearLayout4;
        this.introduceView = coolEllipsizeTextView;
        this.introductionLayout = linearLayout5;
        this.itemView = linearLayout6;
        this.linearView = linearAdapterLayout;
        this.logoView = roundedImageView;
        this.maskView = view5;
        this.remarkAuthor = textView2;
        this.tripleAvatarSpaceHolder = space;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public AppNodeViewModel getModel() {
        return this.mModel;
    }

    public static AppNodeCommunityHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeCommunityHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppNodeCommunityHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558463, viewGroup, z, obj);
    }

    public static AppNodeCommunityHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeCommunityHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppNodeCommunityHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558463, null, false, obj);
    }

    public static AppNodeCommunityHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeCommunityHeaderBinding bind(View view, Object obj) {
        return (AppNodeCommunityHeaderBinding) bind(obj, view, 2131558463);
    }
}
