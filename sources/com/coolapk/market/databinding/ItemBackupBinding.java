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
import com.coolapk.market.model.BackupInfo;

public abstract class ItemBackupBinding extends ViewDataBinding {
    public final TextView discountPriceView;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected BackupInfo mModel;
    @Bindable
    protected String mSubTitle;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final TextView titleView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(BackupInfo backupInfo);

    public abstract void setSubTitle(String str);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemBackupBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, i);
        this.discountPriceView = textView;
        this.itemView = linearLayout;
        this.titleView = textView2;
    }

    public BackupInfo getModel() {
        return this.mModel;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemBackupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackupBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558623, viewGroup, z, obj);
    }

    public static ItemBackupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackupBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558623, null, false, obj);
    }

    public static ItemBackupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupBinding bind(View view, Object obj) {
        return (ItemBackupBinding) bind(obj, view, 2131558623);
    }
}
