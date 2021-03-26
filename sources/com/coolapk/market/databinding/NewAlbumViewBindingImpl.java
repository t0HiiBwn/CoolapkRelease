package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public class NewAlbumViewBindingImpl extends NewAlbumViewBinding {
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
        sparseIntArray.put(2131362067, 3);
        sparseIntArray.put(2131363593, 4);
        sparseIntArray.put(2131362645, 5);
        sparseIntArray.put(2131362652, 6);
        sparseIntArray.put(2131361981, 7);
        sparseIntArray.put(2131362025, 8);
        sparseIntArray.put(2131363588, 9);
        sparseIntArray.put(2131363888, 10);
        sparseIntArray.put(2131363889, 11);
        sparseIntArray.put(2131363891, 12);
        sparseIntArray.put(2131362021, 13);
        sparseIntArray.put(2131362024, 14);
    }

    public NewAlbumViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private NewAlbumViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (TextView) objArr[13], (FrameLayout) objArr[14], (TextView) objArr[8], (AppBarLayout) objArr[3], (View) objArr[2], (ImageView) objArr[5], (LinearLayout) objArr[6], (Toolbar) objArr[9], (CollapsingToolbarFixLayout) objArr[4], (TextView) objArr[1], (CardView) objArr[10], (ImageView) objArr[11], (TextView) objArr[12]);
        this.mDirtyFlags = -1;
        this.fixStatusBar.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.userFollowActionButton.setTag(null);
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
            ThemeBindingAdapters.setBackgroundColor(this.fixStatusBar, "colorPrimary");
            ThemeBindingAdapters.setTextColor(this.userFollowActionButton, "colorPrimary");
        }
    }
}
