package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedTarget;

public class ItemFeedTargetViewBindingImpl extends ItemFeedTargetViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFeedTargetViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemFeedTargetViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        this.relativeView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (197 != i) {
            return false;
        }
        setModel((Feed) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedTargetViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        FeedTarget feedTarget;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (feed != null) {
                feedTarget = feed.getTargetRow();
            } else {
                feedTarget = null;
            }
            boolean z = feedTarget == null;
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            if (feedTarget != null) {
                str2 = feedTarget.getTitle();
                str4 = feedTarget.getLogo();
                str3 = feedTarget.getSubTitle();
            } else {
                str3 = null;
                str2 = null;
                str4 = null;
            }
            i = z ? 8 : 0;
            boolean z2 = str3 == null;
            if ((j & 3) != 0) {
                j |= z2 ? 32 : 16;
            }
            if (z2) {
                i2 = 8;
            }
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i = 0;
        }
        if ((3 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, true, null, bool);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView3, str3);
            this.mboundView3.setVisibility(i2);
            this.relativeView.setVisibility(i);
            ViewBindingAdapters.setFeedTargetClick(this.relativeView, feed);
        }
        if ((j & 2) != 0) {
            ViewBindingAdapters.clipView(this.mboundView1, null, 2);
        }
    }
}
