package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;

public class ItemFeedCoverViewBindingImpl extends ItemFeedCoverViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AutoLinkTextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362657, 7);
        sparseIntArray.put(2131363223, 8);
        sparseIntArray.put(2131362423, 9);
        sparseIntArray.put(2131363604, 10);
        sparseIntArray.put(2131363030, 11);
        sparseIntArray.put(2131363551, 12);
        sparseIntArray.put(2131363212, 13);
        sparseIntArray.put(2131363243, 14);
        sparseIntArray.put(2131362676, 15);
    }

    public ItemFeedCoverViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemFeedCoverViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (DividerLineView) objArr[9], (ImageView) objArr[3], (FeedActionView2) objArr[4], (ForegroundTextView) objArr[6], (Space) objArr[7], (Space) objArr[15], (CardView) objArr[2], (Space) objArr[11], (Space) objArr[13], (Space) objArr[8], (Space) objArr[14], (CoolEllipsizeTextView) objArr[12], (CoolEllipsizeTextView) objArr[10]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.extraImageView.setTag(null);
        this.feedActionView.setTag(null);
        this.foregroundTextView.setTag(null);
        this.imageCardView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[5];
        this.mboundView5 = autoLinkTextView;
        autoLinkTextView.setTag(null);
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
        } else if (158 == i) {
            setImageUrl((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedCoverViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedCoverViewBinding
    public void setImageUrl(String str) {
        this.mImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(158);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedCoverViewBinding
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
        int i;
        int i2;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        String str2 = this.mImageUrl;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = 0;
        int i5 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i5 != 0) {
            String adminInfo = feed != null ? feed.getAdminInfo() : null;
            boolean isEmpty = TextUtils.isEmpty(adminInfo);
            if (i5 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            str = adminInfo;
            i = isEmpty ? 8 : 0;
        } else {
            str = null;
            i = 0;
        }
        int i6 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean isEmpty2 = TextUtils.isEmpty(str2);
            if (i6 != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            if (isEmpty2) {
                i4 = 8;
            }
            i2 = i4;
        } else {
            i2 = 0;
        }
        if ((12 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((j & 10) != 0) {
            Boolean bool = null;
            i3 = i;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extraImageView, str2, null, 2131231702, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            this.imageCardView.setVisibility(i2);
        } else {
            i3 = i;
        }
        if ((8 & j) != 0) {
            ViewBindingAdapters.clipView(this.extraImageView, null, 8);
        }
        if ((j & 9) != 0) {
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            ViewBindingAdapters.updateFeed(this.foregroundTextView, feed);
            this.mboundView5.setVisibility(i3);
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView5, str, null, str3, null, null, str3);
        }
    }
}
