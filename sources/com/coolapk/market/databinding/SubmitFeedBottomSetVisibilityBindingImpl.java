package com.coolapk.market.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.FeedUIConfig;

public class SubmitFeedBottomSetVisibilityBindingImpl extends SubmitFeedBottomSetVisibilityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView2;
    private final ImageView mboundView4;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public SubmitFeedBottomSetVisibilityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private SubmitFeedBottomSetVisibilityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[1], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.mboundView4 = imageView2;
        imageView2.setTag(null);
        this.visibleToAll.setTag(null);
        this.visibleToMe.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (289 == i) {
            setUiConfig((FeedUIConfig) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.SubmitFeedBottomSetVisibilityBinding
    public void setUiConfig(FeedUIConfig feedUIConfig) {
        this.mUiConfig = feedUIConfig;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(289);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.SubmitFeedBottomSetVisibilityBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        boolean z;
        boolean z2;
        Drawable drawable4;
        int i;
        int i2;
        AppTheme appTheme;
        int i3;
        long j2;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FeedUIConfig feedUIConfig = this.mUiConfig;
        View.OnClickListener onClickListener = this.mClick;
        int i4 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (feedUIConfig != null) {
                i3 = feedUIConfig.visibleState();
            } else {
                i3 = 0;
            }
            z2 = true;
            z = i3 == 1;
            if (i3 != -1) {
                z2 = false;
            }
            if (i4 != 0) {
                if (z) {
                    j5 = j | 64 | 1024;
                    j4 = 16384;
                } else {
                    j5 = j | 32 | 512;
                    j4 = 8192;
                }
                j = j5 | j4;
            }
            if ((j & 5) != 0) {
                if (z2) {
                    j3 = j | 16 | 256;
                    j2 = 4096;
                } else {
                    j3 = j | 8 | 128;
                    j2 = 2048;
                }
                j = j3 | j2;
            }
            Context context = this.mboundView2.getContext();
            drawable = z ? AppCompatResources.getDrawable(context, 2131231267) : AppCompatResources.getDrawable(context, 2131230850);
            Context context2 = this.mboundView2.getContext();
            drawable3 = z ? AppCompatResources.getDrawable(context2, 2131231897) : AppCompatResources.getDrawable(context2, 2131230861);
            drawable2 = z2 ? AppCompatResources.getDrawable(this.mboundView4.getContext(), 2131231897) : AppCompatResources.getDrawable(this.mboundView4.getContext(), 2131230861);
            drawable4 = z2 ? AppCompatResources.getDrawable(this.mboundView4.getContext(), 2131231267) : AppCompatResources.getDrawable(this.mboundView4.getContext(), 2131230850);
        } else {
            drawable4 = null;
            z2 = false;
            z = false;
            drawable3 = null;
            drawable2 = null;
            drawable = null;
        }
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 1280) == 0 || (appTheme = AppHolder.getAppTheme()) == null) {
            i = 0;
        } else {
            i = appTheme.getColorAccent();
        }
        int i6 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i6 != 0) {
            int i7 = z2 ? i : -4342339;
            if (!z) {
                i = -4342339;
            }
            i2 = i7;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i6 != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, drawable);
            ViewBindingAdapter.setBackground(this.mboundView2, drawable3);
            ImageViewBindingAdapter.setImageDrawable(this.mboundView4, drawable4);
            ViewBindingAdapter.setBackground(this.mboundView4, drawable2);
            if (getBuildSdkInt() >= 21) {
                this.mboundView2.setBackgroundTintList(Converters.convertColorToColorStateList(i));
                this.mboundView4.setBackgroundTintList(Converters.convertColorToColorStateList(i2));
            }
        }
        if (i5 != 0) {
            Boolean bool = null;
            ViewBindingAdapters.clickListener(this.visibleToAll, onClickListener, bool);
            ViewBindingAdapters.clickListener(this.visibleToMe, onClickListener, bool);
        }
    }
}
