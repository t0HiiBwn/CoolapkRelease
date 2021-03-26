package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.node.app.AppNodeViewModel;

public abstract class DialogAppRatingBinding extends ViewDataBinding {
    @Bindable
    protected AppNodeViewModel mViewModel;
    public final RatingBar ratingBar;

    public abstract void setViewModel(AppNodeViewModel appNodeViewModel);

    protected DialogAppRatingBinding(Object obj, View view, int i, RatingBar ratingBar2) {
        super(obj, view, i);
        this.ratingBar = ratingBar2;
    }

    public AppNodeViewModel getViewModel() {
        return this.mViewModel;
    }

    public static DialogAppRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAppRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558517, viewGroup, z, obj);
    }

    public static DialogAppRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppRatingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAppRatingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558517, null, false, obj);
    }

    public static DialogAppRatingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAppRatingBinding bind(View view, Object obj) {
        return (DialogAppRatingBinding) bind(obj, view, 2131558517);
    }
}
