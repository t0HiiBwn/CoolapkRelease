package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.viewholder.CardDoubleViewHolder;

public class ItemCardDoubleItemBindingImpl extends ItemCardDoubleItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131363435, 5);
        sparseIntArray.put(2131363460, 6);
    }

    public ItemCardDoubleItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemCardDoubleItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (LinearLayout) objArr[5], (TextView) objArr[6], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        this.actionButton.setTag(null);
        this.iconView.setTag(null);
        this.infoView.setTag(null);
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
        if (308 != i) {
            return false;
        }
        setViewModel((CardDoubleViewHolder.ChildItemViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCardDoubleItemBinding
    public void setViewModel(CardDoubleViewHolder.ChildItemViewModel childItemViewModel) {
        updateRegistration(5, childItemViewModel);
        this.mViewModel = childItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(308);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelLogo((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelTransform((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelTitle((ObservableField) obj, i2);
        }
        if (i == 3) {
            return onChangeViewModelInfo((ObservableField) obj, i2);
        }
        if (i == 4) {
            return onChangeViewModelActionText((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return onChangeViewModel((CardDoubleViewHolder.ChildItemViewModel) obj, i2);
    }

    private boolean onChangeViewModelLogo(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelTransform(ObservableField<OnBitmapTransformListener> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelTitle(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelInfo(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelActionText(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModel(CardDoubleViewHolder.ChildItemViewModel childItemViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        OnBitmapTransformListener onBitmapTransformListener;
        String str;
        int i;
        String str2;
        String str3;
        long j2;
        String str4;
        OnBitmapTransformListener onBitmapTransformListener2;
        String str5;
        int i2;
        ObservableField<OnBitmapTransformListener> observableField;
        ObservableField<String> observableField2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CardDoubleViewHolder.ChildItemViewModel childItemViewModel = this.mViewModel;
        if ((127 & j) != 0) {
            if ((j & 99) != 0) {
                if (childItemViewModel != null) {
                    observableField2 = childItemViewModel.logo;
                    observableField = childItemViewModel.transform;
                } else {
                    observableField2 = null;
                    observableField = null;
                }
                updateRegistration(0, observableField2);
                updateRegistration(1, observableField);
                str5 = observableField2 != null ? observableField2.get() : null;
                onBitmapTransformListener2 = observableField != null ? observableField.get() : null;
            } else {
                str5 = null;
                onBitmapTransformListener2 = null;
            }
            if ((j & 100) != 0) {
                ObservableField<String> observableField3 = childItemViewModel != null ? childItemViewModel.title : null;
                updateRegistration(2, observableField3);
                if (observableField3 != null) {
                    str3 = observableField3.get();
                    if ((j & 104) != 0) {
                        ObservableField<String> observableField4 = childItemViewModel != null ? childItemViewModel.info : null;
                        updateRegistration(3, observableField4);
                        if (observableField4 != null) {
                            str2 = observableField4.get();
                            i2 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
                            if (i2 != 0) {
                                ObservableField<String> observableField5 = childItemViewModel != null ? childItemViewModel.actionText : null;
                                updateRegistration(4, observableField5);
                                str4 = observableField5 != null ? observableField5.get() : null;
                                boolean isEmpty = TextUtils.isEmpty(str4);
                                if (i2 != 0) {
                                    j |= isEmpty ? 256 : 128;
                                }
                                i = isEmpty ? 8 : 0;
                                str = str5;
                                onBitmapTransformListener = onBitmapTransformListener2;
                                j2 = 112;
                                if ((j2 & j) != 0) {
                                    TextViewBindingAdapter.setText(this.actionButton, str4);
                                    this.actionButton.setVisibility(i);
                                }
                                if ((64 & j) != 0) {
                                    ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
                                }
                                if ((j & 99) != 0) {
                                    Boolean bool = null;
                                    ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, onBitmapTransformListener, true, bool, bool, null, bool);
                                }
                                if ((104 & j) != 0) {
                                    TextViewBindingAdapter.setText(this.infoView, str2);
                                }
                                if ((j & 100) == 0) {
                                    TextViewBindingAdapter.setText(this.titleView, str3);
                                    return;
                                }
                                return;
                            }
                            str = str5;
                            onBitmapTransformListener = onBitmapTransformListener2;
                            str4 = null;
                        }
                    }
                    str2 = null;
                    i2 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
                    if (i2 != 0) {
                    }
                }
            }
            str3 = null;
            if ((j & 104) != 0) {
            }
            str2 = null;
            i2 = ((j & 112) > 0 ? 1 : ((j & 112) == 0 ? 0 : -1));
            if (i2 != 0) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            onBitmapTransformListener = null;
        }
        j2 = 112;
        i = 0;
        if ((j2 & j) != 0) {
        }
        if ((64 & j) != 0) {
        }
        if ((j & 99) != 0) {
        }
        if ((104 & j) != 0) {
        }
        if ((j & 100) == 0) {
        }
    }
}
