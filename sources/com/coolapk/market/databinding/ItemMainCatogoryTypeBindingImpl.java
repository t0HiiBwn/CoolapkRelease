package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemMainCatogoryTypeBindingImpl extends ItemMainCatogoryTypeBinding {
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
        sparseIntArray.put(2131362251, 3);
        sparseIntArray.put(2131362252, 4);
    }

    public ItemMainCatogoryTypeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemMainCatogoryTypeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (LinearLayout) objArr[4], (CheckedTextView) objArr[1], (CheckedTextView) objArr[2]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.textView1.setTag(null);
        this.textView2.setTag(null);
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
            ThemeBindingAdapters.setBackgroundTint(this.textView1, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView2, "colorAccent");
        }
    }
}
