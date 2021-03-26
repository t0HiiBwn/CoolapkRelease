package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.UserAvatarView;

public class UserToolbarBindingImpl extends UserToolbarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public UserToolbarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private UserToolbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.toolbarActionContainer.setTag(null);
        this.toolbarActionView.setTag(null);
        this.toolbarNameView.setTag(null);
        this.toolbarUserAvatarView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (300 == i) {
            setUserVerifyStatusIcon((String) obj);
        } else if (298 == i) {
            setUserName((String) obj);
        } else if (294 == i) {
            setUserAvatar((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.UserToolbarBinding
    public void setUserVerifyStatusIcon(String str) {
        this.mUserVerifyStatusIcon = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(300);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.UserToolbarBinding
    public void setUserName(String str) {
        this.mUserName = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(298);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.UserToolbarBinding
    public void setUserAvatar(String str) {
        this.mUserAvatar = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(294);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.UserToolbarBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mUserVerifyStatusIcon;
        String str2 = this.mUserName;
        String str3 = this.mUserAvatar;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((17 & j) > 0 ? 1 : ((17 & j) == 0 ? 0 : -1));
        int i2 = ((18 & j) > 0 ? 1 : ((18 & j) == 0 ? 0 : -1));
        int i3 = ((28 & j) > 0 ? 1 : ((28 & j) == 0 ? 0 : -1));
        if ((24 & j) != 0) {
            ViewBindingAdapters.clickListener(this.toolbarActionView, onClickListener, null);
        }
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.toolbarActionView, "capsule", null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.toolbarNameView, str2);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.toolbarUserAvatarView, str3, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, true, true, onClickListener, bool);
        }
        if (i != 0) {
            ImageViewBindingAdapters.setVipSignView(this.toolbarUserAvatarView, str, null);
        }
    }
}
