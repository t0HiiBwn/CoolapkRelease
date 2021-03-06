package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public class AlbumActionBarBindingImpl extends AlbumActionBarBinding {
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
        sparseIntArray.put(2131363434, 1);
        sparseIntArray.put(2131363436, 2);
        sparseIntArray.put(2131363435, 3);
        sparseIntArray.put(2131362855, 4);
        sparseIntArray.put(2131362862, 5);
        sparseIntArray.put(2131362858, 6);
        sparseIntArray.put(2131362293, 7);
        sparseIntArray.put(2131362296, 8);
        sparseIntArray.put(2131362295, 9);
        sparseIntArray.put(2131362427, 10);
        sparseIntArray.put(2131362430, 11);
        sparseIntArray.put(2131362429, 12);
    }

    public AlbumActionBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AlbumActionBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (TextView) objArr[9], (ImageView) objArr[8], (LinearLayout) objArr[10], (TextView) objArr[12], (ImageView) objArr[11], (LinearLayout) objArr[4], (TextView) objArr[6], (ImageView) objArr[5], (LinearLayout) objArr[1], (TextView) objArr[3], (ImageView) objArr[2]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
