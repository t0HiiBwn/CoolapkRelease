package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.goodsList.GoodsListDetailViewModel;
import com.coolapk.market.widget.AspectRatioImageView;
import com.dinuscxj.ellipsize.EllipsizeTextView;

public class ItemGoodsListEditHeaderBindingImpl extends ItemGoodsListEditHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362899, 7);
        sparseIntArray.put(2131363230, 8);
    }

    public ItemGoodsListEditHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemGoodsListEditHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[1], (LinearLayout) objArr[4], (FrameLayout) objArr[0], (EllipsizeTextView) objArr[6], (TextView) objArr[5], (AspectRatioImageView) objArr[2], (LinearLayout) objArr[7], (ImageView) objArr[3], (LinearLayout) objArr[8]);
        this.mDirtyFlags = -1;
        this.addPicView.setTag(null);
        this.contentTitle.setTag(null);
        this.contentView.setTag(null);
        this.etDes.setTag(null);
        this.etTitle.setTag(null);
        this.ivCover.setTag(null);
        this.picCloseView.setTag(null);
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
        if (197 == i) {
            setModel((GoodsListDetailViewModel) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListEditHeaderBinding
    public void setModel(GoodsListDetailViewModel goodsListDetailViewModel) {
        updateRegistration(0, goodsListDetailViewModel);
        this.mModel = goodsListDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemGoodsListEditHeaderBinding
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
        return onChangeModel((GoodsListDetailViewModel) obj, i2);
    }

    private boolean onChangeModel(GoodsListDetailViewModel goodsListDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 61) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 144) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 143) {
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
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        GoodsListDetailViewModel goodsListDetailViewModel = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        if ((61 & j) != 0) {
            str2 = ((j & 41) == 0 || goodsListDetailViewModel == null) ? null : goodsListDetailViewModel.getGoodsShowTitle();
            String coverUrl = ((j & 37) == 0 || goodsListDetailViewModel == null) ? null : goodsListDetailViewModel.getCoverUrl();
            if ((j & 49) == 0 || goodsListDetailViewModel == null) {
                str = coverUrl;
                str3 = null;
            } else {
                str3 = goodsListDetailViewModel.getGoodsShowMessage();
                str = coverUrl;
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 34) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.addPicView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.contentTitle, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.ivCover, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.picCloseView, onClickListener, bool);
        }
        if ((32 & j) != 0) {
            String str4 = null;
            ViewBindingAdapters.clipView(this.addPicView, str4, 8);
            ViewBindingAdapters.clipView(this.contentTitle, str4, 8);
        }
        if ((j & 49) != 0) {
            TextViewBindingAdapter.setText(this.etDes, str3);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.etTitle, str2);
        }
        if ((j & 37) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.ivCover, str, null, 0, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
        }
    }
}
