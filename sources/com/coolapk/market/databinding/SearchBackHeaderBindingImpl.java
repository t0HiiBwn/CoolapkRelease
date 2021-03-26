package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public class SearchBackHeaderBindingImpl extends SearchBackHeaderBinding {
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
        sparseIntArray.put(2131363004, 1);
        sparseIntArray.put(2131363007, 2);
        sparseIntArray.put(2131363318, 3);
        sparseIntArray.put(2131362882, 4);
        sparseIntArray.put(2131363319, 5);
        sparseIntArray.put(2131363320, 6);
        sparseIntArray.put(2131362087, 7);
        sparseIntArray.put(2131363156, 8);
        sparseIntArray.put(2131363157, 9);
        sparseIntArray.put(2131362244, 10);
        sparseIntArray.put(2131363304, 11);
        sparseIntArray.put(2131363311, 12);
    }

    public SearchBackHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private SearchBackHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[7], (ImageView) objArr[10], (ProgressBar) objArr[4], (FrameLayout) objArr[1], (ImageView) objArr[2], (FrameLayout) objArr[8], (ImageView) objArr[9], (LinearLayout) objArr[0], (FrameLayout) objArr[11], (ImageView) objArr[12], (AutoCompleteTextView) objArr[3], (LinearLayout) objArr[5], (TextView) objArr[6]);
        this.mDirtyFlags = -1;
        this.searchBoxLayout.setTag(null);
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
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
