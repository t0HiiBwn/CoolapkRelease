package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.HolderItem;

public abstract class ItemBackupHeaderBinding extends ViewDataBinding {
    public final TextView actionView;
    public final LinearLayout countView;
    public final TextView desView;
    public final ProgressBar loadingView;
    public final ImageView logoView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mCount;
    @Bindable
    protected HolderItem mModel;
    @Bindable
    protected String mTime;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setCount(String str);

    public abstract void setModel(HolderItem holderItem);

    public abstract void setTime(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemBackupHeaderBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, ProgressBar progressBar, ImageView imageView, LinearLayout linearLayout2, TextView textView3) {
        super(obj, view, i);
        this.actionView = textView;
        this.countView = linearLayout;
        this.desView = textView2;
        this.loadingView = progressBar;
        this.logoView = imageView;
        this.rootView = linearLayout2;
        this.titleView = textView3;
    }

    public HolderItem getModel() {
        return this.mModel;
    }

    public String getTime() {
        return this.mTime;
    }

    public String getCount() {
        return this.mCount;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemBackupHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackupHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558625, viewGroup, z, obj);
    }

    public static ItemBackupHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackupHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558625, null, false, obj);
    }

    public static ItemBackupHeaderBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderBinding bind(View view, Object obj) {
        return (ItemBackupHeaderBinding) bind(obj, view, 2131558625);
    }
}
