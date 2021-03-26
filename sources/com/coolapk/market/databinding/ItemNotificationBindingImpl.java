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
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Notification;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemNotificationBindingImpl extends ItemNotificationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemNotificationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemNotificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (TextView) objArr[5], (TextView) objArr[3], (UserAvatarView) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.infoView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
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
            setModel((Notification) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationBinding
    public void setModel(Notification notification) {
        this.mModel = notification;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationBinding
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
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        UserInfo userInfo;
        String str8;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Notification notification = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean z = false;
            if (notification != null) {
                i = notification.getIsNew();
                str8 = notification.getFromUserAvatar();
                userInfo = notification.getFromUserInfo();
                str7 = notification.getFromUserName();
                str6 = notification.getNote();
            } else {
                str8 = null;
                userInfo = null;
                str7 = null;
                str6 = null;
                i = 0;
            }
            if (i > 0) {
                z = true;
            }
            if (i2 != 0) {
                j |= z ? 32 : 16;
            }
            if (userInfo != null) {
                str4 = userInfo.getVerifyStatusIcon();
            } else {
                str4 = null;
            }
            str = str8;
            str3 = str6;
            str2 = z ? "colorAccent" : "textColorSecondary";
            str5 = str7;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 12) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 9) != 0) {
            ThemeBindingAdapters.setTextColor(this.infoView, str2);
            Boolean bool2 = null;
            String str9 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str3, null, str2, bool2, null, str9);
            TextViewBindingAdapters.setDatelineByEntity(this.mboundView4, notification);
            TextViewBindingAdapter.setText(this.titleView, str5);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str9, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool2);
        }
    }
}
