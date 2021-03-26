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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.model.BackupInfo;

public abstract class ItemBackupHeaderInfoBinding extends ViewDataBinding {
    public final ImageView backupImgView;
    public final TextView backupNumView;
    public final TextView backupTitleView;
    public final ImageView deviceImgView;
    public final TextView deviceInfoView;
    public final TextView deviceTitleView;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected BackupInfo mModel;
    @Bindable
    protected OnBitmapTransformListener mTransformer;
    public final LinearLayout rootView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setModel(BackupInfo backupInfo);

    public abstract void setTransformer(OnBitmapTransformListener onBitmapTransformListener);

    protected ItemBackupHeaderInfoBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, LinearLayout linearLayout) {
        super(obj, view, i);
        this.backupImgView = imageView;
        this.backupNumView = textView;
        this.backupTitleView = textView2;
        this.deviceImgView = imageView2;
        this.deviceInfoView = textView3;
        this.deviceTitleView = textView4;
        this.rootView = linearLayout;
    }

    public BackupInfo getModel() {
        return this.mModel;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public OnBitmapTransformListener getTransformer() {
        return this.mTransformer;
    }

    public static ItemBackupHeaderInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBackupHeaderInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558622, viewGroup, z, obj);
    }

    public static ItemBackupHeaderInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBackupHeaderInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558622, null, false, obj);
    }

    public static ItemBackupHeaderInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBackupHeaderInfoBinding bind(View view, Object obj) {
        return (ItemBackupHeaderInfoBinding) bind(obj, view, 2131558622);
    }
}
