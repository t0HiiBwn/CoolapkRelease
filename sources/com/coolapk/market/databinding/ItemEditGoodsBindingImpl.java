package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.view.goodsList.GoodsListItemViewModel;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;

public class ItemEditGoodsBindingImpl extends ItemEditGoodsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362234, 6);
        sparseIntArray.put(2131362433, 7);
    }

    public ItemEditGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemEditGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[1], (CheckBox) objArr[6], (CoolapkCardView) objArr[0], (ImageView) objArr[7], (ImageView) objArr[2], (ImageView) objArr[4], (CoolEllipsizeTextView) objArr[3], (CoolEllipsizeTextView) objArr[5]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.iconView.setTag(null);
        this.noteEdit.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
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
        if (198 == i) {
            setModel((GoodsListItemViewModel) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemEditGoodsBinding
    public void setModel(GoodsListItemViewModel goodsListItemViewModel) {
        updateRegistration(0, goodsListItemViewModel);
        this.mModel = goodsListItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemEditGoodsBinding
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
        return onChangeModel((GoodsListItemViewModel) obj, i2);
    }

    private boolean onChangeModel(GoodsListItemViewModel goodsListItemViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 227) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 228) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i != 140) {
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
        GoodsListItemViewModel goodsListItemViewModel = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        if ((61 & j) != 0) {
            str3 = ((j & 41) == 0 || goodsListItemViewModel == null) ? null : goodsListItemViewModel.getProductGoodsTitle();
            str2 = ((j & 49) == 0 || goodsListItemViewModel == null) ? null : goodsListItemViewModel.getGoodsListItemNote();
            str = ((j & 37) == 0 || goodsListItemViewModel == null) ? null : goodsListItemViewModel.getProductGoodsLogo();
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 34) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.noteEdit, onClickListener, bool);
        }
        if ((37 & j) != 0) {
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool2, bool2, bool2, bool2, bool2, null, null, null, bool2, bool2, true, null, bool2);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        if ((j & 49) != 0) {
            TextViewBindingAdapter.setText(this.versionView, str2);
        }
    }
}
