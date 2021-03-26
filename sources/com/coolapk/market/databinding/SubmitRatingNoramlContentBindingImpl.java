package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.widget.view.BadBadRatingBar;

public class SubmitRatingNoramlContentBindingImpl extends SubmitRatingNoramlContentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final FrameLayout mboundView4;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(25);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(4, new String[]{"feed_warning"}, new int[]{8}, new int[]{2131558566});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363244, 9);
        sparseIntArray.put(2131363293, 10);
        sparseIntArray.put(2131363208, 11);
        sparseIntArray.put(2131362191, 12);
        sparseIntArray.put(2131362311, 13);
        sparseIntArray.put(2131362006, 14);
        sparseIntArray.put(2131362007, 15);
        sparseIntArray.put(2131362008, 16);
        sparseIntArray.put(2131362412, 17);
        sparseIntArray.put(2131362413, 18);
        sparseIntArray.put(2131362414, 19);
        sparseIntArray.put(2131363483, 20);
        sparseIntArray.put(2131363484, 21);
        sparseIntArray.put(2131363485, 22);
        sparseIntArray.put(2131363414, 23);
        sparseIntArray.put(2131363213, 24);
    }

    public SubmitRatingNoramlContentBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private SubmitRatingNoramlContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[5], (EditText) objArr[14], (RelativeLayout) objArr[15], (RecyclerView) objArr[16], (FeedWarningBinding) objArr[8], (CheckBox) objArr[12], (LinearLayout) objArr[13], (LinearLayout) objArr[6], (EditText) objArr[17], (RelativeLayout) objArr[18], (RecyclerView) objArr[19], (ImageView) objArr[3], (TextView) objArr[2], (LinearLayout) objArr[1], (BadBadRatingBar) objArr[11], (TextView) objArr[24], (LinearLayout) objArr[9], (TextView) objArr[10], (Space) objArr[23], (LinearLayout) objArr[7], (EditText) objArr[20], (RelativeLayout) objArr[21], (RecyclerView) objArr[22]);
        this.mDirtyFlags = -1;
        this.advantageAddPhotoView.setTag(null);
        setContainedBinding(this.alertView);
        this.disadvantageAddPhotoView.setTag(null);
        this.expandImageView.setTag(null);
        this.expandTextView.setTag(null);
        this.expandView.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[4];
        this.mboundView4 = frameLayout;
        frameLayout.setTag(null);
        this.summaryAddPhotoView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.alertView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (this.alertView.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (289 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitRatingNoramlContentBinding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
    }

    @Override // com.coolapk.market.databinding.SubmitRatingNoramlContentBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeAlertView((FeedWarningBinding) obj, i2);
    }

    private boolean onChangeAlertView(FeedWarningBinding feedWarningBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((12 & j) != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.advantageAddPhotoView, onClickListener, bool);
            this.alertView.setClick(onClickListener);
            ViewBindingAdapters.clickListener(this.disadvantageAddPhotoView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.expandView, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.summaryAddPhotoView, onClickListener, bool);
        }
        if ((j & 8) != 0) {
            ThemeBindingAdapters.setTintColor(this.expandImageView, "colorAccent");
            ThemeBindingAdapters.setTextColor(this.expandTextView, "colorAccent");
        }
        executeBindingsOn(this.alertView);
    }
}
