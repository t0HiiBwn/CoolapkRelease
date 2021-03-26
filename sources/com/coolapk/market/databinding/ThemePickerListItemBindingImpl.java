package com.coolapk.market.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.AppTheme;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.theme.ThemeListActivity;

public class ThemePickerListItemBindingImpl extends ThemePickerListItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362231, 4);
    }

    public ThemePickerListItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ThemePickerListItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.colorText.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.textView.setTag(null);
        this.tipText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (276 == i) {
            setThemeItem((AppTheme.ThemeItem) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewHolder((ThemeListActivity.ThemePickerFragment.ThemeViewHolder) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ThemePickerListItemBinding
    public void setThemeItem(AppTheme.ThemeItem themeItem) {
        this.mThemeItem = themeItem;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ThemePickerListItemBinding
    public void setViewHolder(ThemeListActivity.ThemePickerFragment.ThemeViewHolder themeViewHolder) {
        updateRegistration(0, themeViewHolder);
        this.mViewHolder = themeViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewHolder((ThemeListActivity.ThemePickerFragment.ThemeViewHolder) obj, i2);
    }

    private boolean onChangeViewHolder(ThemeListActivity.ThemePickerFragment.ThemeViewHolder themeViewHolder, int i) {
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
        String str;
        String str2;
        int i;
        Resources resources;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = false;
        AppTheme.ThemeItem themeItem = this.mThemeItem;
        ThemeListActivity.ThemePickerFragment.ThemeViewHolder themeViewHolder = this.mViewHolder;
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (themeItem != null) {
                z = themeItem.isCurrentTheme();
                str = themeItem.getLabel();
            } else {
                str = null;
            }
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (z) {
                resources = this.textView.getResources();
                i = 2131886151;
            } else {
                resources = this.textView.getResources();
                i = 2131886152;
            }
            str2 = resources.getString(i);
        } else {
            str2 = null;
            str = null;
        }
        int i3 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if ((6 & j) != 0) {
            TextViewBindingAdapter.setText(this.colorText, str);
            TextViewBindingAdapter.setText(this.textView, str2);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.mboundView0, themeViewHolder, bool);
            ViewBindingAdapters.clickListener(this.textView, themeViewHolder, bool);
        }
        if ((j & 4) != 0) {
            ViewBindingAdapters.clipView(this.tipText, "capsule", null);
        }
    }
}
