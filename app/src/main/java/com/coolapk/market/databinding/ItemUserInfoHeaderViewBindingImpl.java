package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.CoolFlowLayout;

public class ItemUserInfoHeaderViewBindingImpl extends ItemUserInfoHeaderViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

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
        sparseIntArray.put(2131363901, 2);
        sparseIntArray.put(2131363900, 3);
        sparseIntArray.put(2131363365, 4);
        sparseIntArray.put(2131362439, 5);
        sparseIntArray.put(2131362852, 6);
        sparseIntArray.put(2131362846, 7);
        sparseIntArray.put(2131362849, 8);
        sparseIntArray.put(2131362583, 9);
        sparseIntArray.put(2131362580, 10);
        sparseIntArray.put(2131362581, 11);
        sparseIntArray.put(2131362513, 12);
        sparseIntArray.put(2131362511, 13);
        sparseIntArray.put(2131362512, 14);
        sparseIntArray.put(2131362576, 15);
    }

    public ItemUserInfoHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemUserInfoHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[5], (TextView) objArr[13], (TextView) objArr[14], (LinearLayout) objArr[12], (CoolFlowLayout) objArr[15], (TextView) objArr[10], (TextView) objArr[11], (LinearLayout) objArr[9], (TextView) objArr[7], (TextView) objArr[8], (LinearLayout) objArr[6], (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[2]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.vIconView.setTag(null);
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
            ViewBindingAdapters.clipView(this.vIconView, "oval", null);
        }
    }
}
