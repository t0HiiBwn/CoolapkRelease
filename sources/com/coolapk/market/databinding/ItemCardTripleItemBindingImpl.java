package com.coolapk.market.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.coolapk.market.binding.ImageViewBindingAdapters;
import com.coolapk.market.binding.ThemeBindingAdapters;
import com.coolapk.market.viewholder.CardTripleViewHolder;

public class ItemCardTripleItemBindingImpl extends ItemCardTripleItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    public ItemCardTripleItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemCardTripleItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
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
            this.mDirtyFlags = 32;
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
        setViewModel((CardTripleViewHolder.ChildItemViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.ItemCardTripleItemBinding
    public void setViewModel(CardTripleViewHolder.ChildItemViewModel childItemViewModel) {
        updateRegistration(4, childItemViewModel);
        this.mViewModel = childItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
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
            return onChangeViewModelTitle((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelInfo((ObservableField) obj, i2);
        }
        if (i == 3) {
            return onChangeViewModelActionText((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeViewModel((CardTripleViewHolder.ChildItemViewModel) obj, i2);
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

    private boolean onChangeViewModelTitle(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelInfo(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelActionText(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModel(CardTripleViewHolder.ChildItemViewModel childItemViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CardTripleViewHolder.ChildItemViewModel childItemViewModel = this.mViewModel;
        if ((63 & j) != 0) {
            if ((j & 49) != 0) {
                ObservableField<String> observableField = childItemViewModel != null ? childItemViewModel.logo : null;
                updateRegistration(0, observableField);
                if (observableField != null) {
                    str5 = observableField.get();
                    if ((j & 50) != 0) {
                        ObservableField<String> observableField2 = childItemViewModel != null ? childItemViewModel.title : null;
                        updateRegistration(1, observableField2);
                        if (observableField2 != null) {
                            str3 = observableField2.get();
                            if ((j & 52) != 0) {
                                ObservableField<String> observableField3 = childItemViewModel != null ? childItemViewModel.info : null;
                                updateRegistration(2, observableField3);
                                if (observableField3 != null) {
                                    str2 = observableField3.get();
                                    i2 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
                                    if (i2 == 0) {
                                        ObservableField<String> observableField4 = childItemViewModel != null ? childItemViewModel.actionText : null;
                                        updateRegistration(3, observableField4);
                                        str4 = observableField4 != null ? observableField4.get() : null;
                                        boolean isEmpty = TextUtils.isEmpty(str4);
                                        if (i2 != 0) {
                                            j |= isEmpty ? 128 : 64;
                                        }
                                        i = isEmpty ? 8 : 0;
                                        str = str5;
                                        if ((j & 56) != 0) {
                                            TextViewBindingAdapter.setText(this.actionButton, str4);
                                            this.actionButton.setVisibility(i);
                                        }
                                        if ((j & 32) != 0) {
                                            ThemeBindingAdapters.setTextColor(this.actionButton, "colorAccent");
                                        }
                                        if ((j & 49) != 0) {
                                            Boolean bool = null;
                                            ImageViewBindingAdapters.setImageUriWithContext(this.mBindingComponent, this.iconView, str, null, 0, 0, bool, bool, bool, bool, bool, null, null, null, true, bool, bool, null, bool);
                                        }
                                        if ((j & 52) != 0) {
                                            TextViewBindingAdapter.setText(this.infoView, str2);
                                        }
                                        if ((j & 50) == 0) {
                                            TextViewBindingAdapter.setText(this.titleView, str3);
                                            return;
                                        }
                                        return;
                                    }
                                    str = str5;
                                    str4 = null;
                                }
                            }
                            str2 = null;
                            i2 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
                            if (i2 == 0) {
                            }
                        }
                    }
                    str3 = null;
                    if ((j & 52) != 0) {
                    }
                    str2 = null;
                    i2 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
                    if (i2 == 0) {
                    }
                }
            }
            str5 = null;
            if ((j & 50) != 0) {
            }
            str3 = null;
            if ((j & 52) != 0) {
            }
            str2 = null;
            i2 = ((j & 56) > 0 ? 1 : ((j & 56) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        i = 0;
        if ((j & 56) != 0) {
        }
        if ((j & 32) != 0) {
        }
        if ((j & 49) != 0) {
        }
        if ((j & 52) != 0) {
        }
        if ((j & 50) == 0) {
        }
    }
}
