package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.percentlayout.widget.PercentFrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Product;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.ScaleImageView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;

public class ProductNodeHeaderBindingImpl extends ProductNodeHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final PercentFrameLayout mboundView10;
    private final PercentFrameLayout mboundView12;
    private final PercentFrameLayout mboundView14;
    private final PercentFrameLayout mboundView16;
    private final TextView mboundView2;
    private final TextView mboundView24;
    private final TextView mboundView25;
    private final PercentFrameLayout mboundView8;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362102, 27);
        sparseIntArray.put(2131362104, 28);
        sparseIntArray.put(2131362105, 29);
        sparseIntArray.put(2131362101, 30);
        sparseIntArray.put(2131362779, 31);
        sparseIntArray.put(2131362345, 32);
        sparseIntArray.put(2131362726, 33);
        sparseIntArray.put(2131362920, 34);
        sparseIntArray.put(2131362741, 35);
        sparseIntArray.put(2131362651, 36);
        sparseIntArray.put(2131362675, 37);
        sparseIntArray.put(2131363645, 38);
        sparseIntArray.put(2131362588, 39);
        sparseIntArray.put(2131363214, 40);
        sparseIntArray.put(2131363221, 41);
        sparseIntArray.put(2131363224, 42);
        sparseIntArray.put(2131363295, 43);
        sparseIntArray.put(2131363208, 44);
        sparseIntArray.put(2131362336, 45);
        sparseIntArray.put(2131363507, 46);
        sparseIntArray.put(2131363206, 47);
        sparseIntArray.put(2131363205, 48);
        sparseIntArray.put(2131363204, 49);
        sparseIntArray.put(2131363203, 50);
        sparseIntArray.put(2131363202, 51);
        sparseIntArray.put(2131362382, 52);
        sparseIntArray.put(2131362674, 53);
        sparseIntArray.put(2131363525, 54);
    }

    public ProductNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 55, sIncludes, sViewsWithIds));
    }

    private ProductNodeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (View) objArr[30], (LinearLayout) objArr[27], (Space) objArr[28], (View) objArr[29], (TextView) objArr[20], (TextView) objArr[18], (TextView) objArr[45], (MaxWidthFrameLayout) objArr[32], (TextView) objArr[52], (LinearLayout) objArr[23], (TextView) objArr[39], (LinearLayout) objArr[36], (HorizontalScrollView) objArr[53], (TextView) objArr[37], (ViewPager) objArr[33], (IndicatorView) objArr[35], (LinearLayout) objArr[31], (LinearAdapterLayout) objArr[26], (ImageView) objArr[1], (View) objArr[34], (LinearLayout) objArr[3], (TextView) objArr[51], (TextView) objArr[50], (TextView) objArr[49], (TextView) objArr[48], (TextView) objArr[47], (RatingBar) objArr[44], (ScaleImageView) objArr[40], (ImageView) objArr[17], (ImageView) objArr[15], (ImageView) objArr[13], (ImageView) objArr[11], (ImageView) objArr[9], (LinearLayout) objArr[41], (LinearLayout) objArr[42], (TextView) objArr[22], (LinearLayout) objArr[5], (TextView) objArr[43], (TableLayout) objArr[46], (LinearLayout) objArr[54], (Space) objArr[38], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[19], (TextView) objArr[21]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.buyCountView.setTag(null);
        this.buySubView.setTag(null);
        this.fetchCouponView.setTag(null);
        this.linearView.setTag(null);
        this.logoView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        PercentFrameLayout percentFrameLayout = (PercentFrameLayout) objArr[10];
        this.mboundView10 = percentFrameLayout;
        percentFrameLayout.setTag(null);
        PercentFrameLayout percentFrameLayout2 = (PercentFrameLayout) objArr[12];
        this.mboundView12 = percentFrameLayout2;
        percentFrameLayout2.setTag(null);
        PercentFrameLayout percentFrameLayout3 = (PercentFrameLayout) objArr[14];
        this.mboundView14 = percentFrameLayout3;
        percentFrameLayout3.setTag(null);
        PercentFrameLayout percentFrameLayout4 = (PercentFrameLayout) objArr[16];
        this.mboundView16 = percentFrameLayout4;
        percentFrameLayout4.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[24];
        this.mboundView24 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[25];
        this.mboundView25 = textView3;
        textView3.setTag(null);
        PercentFrameLayout percentFrameLayout5 = (PercentFrameLayout) objArr[8];
        this.mboundView8 = percentFrameLayout5;
        percentFrameLayout5.setTag(null);
        this.moreFollowerView.setTag(null);
        this.ratingImageView1.setTag(null);
        this.ratingImageView2.setTag(null);
        this.ratingImageView3.setTag(null);
        this.ratingImageView4.setTag(null);
        this.ratingImageView5.setTag(null);
        this.ratingView.setTag(null);
        this.ratingViewContainer.setTag(null);
        this.viewAllView.setTag(null);
        this.viewOwnerView.setTag(null);
        this.wishCountView.setTag(null);
        this.wishView.setTag(null);
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
            setModel((Product) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ProductNodeHeaderBinding
    public void setModel(Product product) {
        this.mModel = product;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ProductNodeHeaderBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
    }

    @Override // com.coolapk.market.databinding.ProductNodeHeaderBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        int i2;
        String str4;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Product product = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i3 = 0;
        int i4 = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (product != null) {
                str4 = product.getCouponTitle();
                str2 = product.getTitle();
            } else {
                str2 = null;
                str4 = null;
            }
            if (str4 != null) {
                z = str4.isEmpty();
            } else {
                z = false;
            }
            boolean z2 = !z;
            if (i4 != 0) {
                j |= z2 ? 32 : 16;
            }
            if (!z2) {
                i3 = 8;
            }
            str = str4;
            i = i3;
        } else {
            str2 = null;
            str = null;
            i = 0;
        }
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.actionView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buyCountView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.buySubView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.fetchCouponView, onClickListener, bool);
            String str5 = null;
            i2 = i;
            str3 = str;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.logoView, str5, null, 0, 0, bool, bool, bool, bool, bool, str5, null, null, bool, bool, bool, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.moreFollowerView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.ratingView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.ratingViewContainer, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.viewAllView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.viewOwnerView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wishCountView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.wishView, onClickListener, bool);
        } else {
            i2 = i;
            str3 = str;
        }
        if ((8 & j) != 0) {
            Number number = null;
            ViewBindingAdapters.clipView(this.actionView, "capsule", number);
            String str6 = null;
            ViewBindingAdapters.clipView(this.fetchCouponView, str6, 8);
            ViewBindingAdapters.clipView(this.linearView, str6, 8);
            ViewBindingAdapters.clipView(this.logoView, str6, 8);
            ViewBindingAdapters.clipView(this.mboundView10, str6, 4);
            ViewBindingAdapters.clipView(this.mboundView12, str6, 4);
            ViewBindingAdapters.clipView(this.mboundView14, str6, 4);
            ViewBindingAdapters.clipView(this.mboundView16, str6, 4);
            ViewBindingAdapters.clipView(this.mboundView24, str6, 4);
            ViewBindingAdapters.clipView(this.mboundView8, str6, 4);
            ViewBindingAdapters.clipView(this.ratingImageView1, str6, 4);
            ViewBindingAdapters.clipView(this.ratingImageView2, str6, 4);
            ViewBindingAdapters.clipView(this.ratingImageView3, str6, 4);
            ViewBindingAdapters.clipView(this.ratingImageView4, str6, 4);
            ViewBindingAdapters.clipView(this.ratingImageView5, str6, 4);
            ViewBindingAdapters.clipView(this.ratingView, "capsule", number);
            ViewBindingAdapters.clipView(this.ratingViewContainer, str6, 8);
            ViewBindingAdapters.clipView(this.wishView, "capsule", number);
        }
        if ((j & 9) != 0) {
            this.fetchCouponView.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView25, str3);
        }
    }
}
