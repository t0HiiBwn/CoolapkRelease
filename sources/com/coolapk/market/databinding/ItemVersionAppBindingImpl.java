package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.view.app.VersionAppViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemVersionAppBindingImpl extends ItemVersionAppBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public ItemVersionAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemVersionAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[5], (ActionButtonFrameLayout) objArr[4], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.dateView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.sizeView.setTag(null);
        this.versionView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (309 != i) {
            return false;
        }
        setViewModel((VersionAppViewHolder) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemVersionAppBinding
    public void setViewModel(VersionAppViewHolder versionAppViewHolder) {
        updateRegistration(0, versionAppViewHolder);
        this.mViewModel = versionAppViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((VersionAppViewHolder) obj, i2);
    }

    private boolean onChangeViewModel(VersionAppViewHolder versionAppViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 303) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 1) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 62) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 286) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        long j2;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int i = 0;
        VersionAppViewHolder versionAppViewHolder = this.mViewModel;
        String str9 = null;
        if ((255 & j) != 0) {
            if ((j & 131) != 0) {
                VersionApp versionApp = versionAppViewHolder != null ? versionAppViewHolder.getVersionApp() : null;
                if (versionApp != null) {
                    str3 = versionApp.getVersionDate();
                    str6 = versionApp.getVersionSize();
                    str7 = versionApp.getVersionName();
                    if ((j & 157) != 0 || versionAppViewHolder == null) {
                        j3 = 0;
                        j2 = 0;
                        str8 = null;
                    } else {
                        j3 = versionAppViewHolder.getTotalLength();
                        j2 = versionAppViewHolder.getCurrentLength();
                        str8 = versionAppViewHolder.getActionButtonBackground();
                    }
                    if (!((j & 161) == 0 || versionAppViewHolder == null)) {
                        str9 = versionAppViewHolder.getActionText();
                    }
                    if (!((j & 193) == 0 || versionAppViewHolder == null)) {
                        i = versionAppViewHolder.getActionButtonTextColor();
                    }
                    str = str7;
                    str5 = str9;
                    str2 = str6;
                    str4 = str8;
                }
            }
            str7 = null;
            str3 = null;
            str6 = null;
            if ((j & 157) != 0) {
            }
            j3 = 0;
            j2 = 0;
            str8 = null;
            str9 = versionAppViewHolder.getActionText();
            i = versionAppViewHolder.getActionButtonTextColor();
            str = str7;
            str5 = str9;
            str2 = str6;
            str4 = str8;
        } else {
            j3 = 0;
            j2 = 0;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((161 & j) != 0) {
            TextViewBindingAdapter.setText(this.actionButton, str5);
        }
        if ((193 & j) != 0) {
            this.actionButton.setTextColor(i);
        }
        if ((157 & j) != 0) {
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, str4, Long.valueOf(j2), Long.valueOf(j3));
        }
        if ((j & 131) != 0) {
            TextViewBindingAdapter.setText(this.dateView, str3);
            TextViewBindingAdapter.setText(this.sizeView, str2);
            TextViewBindingAdapter.setText(this.versionView, str);
        }
    }
}
