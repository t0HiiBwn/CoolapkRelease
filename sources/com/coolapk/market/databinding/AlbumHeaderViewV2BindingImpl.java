package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.widget.AlbumActionView;
import com.coolapk.market.widget.AutoLinkTextView;

public class AlbumHeaderViewV2BindingImpl extends AlbumHeaderViewV2Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(5, new String[]{"feed_warning"}, new int[]{7}, new int[]{2131558563});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362085, 8);
        sparseIntArray.put(2131363526, 9);
        sparseIntArray.put(2131363219, 10);
    }

    public AlbumHeaderViewV2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AlbumHeaderViewV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AlbumActionView) objArr[4], (FeedWarningBinding) objArr[7], (FrameLayout) objArr[8], (ImageView) objArr[1], (TextView) objArr[3], (AutoLinkTextView) objArr[6], (LinearLayout) objArr[5], (ImageView) objArr[10], (LinearLayout) objArr[9], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.albumAction.setTag(null);
        setContainedBinding(this.alertView);
        this.coverView.setTag(null);
        this.infoView.setTag(null);
        this.introduceShadowView.setTag(null);
        this.introduceView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (308 != i) {
            return false;
        }
        setViewModel((AlbumDetailViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumHeaderViewV2Binding
    public void setViewModel(AlbumDetailViewModel albumDetailViewModel) {
        updateRegistration(1, albumDetailViewModel);
        this.mViewModel = albumDetailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.alertView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeAlertView((FeedWarningBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AlbumDetailViewModel) obj, i2);
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

    private boolean onChangeViewModel(AlbumDetailViewModel albumDetailViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 13) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 8) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 14) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i != 19) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Album album;
        String str2;
        String str3;
        Integer num;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumDetailViewModel albumDetailViewModel = this.mViewModel;
        if ((254 & j) != 0) {
            str3 = ((j & 134) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumTitle();
            str2 = ((j & 138) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbumInfo();
            Album album2 = ((j & 146) == 0 || albumDetailViewModel == null) ? null : albumDetailViewModel.getAlbum();
            if ((j & 226) == 0 || albumDetailViewModel == null) {
                num = null;
                str = null;
                album = album2;
            } else {
                String albumIntro = albumDetailViewModel.getAlbumIntro();
                num = albumDetailViewModel.getAlbumMaxWords();
                album = album2;
                str = albumIntro;
            }
        } else {
            num = null;
            str3 = null;
            str2 = null;
            album = null;
            str = null;
        }
        if ((146 & j) != 0) {
            ViewBindingAdapters.updateAlbum(this.albumAction, album);
        }
        if ((128 & j) != 0) {
            String str4 = null;
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.coverView, str4, null, 0, 0, bool, bool, bool, bool, bool, str4, null, null, true, bool, bool, null, bool);
        }
        if ((138 & j) != 0) {
            TextViewBindingAdapter.setText(this.infoView, str2);
        }
        if ((j & 226) != 0) {
            TextViewBindingAdapters.setAutoTextViewLinkable(this.introduceShadowView, str, num, "查看更多", null);
        }
        if ((j & 134) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str3);
        }
        executeBindingsOn(this.alertView);
    }
}
