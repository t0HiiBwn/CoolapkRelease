package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.view.app.AppViewViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemDeveloperCardBindingImpl extends ItemDeveloperCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363359, 5);
        sparseIntArray.put(2131362095, 6);
    }

    public ItemDeveloperCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemDeveloperCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[6], (RoundedImageView) objArr[1], (LinearLayout) objArr[0], (Button) objArr[4], (Button) objArr[5]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.developerView.setTag(null);
        this.followView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setViewModel((AppViewViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDeveloperCardBinding
    public void setViewModel(AppViewViewModel appViewViewModel) {
        updateRegistration(0, appViewViewModel);
        this.mViewModel = appViewViewModel;
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
        return onChangeViewModel((AppViewViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AppViewViewModel appViewViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 68) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 70) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 71) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 118) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppViewViewModel appViewViewModel = this.mViewModel;
        boolean z = false;
        if ((63 & j) != 0) {
            str2 = ((j & 41) == 0 || appViewViewModel == null) ? null : appViewViewModel.getDeveloperTitle();
            String developerAvatar = ((j & 35) == 0 || appViewViewModel == null) ? null : appViewViewModel.getDeveloperAvatar();
            String developerName = ((j & 37) == 0 || appViewViewModel == null) ? null : appViewViewModel.getDeveloperName();
            int i = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
            if (i != 0) {
                if (appViewViewModel != null) {
                    z = appViewViewModel.isFollowDeveloper();
                }
                if (i != 0) {
                    j |= z ? 128 : 64;
                }
                str4 = this.followView.getResources().getString(z ? 2131886114 : 2131886134);
                str = developerAvatar;
            } else {
                str = developerAvatar;
                str4 = null;
            }
            str3 = developerName;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((35 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        }
        if ((49 & j) != 0) {
            TextViewBindingAdapter.setText(this.followView, str4);
        }
        if ((j & 37) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str3);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str2);
        }
    }
}
