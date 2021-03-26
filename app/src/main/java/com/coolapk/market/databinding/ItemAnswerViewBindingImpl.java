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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemAnswerViewBindingImpl extends ItemAnswerViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final AutoLinkTextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 6);
        sparseIntArray.put(2131363568, 7);
        sparseIntArray.put(2131363582, 8);
        sparseIntArray.put(2131363533, 9);
        sparseIntArray.put(2131363016, 10);
        sparseIntArray.put(2131363229, 11);
    }

    public ItemAnswerViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemAnswerViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (FeedActionView2) objArr[3], (ForegroundTextView) objArr[5], (Space) objArr[6], (Space) objArr[10], (Space) objArr[11], (CoolEllipsizeTextView) objArr[9], (FrameLayout) objArr[7], (CoolEllipsizeTextView) objArr[8]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        this.foregroundTextView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[4];
        this.mboundView4 = autoLinkTextView;
        autoLinkTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAnswerViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAnswerViewBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemAnswerViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
        int i2 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i2 != 0) {
            String adminInfo = feed != null ? feed.getAdminInfo() : null;
            boolean isEmpty = TextUtils.isEmpty(adminInfo);
            if (i2 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if (isEmpty) {
                i = 8;
            }
            str = adminInfo;
        } else {
            str = null;
        }
        if ((12 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((j & 9) != 0) {
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            ViewBindingAdapters.updateFeed(this.foregroundTextView, feed);
            this.mboundView4.setVisibility(i);
            String str2 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.mboundView4, str, null, str2, null, null, str2);
        }
        if ((j & 8) != 0) {
            ViewBindingAdapters.clipView(this.mboundView2, null, 3);
        }
    }
}
