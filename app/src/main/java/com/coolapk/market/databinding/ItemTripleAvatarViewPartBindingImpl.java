package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;

public class ItemTripleAvatarViewPartBindingImpl extends ItemTripleAvatarViewPartBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final ImageView mboundView2;
    private final ImageView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTripleAvatarViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemTripleAvatarViewPartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1;
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[3];
        this.mboundView3 = imageView3;
        imageView3.setTag(null);
        this.rootView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (40 == i) {
            setAvatar1((String) obj);
        } else if (42 == i) {
            setAvatar3((String) obj);
        } else if (41 == i) {
            setAvatar2((String) obj);
        } else if (287 != i) {
            return false;
        } else {
            setTransformer((OnBitmapTransformListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTripleAvatarViewPartBinding
    public void setAvatar1(String str) {
        this.mAvatar1 = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(40);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleAvatarViewPartBinding
    public void setAvatar3(String str) {
        this.mAvatar3 = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(42);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleAvatarViewPartBinding
    public void setAvatar2(String str) {
        this.mAvatar2 = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(41);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTripleAvatarViewPartBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(287);
        super.requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
        if (r17 != false) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        OnBitmapTransformListener onBitmapTransformListener;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean isEmpty;
        int i7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str2 = this.mAvatar1;
        String str3 = this.mAvatar3;
        String str4 = this.mAvatar2;
        OnBitmapTransformListener onBitmapTransformListener2 = this.mTransformer;
        int i8 = 8;
        if (!((j & 25) == 0 || (j & 17) == 0)) {
            boolean isEmpty2 = TextUtils.isEmpty(str2);
            if (i7 != 0) {
                j |= isEmpty2 ? 256 : 128;
            }
            if (isEmpty2) {
                i = 8;
                if (!((j & 26) == 0 || (j & 18) == 0)) {
                    isEmpty = TextUtils.isEmpty(str3);
                    if (i6 != 0) {
                        j |= isEmpty ? 64 : 32;
                    }
                    if (isEmpty) {
                        i2 = 8;
                        if (!((j & 28) == 0 || (j & 20) == 0)) {
                            boolean isEmpty3 = TextUtils.isEmpty(str4);
                            if (i5 != 0) {
                                j |= isEmpty3 ? 1024 : 512;
                            }
                        }
                        i8 = 0;
                        int i9 = ((j & 31) > 0 ? 1 : ((j & 31) == 0 ? 0 : -1));
                        if ((17 & j) != 0) {
                            this.mboundView1.setVisibility(i);
                        }
                        if ((25 & j) != 0) {
                            i4 = i8;
                            Boolean bool = null;
                            i3 = i2;
                            onBitmapTransformListener = onBitmapTransformListener2;
                            str = str4;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView1, str2, null, 2131231152, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, bool, bool, bool, null, bool);
                        } else {
                            i3 = i2;
                            i4 = i8;
                            str = str4;
                            onBitmapTransformListener = onBitmapTransformListener2;
                        }
                        if ((16 & j) != 0) {
                            Number number = null;
                            ViewBindingAdapters.clipView(this.mboundView1, "oval", number);
                            ViewBindingAdapters.clipView(this.mboundView2, "oval", number);
                            ViewBindingAdapters.clipView(this.mboundView3, "oval", number);
                        }
                        if ((j & 20) != 0) {
                            this.mboundView2.setVisibility(i4);
                        }
                        if ((j & 28) != 0) {
                            Boolean bool2 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView2, str, null, 2131231152, 0, bool2, bool2, bool2, bool2, bool2, null, null, onBitmapTransformListener, bool2, bool2, bool2, null, bool2);
                        }
                        if ((j & 18) != 0) {
                            this.mboundView3.setVisibility(i3);
                        }
                        if ((j & 26) != 0) {
                            Boolean bool3 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.mboundView3, str3, null, 2131231152, 0, bool3, bool3, bool3, bool3, bool3, null, null, onBitmapTransformListener, bool3, bool3, bool3, null, bool3);
                            return;
                        }
                        return;
                    }
                }
                i2 = 0;
                boolean isEmpty3 = TextUtils.isEmpty(str4);
                if (i5 != 0) {
                }
            }
        }
        i = 0;
        isEmpty = TextUtils.isEmpty(str3);
        if (i6 != 0) {
        }
        if (isEmpty) {
        }
        i2 = 0;
        boolean isEmpty3 = TextUtils.isEmpty(str4);
        if (i5 != 0) {
        }
    }
}
