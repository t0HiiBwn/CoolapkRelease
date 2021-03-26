package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.ScalingImageView;

public class ItemArticleDetailTopBindingImpl extends ItemArticleDetailTopBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ItemFeedTargetViewBinding mboundView01;
    private final View mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_feed_target_view"}, new int[]{5}, new int[]{2131558732});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362340, 6);
        sparseIntArray.put(2131362649, 7);
        sparseIntArray.put(2131363282, 8);
        sparseIntArray.put(2131363211, 9);
        sparseIntArray.put(2131363194, 10);
        sparseIntArray.put(2131363281, 11);
    }

    public ItemArticleDetailTopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemArticleDetailTopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[4], (View) objArr[6], (Space) objArr[7], (BadBadRatingBar) objArr[10], (TextView) objArr[9], (TextView) objArr[11], (LinearLayout) objArr[8], (TextView) objArr[3], (ScalingImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.buyView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[5];
        this.mboundView01 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        this.titleView.setTag(null);
        this.topImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView01.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.mboundView01.hasPendingBindings()) {
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

    @Override // com.coolapk.market.databinding.ItemArticleDetailTopBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleDetailTopBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView01.setLifecycleOwner(lifecycleOwner);
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
                str2 = feed.getMessageTitle();
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
        if ((4 & j) != 0) {
            String str3 = null;
            ViewBindingAdapters.clipView(this.buyView, str3, 4);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.topImageView, str3, null, 0, 0, bool, bool, bool, bool, bool, str3, null, null, bool, true, bool, null, bool);
        }
        if ((j & 5) != 0) {
            this.mboundView01.setModel(feed);
            this.mboundView2.setVisibility(i);
            String str4 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.titleView, str, null, str4, null, null, str4);
        }
        executeBindingsOn(this.mboundView01);
    }
}
