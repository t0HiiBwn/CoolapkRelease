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

public class DialogEditSubmitBindingImpl extends DialogEditSubmitBinding {
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
        sparseIntArray.put(2131363582, 5);
        sparseIntArray.put(2131362441, 6);
        sparseIntArray.put(2131362470, 7);
    }

    public DialogEditSubmitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private DialogEditSubmitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (LinearLayout) objArr[0], (EditText) objArr[6], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[1], (ProgressBar) objArr[4], (TextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.cancelButton.setTag(null);
        this.contentView.setTag(null);
        this.okButton.setTag(null);
        this.pasteButton.setTag(null);
        this.progressBar.setTag(null);
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
            ThemeBindingAdapters.setTextColor(this.cancelButton, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.okButton, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.pasteButton, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
        }
    }
}
