package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Album;
import com.coolapk.market.viewholder.AlbumViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class ItemAlbumBindingImpl extends ItemAlbumBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"feed_top"}, new int[]{5}, new int[]{2131558565});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363627, 6);
        sparseIntArray.put(2131363453, 7);
        sparseIntArray.put(2131363233, 8);
    }

    public ItemAlbumBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemAlbumBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CoolapkCardView) objArr[0], (RoundedImageView) objArr[2], (LinearLayout) objArr[1], (TextView) objArr[8], (LinearLayout) objArr[7], (TextView) objArr[3], (View) objArr[6], (FeedTopBinding) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.itemAlbumView.setTag(null);
        this.textView.setTag(null);
        setContainedBinding(this.topView);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.topView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.topView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8 == i) {
            setAlbum((Album) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewHolder((AlbumViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAlbumBinding
    public void setAlbum(Album album) {
        this.mAlbum = album;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumBinding
    public void setViewHolder(AlbumViewHolder albumViewHolder) {
        updateRegistration(1, albumViewHolder);
        this.mViewHolder = albumViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.topView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeTopView((FeedTopBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewHolder((AlbumViewHolder) obj, i2);
    }

    private boolean onChangeTopView(FeedTopBinding feedTopBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewHolder(AlbumViewHolder albumViewHolder, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i != 298) {
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
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Album album = this.mAlbum;
        AlbumViewHolder albumViewHolder = this.mViewHolder;
        int i = ((20 & j) > 0 ? 1 : ((20 & j) == 0 ? 0 : -1));
        if (i == 0 || album == null) {
            str2 = null;
            str = null;
        } else {
            String icon = album.getIcon();
            str2 = album.getTitle();
            str = icon;
        }
        int i2 = ((26 & j) > 0 ? 1 : ((26 & j) == 0 ? 0 : -1));
        String userName = (i2 == 0 || albumViewHolder == null) ? null : albumViewHolder.getUserName();
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.textView, str2);
        }
        if ((j & 18) != 0) {
            ViewBindingAdapters.clickListener(this.itemAlbumView, albumViewHolder, null);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.userNameView, userName);
        }
        executeBindingsOn(this.topView);
    }
}
