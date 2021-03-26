package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public class AlbumV8DetailBindingImpl extends AlbumV8DetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363588, 5);
        sparseIntArray.put(2131362279, 6);
    }

    public AlbumV8DetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private AlbumV8DetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AppBarLayout) objArr[1], (CommentBar) objArr[6], (ProgressBar) objArr[4], (CoordinatorLayout) objArr[0], (Toolbar) objArr[5], (ScrollStateViewPager) objArr[2]);
        this.mDirtyFlags = -1;
        this.appBar.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        this.viewPager.setTag(null);
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
        if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumDetailViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumV8DetailBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.AlbumV8DetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // com.coolapk.market.databinding.AlbumV8DetailBinding
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
        } else if (i == 170) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 246) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        boolean z;
        long j2;
        long j3;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i4 = 0;
        if ((57 & j) != 0) {
            int i5 = ((j & 49) > 0 ? 1 : ((j & 49) == 0 ? 0 : -1));
            if (i5 != 0) {
                if (albumDetailViewModel != null) {
                    z2 = albumDetailViewModel.getShowContent();
                } else {
                    z2 = false;
                }
                if (i5 != 0) {
                    j |= z2 ? 128 : 64;
                }
                if (z2) {
                    i = 8;
                    i3 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
                    if (i3 == 0) {
                        if (albumDetailViewModel != null) {
                            z = albumDetailViewModel.getIsLoading();
                        } else {
                            z = false;
                        }
                        if (i3 != 0) {
                            if (z) {
                                j3 = j | 512;
                                j2 = 2048;
                            } else {
                                j3 = j | 256;
                                j2 = 1024;
                            }
                            j = j3 | j2;
                        }
                        int i6 = z ? 0 : 8;
                        if (z) {
                            i4 = 8;
                        }
                        i2 = i4;
                        i4 = i6;
                    } else {
                        i2 = 0;
                    }
                }
            }
            i = 0;
            i3 = ((j & 41) > 0 ? 1 : ((j & 41) == 0 ? 0 : -1));
            if (i3 == 0) {
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((32 & j) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
        if ((j & 41) != 0) {
            this.loadingView.setVisibility(i4);
            this.viewPager.setVisibility(i2);
        }
        if ((j & 49) != 0) {
            this.mboundView3.setVisibility(i);
        }
    }
}
