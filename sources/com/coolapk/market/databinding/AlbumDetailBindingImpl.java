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
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.CommentBar;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public class AlbumDetailBindingImpl extends AlbumDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView10;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362264, 12);
        sparseIntArray.put(2131363881, 13);
        sparseIntArray.put(2131362340, 14);
        sparseIntArray.put(2131362652, 15);
        sparseIntArray.put(2131362735, 16);
        sparseIntArray.put(2131363217, 17);
        sparseIntArray.put(2131363588, 18);
        sparseIntArray.put(2131363480, 19);
        sparseIntArray.put(2131362279, 20);
    }

    public AlbumDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private AlbumDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[3], (AppBarLayout) objArr[1], (CollapsingToolbarFixLayout) objArr[12], (CommentBar) objArr[20], (ImageView) objArr[2], (View) objArr[14], (View) objArr[6], (View) objArr[7], (LinearLayout) objArr[15], (LinearLayout) objArr[16], (ProgressBar) objArr[11], (CoordinatorLayout) objArr[0], (LinearLayout) objArr[17], (FrameLayout) objArr[19], (TabLayout) objArr[8], (TextView) objArr[4], (Toolbar) objArr[18], (LinearLayout) objArr[13], (TextView) objArr[5], (ScrollStateViewPager) objArr[9]);
        this.mDirtyFlags = -1;
        this.albumIconView.setTag(null);
        this.appBar.setTag(null);
        this.coverView.setTag(null);
        this.diverView.setTag(null);
        this.divider.setTag(null);
        this.loadingView.setTag(null);
        this.mainContent.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.mboundView10 = linearLayout;
        linearLayout.setTag(null);
        this.tabs.setTag(null);
        this.titleView.setTag(null);
        this.userInfoView.setTag(null);
        this.viewPager.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
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

    @Override // com.coolapk.market.databinding.AlbumDetailBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AlbumDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AlbumDetailBinding
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
        } else if (i == 149) {
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
        } else if (i == 246) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i != 170) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        String str3;
        View.OnClickListener onClickListener;
        int i5;
        int i6;
        int i7;
        int i8;
        String str4;
        String str5;
        int i9;
        boolean z;
        long j2;
        long j3;
        boolean z2;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        OnBitmapTransformListener onBitmapTransformListener = this.mTransformer;
        View.OnClickListener onClickListener2 = this.mClick;
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i10 = ((j & 271) > 0 ? 1 : ((j & 271) == 0 ? 0 : -1));
        int i11 = 0;
        if ((511 & j) != 0) {
            str2 = ((j & 273) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            String albumInfo = ((j & 289) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumInfo();
            int i12 = ((j & 321) > 0 ? 1 : ((j & 321) == 0 ? 0 : -1));
            if (i12 != 0) {
                if (albumDetailViewModel != null) {
                    z2 = albumDetailViewModel.getShowContent();
                } else {
                    z2 = false;
                }
                if (i12 != 0) {
                    if (z2) {
                        j5 = j | 1024;
                        j4 = 4096;
                    } else {
                        j5 = j | 512;
                        j4 = 2048;
                    }
                    j = j5 | j4;
                }
                i9 = z2 ? 0 : 8;
                i3 = z2 ? 8 : 0;
            } else {
                i3 = 0;
                i9 = 0;
            }
            String icon = ((j & 271) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getIcon();
            int i13 = ((j & 385) > 0 ? 1 : ((j & 385) == 0 ? 0 : -1));
            if (i13 != 0) {
                if (albumDetailViewModel != null) {
                    z = albumDetailViewModel.getIsLoading();
                } else {
                    z = false;
                }
                if (i13 != 0) {
                    if (z) {
                        j3 = j | 16384;
                        j2 = 65536;
                    } else {
                        j3 = j | 8192;
                        j2 = 32768;
                    }
                    j = j3 | j2;
                }
                int i14 = z ? 0 : 8;
                if (z) {
                    i11 = 8;
                }
                str = icon;
                i = i14;
                i2 = i11;
                str3 = albumInfo;
                i4 = i9;
                if ((271 & j) == 0) {
                    str5 = str3;
                    str4 = str2;
                    Boolean bool = null;
                    i8 = i2;
                    i7 = i;
                    i6 = i3;
                    i5 = i4;
                    onClickListener = onClickListener2;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.albumIconView, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, true, bool, onClickListener, bool);
                } else {
                    str5 = str3;
                    onClickListener = onClickListener2;
                    str4 = str2;
                    i5 = i4;
                    i6 = i3;
                    i8 = i2;
                    i7 = i;
                }
                if ((256 & j) != 0) {
                    ThemeBindingAdapters.setBackgroundColor(this.appBar, "colorPrimary");
                    String str6 = null;
                    Boolean bool2 = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str6, null, 0, 0, bool2, bool2, bool2, bool2, bool2, str6, null, null, true, bool2, bool2, null, bool2);
                    ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
                }
                if ((j & 321) != 0) {
                    this.diverView.setVisibility(i5);
                    this.divider.setVisibility(i5);
                    this.mboundView10.setVisibility(i6);
                }
                if ((j & 385) != 0) {
                    this.loadingView.setVisibility(i7);
                    this.tabs.setVisibility(i8);
                    this.viewPager.setVisibility(i8);
                }
                if ((j & 273) != 0) {
                    TextViewBindingAdapter.setText(this.titleView, str4);
                }
                if ((j & 289) != 0) {
                    TextViewBindingAdapter.setText(this.userInfoView, str5);
                }
                if ((j & 260) == 0) {
                    ViewBindingAdapters.clickListener(this.userInfoView, onClickListener, null);
                    return;
                }
                return;
            }
            str3 = albumInfo;
            i4 = i9;
            str = icon;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
        }
        i2 = 0;
        i = 0;
        if ((271 & j) == 0) {
        }
        if ((256 & j) != 0) {
        }
        if ((j & 321) != 0) {
        }
        if ((j & 385) != 0) {
        }
        if ((j & 273) != 0) {
        }
        if ((j & 289) != 0) {
        }
        if ((j & 260) == 0) {
        }
    }
}
