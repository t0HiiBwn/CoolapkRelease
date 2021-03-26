package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.ScaleImageView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class ProductNodeHeaderBinding extends ViewDataBinding {
    public final TextView actionView;
    public final View backgroundBottomView;
    public final LinearLayout backgroundContainer;
    public final Space backgroundPlaceholderView;
    public final View backgroundTopView;
    public final TextView buyCountView;
    public final TextView buySubView;
    public final TextView countView;
    public final MaxWidthFrameLayout coverViewContainer;
    public final TextView descriptionView;
    public final LinearLayout fetchCouponView;
    public final TextView followNumView;
    public final LinearLayout headerContainer;
    public final HorizontalScrollView horizontalScrollView;
    public final TextView hotNumView;
    public final ViewPager imageViewPager;
    public final IndicatorView indicatorView;
    public final LinearLayout itemView;
    public final LinearAdapterLayout linearView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final View maskView;
    public final LinearLayout moreFollowerView;
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
    public final LinearLayout ratingOwnerContainer;
    public final LinearLayout ratingSubContainer;
    public final TextView ratingView;
    public final LinearLayout ratingViewContainer;
    public final TextView scoreView;
    public final TableLayout tableView;
    public final LinearLayout tagsContainer;
    public final Space tripleAvatarSpaceHolder;
    public final TextView viewAllView;
    public final TextView viewOwnerView;
    public final TextView wishCountView;
    public final TextView wishView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Product product);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ProductNodeHeaderBinding(Object obj, View view, int i, TextView textView, View view2, LinearLayout linearLayout, Space space, View view3, TextView textView2, TextView textView3, TextView textView4, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView5, LinearLayout linearLayout2, TextView textView6, LinearLayout linearLayout3, HorizontalScrollView horizontalScrollView2, TextView textView7, ViewPager viewPager, IndicatorView indicatorView2, LinearLayout linearLayout4, LinearAdapterLayout linearAdapterLayout, ImageView imageView, View view4, LinearLayout linearLayout5, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, RatingBar ratingBar2, ScaleImageView scaleImageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView13, LinearLayout linearLayout8, TextView textView14, TableLayout tableLayout, LinearLayout linearLayout9, Space space2, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        super(obj, view, i);
        this.actionView = textView;
        this.backgroundBottomView = view2;
        this.backgroundContainer = linearLayout;
        this.backgroundPlaceholderView = space;
        this.backgroundTopView = view3;
        this.buyCountView = textView2;
        this.buySubView = textView3;
        this.countView = textView4;
        this.coverViewContainer = maxWidthFrameLayout;
        this.descriptionView = textView5;
        this.fetchCouponView = linearLayout2;
        this.followNumView = textView6;
        this.headerContainer = linearLayout3;
        this.horizontalScrollView = horizontalScrollView2;
        this.hotNumView = textView7;
        this.imageViewPager = viewPager;
        this.indicatorView = indicatorView2;
        this.itemView = linearLayout4;
        this.linearView = linearAdapterLayout;
        this.logoView = imageView;
        this.maskView = view4;
        this.moreFollowerView = linearLayout5;
        this.rateNum1 = textView8;
        this.rateNum2 = textView9;
        this.rateNum3 = textView10;
        this.rateNum4 = textView11;
        this.rateNum5 = textView12;
        this.ratingBar = ratingBar2;
        this.ratingImageView = scaleImageView;
        this.ratingImageView1 = imageView2;
        this.ratingImageView2 = imageView3;
        this.ratingImageView3 = imageView4;
        this.ratingImageView4 = imageView5;
        this.ratingImageView5 = imageView6;
        this.ratingOwnerContainer = linearLayout6;
        this.ratingSubContainer = linearLayout7;
        this.ratingView = textView13;
        this.ratingViewContainer = linearLayout8;
        this.scoreView = textView14;
        this.tableView = tableLayout;
        this.tagsContainer = linearLayout9;
        this.tripleAvatarSpaceHolder = space2;
        this.viewAllView = textView15;
        this.viewOwnerView = textView16;
        this.wishCountView = textView17;
        this.wishView = textView18;
    }

    public Product getModel() {
        return this.mModel;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ProductNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ProductNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559109, viewGroup, z, obj);
    }

    public static ProductNodeHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ProductNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559109, null, false, obj);
    }

    public static ProductNodeHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProductNodeHeaderBinding bind(View view, Object obj) {
        return (ProductNodeHeaderBinding) bind(obj, view, 2131559109);
    }
}
