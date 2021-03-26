package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.stackcard.StackFrameLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemFeedStackItemBindingImpl extends ItemFeedStackItemBinding {
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
        sparseIntArray.put(2131362649, 2);
        sparseIntArray.put(2131363533, 3);
    }

    public ItemFeedStackItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemFeedStackItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (Space) objArr[2], (StackFrameLayout) objArr[0], (CoolEllipsizeTextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.itemView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedStackItemBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
    }

    @Override // com.coolapk.market.databinding.ItemFeedStackItemBinding
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
    }
}
