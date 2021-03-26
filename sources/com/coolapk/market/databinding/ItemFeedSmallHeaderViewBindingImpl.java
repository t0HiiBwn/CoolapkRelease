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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemFeedSmallHeaderViewBindingImpl extends ItemFeedSmallHeaderViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFeedSmallHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemFeedSmallHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[3], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.infoView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
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
            setModel((Feed) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedSmallHeaderViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedSmallHeaderViewBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedSmallHeaderViewBinding
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
        View.OnClickListener onClickListener;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        int i = ((11 & j) > 0 ? 1 : ((11 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if ((j & 9) != 0) {
                if (feed != null) {
                    str4 = feed.getUserName();
                    str3 = feed.getInfo();
                    userInfo = feed.getUserInfo();
                } else {
                    str4 = null;
                    str3 = null;
                    userInfo = null;
                }
                str2 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
            }
            str = feed != null ? feed.getUserAvatar() : null;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((j & 9) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str3);
            TextViewBindingAdapter.setText(this.nameView, str4);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str2, null);
        }
        if (i != 0) {
            Boolean bool = null;
            onClickListener = onClickListener2;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
        } else {
            onClickListener = onClickListener2;
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, null);
        }
    }
}
