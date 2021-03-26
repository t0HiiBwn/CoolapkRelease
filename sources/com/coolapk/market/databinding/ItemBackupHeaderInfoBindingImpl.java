package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.BackupInfo;

public class ItemBackupHeaderInfoBindingImpl extends ItemBackupHeaderInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362390, 3);
        sparseIntArray.put(2131362393, 4);
        sparseIntArray.put(2131362105, 5);
        sparseIntArray.put(2131362107, 6);
    }

    public ItemBackupHeaderInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemBackupHeaderInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (TextView) objArr[2], (TextView) objArr[6], (ImageView) objArr[3], (TextView) objArr[1], (TextView) objArr[4], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.backupNumView.setTag(null);
        this.deviceInfoView.setTag(null);
        this.rootView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((BackupInfo) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderInfoBinding
    public void setModel(BackupInfo backupInfo) {
        this.mModel = backupInfo;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderInfoBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderInfoBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BackupInfo backupInfo = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i == 0 || backupInfo == null) {
            str2 = null;
            str = null;
        } else {
            str = backupInfo.getApkNumTitle();
            str2 = backupInfo.getDeviceTitle();
        }
        int i2 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i != 0) {
            TextViewBindingAdapter.setText(this.backupNumView, str);
            TextViewBindingAdapter.setText(this.deviceInfoView, str2);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, null);
        }
    }
}
