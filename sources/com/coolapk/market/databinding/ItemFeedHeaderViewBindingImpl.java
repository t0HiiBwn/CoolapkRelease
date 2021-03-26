package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public class ItemFeedHeaderViewBindingImpl extends ItemFeedHeaderViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView4;
    private final ImageView mboundView7;
    private final TextView mboundView8;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"feed_top", "feed_warning"}, new int[]{10, 11}, new int[]{2131558562, 2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363605, 12);
    }

    public ItemFeedHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ItemFeedHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FeedWarningBinding) objArr[11], (EllipsizeTextView) objArr[6], (TextView) objArr[9], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[5], (View) objArr[12], (FeedTopBinding) objArr[10], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.fromWhereView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[7];
        this.mboundView7 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.mboundView8 = textView2;
        textView2.setTag(null);
        this.modifyView.setTag(null);
        this.moreView.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
        setContainedBinding(this.topView);
        this.userAvatarView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.topView.invalidateAll();
        this.alertView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.topView.hasPendingBindings() && !this.alertView.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedHeaderViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedHeaderViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.topView.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeTopView((FeedTopBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeTopView(FeedTopBinding feedTopBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        int i3;
        int i4;
        String str5;
        Boolean bool;
        String str6;
        UserInfo userInfo;
        String str7;
        int i5;
        boolean z;
        String str8;
        String str9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i6 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (feed != null) {
                str5 = feed.getUserName();
                z = feed.showFromView();
                str7 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                str6 = feed.getDeviceTitle();
                i5 = feed.getIsModified();
            } else {
                str5 = null;
                z = false;
                i5 = 0;
                str7 = null;
                userInfo = null;
                str6 = null;
            }
            if (i6 != 0) {
                j |= z ? 64 : 32;
            }
            int i7 = z ? 0 : 8;
            boolean isEmpty = TextUtils.isEmpty(str6);
            boolean z2 = true;
            if (i5 != 1) {
                z2 = false;
            }
            if ((j & 20) != 0) {
                j |= isEmpty ? 1024 : 512;
            }
            if ((j & 20) != 0) {
                j |= z2 ? 256 : 128;
            }
            if (userInfo != null) {
                str9 = userInfo.getVerifyStatusIcon();
                str8 = userInfo.getVerifyLabel();
            } else {
                str9 = null;
                str8 = null;
            }
            int i8 = isEmpty ? 8 : 0;
            int i9 = z2 ? 0 : 8;
            boolean isEmpty2 = TextUtils.isEmpty(str8);
            if ((j & 20) != 0) {
                j |= isEmpty2 ? 4096 : 2048;
            }
            str4 = str8;
            str = str6;
            str3 = str9;
            i3 = i7;
            i4 = isEmpty2 ? 8 : 0;
            i = i9;
            i2 = i8;
            str2 = str7;
        } else {
            str5 = null;
            i4 = 0;
            i3 = 0;
            str4 = null;
            i2 = 0;
            i = 0;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i10 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if ((20 & j) != 0) {
            this.fromWhereView.setVisibility(i3);
            TextViewBindingAdapter.setText(this.mboundView4, str4);
            this.mboundView4.setVisibility(i4);
            this.mboundView7.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView8, str);
            this.mboundView8.setVisibility(i2);
            this.modifyView.setVisibility(i);
            TextViewBindingAdapter.setText(this.nameView, str5);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            bool = null;
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str2, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
        } else {
            bool = null;
        }
        if (i10 != 0) {
            Boolean bool3 = bool;
            ViewBindingAdapters.clickListener(this.fromWhereView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.modifyView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool3);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool3);
        }
        if ((j & 16) != 0) {
            ThemeBindingAdapters.setTextColor(this.modifyView, "colorAccent");
        }
        executeBindingsOn(this.topView);
        executeBindingsOn(this.alertView);
    }
}
