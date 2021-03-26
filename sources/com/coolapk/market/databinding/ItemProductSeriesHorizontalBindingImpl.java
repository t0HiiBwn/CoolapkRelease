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
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.SquareImageView;
import com.coolapk.market.widget.view.FollowStyleTextView;

public class ItemProductSeriesHorizontalBindingImpl extends ItemProductSeriesHorizontalBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final SquareImageView mboundView12;
    private final ImageView mboundView13;
    private final TextView mboundView14;
    private final SquareImageView mboundView2;
    private final ImageView mboundView3;
    private final TextView mboundView4;
    private final SquareImageView mboundView7;
    private final ImageView mboundView8;
    private final TextView mboundView9;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363461, 18);
        sparseIntArray.put(2131363462, 19);
        sparseIntArray.put(2131363463, 20);
    }

    public ItemProductSeriesHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private ItemProductSeriesHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FollowStyleTextView) objArr[5], (FollowStyleTextView) objArr[10], (FollowStyleTextView) objArr[15], (LinearLayout) objArr[16], (ImageView) objArr[17], (LinearLayout) objArr[0], (LinearLayout) objArr[1], (LinearLayout) objArr[6], (LinearLayout) objArr[11], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[20]);
        this.mDirtyFlags = -1;
        this.actionButton1.setTag(null);
        this.actionButton2.setTag(null);
        this.actionButton3.setTag(null);
        this.actionContainer.setTag(null);
        this.actionView.setTag(null);
        this.itemView.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        this.itemView3.setTag(null);
        SquareImageView squareImageView = (SquareImageView) objArr[12];
        this.mboundView12 = squareImageView;
        squareImageView.setTag(null);
        ImageView imageView = (ImageView) objArr[13];
        this.mboundView13 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[14];
        this.mboundView14 = textView;
        textView.setTag(null);
        SquareImageView squareImageView2 = (SquareImageView) objArr[2];
        this.mboundView2 = squareImageView2;
        squareImageView2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        SquareImageView squareImageView3 = (SquareImageView) objArr[7];
        this.mboundView7 = squareImageView3;
        squareImageView3.setTag(null);
        ImageView imageView3 = (ImageView) objArr[8];
        this.mboundView8 = imageView3;
        imageView3.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
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
        if (200 == i) {
            setModel3((Product) obj);
        } else if (199 == i) {
            setModel2((Product) obj);
        } else if (198 == i) {
            setModel1((Product) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesHorizontalBinding
    public void setModel3(Product product) {
        this.mModel3 = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(200);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesHorizontalBinding
    public void setModel2(Product product) {
        this.mModel2 = product;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(199);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesHorizontalBinding
    public void setModel1(Product product) {
        this.mModel1 = product;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemProductSeriesHorizontalBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        String str3;
        String str4;
        int i3;
        int i4;
        String str5;
        String str6;
        int i5;
        int i6;
        boolean z;
        String str7;
        String str8;
        String str9;
        boolean z2;
        String str10;
        String str11;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Product product = this.mModel3;
        Product product2 = this.mModel2;
        Product product3 = this.mModel1;
        View.OnClickListener onClickListener = this.mClick;
        int i7 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (product != null) {
                z3 = product.isReleased();
                str2 = product.getTitle();
                str11 = product.getSquareLogo();
            } else {
                str2 = null;
                str11 = null;
                z3 = false;
            }
            boolean z4 = product != null;
            if (i7 != 0) {
                j |= z4 ? 4096 : 2048;
            }
            boolean z5 = !z3;
            i2 = z4 ? 0 : 8;
            if ((j & 17) != 0) {
                j |= z5 ? 16384 : 8192;
            }
            i = z5 ? 0 : 8;
            str = str11;
        } else {
            str2 = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        int i8 = ((j & 18) > 0 ? 1 : ((j & 18) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (product2 != null) {
                str10 = product2.getTitle();
                z2 = product2.isReleased();
                str9 = product2.getSquareLogo();
            } else {
                str10 = null;
                str9 = null;
                z2 = false;
            }
            boolean z6 = product2 != null;
            if (i8 != 0) {
                j |= z6 ? 256 : 128;
            }
            boolean z7 = !z2;
            i4 = z6 ? 0 : 8;
            if ((j & 18) != 0) {
                j |= z7 ? 1024 : 512;
            }
            str4 = str10;
            i3 = z7 ? 0 : 8;
            str3 = str9;
        } else {
            str4 = null;
            str3 = null;
            i4 = 0;
            i3 = 0;
        }
        int i9 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i9 != 0) {
            if (product3 != null) {
                str8 = product3.getSquareLogo();
                str7 = product3.getTitle();
                z = product3.isReleased();
            } else {
                str8 = null;
                str7 = null;
                z = false;
            }
            boolean z8 = product3 != null;
            if (i9 != 0) {
                j |= z8 ? 65536 : 32768;
            }
            boolean z9 = !z;
            i6 = z8 ? 0 : 8;
            if ((j & 20) != 0) {
                j |= z9 ? 64 : 32;
            }
            i5 = z9 ? 0 : 8;
            str6 = str8;
            str5 = str7;
        } else {
            str6 = null;
            str5 = null;
            i6 = 0;
            i5 = 0;
        }
        if ((j & 24) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionButton1, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionButton2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionButton3, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView3, onClickListener, bool);
        }
        if ((16 & j) != 0) {
            ViewBindingAdapters.clipView(this.actionView, "oval", null);
            String str12 = null;
            ViewBindingAdapters.clipView(this.itemView1, str12, 8);
            ViewBindingAdapters.clipView(this.itemView2, str12, 8);
            ViewBindingAdapters.clipView(this.itemView3, str12, 8);
            ViewBindingAdapters.clipView(this.mboundView12, str12, 4);
            ViewBindingAdapters.clipView(this.mboundView2, str12, 4);
            ViewBindingAdapters.clipView(this.mboundView7, str12, 4);
        }
        if ((j & 20) != 0) {
            this.itemView1.setVisibility(i6);
            Boolean bool2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView2, str6, null, 2131231691, 0, bool2, bool2, bool2, true, bool2, null, null, null, bool2, bool2, bool2, null, bool2);
            this.mboundView3.setVisibility(i5);
            TextViewBindingAdapter.setText(this.mboundView4, str5);
        }
        if ((j & 18) != 0) {
            this.itemView2.setVisibility(i4);
            Boolean bool3 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView7, str3, null, 2131231691, 0, bool3, bool3, bool3, true, bool3, null, null, null, bool3, bool3, bool3, null, bool3);
            this.mboundView8.setVisibility(i3);
            TextViewBindingAdapter.setText(this.mboundView9, str4);
        }
        if ((j & 17) != 0) {
            this.itemView3.setVisibility(i2);
            Boolean bool4 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView12, str, null, 2131231691, 0, bool4, bool4, bool4, true, bool4, null, null, null, bool4, bool4, bool4, null, bool4);
            this.mboundView13.setVisibility(i);
            TextViewBindingAdapter.setText(this.mboundView14, str2);
        }
    }
}
