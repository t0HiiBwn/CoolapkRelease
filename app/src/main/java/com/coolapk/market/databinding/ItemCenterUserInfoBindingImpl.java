package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.widget.RoundProgress;
import com.coolapk.market.widget.UserAvatarView;

public class ItemCenterUserInfoBindingImpl extends ItemCenterUserInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363877, 4);
        sparseIntArray.put(2131363000, 5);
        sparseIntArray.put(2131362839, 6);
        sparseIntArray.put(2131362347, 7);
        sparseIntArray.put(2131362051, 8);
        sparseIntArray.put(2131363146, 9);
    }

    public ItemCenterUserInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemCenterUserInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (TextView) objArr[7], (LinearLayout) objArr[6], (TextView) objArr[2], (TextView) objArr[5], (RoundProgress) objArr[9], (ImageView) objArr[3], (UserAvatarView) objArr[4], (LinearLayout) objArr[1]);
        this.mDirtyFlags = -1;
        this.levelTextView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.qrCodeView.setTag(null);
        this.userInfoItem.setTag(null);
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
        if (197 == i) {
            setModel((UserProfile) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCenterUserInfoBinding
    public void setModel(UserProfile userProfile) {
        this.mModel = userProfile;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCenterUserInfoBinding
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
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UserProfile userProfile = this.mModel;
        int i = 0;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (userProfile != null) {
                i = userProfile.getLevel();
            }
            str = ("Lv." + i) + " ";
        } else {
            str = null;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.levelTextView, str);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.qrCodeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userInfoItem, onClickListener, bool);
        }
    }
}
