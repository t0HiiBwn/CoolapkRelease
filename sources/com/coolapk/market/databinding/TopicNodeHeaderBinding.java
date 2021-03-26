package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.model.Topic;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public abstract class TopicNodeHeaderBinding extends ViewDataBinding {
    public final TextView actionView;
    public final View backgroundBottomView;
    public final LinearLayout backgroundContainer;
    public final Space backgroundPlaceholderView;
    public final View backgroundTopView;
    public final MaxWidthFrameLayout coverViewContainer;
    public final TextView descriptionView;
    public final TextView followNumView;
    public final LinearLayout headerContainer;
    public final TextView hotNumView;
    public final ViewPager imageViewPager;
    public final IndicatorView indicatorView;
    public final LinearLayout itemView;
    public final LinearAdapterLayout linearView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Topic mModel;
    public final View maskView;
    public final LinearLayout moreFollowerView;
    public final Space tripleAvatarSpaceHolder;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Topic topic);

    protected TopicNodeHeaderBinding(Object obj, View view, int i, TextView textView, View view2, LinearLayout linearLayout, Space space, View view3, MaxWidthFrameLayout maxWidthFrameLayout, TextView textView2, TextView textView3, LinearLayout linearLayout2, TextView textView4, ViewPager viewPager, IndicatorView indicatorView2, LinearLayout linearLayout3, LinearAdapterLayout linearAdapterLayout, ImageView imageView, View view4, LinearLayout linearLayout4, Space space2) {
        super(obj, view, i);
        this.actionView = textView;
        this.backgroundBottomView = view2;
        this.backgroundContainer = linearLayout;
        this.backgroundPlaceholderView = space;
        this.backgroundTopView = view3;
        this.coverViewContainer = maxWidthFrameLayout;
        this.descriptionView = textView2;
        this.followNumView = textView3;
        this.headerContainer = linearLayout2;
        this.hotNumView = textView4;
        this.imageViewPager = viewPager;
        this.indicatorView = indicatorView2;
        this.itemView = linearLayout3;
        this.linearView = linearAdapterLayout;
        this.logoView = imageView;
        this.maskView = view4;
        this.moreFollowerView = linearLayout4;
        this.tripleAvatarSpaceHolder = space2;
    }

    public Topic getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static TopicNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TopicNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559202, viewGroup, z, obj);
    }

    public static TopicNodeHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TopicNodeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559202, null, false, obj);
    }

    public static TopicNodeHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TopicNodeHeaderBinding bind(View view, Object obj) {
        return (TopicNodeHeaderBinding) bind(obj, view, 2131559202);
    }
}
