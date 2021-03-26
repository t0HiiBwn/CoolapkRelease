package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.Library;

public abstract class ItemLibraryShowBinding extends ViewDataBinding {
    public final TextView authorView;
    public final LinearLayout cardView;
    public final TextView descriptionView;
    @Bindable
    protected Library mModel;
    public final TextView titleView;

    public abstract void setModel(Library library);

    protected ItemLibraryShowBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.authorView = textView;
        this.cardView = linearLayout;
        this.descriptionView = textView2;
        this.titleView = textView3;
    }

    public Library getModel() {
        return this.mModel;
    }

    public static ItemLibraryShowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLibraryShowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLibraryShowBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558799, viewGroup, z, obj);
    }

    public static ItemLibraryShowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLibraryShowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLibraryShowBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558799, null, false, obj);
    }

    public static ItemLibraryShowBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLibraryShowBinding bind(View view, Object obj) {
        return (ItemLibraryShowBinding) bind(obj, view, 2131558799);
    }
}
