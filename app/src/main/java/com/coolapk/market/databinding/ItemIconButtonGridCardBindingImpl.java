package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AspectRatioImageView;

public class ItemIconButtonGridCardBindingImpl extends ItemIconButtonGridCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;
    private final TextView mboundView6;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362768, 7);
        sparseIntArray.put(2131362679, 8);
        sparseIntArray.put(2131362678, 9);
        sparseIntArray.put(2131362681, 10);
        sparseIntArray.put(2131362680, 11);
    }

    public ItemIconButtonGridCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ItemIconButtonGridCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (FrameLayout) objArr[4], (CoolapkCardView) objArr[0], (ImageView) objArr[9], (LinearLayout) objArr[8], (ImageView) objArr[11], (LinearLayout) objArr[10], (AspectRatioImageView) objArr[2], (AspectRatioImageView) objArr[5], (LinearLayout) objArr[7]);
        this.mDirtyFlags = -1;
        this.cardView0.setTag(null);
        this.cardView1.setTag(null);
        this.coolapkCardView.setTag(null);
        this.img0.setTag(null);
        this.img1.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
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
        if (46 == i) {
            setCard2((Entity) obj);
        } else if (185 == i) {
            setLoadListener((OnImageLoadListener) obj);
        } else if (45 == i) {
            setCard1((Entity) obj);
        } else if (50 != i) {
            return false;
        } else {
            setClick((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemIconButtonGridCardBinding
    public void setCard2(Entity entity) {
        this.mCard2 = entity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(46);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconButtonGridCardBinding
    public void setLoadListener(OnImageLoadListener onImageLoadListener) {
        this.mLoadListener = onImageLoadListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(185);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconButtonGridCardBinding
    public void setCard1(Entity entity) {
        this.mCard1 = entity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(45);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemIconButtonGridCardBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b2  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        boolean z;
        String str2;
        int i2;
        String str3;
        String str4;
        int i3;
        String str5;
        int i4;
        String str6;
        int i5;
        String str7;
        int i6;
        OnImageLoadListener onImageLoadListener;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Entity entity = this.mCard2;
        OnImageLoadListener onImageLoadListener2 = this.mLoadListener;
        Entity entity2 = this.mCard1;
        View.OnClickListener onClickListener = this.mClick;
        int i7 = 8;
        boolean z2 = false;
        int i8 = ((j & 19) > 0 ? 1 : ((j & 19) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (entity != null) {
                str2 = entity.getPic();
            } else {
                str2 = null;
            }
            z = str2 == null;
            if (i8 != 0) {
                j = z ? j | 256 : j | 128;
            }
            int i9 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
            if (i9 != 0) {
                String title = entity != null ? entity.getTitle() : null;
                boolean isEmpty = TextUtils.isEmpty(title);
                if (i9 != 0) {
                    j |= isEmpty ? 4096 : 2048;
                }
                str = title;
                i = isEmpty ? 8 : 0;
                i2 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
                if (i2 == 0) {
                    if (entity2 != null) {
                        str4 = entity2.getPic();
                    } else {
                        str4 = null;
                    }
                    boolean z3 = str4 == null;
                    if (i2 != 0) {
                        j = z3 ? j | 1024 : j | 512;
                    }
                    int i10 = ((j & 20) > 0 ? 1 : ((j & 20) == 0 ? 0 : -1));
                    if (i10 != 0) {
                        String title2 = entity2 != null ? entity2.getTitle() : null;
                        boolean isEmpty2 = TextUtils.isEmpty(title2);
                        if (i10 != 0) {
                            j |= isEmpty2 ? 64 : 32;
                        }
                        if (!isEmpty2) {
                            i7 = 0;
                        }
                        z2 = z3;
                        str3 = title2;
                        i3 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
                        String logo = ((256 & j) != 0 || entity == null) ? null : entity.getLogo();
                        if ((j & 1024) != 0 || entity2 == null) {
                            str5 = null;
                        } else {
                            str5 = entity2.getLogo();
                        }
                        i4 = ((19 & j) > 0 ? 1 : ((19 & j) == 0 ? 0 : -1));
                        if (i4 != 0) {
                            if (z) {
                                str2 = logo;
                            }
                            str6 = str2;
                        } else {
                            str6 = null;
                        }
                        i5 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
                        if (i5 != 0) {
                            if (z2) {
                                str4 = str5;
                            }
                            str7 = str4;
                        } else {
                            str7 = null;
                        }
                        if (i3 != 0) {
                            Boolean bool = null;
                            ViewBindingAdapters.clickListener(this.cardView0, onClickListener, bool);
                            ViewBindingAdapters.clickListener(this.cardView1, onClickListener, bool);
                        }
                        if ((16 & j) != 0) {
                            String str8 = null;
                            ViewBindingAdapters.clipView(this.cardView0, str8, 4);
                            ViewBindingAdapters.clipView(this.cardView1, str8, 4);
                        }
                        if (i5 != 0) {
                            Boolean bool2 = null;
                            i6 = i7;
                            onImageLoadListener = onImageLoadListener2;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.img0, str7, null, 2131231696, 0, bool2, bool2, bool2, bool2, bool2, null, onImageLoadListener, null, bool2, bool2, true, null, bool2);
                        } else {
                            onImageLoadListener = onImageLoadListener2;
                            i6 = i7;
                        }
                        if (i4 != 0) {
                            Boolean bool3 = null;
                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.img1, str6, null, 2131231696, 0, bool3, bool3, bool3, bool3, bool3, null, onImageLoadListener, null, bool3, bool3, true, null, bool3);
                        }
                        if ((j & 20) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView3, str3);
                            this.mboundView3.setVisibility(i6);
                        }
                        if ((j & 17) != 0) {
                            TextViewBindingAdapter.setText(this.mboundView6, str);
                            this.mboundView6.setVisibility(i);
                            return;
                        }
                        return;
                    }
                    z2 = z3;
                    str3 = null;
                } else {
                    str4 = null;
                    str3 = null;
                }
                i7 = 0;
                i3 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
                if ((256 & j) != 0) {
                }
                if ((j & 1024) != 0) {
                }
                str5 = null;
                i4 = ((19 & j) > 0 ? 1 : ((19 & j) == 0 ? 0 : -1));
                if (i4 != 0) {
                }
                i5 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
                if (i5 != 0) {
                }
                if (i3 != 0) {
                }
                if ((16 & j) != 0) {
                }
                if (i5 != 0) {
                }
                if (i4 != 0) {
                }
                if ((j & 20) != 0) {
                }
                if ((j & 17) != 0) {
                }
            } else {
                str = null;
            }
        } else {
            str2 = null;
            str = null;
            z = false;
        }
        i = 0;
        i2 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
        if (i2 == 0) {
        }
        i7 = 0;
        i3 = ((j & 24) > 0 ? 1 : ((j & 24) == 0 ? 0 : -1));
        if ((256 & j) != 0) {
        }
        if ((j & 1024) != 0) {
        }
        str5 = null;
        i4 = ((19 & j) > 0 ? 1 : ((19 & j) == 0 ? 0 : -1));
        if (i4 != 0) {
        }
        i5 = ((j & 22) > 0 ? 1 : ((j & 22) == 0 ? 0 : -1));
        if (i5 != 0) {
        }
        if (i3 != 0) {
        }
        if ((16 & j) != 0) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if ((j & 20) != 0) {
        }
        if ((j & 17) != 0) {
        }
    }
}
