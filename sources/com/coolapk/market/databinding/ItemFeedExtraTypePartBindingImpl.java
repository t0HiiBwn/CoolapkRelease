package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class ItemFeedExtraTypePartBindingImpl extends ItemFeedExtraTypePartBinding {
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
        sparseIntArray.put(2131362484, 5);
    }

    public ItemFeedExtraTypePartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemFeedExtraTypePartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (ActionButtonFrameLayout) objArr[3], (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.extendIcon.setTag(null);
        this.extendLayout.setTag(null);
        this.extendTitle.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        } else if (263 == i) {
            setSingleImg((String) obj);
        } else if (130 == i) {
            setGifImage((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemFeedExtraTypePartBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemFeedExtraTypePartBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemFeedExtraTypePartBinding
    public void setSingleImg(String str) {
        this.mSingleImg = str;
    }

    @Override // com.coolapk.market.databinding.ItemFeedExtraTypePartBinding
    public void setGifImage(String str) {
        this.mGifImage = str;
    }

    @Override // com.coolapk.market.databinding.ItemFeedExtraTypePartBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i2 = ((j & 33) > 0 ? 1 : ((j & 33) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (feed != null) {
                str5 = feed.getExtraPic();
                str4 = feed.getExtraType();
                str3 = feed.getExtraTitle();
            } else {
                str5 = null;
                str4 = null;
                str3 = null;
            }
            boolean isApkType = EntityUtils.isApkType(str4);
            if (i2 != 0) {
                j |= isApkType ? 128 : 64;
            }
            i = isApkType ? 1 : 2;
            str = str5;
            str2 = str3;
        } else {
            str2 = null;
            str = null;
            i = 0;
        }
        int i3 = ((48 & j) > 0 ? 1 : ((48 & j) == 0 ? 0 : -1));
        if ((33 & j) != 0) {
            ActionButtonBindingAdapters.setActionText(this.actionButton, feed);
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, feed, false);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extendIcon, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            this.extendTitle.setMaxLines(i);
            TextViewBindingAdapter.setText(this.extendTitle, str2);
        }
        if (i3 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.actionContainer, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.extendLayout, onClickListener, bool2);
        }
        if ((j & 32) != 0) {
            String str6 = null;
            ViewBindingAdapters.clipView(this.extendIcon, str6, 8);
            ViewBindingAdapters.clipView(this.extendLayout, str6, 8);
        }
    }
}
