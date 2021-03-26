package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;

public class ItemDocListCardItemBindingImpl extends ItemDocListCardItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemDocListCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemDocListCardItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[4], (ImageView) objArr[1]);
        this.mDirtyFlags = -1;
        this.entityTypeNameView.setTag(null);
        this.getView.setTag(null);
        this.iconView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
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
        if (190 == i) {
            setLogo((String) obj);
        } else if (97 == i) {
            setEntityTypeName((String) obj);
        } else if (279 == i) {
            setTitle((String) obj);
        } else if (169 != i) {
            return false;
        } else {
            setIsGift(((Boolean) obj).booleanValue());
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemDocListCardItemBinding
    public void setLogo(String str) {
        this.mLogo = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(190);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDocListCardItemBinding
    public void setEntityTypeName(String str) {
        this.mEntityTypeName = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(97);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDocListCardItemBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(279);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemDocListCardItemBinding
    public void setIsGift(boolean z) {
        this.mIsGift = z;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(169);
        super.requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0090, code lost:
        if (r13 != false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str2 = this.mLogo;
        String str3 = this.mEntityTypeName;
        String str4 = this.mTitle;
        boolean z2 = this.mIsGift;
        int i5 = 8;
        if ((j & 19) != 0) {
            int i6 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
            z = TextUtils.isEmpty(str2);
            if (i6 != 0) {
                j |= z ? 64 : 32;
            }
            if ((j & 19) != 0) {
                j = z ? j | 256 : j | 128;
            }
            if ((j & 17) != 0 && z) {
                i = 8;
                i2 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
                if (i2 != 0) {
                    if (i2 != 0) {
                        j |= z2 ? 1024 : 512;
                    }
                    if (!z2) {
                        i3 = 8;
                        boolean z3 = (256 & j) != 0 ? !TextUtils.isEmpty(str3) : false;
                        i4 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
                        if (i4 != 0) {
                            if (!z) {
                                z3 = false;
                            }
                            if (i4 != 0) {
                                j |= z3 ? 4096 : 2048;
                            }
                        }
                        i5 = 0;
                        if ((18 & j) != 0) {
                            TextViewBindingAdapter.setText(this.entityTypeNameView, str3);
                        }
                        if ((19 & j) != 0) {
                            this.entityTypeNameView.setVisibility(i5);
                        }
                        if ((16 & j) != 0) {
                            ThemeBindingAdapters.setTextColor(this.getView, "colorAccent");
                        }
                        if ((j & 24) != 0) {
                            this.getView.setVisibility(i3);
                        }
                        if ((j & 17) != 0) {
                            this.iconView.setVisibility(i);
                            Boolean bool = null;
                            str = str4;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str2, AppCompatResources.getDrawable(this.iconView.getContext(), 2131231374), 0, 0, bool, bool, bool, true, bool, null, null, null, bool, bool, bool, null, bool);
                        } else {
                            str = str4;
                        }
                        if ((j & 20) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView3, str);
                            return;
                        }
                        return;
                    }
                }
                i3 = 0;
                if ((256 & j) != 0) {
                }
                i4 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
                if (i4 != 0) {
                }
                i5 = 0;
                if ((18 & j) != 0) {
                }
                if ((19 & j) != 0) {
                }
                if ((16 & j) != 0) {
                }
                if ((j & 24) != 0) {
                }
                if ((j & 17) != 0) {
                }
                if ((j & 20) != 0) {
                }
            }
        } else {
            z = false;
        }
        i = 0;
        i2 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if (i2 != 0) {
        }
        i3 = 0;
        if ((256 & j) != 0) {
        }
        i4 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
        if (i4 != 0) {
        }
        i5 = 0;
        if ((18 & j) != 0) {
        }
        if ((19 & j) != 0) {
        }
        if ((16 & j) != 0) {
        }
        if ((j & 24) != 0) {
        }
        if ((j & 17) != 0) {
        }
        if ((j & 20) != 0) {
        }
    }
}
