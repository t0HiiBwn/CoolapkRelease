package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.RatioImageView;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public class ActivityWallpaperBindingImpl extends ActivityWallpaperBinding {
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
        sparseIntArray.put(2131363610, 5);
        sparseIntArray.put(2131363361, 6);
        sparseIntArray.put(2131362332, 7);
    }

    public ActivityWallpaperBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ActivityWallpaperBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppBarLayout) objArr[1], (CollapsingToolbarFixLayout) objArr[2], (FrameLayout) objArr[7], (RatioImageView) objArr[3], (CoordinatorLayout) objArr[0], (TextView) objArr[6], (TextView) objArr[4], (Toolbar) objArr[5]);
        this.mDirtyFlags = -1;
        this.appBar.setTag(null);
        this.collapsingToolbar.setTag(null);
        this.coverView.setTag(null);
        this.mainContent.setTag(null);
        this.textView6.setTag(null);
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
        if (104 == i) {
            setFeed((Feed) obj);
        } else if (186 != i) {
            return false;
        } else {
            setLoadListener((OnImageLoadListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ActivityWallpaperBinding
    public void setFeed(Feed feed) {
        this.mFeed = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(104);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ActivityWallpaperBinding
    public void setLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mLoadListener = onImageLoadListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(186);
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
        Feed feed = this.mFeed;
        OnImageLoadListener onImageLoadListener = this.mLoadListener;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i != 0) {
            String middleSizePic = feed != null ? feed.getMiddleSizePic() : null;
            if ((j & 5) == 0 || feed == null) {
                str = middleSizePic;
                str2 = null;
            } else {
                str2 = feed.getLabel();
                str = middleSizePic;
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((4 & j) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
            ThemeBindingAdapters.setBackgroundColor(this.collapsingToolbar, "colorPrimary");
        }
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str, null, 0, 0, bool, bool, bool, bool, bool, null, onImageLoadListener, null, bool, true, bool, null, bool);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.textView6, str2);
        }
    }
}
