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
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemFeedVoteCommentSmallBindingImpl extends ItemFeedVoteCommentSmallBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363982, 8);
        sparseIntArray.put(2131363551, 9);
        sparseIntArray.put(2131362853, 10);
        sparseIntArray.put(2131362292, 11);
    }

    public ItemFeedVoteCommentSmallBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemFeedVoteCommentSmallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (ImageView) objArr[11], (TextView) objArr[6], (LinearLayout) objArr[5], (ImageView) objArr[10], (TextView) objArr[4], (LinearLayout) objArr[3], (CoolEllipsizeTextView) objArr[9], (UserAvatarView) objArr[1], (ImageView) objArr[8]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.likeNum.setTag(null);
        this.likeView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.mboundView7 = textView2;
        textView2.setTag(null);
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
            setModel((Feed) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentSmallBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentSmallBinding
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
        boolean z;
        Long l;
        int i;
        int i2;
        String str4;
        String str5;
        UserInfo userInfo;
        String str6;
        String str7;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = 0;
        int i5 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (feed != null) {
                i = feed.getLikeNum();
                l = feed.getDateline();
                str7 = feed.getUserName();
                str6 = feed.getUserAvatar();
                userInfo = feed.getUserInfo();
                i3 = feed.getReplyNum();
            } else {
                l = null;
                str7 = null;
                str6 = null;
                userInfo = null;
                i3 = 0;
                i = 0;
            }
            z = i > 0;
            if (i3 > 0) {
                i4 = 1;
            }
            if (i5 != 0) {
                j = z ? j | 16 : j | 8;
            }
            if ((j & 5) != 0) {
                j = i4 != 0 ? j | 64 : j | 32;
            }
            str3 = userInfo != null ? userInfo.getVerifyStatusIcon() : null;
            str2 = str7;
            str = str6;
            i4 = i3;
            i2 = i4;
        } else {
            l = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
            z = false;
        }
        int i6 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((64 & j) != 0) {
            str4 = "" + i4;
        } else {
            str4 = null;
        }
        if ((16 & j) != 0) {
            str5 = "" + i;
        } else {
            str5 = null;
        }
        int i7 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (!z) {
                str5 = "";
            }
            if (i2 == 0) {
                str4 = "";
            }
        } else {
            str5 = null;
            str4 = null;
        }
        if (i6 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.mboundView2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.cardView, null, 8);
        }
        if (i7 != 0) {
            TextViewBindingAdapter.setText(this.commentNum, str4);
            TextViewBindingAdapter.setText(this.likeNum, str5);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapters.setTime(this.mboundView7, l);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool2);
        }
    }
}
