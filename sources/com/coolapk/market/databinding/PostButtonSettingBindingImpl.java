package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.widget.RadioGroupPlus;
import com.meg7.widget.SvgImageView;

public class PostButtonSettingBindingImpl extends PostButtonSettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363170, 3);
        sparseIntArray.put(2131363132, 4);
        sparseIntArray.put(2131363131, 5);
        sparseIntArray.put(2131363174, 6);
        sparseIntArray.put(2131362010, 7);
        sparseIntArray.put(2131362009, 8);
        sparseIntArray.put(2131363162, 9);
        sparseIntArray.put(2131362324, 10);
        sparseIntArray.put(2131362322, 11);
        sparseIntArray.put(2131363164, 12);
        sparseIntArray.put(2131362354, 13);
        sparseIntArray.put(2131362352, 14);
        sparseIntArray.put(2131362353, 15);
        sparseIntArray.put(2131363165, 16);
        sparseIntArray.put(2131363171, 17);
        sparseIntArray.put(2131362894, 18);
        sparseIntArray.put(2131363176, 19);
        sparseIntArray.put(2131362891, 20);
        sparseIntArray.put(2131363163, 21);
        sparseIntArray.put(2131362893, 22);
        sparseIntArray.put(2131363173, 23);
        sparseIntArray.put(2131362892, 24);
        sparseIntArray.put(2131363166, 25);
    }

    public PostButtonSettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    private PostButtonSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (LinearLayout) objArr[7], (ImageView) objArr[11], (LinearLayout) objArr[10], (SvgImageView) objArr[14], (ImageView) objArr[15], (LinearLayout) objArr[13], (LinearLayout) objArr[20], (LinearLayout) objArr[24], (LinearLayout) objArr[22], (LinearLayout) objArr[18], (ImageView) objArr[5], (LinearLayout) objArr[4], (RadioButton) objArr[9], (RadioButton) objArr[21], (RadioButton) objArr[12], (RadioButton) objArr[16], (RadioButton) objArr[25], (RadioGroupPlus) objArr[3], (RadioGroupPlus) objArr[17], (RadioButton) objArr[23], (RadioButton) objArr[6], (RadioButton) objArr[19]);
        this.mDirtyFlags = -1;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 1) != 0) {
            ThemeBindingAdapters.setTextColor(this.mboundView1, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView2, "colorAccent");
        }
    }
}
