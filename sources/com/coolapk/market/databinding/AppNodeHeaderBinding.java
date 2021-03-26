package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.view.node.app.AppNodeViewModel;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.ScaleImageView;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class AppNodeHeaderBinding extends ViewDataBinding {
    public final ActionButton actionButton;
    public final ActionButton actionButton2;
    public final FrameLayout alsoDownloadLayout;
    public final UserAvatarView avatarView;
    public final View backgroundBottomView;
    public final LinearLayout backgroundContainer;
    public final View backgroundPlaceholderView;
    public final View backgroundTopView;
    public final RecyclerView categoryList;
    public final LinearLayout changeLogActionView;
    public final LinearLayout changeLogLayout;
    public final CoolEllipsizeTextView changeLogView;
    public final TextView countView;
    public final TextView couponAllActionView;
    public final LinearLayout couponLayout;
    public final RecyclerView couponList;
    public final MaxWidthFrameLayout coverViewContainer;
    public final LinearLayout developerView;
    public final ActionButton followActionView;
    public final TextView followNumView;
    public final LinearLayout followerLayout;
    public final TextView giftAllActionView;
    public final LinearLayout giftLayout;
    public final RecyclerView giftList;
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
    public final TextView rateNum1;
    public final TextView rateNum2;
    public final TextView rateNum3;
    public final TextView rateNum4;
    public final TextView rateNum5;
    public final RatingBar ratingBar;
    public final ScaleImageView ratingImageView;
    public final ImageView ratingImageView1;
    public final ImageView ratingImageView2;
    public final ImageView ratingImageView3;
    public final ImageView ratingImageView4;
    public final ImageView ratingImageView5;
    public final LinearLayout ratingSubContainer;
    public final LinearLayout ratingViewContainer;
    public final RecyclerView relateAppList;
    public final LinearLayout relativeLayout;
    public final TextView remarkAuthor;
    public final ActionButton scoreActionView;
    public final ActionButton scoreActionView2;
    public final TextView scoreView;
    public final RecyclerView thumbnailList;
    public final Space tripleAvatarSpaceHolder;
    public final TextView wishView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(AppNodeViewModel appNodeViewModel);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected AppNodeHeaderBinding(Object obj, View view, int i, ActionButton actionButton3, ActionButton actionButton4, FrameLayout frameLayout, UserAvatarView userAvatarView, View view2, LinearLayout linearLayout, View view3, View view4, RecyclerView recyclerView, LinearLayout linearLayout2, LinearLayout linearLayout3, CoolEllipsizeTextView coolEllipsizeTextView, TextView textView, TextView textView2, LinearLayout linearLayout4, RecyclerView recyclerView2, MaxWidthFrameLayout maxWidthFrameLayout, LinearLayout linearLayout5, ActionButton actionButton5, TextView textView3, LinearLayout linearLayout6, TextView textView4, LinearLayout linearLayout7, RecyclerView recyclerView3, LinearLayout linearLayout8, ViewPager viewPager, IndicatorView indicatorView2, LinearLayout linearLayout9, CoolEllipsizeTextView coolEllipsizeTextView2, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearAdapterLayout linearAdapterLayout, RoundedImageView roundedImageView, View view5, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, RatingBar ratingBar2, ScaleImageView scaleImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout12, LinearLayout linearLayout13, RecyclerView recyclerView4, LinearLayout linearLayout14, TextView textView10, ActionButton actionButton6, ActionButton actionButton7, TextView textView11, RecyclerView recyclerView5, Space space, TextView textView12) {
        super(obj, view, i);
        this.actionButton = actionButton3;
        this.actionButton2 = actionButton4;
        this.alsoDownloadLayout = frameLayout;
        this.avatarView = userAvatarView;
        this.backgroundBottomView = view2;
        this.backgroundContainer = linearLayout;
        this.backgroundPlaceholderView = view3;
        this.backgroundTopView = view4;
        this.categoryList = recyclerView;
        this.changeLogActionView = linearLayout2;
        this.changeLogLayout = linearLayout3;
        this.changeLogView = coolEllipsizeTextView;
        this.countView = textView;
        this.couponAllActionView = textView2;
        this.couponLayout = linearLayout4;
        this.couponList = recyclerView2;
        this.coverViewContainer = maxWidthFrameLayout;
        this.developerView = linearLayout5;
        this.followActionView = actionButton5;
        this.followNumView = textView3;
        this.followerLayout = linearLayout6;
        this.giftAllActionView = textView4;
        this.giftLayout = linearLayout7;
        this.giftList = recyclerView3;
        this.headerContainer = linearLayout8;
        this.imageViewPager = viewPager;
        this.indicatorView = indicatorView2;
        this.introduceActionView = linearLayout9;
        this.introduceView = coolEllipsizeTextView2;
        this.introductionLayout = linearLayout10;
        this.itemView = linearLayout11;
        this.linearView = linearAdapterLayout;
        this.logoView = roundedImageView;
        this.maskView = view5;
        this.rateNum1 = textView5;
        this.rateNum2 = textView6;
        this.rateNum3 = textView7;
        this.rateNum4 = textView8;
        this.rateNum5 = textView9;
        this.ratingBar = ratingBar2;
        this.ratingImageView = scaleImageView;
        this.ratingImageView1 = imageView;
        this.ratingImageView2 = imageView2;
        this.ratingImageView3 = imageView3;
        this.ratingImageView4 = imageView4;
        this.ratingImageView5 = imageView5;
        this.ratingSubContainer = linearLayout12;
        this.ratingViewContainer = linearLayout13;
        this.relateAppList = recyclerView4;
        this.relativeLayout = linearLayout14;
        this.remarkAuthor = textView10;
        this.scoreActionView = actionButton6;
        this.scoreActionView2 = actionButton7;
        this.scoreView = textView11;
        this.thumbnailList = recyclerView5;
        this.tripleAvatarSpaceHolder = space;
        this.wishView = textView12;
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

    public static AppNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AppNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558465, viewGroup, z, obj);
    }

    public static AppNodeHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AppNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558465, null, false, obj);
    }

    public static AppNodeHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AppNodeHeaderBinding bind(View view, Object obj) {
        return (AppNodeHeaderBinding) bind(obj, view, 2131558465);
    }
}
