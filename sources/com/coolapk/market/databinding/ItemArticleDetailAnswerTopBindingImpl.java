package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;

public class ItemArticleDetailAnswerTopBindingImpl extends ItemArticleDetailAnswerTopBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ItemFeedTargetViewBinding mboundView0;
    private final LinearLayout mboundView01;
    private final View mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_feed_target_view"}, new int[]{8}, new int[]{2131558732});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363568, 9);
        sparseIntArray.put(2131362649, 10);
    }

    public ItemArticleDetailAnswerTopBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemArticleDetailAnswerTopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ProgressBar) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[4], (TextView) objArr[3], (Space) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.addAnswerImage.setTag(null);
        this.addAnswerProgress.setTag(null);
        this.addAnswerText.setTag(null);
        this.addAnswerView.setTag(null);
        this.countView.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[8];
        this.mboundView0 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView01 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        this.titleView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemArticleDetailAnswerTopBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleDetailAnswerTopBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        FeedTarget feedTarget;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
            } else {
                feedTarget = null;
            }
            boolean z = feedTarget == null;
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                i = 8;
            }
        }
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((4 & j) != 0) {
            ThemeBindingAdapters.setTintColor(this.addAnswerImage, "colorAccent");
            ThemeBindingAdapters.setIndeterminateTint(this.addAnswerProgress, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.addAnswerText, "colorAccent");
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.addAnswerView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.countView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.titleView, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            this.mboundView0.setModel(feed);
            this.mboundView1.setVisibility(i);
        }
        executeBindingsOn(this.mboundView0);
    }
}
