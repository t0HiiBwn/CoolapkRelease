package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.FeedActionView2;

public class ItemGoodsListFeedBindingImpl extends ItemGoodsListFeedBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362649, 7);
        sparseIntArray.put(2131362630, 8);
    }

    public ItemGoodsListFeedBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemGoodsListFeedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (CoolapkCardView) objArr[0], (AspectRatioImageView) objArr[3], (FeedActionView2) objArr[6], (CoolapkCardView) objArr[8], (Space) objArr[7], (FrameLayout) objArr[2]);
        this.mDirtyFlags = -1;
        this.cardLayout.setTag(null);
        this.coolapkCardView.setTag(null);
        this.coverView.setTag(null);
        this.feedActionView.setTag(null);
        this.itemView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        } else if (301 == i) {
            setVerifyStatusIcon((String) obj);
        } else if (250 == i) {
            setShowFromView(((Boolean) obj).booleanValue());
        } else if (300 == i) {
            setVerifyLabel((String) obj);
        } else if (121 == i) {
            setFollowNum((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setVerifyStatusIcon(String str) {
        this.mVerifyStatusIcon = str;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setShowFromView(boolean z) {
        this.mShowFromView = z;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setVerifyLabel(String str) {
        this.mVerifyLabel = str;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setFollowNum(String str) {
        this.mFollowNum = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(121);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListFeedBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        String str3 = this.mFollowNum;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((65 & j) > 0 ? 1 : ((65 & j) == 0 ? 0 : -1));
        if (i == 0 || feed == null) {
            str2 = null;
            str = null;
        } else {
            String extraPic = feed.getExtraPic();
            str2 = feed.getTitle();
            str = extraPic;
        }
        int i2 = ((80 & j) > 0 ? 1 : ((80 & j) == 0 ? 0 : -1));
        if ((j & 96) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardLayout, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool);
        }
        if (i != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str, AppCompatResources.getDrawable(this.coverView.getContext(), 2131231696), 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            ViewBindingAdapters.updateFeed(this.feedActionView, feed);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str3);
        }
    }
}
