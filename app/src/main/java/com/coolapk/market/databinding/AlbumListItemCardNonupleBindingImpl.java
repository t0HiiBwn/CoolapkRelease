package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Card;
import com.coolapk.market.viewholder.AlbumMainCardViewHolder;

public class AlbumListItemCardNonupleBindingImpl extends AlbumListItemCardNonupleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView3;
    private final LinearLayout mboundView4;
    private final LinearLayout mboundView5;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(3, new String[]{"album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item"}, new int[]{6, 7, 8, 9}, new int[]{2131558449, 2131558449, 2131558449, 2131558449});
        includedLayouts.setIncludes(4, new String[]{"album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item"}, new int[]{10, 11, 12, 13}, new int[]{2131558449, 2131558449, 2131558449, 2131558449});
        includedLayouts.setIncludes(5, new String[]{"album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item", "album_list_item_card_nonuple_item"}, new int[]{14, 15, 16, 17}, new int[]{2131558449, 2131558449, 2131558449, 2131558449});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362652, 18);
        sparseIntArray.put(2131362644, 19);
    }

    public AlbumListItemCardNonupleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private AlbumListItemCardNonupleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (LinearLayout) objArr[0], (ImageView) objArr[19], (TextView) objArr[2], (TextView) objArr[1], (LinearLayout) objArr[18], (AlbumListItemCardNonupleItemBinding) objArr[6], (AlbumListItemCardNonupleItemBinding) objArr[15], (AlbumListItemCardNonupleItemBinding) objArr[16], (AlbumListItemCardNonupleItemBinding) objArr[17], (AlbumListItemCardNonupleItemBinding) objArr[7], (AlbumListItemCardNonupleItemBinding) objArr[8], (AlbumListItemCardNonupleItemBinding) objArr[9], (AlbumListItemCardNonupleItemBinding) objArr[10], (AlbumListItemCardNonupleItemBinding) objArr[11], (AlbumListItemCardNonupleItemBinding) objArr[12], (AlbumListItemCardNonupleItemBinding) objArr[13], (AlbumListItemCardNonupleItemBinding) objArr[14]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.headerMoreView.setTag(null);
        this.headerTitleView.setTag(null);
        setContainedBinding(this.itemView1);
        setContainedBinding(this.itemView10);
        setContainedBinding(this.itemView11);
        setContainedBinding(this.itemView12);
        setContainedBinding(this.itemView2);
        setContainedBinding(this.itemView3);
        setContainedBinding(this.itemView4);
        setContainedBinding(this.itemView5);
        setContainedBinding(this.itemView6);
        setContainedBinding(this.itemView7);
        setContainedBinding(this.itemView8);
        setContainedBinding(this.itemView9);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[4];
        this.mboundView4 = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[5];
        this.mboundView5 = linearLayout3;
        linearLayout3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16384;
        }
        this.itemView1.invalidateAll();
        this.itemView2.invalidateAll();
        this.itemView3.invalidateAll();
        this.itemView4.invalidateAll();
        this.itemView5.invalidateAll();
        this.itemView6.invalidateAll();
        this.itemView7.invalidateAll();
        this.itemView8.invalidateAll();
        this.itemView9.invalidateAll();
        this.itemView10.invalidateAll();
        this.itemView11.invalidateAll();
        this.itemView12.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.itemView1.hasPendingBindings() && !this.itemView2.hasPendingBindings() && !this.itemView3.hasPendingBindings() && !this.itemView4.hasPendingBindings() && !this.itemView5.hasPendingBindings() && !this.itemView6.hasPendingBindings() && !this.itemView7.hasPendingBindings() && !this.itemView8.hasPendingBindings() && !this.itemView9.hasPendingBindings() && !this.itemView10.hasPendingBindings() && !this.itemView11.hasPendingBindings() && !this.itemView12.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (44 == i) {
            setCard((Card) obj);
        } else if (307 != i) {
            return false;
        } else {
            setViewHolder((AlbumMainCardViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumListItemCardNonupleBinding
    public void setCard(Card card) {
        this.mCard = card;
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AlbumListItemCardNonupleBinding
    public void setViewHolder(AlbumMainCardViewHolder albumMainCardViewHolder) {
        updateRegistration(12, albumMainCardViewHolder);
        this.mViewHolder = albumMainCardViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.itemView1.setLifecycleOwner(lifecycleOwner);
        this.itemView2.setLifecycleOwner(lifecycleOwner);
        this.itemView3.setLifecycleOwner(lifecycleOwner);
        this.itemView4.setLifecycleOwner(lifecycleOwner);
        this.itemView5.setLifecycleOwner(lifecycleOwner);
        this.itemView6.setLifecycleOwner(lifecycleOwner);
        this.itemView7.setLifecycleOwner(lifecycleOwner);
        this.itemView8.setLifecycleOwner(lifecycleOwner);
        this.itemView9.setLifecycleOwner(lifecycleOwner);
        this.itemView10.setLifecycleOwner(lifecycleOwner);
        this.itemView11.setLifecycleOwner(lifecycleOwner);
        this.itemView12.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeItemView7((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 1:
                return onChangeItemView6((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 2:
                return onChangeItemView5((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 3:
                return onChangeItemView12((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 4:
                return onChangeItemView4((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 5:
                return onChangeItemView11((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 6:
                return onChangeItemView10((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 7:
                return onChangeItemView9((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 8:
                return onChangeItemView8((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 9:
                return onChangeItemView3((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 10:
                return onChangeItemView2((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 11:
                return onChangeItemView1((AlbumListItemCardNonupleItemBinding) obj, i2);
            case 12:
                return onChangeViewHolder((AlbumMainCardViewHolder) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeItemView7(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeItemView6(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemView5(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeItemView12(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeItemView4(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeItemView11(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeItemView10(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeItemView9(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeItemView8(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeItemView3(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeItemView2(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeItemView1(AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewHolder(AlbumMainCardViewHolder albumMainCardViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
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
        AlbumMainCardViewHolder albumMainCardViewHolder = this.mViewHolder;
        int i = ((24576 & j) > 0 ? 1 : ((24576 & j) == 0 ? 0 : -1));
        String title = (i == 0 || card == null) ? null : card.getTitle();
        int i2 = ((20480 & j) > 0 ? 1 : ((20480 & j) == 0 ? 0 : -1));
        if ((j & 16384) != 0) {
            ThemeBindingAdapters.setTextColor(this.headerMoreView, "colorAccent");
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.headerMoreView, albumMainCardViewHolder, null);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.headerTitleView, title);
        }
        executeBindingsOn(this.itemView1);
        executeBindingsOn(this.itemView2);
        executeBindingsOn(this.itemView3);
        executeBindingsOn(this.itemView4);
        executeBindingsOn(this.itemView5);
        executeBindingsOn(this.itemView6);
        executeBindingsOn(this.itemView7);
        executeBindingsOn(this.itemView8);
        executeBindingsOn(this.itemView9);
        executeBindingsOn(this.itemView10);
        executeBindingsOn(this.itemView11);
        executeBindingsOn(this.itemView12);
    }
}
