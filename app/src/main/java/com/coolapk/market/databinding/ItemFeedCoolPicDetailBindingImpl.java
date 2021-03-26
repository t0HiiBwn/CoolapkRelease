package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.model.Feed;

public class ItemFeedCoolPicDetailBindingImpl extends ItemFeedCoolPicDetailBinding {
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
        sparseIntArray.put(2131362649, 3);
        sparseIntArray.put(2131363539, 4);
        sparseIntArray.put(2131363229, 5);
    }

    public ItemFeedCoolPicDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedCoolPicDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (Space) objArr[3], (Space) objArr[5], (TextView) objArr[2], (FrameLayout) objArr[4], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.textView.setTag(null);
        this.titleView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedCoolPicDetailBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedCoolPicDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                str2 = feed.getMessageTitle();
                str3 = feed.getMessage();
            } else {
                str3 = null;
                str2 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (i2 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if (isEmpty) {
                i = 8;
            }
            str = str3;
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 5) != 0) {
            String str4 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.textView, str, null, str4, null, null, str4);
            TextViewBindingAdapter.setText(this.titleView, str2);
            this.titleView.setVisibility(i);
        }
    }
}
