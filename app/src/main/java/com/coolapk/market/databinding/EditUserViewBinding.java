package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.view.user.edit.EditUserBaseViewModel;
import com.coolapk.market.widget.view.WeUIItem;

public abstract class EditUserViewBinding extends ViewDataBinding {
    public final WeUIItem codeInputContainer;
    public final View diverView1;
    public final View diverView2;
    public final View diverView3;
    public final TextView editUserSave;
    public final WeUIItem headContainer;
    public final WeUIItem imgCodeContainer;
    public final LinearLayout infoViewContainer;
    @Bindable
    protected EditUserBaseViewModel mModel;
    public final WeUIItem mainInputContainer;
    public final TextView otherInfo;
    public final TextView tipView;

    public abstract void setModel(EditUserBaseViewModel editUserBaseViewModel);

    protected EditUserViewBinding(Object obj, View view, int i, WeUIItem weUIItem, View view2, View view3, View view4, TextView textView, WeUIItem weUIItem2, WeUIItem weUIItem3, LinearLayout linearLayout, WeUIItem weUIItem4, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.codeInputContainer = weUIItem;
        this.diverView1 = view2;
        this.diverView2 = view3;
        this.diverView3 = view4;
        this.editUserSave = textView;
        this.headContainer = weUIItem2;
        this.imgCodeContainer = weUIItem3;
        this.infoViewContainer = linearLayout;
        this.mainInputContainer = weUIItem4;
        this.otherInfo = textView2;
        this.tipView = textView3;
    }

    public EditUserBaseViewModel getModel() {
        return this.mModel;
    }

    public static EditUserViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EditUserViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EditUserViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558545, viewGroup, z, obj);
    }

    public static EditUserViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EditUserViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EditUserViewBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558545, null, false, obj);
    }

    public static EditUserViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EditUserViewBinding bind(View view, Object obj) {
        return (EditUserViewBinding) bind(obj, view, 2131558545);
    }
}
