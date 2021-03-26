package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public class FeedEntranceV8BindingImpl extends FeedEntranceV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView8;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362697, 10);
        sparseIntArray.put(2131363618, 11);
        sparseIntArray.put(2131362262, 12);
        sparseIntArray.put(2131363633, 13);
        sparseIntArray.put(2131362847, 14);
        sparseIntArray.put(2131362722, 15);
        sparseIntArray.put(2131363414, 16);
        sparseIntArray.put(2131362723, 17);
        sparseIntArray.put(2131363269, 18);
        sparseIntArray.put(2131363235, 19);
    }

    public FeedEntranceV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FeedEntranceV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[12], (TextView) objArr[9], (LinearLayout) objArr[7], (ImageView) objArr[10], (ImageView) objArr[15], (ImageView) objArr[17], (FrameLayout) objArr[5], (FrameLayout) objArr[6], (Space) objArr[14], (View) objArr[1], (LinearLayout) objArr[4], (RecyclerView) objArr[19], (Space) objArr[18], (DrawSystemBarFrameLayout) objArr[0], (ImageView) objArr[3], (Space) objArr[16], (LinearLayout) objArr[2], (TextView) objArr[11], (LinearLayout) objArr[13]);
        this.mDirtyFlags = -1;
        this.draftTextView.setTag(null);
        this.draftView.setTag(null);
        this.itemView1.setTag(null);
        this.itemView2.setTag(null);
        this.maskView.setTag(null);
        ImageView imageView = (ImageView) objArr[8];
        this.mboundView8 = imageView;
        imageView.setTag(null);
        this.qrView.setTag(null);
        this.rootView.setTag(null);
        this.searchView.setTag(null);
        this.toolbar.setTag(null);
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
        if (50 != i) {
            return false;
        }
        setClick((View.OnClickListener) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.FeedEntranceV8Binding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.draftTextView, "colorAccent");
            ThemeBindingAdapters.setBackgroundTint(this.draftView, "colorAccent");
            String str = null;
            ViewBindingAdapters.clipView(this.itemView1, str, 16);
            ViewBindingAdapters.clipView(this.itemView2, str, 16);
            ThemeBindingAdapters.setTintColor(this.mboundView8, "colorAccent");
        }
        if (i != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.itemView1, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.itemView2, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.maskView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.qrView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.searchView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.toolbar, onClickListener, bool);
        }
    }
}
