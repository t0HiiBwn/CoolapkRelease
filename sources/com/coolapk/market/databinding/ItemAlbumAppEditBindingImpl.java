package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.view.album.AlbumItemViewModel;

public class ItemAlbumAppEditBindingImpl extends ItemAlbumAppEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final View mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362322, 7);
        sparseIntArray.put(2131362074, 8);
        sparseIntArray.put(2131363038, 9);
        sparseIntArray.put(2131363069, 10);
    }

    public ItemAlbumAppEditBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ItemAlbumAppEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[8], (LinearLayout) objArr[5], (TextView) objArr[6], (LinearLayout) objArr[0], (LinearLayout) objArr[7], (ImageView) objArr[1], (ImageView) objArr[9], (ImageView) objArr[10], (TextView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.appCommentView.setTag(null);
        this.appEditText.setTag(null);
        this.cardView.setTag(null);
        this.iconView.setTag(null);
        View view2 = (View) objArr[4];
        this.mboundView4 = view2;
        view2.setTag(null);
        this.titleView.setTag(null);
        this.versionView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (198 == i) {
            setModel((AlbumItemViewModel) obj);
        } else if (27 != i) {
            return false;
        } else {
            setApp((AlbumItem) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemAlbumAppEditBinding
    public void setModel(AlbumItemViewModel albumItemViewModel) {
        updateRegistration(0, albumItemViewModel);
        this.mModel = albumItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemAlbumAppEditBinding
    public void setApp(AlbumItem albumItem) {
        this.mApp = albumItem;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((AlbumItemViewModel) obj, i2);
    }

    private boolean onChangeModel(AlbumItemViewModel albumItemViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 192) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 279) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 25) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i != 208) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AlbumItemViewModel albumItemViewModel = this.mModel;
        int i2 = 0;
        if ((125 & j) != 0) {
            String logoUrl = ((j & 69) == 0 || albumItemViewModel == null) ? null : albumItemViewModel.getLogoUrl();
            str4 = ((j & 81) == 0 || albumItemViewModel == null) ? null : albumItemViewModel.getApkName();
            if ((j & 73) != 0) {
                str3 = albumItemViewModel != null ? albumItemViewModel.getTitle() : null;
                str2 = "点评 " + str3;
            } else {
                str3 = null;
                str2 = null;
            }
            int i3 = ((j & 97) > 0 ? 1 : ((j & 97) == 0 ? 0 : -1));
            if (i3 != 0) {
                str5 = albumItemViewModel != null ? albumItemViewModel.getNote() : null;
                boolean isEmpty = TextUtils.isEmpty(str5);
                if (i3 != 0) {
                    j |= isEmpty ? 256 : 128;
                }
                if (isEmpty) {
                    i2 = 8;
                }
                str = logoUrl;
                i = i2;
                if ((j & 97) != 0) {
                    this.appCommentView.setVisibility(i);
                    TextViewBindingAdapter.setText(this.appEditText, str5);
                    this.mboundView4.setVisibility(i);
                }
                if ((73 & j) != 0) {
                    this.appEditText.setHint(str2);
                    TextViewBindingAdapter.setText(this.titleView, str3);
                }
                if ((69 & j) != 0) {
                    Boolean bool = null;
                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 2131231374, 0, bool, bool, bool, bool, bool, null, null, null, bool, bool, bool, null, bool);
                }
                if ((j & 81) == 0) {
                    TextViewBindingAdapter.setText(this.versionView, str4);
                    return;
                }
                return;
            }
            str = logoUrl;
            str5 = null;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        if ((j & 97) != 0) {
        }
        if ((73 & j) != 0) {
        }
        if ((69 & j) != 0) {
        }
        if ((j & 81) == 0) {
        }
    }
}
