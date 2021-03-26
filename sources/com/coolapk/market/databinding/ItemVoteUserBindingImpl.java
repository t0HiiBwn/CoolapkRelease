package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemVoteUserBindingImpl extends ItemVoteUserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemVoteUserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemVoteUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.loginTimeView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
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
        if (197 != i) {
            return false;
        }
        setModel((User) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemVoteUserBinding
    public void setModel(User user) {
        this.mModel = user;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        Long l2;
        String str3;
        String str4;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        User user = this.mModel;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (user != null) {
                l2 = user.getDateline();
                str2 = user.getUserName();
                str4 = user.getUserAvatar();
                userInfo = user.getUserInfo();
            } else {
                userInfo = null;
                l2 = null;
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
            l2 = null;
            str2 = null;
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapters.setTime(this.loginTimeView, l2);
            TextViewBindingAdapter.setText(this.titleView, str2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool);
        }
    }
}
