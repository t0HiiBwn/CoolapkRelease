package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.ActionButton;

public abstract class ServiceAppBinding extends ViewDataBinding {
    public final ActionButton actionContainer;
    public final FrameLayout alsoDownloadLayout;
    public final TextView apkInfoView;
    public final TextView apkSubtitleView;
    public final CoolapkCardView coolapkCardView;
    public final TextView couponTitleView;
    public final FrameLayout couponView;
    public final TextView extraTextView;
    public final TextView fetchCouponView;
    public final LinearLayout headerView;
    public final ImageView iconView;
    public final LinearLayout introductionLayout;
    public final TextView introductionView;
    public final LinearLayout itemView;
    @Bindable
    protected ServiceApp mApp;
    public final TextView marketInfoView;
    public final TextView newTagView;
    public final TextView rankTextView;
    public final TextView rankUpDownView;
    public final LinearLayout rankView;
    public final LinearLayout setTopView;
    public final TextView titleView;

    public abstract void setApp(ServiceApp serviceApp);

    protected ServiceAppBinding(Object obj, View view, int i, ActionButton actionButton, FrameLayout frameLayout, TextView textView, TextView textView2, CoolapkCardView coolapkCardView2, TextView textView3, FrameLayout frameLayout2, TextView textView4, TextView textView5, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView6, LinearLayout linearLayout3, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView11) {
        super(obj, view, i);
        this.actionContainer = actionButton;
        this.alsoDownloadLayout = frameLayout;
        this.apkInfoView = textView;
        this.apkSubtitleView = textView2;
        this.coolapkCardView = coolapkCardView2;
        this.couponTitleView = textView3;
        this.couponView = frameLayout2;
        this.extraTextView = textView4;
        this.fetchCouponView = textView5;
        this.headerView = linearLayout;
        this.iconView = imageView;
        this.introductionLayout = linearLayout2;
        this.introductionView = textView6;
        this.itemView = linearLayout3;
        this.marketInfoView = textView7;
        this.newTagView = textView8;
        this.rankTextView = textView9;
        this.rankUpDownView = textView10;
        this.rankView = linearLayout4;
        this.setTopView = linearLayout5;
        this.titleView = textView11;
    }

    public ServiceApp getApp() {
        return this.mApp;
    }

    public static ServiceAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceAppBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ServiceAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558924, viewGroup, z, obj);
    }

    public static ServiceAppBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceAppBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ServiceAppBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558924, null, false, obj);
    }

    public static ServiceAppBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ServiceAppBinding bind(View view, Object obj) {
        return (ServiceAppBinding) bind(obj, view, 2131558924);
    }
}
