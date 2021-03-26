package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.UserProfile;

public class ItemUserInfoNumBindingImpl extends ItemUserInfoNumBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemUserInfoNumBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemUserInfoNumBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[6], (LinearLayout) objArr[5], (LinearLayout) objArr[1], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.text1.setTag(null);
        this.text2.setTag(null);
        this.text3.setTag(null);
        this.userFansItem.setTag(null);
        this.userFeedItem.setTag(null);
        this.userFollowItem.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (198 == i) {
            setModel((UserProfile) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemUserInfoNumBinding
    public void setModel(UserProfile userProfile) {
        this.mModel = userProfile;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemUserInfoNumBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UserProfile userProfile = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = userProfile == null;
            if (i2 != 0) {
                j = z ? j | 16 | 64 | 256 : j | 8 | 32 | 128;
            }
        } else {
            z = false;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((128 & j) != 0) {
            str = String.valueOf(userProfile != null ? userProfile.getFeedNum() : 0);
        } else {
            str = null;
        }
        if ((8 & j) != 0) {
            str2 = String.valueOf(userProfile != null ? userProfile.getFollowNum() : 0);
        } else {
            str2 = null;
        }
        if ((32 & j) != 0) {
            if (userProfile != null) {
                i = userProfile.getFansNum();
            }
            str3 = String.valueOf(i);
        } else {
            str3 = null;
        }
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (z) {
                str2 = "0";
            }
            if (z) {
                str3 = "0";
            }
            if (z) {
                str = "0";
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.text1, str);
            TextViewBindingAdapter.setText(this.text2, str2);
            TextViewBindingAdapter.setText(this.text3, str3);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.userFansItem, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userFeedItem, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userFollowItem, onClickListener, bool);
        }
    }
}
