package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.camera.CameraPreview;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.google.android.material.appbar.AppBarLayout;

public class QrCodeBindingImpl extends QrCodeBinding {
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
        sparseIntArray.put(2131362198, 8);
        sparseIntArray.put(2131363157, 9);
        sparseIntArray.put(2131363608, 10);
        sparseIntArray.put(2131362135, 11);
        sparseIntArray.put(2131362835, 12);
        sparseIntArray.put(2131363253, 13);
        sparseIntArray.put(2131363243, 14);
        sparseIntArray.put(2131363533, 15);
        sparseIntArray.put(2131362707, 16);
        sparseIntArray.put(2131362067, 17);
        sparseIntArray.put(2131363588, 18);
    }

    public QrCodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private QrCodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[7], (Button) objArr[6], (AppBarLayout) objArr[17], (ImageView) objArr[11], (RelativeLayout) objArr[8], (MaxWidthFrameLayout) objArr[1], (ImageView) objArr[16], (ImageView) objArr[12], (DrawSystemBarFrameLayout) objArr[0], (ImageView) objArr[3], (CameraPreview) objArr[9], (ImageView) objArr[4], (FrameLayout) objArr[14], (RelativeLayout) objArr[5], (ImageView) objArr[13], (View) objArr[2], (TextView) objArr[15], (Toolbar) objArr[18], (ImageView) objArr[10]);
        this.mDirtyFlags = -1;
        this.actionCopy.setTag(null);
        this.actionOpen.setTag(null);
        this.cropLayout.setTag(null);
        this.mainContent.setTag(null);
        this.myQrView.setTag(null);
        this.readImageView.setTag(null);
        this.resultView.setTag(null);
        this.scanLineView.setTag(null);
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
            ThemeBindingAdapters.setTextColor(this.actionCopy, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.actionOpen, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.cropLayout, "colorAccent");
            Number number = null;
            ViewBindingAdapters.clipView(this.myQrView, "oval", number);
            ViewBindingAdapters.clipView(this.readImageView, "oval", number);
            ViewBindingAdapters.clipView(this.resultView, null, 8);
            ThemeBindingAdapters.setBackgroundTint(this.scanLineView, "colorAccent");
        }
    }
}
