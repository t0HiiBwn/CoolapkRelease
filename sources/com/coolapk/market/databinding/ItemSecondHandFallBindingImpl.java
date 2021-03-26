package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemSecondHandFallBindingImpl extends ItemSecondHandFallBinding {
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
        sparseIntArray.put(2131362602, 8);
        sparseIntArray.put(2131363358, 9);
        sparseIntArray.put(2131363155, 10);
        sparseIntArray.put(2131362481, 11);
        sparseIntArray.put(2131363380, 12);
        sparseIntArray.put(2131362744, 13);
    }

    public ItemSecondHandFallBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemSecondHandFallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (UserAvatarView) objArr[6], (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (TextView) objArr[11], (FrameLayout) objArr[8], (TextView) objArr[13], (ScalingImageView) objArr[2], (TextView) objArr[10], (ImageView) objArr[9], (ImageView) objArr[5], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[7]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.picView.setTag(null);
        this.signLink.setTag(null);
        this.titleTagView.setTag(null);
        this.titleView.setTag(null);
        this.userName.setTag(null);
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
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandFallBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandFallBinding
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
        String str5;
        String str6;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                str6 = feed.getMessageTitle();
                str4 = feed.getUserName();
                str5 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                str7 = feed.getThumbnailPic();
            } else {
                str7 = null;
                str6 = null;
                str4 = null;
                str5 = null;
                userInfo = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str6);
            if (i2 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if (userInfo != null) {
                str3 = userInfo.getVerifyStatusIcon();
            } else {
                str3 = null;
            }
            if (isEmpty) {
                i = 8;
            }
            str2 = str7;
            str = str5;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            Drawable drawable = null;
            Boolean bool = null;
            String str8 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, drawable, 2131231162, 0, bool, bool, bool, bool, bool, str8, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            ImageViewBindingAdapters.setVipSignView(this.avatarView, str3, bool);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.picView, str2, drawable, 0, 0, bool, bool, bool, true, bool, str8, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            this.titleView.setVisibility(i);
            TextViewBindingAdapter.setText(this.userName, str4);
        }
        if (i3 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool2);
        }
        if ((j & 4) != 0) {
            String str9 = null;
            ViewBindingAdapters.clipView(this.signLink, str9, 2);
            ViewBindingAdapters.clipView(this.titleTagView, str9, 3);
        }
    }
}
