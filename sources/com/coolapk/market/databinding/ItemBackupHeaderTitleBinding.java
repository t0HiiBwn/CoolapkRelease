package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;

public abstract class ItemBackupHeaderTitleBinding extends ViewDataBinding {
    public final LinearLayout countView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected String mCount;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setCount(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemBackupHeaderTitleBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.countView = linearLayout;
        this.titleView = textView;
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

    public static ItemBackupHeaderTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackupHeaderTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558627, viewGroup, z, obj);
    }

    public static ItemBackupHeaderTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackupHeaderTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558627, null, false, obj);
    }

    public static ItemBackupHeaderTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderTitleBinding bind(View view, Object obj) {
        return (ItemBackupHeaderTitleBinding) bind(obj, view, 2131558627);
    }
}
