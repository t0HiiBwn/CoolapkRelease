package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.viewholder.AlbumBaseViewHolder;
import com.coolapk.market.widget.AlbumActionView;

public class AlbumItemBaseInfoBindingImpl extends AlbumItemBaseInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public AlbumItemBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private AlbumItemBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AlbumActionView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.albumAction.setTag(null);
        this.introduceShadowView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
        if (307 == i) {
            setViewHolder((AlbumBaseViewHolder) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumDetailViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumItemBaseInfoBinding
    public void setViewHolder(AlbumBaseViewHolder albumBaseViewHolder) {
        this.mViewHolder = albumBaseViewHolder;
    }

    @Override // com.coolapk.market.databinding.AlbumItemBaseInfoBinding
    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(1, albumDetailViewModel);
        this.mViewModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewHolder((AlbumBaseViewHolder) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AlbumDetailViewModel) obj, i2);
    }

    private boolean onChangeViewHolder(AlbumBaseViewHolder albumBaseViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 19) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 14) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 8) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Integer num;
        String str;
        Album album;
        String str2;
        Integer num2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        if ((62 & j) != 0) {
            if ((j & 46) == 0 || albumDetailViewModel == null) {
                num2 = null;
                str2 = null;
            } else {
                num2 = albumDetailViewModel.getAlbumMaxWords();
                str2 = albumDetailViewModel.getAlbumIntro();
            }
            if ((j & 50) == 0 || albumDetailViewModel == null) {
                num = num2;
                str = str2;
                album = null;
            } else {
                album = albumDetailViewModel.getAlbum();
                num = num2;
                str = str2;
            }
        } else {
            album = null;
            str = null;
            num = null;
        }
        if ((j & 50) != 0) {
            ViewBindingAdapters.updateAlbum(this.albumAction, album);
        }
        if ((j & 46) != 0) {
            String str3 = null;
            TextViewBindingAdapters.setTextViewLinkable(this.introduceShadowView, str, num, str3, null, null, str3);
        }
    }
}
