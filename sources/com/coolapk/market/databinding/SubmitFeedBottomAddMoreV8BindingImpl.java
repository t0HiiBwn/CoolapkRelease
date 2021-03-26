package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;

public class SubmitFeedBottomAddMoreV8BindingImpl extends SubmitFeedBottomAddMoreV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public SubmitFeedBottomAddMoreV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private SubmitFeedBottomAddMoreV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (LinearLayout) objArr[1], (LinearLayout) objArr[2], (LinearLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.buttonShareApp.setTag(null);
        this.buttonShareLink.setTag(null);
        this.buttonShareMusic.setTag(null);
        this.buttonShareVideo.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
        if (288 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitFeedBottomAddMoreV8Binding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitFeedBottomAddMoreV8Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = 8;
        int i4 = 0;
        int i5 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (feedUIConfig != null) {
                z4 = feedUIConfig.canAddVideo();
                z3 = feedUIConfig.canAddMusic();
                z = feedUIConfig.isShareAppItemVisible();
            } else {
                z4 = false;
                z3 = false;
                z = false;
            }
            if (i5 != 0) {
                j |= z4 ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j = z ? j | 64 : j | 32;
            }
            i2 = z4 ? 0 : 8;
            i = z3 ? 0 : 8;
        } else {
            i2 = 0;
            i = 0;
            z = false;
        }
        if ((64 & j) == 0 || feedUIConfig == null) {
            z2 = false;
        } else {
            z2 = feedUIConfig.isShowAddGoodsInMenuBar();
        }
        int i6 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i6 != 0) {
                j |= z2 ? 1024 : 512;
            }
            if (z2) {
                i3 = 0;
            }
            i4 = i3;
        }
        if ((5 & j) != 0) {
            this.buttonShareApp.setVisibility(i4);
            this.buttonShareMusic.setVisibility(i);
            this.buttonShareVideo.setVisibility(i2);
        }
        if ((j & 6) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.buttonShareApp, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonShareLink, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonShareMusic, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buttonShareVideo, onClickListener, bool);
        }
    }
}
