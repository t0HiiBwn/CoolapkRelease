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
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.view.ProductScoreView;

public abstract class ItemProductMultiRatingMapBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout itemView;
    public final LinearLayout linearView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected Product mModel;
    public final ProductScoreView productScoreView;
    public final RatingBar ratingBar;
    public final TextView ratingCountView;
    public final TextView scoreView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(Product product);

    protected ItemProductMultiRatingMapBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ProductScoreView productScoreView2, RatingBar ratingBar2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.itemView = linearLayout;
        this.linearView = linearLayout2;
        this.productScoreView = productScoreView2;
        this.ratingBar = ratingBar2;
        this.ratingCountView = textView2;
        this.scoreView = textView3;
    }

    public Product getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemProductMultiRatingMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMultiRatingMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemProductMultiRatingMapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558869, viewGroup, z, obj);
    }

    public static ItemProductMultiRatingMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMultiRatingMapBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemProductMultiRatingMapBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558869, null, false, obj);
    }

    public static ItemProductMultiRatingMapBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemProductMultiRatingMapBinding bind(View view, Object obj) {
        return (ItemProductMultiRatingMapBinding) bind(obj, view, 2131558869);
    }
}
