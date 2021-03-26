package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.BlockBackEventLayout;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.InstantAutoComplete;
import com.coolapk.market.widget.TagsView;

public class SearchBindingImpl extends SearchBinding {
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
        sparseIntArray.put(2131363302, 2);
        sparseIntArray.put(2131363004, 3);
        sparseIntArray.put(2131363157, 4);
        sparseIntArray.put(2131362244, 5);
        sparseIntArray.put(2131363304, 6);
        sparseIntArray.put(2131362816, 7);
    }

    public SearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private SearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (DrawSystemBarFrameLayout) objArr[0], (TagsView) objArr[7], (ImageView) objArr[3], (ImageView) objArr[4], (BlockBackEventLayout) objArr[2], (ImageView) objArr[6], (InstantAutoComplete) objArr[1]);
        this.mDirtyFlags = -1;
        this.clickableLayout.setTag(null);
        this.searchText.setTag(null);
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
            ThemeBindingAdapters.setEditTextTint(this.searchText, "colorAccent");
        }
    }
}
