package com.coolapk.market.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.user.edit.EditUserBaseViewModel;
import com.coolapk.market.widget.view.WeUIItem;

public class EditUserViewBindingImpl extends EditUserViewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131362446, 11);
    }

    public EditUserViewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private EditUserViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (WeUIItem) objArr[7], (View) objArr[2], (View) objArr[4], (View) objArr[6], (TextView) objArr[11], (WeUIItem) objArr[1], (WeUIItem) objArr[5], (LinearLayout) objArr[8], (WeUIItem) objArr[3], (TextView) objArr[10], (TextView) objArr[9]);
        this.mDirtyFlags = -1;
        this.codeInputContainer.setTag(null);
        this.diverView1.setTag(null);
        this.diverView2.setTag(null);
        this.diverView3.setTag(null);
        this.headContainer.setTag(null);
        this.imgCodeContainer.setTag(null);
        this.infoViewContainer.setTag(null);
        this.mainInputContainer.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.otherInfo.setTag(null);
        this.tipView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (197 != i) {
            return false;
        }
        setModel((EditUserBaseViewModel) obj);
        return true;
    }

    @Override // com.coolapk.market.databinding.EditUserViewBinding
    public void setModel(EditUserBaseViewModel editUserBaseViewModel) {
        updateRegistration(0, editUserBaseViewModel);
        this.mModel = editUserBaseViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(197);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeModel((EditUserBaseViewModel) obj, i2);
    }

    private boolean onChangeModel(EditUserBaseViewModel editUserBaseViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        boolean z;
        boolean z2;
        String str3;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        EditUserBaseViewModel editUserBaseViewModel = this.mModel;
        String str4 = null;
        int i5 = 0;
        int i6 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (editUserBaseViewModel != null) {
                z4 = editUserBaseViewModel.hasImgCode();
                str4 = editUserBaseViewModel.getActionText();
                z3 = editUserBaseViewModel.hasCode();
                str3 = editUserBaseViewModel.getCodeType();
                z2 = editUserBaseViewModel.isEditPhoneNumber();
                str = editUserBaseViewModel.getEditType();
                z = editUserBaseViewModel.isEditEmail();
                z5 = editUserBaseViewModel.isEditUserName();
            } else {
                str3 = null;
                str = null;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            if (i6 != 0) {
                j |= z4 ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 2048 : 1024;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 128 : 64;
            }
            if ((j & 3) != 0) {
                j |= z5 ? 512 : 256;
            }
            i4 = z4 ? 0 : 8;
            int i7 = z3 ? 0 : 8;
            i = z2 ? 0 : 8;
            boolean z6 = !z;
            int i8 = z5 ? 0 : 8;
            if ((j & 3) != 0) {
                j |= z6 ? 32 : 16;
            }
            if (!z6) {
                i5 = 8;
            }
            i2 = i8;
            str2 = str4;
            str4 = str3;
            i5 = i7;
            i3 = i5;
        } else {
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & 3) != 0) {
            this.codeInputContainer.setEditType(str4);
            this.codeInputContainer.setVisibility(i5);
            this.diverView1.setVisibility(i);
            this.diverView2.setVisibility(i4);
            this.diverView3.setVisibility(i5);
            this.headContainer.setVisibility(i);
            this.headContainer.setActionText(str2);
            this.imgCodeContainer.setVisibility(i4);
            this.infoViewContainer.setVisibility(i3);
            this.mainInputContainer.setEditType(str);
            this.otherInfo.setVisibility(i3);
            this.tipView.setVisibility(i2);
        }
    }
}
