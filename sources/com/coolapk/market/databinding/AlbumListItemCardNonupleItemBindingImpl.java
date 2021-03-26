package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.Album;
import com.coolapk.market.viewholder.GridAlbumCardViewHolder;

public class AlbumListItemCardNonupleItemBindingImpl extends AlbumListItemCardNonupleItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    public AlbumListItemCardNonupleItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private AlbumListItemCardNonupleItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[3], (ImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.apkNumView.setTag(null);
        this.iconView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (8 == i) {
            setAlbum((Album) obj);
        } else if (307 != i) {
            return false;
        } else {
            setViewHolder((GridAlbumCardViewHolder.DataViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumListItemCardNonupleItemBinding
    public void setAlbum(Album album) {
        this.mAlbum = album;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AlbumListItemCardNonupleItemBinding
    public void setViewHolder(GridAlbumCardViewHolder.DataViewHolder dataViewHolder) {
        this.mViewHolder = dataViewHolder;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((GridAlbumCardViewHolder.DataViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(GridAlbumCardViewHolder.DataViewHolder dataViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Album album = this.mAlbum;
        int i = 0;
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (album != null) {
                str4 = album.getLogo();
                i = album.getTotalApkNum();
                str3 = album.getTitle();
            } else {
                str3 = null;
                str4 = null;
            }
            str2 = i + "个应用";
            str = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.apkNumView, str2);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
    }
}
