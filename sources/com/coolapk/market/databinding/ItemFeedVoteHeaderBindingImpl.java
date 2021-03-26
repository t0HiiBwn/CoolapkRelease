package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;

public class ItemFeedVoteHeaderBindingImpl extends ItemFeedVoteHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362068, 8);
        sparseIntArray.put(2131363582, 9);
        sparseIntArray.put(2131362093, 10);
        sparseIntArray.put(2131362376, 11);
        sparseIntArray.put(2131363949, 12);
        sparseIntArray.put(2131363950, 13);
        sparseIntArray.put(2131363948, 14);
        sparseIntArray.put(2131363951, 15);
        sparseIntArray.put(2131363944, 16);
        sparseIntArray.put(2131362058, 17);
        sparseIntArray.put(2131362059, 18);
        sparseIntArray.put(2131362417, 19);
    }

    public ItemFeedVoteHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ItemFeedVoteHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[7], (LinearLayout) objArr[6], (ImageView) objArr[17], (TextView) objArr[18], (Space) objArr[8], (LinearLayout) objArr[10], (TextView) objArr[11], (FrameLayout) objArr[4], (View) objArr[19], (TextView) objArr[5], (TextView) objArr[9], (UserAvatarView) objArr[1], (TextView) objArr[2], (LinearLayout) objArr[16], (TextView) objArr[14], (LinearLayout) objArr[12], (TextView) objArr[13], (FrameLayout) objArr[15]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.anonymousCheckContainer.setTag(null);
        this.descriptionViewContainer.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.timeView.setTag(null);
        this.userAvatarView.setTag(null);
        this.userNameView.setTag(null);
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
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteHeaderBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteHeaderBinding
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
        Long l2;
        String str3;
        String str4;
        UserInfo userInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (feed != null) {
                l2 = feed.getDateline();
                str2 = feed.getUserName();
                str4 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
            } else {
                userInfo = null;
                l2 = null;
                str2 = null;
                str4 = null;
            }
            str3 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            str = str4;
        } else {
            str3 = null;
            l2 = null;
            str2 = null;
            str = null;
        }
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.anonymousCheckContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.descriptionViewContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.timeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.actionView, null, 3);
        }
        if (i != 0) {
            TextViewBindingAdapters.setTime(this.mboundView3, l2);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
            TextViewBindingAdapter.setText(this.userNameView, str2);
        }
    }
}
