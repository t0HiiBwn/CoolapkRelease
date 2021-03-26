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

public class ItemFeedVotePkResultBindingImpl extends ItemFeedVotePkResultBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

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
        sparseIntArray.put(2131363116, 2);
        sparseIntArray.put(2131363118, 3);
        sparseIntArray.put(2131363126, 4);
        sparseIntArray.put(2131363124, 5);
        sparseIntArray.put(2131363115, 6);
        sparseIntArray.put(2131363114, 7);
        sparseIntArray.put(2131363122, 8);
        sparseIntArray.put(2131363123, 9);
        sparseIntArray.put(2131362837, 10);
        sparseIntArray.put(2131363256, 11);
    }

    public ItemFeedVotePkResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemFeedVotePkResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[10], (ImageView) objArr[7], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[3], (LinearLayout) objArr[1], (ImageView) objArr[8], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[4], (View) objArr[11]);
        this.mDirtyFlags = -1;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.pkResultView.setTag(null);
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
            ViewBindingAdapters.clipView(this.pkResultView, "capsule", null);
        }
    }
}
