package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeedVotePkResultBinding extends ViewDataBinding {
    public final View leftView;
    public final ImageView pkLeftCheckView;
    public final TextView pkLeftCountView;
    public final TextView pkLeftPercentView;
    public final TextView pkLeftTitleView;
    public final LinearLayout pkResultView;
    public final ImageView pkRightCheckView;
    public final TextView pkRightCountView;
    public final TextView pkRightPercentView;
    public final TextView pkRightTitleView;
    public final View rightView;

    protected ItemFeedVotePkResultBinding(Object obj, View view, int i, View view2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6, View view3) {
        super(obj, view, i);
        this.leftView = view2;
        this.pkLeftCheckView = imageView;
        this.pkLeftCountView = textView;
        this.pkLeftPercentView = textView2;
        this.pkLeftTitleView = textView3;
        this.pkResultView = linearLayout;
        this.pkRightCheckView = imageView2;
        this.pkRightCountView = textView4;
        this.pkRightPercentView = textView5;
        this.pkRightTitleView = textView6;
        this.rightView = view3;
    }

    public static ItemFeedVotePkResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFeedVotePkResultBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558743, viewGroup, z, obj);
    }

    public static ItemFeedVotePkResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFeedVotePkResultBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558743, null, false, obj);
    }

    public static ItemFeedVotePkResultBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFeedVotePkResultBinding bind(View view, Object obj) {
        return (ItemFeedVotePkResultBinding) bind(obj, view, 2131558743);
    }
}
