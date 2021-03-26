package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.widget.InteractivePeopleView;

public abstract class ItemAppViewInteractiveBinding extends ViewDataBinding {
    public final InteractivePeopleView discoveryOfTheirsView;
    @Bindable
    protected AppViewViewModel mViewModel;
    public final View rate1;
    public final View rate2;
    public final View rate3;
    public final View rate4;
    public final View rate5;
    public final TextView rateNum1;
    public final TextView rateNum2;
    public final TextView rateNum3;
    public final TextView rateNum4;
    public final TextView rateNum5;
    public final TextView ratingAverage;
    public final RatingBar ratingBarAverage;
    public final TextView ratingCount;
    public final InteractivePeopleView ratingOfTheirsView;
    public final LinearLayout ratingView;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewInteractiveBinding(Object obj, View view, int i, InteractivePeopleView interactivePeopleView, View view2, View view3, View view4, View view5, View view6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RatingBar ratingBar, TextView textView7, InteractivePeopleView interactivePeopleView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.discoveryOfTheirsView = interactivePeopleView;
        this.rate1 = view2;
        this.rate2 = view3;
        this.rate3 = view4;
        this.rate4 = view5;
        this.rate5 = view6;
        this.rateNum1 = textView;
        this.rateNum2 = textView2;
        this.rateNum3 = textView3;
        this.rateNum4 = textView4;
        this.rateNum5 = textView5;
        this.ratingAverage = textView6;
        this.ratingBarAverage = ratingBar;
        this.ratingCount = textView7;
        this.ratingOfTheirsView = interactivePeopleView2;
        this.ratingView = linearLayout;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558606, viewGroup, z, obj);
    }

    public static ItemAppViewInteractiveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewInteractiveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558606, null, false, obj);
    }

    public static ItemAppViewInteractiveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewInteractiveBinding bind(View view, Object obj) {
        return (ItemAppViewInteractiveBinding) bind(obj, view, 2131558606);
    }
}
