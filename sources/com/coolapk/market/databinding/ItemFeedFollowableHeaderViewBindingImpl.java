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

public class ItemFeedFollowableHeaderViewBindingImpl extends ItemFeedFollowableHeaderViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView3;
    private final ImageView mboundView5;
    private final TextView mboundView6;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"feed_warning"}, new int[]{9}, new int[]{2131558566});
    }

    public ItemFeedFollowableHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemFeedFollowableHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FeedWarningBinding) objArr[9], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[4], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.followView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.mboundView5 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        this.modifyView.setTag(null);
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
        if (this.alertView.hasPendingBindings()) {
            return true;
        }
        return false;
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

    @Override // com.coolapk.market.databinding.ItemFeedFollowableHeaderViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedFollowableHeaderViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        String str5;
        Boolean bool;
        UserInfo userInfo;
        int i4;
        String str6;
        String str7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i5 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (feed != null) {
                str5 = feed.getUserName();
                str6 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                str2 = feed.getDeviceTitle();
                i4 = feed.getIsModified();
            } else {
                str5 = null;
                str6 = null;
                i4 = 0;
                userInfo = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean z = true;
            if (i4 != 1) {
                z = false;
            }
            if (i5 != 0) {
                j |= isEmpty ? 128 : 64;
            }
            if ((j & 10) != 0) {
                j |= z ? 32 : 16;
            }
            if (userInfo != null) {
                str8 = userInfo.getVerifyStatusIcon();
                str7 = userInfo.getVerifyLabel();
            } else {
                str8 = null;
                str7 = null;
            }
            int i6 = isEmpty ? 8 : 0;
            i = z ? 0 : 8;
            boolean isEmpty2 = TextUtils.isEmpty(str7);
            if ((j & 10) != 0) {
                j |= isEmpty2 ? 512 : 256;
            }
            str = str6;
            str3 = str7;
            i3 = i6;
            str4 = str8;
            i2 = isEmpty2 ? 8 : 0;
        } else {
            str5 = null;
            i3 = 0;
            i2 = 0;
            i = 0;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i7 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((j & 8) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.followView, "colorAccent");
            bool = null;
            ViewBindingAdapters.clipView(this.followView, null, 13);
        } else {
            bool = null;
        }
        if (i7 != 0) {
            Boolean bool2 = bool;
            ViewBindingAdapters.clickListener(this.followView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.modifyView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str3);
            this.mboundView3.setVisibility(i2);
            this.mboundView5.setVisibility(i3);
            TextViewBindingAdapter.setText(this.mboundView6, str2);
            this.mboundView6.setVisibility(i3);
            this.modifyView.setVisibility(i);
            TextViewBindingAdapter.setText(this.nameView, str5);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool3, bool3, bool3, bool3, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str4, bool3);
        }
        executeBindingsOn(this.alertView);
    }
}
