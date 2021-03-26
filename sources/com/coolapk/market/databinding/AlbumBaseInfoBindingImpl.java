package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.viewholder.AlbumBaseViewHolder;
import com.coolapk.market.widget.AutoLinkTextView;

public class AlbumBaseInfoBindingImpl extends AlbumBaseInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363233, 2);
    }

    public AlbumBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private AlbumBaseInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AutoLinkTextView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[2]);
        this.mDirtyFlags = -1;
        this.introduceShadowView.setTag(null);
        this.introduceView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (308 == i) {
            setViewHolder((AlbumBaseViewHolder) obj);
        } else if (309 != i) {
            return false;
        } else {
            setViewModel((AlbumDetailViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumBaseInfoBinding
    public void setViewHolder(AlbumBaseViewHolder albumBaseViewHolder) {
        this.mViewHolder = albumBaseViewHolder;
    }

    @Override // com.coolapk.market.databinding.AlbumBaseInfoBinding
    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(1, albumDetailViewModel);
        this.mViewModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(309);
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
        } else if (i != 14) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        String str = null;
        int i = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
        if (!(i == 0 || albumDetailViewModel == null)) {
            str = albumDetailViewModel.getAlbumIntro();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.introduceShadowView, str);
        }
    }
}
