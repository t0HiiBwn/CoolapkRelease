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
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemSimpleUserViewBindingImpl extends ItemSimpleUserViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemSimpleUserViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSimpleUserViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (UserAvatarView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        this.titleView.setTag(null);
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
            setModel((User) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSimpleUserViewBinding
    public void setModel(User user) {
        this.mModel = user;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSimpleUserViewBinding
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
        String str2;
        String str3;
        String str4;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        User user = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (user != null) {
                str2 = user.getUserName();
                str4 = user.getUserAvatar();
                userInfo = user.getUserInfo();
            } else {
                userInfo = null;
                str2 = null;
                str4 = null;
            }
            if (userInfo != null) {
                str3 = userInfo.getVerifyStatusIcon();
                str = str4;
            } else {
                str = str4;
                str3 = null;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            ImageViewBindingAdapters.setVipSignView(this.iconView, str3, bool);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
