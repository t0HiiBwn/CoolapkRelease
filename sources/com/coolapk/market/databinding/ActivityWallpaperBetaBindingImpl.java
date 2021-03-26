package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public class ActivityWallpaperBetaBindingImpl extends ActivityWallpaperBetaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362069, 6);
        sparseIntArray.put(2131363615, 7);
        sparseIntArray.put(2131362660, 8);
        sparseIntArray.put(2131363361, 9);
        sparseIntArray.put(2131363610, 10);
        sparseIntArray.put(2131362332, 11);
    }

    public ActivityWallpaperBetaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ActivityWallpaperBetaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppBarLayout) objArr[6], (FrameLayout) objArr[11], (ImageView) objArr[1], (FrameLayout) objArr[8], (ProgressBar) objArr[5], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[2], (Toolbar) objArr[10], (CollapsingToolbarFixLayout) objArr[7]);
        this.mDirtyFlags = -1;
        this.coverView.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        this.progressBar.setTag(null);
        this.recommendSplashView.setTag(null);
        this.recommendView.setTag(null);
        this.textView6.setTag(null);
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
        if (104 != i) {
            return false;
        }
        setFeed((Feed) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ActivityWallpaperBetaBinding
    public void setFeed(Feed feed) {
        this.mFeed = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(104);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        String str2;
        int i3;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mFeed;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feed != null) {
                str3 = feed.getMiddleSizePic();
                i3 = feed.getRecommend();
                str2 = feed.getLabel();
            } else {
                str2 = null;
                str3 = null;
                i3 = 0;
            }
            boolean z = i3 == 2;
            boolean z2 = i3 > 0;
            if (i4 != 0) {
                j |= z ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 8 : 4;
            }
            int i5 = 8;
            int i6 = z ? 0 : 8;
            if (z2) {
                i5 = 0;
            }
            str = str3;
            i2 = i5;
            i = i6;
        } else {
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        if ((3 & j) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str, null, 2131231702, 0, false, bool, bool, bool, bool, null, null, null, bool, true, bool, null, bool);
            this.recommendSplashView.setVisibility(i);
            this.recommendView.setVisibility(i2);
            TextViewBindingAdapter.setText(this.textView6, str2);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
        }
    }
}
