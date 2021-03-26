package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ActionButtonBindingAdapters;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.view.album.AlbumItemViewModel;
import com.coolapk.market.viewholder.AlbumItemViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.AutoLinkTextView;

public class AlbumAppBindingImpl extends AlbumAppBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public AlbumAppBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private AlbumAppBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[6], (ActionButtonFrameLayout) objArr[5], (LinearLayout) objArr[0], (TextView) objArr[4], (ImageView) objArr[1], (AutoLinkTextView) objArr[7], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.actionContainer.setTag(null);
        this.albumAppView.setTag(null);
        this.apkSizeView.setTag(null);
        this.iconView.setTag(null);
        this.introductionView.setTag(null);
        this.sourceNameView.setTag(null);
        this.titleView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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
        if (27 == i) {
            setApp((AlbumItem) obj);
        } else if (307 == i) {
            setViewHolder((AlbumItemViewHolder) obj);
        } else if (308 != i) {
            return false;
        } else {
            setViewModel((AlbumItemViewModel) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.AlbumAppBinding
    public void setApp(AlbumItem albumItem) {
        this.mApp = albumItem;
    }

    @Override // com.coolapk.market.databinding.AlbumAppBinding
    public void setViewHolder(AlbumItemViewHolder albumItemViewHolder) {
        updateRegistration(0, albumItemViewHolder);
        this.mViewHolder = albumItemViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(307);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.AlbumAppBinding
    public void setViewModel(AlbumItemViewModel albumItemViewModel) {
        updateRegistration(1, albumItemViewModel);
        this.mViewModel = albumItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewHolder((AlbumItemViewHolder) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModel((AlbumItemViewModel) obj, i2);
    }

    private boolean onChangeViewHolder(AlbumItemViewHolder albumItemViewHolder, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModel(AlbumItemViewModel albumItemViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 191) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 278) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 266) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 25) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 15) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i != 207) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b3, code lost:
        if (r29 != false) goto L_0x00ba;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b6  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        String str3;
        String str4;
        String str5;
        AlbumItem albumItem;
        int i4;
        String str6;
        int i5;
        int i6;
        String str7;
        long j2;
        int i7;
        String str8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumItemViewHolder albumItemViewHolder = this.mViewHolder;
        AlbumItemViewModel albumItemViewModel = this.mViewModel;
        if ((1018 & j) != 0) {
            String logoUrl = ((j & 522) == 0 || albumItemViewModel == null) ? null : albumItemViewModel.getLogoUrl();
            str4 = ((j & 530) == 0 || albumItemViewModel == null) ? null : albumItemViewModel.getTitle();
            int i8 = 8;
            int i9 = ((j & 770) > 0 ? 1 : ((j & 770) == 0 ? 0 : -1));
            if (i9 != 0) {
                str6 = albumItemViewModel != null ? albumItemViewModel.getNote() : null;
                boolean isEmpty = TextUtils.isEmpty(str6);
                if (i9 != 0) {
                    j |= isEmpty ? 32768 : 16384;
                }
                if (isEmpty) {
                    i4 = 8;
                    i5 = ((j & 578) > 0 ? 1 : ((j & 578) == 0 ? 0 : -1));
                    if (i5 == 0) {
                        str7 = albumItemViewModel != null ? albumItemViewModel.getApkName() : null;
                        boolean isEmpty2 = TextUtils.isEmpty(str7);
                        if (i5 != 0) {
                            j |= isEmpty2 ? 2048 : 1024;
                        }
                        i6 = isEmpty2 ? 8 : 0;
                        j2 = 546;
                    } else {
                        str7 = null;
                        j2 = 546;
                        i6 = 0;
                    }
                    i7 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                    if (i7 == 0) {
                        str8 = albumItemViewModel != null ? albumItemViewModel.getSourceName() : null;
                        boolean isEmpty3 = TextUtils.isEmpty(str8);
                        if (i7 != 0) {
                            j |= isEmpty3 ? 8192 : 4096;
                        }
                    } else {
                        str8 = null;
                    }
                    i8 = 0;
                    albumItem = ((j & 642) != 0 || albumItemViewModel == null) ? null : albumItemViewModel.getAlbumItem();
                    i2 = i4;
                    i = i8;
                    str3 = str7;
                    i3 = i6;
                    str = str8;
                    str2 = logoUrl;
                    str5 = str6;
                }
            } else {
                str6 = null;
            }
            i4 = 0;
            i5 = ((j & 578) > 0 ? 1 : ((j & 578) == 0 ? 0 : -1));
            if (i5 == 0) {
            }
            i7 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
            if (i7 == 0) {
            }
            i8 = 0;
            if ((j & 642) != 0) {
            }
            i2 = i4;
            i = i8;
            str3 = str7;
            i3 = i6;
            str = str8;
            str2 = logoUrl;
            str5 = str6;
        } else {
            albumItem = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 642) != 0) {
            ActionButtonBindingAdapters.setActionText(this.actionButton, albumItem);
            ActionButtonBindingAdapters.setActionButtonBackground(this.actionContainer, albumItem, false);
        }
        if ((513 & j) != 0) {
            ViewBindingAdapters.clickListener(this.actionContainer, albumItemViewHolder, true);
            ViewBindingAdapters.setOnLongClickListener(this.albumAppView, albumItemViewHolder);
            ViewBindingAdapters.clickListener(this.albumAppView, albumItemViewHolder, null);
        }
        if ((578 & j) != 0) {
            TextViewBindingAdapter.setText(this.apkSizeView, str3);
            this.apkSizeView.setVisibility(i3);
        }
        if ((j & 522) != 0) {
            Boolean bool = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str2, null, 2131231363, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
        }
        if ((770 & j) != 0) {
            this.introductionView.setVisibility(i2);
            TextViewBindingAdapters.setAutoTextViewLinkable(this.introductionView, str5, null, null, null);
        }
        if ((546 & j) != 0) {
            TextViewBindingAdapter.setText(this.sourceNameView, str);
            this.sourceNameView.setVisibility(i);
        }
        if ((j & 530) != 0) {
            TextViewBindingAdapter.setText(this.titleView, str4);
        }
    }
}
