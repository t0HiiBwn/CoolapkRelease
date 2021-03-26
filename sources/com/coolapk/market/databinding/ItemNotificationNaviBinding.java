package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.widget.view.FatTextView;

public abstract class ItemNotificationNaviBinding extends ViewDataBinding {
    public final ImageView imageView;
    public final LinearLayout itemView1;
    public final LinearLayout itemView2;
    public final LinearLayout itemView4;
    public final LinearLayout itemView5;
    public final LinearLayout itemView6;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected AppNotification mNotification;
    public final FatTextView textView1;
    public final FatTextView textView2;
    public final FatTextView textView3;
    public final FatTextView textView4;
    public final FatTextView textView5;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setNotification(AppNotification appNotification);

    protected ItemNotificationNaviBinding(Object obj, View view, int i, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, FatTextView fatTextView, FatTextView fatTextView2, FatTextView fatTextView3, FatTextView fatTextView4, FatTextView fatTextView5) {
        super(obj, view, i);
        this.imageView = imageView2;
        this.itemView1 = linearLayout;
        this.itemView2 = linearLayout2;
        this.itemView4 = linearLayout3;
        this.itemView5 = linearLayout4;
        this.itemView6 = linearLayout5;
        this.textView1 = fatTextView;
        this.textView2 = fatTextView2;
        this.textView3 = fatTextView3;
        this.textView4 = fatTextView4;
        this.textView5 = fatTextView5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public AppNotification getNotification() {
        return this.mNotification;
    }

    public static ItemNotificationNaviBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationNaviBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNotificationNaviBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558846, viewGroup, z, obj);
    }

    public static ItemNotificationNaviBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationNaviBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNotificationNaviBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558846, null, false, obj);
    }

    public static ItemNotificationNaviBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNotificationNaviBinding bind(View view, Object obj) {
        return (ItemNotificationNaviBinding) bind(obj, view, 2131558846);
    }
}
