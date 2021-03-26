package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.model.ServiceApp;
import java.util.List;

public abstract class ItemPodiumCardBinding extends ViewDataBinding {
    public final ItemPodiumCardItemBinding championView;
    @Bindable
    protected List<ServiceApp> mApps;
    @Bindable
    protected List<String> mLogos;
    @Bindable
    protected List<String> mScores;
    @Bindable
    protected List<String> mTitles;
    public final ItemPodiumCardItemBinding secondPlaceView;
    public final ItemPodiumCardItemBinding thirdPlaceView;

    public abstract void setApps(List<ServiceApp> list);

    public abstract void setLogos(List<String> list);

    public abstract void setScores(List<String> list);

    public abstract void setTitles(List<String> list);

    protected ItemPodiumCardBinding(Object obj, View view, int i, ItemPodiumCardItemBinding itemPodiumCardItemBinding, ItemPodiumCardItemBinding itemPodiumCardItemBinding2, ItemPodiumCardItemBinding itemPodiumCardItemBinding3) {
        super(obj, view, i);
        this.championView = itemPodiumCardItemBinding;
        this.secondPlaceView = itemPodiumCardItemBinding2;
        this.thirdPlaceView = itemPodiumCardItemBinding3;
    }

    public List<ServiceApp> getApps() {
        return this.mApps;
    }

    public List<String> getLogos() {
        return this.mLogos;
    }

    public List<String> getTitles() {
        return this.mTitles;
    }

    public List<String> getScores() {
        return this.mScores;
    }

    public static ItemPodiumCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPodiumCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558859, viewGroup, z, obj);
    }

    public static ItemPodiumCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPodiumCardBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558859, null, false, obj);
    }

    public static ItemPodiumCardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPodiumCardBinding bind(View view, Object obj) {
        return (ItemPodiumCardBinding) bind(obj, view, 2131558859);
    }
}
