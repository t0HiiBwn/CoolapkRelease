package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class AddGoodsItemDialogBindingImpl extends AddGoodsItemDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362637, 7);
        sparseIntArray.put(2131362448, 8);
        sparseIntArray.put(2131362200, 9);
    }

    public AddGoodsItemDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AddGoodsItemDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (LinearLayout) objArr[0], (EditText) objArr[8], (LinearLayout) objArr[7], (ProgressBar) objArr[6], (ImageView) objArr[3], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.contentView.setTag(null);
        this.loadingView.setTag(null);
        this.logoView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.okButton.setTag(null);
        this.textView.setTag(null);
        this.titleView.setTag(null);
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
        if (190 == i) {
            setLogo((String) obj);
        } else if (74 == i) {
            setDialogTitle((String) obj);
        } else if (272 == i) {
            setSubTitle((String) obj);
        } else if (279 != i) {
            return false;
        } else {
            setTitle((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AddGoodsItemDialogBinding
    public void setLogo(String str) {
        this.mLogo = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(190);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AddGoodsItemDialogBinding
    public void setDialogTitle(String str) {
        this.mDialogTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(74);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AddGoodsItemDialogBinding
    public void setSubTitle(String str) {
        this.mSubTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(272);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AddGoodsItemDialogBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(279);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str3 = this.mLogo;
        String str4 = this.mDialogTitle;
        String str5 = this.mSubTitle;
        String str6 = this.mTitle;
        int i3 = 0;
        int i4 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i4 != 0) {
            boolean isEmpty = TextUtils.isEmpty(str5);
            if (i4 != 0) {
                j |= isEmpty ? 64 : 32;
            }
            if (isEmpty) {
                i3 = 8;
            }
            i = i3;
        } else {
            i = 0;
        }
        int i5 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if ((16 & j) != 0) {
            ThemeBindingAdapters.setIndeterminateTint(this.loadingView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.okButton, "colorAccent");
        }
        if ((17 & j) != 0) {
            Boolean bool = null;
            i2 = i;
            str2 = str6;
            str = str5;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str3, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
        } else {
            str = str5;
            str2 = str6;
            i2 = i;
        }
        if (i5 != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if ((j & 20) != 0) {
            TextViewBindingAdapter.setText(this.textView, str);
            this.textView.setVisibility(i2);
        }
        if ((j & 18) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
    }
}
