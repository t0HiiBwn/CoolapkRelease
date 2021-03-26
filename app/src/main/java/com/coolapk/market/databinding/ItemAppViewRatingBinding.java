package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.app.AppViewViewModel;

public abstract class ItemAppViewRatingBinding extends ViewDataBinding {
    @Bindable
    protected AppViewViewModel mViewModel;
    public final RatingBar ratingBar;

    public abstract void setViewModel(AppViewViewModel appViewViewModel);

    protected ItemAppViewRatingBinding(Object obj, View view, int i, RatingBar ratingBar2) {
        super(obj, view, i);
        this.ratingBar = ratingBar2;
    }

    public AppViewViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemAppViewRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppViewRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558607, viewGroup, z, obj);
    }

    public static ItemAppViewRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppViewRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558607, null, false, obj);
    }

    public static ItemAppViewRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppViewRatingBinding bind(View view, Object obj) {
        return (ItemAppViewRatingBinding) bind(obj, view, 2131558607);
    }
}
