package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

public class ItemMainCategoryLinkBindingImpl extends ItemMainCategoryLinkBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TableLayout mboundView0;
    private final TableRow mboundView1;
    private final TableRow mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_main_category_child", "item_main_category_child"}, new int[]{3, 4}, new int[]{2131558824, 2131558824});
        includedLayouts.setIncludes(2, new String[]{"item_main_category_child", "item_main_category_child"}, new int[]{5, 6}, new int[]{2131558824, 2131558824});
    }

    public ItemMainCategoryLinkBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemMainCategoryLinkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ItemMainCategoryChildBinding) objArr[3], (ItemMainCategoryChildBinding) objArr[4], (ItemMainCategoryChildBinding) objArr[5], (ItemMainCategoryChildBinding) objArr[6]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.itemView1);
        setContainedBinding(this.itemView2);
        setContainedBinding(this.itemView3);
        setContainedBinding(this.itemView4);
        TableLayout tableLayout = (TableLayout) objArr[0];
        this.mboundView0 = tableLayout;
        tableLayout.setTag(null);
        TableRow tableRow = (TableRow) objArr[1];
        this.mboundView1 = tableRow;
        tableRow.setTag(null);
        TableRow tableRow2 = (TableRow) objArr[2];
        this.mboundView2 = tableRow2;
        tableRow2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.itemView1.invalidateAll();
        this.itemView2.invalidateAll();
        this.itemView3.invalidateAll();
        this.itemView4.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.itemView1.hasPendingBindings() && !this.itemView2.hasPendingBindings() && !this.itemView3.hasPendingBindings() && !this.itemView4.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.itemView1.setLifecycleOwner(lifecycleOwner);
        this.itemView2.setLifecycleOwner(lifecycleOwner);
        this.itemView3.setLifecycleOwner(lifecycleOwner);
        this.itemView4.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeItemView4((ItemMainCategoryChildBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeItemView3((ItemMainCategoryChildBinding) obj, i2);
        }
        if (i == 2) {
            return onChangeItemView2((ItemMainCategoryChildBinding) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeItemView1((ItemMainCategoryChildBinding) obj, i2);
    }

    private boolean onChangeItemView4(ItemMainCategoryChildBinding itemMainCategoryChildBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeItemView3(ItemMainCategoryChildBinding itemMainCategoryChildBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemView2(ItemMainCategoryChildBinding itemMainCategoryChildBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeItemView1(ItemMainCategoryChildBinding itemMainCategoryChildBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.itemView1);
        executeBindingsOn(this.itemView2);
        executeBindingsOn(this.itemView3);
        executeBindingsOn(this.itemView4);
    }
}
