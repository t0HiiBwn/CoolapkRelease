package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.DividerLineView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.widget.NativeAdContainer;

public class ItemSponsorSelfDrawNewsBindingImpl extends ItemSponsorSelfDrawNewsBinding {
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
        sparseIntArray.put(2131363002, 6);
        sparseIntArray.put(2131362768, 7);
        sparseIntArray.put(2131362417, 8);
        sparseIntArray.put(2131363582, 9);
        sparseIntArray.put(2131362913, 10);
        sparseIntArray.put(2131362304, 11);
        sparseIntArray.put(2131362308, 12);
        sparseIntArray.put(2131362309, 13);
        sparseIntArray.put(2131362310, 14);
        sparseIntArray.put(2131363723, 15);
        sparseIntArray.put(2131362833, 16);
        sparseIntArray.put(2131362257, 17);
    }

    public ItemSponsorSelfDrawNewsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private ItemSponsorSelfDrawNewsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (ImageView) objArr[17], (LinearLayout) objArr[11], (ImageView) objArr[12], (ImageView) objArr[13], (ImageView) objArr[14], (ImageView) objArr[4], (MaxWidthFrameLayout) objArr[3], (CoolapkCardView) objArr[0], (DividerLineView) objArr[8], (ImageView) objArr[2], (CardView) objArr[1], (RelativeLayout) objArr[7], (TextView) objArr[16], (MediaView) objArr[10], (NativeAdContainer) objArr[6], (CoolEllipsizeTextView) objArr[9], (FrameLayout) objArr[15]);
        this.mDirtyFlags = -1;
        this.adTextView.setTag(null);
        this.contentImageView.setTag(null);
        this.contentView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.extraImageView.setTag(null);
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
        if (197 == i) {
            setModel((Feed) obj);
        } else if (157 == i) {
            setImageUrl((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorSelfDrawNewsBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
    }

    @Override // com.coolapk.market.databinding.ItemSponsorSelfDrawNewsBinding
    public void setImageUrl(String str) {
        this.mImageUrl = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(157);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSponsorSelfDrawNewsBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mImageUrl;
        int i = 0;
        int i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str);
            if (i2 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if (isEmpty) {
                i = 8;
            }
        }
        if ((8 & j) != 0) {
            String str2 = null;
            ViewBindingAdapters.clipView(this.adTextView, str2, 2);
            ViewBindingAdapters.clipView(this.contentImageView, str2, 8);
            ViewBindingAdapters.clipView(this.contentView, str2, 8);
            ViewBindingAdapters.clipView(this.extraImageView, str2, 8);
        }
        if ((j & 10) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extraImageView, str, null, 2131231691, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            this.imageCardView.setVisibility(i);
        }
    }
}
