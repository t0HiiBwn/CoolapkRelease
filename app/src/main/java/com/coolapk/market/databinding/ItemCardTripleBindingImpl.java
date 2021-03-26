package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.model.Card;

public class ItemCardTripleBindingImpl extends ItemCardTripleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(3, new String[]{"item_card_triple_item", "item_card_triple_item", "item_card_triple_item"}, new int[]{4, 5, 6}, new int[]{2131558635, 2131558635, 2131558635});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362200, 7);
    }

    public ItemCardTripleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemCardTripleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LinearLayout) objArr[7], (ItemCardTripleItemBinding) objArr[4], (ItemCardTripleItemBinding) objArr[5], (ItemCardTripleItemBinding) objArr[6], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.itemView1);
        setContainedBinding(this.itemView2);
        setContainedBinding(this.itemView3);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout2;
        linearLayout2.setTag(null);
        this.moreView.setTag(null);
        this.titleView.setTag(null);
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
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.itemView1.hasPendingBindings() && !this.itemView2.hasPendingBindings() && !this.itemView3.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (44 != i) {
            return false;
        }
        setCard((Card) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCardTripleBinding
    public void setCard(Card card) {
        this.mCard = card;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.itemView1.setLifecycleOwner(lifecycleOwner);
        this.itemView2.setLifecycleOwner(lifecycleOwner);
        this.itemView3.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeItemView3((ItemCardTripleItemBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeItemView2((ItemCardTripleItemBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeItemView1((ItemCardTripleItemBinding) obj, i2);
    }

    private boolean onChangeItemView3(ItemCardTripleItemBinding itemCardTripleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeItemView2(ItemCardTripleItemBinding itemCardTripleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemView1(ItemCardTripleItemBinding itemCardTripleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
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
        Card card = this.mCard;
        String str = null;
        int i = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if (!(i == 0 || card == null)) {
            str = card.getTitle();
        }
        if ((j & 16) != 0) {
            ThemeBindingAdapters.setTextColor(this.moreView, "colorAccent");
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        executeBindingsOn(this.itemView1);
        executeBindingsOn(this.itemView2);
        executeBindingsOn(this.itemView3);
    }
}
