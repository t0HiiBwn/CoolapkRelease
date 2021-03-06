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

public class ItemFeedSecondHandHeaderViewPartBindingImpl extends ItemFeedSecondHandHeaderViewPartBinding {
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
        sparseIntArray.put(2131363590, 3);
        sparseIntArray.put(2131363604, 4);
        sparseIntArray.put(2131363551, 5);
        sparseIntArray.put(2131362481, 6);
        sparseIntArray.put(2131363380, 7);
        sparseIntArray.put(2131363166, 8);
        sparseIntArray.put(2131362945, 9);
    }

    public ItemFeedSecondHandHeaderViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemFeedSecondHandHeaderViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[8], (ImageView) objArr[2], (TextView) objArr[7], (TextView) objArr[5], (FrameLayout) objArr[3], (TextView) objArr[1], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.signLink.setTag(null);
        this.titleTagView.setTag(null);
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
            String str = null;
            ViewBindingAdapters.clipView(this.signLink, str, 2);
            ViewBindingAdapters.clipView(this.titleTagView, str, 3);
        }
    }
}
