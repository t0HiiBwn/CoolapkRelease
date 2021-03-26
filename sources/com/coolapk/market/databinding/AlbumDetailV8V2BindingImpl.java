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
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.AlbumActionView;
import com.coolapk.market.widget.CommentBar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AlbumDetailV8V2BindingImpl extends AlbumDetailV8V2Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362269, 10);
        sparseIntArray.put(2131363904, 11);
        sparseIntArray.put(2131363544, 12);
        sparseIntArray.put(2131363610, 13);
        sparseIntArray.put(2131362920, 14);
        sparseIntArray.put(2131362919, 15);
    }

    public AlbumDetailV8V2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private AlbumDetailV8V2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AlbumActionView) objArr[5], (FrameLayout) objArr[6], (AppBarLayout) objArr[1], (CollapsingToolbarLayout) objArr[10], (CommentBar) objArr[9], (ImageView) objArr[2], (TextView) objArr[4], (ProgressBar) objArr[8], (CoordinatorLayout) objArr[0], (LinearLayout) objArr[15], (ImageView) objArr[14], (LinearLayout) objArr[12], (TextView) objArr[3], (Toolbar) objArr[13], (LinearLayout) objArr[11]);
        this.mDirtyFlags = -1;
        this.albumAction.setTag(null);
        this.albumList.setTag(null);
        this.appBar.setTag(null);
        this.commentBar.setTag(null);
        this.coverView.setTag(null);
        this.infoView.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[7];
        this.mboundView7 = linearLayout;
        linearLayout.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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

    @Override // com.coolapk.market.databinding.AlbumDetailV8V2Binding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.AlbumDetailV8V2Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // com.coolapk.market.databinding.AlbumDetailV8V2Binding
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
        } else if (i == 248) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 13) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 8) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 247) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i != 171) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bf  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        Album album;
        String str;
        int i2;
        String str2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i8 = 0;
        if ((1017 & j) != 0) {
            str2 = ((j & 529) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            int i9 = ((j & 521) > 0 ? 1 : ((j & 521) == 0 ? 0 : -1));
            if (i9 != 0) {
                if (albumDetailViewModel != null) {
                    z3 = albumDetailViewModel.getShowContentView();
                } else {
                    z3 = false;
                }
                if (i9 != 0) {
                    j |= z3 ? 8192 : 4096;
                }
                if (!z3) {
                    i4 = 8;
                    String albumInfo = ((j & 545) != 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumInfo();
                    Album album2 = ((j & 577) != 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbum();
                    i5 = ((j & 641) > 0 ? 1 : ((j & 641) == 0 ? 0 : -1));
                    if (i5 != 0) {
                        if (albumDetailViewModel != null) {
                            z2 = albumDetailViewModel.getShowContent();
                        } else {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            j |= z2 ? 2048 : 1024;
                        }
                        if (z2) {
                            i6 = 8;
                            i7 = ((j & 769) > 0 ? 1 : ((j & 769) == 0 ? 0 : -1));
                            if (i7 != 0) {
                                if (albumDetailViewModel != null) {
                                    z = albumDetailViewModel.getIsLoading();
                                } else {
                                    z = false;
                                }
                                if (i7 != 0) {
                                    j |= z ? 32768 : 16384;
                                }
                                if (!z) {
                                    i8 = 8;
                                }
                                i2 = i8;
                                i3 = i4;
                                str = albumInfo;
                                album = album2;
                                i = i6;
                            } else {
                                i3 = i4;
                                str = albumInfo;
                                album = album2;
                                i = i6;
                                i2 = 0;
                            }
                        }
                    }
                    i6 = 0;
                    i7 = ((j & 769) > 0 ? 1 : ((j & 769) == 0 ? 0 : -1));
                    if (i7 != 0) {
                    }
                }
            }
            i4 = 0;
            if ((j & 545) != 0) {
            }
            if ((j & 577) != 0) {
            }
            i5 = ((j & 641) > 0 ? 1 : ((j & 641) == 0 ? 0 : -1));
            if (i5 != 0) {
            }
            i6 = 0;
            i7 = ((j & 769) > 0 ? 1 : ((j & 769) == 0 ? 0 : -1));
            if (i7 != 0) {
            }
        } else {
            str2 = null;
            str = null;
            album = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 577) != 0) {
            ViewBindingAdapters.updateAlbum(this.albumAction, album);
        }
        if ((j & 521) != 0) {
            this.albumList.setVisibility(i3);
            this.appBar.setVisibility(i3);
            this.commentBar.setVisibility(i3);
        }
        if ((512 & j) != 0) {
            ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
            String str3 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str3, null, 0, 0, bool, bool, bool, bool, bool, str3, null, null, true, bool, bool, null, bool);
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
        if ((j & 545) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str);
        }
        if ((769 & j) != 0) {
            this.loadingView.setVisibility(i2);
        }
        if ((641 & j) != 0) {
            this.mboundView7.setVisibility(i);
        }
        if ((j & 529) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
