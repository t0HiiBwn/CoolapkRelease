package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.MobileApp;

public class DialogAlbumMobileappNoteBindingImpl extends DialogAlbumMobileappNoteBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public DialogAlbumMobileappNoteBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private DialogAlbumMobileappNoteBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.apkNoteEditView.setTag(null);
        this.cacel.setTag(null);
        this.dialogTitleView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.ok.setTag(null);
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
        if (27 != i) {
            return false;
        }
        setApp((MobileApp) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.DialogAlbumMobileappNoteBinding
    public void setApp(MobileApp mobileApp) {
        this.mApp = mobileApp;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MobileApp mobileApp = this.mApp;
        String str = null;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (!(i == 0 || mobileApp == null)) {
            str = mobileApp.getAppName();
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setEditTextTint(this.apkNoteEditView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.cacel, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.ok, "colorAccent");
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.dialogTitleView, str);
        }
    }
}
