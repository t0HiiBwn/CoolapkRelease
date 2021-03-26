package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.AppForum;

public abstract class ItemAppForumBinding extends ViewDataBinding {
    public final LinearLayout cardView;
    public final TextView commentView;
    public final CoolapkCardView coolapkCardView;
    public final TextView followView;
    public final ImageView iconView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected AppForum mModel;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(AppForum appForum);

    protected ItemAppForumBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, CoolapkCardView coolapkCardView2, TextView textView2, ImageView imageView, TextView textView3) {
        super(obj, view, i);
        this.cardView = linearLayout;
        this.commentView = textView;
        this.coolapkCardView = coolapkCardView2;
        this.followView = textView2;
        this.iconView = imageView;
        this.titleView = textView3;
    }

    public AppForum getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemAppForumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppForumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAppForumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558591, viewGroup, z, obj);
    }

    public static ItemAppForumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppForumBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAppForumBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558591, null, false, obj);
    }

    public static ItemAppForumBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAppForumBinding bind(View view, Object obj) {
        return (ItemAppForumBinding) bind(obj, view, 2131558591);
    }
}
