package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.widget.view.FatTextView;

public class ItemNotificationNaviBindingImpl extends ItemNotificationNaviBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView11;
    private final ImageView mboundView14;
    private final ImageView mboundView5;
    private final ImageView mboundView8;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemNotificationNaviBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemNotificationNaviBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (LinearLayout) objArr[1], (LinearLayout) objArr[4], (LinearLayout) objArr[7], (LinearLayout) objArr[10], (LinearLayout) objArr[13], (FatTextView) objArr[3], (FatTextView) objArr[6], (FatTextView) objArr[9], (FatTextView) objArr[12], (FatTextView) objArr[15]);
        this.mDirtyFlags = -1;
        this.imageView.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        this.itemView4.setTag(null);
        this.itemView5.setTag(null);
        this.itemView6.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[11];
        this.mboundView11 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[14];
        this.mboundView14 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[5];
        this.mboundView5 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[8];
        this.mboundView8 = imageView4;
        imageView4.setTag(null);
        this.textView1.setTag(null);
        this.textView2.setTag(null);
        this.textView3.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
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
        if (209 == i) {
            setNotification((AppNotification) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemNotificationNaviBinding
    public void setNotification(AppNotification appNotification) {
        this.mNotification = appNotification;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(209);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemNotificationNaviBinding
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
        int i;
        int i2;
        String str2;
        String str3;
        int i3;
        String str4;
        int i4;
        String str5;
        int i5;
        String str6;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AppNotification appNotification = this.mNotification;
        View.OnClickListener onClickListener = this.mClick;
        int i12 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i12 != 0) {
            if (appNotification != null) {
                i10 = appNotification.getCountByPage(5);
                i8 = appNotification.getCountByPage(4);
                i7 = appNotification.getCountByPage(6);
                i9 = appNotification.getCountByPage(2);
                i11 = appNotification.getCountByPage(1);
            } else {
                i11 = 0;
                i10 = 0;
                i9 = 0;
                i8 = 0;
                i7 = 0;
            }
            boolean z = i10 == 0;
            str3 = i10 + "";
            str2 = i8 + "";
            boolean z2 = i8 == 0;
            str5 = i7 + "";
            boolean z3 = i7 == 0;
            str = i9 + "";
            boolean z4 = i9 == 0;
            str4 = i11 + "";
            boolean z5 = i11 == 0;
            if (i12 != 0) {
                j |= z ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= z4 ? 4096 : 2048;
            }
            if ((j & 5) != 0) {
                j |= z5 ? 1024 : 512;
            }
            i3 = z ? 8 : 0;
            i2 = z2 ? 8 : 0;
            i4 = z3 ? 8 : 0;
            i5 = z4 ? 8 : 0;
            i = z5 ? 8 : 0;
        } else {
            i5 = 0;
            str5 = null;
            i4 = 0;
            str4 = null;
            i3 = 0;
            str3 = null;
            str2 = null;
            i2 = 0;
            i = 0;
            str = null;
        }
        int i13 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if ((4 & j) != 0) {
            i6 = i2;
            str6 = str2;
            Number number = null;
            ViewBindingAdapters.clipView(this.imageView, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView11, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView14, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView5, "oval", number);
            ViewBindingAdapters.clipView(this.mboundView8, "oval", number);
            ThemeBindingAdapters.setBackgroundTint(this.textView1, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView2, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView3, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView4, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.textView5, "colorAccent");
        } else {
            str6 = str2;
            i6 = i2;
        }
        if (i13 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView4, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView5, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView6, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.mboundView0, onClickListener, bool);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.textView1, str4);
            this.textView1.setVisibility(i);
            TextViewBindingAdapter.setText(this.textView2, str);
            this.textView2.setVisibility(i5);
            TextViewBindingAdapter.setText(this.textView3, str3);
            this.textView3.setVisibility(i3);
            TextViewBindingAdapter.setText(this.textView4, str5);
            this.textView4.setVisibility(i4);
            TextViewBindingAdapter.setText(this.textView5, str6);
            this.textView5.setVisibility(i6);
        }
    }
}
