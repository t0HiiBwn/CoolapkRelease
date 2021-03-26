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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.ForegroundTextView;

public class ItemFeedLayoutV8BindingImpl extends ItemFeedLayoutV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AutoLinkTextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 6);
        sparseIntArray.put(2131363209, 7);
        sparseIntArray.put(2131363568, 8);
        sparseIntArray.put(2131363582, 9);
        sparseIntArray.put(2131363325, 10);
        sparseIntArray.put(2131363533, 11);
        sparseIntArray.put(2131363388, 12);
        sparseIntArray.put(2131362487, 13);
        sparseIntArray.put(2131363016, 14);
        sparseIntArray.put(2131363917, 15);
        sparseIntArray.put(2131362488, 16);
        sparseIntArray.put(2131362492, 17);
        sparseIntArray.put(2131363198, 18);
        sparseIntArray.put(2131362089, 19);
        sparseIntArray.put(2131363229, 20);
        sparseIntArray.put(2131362665, 21);
        sparseIntArray.put(2131362722, 22);
    }

    public ItemFeedLayoutV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private ItemFeedLayoutV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Space) objArr[19], (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (FrameLayout) objArr[13], (Space) objArr[16], (FrameLayout) objArr[17], (FeedActionView2) objArr[3], (ForegroundTextView) objArr[5], (Space) objArr[6], (Space) objArr[21], (ImageView) objArr[22], (Space) objArr[14], (Space) objArr[18], (Space) objArr[7], (Space) objArr[20], (Space) objArr[10], (Space) objArr[12], (TextView) objArr[11], (FrameLayout) objArr[8], (TextView) objArr[2], (TextView) objArr[9], (Space) objArr[15]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.feedActionView.setTag(null);
        this.foregroundTextView.setTag(null);
        AutoLinkTextView autoLinkTextView = (AutoLinkTextView) objArr[4];
        this.mboundView4 = autoLinkTextView;
        autoLinkTextView.setTag(null);
        this.titleTagView.setTag(null);
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

    @Override // com.coolapk.market.databinding.ItemFeedLayoutV8Binding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedLayoutV8Binding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemFeedLayoutV8Binding
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
            ViewBindingAdapters.clipView(this.titleTagView, null, 3);
        }
    }
}
