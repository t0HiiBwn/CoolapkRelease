package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;

public class SecondHandContentV8BindingImpl extends SecondHandContentV8Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final LinearLayout mboundView1;
    private final View mboundView4;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"feed_warning"}, new int[]{9}, new int[]{2131558566});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362450, 10);
        sparseIntArray.put(2131363981, 11);
        sparseIntArray.put(2131363235, 12);
        sparseIntArray.put(2131363414, 13);
        sparseIntArray.put(2131363068, 14);
    }

    public SecondHandContentV8BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private SecondHandContentV8BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FeedWarningBinding) objArr[9], (TextView) objArr[7], (TextView) objArr[8], (EditText) objArr[5], (EditText) objArr[3], (TextView) objArr[10], (RecyclerView) objArr[14], (RelativeLayout) objArr[6], (RecyclerView) objArr[12], (LinearLayout) objArr[2], (Space) objArr[13], (LinearLayout) objArr[11]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.alertView);
        this.commentBoardTip1.setTag(null);
        this.commentBoardTip2.setTag(null);
        this.editText.setTag(null);
        this.editTitle.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[4];
        this.mboundView4 = view2;
        view2.setTag(null);
        this.photoContainer.setTag(null);
        this.relativeView.setTag(null);
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

    @Override // com.coolapk.market.databinding.SecondHandContentV8Binding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(289);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SecondHandContentV8Binding
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
        String str;
        int i;
        int i2;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feedUIConfig != null) {
                z2 = feedUIConfig.isPickPhotoItemVisible();
                z = feedUIConfig.isPickPhotoContainerVisible();
                z3 = feedUIConfig.isEditTitleViewVisible();
                str7 = feedUIConfig.commentBoardTip2();
                str6 = feedUIConfig.editTextHint();
                str5 = feedUIConfig.commentBoardTip1();
                str4 = feedUIConfig.editTitleHint();
            } else {
                str4 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                z2 = false;
                z = false;
                z3 = false;
            }
            if (i4 != 0) {
                j |= z2 ? 512 : 256;
            }
            if ((j & 10) != 0) {
                j |= z ? 2048 : 1024;
            }
            if ((j & 10) != 0) {
                j |= z3 ? 32 : 16;
            }
            i2 = z ? 3 : 5;
            i = z3 ? 0 : 8;
            str3 = str7;
            str2 = str6;
            str = str5;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z2 = false;
            z = false;
            i2 = 0;
            i = 0;
        }
        int i5 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (!z2) {
                z = false;
            }
            if (i5 != 0) {
                j |= z ? 128 : 64;
            }
            i3 = z ? 0 : 8;
        } else {
            i3 = 0;
        }
        if ((j & 12) != 0) {
            this.alertView.setClick(onClickListener);
            ViewBindingAdapters.clickListener(this.relativeView, onClickListener, null);
        }
        if ((j & 10) != 0) {
            TextViewBindingAdapter.setText(this.commentBoardTip1, str);
            TextViewBindingAdapter.setText(this.commentBoardTip2, str3);
            this.editText.setHint(str2);
            this.editText.setMinLines(i2);
            this.editTitle.setHint(str4);
            this.editTitle.setVisibility(i);
            this.mboundView4.setVisibility(i);
            this.photoContainer.setVisibility(i3);
        }
        executeBindingsOn(this.alertView);
    }
}
