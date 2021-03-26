package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Feed;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;

public class PictureDetailWrapBindingImpl extends PictureDetailWrapBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final TextView mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362344, 5);
        sparseIntArray.put(2131362343, 6);
        sparseIntArray.put(2131362069, 7);
        sparseIntArray.put(2131363615, 8);
        sparseIntArray.put(2131362153, 9);
        sparseIntArray.put(2131361918, 10);
        sparseIntArray.put(2131363361, 11);
        sparseIntArray.put(2131362669, 12);
        sparseIntArray.put(2131362331, 13);
        sparseIntArray.put(2131362514, 14);
    }

    public PictureDetailWrapBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private PictureDetailWrapBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[10], (AppBarLayout) objArr[7], (FrameLayout) objArr[9], (FrameLayout) objArr[13], (View) objArr[6], (ImageView) objArr[5], (View) objArr[14], (Toolbar) objArr[12], (ProgressBar) objArr[4], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[11], (CollapsingToolbarFixLayout) objArr[8]);
        this.mDirtyFlags = -1;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.progressBar.setTag(null);
        this.recommendSplashView.setTag(null);
        this.recommendView.setTag(null);
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

    @Override // com.coolapk.market.databinding.PictureDetailWrapBinding
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
        int i;
        int i2;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mFeed;
        String str2 = null;
        int i3 = 0;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feed != null) {
                i2 = feed.getRecommend();
                str = feed.getLabel();
            } else {
                str = null;
                i2 = 0;
            }
            boolean z = true;
            boolean z2 = i2 == 2;
            if (i2 <= 0) {
                z = false;
            }
            if (i4 != 0) {
                j |= z2 ? 32 : 16;
            }
            if ((j & 3) != 0) {
                j |= z ? 8 : 4;
            }
            int i5 = z2 ? 0 : 8;
            if (!z) {
                i3 = 8;
            }
            str2 = str;
            i = i3;
            i3 = i5;
        } else {
            i = 0;
        }
        if ((3 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str2);
            this.recommendSplashView.setVisibility(i3);
            this.recommendView.setVisibility(i);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.progressBar, "colorAccent");
        }
    }
}
