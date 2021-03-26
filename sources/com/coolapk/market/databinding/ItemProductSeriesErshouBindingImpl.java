package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Product;

public class ItemProductSeriesErshouBindingImpl extends ItemProductSeriesErshouBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemProductSeriesErshouBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemProductSeriesErshouBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (LinearLayout) objArr[1], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        this.itemView.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
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
        if (198 == i) {
            setModel1((Product) obj);
        } else if (199 == i) {
            setModel2((Product) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesErshouBinding
    public void setModel1(Product product) {
        this.mModel1 = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesErshouBinding
    public void setModel2(Product product) {
        this.mModel2 = product;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(199);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesErshouBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Product product = this.mModel1;
        Product product2 = this.mModel2;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = 8;
        boolean z = true;
        int i5 = 0;
        int i6 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean z2 = product != null;
            if (i6 != 0) {
                j |= z2 ? 32 : 16;
            }
            if (product != null) {
                str = product.getSecondHandNumText();
            } else {
                str = null;
            }
            if (!z2) {
                i = 8;
                i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
                if (i2 == 0) {
                    if (product2 != null) {
                        str3 = product2.getSecondHandNumText();
                    } else {
                        str3 = null;
                    }
                    if (product2 == null) {
                        z = false;
                    }
                    if (i2 != 0) {
                        j |= z ? 128 : 64;
                    }
                    if (z) {
                        i4 = 0;
                    }
                    i5 = i4;
                    str2 = str3;
                } else {
                    str2 = null;
                }
                i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
                if ((9 & j) != 0) {
                    this.itemView1.setVisibility(i);
                    TextViewBindingAdapter.setText(this.mboundView2, str);
                }
                if (i3 != 0) {
                    Boolean bool = null;
                    ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool);
                    ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool);
                }
                if ((8 & j) != 0) {
                    String str4 = null;
                    ViewBindingAdapters.clipView(this.itemView1, str4, 3);
                    ViewBindingAdapters.clipView(this.itemView2, str4, 3);
                }
                if ((j & 10) == 0) {
                    this.itemView2.setVisibility(i5);
                    TextViewBindingAdapter.setText(this.mboundView4, str2);
                    return;
                }
                return;
            }
        } else {
            str = null;
        }
        i = 0;
        i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i2 == 0) {
        }
        i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if ((9 & j) != 0) {
        }
        if (i3 != 0) {
        }
        if ((8 & j) != 0) {
        }
        if ((j & 10) == 0) {
        }
    }
}
