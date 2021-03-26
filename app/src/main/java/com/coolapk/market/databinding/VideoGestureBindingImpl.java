package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;

public class VideoGestureBindingImpl extends VideoGestureBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

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
        sparseIntArray.put(2131363941, 4);
        sparseIntArray.put(2131363942, 5);
        sparseIntArray.put(2131362152, 6);
        sparseIntArray.put(2131362153, 7);
        sparseIntArray.put(2131362516, 8);
        sparseIntArray.put(2131362515, 9);
    }

    public VideoGestureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private VideoGestureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (ImageView) objArr[6], (TextView) objArr[7], (LinearLayout) objArr[3], (TextView) objArr[9], (TextView) objArr[8], (LinearLayout) objArr[1], (ImageView) objArr[4], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.brightnessBoxView.setTag(null);
        this.fastForwardBoxView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.volumeBoxView.setTag(null);
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
            ViewBindingAdapters.clipView(this.brightnessBoxView, str, 12);
            ViewBindingAdapters.clipView(this.fastForwardBoxView, str, 12);
            ViewBindingAdapters.clipView(this.volumeBoxView, str, 12);
        }
    }
}
