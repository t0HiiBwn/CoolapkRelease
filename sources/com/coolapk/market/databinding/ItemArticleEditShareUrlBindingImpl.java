package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.view.feedv8.ArticleShareUrl;

public class ItemArticleEditShareUrlBindingImpl extends ItemArticleEditShareUrlBinding {
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
        sparseIntArray.put(2131362484, 3);
    }

    public ItemArticleEditShareUrlBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemArticleEditShareUrlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.extendIcon.setTag(null);
        this.extendLayout.setTag(null);
        this.extendTitle.setTag(null);
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
        if (197 == i) {
            setModel((ArticleShareUrl) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemArticleEditShareUrlBinding
    public void setModel(ArticleShareUrl articleShareUrl) {
        this.mModel = articleShareUrl;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemArticleEditShareUrlBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
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
        ArticleShareUrl articleShareUrl = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i == 0 || articleShareUrl == null) {
            str2 = null;
            str = null;
        } else {
            String logo = articleShareUrl.getLogo();
            str2 = articleShareUrl.getTitle();
            str = logo;
        }
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.extendIcon, str, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
            TextViewBindingAdapter.setText(this.extendTitle, str2);
        }
        if ((j & 4) != 0) {
            String str3 = null;
            ViewBindingAdapters.clipView(this.extendIcon, str3, 8);
            ViewBindingAdapters.clipView(this.extendLayout, str3, 8);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.extendLayout, onClickListener, null);
        }
    }
}
