package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;

public class NewV8AlbumBindingImpl extends NewV8AlbumBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362121, 6);
        sparseIntArray.put(2131362205, 7);
        sparseIntArray.put(2131362069, 8);
        sparseIntArray.put(2131363610, 9);
    }

    public NewV8AlbumBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private NewV8AlbumBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AppBarLayout) objArr[8], (UserAvatarView) objArr[4], (View) objArr[6], (CardView) objArr[7], (ImageView) objArr[1], (TextView) objArr[5], (CoordinatorLayout) objArr[0], (TextView) objArr[3], (Toolbar) objArr[9], (ScrollStateViewPager) objArr[2]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.coverView.setTag(null);
        this.infoView.setTag(null);
        this.mainContent.setTag(null);
        this.titleView.setTag(null);
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

    @Override // com.coolapk.market.databinding.NewV8AlbumBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.NewV8AlbumBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // com.coolapk.market.databinding.NewV8AlbumBinding
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
        } else if (i == 171) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 294) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 8) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i != 13) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        int i2;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        int i3 = 0;
        if ((505 & j) != 0) {
            str4 = ((j & 273) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            str3 = ((j & 385) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumInfo();
            if ((j & 321) != 0) {
                Album album = albumDetailViewModel != null ? albumDetailViewModel.getAlbum() : null;
                UserInfo userInfo = album != null ? album.getUserInfo() : null;
                if (userInfo != null) {
                    str5 = userInfo.getVerifyStatusIcon();
                    String userAvatar = ((j & 289) != 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getUserAvatar();
                    i2 = ((j & 265) > 0 ? 1 : ((j & 265) == 0 ? 0 : -1));
                    if (i2 == 0) {
                        if (albumDetailViewModel != null) {
                            z = albumDetailViewModel.getIsLoading();
                        } else {
                            z = false;
                        }
                        if (i2 != 0) {
                            j |= z ? 1024 : 512;
                        }
                        if (z) {
                            i3 = 8;
                        }
                        i = i3;
                        str2 = str5;
                        str = userAvatar;
                        if ((j & 289) != 0) {
                            Boolean bool = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
                        }
                        if ((321 & j) != 0) {
                            ImageViewBindingAdapters.setVipSignView(this.avatarView, str2, null);
                        }
                        if ((256 & j) != 0) {
                            String str6 = null;
                            Boolean bool2 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str6, null, 0, 0, bool2, bool2, bool2, bool2, bool2, str6, null, null, true, bool2, bool2, null, bool2);
                        }
                        if ((j & 385) != 0) {
                            TextViewBindingAdapter.setText(this.infoView, str3);
                        }
                        if ((j & 273) != 0) {
                            TextViewBindingAdapter.setText(this.titleView, str4);
                        }
                        if ((j & 265) == 0) {
                            this.viewPager.setVisibility(i);
                            return;
                        }
                        return;
                    }
                    str2 = str5;
                    str = userAvatar;
                }
            }
            str5 = null;
            if ((j & 289) != 0) {
            }
            i2 = ((j & 265) > 0 ? 1 : ((j & 265) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        if ((j & 289) != 0) {
        }
        if ((321 & j) != 0) {
        }
        if ((256 & j) != 0) {
        }
        if ((j & 385) != 0) {
        }
        if ((j & 273) != 0) {
        }
        if ((j & 265) == 0) {
        }
    }
}
