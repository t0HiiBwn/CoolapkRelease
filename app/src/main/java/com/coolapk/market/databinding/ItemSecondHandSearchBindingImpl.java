package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.SecondHandInfo;

public class ItemSecondHandSearchBindingImpl extends ItemSecondHandSearchBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView8;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362908, 10);
        sparseIntArray.put(2131362722, 11);
        sparseIntArray.put(2131363568, 12);
        sparseIntArray.put(2131363582, 13);
        sparseIntArray.put(2131361981, 14);
        sparseIntArray.put(2131363364, 15);
    }

    public ItemSecondHandSearchBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemSecondHandSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[14], (ImageView) objArr[7], (CoolapkCardView) objArr[0], (TextView) objArr[4], (TextView) objArr[5], (ImageView) objArr[11], (LinearLayout) objArr[1], (TextView) objArr[9], (View) objArr[10], (ImageView) objArr[2], (ImageView) objArr[6], (TextView) objArr[15], (FrameLayout) objArr[12], (TextView) objArr[3], (TextView) objArr[13]);
        this.mDirtyFlags = -1;
        this.avatarView.setTag(null);
        this.coolapkCardView.setTag(null);
        this.discountPriceView.setTag(null);
        this.exchangePriceView.setTag(null);
        this.itemView.setTag(null);
        this.locationView.setTag(null);
        TextView textView = (TextView) objArr[8];
        this.mboundView8 = textView;
        textView.setTag(null);
        this.picView.setTag(null);
        this.signLink.setTag(null);
        this.titleTagView.setTag(null);
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
        if (197 == i) {
            setModel((Feed) obj);
        } else if (187 == i) {
            setLocationText((String) obj);
        } else if (63 == i) {
            setDateAndReply((String) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandSearchBinding
    public void setModel(Feed feed) {
        this.mModel = feed;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandSearchBinding
    public void setLocationText(String str) {
        this.mLocationText = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(187);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandSearchBinding
    public void setDateAndReply(String str) {
        this.mDateAndReply = str;
    }

    @Override // com.coolapk.market.databinding.ItemSecondHandSearchBinding
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
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        SecondHandInfo secondHandInfo;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Feed feed = this.mModel;
        String str8 = this.mLocationText;
        View.OnClickListener onClickListener = this.mClick;
        int i = ((17 & j) > 0 ? 1 : ((17 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (feed != null) {
                str4 = feed.getUserName();
                str7 = feed.getThumbSquarePic();
                str6 = feed.getUserAvatar();
                secondHandInfo = feed.getSecondHandInfo();
            } else {
                secondHandInfo = null;
                str4 = null;
                str7 = null;
                str6 = null;
            }
            if (secondHandInfo != null) {
                str3 = secondHandInfo.getPriceText();
                str5 = secondHandInfo.getPriceShowText();
                str2 = str7;
            } else {
                str2 = str7;
                str5 = null;
                str3 = null;
            }
            str = str6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        int i2 = ((18 & j) > 0 ? 1 : ((18 & j) == 0 ? 0 : -1));
        int i3 = ((24 & j) > 0 ? 1 : ((24 & j) == 0 ? 0 : -1));
        if (i != 0) {
            Drawable drawable = null;
            Boolean bool = null;
            String str9 = null;
            OnImageLoadListener onImageLoadListener = null;
            OnBitmapTransformListener onBitmapTransformListener = null;
            View.OnClickListener onClickListener2 = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.avatarView, str, drawable, 2131231152, 0, bool, bool, bool, bool, bool, str9, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
            TextViewBindingAdapter.setText(this.discountPriceView, str3);
            TextViewBindingAdapter.setText(this.exchangePriceView, str5);
            TextViewBindingAdapter.setText(this.mboundView8, str4);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.picView, str2, drawable, 2131231691, 0, bool, bool, bool, bool, bool, str9, onImageLoadListener, onBitmapTransformListener, bool, bool, bool, onClickListener2, bool);
        }
        if (i3 != 0) {
            Boolean bool2 = null;
            ViewBindingAdapters.clickListener(this.avatarView, onClickListener, bool2);
            ViewBindingAdapters.clickListener(this.itemView, onClickListener, bool2);
        }
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.avatarView, "oval", null);
            String str10 = null;
            ViewBindingAdapters.clipView(this.picView, str10, 4);
            ViewBindingAdapters.clipView(this.signLink, str10, 2);
            ViewBindingAdapters.clipView(this.titleTagView, str10, 3);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.locationView, str8);
        }
    }
}
