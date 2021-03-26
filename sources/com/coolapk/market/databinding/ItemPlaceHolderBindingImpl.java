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
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemPlaceHolderBindingImpl extends ItemPlaceHolderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemPlaceHolderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemPlaceHolderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (UserAvatarView) objArr[3], (TextView) objArr[6], (LinearLayout) objArr[1], (TextView) objArr[5], (LinearLayout) objArr[2]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.deleteView.setTag(null);
        this.itemView.setTag(null);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.titleView.setTag(null);
        this.userInfo.setTag(null);
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
        if (198 == i) {
            setModel((ItemPlaceHolder) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemPlaceHolderBinding
    public void setModel(ItemPlaceHolder itemPlaceHolder) {
        this.mModel = itemPlaceHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPlaceHolderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemPlaceHolderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        View.OnClickListener onClickListener;
        String str5;
        String str6;
        int i2;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ItemPlaceHolder itemPlaceHolder = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        int i3 = 0;
        if ((j & 11) != 0) {
            int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (itemPlaceHolder != null) {
                    userInfo = itemPlaceHolder.getUserInfo();
                    str9 = itemPlaceHolder.getShowUserName();
                    str8 = itemPlaceHolder.getTitle();
                    z = itemPlaceHolder.isMe();
                } else {
                    userInfo = null;
                    str9 = null;
                    str8 = null;
                    z = false;
                }
                if (i4 != 0) {
                    j |= z ? 32 : 16;
                }
                str10 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
                if (!z) {
                    i3 = 8;
                }
            } else {
                str10 = null;
                str9 = null;
                str8 = null;
            }
            if (itemPlaceHolder != null) {
                str4 = itemPlaceHolder.getDisplayUserAvatar();
                str2 = str10;
                str = str9;
            } else {
                str2 = str10;
                str = str9;
                str4 = null;
            }
            i = i3;
            str3 = str8;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        int i5 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((11 & j) != 0) {
            str7 = str3;
            Boolean bool = null;
            i2 = i;
            str6 = str;
            str5 = str2;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str4, null, 2131231162, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        } else {
            str7 = str3;
            onClickListener = onClickListener2;
            str5 = str2;
            i2 = i;
            str6 = str;
        }
        if ((j & 9) != 0) {
            ImageViewBindingAdapters.setVipSignView(this.avatarView, str5, null);
            this.deleteView.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView4, str6);
            TextViewBindingAdapter.setText(this.titleView, str7);
        }
        if (i5 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.deleteView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userInfo, onClickListener, bool2);
        }
    }
}
