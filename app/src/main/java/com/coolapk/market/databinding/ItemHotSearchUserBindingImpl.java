package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemHotSearchUserBindingImpl extends ItemHotSearchUserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363437, 3);
    }

    public ItemHotSearchUserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemHotSearchUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (UserAvatarView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
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
        if (197 == i) {
            setModel((User) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (211 != i) {
            return false;
        } else {
            setOnClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemHotSearchUserBinding
    public void setModel(User user) {
        this.mModel = user;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemHotSearchUserBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemHotSearchUserBinding
    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(211);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        User user = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener = this.mOnClick;
        int i = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if ((j & 9) != 0) {
                if (user != null) {
                    str7 = user.getUserName();
                    userInfo = user.getUserInfo();
                } else {
                    str7 = null;
                    userInfo = null;
                }
                str6 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            } else {
                str7 = null;
                str6 = null;
            }
            if (user != null) {
                str3 = user.getUserAvatar();
                str2 = str7;
                str = str6;
            } else {
                str2 = str7;
                str = str6;
                str3 = null;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((12 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if (i != 0) {
            Boolean bool = null;
            str5 = str;
            str4 = str2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str3, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        } else {
            str4 = str2;
            str5 = str;
        }
        if ((j & 9) != 0) {
            ImageViewBindingAdapters.setVipSignView(this.iconView, str5, null);
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
    }
}
