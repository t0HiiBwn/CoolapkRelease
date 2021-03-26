package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.UserAvatarView;

public class ItemFeedReplyBindingImpl extends ItemFeedReplyBinding {
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
        sparseIntArray.put(2131363604, 9);
        sparseIntArray.put(2131362585, 10);
        sparseIntArray.put(2131362498, 11);
        sparseIntArray.put(2131363256, 12);
        sparseIntArray.put(2131363255, 13);
        sparseIntArray.put(2131362853, 14);
        sparseIntArray.put(2131362292, 15);
        sparseIntArray.put(2131362868, 16);
    }

    public ItemFeedReplyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ItemFeedReplyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[15], (TextView) objArr[6], (LinearLayout) objArr[5], (FrameLayout) objArr[11], (ImageView) objArr[10], (TextView) objArr[2], (ImageView) objArr[14], (TextView) objArr[4], (LinearLayout) objArr[3], (LinearAdapterLayout) objArr[16], (TextView) objArr[8], (TextView) objArr[13], (LinearLayout) objArr[12], (LinearLayout) objArr[7], (TextView) objArr[9], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.infoView.setTag(null);
        this.likeNum.setTag(null);
        this.likeView.setTag(null);
        this.moreSubReplyView.setTag(null);
        this.subReplyContainer.setTag(null);
        this.userAvatarView.setTag(null);
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
            setModel((FeedReply) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedReplyBinding
    public void setModel(FeedReply feedReply) {
        this.mModel = feedReply;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedReplyBinding
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
        boolean z;
        boolean z2;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        String str5;
        String str6;
        int i3;
        UserInfo userInfo;
        String str7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedReply feedReply = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feedReply != null) {
                i = feedReply.getLikeNum();
                userInfo = feedReply.getUserInfo();
                i3 = feedReply.getReplyNum();
                str6 = feedReply.getMessage();
                str7 = feedReply.getUserAvatar();
            } else {
                str7 = null;
                userInfo = null;
                str6 = null;
                i = 0;
                i3 = 0;
            }
            z2 = true;
            z = i > 0;
            if (i3 <= 0) {
                z2 = false;
            }
            if (i4 != 0) {
                j = z ? j | 16 : j | 8;
            }
            if ((j & 5) != 0) {
                j = z2 ? j | 64 : j | 32;
            }
            if (userInfo != null) {
                str3 = userInfo.getVerifyStatusIcon();
                str = str7;
            } else {
                str = str7;
                str3 = null;
            }
            i2 = i3;
            str2 = str6;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
            z2 = false;
            z = false;
        }
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((64 & j) != 0) {
            str4 = "" + i2;
        } else {
            str4 = null;
        }
        if ((16 & j) != 0) {
            str5 = "" + i;
        } else {
            str5 = null;
        }
        int i6 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (!z) {
                str5 = "";
            }
            if (!z2) {
                str4 = "";
            }
        } else {
            str4 = null;
            str5 = null;
        }
        if (i5 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.subReplyContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if (i6 != 0) {
            TextViewBindingAdapter.setText(this.commentNum, str4);
            String str8 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.infoView, str2, null, str8, false, null, str8);
            TextViewBindingAdapter.setText(this.likeNum, str5);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, str8, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
        }
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setTextColor(this.moreSubReplyView, "colorAccent");
        }
    }
}
