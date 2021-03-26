package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.coolapk.market.view.backupList.BackupMobileAppFragment;

public class ItemBackAppSwitchBindingImpl extends ItemBackAppSwitchBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363533, 3);
    }

    public ItemBackAppSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemBackAppSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ProgressBar) objArr[2], (SwitchCompat) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.loading.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.switchView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (306 != i) {
            return false;
        }
        setVh((BackupMobileAppFragment.SwitchViewHolder) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBackAppSwitchBinding
    public void setVh(BackupMobileAppFragment.SwitchViewHolder switchViewHolder) {
        updateRegistration(0, switchViewHolder);
        this.mVh = switchViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(306);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVh((BackupMobileAppFragment.SwitchViewHolder) obj, i2);
    }

    private boolean onChangeVh(BackupMobileAppFragment.SwitchViewHolder switchViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 48) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 186) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        boolean z2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BackupMobileAppFragment.SwitchViewHolder switchViewHolder = this.mVh;
        int i2 = 0;
        if ((15 & j) != 0) {
            z = ((j & 11) == 0 || switchViewHolder == null) ? false : switchViewHolder.isChecked();
            int i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i3 != 0) {
                if (switchViewHolder != null) {
                    z2 = switchViewHolder.isLoading();
                } else {
                    z2 = false;
                }
                if (i3 != 0) {
                    if (z2) {
                        j3 = j | 32;
                        j2 = 128;
                    } else {
                        j3 = j | 16;
                        j2 = 64;
                    }
                    j = j3 | j2;
                }
                i = z2 ? 8 : 0;
                if (!z2) {
                    i2 = 8;
                }
                if ((13 & j) != 0) {
                    this.loading.setVisibility(i2);
                    this.switchView.setVisibility(i);
                }
                if ((j & 11) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.switchView, z);
                }
                if ((j & 9) == 0) {
                    this.switchView.setOnCheckedChangeListener(switchViewHolder);
                    return;
                }
                return;
            }
        } else {
            z = false;
        }
        i = 0;
        if ((13 & j) != 0) {
        }
        if ((j & 11) != 0) {
        }
        if ((j & 9) == 0) {
        }
    }
}
