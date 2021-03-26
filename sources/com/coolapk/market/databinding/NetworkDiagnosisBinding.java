package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class NetworkDiagnosisBinding extends ViewDataBinding {
    public final Button copy;
    public final Button start;
    public final TextView text;

    protected NetworkDiagnosisBinding(Object obj, View view, int i, Button button, Button button2, TextView textView) {
        super(obj, view, i);
        this.copy = button;
        this.start = button2;
        this.text = textView;
    }

    public static NetworkDiagnosisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NetworkDiagnosisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NetworkDiagnosisBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559052, viewGroup, z, obj);
    }

    public static NetworkDiagnosisBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NetworkDiagnosisBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NetworkDiagnosisBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559052, null, false, obj);
    }

    public static NetworkDiagnosisBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static NetworkDiagnosisBinding bind(View view, Object obj) {
        return (NetworkDiagnosisBinding) bind(obj, view, 2131559052);
    }
}
