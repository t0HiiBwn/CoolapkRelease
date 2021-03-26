package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.HolderItem;

public class ItemBackupHeaderBindingImpl extends ItemBackupHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362889, 6);
        sparseIntArray.put(2131362330, 7);
    }

    public ItemBackupHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemBackupHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (LinearLayout) objArr[7], (TextView) objArr[2], (ProgressBar) objArr[4], (ImageView) objArr[6], (LinearLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.desView.setTag(null);
        this.loadingView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        this.rootView.setTag(null);
        this.titleView.setTag(null);
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
            setModel((HolderItem) obj);
        } else if (58 == i) {
            setCount((String) obj);
        } else if (287 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (276 != i) {
            return false;
        } else {
            setTime((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderBinding
    public void setModel(HolderItem holderItem) {
        this.mModel = holderItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderBinding
    public void setCount(String str) {
        this.mCount = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(58);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemBackupHeaderBinding
    public void setTime(String str) {
        this.mTime = str;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
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
        HolderItem holderItem = this.mModel;
        String str3 = this.mCount;
        View.OnClickListener onClickListener = this.mClick;
        String str4 = this.mTime;
        int i = ((33 & j) > 0 ? 1 : ((33 & j) == 0 ? 0 : -1));
        if (i == 0 || holderItem == null) {
            str2 = null;
            str = null;
        } else {
            str = holderItem.getString();
            str2 = holderItem.getValue();
        }
        int i2 = ((34 & j) > 0 ? 1 : ((34 & j) == 0 ? 0 : -1));
        int i3 = ((40 & j) > 0 ? 1 : ((40 & j) == 0 ? 0 : -1));
        int i4 = ((48 & j) > 0 ? 1 : ((48 & j) == 0 ? 0 : -1));
        if (i != 0) {
            TextViewBindingAdapter.setText(this.actionView, str2);
            TextViewBindingAdapter.setText(this.titleView, str);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.rootView, onClickListener, bool);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.desView, str4);
        }
        if ((j & 32) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str3);
        }
    }
}
