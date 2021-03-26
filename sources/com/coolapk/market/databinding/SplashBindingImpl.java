package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public class SplashBindingImpl extends SplashBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final DrawSystemBarFrameLayout mboundView0;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362718, 5);
        sparseIntArray.put(2131362336, 6);
        sparseIntArray.put(2131362322, 7);
    }

    public SplashBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private SplashBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[7], (TextView) objArr[6], (ImageView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1;
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = (DrawSystemBarFrameLayout) objArr[0];
        this.mboundView0 = drawSystemBarFrameLayout;
        drawSystemBarFrameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        this.userNameView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (275 != i) {
            return false;
        }
        setTextColor((Integer) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.SplashBinding
    public void setTextColor(Integer num) {
        this.mTextColor = num;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(275);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        int i = 0;
        Integer num = this.mTextColor;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            i = ViewDataBinding.safeUnbox(num);
        }
        if (i2 != 0) {
            if (getBuildSdkInt() >= 21) {
                this.mboundView1.setImageTintList(Converters.convertColorToColorStateList(num.intValue()));
            }
            this.mboundView2.setTextColor(i);
            this.mboundView3.setTextColor(i);
            this.userNameView.setTextColor(i);
        }
    }
}
