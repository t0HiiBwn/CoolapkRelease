package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;

public class ItemFeedDetailViewV8BindingImpl extends ItemFeedDetailViewV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;
    private final ItemFeedTargetViewBinding mboundView11;
    private final View mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(22);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_feed_target_view"}, new int[]{6}, new int[]{2131558732});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 7);
        sparseIntArray.put(2131363209, 8);
        sparseIntArray.put(2131363568, 9);
        sparseIntArray.put(2131363325, 10);
        sparseIntArray.put(2131363326, 11);
        sparseIntArray.put(2131363539, 12);
        sparseIntArray.put(2131363388, 13);
        sparseIntArray.put(2131362488, 14);
        sparseIntArray.put(2131362487, 15);
        sparseIntArray.put(2131363016, 16);
        sparseIntArray.put(2131363917, 17);
        sparseIntArray.put(2131362492, 18);
        sparseIntArray.put(2131363527, 19);
        sparseIntArray.put(2131363229, 20);
        sparseIntArray.put(2131362722, 21);
    }

    public ItemFeedDetailViewV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private ItemFeedDetailViewV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (FrameLayout) objArr[15], (Space) objArr[14], (FrameLayout) objArr[18], (Space) objArr[7], (ImageView) objArr[21], (Space) objArr[16], (Space) objArr[8], (Space) objArr[20], (Space) objArr[10], (Space) objArr[11], (Space) objArr[13], (TextView) objArr[19], (TextView) objArr[5], (FrameLayout) objArr[12], (FrameLayout) objArr[9], (TextView) objArr[3], (TextView) objArr[4], (Space) objArr[17]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        ItemFeedTargetViewBinding itemFeedTargetViewBinding = (ItemFeedTargetViewBinding) objArr[6];
        this.mboundView11 = itemFeedTargetViewBinding;
        setContainedBinding(itemFeedTargetViewBinding);
        View view2 = (View) objArr[2];
        this.mboundView2 = view2;
        view2.setTag(null);
        this.textView.setTag(null);
        this.titleTagView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.mboundView11.hasPendingBindings()) {
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

    @Override // com.coolapk.market.databinding.ItemFeedDetailViewV8Binding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedDetailViewV8Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        FeedTarget feedTarget;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i2 = 0;
        int i3 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
                str2 = feed.getMessageTitle();
                str = feed.getMessage();
            } else {
                feedTarget = null;
                str2 = null;
                str = null;
            }
            boolean z = feedTarget == null;
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (i3 != 0) {
                j |= z ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= isEmpty ? 16 : 8;
            }
            int i4 = z ? 8 : 0;
            if (isEmpty) {
                i2 = 8;
            }
            i2 = i4;
            i = i2;
        } else {
            str = null;
            i = 0;
        }
        if ((5 & j) != 0) {
            this.mboundView11.setModel(feed);
            this.mboundView2.setVisibility(i2);
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str, null, str3, null, null, str3);
            this.titleView.setVisibility(i);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.titleTagView, null, 3);
        }
        executeBindingsOn(this.mboundView11);
    }
}
