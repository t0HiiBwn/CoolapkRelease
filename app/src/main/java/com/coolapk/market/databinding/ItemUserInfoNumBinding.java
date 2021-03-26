package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.UserProfile;

public abstract class ItemUserInfoNumBinding extends ViewDataBinding {
    public final CoolapkCardView coolapkCardView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected UserProfile mModel;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final LinearLayout userFansItem;
    public final LinearLayout userFeedItem;
    public final LinearLayout userFollowItem;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(UserProfile userProfile);

    protected ItemUserInfoNumBinding(Object obj, View view, int i, CoolapkCardView coolapkCardView2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.coolapkCardView = coolapkCardView2;
        this.text1 = textView;
        this.text2 = textView2;
        this.text3 = textView3;
        this.userFansItem = linearLayout;
        this.userFeedItem = linearLayout2;
        this.userFollowItem = linearLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public UserProfile getModel() {
        return this.mModel;
    }

    public static ItemUserInfoNumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoNumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserInfoNumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558975, viewGroup, z, obj);
    }

    public static ItemUserInfoNumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoNumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserInfoNumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558975, null, false, obj);
    }

    public static ItemUserInfoNumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserInfoNumBinding bind(View view, Object obj) {
        return (ItemUserInfoNumBinding) bind(obj, view, 2131558975);
    }
}
