package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class AddToAlbumEditBindingImpl extends AddToAlbumEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public AddToAlbumEditBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AddToAlbumEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (EditText) objArr[1], (ProgressBar) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cacelView.setTag(null);
        this.editText.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.progressBar.setTag(null);
        this.submitView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
    public boolean setVariable(int i, Object obj) {
        if (186 != i) {
            return false;
        }
        setLoading(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.coolapk.market.databinding.AddToAlbumEditBinding
    public void setLoading(boolean z) {
        this.mLoading = z;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(186);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = this.mLoading;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (i3 != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            i = z ? 4 : 0;
            if (!z) {
                i2 = 8;
            }
        } else {
            i = 0;
        }
        if ((2 & j) != 0) {
            ThemeBindingAdapters.setTextColor(this.cacelView, "colorAccent");
            ThemeBindingAdapters.setEditTextTint(this.editText, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.submitView, "colorAccent");
        }
        if ((j & 3) != 0) {
            this.progressBar.setVisibility(i2);
            this.submitView.setVisibility(i);
        }
    }
}
