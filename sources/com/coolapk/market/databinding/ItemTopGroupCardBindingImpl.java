package com.coolapk.market.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.model.TopCard;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.util.CircleTransform;
import java.util.List;

public class ItemTopGroupCardBindingImpl extends ItemTopGroupCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView4;
    private final TextView mboundView5;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362794, 7);
        sparseIntArray.put(2131362795, 8);
        sparseIntArray.put(2131362642, 9);
    }

    public ItemTopGroupCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ItemTopGroupCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CoolapkCardView) objArr[0], (RecyclerView) objArr[9], (ImageView) objArr[3], (ImageView) objArr[6], (LinearLayout) objArr[7], (LinearLayout) objArr[8]);
        this.mDirtyFlags = -1;
        this.coolapkCardView.setTag(null);
        this.itemViewImageTopLeft.setTag(null);
        this.itemViewImageTopRight.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.mboundView5 = textView4;
        textView4.setTag(null);
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
        if (44 == i) {
            setCard((TopGroupCard) obj);
        } else if (211 != i) {
            return false;
        } else {
            setOnBitmapTransform((CircleTransform) obj);
        }
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemTopGroupCardBinding
    public void setCard(TopGroupCard topGroupCard) {
        this.mCard = topGroupCard;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // com.coolapk.market.databinding.ItemTopGroupCardBinding
    public void setOnBitmapTransform(CircleTransform circleTransform) {
        this.mOnBitmapTransform = circleTransform;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(211);
        super.requestRebind();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009e  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        long j2;
        String str5;
        String str6;
        boolean z2;
        TopCard topCard;
        TopCard topCard2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        TopGroupCard topGroupCard = this.mCard;
        CircleTransform circleTransform = this.mOnBitmapTransform;
        boolean z3 = false;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i != 0) {
            List<TopCard> entities = topGroupCard != null ? topGroupCard.getEntities() : null;
            if (entities != null) {
                topCard = (TopCard) getFromList(entities, 1);
                topCard2 = (TopCard) getFromList(entities, 0);
            } else {
                topCard2 = null;
                topCard = null;
            }
            if ((j & 5) != 0) {
                if (topCard != null) {
                    str15 = topCard.getTitle();
                    str14 = topCard.getSubTitle();
                } else {
                    str15 = null;
                    str14 = null;
                }
                if (topCard2 != null) {
                    str13 = topCard2.getSubTitle();
                    str12 = topCard2.getTitle();
                    str4 = topCard == null ? topCard.getPic() : null;
                    if (topCard2 == null) {
                        str3 = topCard2.getPic();
                    } else {
                        str3 = null;
                    }
                    z = str4 != null;
                    if (str3 == null) {
                        z3 = true;
                    }
                    if (i != 0) {
                        j = z ? j | 16 : j | 8;
                    }
                    if ((j & 7) != 0) {
                        j2 = 64;
                    } else if (z3) {
                        j2 = 64;
                        j |= 64;
                    } else {
                        j2 = 64;
                        j |= 32;
                    }
                    str5 = str14;
                    str2 = str13;
                    str = str12;
                    str6 = str15;
                    z2 = z3;
                } else {
                    str13 = null;
                }
            } else {
                str15 = null;
                str14 = null;
                str13 = null;
            }
            str12 = str13;
            if (topCard == null) {
            }
            if (topCard2 == null) {
            }
            if (str4 != null) {
            }
            if (str3 == null) {
            }
            if (i != 0) {
            }
            if ((j & 7) != 0) {
            }
            str5 = str14;
            str2 = str13;
            str = str12;
            str6 = str15;
            z2 = z3;
        } else {
            j2 = 64;
            topCard2 = null;
            topCard = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            z2 = false;
            z = false;
        }
        String logo = ((j & j2) == 0 || topCard2 == null) ? null : topCard2.getLogo();
        if ((16 & j) == 0 || topCard == null) {
            str7 = null;
        } else {
            str7 = topCard.getLogo();
        }
        int i2 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (z) {
                str4 = str7;
            }
            if (z2) {
                str3 = logo;
            }
            str8 = str4;
            str9 = str3;
        } else {
            str9 = null;
            str8 = null;
        }
        if (i2 != 0) {
            Drawable drawable = null;
            Boolean bool = null;
            str11 = str5;
            str10 = str6;
            String str16 = null;
            OnImageLoadListener onImageLoadListener = null;
            View.OnClickListener onClickListener = null;
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.itemViewImageTopLeft, str9, drawable, 0, 0, bool, bool, bool, bool, bool, str16, onImageLoadListener, circleTransform, true, bool, bool, onClickListener, bool);
            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.itemViewImageTopRight, str8, drawable, 0, 0, bool, bool, bool, bool, bool, str16, onImageLoadListener, circleTransform, true, bool, bool, onClickListener, bool);
        } else {
            str10 = str6;
            str11 = str5;
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str);
            TextViewBindingAdapter.setText(this.mboundView2, str2);
            TextViewBindingAdapter.setText(this.mboundView4, str10);
            TextViewBindingAdapter.setText(this.mboundView5, str11);
        }
    }
}
