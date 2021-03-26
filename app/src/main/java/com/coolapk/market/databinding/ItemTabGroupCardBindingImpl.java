package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.GridCard;
import com.coolapk.market.model.TabGroupCard;
import java.util.List;

public class ItemTabGroupCardBindingImpl extends ItemTabGroupCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362970, 5);
        sparseIntArray.put(2131363483, 6);
        sparseIntArray.put(2131363484, 7);
        sparseIntArray.put(2131362634, 8);
    }

    public ItemTabGroupCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemTabGroupCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (RecyclerView) objArr[8], (FrameLayout) objArr[5], (LinearLayout) objArr[6], (LinearLayout) objArr[7], (ImageView) objArr[2], (ImageView) objArr[4], (TextView) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.tabViewIndicator1.setTag(null);
        this.tabViewIndicator2.setTag(null);
        this.tabViewText1.setTag(null);
        this.tabViewText2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (44 != i) {
            return false;
        }
        setCard((TabGroupCard) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTabGroupCardBinding
    public void setCard(TabGroupCard tabGroupCard) {
        this.mCard = tabGroupCard;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        GridCard gridCard;
        GridCard gridCard2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        TabGroupCard tabGroupCard = this.mCard;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            List<GridCard> entities = tabGroupCard != null ? tabGroupCard.getEntities() : null;
            if (entities != null) {
                gridCard = (GridCard) getFromList(entities, 1);
                gridCard2 = (GridCard) getFromList(entities, 0);
            } else {
                gridCard2 = null;
                gridCard = null;
            }
            str = gridCard != null ? gridCard.getTitle() : null;
            str2 = gridCard2 != null ? gridCard2.getTitle() : null;
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 2) != 0) {
            Drawable drawable = null;
            Boolean bool = null;
            String str3 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.tabViewIndicator1, "colorAccent", drawable, 0, 0, bool, bool, bool, bool, bool, str3, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener, bool);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.tabViewIndicator2, "colorAccent", drawable, 0, 0, bool, bool, bool, bool, bool, str3, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener, bool);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tabViewText1, str2);
            TextViewBindingAdapter.setText(this.tabViewText2, str);
        }
    }
}
