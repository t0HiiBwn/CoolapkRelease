package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemCenterMoreMenuBindingImpl extends ItemCenterMoreMenuBinding {
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
        sparseIntArray.put(2131362718, 2);
        sparseIntArray.put(2131363551, 3);
        sparseIntArray.put(2131362004, 4);
        sparseIntArray.put(2131362982, 5);
    }

    public ItemCenterMoreMenuBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemCenterMoreMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (TextView) objArr[1], (ImageView) objArr[2], (LinearLayout) objArr[0], (ImageView) objArr[5], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.bubbleTextView.setTag(null);
        this.itemView.setTag(null);
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
            ThemeBindingAdapters.setBackgroundTint(this.bubbleTextView, "colorAccent");
        }
    }
}
