package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.ShapedImageView;

public class ItemCoolpicFallBindingImpl extends ItemCoolpicFallBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoolapkCardView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362993, 7);
    }

    public ItemCoolpicFallBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemCoolpicFallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ShapedImageView) objArr[2], (FrameLayout) objArr[1], (ImageView) objArr[7], (TextView) objArr[6], (CoolEllipsizeTextView) objArr[3], (UserAvatarView) objArr[5], (LinearLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        this.itemView.setTag(null);
        CoolapkCardView coolapkCardView = (CoolapkCardView) objArr[0];
        this.mboundView0 = coolapkCardView;
        coolapkCardView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userInfoView.setTag(null);
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
        if (104 == i) {
            setFeed((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCoolpicFallBinding
    public void setFeed(Feed feed) {
        this.mFeed = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(104);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCoolpicFallBinding
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
        String str5;
        UserInfo userInfo;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mFeed;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (feed != null) {
                str7 = feed.getThumbnailPic();
                str5 = feed.getUserName();
                str6 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                str8 = feed.getMessage();
            } else {
                str8 = null;
                str7 = null;
                str5 = null;
                str6 = null;
                userInfo = null;
            }
            if (userInfo != null) {
                str4 = userInfo.getVerifyStatusIcon();
                str3 = str8;
                str2 = str7;
            } else {
                str3 = str8;
                str2 = str7;
                str4 = null;
            }
            str = str6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i != 0) {
            Boolean bool = null;
            String str9 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.imageView, str2, AppCompatResources.getDrawable(this.imageView.getContext(), 2131231691), 0, 0, bool, bool, bool, true, bool, str9, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            TextViewBindingAdapter.setText(this.timeView, str5);
            TextViewBindingAdapters.setTextViewLinkable(this.titleView, str3, null, str9, bool, null, str9);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool, bool, bool, bool, bool, str9, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool);
        }
        if (i2 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userInfoView, onClickListener, bool2);
        }
    }
}
