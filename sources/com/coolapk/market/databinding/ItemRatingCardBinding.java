package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.widget.ScaleImageView;

public abstract class ItemRatingCardBinding extends ViewDataBinding {
    public final CoolapkCardView itemView;
    public final ScaleImageView logoView;
    public final TextView rateNum1;
    public final TextView rateNum2;
    public final TextView rateNum3;
    public final TextView rateNum4;
    public final TextView rateNum5;
    public final RatingBar ratingBar;
    public final TextView ratingCountView;
    public final ImageView ratingImageView1;
    public final ImageView ratingImageView2;
    public final ImageView ratingImageView3;
    public final ImageView ratingImageView4;
    public final ImageView ratingImageView5;
    public final TableLayout ratingView;
    public final TextView scoreView;

    protected ItemRatingCardBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView, ScaleImageView scaleImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RatingBar ratingBar2, TextView textView6, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TableLayout tableLayout, TextView textView7) {
        super(obj, view, i);
        this.itemView = coolapkCardView;
        this.logoView = scaleImageView;
        this.rateNum1 = textView;
        this.rateNum2 = textView2;
        this.rateNum3 = textView3;
        this.rateNum4 = textView4;
        this.rateNum5 = textView5;
        this.ratingBar = ratingBar2;
        this.ratingCountView = textView6;
        this.ratingImageView1 = imageView;
        this.ratingImageView2 = imageView2;
        this.ratingImageView3 = imageView3;
        this.ratingImageView4 = imageView4;
        this.ratingImageView5 = imageView5;
        this.ratingView = tableLayout;
        this.scoreView = textView7;
    }

    public static ItemRatingCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRatingCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRatingCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558896, viewGroup, z, obj);
    }

    public static ItemRatingCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRatingCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRatingCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558896, null, false, obj);
    }

    public static ItemRatingCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRatingCardBinding bind(View view, Object obj) {
        return (ItemRatingCardBinding) bind(obj, view, 2131558896);
    }
}
