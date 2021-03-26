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
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ItemVideoViewPartBindingImpl extends ItemVideoViewPartBinding {
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
        sparseIntArray.put(2131363913, 4);
        sparseIntArray.put(2131363129, 5);
        sparseIntArray.put(2131363234, 6);
        sparseIntArray.put(2131362873, 7);
        sparseIntArray.put(2131362872, 8);
        sparseIntArray.put(2131363080, 9);
        sparseIntArray.put(2131362417, 10);
    }

    public ItemVideoViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemVideoViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DividerLineView) objArr[10], (MaxWidthFrameLayout) objArr[0], (TextView) objArr[8], (LinearLayout) objArr[7], (ImageView) objArr[9], (ImageView) objArr[5], (TextView) objArr[6], (TextView) objArr[3], (ImageView) objArr[4], (FrameLayout) objArr[2], (FrameLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.tagView.setTag(null);
        this.videoCoverContainer.setTag(null);
        this.videoPlayer.setTag(null);
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
            ViewBindingAdapters.clipView(this.tagView, str, 2);
            ViewBindingAdapters.clipView(this.videoCoverContainer, str, 8);
            ViewBindingAdapters.clipView(this.videoPlayer, str, 8);
        }
    }
}
