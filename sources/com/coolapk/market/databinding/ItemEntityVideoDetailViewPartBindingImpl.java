package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.viewholder.EntityItemModel;

public class ItemEntityVideoDetailViewPartBindingImpl extends ItemEntityVideoDetailViewPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(5, new String[]{"item_app_inside_image_card"}, new int[]{9}, new int[]{2131558592});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363912, 10);
        sparseIntArray.put(2131363604, 11);
        sparseIntArray.put(2131363582, 12);
        sparseIntArray.put(2131362131, 13);
        sparseIntArray.put(2131362348, 14);
        sparseIntArray.put(2131363332, 15);
        sparseIntArray.put(2131363613, 16);
        sparseIntArray.put(2131362873, 17);
        sparseIntArray.put(2131362872, 18);
        sparseIntArray.put(2131363146, 19);
    }

    public ItemEntityVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ItemEntityVideoDetailViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[13], (CoolapkCardView) objArr[5], (TextView) objArr[14], (ImageView) objArr[7], (ItemAppInsideImageCardBinding) objArr[9], (FrameLayout) objArr[0], (TextView) objArr[18], (LinearLayout) objArr[17], (ImageView) objArr[4], (ImageView) objArr[1], (ImageView) objArr[3], (ImageView) objArr[6], (ProgressBar) objArr[19], (LinearLayout) objArr[8], (SeekBar) objArr[15], (TextView) objArr[12], (LinearLayout) objArr[11], (TextView) objArr[16], (FrameLayout) objArr[10], (ImageView) objArr[2]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.fullScreenView.setTag(null);
        setContainedBinding(this.includeApp);
        this.itemView.setTag(null);
        this.moreView.setTag(null);
        this.navigationView.setTag(null);
        this.pipView.setTag(null);
        this.playView.setTag(null);
        this.replayView.setTag(null);
        this.volumeView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.includeApp.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.includeApp.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (197 == i) {
            setModel((EntityItemModel) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemEntityVideoDetailViewPartBinding
    public void setModel(EntityItemModel entityItemModel) {
        this.mModel = entityItemModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemEntityVideoDetailViewPartBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeApp.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeIncludeApp((ItemAppInsideImageCardBinding) obj, i2);
    }

    private boolean onChangeIncludeApp(ItemAppInsideImageCardBinding itemAppInsideImageCardBinding, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EntityItemModel entityItemModel = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((10 & j) > 0 ? 1 : ((10 & j) == 0 ? 0 : -1));
        if ((j & 12) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.fullScreenView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.navigationView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.pipView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.playView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.replayView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.volumeView, onClickListener, bool);
        }
        if (i != 0) {
            this.includeApp.setModel(entityItemModel);
        }
        executeBindingsOn(this.includeApp);
    }
}
