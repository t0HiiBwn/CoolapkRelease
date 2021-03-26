package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.CoolFlowLayout;

public abstract class ItemUserInfoHeaderViewBinding extends ViewDataBinding {
    public final LinearLayout editSignatureView;
    public final TextView fansNumView;
    public final TextView fansTextView;
    public final LinearLayout fansViewContainer;
    public final CoolFlowLayout flowLayout;
    public final TextView followNumView;
    public final TextView followTextView;
    public final LinearLayout followViewContainer;
    public final TextView likeNumView;
    public final TextView likeTextView;
    public final LinearLayout likeViewContainer;
    public final TextView signatureView;
    public final ImageView vIconView;
    public final TextView vTextView;
    public final LinearLayout vViewContainer;

    protected ItemUserInfoHeaderViewBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, CoolFlowLayout coolFlowLayout, TextView textView3, TextView textView4, LinearLayout linearLayout3, TextView textView5, TextView textView6, LinearLayout linearLayout4, TextView textView7, ImageView imageView, TextView textView8, LinearLayout linearLayout5) {
        super(obj, view, i);
        this.editSignatureView = linearLayout;
        this.fansNumView = textView;
        this.fansTextView = textView2;
        this.fansViewContainer = linearLayout2;
        this.flowLayout = coolFlowLayout;
        this.followNumView = textView3;
        this.followTextView = textView4;
        this.followViewContainer = linearLayout3;
        this.likeNumView = textView5;
        this.likeTextView = textView6;
        this.likeViewContainer = linearLayout4;
        this.signatureView = textView7;
        this.vIconView = imageView;
        this.vTextView = textView8;
        this.vViewContainer = linearLayout5;
    }

    public static ItemUserInfoHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserInfoHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558974, viewGroup, z, obj);
    }

    public static ItemUserInfoHeaderViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoHeaderViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserInfoHeaderViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558974, null, false, obj);
    }

    public static ItemUserInfoHeaderViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoHeaderViewBinding bind(View view, Object obj) {
        return (ItemUserInfoHeaderViewBinding) bind(obj, view, 2131558974);
    }
}
