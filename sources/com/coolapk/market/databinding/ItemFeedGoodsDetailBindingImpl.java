package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ItemFeedGoodsDetailBindingImpl extends ItemFeedGoodsDetailBinding {
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
        sparseIntArray.put(2131363935, 3);
        sparseIntArray.put(2131363934, 4);
        sparseIntArray.put(2131362730, 5);
        sparseIntArray.put(2131362649, 6);
        sparseIntArray.put(2131363211, 7);
        sparseIntArray.put(2131363194, 8);
        sparseIntArray.put(2131362190, 9);
        sparseIntArray.put(2131362631, 10);
        sparseIntArray.put(2131363229, 11);
    }

    public ItemFeedGoodsDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemFeedGoodsDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (LinearLayout) objArr[1], (LinearLayout) objArr[0], (Space) objArr[10], (Space) objArr[6], (IndicatorView) objArr[5], (BadBadRatingBar) objArr[8], (TextView) objArr[7], (Space) objArr[11], (TextView) objArr[2], (ViewPager2) objArr[4], (MaxWidthFrameLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.buyView.setTag(null);
        this.cardView.setTag(null);
        this.textView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedGoodsDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedGoodsDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        String message = (i == 0 || feed == null) ? null : feed.getMessage();
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.buyView, null, 4);
        }
        if (i != 0) {
            String str = null;
            TextViewBindingAdapters.setTextViewLinkable(this.textView, message, null, str, null, null, str);
        }
    }
}
