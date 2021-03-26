package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.util.StringUtils;

public class ItemAppViewCommentTitleBindingImpl extends ItemAppViewCommentTitleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362555, 4);
    }

    public ItemAppViewCommentTitleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemAppViewCommentTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (LinearLayout) objArr[4]);
        this.mDirtyFlags = -1;
        this.filterTextView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
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
        if (53 != i) {
            return false;
        }
        setCommentNum((String) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAppViewCommentTitleBinding
    public void setCommentNum(String str) {
        this.mCommentNum = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(53);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mCommentNum;
        String str2 = null;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if (i != 0) {
            str2 = StringUtils.titleWithNum(this.mboundView1.getResources().getString(2131886667), str);
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.filterTextView, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.mboundView3, "colorAccent");
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str2);
        }
    }
}
