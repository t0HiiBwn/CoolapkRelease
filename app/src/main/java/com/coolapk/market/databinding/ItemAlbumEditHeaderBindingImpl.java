package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.album.AlbumDetailViewModel;

public class ItemAlbumEditHeaderBindingImpl extends ItemAlbumEditHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363582, 7);
        sparseIntArray.put(2131362741, 8);
    }

    public ItemAlbumEditHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemAlbumEditHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[6], (ImageView) objArr[3], (TextView) objArr[5], (RelativeLayout) objArr[4], (TextView) objArr[8], (LinearLayout) objArr[0], (TextView) objArr[2], (RelativeLayout) objArr[1], (TextView) objArr[7]);
        this.mDirtyFlags = -1;
        this.editIntroView.setTag(null);
        this.editTitleView.setTag(null);
        this.introDetailView.setTag(null);
        this.introLayout.setTag(null);
        this.rootView.setTag(null);
        this.titleDetailView.setTag(null);
        this.titleLayout.setTag(null);
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
        if (197 == i) {
            setModel((AlbumDetailViewModel) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAlbumEditHeaderBinding
    public void setModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(0, albumDetailViewModel);
        this.mModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumEditHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((AlbumDetailViewModel) obj, i2);
    }

    private boolean onChangeModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i != 14) {
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
        AlbumDetailViewModel albumDetailViewModel = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        if ((29 & j) != 0) {
            str = ((j & 21) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            str2 = ((j & 25) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumIntro();
        } else {
            str2 = null;
            str = null;
        }
        if ((18 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.editIntroView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.editTitleView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.introLayout, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.titleLayout, onClickListener, bool);
        }
        if ((j & 25) != 0) {
            TextViewBindingAdapter.setText(this.introDetailView, str2);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(this.titleDetailView, str);
        }
    }
}
