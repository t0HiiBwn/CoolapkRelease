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
import com.coolapk.market.model.Feed;

public abstract class ItemSecondHandSearchBinding extends ViewDataBinding {
    public final LinearLayout actionView;
    public final ImageView avatarView;
    public final CoolapkCardView coolapkCardView;
    public final TextView discountPriceView;
    public final TextView exchangePriceView;
    public final ImageView imgSellView;
    public final LinearLayout itemView;
    public final TextView locationView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mDateAndReply;
    @Bindable
    protected String mLocationText;
    @Bindable
    protected Feed mModel;
    public final View maskView;
    public final ImageView picView;
    public final ImageView signLink;
    public final TextView signLinkText;
    public final FrameLayout titleContainer;
    public final TextView titleTagView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setDateAndReply(String str);

    public abstract void setLocationText(String str);

    public abstract void setModel(Feed feed);

    protected ItemSecondHandSearchBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2, ImageView imageView2, LinearLayout linearLayout2, TextView textView3, View view2, ImageView imageView3, ImageView imageView4, TextView textView4, FrameLayout frameLayout, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.actionView = linearLayout;
        this.avatarView = imageView;
        this.coolapkCardView = coolapkCardView2;
        this.discountPriceView = textView;
        this.exchangePriceView = textView2;
        this.imgSellView = imageView2;
        this.itemView = linearLayout2;
        this.locationView = textView3;
        this.maskView = view2;
        this.picView = imageView3;
        this.signLink = imageView4;
        this.signLinkText = textView4;
        this.titleContainer = frameLayout;
        this.titleTagView = textView5;
        this.titleView = textView6;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public String getDateAndReply() {
        return this.mDateAndReply;
    }

    public Feed getModel() {
        return this.mModel;
    }

    public String getLocationText() {
        return this.mLocationText;
    }

    public static ItemSecondHandSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSecondHandSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558927, viewGroup, z, obj);
    }

    public static ItemSecondHandSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSecondHandSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558927, null, false, obj);
    }

    public static ItemSecondHandSearchBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSecondHandSearchBinding bind(View view, Object obj) {
        return (ItemSecondHandSearchBinding) bind(obj, view, 2131558927);
    }
}
