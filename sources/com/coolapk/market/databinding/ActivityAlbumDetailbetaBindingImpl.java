package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.CommentBar;
import com.google.android.material.appbar.AppBarLayout;

public class ActivityAlbumDetailbetaBindingImpl extends ActivityAlbumDetailbetaBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363588, 4);
        sparseIntArray.put(2131362023, 5);
        sparseIntArray.put(2131362279, 6);
    }

    public ActivityAlbumDetailbetaBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ActivityAlbumDetailbetaBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[5], (AppBarLayout) objArr[1], (CommentBar) objArr[6], (ProgressBar) objArr[3], (CoordinatorLayout) objArr[0], (Toolbar) objArr[4]);
        this.mDirtyFlags = -1;
        this.appBar.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout;
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
        if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumDetailViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ActivityAlbumDetailbetaBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ActivityAlbumDetailbetaBinding
    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(0, albumDetailViewModel);
        this.mViewModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
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
        } else if (i == 246) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 170) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i3 = 0;
        if ((29 & j) != 0) {
            int i4 = ((j & 21) > 0 ? 1 : ((j & 21) == 0 ? 0 : -1));
            if (i4 != 0) {
                if (albumDetailViewModel != null) {
                    z2 = albumDetailViewModel.getShowContent();
                } else {
                    z2 = false;
                }
                if (i4 != 0) {
                    j |= z2 ? 64 : 32;
                }
                if (z2) {
                    i = 8;
                    i2 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
                    if (i2 != 0) {
                        if (albumDetailViewModel != null) {
                            z = albumDetailViewModel.getIsLoading();
                        } else {
                            z = false;
                        }
                        if (i2 != 0) {
                            j |= z ? 256 : 128;
                        }
                        if (!z) {
                            i3 = 8;
                        }
                    }
                }
            }
            i = 0;
            i2 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i2 != 0) {
            }
        } else {
            i = 0;
        }
        if ((16 & j) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
        if ((j & 25) != 0) {
            this.loadingView.setVisibility(i3);
        }
        if ((j & 21) != 0) {
            this.mboundView2.setVisibility(i);
        }
    }
}
