package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.AlphableAppBarLayout;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GoodsDetailBindingImpl extends GoodsDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView5;
    private final TextView mboundView6;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"loading_view"}, new int[]{10}, new int[]{2131559020});
        includedLayouts.setIncludes(2, new String[]{"user_toolbar"}, new int[]{9}, new int[]{2131559296});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362069, 11);
        sparseIntArray.put(2131363413, 12);
        sparseIntArray.put(2131362651, 13);
        sparseIntArray.put(2131363508, 14);
        sparseIntArray.put(2131363610, 15);
        sparseIntArray.put(2131363959, 16);
    }

    public GoodsDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private GoodsDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[7], (AlphableAppBarLayout) objArr[11], (CoordinatorLayout) objArr[1], (FloatingActionButton) objArr[8], (LinearLayout) objArr[13], (ImageView) objArr[3], (LoadingViewBinding) objArr[10], (DrawSystemBarFrameLayout) objArr[0], (Space) objArr[12], (IgnoreInsetFrameLayout) objArr[2], (TabLayout) objArr[14], (TextView) objArr[4], (Toolbar) objArr[15], (UserToolbarBinding) objArr[9], (ScrollStateViewPager) objArr[16]);
        this.mDirtyFlags = -1;
        this.actionView.setTag(null);
        this.coordinator.setTag(null);
        this.floatingButton.setTag(null);
        this.iconView.setTag(null);
        setContainedBinding(this.loadingView);
        this.mainContent.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        this.tabContainer.setTag(null);
        this.titleView.setTag(null);
        setContainedBinding(this.userToolbar);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.userToolbar.invalidateAll();
        this.loadingView.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
        if (!this.userToolbar.hasPendingBindings() && !this.loadingView.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (198 == i) {
            setModel((FeedGoods) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.GoodsDetailBinding
    public void setModel(FeedGoods feedGoods) {
        this.mModel = feedGoods;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.GoodsDetailBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.userToolbar.setLifecycleOwner(lifecycleOwner);
        this.loadingView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeUserToolbar((UserToolbarBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeLoadingView((LoadingViewBinding) obj, i2);
    }

    private boolean onChangeUserToolbar(UserToolbarBinding userToolbarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLoadingView(LoadingViewBinding loadingViewBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        int i3;
        String str4;
        long j2;
        String str5;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedGoods feedGoods = this.mModel;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
        if (i4 != 0) {
            boolean z = feedGoods == null;
            if (i4 != 0) {
                j |= z ? 1024 : 512;
            }
            if (feedGoods != null) {
                str6 = feedGoods.getPrice();
                str2 = feedGoods.getTitle();
                str5 = feedGoods.getCategoryName();
                str4 = feedGoods.getCover();
            } else {
                str4 = null;
                str6 = null;
                str2 = null;
                str5 = null;
            }
            int i5 = z ? 8 : 0;
            str3 = "￥" + str6;
            boolean isEmpty = TextUtils.isEmpty(str6);
            boolean isEmpty2 = TextUtils.isEmpty(str5);
            if ((j & 20) != 0) {
                j |= isEmpty ? 256 : 128;
            }
            if ((j & 20) != 0) {
                j |= isEmpty2 ? 64 : 32;
            }
            i2 = isEmpty ? 8 : 0;
            int i6 = isEmpty2 ? 8 : 0;
            str = str5;
            i = i5;
            i3 = i6;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i7 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if ((j & 16) != 0) {
            ViewBindingAdapters.clipView(this.actionView, "capsule", null);
            ThemeBindingAdapters.setBackgroundTint(this.floatingButton, "colorAccent");
            String str7 = null;
            ViewBindingAdapters.clipView(this.iconView, str7, 8);
            ViewBindingAdapters.clipView(this.mboundView6, str7, 4);
            this.userToolbar.setUserVerifyStatusIcon(str7);
            j2 = 20;
        } else {
            j2 = 20;
        }
        if ((j & j2) != 0) {
            this.coordinator.setVisibility(i);
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str4, null, 2131231419, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, true, null, bool);
            TextViewBindingAdapter.setText(this.mboundView5, str3);
            this.mboundView5.setVisibility(i2);
            TextViewBindingAdapter.setText(this.mboundView6, str);
            this.mboundView6.setVisibility(i3);
            TextViewBindingAdapter.setText(this.titleView, str2);
            this.userToolbar.setUserAvatar(str4);
            this.userToolbar.setUserName(str2);
        }
        if (i7 != 0) {
            ViewBindingAdapters.clickListener(this.iconView, onClickListener, null);
            this.userToolbar.setClick(onClickListener);
        }
        executeBindingsOn(this.userToolbar);
        executeBindingsOn(this.loadingView);
    }
}
