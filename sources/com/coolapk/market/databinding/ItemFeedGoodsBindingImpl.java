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
import com.coolapk.market.widget.view.BadBadRatingBar;

public class ItemFeedGoodsBindingImpl extends ItemFeedGoodsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final AutoLinkTextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 6);
        sparseIntArray.put(2131363194, 7);
        sparseIntArray.put(2131362190, 8);
        sparseIntArray.put(2131363533, 9);
        sparseIntArray.put(2131363016, 10);
        sparseIntArray.put(2131362631, 11);
        sparseIntArray.put(2131363229, 12);
        sparseIntArray.put(2131362665, 13);
    }

    public ItemFeedGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ItemFeedGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (LinearLayout) objArr[3], (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (FeedActionView2) objArr[4], (Space) objArr[11], (Space) objArr[6], (Space) objArr[13], (Space) objArr[10], (BadBadRatingBar) objArr[7], (Space) objArr[12], (TextView) objArr[9]);
        this.mDirtyFlags = -1;
        this.buyView.setTag(null);
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[5];
        this.mboundView5 = autoLinkTextView;
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

    @Override // com.coolapk.market.databinding.ItemFeedGoodsBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedGoodsBinding
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
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((4 & j) != 0) {
            String str2 = null;
            ViewBindingAdapters.clipView(this.buyView, str2, 3);
            ViewBindingAdapters.clipView(this.mboundView2, str2, 3);
        }
        if (i3 != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            this.mboundView5.setVisibility(i);
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView5, str, null, str3, null, null, str3);
        }
    }
}
