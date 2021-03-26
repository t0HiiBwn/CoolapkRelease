package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemTitleViewBindingImpl extends ItemTitleViewBinding {
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
        sparseIntArray.put(2131362982, 2);
        sparseIntArray.put(2131363590, 3);
        sparseIntArray.put(2131362718, 4);
        sparseIntArray.put(2131363604, 5);
        sparseIntArray.put(2131362981, 6);
        sparseIntArray.put(2131362472, 7);
        sparseIntArray.put(2131362262, 8);
        sparseIntArray.put(2131363627, 9);
        sparseIntArray.put(2131363414, 10);
        sparseIntArray.put(2131362135, 11);
        sparseIntArray.put(2131362153, 12);
        sparseIntArray.put(2131362151, 13);
        sparseIntArray.put(2131362136, 14);
    }

    public ItemTitleViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ItemTitleViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[11], (ImageView) objArr[14], (LinearLayout) objArr[13], (TextView) objArr[1], (FrameLayout) objArr[12], (ImageView) objArr[8], (ImageView) objArr[7], (ImageView) objArr[4], (TextView) objArr[6], (FrameLayout) objArr[2], (Space) objArr[10], (LinearLayout) objArr[3], (TextView) objArr[5], (View) objArr[9], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        this.bottomTitleView.setTag(null);
        this.wrapperView.setTag(null);
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
            ThemeBindingAdapters.setTextColor(this.bottomTitleView, "colorAccent");
        }
    }
}
