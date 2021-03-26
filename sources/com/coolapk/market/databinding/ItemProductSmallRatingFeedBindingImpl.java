package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
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

public class ItemProductSmallRatingFeedBindingImpl extends ItemProductSmallRatingFeedBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363208, 11);
        sparseIntArray.put(2131363295, 12);
        sparseIntArray.put(2131362636, 13);
        sparseIntArray.put(2131362113, 14);
        sparseIntArray.put(2131362612, 15);
        sparseIntArray.put(2131362853, 16);
        sparseIntArray.put(2131362292, 17);
    }

    public ItemProductSmallRatingFeedBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ItemProductSmallRatingFeedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolEllipsizeTextView) objArr[14], (ImageView) objArr[17], (TextView) objArr[10], (LinearLayout) objArr[9], (CoolEllipsizeTextView) objArr[15], (CoolEllipsizeTextView) objArr[13], (LinearLayout) objArr[0], (ImageView) objArr[16], (TextView) objArr[8], (LinearLayout) objArr[7], (TextView) objArr[2], (RatingBar) objArr[11], (TextView) objArr[12], (TextView) objArr[6], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.itemView.setTag(null);
        this.likeNum.setTag(null);
        this.likeView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.mboundView5 = textView3;
        textView3.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemProductSmallRatingFeedBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSmallRatingFeedBinding
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
        boolean z;
        int i;
        String str3;
        int i2;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        UserInfo userInfo;
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
                i2 = feed.getLikeNum();
                userInfo = feed.getUserInfo();
                i3 = feed.getReplyNum();
                str7 = feed.getUserName();
                str6 = feed.getUserAvatar();
            } else {
                userInfo = null;
                str7 = null;
                str6 = null;
                i2 = 0;
                i3 = 0;
            }
            z = i2 > 0;
            if (i3 > 0) {
                i4 = 1;
            }
            if (i5 != 0) {
                j = z ? j | 16 : j | 8;
            }
            if ((j & 5) != 0) {
                j = i4 != 0 ? j | 64 : j | 32;
            }
            if (userInfo != null) {
                str3 = userInfo.getVerifyStatusIcon();
                i = i4;
            } else {
                i = i4;
                str3 = null;
            }
            i4 = i3;
            str2 = str7;
            str = str6;
        } else {
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
            str5 = "" + i2;
        } else {
            str5 = null;
        }
        int i7 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (!z) {
                str5 = "";
            }
            if (i == 0) {
                str4 = "";
            }
        } else {
            str5 = null;
            str4 = null;
        }
        if (i7 != 0) {
            TextViewBindingAdapter.setText(this.commentNum, str4);
            TextViewBindingAdapter.setText(this.likeNum, str5);
            TextViewBindingAdapter.setText(this.nameView, str2);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            ImageViewBindingAdapters.setVipSignView(this.userAvatarView, str3, bool);
        }
        if (i6 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.commentView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.likeView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool2);
        }
        if ((j & 4) != 0) {
            String str8 = null;
            ViewBindingAdapters.clipView(this.itemView, str8, 4);
            ViewBindingAdapters.clipView(this.mboundView3, str8, 3);
            ViewBindingAdapters.clipView(this.mboundView4, str8, 3);
            ViewBindingAdapters.clipView(this.mboundView5, str8, 3);
        }
    }
}
