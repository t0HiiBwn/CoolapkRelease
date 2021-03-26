package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;

public class ItemFeedVoteCommentDetailBindingImpl extends ItemFeedVoteCommentDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ItemFeedTargetViewBinding mboundView0;
    private final View mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_feed_target_view"}, new int[]{3}, new int[]{2131558732});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 4);
        sparseIntArray.put(2131363539, 5);
        sparseIntArray.put(2131363016, 6);
        sparseIntArray.put(2131363947, 7);
        sparseIntArray.put(2131363229, 8);
    }

    public ItemFeedVoteCommentDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemFeedVoteCommentDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (Space) objArr[4], (Space) objArr[6], (Space) objArr[8], (TextView) objArr[2], (FrameLayout) objArr[5], (Space) objArr[7]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[3];
        this.mboundView0 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        this.textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.mboundView0.hasPendingBindings()) {
            return true;
        }
        return false;
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

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedVoteCommentDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        FeedTarget feedTarget;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
                str2 = feed.getMessage();
            } else {
                feedTarget = null;
                str2 = null;
            }
            boolean z = feedTarget == null;
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                i = 8;
            }
            str = str2;
        } else {
            str = null;
        }
        if ((j & 5) != 0) {
            this.mboundView0.setModel(feed);
            this.mboundView1.setVisibility(i);
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str, null, str3, null, null, str3);
        }
        executeBindingsOn(this.mboundView0);
    }
}
