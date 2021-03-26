package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Collection;

public class ItemCollectionSelectBindingImpl extends ItemCollectionSelectBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemCollectionSelectBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemCollectionSelectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (LinearLayout) objArr[0], (CheckBox) objArr[4], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.infoView.setTag(null);
        this.itemView.setTag(null);
        this.selectView.setTag(null);
        this.statusView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            setModel((Collection) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCollectionSelectBinding
    public void setModel(Collection collection) {
        this.mModel = collection;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemCollectionSelectBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemCollectionSelectBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
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
        Collection collection = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if (i == 0 || collection == null) {
            str3 = null;
            str2 = null;
            str = null;
        } else {
            str2 = collection.getTitle();
            str = collection.getSubDes();
            str3 = collection.getStatusText();
        }
        int i2 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if (i != 0) {
            TextViewBindingAdapter.setText(this.infoView, str);
            TextViewBindingAdapter.setText(this.statusView, str3);
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, null);
        }
        if ((j & 8) != 0) {
            ThemeBindingAdapters.setTint(this.selectView, "colorAccent");
        }
    }
}
