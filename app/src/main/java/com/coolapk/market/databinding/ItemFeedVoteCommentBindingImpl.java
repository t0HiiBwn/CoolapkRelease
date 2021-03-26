package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public class ItemFeedVoteCommentBindingImpl extends ItemFeedVoteCommentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AutoLinkTextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 5);
        sparseIntArray.put(2131363533, 6);
        sparseIntArray.put(2131363016, 7);
        sparseIntArray.put(2131363947, 8);
        sparseIntArray.put(2131363229, 9);
    }

    public ItemFeedVoteCommentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemFeedVoteCommentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (FeedActionView2) objArr[2], (ForegroundTextView) objArr[4], (Space) objArr[5], (Space) objArr[7], (Space) objArr[9], (TextView) objArr[6], (Space) objArr[8]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        this.foregroundTextView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[3];
        this.mboundView3 = autoLinkTextView;
        autoLinkTextView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            String adminInfo = feed != null ? feed.getAdminInfo() : null;
            boolean isEmpty = TextUtils.isEmpty(adminInfo);
            if (i2 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if (isEmpty) {
                i = 8;
            }
            str = adminInfo;
        } else {
            str = null;
        }
        if ((6 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            ViewBindingAdapters.updateFeed(this.foregroundTextView, feed);
            this.mboundView3.setVisibility(i);
            String str2 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView3, str, null, str2, null, null, str2);
        }
    }
}
