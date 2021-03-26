package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.model.Message;
import com.coolapk.market.widget.view.ShapedImageView;

public class ItemChatingUserBindingImpl extends ItemChatingUserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362946, 6);
    }

    public ItemChatingUserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemChatingUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (TextView) objArr[5], (LinearLayout) objArr[2], (LinearLayout) objArr[6], (ShapedImageView) objArr[4], (TextView) objArr[3], (ImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.cardView.setTag(null);
        this.errorPicView.setTag(null);
        this.messageView.setTag(null);
        this.picView.setTag(null);
        this.textView.setTag(null);
        this.userAvatarView.setTag(null);
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
            setModel((Message) obj);
        } else if (255 == i) {
            setShowPic((Boolean) obj);
        } else if (250 == i) {
            setShowError((Boolean) obj);
        } else if (221 == i) {
            setPic((String) obj);
        } else if (288 == i) {
            setTransformer((OnBitmapTransformListener) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setModel(Message message) {
        this.mModel = message;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(198);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setShowPic(Boolean bool) {
        this.mShowPic = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(255);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setShowError(Boolean bool) {
        this.mShowError = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(250);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setPic(String str) {
        this.mPic = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(221);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.mTransformer = onBitmapTransformListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemChatingUserBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009d, code lost:
        if (r18 != false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        OnBitmapTransformListener onBitmapTransformListener;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Message message = this.mModel;
        Boolean bool = this.mShowPic;
        Boolean bool2 = this.mShowError;
        String str3 = this.mPic;
        OnBitmapTransformListener onBitmapTransformListener2 = this.mTransformer;
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 81) != 0) {
            String message2 = ((j & 65) == 0 || message == null) ? null : message.getMessage();
            if (message != null) {
                str = message.getFromUserAvatar();
                str2 = message2;
            } else {
                str2 = message2;
                str = null;
            }
        } else {
            str2 = null;
            str = null;
        }
        int i5 = 8;
        int i6 = ((j & 66) > 0 ? 1 : ((j & 66) == 0 ? 0 : -1));
        if (i6 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i6 != 0) {
                j |= safeUnbox ? 256 : 128;
            }
            if (!safeUnbox) {
                i = 8;
                i2 = ((j & 68) > 0 ? 1 : ((j & 68) == 0 ? 0 : -1));
                if (i2 != 0) {
                    boolean safeUnbox2 = ViewDataBinding.safeUnbox(bool2);
                    if (i2 != 0) {
                        j |= safeUnbox2 ? 1024 : 512;
                    }
                    if (!safeUnbox2) {
                        i3 = 8;
                        i4 = ((j & 72) > 0 ? 1 : ((j & 72) == 0 ? 0 : -1));
                        if (i4 != 0) {
                            boolean z = str3 != null;
                            if (i4 != 0) {
                                j |= z ? 4096 : 2048;
                            }
                        }
                        i5 = 0;
                        if ((j & 96) != 0) {
                            Boolean bool3 = null;
                            ViewBindingAdapters.clickListener(this.cardView, onClickListener, bool3);
                            ViewBindingAdapters.clickListener(this.picView, onClickListener, bool3);
                            ViewBindingAdapters.clickListener(this.userAvatarView, onClickListener, bool3);
                        }
                        if ((68 & j) != 0) {
                            this.errorPicView.setVisibility(i3);
                        }
                        if ((72 & j) != 0) {
                            this.messageView.setVisibility(i5);
                            Boolean bool4 = null;
                            onBitmapTransformListener = onBitmapTransformListener2;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.picView, str3, null, 2131231702, 0, bool4, bool4, bool4, false, bool4, null, null, null, bool4, bool4, bool4, null, true);
                        } else {
                            onBitmapTransformListener = onBitmapTransformListener2;
                        }
                        if ((j & 66) != 0) {
                            this.picView.setVisibility(i);
                        }
                        if ((j & 65) != 0) {
                            String str4 = null;
                            TextViewBindingAdapters.setTextViewLinkable(this.textView, str2, null, str4, null, null, str4);
                        }
                        if ((j & 81) != 0) {
                            Boolean bool5 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.userAvatarView, str, null, 2131231162, 0, bool5, bool5, bool5, bool5, bool5, null, null, onBitmapTransformListener, bool5, bool5, bool5, null, bool5);
                            return;
                        }
                        return;
                    }
                }
                i3 = 0;
                i4 = ((j & 72) > 0 ? 1 : ((j & 72) == 0 ? 0 : -1));
                if (i4 != 0) {
                }
                i5 = 0;
                if ((j & 96) != 0) {
                }
                if ((68 & j) != 0) {
                }
                if ((72 & j) != 0) {
                }
                if ((j & 66) != 0) {
                }
                if ((j & 65) != 0) {
                }
                if ((j & 81) != 0) {
                }
            }
        }
        i = 0;
        i2 = ((j & 68) > 0 ? 1 : ((j & 68) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        i3 = 0;
        i4 = ((j & 72) > 0 ? 1 : ((j & 72) == 0 ? 0 : -1));
        if (i4 != 0) {
        }
        i5 = 0;
        if ((j & 96) != 0) {
        }
        if ((68 & j) != 0) {
        }
        if ((72 & j) != 0) {
        }
        if ((j & 66) != 0) {
        }
        if ((j & 65) != 0) {
        }
        if ((j & 81) != 0) {
        }
    }
}
