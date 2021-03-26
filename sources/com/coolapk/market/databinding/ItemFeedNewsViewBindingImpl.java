package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;

public class ItemFeedNewsViewBindingImpl extends ItemFeedNewsViewBinding {
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
        sparseIntArray.put(2131362423, 5);
        sparseIntArray.put(2131363604, 6);
        sparseIntArray.put(2131363030, 7);
        sparseIntArray.put(2131362844, 8);
    }

    public ItemFeedNewsViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemFeedNewsViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (DividerLineView) objArr[5], (ImageView) objArr[3], (ForegroundTextView) objArr[4], (CardView) objArr[2], (TextView) objArr[8], (Space) objArr[7], (CoolEllipsizeTextView) objArr[6]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.extraImageView.setTag(null);
        this.foregroundTextView.setTag(null);
        this.imageCardView.setTag(null);
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
        if (198 == i) {
            setModel((Feed) obj);
        } else if (158 == i) {
            setImageUrl((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedNewsViewBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedNewsViewBinding
    public void setImageUrl(String str) {
        this.mImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(158);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedNewsViewBinding
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
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        String str = this.mImageUrl;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = 0;
        int i3 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i3 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if (isEmpty) {
                i2 = 8;
            }
            i = i2;
        } else {
            i = 0;
        }
        if ((12 & j) != 0) {
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, null);
        }
        if ((j & 10) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extraImageView, str, null, 2131231702, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            this.imageCardView.setVisibility(i);
        }
        if ((8 & j) != 0) {
            ViewBindingAdapters.clipView(this.extraImageView, null, 8);
        }
        if ((j & 9) != 0) {
            ViewBindingAdapters.updateFeed(this.foregroundTextView, feed);
        }
    }
}
