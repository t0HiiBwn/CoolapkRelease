package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.SquareImageView;
import com.coolapk.market.widget.UserAvatarView;

public class UserQrcodeBindingImpl extends UserQrcodeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363626, 5);
        sparseIntArray.put(2131363900, 6);
        sparseIntArray.put(2131363914, 7);
        sparseIntArray.put(2131362382, 8);
        sparseIntArray.put(2131363168, 9);
        sparseIntArray.put(2131362900, 10);
    }

    public UserQrcodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private UserQrcodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ImageView) objArr[2], (ImageView) objArr[3], (FrameLayout) objArr[0], (TextView) objArr[8], (ImageView) objArr[10], (SquareImageView) objArr[9], (LinearLayout) objArr[1], (LinearLayout) objArr[5], (UserAvatarView) objArr[6], (TextView) objArr[7]);
        this.mDirtyFlags = -1;
        this.actionQrScan.setTag(null);
        this.actionSave.setTag(null);
        this.actionShare.setTag(null);
        this.contentView.setTag(null);
        this.qrViewContainer.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 1) != 0) {
            Number number = null;
            ViewBindingAdapters.clipView(this.actionQrScan, "oval", number);
            ViewBindingAdapters.clipView(this.actionSave, "oval", number);
            ViewBindingAdapters.clipView(this.actionShare, "oval", number);
            ViewBindingAdapters.clipView(this.qrViewContainer, null, 8);
        }
    }
}
