package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.view.KeyBoardLayout;

public class CreateFunThingsBindingImpl extends CreateFunThingsBinding {
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
        sparseIntArray.put(2131363615, 7);
        sparseIntArray.put(2131362322, 8);
        sparseIntArray.put(2131362910, 9);
        sparseIntArray.put(2131363244, 10);
        sparseIntArray.put(2131362480, 11);
        sparseIntArray.put(2131362479, 12);
        sparseIntArray.put(2131362518, 13);
        sparseIntArray.put(2131362517, 14);
    }

    public CreateFunThingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private CreateFunThingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[4], (ImageView) objArr[1], (FrameLayout) objArr[8], (EditText) objArr[12], (EditText) objArr[11], (FrameLayout) objArr[14], (LinearLayout) objArr[13], (AspectRatioImageView) objArr[5], (KeyBoardLayout) objArr[0], (LinearLayout) objArr[9], (ImageView) objArr[6], (LinearLayout) objArr[10], (TextView) objArr[3], (TextView) objArr[2], (LinearLayout) objArr[7]);
        this.mDirtyFlags = -1;
        this.addPicView.setTag(null);
        this.closeView.setTag(null);
        this.ivCover.setTag(null);
        this.keyBoardInteractLayout.setTag(null);
        this.picCloseView.setTag(null);
        this.submitView.setTag(null);
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
        if (6 == i) {
            setActionTitle((String) obj);
        } else if (50 == i) {
            setClick((View.OnClickListener) obj);
        } else if (284 != i) {
            return false;
        } else {
            setToolbarTitle((String) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.CreateFunThingsBinding
    public void setActionTitle(String str) {
        this.mActionTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.CreateFunThingsBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.CreateFunThingsBinding
    public void setToolbarTitle(String str) {
        this.mToolbarTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(284);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mActionTitle;
        View.OnClickListener onClickListener = this.mClick;
        String str2 = this.mToolbarTitle;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        int i2 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((10 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.addPicView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.closeView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.picCloseView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.submitView, onClickListener, bool);
        }
        if ((j & 8) != 0) {
            String str3 = null;
            ViewBindingAdapters.clipView(this.addPicView, str3, 8);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.ivCover, str3, null, 0, 0, bool2, bool2, bool2, bool2, bool2, str3, null, null, bool2, bool2, true, null, bool2);
            ThemeBindingAdapters.setTextColor(this.submitView, "colorAccent");
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.submitView, str);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.titleView, str2);
        }
    }
}
