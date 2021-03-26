package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public class AlbumDetailtViewBindingImpl extends AlbumDetailtViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363959, 3);
        sparseIntArray.put(2131362286, 4);
        sparseIntArray.put(2131362920, 5);
        sparseIntArray.put(2131362069, 6);
        sparseIntArray.put(2131363610, 7);
    }

    public AlbumDetailtViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private AlbumDetailtViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AppBarLayout) objArr[6], (Space) objArr[4], (ProgressBar) objArr[2], (DrawSystemBarFrameLayout) objArr[0], (PhotoView) objArr[5], (Toolbar) objArr[7], (ScrollStateViewPager) objArr[3]);
        this.mDirtyFlags = -1;
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((AlbumDetailViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumDetailtViewBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.AlbumDetailtViewBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // com.coolapk.market.databinding.AlbumDetailtViewBinding
    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(0, albumDetailViewModel);
        this.mViewModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(309);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((AlbumDetailViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i != 248) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i = 0;
        int i2 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (albumDetailViewModel != null) {
                z = albumDetailViewModel.getShowContentView();
            } else {
                z = false;
            }
            if (i2 != 0) {
                j |= z ? 64 : 32;
            }
            if (z) {
                i = 8;
            }
        }
        if ((16 & j) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
        if ((j & 25) != 0) {
            this.loadingView.setVisibility(i);
            this.mboundView1.setVisibility(i);
        }
    }
}
