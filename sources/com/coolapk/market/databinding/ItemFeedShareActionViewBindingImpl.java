package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;

public class ItemFeedShareActionViewBindingImpl extends ItemFeedShareActionViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFeedShareActionViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedShareActionViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[5], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[4]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.moreView.setTag(null);
        this.qqView.setTag(null);
        this.wechatTimeLineView.setTag(null);
        this.wechatView.setTag(null);
        this.weiboView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedShareActionViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
    }

    @Override // com.coolapk.market.databinding.ItemFeedShareActionViewBinding
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
        if ((6 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.qqView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wechatTimeLineView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wechatView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.weiboView, onClickListener, bool);
        }
        if ((j & 4) != 0) {
            Number number = null;
            ViewBindingAdapters.clipView(this.moreView, "oval", number);
            ViewBindingAdapters.clipView(this.qqView, "oval", number);
            ViewBindingAdapters.clipView(this.wechatTimeLineView, "oval", number);
            ViewBindingAdapters.clipView(this.wechatView, "oval", number);
            ViewBindingAdapters.clipView(this.weiboView, "oval", number);
        }
    }
}
