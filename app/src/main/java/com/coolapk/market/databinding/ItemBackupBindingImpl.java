package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.BackupInfo;

public class ItemBackupBindingImpl extends ItemBackupBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemBackupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemBackupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (LinearLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.discountPriceView.setTag(null);
        this.itemView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        } else if (271 == i) {
            setSubTitle((String) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBackupBinding
    public void setModel(BackupInfo backupInfo) {
        this.mModel = backupInfo;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupBinding
    public void setSubTitle(String str) {
        this.mSubTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(271);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemBackupBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BackupInfo backupInfo = this.mModel;
        String str2 = this.mSubTitle;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((17 & j) > 0 ? 1 : ((17 & j) == 0 ? 0 : -1));
        if (i == 0 || backupInfo == null) {
            str = null;
        } else {
            str = backupInfo.getTitle();
        }
        int i2 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if ((18 & j) != 0) {
            TextViewBindingAdapter.setText(this.discountPriceView, str2);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.itemView, null, 8);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
    }
}
