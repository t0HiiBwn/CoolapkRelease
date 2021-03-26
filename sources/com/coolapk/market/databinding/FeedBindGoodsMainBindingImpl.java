package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class FeedBindGoodsMainBindingImpl extends FeedBindGoodsMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final ImageView mboundView3;
    private final TextView mboundView4;
    private final ImageView mboundView6;
    private final TextView mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362305, 8);
        sparseIntArray.put(2131363235, 9);
        sparseIntArray.put(2131362463, 10);
    }

    public FeedBindGoodsMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FeedBindGoodsMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (LinearLayout) objArr[8], (TextView) objArr[10], (LinearLayout) objArr[5], (RecyclerView) objArr[9], (LinearLayout) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionDone.setTag(null);
        this.manualGoodsView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.mboundView6 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.mboundView7 = textView2;
        textView2.setTag(null);
        this.searchGoodsView.setTag(null);
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

    @Override // com.coolapk.market.databinding.FeedBindGoodsMainBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        if ((j & 2) != 0) {
            ThemeBindingAdapters.setTextColor(this.actionDone, "colorAccent");
            Number number = null;
            ViewBindingAdapters.clipView(this.manualGoodsView, "capsule", number);
            ThemeBindingAdapters.setTintColor(this.mboundView3, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView4, "colorAccent");
            ThemeBindingAdapters.setTintColor(this.mboundView6, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.mboundView7, "colorAccent");
            ViewBindingAdapters.clipView(this.searchGoodsView, "capsule", number);
        }
    }
}
