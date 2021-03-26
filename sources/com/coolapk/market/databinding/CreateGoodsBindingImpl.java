package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.ImageUrl;

public class CreateGoodsBindingImpl extends CreateGoodsBinding {
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
        sparseIntArray.put(2131363184, 5);
    }

    public CreateGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private CreateGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (LinearLayout) objArr[0], (ImageView) objArr[2], (RadioGroup) objArr[5], (EditText) objArr[3], (EditText) objArr[4]);
        this.mDirtyFlags = -1;
        this.actionDone.setTag(null);
        this.containerView.setTag(null);
        this.iconView.setTag(null);
        this.titleEditText.setTag(null);
        this.urlEditText.setTag(null);
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
        if (156 == i) {
            setImage((ImageUrl) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.CreateGoodsBinding
    public void setImage(ImageUrl imageUrl) {
        this.mImage = imageUrl;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(156);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.CreateGoodsBinding
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
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ImageUrl imageUrl = this.mImage;
        View.OnClickListener onClickListener = this.mClick;
        boolean z = false;
        int i = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i != 0) {
            if (imageUrl != null) {
                str = imageUrl.getCompressedUrl();
            } else {
                str = null;
            }
            if (str == null) {
                z = true;
            }
            if (i != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            str = null;
        }
        int i2 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((16 & j) == 0 || imageUrl == null) {
            str2 = null;
        } else {
            str2 = imageUrl.getSourceUrl();
        }
        int i3 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (z) {
                str = str2;
            }
            str3 = str;
        } else {
            str3 = null;
        }
        if ((j & 4) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionDone, "colorAccent");
            String str4 = null;
            ViewBindingAdapters.clipView(this.iconView, str4, 4);
            ViewBindingAdapters.clipView(this.titleEditText, str4, 4);
            ViewBindingAdapters.clipView(this.urlEditText, str4, 4);
        }
        if (i3 != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str3, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231707), 0, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, true, null, bool);
        }
        if (i2 != 0) {
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, null);
        }
    }
}
