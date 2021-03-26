package com.coolapk.market.databinding;

import android.text.TextUtils;
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

public class ItemProductSmallRatingArticleBindingImpl extends ItemProductSmallRatingArticleBinding {
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
        sparseIntArray.put(2131363208, 9);
        sparseIntArray.put(2131363295, 10);
        sparseIntArray.put(2131363551, 11);
        sparseIntArray.put(2131362853, 12);
        sparseIntArray.put(2131362292, 13);
    }

    public ItemProductSmallRatingArticleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemProductSmallRatingArticleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[13], (TextView) objArr[8], (LinearLayout) objArr[7], (LinearLayout) objArr[0], (ImageView) objArr[12], (TextView) objArr[6], (LinearLayout) objArr[5], (TextView) objArr[2], (RatingBar) objArr[9], (TextView) objArr[10], (CoolEllipsizeTextView) objArr[11], (TextView) objArr[4], (TextView) objArr[3], (UserAvatarView) objArr[1]);
        this.mDirtyFlags = -1;
        this.commentNum.setTag(null);
        this.commentView.setTag(null);
        this.itemView.setTag(null);
        this.likeNum.setTag(null);
        this.likeView.setTag(null);
        this.nameView.setTag(null);
        this.timeView.setTag(null);
        this.titleView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemProductSmallRatingArticleBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSmallRatingArticleBinding
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
        int i;
        boolean z;
        boolean z2;
        int i2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i3;
        UserInfo userInfo;
        String str9;
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
                str4 = feed.getMessageTitle();
                i2 = feed.getLikeNum();
                userInfo = feed.getUserInfo();
                i3 = feed.getReplyNum();
                str8 = feed.getUserName();
                str7 = feed.getUserAvatar();
            } else {
                str4 = null;
                userInfo = null;
                str8 = null;
                str7 = null;
                i2 = 0;
                i3 = 0;
            }
            boolean isEmpty = TextUtils.isEmpty(str4);
            z2 = true;
            z = i2 > 0;
            if (i3 <= 0) {
                z2 = false;
            }
            if (i5 != 0) {
                j |= isEmpty ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j = z ? j | 16 : j | 8;
            }
            if ((j & 5) != 0) {
                j = z2 ? j | 64 : j | 32;
            }
            if (userInfo != null) {
                str9 = userInfo.getVerifyStatusIcon();
            } else {
                str9 = null;
            }
            if (isEmpty) {
                i4 = 8;
            }
            i = i4;
            str3 = str9;
            i4 = i3;
            str2 = str8;
            str = str7;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i2 = 0;
            z2 = false;
            z = false;
            i = 0;
        }
        int i6 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((64 & j) != 0) {
            str5 = "" + i4;
        } else {
            str5 = null;
        }
        if ((16 & j) != 0) {
            str6 = "" + i2;
        } else {
            str6 = null;
        }
        int i7 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (!z) {
                str6 = "";
            }
            if (!z2) {
                str5 = "";
            }
        } else {
            str6 = null;
            str5 = null;
        }
        if (i7 != 0) {
            TextViewBindingAdapter.setText(this.commentNum, str5);
            TextViewBindingAdapter.setText(this.likeNum, str6);
            TextViewBindingAdapter.setText(this.nameView, str2);
            TextViewBindingAdapters.setDatelineByEntity(this.timeView, feed);
            TextViewBindingAdapter.setText(this.titleView, str4);
            this.titleView.setVisibility(i);
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
            ViewBindingAdapters.clipView(this.itemView, null, 4);
        }
    }
}
